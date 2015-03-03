Title:     Related projects
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

The Taverna team are currently involved or collaborating on several projects sponsoring the development 
   of new tools and the improvement of Taverna:

 - [BioVeL][1] – establishing an international e-Laboratory to allow biodiversity scientists to jointly tackle 
      diverse research challenges using Taverna, myExperiment and BioCatalogue
 - [Wf4Ever][2] – providing methods and tools required to ensure the long-term preservation of 
      scientific workflows
 - [SCAPE][3] – large scale and computation intense automated digital preservation and quality assurance 
      workflows on a cloud infrastructure

We are also involved in various projects set out to solve particular e-Science problems using Taverna:

 - [ChemTaverna][4] – workflows for chemoinformatics
 - [ONDEX][5] – integration of biological data
 - [Shared Genomics][6] – the use of the [Taverna Server](/documentation/server) to run genetic data workflows
 - [REFINE][8] – text mining and visualisation
 - [HELIO][9] – services and workflows for HelioPhysics

An outreach project designed to expose scientists to the possible uses of e-Science and to aid them in 
    adopting the available tools and techniques:

 - [ENGAGE][10] – JISC initiative for exploiting the benefits of e-Infrastructure by developing and deploying 
      new software solutions on available UK e-Infrastructure; funded a development project to facilitate 
      the use of Taverna for [Shared Genomics][11]

There are also a large number of Taverna-related projects that the team have been involved with in the past:

 - [HELIO][12] – the Heliophysics Integrated Observatory
 - [TSB grant][13] – to address NHS requirements for accessing and comparing large amounts of information and 
      find common genetic links when testing new treatments (in partnership with Eagle Genomics)
 - [Taverna-Galaxy][14] – a tool for automatic generation and exposure of Taverna workflows as Galaxy tools. 
   Galaxy is an open, web-based platform for data intensive biomedical research
 - [e-LICO][15] – a virtual laboratory for interdisciplinary collaborative workflows in data mining and 
     data-intensive sciences
 - [NeISS][16] – Taverna workflows for social (population and traffic) simulations in portals
 - [caGrid project][17] – support for running cancer-research workflows
 - [e-Fungi][18] – Web services for comparative genomics
 - [ISpider][19] – proteomics workflows
 - [MIASGrid][20] – medical imaging

<a name="biovel"></a>
##BioVeL##

The Biodiversity Virtual e‑Laboratory (BioVeL) project, 
  led by the School of Computer Science and Informatics at Cardiff University, 
  has €5 million in funding and is seeking to provide a vital service that will improve the way scientists share,
  analyse and present information in the growing area of biodiversity science. 
The project includes the application of Taverna, [myExperiment][21] and the [BioCatalogue][22].

Biodiversity science is the study of plants and animals that inhabit our planet and the environments they 
  live in. 
Amid growing concerns over the extinction rate of certain species as their natural habitats are increasingly 
  destroyed, and with biodiversity becoming as important as climate change on the political agenda, 
this new research project could not be more timely.

Biodiversity Virtual e‑Laboratory (BioVeL) will establish an international e-Laboratory – 
  the first of its kind in Europe – that will allow biodiversity scientists to jointly tackle diverse 
  research challenges.

Experts from Cardiff University along with 15 partners from institutions across Europe, 
  hope that when completed, the BioVeL e-Laboratory will, for the first time, 
  give scientists access to multiple data, analysis and computing resources for biodiversity science through 
  a robust e-Science infrastructure.

Ranked by the European Commission (EC) as top of its class from more than 60 proposals, 
  BioVeL is funded under the EC’s FP7 e-Infrastructures programme to support the creation of the 
  European Research Area.

