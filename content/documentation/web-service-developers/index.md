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
   [WS-I](http://www.ws-i.org/Profiles/BasicProfile-1.1-2004-08-24.html) (Web Services Interoparability) compliant, 
   but this is a long-term goal and currently there are a few nuances. 
However, it should be possible to create Web services that are compatible with Taverna if you follow certain guidelines.

##WSDL (Web Service Description Language) style Web services

[WSDL](/documentation/glossary#wsdl) binding describes how the Web service is bound to a messaging protocol; 
   particularly the SOAP messaging protocol. 
A WSDL SOAP binding can be either a **Remote Procedure Call (RPC)** style binding or a **document** style binding. 
A SOAP binding can also have an **encoded** use or a **literal** use. 
This gives you four style/use models:

 1. RPC/encoded
 2. RPC/literal
 3. Document/encoded
 4. Document/literal

There is also a fifth binding style that is commonly referred to as the document/literal wrapped. 
Thus, developers have five binding styles to choose from when creating a WSDL file.

A good description of the differences between these styles can be found 
   [here](http://www-128.ibm.com/developerworks/webservices/library/ws-whichwsdl/).

Although Taverna supports bindings that are **RPC/encoded** and **RPC/literal** to a fair extent, 
   the preferred binding style is **document/literal wrapped**, 
   i.e. the WSDL should have “style” attributes that are set to “document” and “use” attributes set to “literal”. 
This is particularly the case when dealing with complex types; for primitive types no problems are anticipated.

###Currently un-tested

The following are untested, and although not proven to fail the behaviour is currently undefined. 
For this reason it is advised that these features are avoided.

 - Multiple WSDL imports. 
   Taverna has only been tested on services that contain either no, or only one import of an additional wsdl file. 
   For WSDLs that import more than one additional WSDL, particularly if that WSDL has a different service endpoint to the others,
     the behaviour of Taverna is currently unclear. 
   Its expected that it will fail when invoking the Web service.
   This does not affect imports of schemas. 
   This has been thoroughly tested and works as expected.
 - Multiple service endpoints. For a given WSDL Taverna currently only references the first service endpoint. 
   If more than one exists then operations belonging to the second endpoint are expected to fail.
 - Ambiguous type names. 
   In the unusual case that an operation requires inputs that contain identically named types 
      that belong to different namespaces it is expected that Taverna should not have any problems. 
   However, because of the unusual nature of this it is untested and therefore not recommended.

###Currently known to fail

The following are situations that are known to fail in Taverna.

 - Cyclic references. 
   When processing the result of invoking an operation, Taverna resolves the XML into a single document. 
   If the response contains cyclic references, this is detected and an error occurs (to prevent an infinitely long document!). 
   For this reason cyclic references should be avoided. 
   (Taverna will, however, 
      work with such an operation as long as the cyclic reference is not contained within the response data structure).
 - Overloaded operations. Within the UI, 
      Taverna only distinguishes between operations, for a given service, by name. 
   The operation signature is not used to distinguish between operations of the same name. 
   For this simple reason, Taverna does not support overloaded operations.
 - anyType. 
   Although Taverna can invoke a service that deals with the anyType type, 
      the XML splitting mechanism cannot work since there is no information about the data structure required or received. 
   Such services can only be used by providing and/or manipulating the XML directly.
 
##Advertise your services with BioCatalogue

If your services are in the Life Sciences domain, 
   one of the best ways to make people aware of your services and make them easily discoverable from Taverna and 
      the Web is to register and describe them in [BioCatalogue](http://www.biocatalogue.org/) 
      Life Sciences Web Services registry.</p>

With BioCatalogue, service providers can easily register, describe, advertise and monitor their Web services. 
   Users can easily find the right Web service using BioCatalogue's powerful search and filtering. 
BioCatalogue provides combined information about services from both providers and community 
   as it has on-going expert curation as well as social curation by the community.
