Title:     Services in Taverna
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

Taverna can access a large number of services in the fields of bioinformatics, astronomy, chemoinformatics, 
   health informatics and others. Although many examples of using Taverna lie in the bioinformatics domain, 
   Taverna is actually domain independent. 
This means that Taverna can be applied to a wide range of fields – even music and food sciences.

Taverna can invoke generic [WSDL-style Web services][1]. 
You do not need to alter a service in any way; 
you simply need to give Taverna the URL address of the service’s WSDL document. 
Please refer to our [Web service developers’ documentation][2] if you are planning on developing Web services 
   accessible from Taverna.

Taverna can also access other types of Web services, such as [BioMoby][3], [BioMart][4] and [SoapLab][5] 
   services.

In addition, Taverna can invoke local Java services ([Beanshell][6] scripts), local Java API ([API Consumer][7]), 
   R scripts on an R server ([Rshell][8] scripts), import data from a [cvs or Excel spreadsheet][9] and interact 
   with users in a browser.

Taverna can also [interact][10] with a running workflow from your Web browser, 
   and has the ability to incorporate workflow fragments (reusable [components][11]) as services in a workflow.

A full list of service types is in the [User Manual][12].

Please see the [BioCatalogue][13] for details of the services we are currently aware of that work with Taverna. 
If you would like to add your services to this list, please contact [the BioCatalogue team][14].

##Domain and shim services##

Services accessible from Taverna can be broadly categorised into domain services and shim services.

 -  Domain (scientific) services perform scientific function(s) and are often provided by third-party suppliers.
       They cannot usually be changed by individual users.
 -  Shim services are created during workflow design, 
       to specifically connect the inputs and outputs of closely related services in order to achieve 
       interoperation between domain services. 
    This typically involves changing one service’s output into a different format for another service to accept. An example might include changing the output from tab to comma separated values. Taverna comes with a library of frequently used shim services. A new workflow, however, often brings about the need to develop a new shim or modify an existing one.

A rule of thumb for distinguishing a domain service from a shim service is that a workflow, 
    when the shims services are invisible, is equivalent to the methods section of a scientific paper. 
If a service needs to be explicitly mentioned in the method, then it is not a shim.

##Service providers##

Nearly all services accessible by Taverna are neither owned nor provided by us. 
The majority of services are provided by third-party institutes and research facilities, 
   all of which can be accessed from within Taverna. 
Taverna only provides most commonly used shim services, e.g. to concatenate strings, read content from a file, 
   etc.

Service suppliers can often be large government-funded bodies such as the [NCBI][15] (United States), 
   [EMBL-EBI][16] (Europe) or [DNA Databank of Japan][17]. 
Each is responsible in providing data to the global scientific community. 
These major providers generally have dedicated human resources for service development, API documentation, 
   hosting and maintenance. 
In addition to programmatic access to their services these also maintain Web-form based access.

A large proportion of suppliers of services and workflows are much smaller in scale – 
   this includes individuals or small laboratories that have developed a tool, algorithm, database, 
   or workflow that they wish to share with others. 
Developers of services from these small establishments may have limited knowledge on Web services and 
   related standards when compared to their knowledge of programming/scripting. 
Such circumstances have required myGrid to develop tools like [Soaplab][18] that help alleviate this limitation 
   of small-scale providers by allowing simple deployment of the tool at hand.

All these service providers are independent of, and usually ignorant of, their consumers. 
Thus, the suppliers and consumers in the open market are loosely coupled and asynchronous. 
Other services are private and local to the scientist (workflow designer), 
   or developed specifically for a workflow to make it work.
Creating a service accessible from Taverna

If you are planning on creating a service that should be accessible from Taverna, 
   please have a look at the documentation for Web service developers[link text][19].


  [1]: /documentation/glossary#wsdl
  [2]: /documentation/web-service-developers
  [3]: /documentation/glossary#biomoby
  [4]: /documentation/glossary#biomart
  [5]: /documentation/glossary#soaplab
  [6]: /documentation/glossary#beanshell
  [7]: /documentation/glossary#api_consumer
  [8]: /documentation/glossary#rshell
  [9]: /documentation/glossary#spreadsheet_import
  [10]: http://dev.mygrid.org.uk/wiki/display/taverna/Interaction+service
  [11]: http://dev.mygrid.org.uk/wiki/display/taverna/Component+services
  [12]: http://dev.mygrid.org.uk/wiki/display/taverna/Service+types
  [13]: http://biocatalogue.org/
  [14]: http://www.biocatalogue.org/contact
  [15]: http://www.ncbi.nlm.nih.gov/
  [16]: http://www.ebi.ac.uk/
  [17]: http://www.ddbj.nig.ac.jp/
  [18]: http://www.ebi.ac.uk/soaplab/
  [19]: /documentation/web-service-developers