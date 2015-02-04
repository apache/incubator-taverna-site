Title:     Natural Language Processing
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

PANACEA addressing the most critical aspect for Machine Translation (MT).

<a name="panacea"></a>
##PANACEA##

[PANACEA][1] is a EU funded project whose objective is to build a factory of Language Resources that automates the
  stages involved in the acquisition, production, updating and maintenance of language resources required by 
  MT systems, and by other applications based on Language Technologies, and within the time required. 
The architecture of the factory platform is based on deploying NLP tools as Web Services (WS), 
   using the SOAP or REST standards (the aim is to be as interoperable as possible). 
PANACEA uses [Soaplab][2] as it provides a convenient way to generate WSs for command-line software 
   (most NLP tools belong to this type). 
Once the WSs are deployed users may want to combine them to create complex chains. 
[Taverna][3] workflow editor and engine is the tool used in the platform to combine WSs. 
This tool allows the user to create complex workflows with different kinds of WSs (SOAP, REST, secure WSs, etc.) 
   within a GUI.

The second version of the platform was presented during the second year project review which was held on 
   February 29, at UPF premises in Barcelona, Spain. 
It was headed by Kimmo Rossi, as EC Project Officer, and by Serge Sharoff (University of Leeds, U.K.) and 
   Gregory Grefenstette (Exalead, France), as project reviewers. 
The project development was positively evaluated and both the project Officer and the reviewers complimented 
   the achievements presented while being constructively detailed in their remarks. 
In special the review report stated that “The partners gave an impressive demonstration of the second versión 
   of the integrated platform”.

  [1]: http://www.panacea-lr.eu/
  [2]: http://soaplab.sourceforge.net/soaplab2/
  [3]: http://www.taverna.org.uk