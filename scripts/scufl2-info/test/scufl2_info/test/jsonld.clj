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
(ns scufl2-info.test.jsonld
  (:import com.github.jsonldjava.jena.JenaJSONLD)
  (:use clojure.test
        scufl2-info.jsonld))

(deftest test-content-types-of-lang
    (is (= "application/ld+json" (first (content-types-of-lang JenaJSONLD/JSONLD)))))

(deftest test-rdf-content-types
  (testing "contains turtle"
    (is (contains? rdf-content-types "text/turtle"))
    (is (contains? rdf-content-types "application/turtle")))
  (testing "contains trig"
    (is (contains? rdf-content-types "application/trig")))
    (is (contains? rdf-content-types "text/trig"))
  (testing "contains jsonld"
    (is (contains? rdf-content-types "application/ld+json"))))


(defn verify-turtle [turtle]
  ;(print turtle)
      (is (. turtle contains "<http://example.com/a>"))
  ;; Not true for ntriples
      ;(is (. turtle contains " a "))
      (is (. turtle contains "<http://example.org/b>"))
      (is (. turtle contains "<http://example.net/c>"))
      (is (. turtle contains "\"d\"")))

(defn verify-rdfxml [rdfxml]
      (is (. rdfxml contains "\"http://example.com/a\""))
      (is (. rdfxml contains "rdf:about"))
      (is (. rdfxml contains "http://example.org/"))
      (is (. rdfxml contains "http://example.net/"))
      (is (. rdfxml contains ">d<")))

(def jsonld { "@id"   "http://example.com/a"
              "@type" "http://example.org/b" 
              "http://example.net/c" "d" })


(deftest test-jsonld-to-rdf
  (testing "jsonld to turtle"
    (verify-turtle (jsonld-to-rdf jsonld :turtle)))
  (testing "jsonld to ntriples"
    (verify-turtle (jsonld-to-rdf jsonld :ntriples)))
  (testing "jsonld to rdfxml"
    (verify-rdfxml (jsonld-to-rdf jsonld :rdfxml)))
  (testing "jsonld-to-every-content-type"
    (map (partial jsonld-to-rdf jsonld) rdf-content-types)))

