Title:     Genome and gene expression
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

Taverna is being used by various projects and researchers for the analysis of genomes and gene expression.  
These include:

 - [Next Generation Sequencing](#next-generation-sequencing) using Taverna 2 Server on Amazon cloud
 - [TavernaPBS](#tavernapbs) - next generation sequencing analysis using a computational cluster that 
       uses a PBS queuing system and Taverna 2 Workbench
 - [Coordination and Sustainability of International Mouse Informatics Resources](#casimir) 
      (CASIMIR) -workflows to associate mouse genome and phenome
 - [Developmental Gene Expression Map](#dgemap) (DGEMap)- analysis of human gene expression during development
 - [Graves disease](/introduction/taverna-in-use/disease-research#graves-disease) - identification of genes responsible
 - [MicroArray analysis using R](/introduction/taverna-in-use/bioinformatics#gene-expression-from-microarray) - 
       statistical analysis of gene expression
 - [SIGENAE](#sigenae) - development of workflows to analyse breeding animal data
 - [Trypanosomiasis](/introduction/taverna-in-use/disease-research#trypanosomiasis) - 
      identification of genes responsible for sleeping sickness
 - [Williams-Beuren syndrome](/introduction/taverna-in-use/disease-research#williams-beuren-syndrome) - 
      automation and confirmation of gene characterization
 - [Integration of plant genome resources](/introduction/taverna-in-use/bioinformatics#planet) (PLANET)
 - [Annotation of genomes](/introduction/taverna-in-use/annotation#annotation-of-genomes)
 - [Shared Genomics](/introduction/related-projects#shared-genomics)
 - [e-Fungi](http://www.cs.man.ac.uk/~cornell/eFungi/) - functional genomics in fungal species

<a name="next-generation-sequencing"</a>
##Next generation sequencing

Next generation sequencing presents new challenges in large scale data processing. 
In collaboration with the University of Liverpool’s 
   [Animal Sciences &amp; Physiology Research group](http://www.liv.ac.uk/infection-and-global-health/research/animal-health-and-welfare/),
   in particular [Dr Harry Noyes](http://www.liv.ac.uk/integrative-biology/staff/harry-noyes/),  
   we combined Taverna scientific workflows with computing power from the Amazon cloud to create 
   a powerful next generation sequencing application for whole genome Single Nucleotide Polymorphism (SNP) analysis.

Through a Web portal, the application allows scientists to upload  their input data, 
   fire off a number of parallel cloud instances for the  analysis, 
   monitor progress and collect results (see figure below).

![](/img/NextGenSequencing-Figure.png)

Preliminary work on the genetic variation of African cattle showed we can run a whole genome of ~22 million SNPs 
   in a matter of hours. 
This work focuses on the response to trypanomiasis infection (sleeping sickness) in different cattle species.

The application was demonstrated at the European Conference of Computational Biology (ECCB) 2010, Ghent, Belgium, 
   under the title “Software for the Data-Driven Researcher of the Future” – see the 
   [slides](http://www.mygrid.org.uk/files/presentations/ECCB_Tech_Talk.ppt) and 
   [video](http://www.youtube.com/watch?v=eR_iPWNYb48) (no audio or subtitles yet!) from the talk.

This cloud application was based on the next generation sequencing work done presented at 
   Bioinformatics Open Source Conference (BOSC) 2010, Boston, USA, under the title
    “Analysing African and European cattle with Taverna 2.2″. 
   See the [slides](http://www.mygrid.org.uk/files/presentations/BOSC2010.ppt) from the talk.

<a name="tavernapbs></a>
##TavernaPBS                    

[TavernaPBS](http://obx.cphg.virginia.edu/mackey/?page_id=1348)
    is a plugin for Taverna developed by the 
    [Mackey Lab](http://obx.cphg.virginia.edu/mackey/),
    Center for Public Health Genomics, University of Virginia, US. 
It allows a user to define workflows that can then be run using a computational cluster that uses a PBS queuing system. 
The workflows represent next generation sequencing analysis pipelines.

To most efficiently make use of their myriad of UNIX command line tools, the project has developed a custom 
   [Beanshell](/documentation/glossary#beanshell) - 
   based library to enable workflows composed of UNIX command line invocations.  Furthermore, they have abstracted     the command execution such that each step could be executed as an     independent &#8220;job&#8221; on a remote high performance computing or grid     environment.  By doing so, they have essentially turned Taverna into a     distributed workflow &#8220;compiler&#8221;.</p>

You can download the code from the project's 
   [pages at SourceForge](http://sourceforge.net/projects/tavernapbs/).

<a name="casimir"></a>
##CASIMIR
                    
The Coordination and Sustainability of International Mouse Informatics Resources (CASIMIR) 
   [project](http://www.casimir.org.uk/) carried out a
   [pilot study](http://www.casimir.org.uk/fullstory.php?storyid=50) 
   that demonstrated how (parts of) existing databases can be made accessible in a standardized way and 
   data processed using the 
   [MOLGENIS toolkit](http://molgenis.sourceforge.net/), 
   [BioMART](http://www.biomart.org/) and Taverna.

The MOLGENIS toolkit was used to generate WSDL services to access the databases. 
These were then included in a Taverna workflow along with BioMart processors.

An example [workflow](http://www.myexperiment.org/workflows/126) can be found on 
   [myExperiment](http://www.myexperiment.org).

<a name="dgemap"></a>
##DGEMap
                    
The Developmental Gene Expression Map (DGEMap) 
   [project](http://www.dgemap.org/) 
   is an EU-funded study to design a pan-European infrastructure to support gene expression studies in early human development.

The DGEMap team [plan](http://www.inf.ed.ac.uk/research/ICTreviewEPSRC20061207/posters/HumanDev.pdf) 
   to use Taverna workflows to link human spatio-temporal gene expression data with other bioinformatics resources.

<a name="sigenae"></a>
##SIGENAE
                    
The [Systeme d’Information des GENomes des animaux ’Elevage](http://www.sigenae.org/)
   (SIGENAE) is the Information System of Analysis of Breeding Animals’ Genome 
   ([AGENAE](http://www.inra.fr/agenae/)) program. 
They are a group of French bioinformaticians providing services to biologists working on four mammal and one fish species. 
They are funded by the French National Institute for Agricultural Research 
   ([INRA](http://www.international.inra.fr/)).  
They not only use Taverna Workbench to support e-Science 
   but have been very active in promoting its adoption throughout the French bioinformatics community.

Some of the workflows developed by the Sigenae community have been made available for 
   [sharing](http://www.sigenae.org/index.php?id=84#408).