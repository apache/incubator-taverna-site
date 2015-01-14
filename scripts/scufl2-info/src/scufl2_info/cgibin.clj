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
(ns scufl2-info.cgibin
  (:gen-class)
  (:import [java.util Locale]
           [java.net URI])
  (:require
    [ring.mock.request :as mock]
    [scufl2-info.handler :as handler]
    ))

(defn convert-cgi-header [header]
  (.. header
    (replaceFirst "HTTP_" "")
    (replace "_" "-")
    (toLowerCase Locale/US)
  ))

(defn select-http-headers [header]
  (.startsWith header "HTTP_"))

(defn convert-headers []
  (let [http-keys (filter select-http-headers (keys (System/getenv)))]
    (zipmap
      (map convert-cgi-header http-keys)
      (vals (select-keys (System/getenv) http-keys)))))

(defn print-header [[k,v]]
  (println (str k ": " v)))

(defn -main [& args]

  (let [
        uri (or (System/getenv "PATH_INFO") "/")
        request-method (or (System/getenv "REQUEST_METHOD") "GET")
        auth-type (System/getenv "AUTH_TYPE")
        content-length (System/getenv "CONTENT_LENGTH")
        content-type (System/getenv "CONTENT_TYPE")
        server-port (or (System/getenv "SERVER_PORT") "80")
        server-name (or (System/getenv "SERVER_NAME") "localhost")
        scheme (or (System/getenv "SERVER_PROTOCOL") "http")
        remote-addr (or (System/getenv "REMOTE_ADDR") "127.0.0.1")
        remote-host (or (System/getenv "REMOTE_HOST") "localhost")
        remote-ident (System/getenv "REMOTE_IDENT")
        remote-user (System/getenv "REMOTE_USER")
        query-string (System/getenv "QUERY_STRING")
        ; see http://www.ietf.org/rfc/rfc3875
        request { :request-method (keyword (.toLowerCase request-method))
                  :uri (.getRawPath (URI. uri))
                  :server-port (Integer/parseInt server-port)
                  :server-name server-name
                  :scheme scheme
                  :remote-addr remote-addr
                  :remote-host remote-host
                  :remote-ident remote-ident
                  :remote-user remote-user
                  :query-string query-string
                  :content-length (and content-length (Long/parseLong content-length))
                  :content-type content-type
                  :auth-type auth-type
                  :headers (convert-headers) }
        ; TODO read in content-length submitted bytes and store in :body
        response (handler/app request)]

  ; FIXME: This is a potential security breach
  (if (and query-string (.contains query-string "_cgi=debug"))
    (do
      (println "Content-Type: text/plain")
      (println "")
      (println "Debug from cgibin.clj")
      (println)
      (println "env") (doall (map println (System/getenv)))
      (println "request") (println request))
    (do
      (println "Status:" (:status response))
      (doall (map print-header (:headers response)))
      (println "")
      ; Should probably do (print) instead of (println) in case :body is a binary - but we know it's all HTML and JSON)
      (println (or (:body response) ""))))))
