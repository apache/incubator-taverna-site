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
(ns scufl2-info.workflow-bundle
  (:use compojure.core)
  (:use scufl2-info.util)
  (:require
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [ring.util.response :as response]
            [ring.util.codec :as codec]
            [compojure.route :as route]
            ))

(defn wfbundle-uri [uuid]
  (str "http://ns.taverna.org.uk/2010/workflowBundle/" (ensure-uuid uuid) "/"))

(defn workflow-uri [uuid workflow]
  ; Relative URI from wfbundle, as we set @base
  (str "workflow/" (codec/url-encode workflow) "/"))

(defn processor-uri [uuid workflow processor]
  (str (workflow-uri uuid workflow) "processor/" (codec/url-encode processor) "/"))

(defn processor-port-uri [uuid workflow processor inOrOut port]
  (str (processor-uri uuid workflow processor) (name inOrOut) "/" (codec/url-encode port)))

(defn workflow-port-uri [uuid workflow inOrOut port]
  (str (workflow-uri uuid workflow) (name inOrOut) "/" (codec/url-encode port)))

(defn iterationstrategy-uri [uuid workflow processor]
  (str (processor-uri uuid workflow processor) "iterationstrategy/"))

(defn datalink-uri [uuid workflow from to]
  (str (workflow-uri uuid workflow) "datalink?from=" from "&to=" to))

(defn wfbundle-json [uuid]
  { "@context" {
                "@base" (wfbundle-uri uuid)
;                "rdfs" "http://www.w3.org/2000/01/rdf-schema#"
;                "seeAlso" "rdfs:seeAlso"
                "@vocab" "http://ns.taverna.org.uk/2010/scufl2#"
                }
    ; Absolute URI here, because some people would be confused by "" or "."
    "@id" (wfbundle-uri uuid) 
    "@type" :WorkflowBundle})

(defn workflow-json [uuid workflow]
  (assoc (wfbundle-json uuid)
         :workflow { 
                    "@id" (workflow-uri uuid workflow)
                    "@type" :Workflow
                    :name workflow}))

(defn processor-json [uuid workflow processor]
  (assoc-in (workflow-json uuid workflow)
            [:workflow :processor]
            { "@id" (processor-uri uuid workflow processor)
              "@type" :Processor
              :name processor }))

(defn processor-port-json [uuid workflow processor inOrOut port]
  (assoc-in (processor-json uuid workflow processor)
            [:workflow :processor (case inOrOut 
                :in :inputProcessorPort
                :out :outputProcessorPort)]
            { "@id" (processor-port-uri uuid workflow processor inOrOut port)
              "@type" (case inOrOut 
                        :in :InputProcessorPort
                        :out :OutputProcessorPort)
              "name" port}))

(defn workflow-port-json [uuid workflow inOrOut port]
  (assoc-in (workflow-json uuid workflow)
            [:workflow (case inOrOut 
                :in :inputWorkflowPort
                :out :outputWorkflowPort)]
            { "@id" (workflow-port-uri uuid workflow inOrOut port)
              "@type" (case inOrOut 
                        :in :InputWorkflowPort
                        :out :OutputWorkflowPort)
              "name" port}))

(defn iteration-stack-json [uuid workflow processor]
  (assoc-in (processor-json uuid workflow processor)
            [:workflow :processor :iterationStrategyStack]
            { "@id" (iterationstrategy-uri uuid workflow processor)
              "@type" :IterationStrategyStack }))

(defn datalink-json [uuid workflow from to]
  (assoc-in (workflow-json uuid workflow)
            [:workflow :datalink]
            { "@id" (datalink-uri uuid workflow from to)
              "@type" :DataLink
             ; TODO: support merge
              :receiveFrom { "@id" (str (workflow-uri uuid workflow) from)
                             "@type" (if (.startsWith from "in/") :InputWorkflowPort :OutputProcessorPort)
                            }
              :sendTo { "@id" (str (workflow-uri uuid workflow) to) 
                             "@type" (if (.startsWith to "out/") :OutputWorkflowPort :InputProcessorPort)
                       } 
             ; TODO: Should we also expand from and to here to show ports and
             ; processors, or expect the client to simply follow the links?
             }))

(def wfbundle-context (context "/workflowBundle" []
  (GET "/" [] "
              <h1>scufl2-info wfbundles</h1>
              This is the <a href='https://github.com/stain/scufl2-info'>scufl2-info</a> web service.
              <p>
              This service generates <a href='http://json-ld.org/'>JSON-LD</a> Linked Data descriptions for 
              <a href='http://dev.mygrid.org.uk/wiki/display/developer/SCUFL2'>SCUFL2</a> <code>workflowBundle/</code>resources,
              following the same URI syntax as below the base
              <code>http://ns.taverna.org.uk/2010/workflowBundle/</code>
              <p>
              Examples:
              <ul>
                <li> <a href='2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/'>workflow bundle</a></li>
                <li> <a href='2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/'>workflow</a></li>
                <li> <a href='2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/in/input1'>workflow input port</a></li>
                <li> <a href='2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/processor/hello/'>processor</a></li>
                <li> <a href='2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/processor/hello/out/output1'>processor output port</a></li>
                <li> <a href='2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/datalink?from=processor/hello/out/output1&to=out/result'>datalink</a></li>
              </ul>
              <p>
              Questions? Contact support@mygrid.org.uk
              ")
  (context "/:uuid" [uuid] 
    (GET "/" 
        [uuid] {:body (wfbundle-json uuid) } )
    (GET "/workflow/:workflow/" 
        [workflow] {:body (workflow-json uuid workflow)}) 
    (GET "/workflow/:workflow/in/:port" 
        [workflow processor port] {:body (workflow-port-json uuid workflow :in port)})
    (GET "/workflow/:workflow/out/:port" 
        [workflow processor port] {:body (workflow-port-json uuid workflow :out port)})
    (GET "/workflow/:workflow/processor/:processor/" 
        [workflow processor] {:body (processor-json uuid workflow processor)})
    (GET "/workflow/:workflow/processor/:processor/in/:port" 
        [workflow processor port] {:body (processor-port-json uuid workflow processor :in port)})
    (GET "/workflow/:workflow/processor/:processor/out/:port" 
        [workflow processor port] {:body (processor-port-json uuid workflow processor :out port)})
    (GET "/workflow/:workflow/processor/:processor/iterationstrategy/" 
        [workflow processor] {:body (iteration-stack-json uuid workflow processor)})
    (GET "/workflow/:workflow/datalink"
        [workflow from to] 
        (if (or (nil? from) (nil? to))
          {:status 404
           :body "Not Found.\ndatalink requires query parameters 'from' and 'to'" } 
          {:body (datalink-json uuid workflow from to)})))))

