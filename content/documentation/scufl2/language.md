Title:     SCUFL2 language
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

The SCUFL2 language is the abstract set of constructs that define a Taverna workflow.

This has been formalized in an [OWL ontology](/documentation/scufl2/ontology),
  which is used by the `scufl2-rdfxml` module of the [SCUFL2 API](/documentation/scufl2/api)
  to serialise the [Taverna workflow bundle](/documentation/scufl2/taverna_bundle).

At the core of this is a [workflow bundle](/documentation/scufl2/bundle),
  which combines a set of [workflows](/documentation/scufl2/workflow) and
  [profiles](/documentation/scufl2/profile).

You can browse a serialisation of using the SCUFL2 ontology within a
Taverna workflow bundle in [this example](https://github.com/apache/incubator-taverna-language/tree/master/taverna-scufl2-wfbundle/src/test/resources/org/apache/taverna/scufl2/rdfxml/example).
