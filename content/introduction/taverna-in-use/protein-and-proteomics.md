Title:     Protein and proteomics
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

Taverna is used by various projects and researchers for the analysis of proteins and proteomics:

 - [Anthrax analysis](/introduction/taverna-in-use/disease-research#analysis-of-anthrax-bacterium) - 
   identification of proteins secreted by bacteria>
 - [eFamily](/introduction/taverna-in-use/databases#efamily) - integrating data from different databases
 - [European Model for Bioinformatics Research And Community Education](http://www.mygrid.org.uk/mygrid-in-use/adoption-by-embrace)
      (EMBRACE) - calling services on a grid; recovering a database
 - [iSpider](/introduction/related-projects#ispider) - querying multiple data sources
 - [ProDom](#prodom) -running of Taverna workflows behind a portal to search a protein database

<a name="prodom"></a>
##ProDom

[ProDom](http://prodom.prabi.fr/) is a comprehensive database of protein domain families generated 
   from the global comparison of all available protein sequences. 
It was developed at the Rhône-Alpes Bioinformatics Center ([PRABI](http://www.prabi.fr/)).

ProDom is described in the [paper](http://dx.doi.org/10.1093/nar/gki034) 
   *The ProDom database of protein domain families: more emphasis on 3D * by Bru et al.

A Web-based front-end is [available](http://prodom.prabi.fr/prodom/current/html/form.php)
   to perform searches and comparisons on the content of the database.

Some of the queries used by the front-end make use of Taverna 
   [workflows](http://prodom.prabi.fr/prodom/current/html/webservices.html).
