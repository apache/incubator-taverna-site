Title:     Document and image analysis
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

 - [Islandora][1] - an open-source software framework designed to help institutions and organizations and 
   their audiences collaboratively manage, and discover digital assets using a best-practices framework.
 - [SCAPE][2] – large scale and computation intense automated digital preservation and quality assurance workflows
      on a cloud infrastructure
 - [DAE][3] - Document analysis algorithm contributions in end-to-end applications
 - [IMPACT][4] project works on improving access to historical texts and digitisation of European cultural 
      heritage using Taverna and [myExperiment][5]

<a name="islandora"></a>
##Islandora##
[Islandora][6] is an open-source software framework designed to help institutions and organizations and their 
   audiences collaboratively manage, and discover digital assets using a best-practices framework.

Islandora connects the [Drupal][7] and [Fedora][8] open software applications, acting as a kind of glue between 
   the content management and presentation capabilities of Drupal with the long term preservation features of 
   Fedora.

In an [interview][9] with http://loomware.typepad.com/about.html, the University Librarian at the University of 
   Prince Edward Island, Mark explains how Taverna workflows are utilized by the Islandora framework to 
   call local Python scripts remotely via Web services&' wrappers. 
This allowed for extreme agility within the Islandora ecosystem and has allowed the integration of a wide range 
   of open source (and proprietary where desirable) software systems in relatively quick order. 
Read the [full interview][10] with Mark Leggott.

<a name="dae"></a>
##DAE##

The [DAE project][11] (Document Analysis Algorithm Contributions in End-to-End Applications) provides the 
   [DAE Platform][12] to give access to a collection of resources and applications related to machine perception
   and document analysis. 
   Applications include binarization, text segmentation, OCR (Optical Character Recognition), 
      named entity detection, etc.

The DAE Platform is accessible though a Web portal which provides a series of services related to document 
   analysis research of  which the most prominent are the access to a wide range of reference datasets, 
   as well as their annotations, ground-truths or  interpretations; a catalogue of state of the art algorithms 
   that can be  executed on hosted or otherwise provided data, as well as the uploading  and execution of 
   complex workflows combining those algorithms.

One of the more advanced contributions of the DAE Platform is to provide  an open and very flexible framework to
    add, run, evaluate and contribute  algorithms. These algorithms are provided as Web services and can be
   invoked from anywhere. 
Because of its open architecture users can very  easily contribute and convert their own algorithms to this 
   framework,  without necessarily disclosing their source code, and without the need  to port their code to 
   a particular technical environment.

The Platform is integrated with the [Taverna Web Service Orchestration][13] to provide the opportunity to 
   design, host and execute  complete and complex workflows of combined and distributed algorithms.


  [1]: #islandora
  [2]: /introduction/related-projects#scape
  [3]: #dae
  [4]: /introduction/taverna-in-use/social-sciences#impact
  [5]: http://www.myexperiment.org/
  [6]: http://islandora.ca/
  [7]: http://drupal.org/
  [8]: http://www.fedora-commons.org/
  [9]: http://blogs.loc.gov/digitalpreservation/2013/03/islandoras-open-source-ecosystem-and-digital-preservation-an-interview-with-mark-leggott/
  [10]: http://blogs.loc.gov/digitalpreservation/2013/03/islandoras-open-source-ecosystem-and-digital-preservation-an-interview-with-mark-leggott/
  [11]: http://dae.cse.lehigh.edu/DAE/
  [12]: http://sourceforge.net/apps/mediawiki/daeplatform/index.php?title=Platform_Architecture
  [13]: http://sourceforge.net/apps/mediawiki/daeplatform/index.php?title=Platform_Architecture#Web_Service_Orchestration