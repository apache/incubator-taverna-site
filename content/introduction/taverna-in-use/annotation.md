Title:     Annotations
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

Taverna is used by various tools and projects for the association of metadata with data (annotation). 
These include:
 - [Automatic Functional Annotation in a distributed Web service Environment][1](AFAWE) - 
      annotation of plant genes with their functionality
 - [Interactive genome annotation pipeline][2]</a> - automatic and manual annotation of genes
 - [TaWeka][3] - associating biological data with calculated functionality

In addition, Taverna makes use of the semantic annotation that has been specified for the services provided by 
   the [MOBY consortium][4].

Taverna has also been used for the identification of mismatches and possible annotations in workflows by the 
   [iSPIDER][5] project.

<a name="afawe"></a>
##AFAWE##

The [Max Planck Institute for Plant Breeding Research][6] in Cologne, Germany have developed the 
  Automatic Functional Annotation in a distributed Web Service Environment ([AFAWE][7]). 
AFAWE is a tool for the automatic functional annotation of new genes in plants and other organisms. 
The annotation involves the running of several Web services, and also the execution of a Taverna [workflow][8].

The annotation workflow is [available][9] on [myExperiment][10].

###Publications###
The [paper][11] *Protein function prediction and annotation in an integrated environment powered by web services 
  (AFAWE)* by Joecker et al describes the concepts and implementation of AFAWE.

<a name="annotation-of-genomes"></a>
##Annotation of genomes##
A collaboration between Tom Oinn from the myGrid team and Anders Lanzen, Svenn Helge Grindhaug and 
   Pal Puntervoll from the [University of Bergen][13], Norway, has produced an interactive genome annotation 
   pipeline.

Sequencing, characterising and annotating a genome are the first steps to understanding its function. 
Important stages in this include gene prediction, comparative genomics and function prediction of genes and 
   gene products. 
With workflows all of these stages can be automate, requiring little human interaction. 
However, manual inspection can be required at certain points in the process.

###Publications###
[Articles and papers](http://scholar.google.co.uk/scholar?q=Taverna+for+genome+annotation) 
   about the success of Taverna for genome annotation are available on-line.

<a name="taweka"></a>
##TaWeka##
[Luna De Ferrari][15] from the Computational Systems Biology &amp; 
   [Bioinformatics group at the University of Edinburgh][16] has developed [TaWeka][17],

> a rapid prototyping tool for biological classifiers.

TaWeka uses Taverna workflows to store data retrieved from webservices, e.g. queries of biological data, 
   into a database. 
[Weka][18] is then used to run machine learning experiments on the data in order to evaluate and improve 
   biological classification functions.

###Publications###
A poster [*TaWeka: from biological web services to data mining*][19] by De Ferrara and Goryanin describes the 
   purpose and implementation of TaWeka.

<a name="adoption-by-moby"></a>
##Adoption by the Moby consortium##
The [Moby][20] project develops a system for interoperability between biological data hosts and 
   analytical services. 
Their relationship with Taverna is multiple:

 - The Moby team actively collaborate with myGrid in the development of the ontologies used to describe their 
      services. 
   Service descriptions are then used by Taverna to find services to use in workflows.
 - The services published on Moby are a large proportion of the services often used in Taverna workflows
 - People wishing to combine Moby services commonly use Taverna Workbench as a platform
 - Specific support for Moby services is available within Taverna.

###Publications###
The [paper][21] *Interoperability with Moby 1.0—It’s better than sharing your toothbrush!* by the 
   Moby consortium gives an overview of Moby and their activities.

  [1]: #afawe
  [2]: #annotation-of-genomes
  [3]: #taweka
  [4]: #adoption-by-moby
  [5]: /introduction/related-projects#ispider
  [6]: http://www.mpiz-koeln.mpg.de/2169/en
  [7]: http://bioinfo.mpiz-koeln.mpg.de/afawe/
  [8]: http://bioinfo.mpiz-koeln.mpg.de/afawe/help/Tools.html#SIFTER
  [9]: http://www.myexperiment.org/workflows/95
  [10]: http://www.myexperiment.org/
  [11]: http://dx.doi.org/10.1093/bioinformatics/btn394
  [13]: http://www.uib.no/en
  [15]: http://homepages.inf.ed.ac.uk/ldeferra/
  [16]: http://www.bioinformatics.ed.ac.uk/
  [17]: http://mook.inf.ed.ac.uk/twiki/bin/view.cgi/PublicCSB/TaWeka
  [18]: http://www.cs.waikato.ac.nz/ml/weka/
  [19]: http://mook.inf.ed.ac.uk/twiki/pub/PublicCSB/TaWekaPosters/colourA4_16.pdf
  [20]: http://biomoby.open-bio.org/
  [21]: http://dx.doi.org/10.1093/bib/bbn003
  [22]: #d