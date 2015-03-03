Title:     Databases
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

Various projects and researchers use Taverna to access, collate and manipulate data from databases:

 - [Electronic Cultural Heritage made Accessible for Sustainable Exploitation][1] (eCHASE)
 - [eFamily][2]
 - [European Model for Bioinformatics Research And Community Education][3] (EMBRACE)
 - [iSpider][4]
 - [omixed][5]
 - [ProDom][6] - running of Taverna workflows behind a portal to search a protein database

<a name="efamily"></a>
##eFamily##

The [eFamily project][7] was designed to integrate the information contained in five major protein databases. 
   The project developed webservices to allow the calculation of results based upon the content of 
   several databases, and upon annotation of the data.

The project made use of Taverna workflows to integrate the webservices, 
   both those provided by the eFamily project and those developed externally.

###Publications###
Some details of this work are given in the http://www.allhands.org.uk/2004/proceedings/papers/211.pdf 
   *eFamily: Bridging Sequence and Structure* by Finn et al.

<a name="embrace"></a>
##EMBRACE##
[EMBRACE][8] is the European Model for Bioinformatics Research And Community Education (EMBRACE).
It consists of a large number of partners throughout Europe

> The objective of EMBRACE is to draw together a wide group of experts
> throughout Europe who are involved in the use of information
> technology in the biomolecular sciences.  
> The EMBRACE Network of Excellence will optimise informatics and information exploitation by
> pure and applied biological scientists in both the academic and commercial sectors.

The [University of Manchester][9] is a member of the EMBRACE project, 
   and the Taverna Workbench has been adopted by EMBRACE as its workflow system of choice.

The suitability of Taverna Workbench has been confirmed by its use in several test cases:

 - The use of Taverna to access Grid Protein Sequence Analysis (GPSA) Web services as described by 
      Blanchet et al. in the [paper][10] 
      *Web Services Interface to Run Protein Sequence Tools on Grid, Testcase of Protein Sequence Alignment*. 
   This includes the running of the Web services on [EGEE][11] grid.
 - Taverna has been used to automate the cleaning up and extraction of data by the EMBRACE project from the 
      tGRAP database of mutated G-protein coupled receptors.
 - The ProDom-based protein family analyses test case includes the use of Taverna within [ProDom][12].

The tGRAP work is described in the [document][13] *The reincarnation of the tGRAP database* by Vroling.

Use of Taverna allows the members of EMBRACE to have ready access to the existing bioinformatics services and 
   also to the myGrid team’s expertise in this area. Correspondingly, the members of EMBRACE represent 
   a diverse group of users with different backgrounds and infrastructure.

<a name="omixed"></a>
##omixed##

[omixed][14]</a> is a “customisable storage system for scientific data, completely managed via web services”. 
Its developers have written a Taverna 1.7.x [plugin][15] to allow users to access data.

The plugin “provides two endpoints giving full control of omixed resources. 
The first endpoint, known as the server endpoint, is designed for most users who want to browse, download, 
   or add to or modify existing resources. 
The second point, known as the admin endpoint, is designed for administrators to create and delete resources, 
   assign schema to them, and modify user privileges.”


  [1]: /introduction/taverna-in-use/multimedia#echase
  [2]: #efamily
  [3]: #embrace
  [4]: /introduction/related-projects#ispider
  [5]: #omixed
  [6]: /introduction/taverna-in-use/protein-and-proteomics#prodom
  [7]: http://www.ebi.ac.uk/pdbe/docs/sifts/efamily.html
  [8]: http://www.embracegrid.info/
  [9]: http://www.manchester.ac.uk/
  [10]: http://dx.doi.org/10.1007/11946465_22
  [11]: https://eu-egee-org.web.cern.ch/eu-egee-org/index.html
  [12]: /introduction/taverna-in-use/protein-and-proteomics#prodom
  [13]: http://www.myexperiment.org/files/29
  [14]: http://nebc.nerc.ac.uk/tools/omixed/overview
  [15]: http://www.omixed.org/documentation/omixed%20taverna%20plugin