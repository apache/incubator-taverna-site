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
(ns scufl2-info.handler
  (:use compojure.core)
  (:require 
            [com.gfredericks.catch-data :refer [try+]]
            [scufl2-info.workflow-bundle :as wfbundle]
            [scufl2-info.run :as run]
            [scufl2-info.jsonld :as jsonld]
            [scufl2-info.data :as data]
            [compojure.handler :as handler]
            [ring.middleware.json :as json]
            [ring.util.codec :as codec]
            [ring.util.response :as response]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "
              <h1>scufl2-info</h1>
              This is the <a href='https://github.com/stain/scufl2-info'>scufl2-info</a> web service.
              <p>
              This service generates <a href='http://json-ld.org/'>JSON-LD</a> Linked Data descriptions for 
              <a href='http://dev.mygrid.org.uk/wiki/display/developer/SCUFL2'>SCUFL2</a> resources,
              following the same URI syntax as below the base
              <code>http://ns.taverna.org.uk/2010/workflowBundle/</code>
              <p>
              Examples:
              <ul>
                <li> <a href='workflowBundle/2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/'>workflow bundle</a>
                  <ul>
                    <li> <a href='workflowBundle/2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/'>workflow</a></li>
                    <li> <a href='workflowBundle/2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/in/input1'>workflow input port</a></li>
                    <li> <a href='workflowBundle/2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/processor/hello/'>processor</a></li>
                    <li> <a href='workflowBundle/2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/processor/hello/out/output1'>processor output port</a></li>
                    <li> <a href='workflowBundle/2f0e94ef-b5c4-455d-aeab-1e9611f46b8b/workflow/HelloWorld/datalink?from=processor/hello/out/output1&to=out/result'>datalink</a></li>
              </ul></li>

                <li> <a href='run/d5ee659e-e11e-43a5-bc0a-58d93674e5e2/'>workflow run</a>
                <ul>
                  <li> <a href='run/d5ee659e-e11e-43a5-bc0a-58d93674e5e2/process/1e027057-2aeb-47f7-97dc-03e19e9772be/'>process run</a></li>
                </ul></li>

                <li> <a href='data/d5ee659e-e11e-43a5-bc0a-58d93674e5e2/ref/a060702f-7962-4773-9be3-99c026dd5da5/'>data artifact</a></li>
                <li> <a href='data/d5ee659e-e11e-43a5-bc0a-58d93674e5e2/list/c2f58d3e-8686-40a5-b1cd-b797cd18fbb7/false/1'>list (depth 1)</a></li>
                <li> <a href='data/d5ee659e-e11e-43a5-bc0a-58d93674e5e2/list/2cdc8e4c-ebcf-4662-83db-85a2fd496ca7/true/2'>list (depth 2, w/errors)</a></li>
                <li> <a href='data/d5ee659e-e11e-43a5-bc0a-58d93674e5e2/error/49785ed7-eda9-4d53-b74f-6c6a7a4940a5/0'>error (depth 0)</a></li>

              </ul>
              <p>
              Questions? Contact support@mygrid.org.uk
              ")
  (GET "/workflowBundle" [] (response/redirect "/workflowBundle/"))
  (GET "/data" [] (response/redirect "/data/"))
  (GET "/run" [] (response/redirect "/run/"))
  wfbundle/wfbundle-context
  data/data-context 
  run/run-context 
  (route/resources "/")
  (route/not-found "Not Found"))

(defn ex-info-status
  "Ring Middleware that catches exceptions which minimally contain the (ex-data) key :status.

  The exception message will be used as body, unless the ex-data contains a :body key.
  Additional Ring response keys can be used to customize headers, etc.

  Example:
     (throw (ex-info \"Resource was deleted.\" { :status 410 }))

  Redirection:
     (throw (ex-info nil (ring.util.response/redirect \"http://example.com/\")))

  Usage with ring: 
    (def app
      (-> 
        (handler/site app-routes)
        (ex-info-status)))
  "

  [handler]
  (fn [request]
    (try+ (handler request)
      (catch-data :status {:as data, :ex e}
                  (merge 
                    { :body (.getMessage e) }
                    data)))))

(defn convert-jsonld
  [handler]
  (fn [request]
    (let [{status :status
           body :body
           :as response} (handler request)]
      (if (and (= 201 status) (coll? body))
        (assoc response :body (jsonld/jsonld-to-rdf body :turtle))
        response))))


(def app
  (-> 
    (handler/site app-routes)
    (ex-info-status)
    (convert-jsonld)
    (json/wrap-json-response {:pretty true})
    ))