For further information on the BioVeL project, visit [http://www.biovel.eu/][23]

<a name="scape"></a>
##SCAPE##

[SCAPE][24] (SCAlable Preservation Environments) is an EU-funded FP7 project aimed at building a scalable 
   platform for planning and execution of computation intensive processes for ingestion or migration of 
   large data sets in order to help automate digital preservation.

The data sets involved are either heterogeneous data collections (collections of objects of different type), 
   contain data objects that are themselves large or complex in structure or contain a huge amount of digital 
   objects. 
The sheer volume of data archives makes it impossible to use the current service-oriented architectures to 
   ensure access to digital information over time.

In this project, preservation processes will be realised as data pipelines and described formally as automated, 
   quality-assured preservation Taverna workflows. The workflows will invoke various services for planning 
   and execution of institutional preservation and quality assurance strategies. 
The workflows will be deployed on a large scale (using Hadoop MapReduce clouds) and executed over large, 
   distributed and heterogeneous collections of complex digital objects.

The workflows will enable reproducibility of preservation processes and collect provenance data over the 
   entire digital object’s lifecycle.

The execution of workflows will be controlled by a policy-based “planning and watch” system, which will 
   ensure the workflows are in line with state-of-the art in digital object representation, file formats, 
   rendering tools, etc. and detect and report any errors in a preservation process.

###SCAPE and Taverna in use###

by Schlarb Sven, sven.schlarb@onb.ac.at, Austrian National Library

SCAPE consists of testbeds that have three application areas: Digital Repositories, 
   from the library community, Web Content, from the web archiving community, and Research Data Sets, 
   from the scientific community. 
The testbeds are used to evaluate solutions developed by the SCAPE project against defined institutional 
   data sets in order to validate their applicability to real life application scenarios, 
   such as large scale data repository ingest-workflows or data archive maintenance.

Taverna is being used to develop concept workflows locally, to study the feasibility of differing approaches. 
Taverna server is used for remote execution of workflows, 
   with the Tool service in use as the main integration pattern.

In the context of how Taverna technology is currently used from a research perspective it is being used 
   as a tool for ETL (Extraction/Transform/Load) and creating query-able data tables from large 
   digital object collections. Content analysis and quality assurance are also performed using Taverna.

Austrian National Library

Max Kaiser, Head of Department of Research and Development
Bettina Kann, Head of Digital Library

<a name="ChemTaverna"></a>
##ChemTaverna##

ChemTaverna is a pilot project currently being undertaken to investigate the application of Taverna in 
   cheminformatics by scientists at the School of Chemistry, University of Southampton in collaboration
   with developers at the [Manchester Interdisciplinary Biocentre][25] (MIB).

A range of cheminformatics services are available for use in the Taverna Workbench – 
   their [descriptions and example workflows][26] showing how they can be used in data analyses are available 
   on-line. 
All cheminformatics services can be imported to the Workbench in one go in the form of the 
   [Chemistry Service Set][27] , which is available from myExperiment as a Service Set Pack.

The results from cheminformatics workflows will be shared by means of blogs to provide a notebook record 
   of data analyses. 
The ChemTaverna project will also investigate how laboratory instrumentation can be controlled in workflows 
   for use in closed-loop optimization experiments to enhance the performance of analytical instruments.

[UsefulChem][28] project, an Open Notebook Science project in chemistry led by the Bradley Laboratory at 
   Drexel University, have created many useful chemistry workflows using Taverna. 
The workflows are described at Jean-Claude Bradley’s [UsefulChem blog][29].

<a name="ondex"></a>
##ONDEX##

[ONDEX][30] is currently an opensource suite of software that “enables data from diverse biological data sets 
   to be linked, integrated and visualised”. 
This [BBSRC][31] funded project aims to support ONDEX and its integration with more general bioinformatics 
   tools, such as those developed by the myGrid team.

The existing ONDEX functionality is being exposed as Web services. 
These may then be used in workflow systems such as Taverna. Taverna workflows are also used to increase the 
   functionality of ONDEX.

The partners are the [University of Manchester][32] ([Carole Goble][33] and Robert Stevens), 
[University of Newcastle][34] (Anil Wipat), [Rothamsted Research][35] (C Rawlings), 
[the National Centre for Text Mining][36] and [Manchester Centre of Integrative Systems Biology][37]. 
The project runs from April 2008 to March 2011.

<a name="shared-genomics"></a>
##Shared Genomics##

Shared Genomics project, in partnership with Microsoft, aims to develop accessible High Power Computing 
   infrastructure to support the analysis of large genetic data. An essential part of the work is the 
   integration of results with metadata retrieved from knowledge repositories. 
This work will build upon the myGrid achievements in the association of metadata with data and the description 
   of the semantics of services.

The project is based at the North West Institute for BioHealth Informatics (NIBHI), 
   a collaborative venture between the major universities in the North West of England, 
   industrial partners such as Astra Zeneca, and the North West Development Agency. 
The principal investigator is Iain Buchan. The project is funded for £600k and runs from March 2008 to 
   February 2010.
Enable Taverna workflows in a Shared Genomics causality workbench

This is an ENGAGE funded project to enable Taverna workflows using Shared Genomics services to be called 
   in a more efficient manner. This work builds on the Taverna Server.

<a name="refine"></a>
##REFINE##

[REFINE][38], Tools for the text mining-based visualisation of the provenance of 
   biochemical networks, is a BBSRC funded project to find solutions for the terminology 
   problem in systems biology, by developing techniques for recognising synonym terms.

The REFINE project involves the use of text mining tools. 
Their application will be influenced by the experience of the myGrid team and Taverna Workbench users in 
   this area.

The principal investigator is [Sophia Ananiadou][40], Director of the National Centre for Text Mining 
   ([NaCTeM][41]) at the [University of Manchester][42]. 
The project runs from January 2007 to June 2010.

<a name="helio"></a>
##HELIO##

[HELIO][43], the Heliophysics Integrated Observatory, is a three year EU funded project that started in 
   June 2009.

> The Heliophysics Integrated Observatory, HELIO, will deploy a
> distributed network of services that will address the needs of a broad
> community of researchers in heliophysics. HELIO will provide the most
> comprehensive integrated information system in this domain; it will
> coordinate access to the resources needed by the community, and will
> provide access to services to mine and analyse the data.

The project [partners][44] include institutions from France, Ireland, Italy, Switzerland, the UK and the USA.
Publications

Workflows for Heliophysics, Blanc, A., Brooke, J., Fellows, D., Soldati, M., Pérez-Suárez, D., Marassi, A., 
   Santin, A.,  [Journal of Grid Computing][45].
[http://link.springer.com/article/10.1007%2Fs10723-013-9256-5][46]

<a name = "engage"></a>
##ENGAGE##

The ENGage Academic Groups with E-infrastructure ([ENGAGE][47]) project is a [JISC][48] 
    funded initiative involving the 
   [National Grid Service][49] (NGS) and the Universities of [Southampton][50], 
   [Manchester][51] and [Edinburgh][52].

“The overall aim of the project is to improve the experience of research users of UK e-Infrastructure, 
   and promote the use of UK e-Infrastructure to a wider set of users by engaging with different research 
   communities.”

The principal investigator is David De Roure.

ENGAGE funded a development project to facilitate the use of Taverna for [Shared Genomics][53].

<a name = "tsb"></a>
##TSB grant##

This £500,000 project is part-funded by the UK’s national innovation agency, 
   the Technology Strategy Board (TSB) and is carried out by [Eagle Genomics][54], 
   a leading open-source bioinformatics service provider, 
   in collaboration with the myGrid/Taverna team and Cytocell Ltd., with assistance from [NGRL][55], 
   based at the Central Manchester University Hospitals NHS Foundation Trust, 
   and the [NIHR Manchester Biomedical Research Centre][56].

The project will build upon the success of the Taverna Workflow Management System in next generation 
   sequencing to enable medical researchers who are developing and testing new treatments to compare large 
   amounts of information analysed and stored on a cloud and find common genetic links.

The technology will also help clinicians to look at an individual patient’s genetic make-up to aid diagnosis 
   and ongoing treatment.

Rather than simply testing a patient for one suspected condition, 
   using the cloud technology could allow clinicians to test for a much wider range of complaints.

Currently, the NHS IT systems do not have the resources to cope with the huge demands required. 
The cloud system can be accessed from a separate site, away from hospitals, freeing up space.

Eagle Genomics will work with the Taverna team  to adapt Taverna to allow non-IT experts to easily add and 
   extract information and share it with their colleagues.

[Read mode about the project][57].

<a name = "taverna-galaxy"></a>
##Taverna 2-Galaxy##

[Galaxy][58] is an open, Web-based platform for data intensive biomedical research. 
Taverna 2-Galaxy integration is a first step towards making Galaxy and Taverna 2 more interoperable. 
It allows the automatic generation of Galaxy tools from Taverna 2 workflows. 
The tools can then be installed as usual in a Galaxy server and allow the Taverna workflows to become part 
   of a Galaxy pipeline. It has been developed by Kostas Karasavvas of [NBIC][59].

Users do not need to install Taverna 2-Galaxy themselves. 
It is available as part of the myExperiment [Web site][60]. 
While browsing Taverna 2 workflows the user will see an additional link “Download as Galaxy Tool” in the 
  download section of the workflow. 
The tool can then be installed into Galaxy in the usual manner by the Galaxy administrator. 
They will also need a [Taverna Server][61] that will run the Taverna 2-Galaxy tools.

Also check out the Taverna-Galaxy [wiki][62].
For Taverna-Galaxy users

 - You can now include Taverna workflows as part of your Galaxy workflows
 - The Taverna workflow will be made available as a Galaxy tool
 - You can [search/browse][63] Taverna workflows from the [myExperiment][64] workflow repository, and
 - Just let your Galaxy administrator know which Taverna workflows you want installed in Galaxy

Try it out

    The [NBIC Galaxy Server][65] provides a demo platform to run some pre-installed Taverna workflows in Galaxy

Taverna-Galaxy in use

Dr Casey Bergman and his group of Life Sciences researchers from the [Bergman Lab][66] @ University of Manchester 
   working on eukaryotic genome biology have successfully installed and used the integrated Taverna-Galaxy tools.

See [their blog][67] about their experiences in installing and running Taverna-Galaxy.

<a name = "e-lico"></a>

##e-LICO##

The goal of the [e-LICO project][68] is to build a virtual laboratory for interdisciplinary collaborative research in data mining and data-intensive sciences. The proposed e-lab will comprise three layers: the e-science and data mining layers will form a generic research environment that can be adapted to different scientific domains by customizing the application layer.

The foundation of the e-science layer is a suite of open source components from the myGrid e-science platform (one of which is the next generation Taverna Workbench). To build the e-LICO infrastructure, these components will be extended with tools for content creation (e.g. semantic annotation, ontology engineering), as well as mechanisms for multiple levels and modes of collaboration in experimental research.

A [video tutorial][69] explains how to build data mining workflows.

<a name = "neiss"></a>
##NeISS##

The National e-Infrastructure for Social Simulation is a [JISC][70]-funded project to undertake a coordinated 
   programme of producing services and furthering uptake through community engagement to create a sustainable, 
   long-term platform for social simulation with potential for major strategic impact, 
   both in the UK and internationally. 
The project involves [Leeds University][71], [Manchester University][72] 
   (including [NCeSS](http://en.wikipedia.org/wiki/National_Centre_for_e-Social_Science)), 
   [Stirling University][74], Glasgow University, UCL, Southampton University, STFC Daresbury Laboratory.

Within the project, the Taverna team are working on:

 - the integration of the Taverna functionality into a portal, i.e. providing JSR 168/286 compliant 
      components that provide access to enactment, management, monitoring and creation of workflows.
 - the re-purposing of services from [myExperiment][75], facilitating their integration into a portal. 
   An important focus will be the incorporation of social networking functionality to provide extended 
      archiving and documentation capability for social simulations.

[Documentation on wrapping Taverna workflows in a portal and the code][76] is available from our 
   (Pre Apache) wiki.

<a name = "cagrid"></a>
##caGrid##

[caGrid][77] is part of [caBIG][78] (cancer Biomedical Informatics Grid), 
   a US project to carry out eScience and bioinformatics in cancer research.

The Taverna team were funded by the US National Cancer Institute (NCI) to help integrate Taverna with caGrid, 
   so that Taverna can find and use (secured and non-secured) caBIG data and analytical services found on caGrid.

The team wrapped a selection of typical non-caBIG services used by Taverna users so that they are annotated 
   and comply with caBIG’s Silver-level compatibility requirements.

The team also implemented a plugin for Taverna 2.1.2 that enables semantic search for caGrid services 
   described by the caGrid’s Index Service and adding them as component to workflows.

More details about the project and the deliverables can be found on the project’s [Wiki pages][79] and 
   NCI’s Gforge project pages. Source code of the Taverna plugins is available from the [SVN repository][80]. 
The project ran from September 2008 to November 2009.

The work on the caGrid project follows on from caGrid’s previous adoption of Taverna when the Taverna and 
   caGrid collaborated in 2007 to develop a Taverna 1.7.0 GT4 processor as a plugin based upon the 
   Taverna’s WSDL processor. 
This work has been updated for Taverna 2.x and there are two plugins available: [caGrid plugin][81] 
   (for invoking caGrid services) and [caGrid remote execution plugin][82] (for remote execution of 
   caGrid workflows on a server).

The functionality of the Taverna 1.7.0 caGrid plugin was shown at a caGrid meeting in late 2008 where 
   the associated poster won an outstanding poster [award][83].

The installation and use of the Taverna 1.7.0 caGrid plugin is described on the caGrid [wiki][84].

###Publications###

The [paper][85] “Combining the Power of Taverna and caGrid: Scientific Workflows that Enable Web-Scale 
   Collaboration” has been written by Wei Tan, Ian Foster and Ravi Madduri to describe some of the work done on 
   the project.

<a name = "e-fungi"></a>

##e-Fungi##

e-Fungi was a BBSRC funded project to produce an e-Science infrastructure for comparative functional 
  genomics in fungal species. 
Parts of the e-Fungi project include the development of a data warehouse and analysis libraries that are 
  exposed as Web services. 
These Web services can be used within the Taverna Workbench for the creation of workflows.

The principal investigators were Professor Norman Paton, Professor Oliver, 
   Dr Rattray and Dr Hubbard of the University of Manchester. 
The project ran from October 2004 to June 2008.

<a name = "ispider"></a>

##iSpider##

[iSpider][86] was a [BBSRC][87] funded project to create an informatics platform for proteomics using Grid-based 
   technologies, and to use this to address specific biological problems. 
The grantholders were Dr S. Hubbard, Dr Suzanne Embury, Professor [Carole Goble][88] CBE, 
   Professor Norman Paton, Dr Robert Stevens and Prof Oliver of the [University of Manchester][89]. 
The project ran from July 2004 to June 2007.

The iSpider project developed three tools that make use of Taverna’s functionality and plugability to 
   support the development of workflows, in particular for proteomics.

Much of the work has been done by Khalid Belhajjame and additional information can be found in his publications.
A tool for the identification and the characterisation of mismatches in scientific workflows

By using the [Feta][90] service registry and extending the capabilities of the Taverna Workbench, 
   this tool provides a means for automatically identifying and characterising the mismatches that may 
   arise between the constituent operations of an in silico experiments.
A tool for automatically inferring service annotations

This tool allows the derivation, in an automatic fashion, 
   of information about the annotations of service parameters using existing tested-and-tried workflows. 
It has been evaluated using the workflow repository provided by [myExperiment][91] together with the 
   [myGrid ontology][92].
A system for querying multiple proteomics data sources

It supports the combined use of Grid data access ([OGSA-DAI][93]), Grid distributed querying ([OGSA-DQP][94]) and 
   data integration ([AutoMed][95]) software tools to support distributed data analysis. 
This system has been used for providing an integrated access to four proteomics data sources, namely, 
   [gpmDB][96], [PedroDB][97], PepSeeker and [Pride][98].

<a name = "miasgrid"></a>
##MIASGrid##

The MIAS project examined the requirements of Medical Imaging and Signals. 
The [MIASGrid][99] sub-project, took examples of those requirements and investigated how e-Science and 
   the myGrid tools in particular could satisfy them. 
The project was funded by the [EPSRC][100] for £494k and ran until April 2006.

The project produced several workflows that demonstrated the applicability of Taverna to the handling of 
  large amounts of medical image data. 
The workflows made use of [MATLAB][101] and also interaction with users.

The workflows covered two domains:

 - The analysis of MRI scans of knees to detect changes in cartilage
 - The [description and searching][102] of a database of mammograms


  [1]: #biovel
  [2]: http://www.wf4ever-project.org/home
  [3]: #scape
  [4]: #ChemTaverna
  [5]: #ondex
  [6]: #shared-genomics
  [8]: #refine
  [9]: #helio
  [10]: #engage
  [11]: #shared-genomics
  [12]: #helio
  [13]: #tsb
  [14]: #taverna-galaxy
  [15]: #e-lico
  [16]: #neiss
  [17]: #cagrid
  [18]: #e-fungi
  [19]: #ispider
  [20]: #miasgrid
  [21]: http://www.myexperiment.org/
  [22]: http://www.biocatalogue.org/
  [23]: http://www.biovel.eu/
  [24]: http://www.scape-project.eu/
  [25]: http://www.mib.ac.uk/
  [26]: /introduction/chemistry-web-services
  [27]: http://www.myexperiment.org/packs/135.html
  [28]: http://usefulchem.wikispaces.com/
  [29]: http://usefulchem.blogspot.com/
  [30]: http://www.ondex.org/
  [31]: http://www.bbsrc.ac.uk/
  [32]: http://www.manchester.ac.uk/
  [33]: https://sites.google.com/site/carolegoble/
  [34]: http://www.ncl.ac.uk/
  [35]: http://www.rothamsted.ac.uk/
  [36]: http://www.nactem.ac.uk/
  [37]: http://www.mcisb.org/
  [38]: http://www.nactem.ac.uk/pathtext/
  [40]: http://www.nactem.ac.uk/staff/sophia.ananiadou/
  [41]: http://www.nactem.ac.uk/
  [42]: http://www.manchester.ac.uk/
  [43]: http://www.helio-vo.eu/
  [44]: http://www.helio-vo.eu/aboutus/helio_consortium.php
  [45]: http://link.springer.com/journal/10723
  [46]: http://link.springer.com/article/10.1007%2Fs10723-013-9256-5
  [47]: http://www.engage.ac.uk/
  [48]: http://www.jisc.ac.uk/
  [49]: http://www.ngs.ac.uk/
  [50]: http://www.soton.ac.uk/
  [51]: http://www.manchester.ac.uk/
  [52]: http://www.edinburgh.ac.uk/
  [53]: #shared-genomics
  [54]: http://www.eaglegenomics.com/
  [55]: http://www.ngrl.org.uk/
  [56]: http://www.manchesterbrc.org/index.php
  [57]: http://www.eaglegenomics.com/genetics-cloud-to-create-new-opportunities-for-researchers-and-clinicians
  [58]: http://galaxy.psu.edu/
  [59]: http://www.nbic.nl/
  [60]: http://www.myexperiment.org/
  [61]: /documentation/server
  [62]: https://trac.nbic.nl/elabfactory/wiki/eGalaxy
  [63]: http://www.myexperiment.org/workflows
  [64]: http://www.myexperiment.org/
  [65]: http://galaxy.nbic.nl/
  [66]: http://bergmanlab.smith.man.ac.uk/
  [67]: http://bergmanlab.smith.man.ac.uk/?p=943
  [68]: http://www.e-lico.eu/
  [69]: http://www.vimeo.com/10345778
  [70]: http://www.jisc.ac.uk/
  [71]: http://www.leeds.ac.uk/
  [72]: http://www.manchester.ac.uk/
  [74]: http://www.stir.ac.uk/
  [75]: http://www.myexperiment.org/
  [76]: http://www.mygrid.org.uk/dev/wiki/display/portals/NeISS+Project
  [77]: http://www.cagrid.org/
  [78]: http://cabig.cancer.gov/
  [79]: http://www.mygrid.org.uk/dev/wiki/display/caGrid/Home
  [80]: https://gforge.nci.nih.gov/svnroot/taverna-cagrid/
  [81]: http://www.taverna.org.uk/documentation/taverna-plugins/taverna-2-x-plugins#cagrid_plugin
  [82]: http://www.taverna.org.uk/documentation/taverna-plugins/taverna-2-x-plugins#cagrid_remote_execution_plugin
  [83]: http://www.mygrid.org.uk/2008/09/outstanding-poster-award-at-the-cabig-ncri-conference/
  [84]: http://cagrid.org/display/knowledgebase/How+to+Create+CaGrid+Workflow+Using+Taverna
  [85]: http://dx.doi.org/10.1109/MIC.2008.120
  [86]: http://www.ispider.manchester.ac.uk/
  [87]: http://www.bbsrc.ac.uk/
  [88]: https://sites.google.com/site/carolegoble/
  [89]: http://www.manchester.ac.uk/
  [90]: http://www.mygrid.org.uk/tools/service-management/feta/
  [91]: http://www.myexperiment.org/
  [92]: http://www.mygrid.org.uk/tools/service-management/mygrid-ontology/
  [93]: http://www.ogsadai.org.uk/
  [94]: http://link.springer.com/chapter/10.1007%2F978-3-540-24741-8_58
  [95]: http://www.doc.ic.ac.uk/automed/
  [96]: http://gpmdb.thegpm.org/
  [97]: http://pedro.cs.manchester.ac.uk/
  [98]: http://www.ebi.ac.uk/pride/
  [99]: http://www.robots.ox.ac.uk/~irc/grid_mias-grid.html
  [100]: http://www.epsrc.ac.uk/
  [101]: http://www.mathworks.com/products/matlab/
  [102]: https://www.escholar.manchester.ac.uk/uk-ac-man-scw:1d33210