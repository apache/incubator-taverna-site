;   Licensed to the Apache Software Foundation (ASF) under one or more
;   contributor license agreements.  See the NOTICE file distributed with
;   this work for additional information regarding copyright ownership.
;   The ASF licenses this file to You under the Apache License, Version 2.0
;   (the "License"); you may not use this file except in compliance with
;   the License.  You may obtain a copy of the License at
;
;       http://www.apache.org/licenses/LICENSE-2.0
;
;   Unless required by applicable law or agreed to in writing, software
;   distributed under the License is distributed on an "AS IS" BASIS,
;   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;   See the License for the specific language governing permissions and
;   limitations under the License.
;
(ns scufl2-info.data
  (:use compojure.core)
  (:use scufl2-info.util)
  (:require
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [ring.util.response :as response]
            [ring.util.codec :as codec]
            [compojure.route :as route]
            ))


(defn data-uri [data]
  (str "http://ns.taverna.org.uk/2011/data/" (ensure-uuid data) "/"))

(defn run-uri [uuid]
  (str "http://ns.taverna.org.uk/2011/run/" (ensure-uuid uuid) "/"))

(defn ref-uri [data reference]
  (str (data-uri data) "ref/" (ensure-uuid reference) "/"))

(defn error-uri [data error depth]
  (str (data-uri data) "error/" (ensure-uuid error) "/" (ensure-int depth)))

(defn list-uri [data listref has-errors depth]
  (str (data-uri data) "list/" (ensure-uuid listref) "/" (ensure-bool has-errors) "/" (ensure-int depth)))

(defn jsonld-context []
  { "@context" {
                "@vocab" "http://purl.org/wf4ever/wfprov#"
                "tavernaprov" "http://ns.taverna.org.uk/2012/tavernaprov/"
                "prov" "http://www.w3.org/ns/prov#"
                ; TODO: define new subproperty in tavernaprov
                "involvedInRun" { "@id" "tavernaprov:involvedInRun"
                                  "@type" "@id" }
                "depth" "tavernaprov:depth"
                "scufl2" "http://ns.taverna.org.uk/2010/scufl2#"
                }})

(defn ref-json [data reference]
   {
    "@id" (ref-uri data reference) 
    "@type" [:Artifact "prov:Entity"]
    "involvedInRun" (run-uri data)
   })

(defn error-json [data error depth]
   {
    "@id" (error-uri data error depth) 
    "@type" ["tavernaprov:Error" :Artifact "prov:Entity"]
    "depth" (ensure-int depth)
    "involvedInRun" (run-uri data)
   })

(defn list-json [data listref has-errors depth]
   {
    "@id" (list-uri data listref has-errors depth) 
    "@type" (let [types ["prov:Collection" :Artifact "prov:Entity"]]
              (if (ensure-bool has-errors) (conj types "tavernaprov:ContainsError" has-errors) types))
    "depth" (ensure-int depth)
    "involvedInRun" (run-uri data)
   })


(defn ref-json-resource [data reference]  
    {:body    
      (merge 
          (ref-json data reference)
          (jsonld-context)
        )})

(defn error-json-resource [data error depth]
  {:body    
    (merge 
        (error-json data error depth)
        (jsonld-context) 
      )})

(defn list-json-resource [data listref has-errors depth]
  {:body    
    (merge 
        (list-json data listref has-errors depth)
        (jsonld-context) 
      )})


(def data-context (context "/data" []
  (GET "/" [] "
              <h1>scufl2-info data</h1>
              This is the <a href='https://github.com/stain/scufl2-info'>scufl2-info</a> web service.
              <p>
              This service generates <a href='http://json-ld.org/'>JSON-LD</a> Linked Data descriptions for 
              <a href='http://www.taverna.org.uk/'>Taverna workflow data</a> resources
              as found in the provenance data bundles exported from Taverna.
              </p>
              <p>This service reflects URIs under the namespace
              <code>http://ns.taverna.org.uk/2011/data/</code>
              <p>
              Examples:
              <ul>
                <li> <a href='d5ee659e-e11e-43a5-bc0a-58d93674e5e2/ref/a060702f-7962-4773-9be3-99c026dd5da5/'>data artifact</a></li>
                <li> <a href='d5ee659e-e11e-43a5-bc0a-58d93674e5e2/list/c2f58d3e-8686-40a5-b1cd-b797cd18fbb7/false/1'>list (depth 1)</a></li>
                <li> <a href='d5ee659e-e11e-43a5-bc0a-58d93674e5e2/list/2cdc8e4c-ebcf-4662-83db-85a2fd496ca7/true/2'>list (depth 2, w/errors)</a></li>
                <li> <a href='d5ee659e-e11e-43a5-bc0a-58d93674e5e2/error/49785ed7-eda9-4d53-b74f-6c6a7a4940a5/0'>error (depth 0)</a></li>
              </ul>
              <p>
              Questions? Contact support@mygrid.org.uk
              ")
  (context "/:data" [data] 
    (GET "/" 
        [uuid] (response/redirect (run-uri data)))
    (GET "/ref/:reference/" 
        [reference] (ref-json-resource data reference))
    (GET "/list/:listref/:has-errors/:depth" 
        [listref has-errors depth] (list-json-resource data listref has-errors depth))
    (GET "/error/:error/:depth" 
        [error depth] (error-json-resource data error depth))
           
           )))

