Title:     Web service developers
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

Taverna aims to support Web services that are 
   [WS-I](http://www.ws-i.org/Profiles/BasicProfile-1.1-2004-08-24.html) (Web Services Interoperability) compliant, 
   but this is a long-term goal and currently there are a few nuances. 
However, it should be possible to create Web services that are compatible with Taverna if you follow these guidelines.

##WSDL (Web Service Description Language) style Web services

[WSDL](/documentation/glossary#wsdl) binding describes how the Web service is bound to a messaging protocol, 
   particularly the SOAP messaging protocol. 
A WSDL SOAP binding can be either a **Remote Procedure Call (RPC)** style binding or a **document** style binding. 
A SOAP binding can also have an **encoded** use or a **literal** use. Combining these 
options would yield 4 binding styles, except the document/encoded combination
is not WS-I compliant and is [not used](https://www.ibm.com/developerworks/library/ws-whichwsdl/). 
However, there is an additional binding style commonly referred to as the 
document/literal wrapped style. 

Thus, developers have 4 binding styles to choose from when creating a WSDL file.

 1. RPC/encoded
 2. RPC/literal
 3. Document/literal
 4. Document/literal wrapped

IBM developerWorks has a good description of the [differences between these styles](https://www.ibm.com/developerworks/library/ws-whichwsdl/). 

Although Taverna supports to a fair extent bindings that are **RPC/encoded** or **RPC/literal**, 
   the preferred binding style is **document/literal wrapped**. 
   Specifically, the WSDL should have “style” attributes that are set to “document,” "use” attributes set to “literal,” 
   and the parameters should be inside a wrapper.
This is particularly important when dealing with complex types. For primitive types, no problems are anticipated.

###Currently untested features

The following are untested and, although not proven to fail, the behaviour is currently undefined. 
For this reason, it is advised to avoid these features.

 - **Multiple WSDL imports.** 
   Taverna has only been tested on services that contain *no more than one* import of an additional WSDL file. 
   For WSDLs that import more than one additional WSDL, particularly if that WSDL has a different service endpoint to the others,
     the behaviour of Taverna is currently unclear. 
   Its expected that it will fail when invoking the Web service.
   *This does not affect import of schemas, which has been thoroughly tested and works as expected.*

 - **Multiple service endpoints.** For a given WSDL, Taverna currently only references the first service endpoint. 
   If more than one exists, operations belonging to the second endpoint are expected to fail.

 - **Ambiguous type names.** 
   In the unusual case that an operation requires inputs that contain identically named types 
      belonging to different namespaces, it is expected that Taverna should not have any problems. 
   However, because of the unusual nature of this it is untested and therefore not recommended.

###Situations currently known to fail

The following are situations that are known to fail in Taverna.

 - **Cyclic references.** 
   When processing the result of an invoked operation, Taverna resolves the XML into a single document. 
   If the response contains cyclic references, this is detected and an error occurs. (This prevents an infinitely long document!) 
   *For this reason, cyclic references should be avoided.* 
   (Taverna will, however, 
      work with such an operation as long as the cyclic reference is not contained within the response data structure).

 - **Overloaded operations.** Within the UI, 
      Taverna only distinguishes by name between operations for a given service. 
   *The operation signature is not used to distinguish between operations of the same name.* 
   For this simple reason, Taverna does not support overloaded operations.

 - **anyType.** 
   Although Taverna can invoke a service that uses the anyType type, 
      the XML splitting mechanism cannot work since there is no information about the data structure required or received. 
   Such services can only be used by providing and/or manipulating the XML directly.
 
##Advertise your Life Sciences services with BioCatalogue

Registering with the [BioCatalogue](http://www.biocatalogue.org/) 
      Life Sciences Web Services registry is one of the best ways to raise awareness of your services
      and to make them easily discoverable from Taverna and the Web.

With BioCatalogue, service providers can easily register, describe, advertise and monitor their Web services. 
   Users can quickly find the right Web service using BioCatalogue's powerful search and filtering. 
BioCatalogue provides combined information about services from both providers and community 
   as it has on-going expert curation as well as social curation by the community.
