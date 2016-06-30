Title:     Scufl2 Ontology
Notice:    Licensed to the Apache Software Foundation (ASF) under one
           or more contributor license agreements.  See the NOTICE file
           distributed with this work for additional information
           regarding copyright ownership.  The ASF licenses this file
           to you under the Apache License, Version 2.0 (the
           "License"); you may not use this file except in compliance
           with the License.  You may obtain a copy of the License at
           .
             http://www.apache.org/licenses/LICENSE-2.0
           .
           Unless required by applicable law or agreed to in writing,
           software distributed under the License is distributed on an
           "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
           KIND, either express or implied.  See the License for the
           specific language governing permissions and limitations
           under the License.

The [SCUFL2](.) ontology defines the terms used to describe a Taverna workflow
within a [workflow bundle](workflow).

* Namespace: `http://ns.taverna.org.uk/2010/scufl2#`
* Formats: [Turtle](https://taverna.incubator.apache.org/ns/2010/scufl2/scufl2.ttl), [RDF/XML](https://taverna.incubator.apache.org/ns/2010/scufl2/scufl2.rdf)
* [Ontology documentation](http://www.essepuntato.it/lode/http://ns.taverna.org.uk/2010/scufl2)
* [Ontology source](https://github.com/apache/incubator-taverna-language/tree/master/taverna-scufl2-schemas/src/main/resources/org/apache/taverna/scufl2/rdf)
* [Example usage](https://github.com/apache/incubator-taverna-language/tree/master/taverna-scufl2-wfbundle/src/test/resources/org/apache/taverna/scufl2/rdfxml/example)

The myGrid wiki has archived some [further documentation on SCUFL2](http://dev.mygrid.org.uk/wiki/display/developer/Scufl2+Ontology), but
be aware that it is _outdated_, as its examples uses an _n3_ serialization rather than
the current _RDF/XML_ serialization.

## Extensions

Taverna 2.2 features are in the namespace `http://ns.taverna.org.uk/2010/taverna/2.2/`

[Activities](/download/common-activities/) define their own namespaces for
their SCUFL2 type and configuration properties.
