Title:     Medicine
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

Taverna is used by various projects and researchers in medicine:

 - [Know-how Sharing Technology Based on ARC Services and Open Standards](#knowarc) (KnowARC) - 
      rapid iteration and large datasets on a grid for for medical imaging
 - [Medical Imaging and Signals Grid](#miasgrid) (MIASGrid) - 
      workflows for MRI and mammogram analysis
 - [caGrid](/introduction/related-projects#cagrid) - cancer research
 - [EU-ADR](#eu-adr) - detecting adverse drug reactions through the exploitation of clinical data from 
      electronic healthcare records

<a name="knowarc"></a>
##KnowARC

The Grid-enabled Know-how Sharing Technology Based on ARC Services and Open Standards (KnowARC) 
   [project](http://www.knowarc.eu/) is:  

> a Sixth Framework Programme Specific Targeted Research Project, under
> Priority IST-2005-2.5.4 “Advanced Grid Technologies, Systems and
> Services”. The operative comencement date of the project is June 1,
> 2006, and the planned duration is 3 years.
> 
> The objectives of the project are:
> 
>  - to create a novel, powerful Next Generation Grid middleware based on NorduGrid’s 
>     [ARC](http://www.nordugrid.org/), widely respected for its simplicity,
>     non-invasiveness and cost-efficiency;
>  - to promote Grid standardization and interoperability;
>  - to contribute to Grid technologies take-up, bridging the gaps between business and academia in Grid development

The KnowARC team have adopted Taverna to specify their workflows.  
They have also developed the [ARC plugin](/documentation/plugins#usecase_plugin) for Taverna.

The functionality of the ARC plugin has been [demonstrated](http://www.knowarc.eu/demos/) 
   in the domain of medical imaging.

<a name="miasgrid"></a>
##MIASGrid
                    
The MIAS project examined the requirements of Medical Imaging and Signals.  
The [MIASGrid]http://www.robots.ox.ac.uk/~irc/grid_mias-grid.html) sub-project, 
   took examples of those requirements and investigated how e-Science and the myGrid tools in particular could satisfy them. 
The project was funded by the [EPSRC](http://www.epsrc.ac.uk/) for £494k and ran until April 2006.

The project produced several workflows that demonstrated the applicability of Taverna to the handling 
   of large amounts of medical image data. 
The workflows made use of [MATLAB](http://www.mathworks.com/products/matlab/) and also interaction with users.

The workflows covered two domains:

 - The analysis of MRI scans of knees to detect changes in cartilage
 - The [description and searching](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.111.3846&rep=rep1&type=pdf) 
     of a database of mammograms

<a name="eu-adr"></a>
##EU-ADR

The [EU-ADR](http://euadr-project.org/) project aims to develop an innovative computerised system to 
  detect adverse drug reactions (ADRs) through the exploitation of clinical data from electronic healthcare records (EHRs). 
This process will rely on the usage and development of various computational techniques to analyse the EHRs in order to 
   detect “signals” (combination of drugs and suspected adverse events that warrant further investigation). 
These techniques will be made available as a set of secure Web services, combining secure HTTPS connection with 
   WS-Security user authentication.

However, to obtain final readable results, the various services must work with each other, constructing one or more workflows. 
An interdisciplinary team of researchers, requiring a software application that enhances workflow development in 
   an elegant manner, will develop these workflows. 
The chosen platform is Taverna, which provides a very easy to use interface and strong core features for 
   Web services interconnection and management, improving researchers’ collaboration and general system functionality. 
Taverna will support the remaining system components and end-user applications. 
In the end, the project should demonstrate that scientific and clinical evidence could quickly and 
   directly be translated into patient safety and, thus, health benefit.

[Presentation slides](http://www.taverna.org.uk/pages/wp-content/uploads/2010/10/EUADR_project.pdf) 
   by Pedro Lopes describe the use of Taverna by the EU-ADR project.
