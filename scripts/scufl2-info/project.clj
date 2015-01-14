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
(defproject scufl2-info "0.5.1-SNAPSHOT"
  :description "SCUFL2 information service"
  :url "https://github.com/stain/scufl2-info"
  :dependencies [
                 [org.clojure/clojure "1.5.1"]
                 [com.github.jsonld-java/jsonld-java-jena "0.3"]
                 [ring-middleware-format "0.3.2"]
                 [ring/ring-json "0.3.1"]
                 [com.gfredericks/catch-data "0.1.3"]
                 [ring/ring-mock "0.2.0"]
                 [compojure "1.1.6"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler scufl2-info.handler/app}
  :main scufl2-info.cgibin
  :profiles
    {:uberjar {:aot :all
               :main scufl2-info.cgibin }
     :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                          ]}})
