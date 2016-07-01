Title:     Bioinformatics
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

Taverna can connect to a wide variety of bioinformatics resources and has been successfully applied to a number 
   of bioinformatics problems, listed below according to their sub-domains.
<img class="aligncenter" 
     title="Bioinformatics services and resources" 
     src="/img/BioinformaticsResources.png" 
     alt="Bioinformatics services and resources" width="676" height="441" />

Bioinformatics systems/tools using Taverna:

 - [BioWEP][1] - bioinformatics workflow enactment portal
 - [BioLinux][2] - Ubuntu Linux distribution that includes Taverna and many other bioinformatics programs

### Biodiversity ###

 - [BioVeL](/introduction/related-projects#biovel)

### Gene and genome expression ###

 - [Next Generation Sequencing][4] using Taverna 2 Server on Amazon cloud
 - [TavernaPBS][5] - next generation sequencing analysis using a computational cluster that uses a PBS 
      queuing system and Taverna 2 Workbench
 - [Coordination and Sustainability of International Mouse Informatics Resources][6] (CASIMIR) - 
      workflows to associate mouse genome and phenome
 - [Developmental Gene Expression Map][7] (DGEMap)- analysis of human gene expression during development
 - [Graves disease][8] - identification of genes responsible
 - [Examination of gene expression from MicroArray data using R][9] - statistical analysis of gene expression
 - [SIGENAE][10] - development of workflows to analyse breeding animal data
 - [Trypanosomiasis][11] - identification of genes responsible for sleeping sickness
 - [Williams-Beuren syndrome][12] - automation and confirmation of gene characterization
 - [PLANET][13] - integration of plant genome resources
 - [Annotation of genomes][14]</a>
 - [Shared Genomics][15]</a>
 - [e-Fungi][16] functional genomics in fungal species

###Protein and proteomics###

 - [Analysis of mass spectrometry data in proteomics][17]
 - [Anthrax analysis][18] - identification of proteins secreted by bacteria
 - [eFamily][19] - integrating data from different databases
 - [European Model for Bioinformatics Research And Community Education][20] (EMBRACE) - 
      calling services on a grid; recovering a database
 - [iSpider][21] - querying multiple data sources
 - [ProDom][22] - running of Taverna workflows behind a portal to search a protein database

###Biology and systems biology###

 - [ENFIN][23] – Enabling Systems Biology – calling of wrapped tools within workflows
 - [Manchester Centre for Integrative Systems Biology][24] (MCISB) – modelling metabolomic pathways
 - [Systems Biology Operational Software][25] (SB.OS) - a live DVD based on Ubuntu Linux that comes with a 
      comprehensive list of Systems Biology Software (including Taverna)
 - [Tav4SB][26] - Taverna workflows for systems biology, 
      in particular for analysis of the kinetic models of biological systems
 - [Measuring of enzyme characteristics of yeast][27]
 - [Automatic Functional Annotation in a distributed Web Service Environment][28] (AFAWE) – 
      protein prediction and annotation by a tool that calls workflows
 - [PLANET (A Network of European Plant Databases)][29] – calling of workflows from a portal

###Biomedicine and disease-related research###

 - [Fighting dementia][30] (VP-DARE@IT and VPH-SHARE)
 - [Analysis of the anthrax bacterium][31]
 - [Study of resistance into trypanosomiasis][32] (sleeping sickness)
 - [Identification of genes linked to Graves disease][33]
 - [Characterisation of genes associated with Williams-Beuren syndrome][34]
 - [caGrid][35] - research into predicting limphoma cancer
 - [EU-ADR][36] - detecting adverse drug reactions through the exploitation of clinical data from electronic 
      healthcare records

<a name="biowep"></a>
###BioWEP###
Researchers at the Italian National Institute for Cancer Research Genoa ([IST][37]) have developed a 
   Bioinformatics Workflow Enactment Portal called [BioWEP][38].

The [portal][39] allows registered users to search for or select from a set of specified Taverna workflows. 
The workflow can be enacted by entering input values into a form. 
During enaction, the user can either wait for the result, or for longer running workflows, 
   visit the portal later. The results of the enactment can be downloaded for external visualization.

####Publications####
The http://dx.doi.org/10.1186/1471-2105-8-S1-S19 *Biowep: a workflow enactment portal for bioinformatics 
   applications* by Romano et al gives an overview of the intent and design of Biowep.

<a naem="biolinux"></a>
###BioLinux###
The UK’s Natural Environment Research Council (NERC) Environmental Bioinformatics [Centre][40] release 
   [BioLinux][41], an installation of Ubuntu Linux that includes many bioinformatics programs.

Among the programs included in the BioLinux distribution is Taverna.  
The suite of programs are also available for installation on pre-existing Linux systems.

<a name="lumc"></a>
###LUMC###
People from the Leiden University Medical Center ([LUMC](https://www.lumc.nl/) in the Netherlands are using Taverna for analysis 
  of mass spectrometry data in proteomics.

They presented a [poster][43] at the 2011 ASMS (the American Society for Mass Spectrometry) Conference on 
  Mass Spectrometry and Allied Topics.

Please contact [Dr. Magnus Palmblad][44] for more details.

<a name="measuring-enzyme-characteristics-of-yeast"></a>
###Measuring enzyme characteristics of yeast###
The [Manchester Centre for Integrative Systems Biology][45] (MCISB) is in the process of measuring the 
   kinetic and binding constants associated with enzyme reactions in metabolic pathways in the yeast, 
   Saccharomyces cerevisiae. 
Quantitative models of these metabolic pathways are being integrated with transcriptomic, proteomic and 
   metabolomic data by workflows that have been constructed and enacted using Taverna.

####Publications####
A [poster][46] by Peter Li describing the systems biology workflows was presented at the International 
   Conference of Systems Biology 2006 and he has written several publications about the work.

Many of the workflows make use of Systems Biology Markup Language ([SBML][47]) as described in the 
   [paper](http://bioinformatics.oxfordjournals.org/content/24/2/287.full.pdf) 
   *Automated manipulation of systems biology models using libSBML within Taverna workflows* 
   by Li et al.

An [example workflow][49] using SBML is available on [myExperiment][50].

  [1]: #biowep
  [2]: #biolinux
  [4]: /introduction/taverna-in-use/genome-and-gene-expression#next-generation-sequencing
  [5]: /introduction/taverna-in-use/genome-and-gene-expression#tavernapbs
  [6]: /introduction/taverna-in-use/genome-and-gene-expression#casimir
  [7]: /introduction/taverna-in-use/genome-and-gene-expression#dgemap
  [8]: /introduction/taverna-in-use/disease-research#graves-disease
  [9]: /introduction/taverna-in-use/bioinformatics#gene-expression-from-microarray
  [10]: /introduction/taverna-in-use/genome-and-gene-expression#sigenae
  [11]: /introduction/taverna-in-use/disease-research#trypanosomiasis
  [12]: /introduction/taverna-in-use/disease-research#williams-beuren-syndrome
  [13]: /introduction/taverna-in-use/biology#planet
  [14]: /introduction/taverna-in-use/annotation#annotation-of-genomes
  [15]: /introduction/related-projects#shared-genomics
  [16]: http://img.cs.man.ac.uk/efungi/
  [17]: #lumc
  [18]: /introduction/taverna-in-use/disease-research#analysis-of-anthrax-bacterium
  [19]: /introduction/taverna-in-use/databases#efamily
  [20]: http://www.mygrid.org.uk/mygrid-in-use/adoption-by-embrace
  [21]: /introduction/related-projects#ispider
  [22]: /introduction/taverna-in-use/protein-and-proteomics#prodom
  [23]: /introduction/taverna-in-use/biology#enfin
  [24]: /introduction/taverna-in-use/biology#manchester-centre-for-integrative-systems-biology
  [25]: /introduction/taverna-in-use/biology#sb-os
  [26]: /introduction/taverna-in-use/biology#tav4sb
  [27]: #measuring-enzyme-characteristics-of-yeast
  [28]: /introduction/taverna-in-use/annotation#afawe
  [29]: /introduction/taverna-in-use/biology#planet
  [30]: /introduction/taverna-in-use/disease-research#vph-dareit
  [31]: /introduction/taverna-in-use/disease-research#analysis-of-anthrax-bacterium
  [32]: /introduction/taverna-in-use#trypanosomiasis
  [33]: /introduction/taverna-in-use/disease-research#graves-disease
  [34]: /introduction/taverna-in-use/disease-research#williams-beuren-syndrome
  [35]: /introduction/related-projects#cagrid
  [36]: /introduction/taverna-in-use/medicine#eu-adr
  [37]: http://www.istge.it/
  [38]: http://bioinformatics.istge.it/biowep/index.html
  [39]: http://bioinformatics.istge.it:8080/biowep/
  [40]: http://nebc.nox.ac.uk/
  [41]: http://nebc.nox.ac.uk/biolinux.html
  [43]: http://www.taverna.org.uk/pages/wp-content/uploads/2011/06/Palmblad_ASMS_2011_LUMC.pdf
  [44]: https://www.lumc.nl/org/proteomics-metabolomics/medewerkers/nmpalmblad
  [45]: /introduction/taverna-in-use/biology#manchester-centre-for-integrative-systems-biology
  [46]: http://www.mygrid.org.uk/files/2008/09/peter-li-poster.pdf
  [47]: http://sbml.org/
  [49]: http://www.myexperiment.org/workflows/79
  [50]: http://www.myexperiment.org/
