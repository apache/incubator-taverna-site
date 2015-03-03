Title:     Biology
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

Taverna is used by various projects and researchers for investigations into systems biology:

 - [ENFIN – Enabling Systems Biology](#enfin) – calling of wrapped tools within workflows
 - [Manchester Centre for Integrative Systems Biology](#manchester-centre-for-integrative-systems-biology) 
      (MCISB) – modelling metabolomic pathways
 - [Systems Biology Operational Software](#sb-os) (SB.OS) - 
      a live DVD based on Ubuntu Linux that comes with a comprehensive list of Systems Biology Software (including Taverna)
 - [MetWare](#metware) - applications, databases and workflows for metabolomics
 - [Tav4SB](/introduction/taverna-in-use/biology#tav4sb) - Taverna workflows for systems biology, 
      in particular for analysis of the kinetic models of biological systems
 - [CCPN](/introduction/taverna-in-use/biology#ccpn) - Taverna is used to encapsulate and combine protocols between 
      WeNMR (Worldwide e-Infrastructure for NMR and structural biology) portals and CCPN's 
     (Collaborative Computing Project for NMR) software. 

Taverna is also used for analysis of plant biology:

 - [Automatic Functional Annotation in a distributed Web Service Environment](/introduction/taverna-in-use/annotation#afawe) 
   (AFAWE) – protein prediction and annotation by a tool that calls workflows
 - [PLANET (A Network of European Plant Databases)](#planet) – calling of workflows from a portal


<a name="enfin"></a>
##ENFIN

The partners within the ENFIN - Enabling Systems Biology [project](http://www.enfin.org/) 
   developed a suite of Systems Biology tools (ENSUITE). 
These tools are also available as normal WSDL services and their possible use within workflows has been 
   demonstrated by use of Taverna.

###Publications
The [paper](http://www.springerlink.com/content/hw667700pm2170j4/) 
   *ENFIN - An Integrative Structure for Systems Biology* 
   by Reisinger et al. describes the overall design and structure of ENFIN.

<a name="manchester-centre-for-integrative-systems-biology"></a>
##Manchester Centre for Integrative Systems Biology

The [BBSRC](http://www.bbsrc.ac.uk/) and [EPSRC](http://www.epsrc.ac.uk/) have awarded £6.3m to the 
  [Manchester Centre for Integrative Systems Biology](http://www.mcisb.org/) 
  (MCISB) based at the [Manchester Interdisciplinary Biocentre](http://www.mib.ac.uk/) (MIB). 
The award is to pioneer the development of new experimental and computational technologies in Systems Biology, 
   and their exploitation.

The MCISB is intended to provide a hub for cutting-edge systems biology research in the Manchester area, 
   acting as a focal point for the creation of the necessary ideas and infrastructure, 
   and for establishing new methods and routines.

The co-investigators in the project Professor [Norman Paton](http://www.manchester.ac.uk/research/norman.paton), 
   Professor [Douglas Kell](http://www.manchester.ac.uk/research/Douglas.kell) et al.  
It ran from May 2005 to April 2010.

###Metabolomic Pathways

The Manchester Centre for Integrative Systems Biology is in the process of measuring the kinetic and 
   binding constants associated with enzyme reactions in metabolic pathways in the yeast, 
   Saccharomyces cerevisiae. 
Quantitative models of these metabolic pathways are being integrated with transcriptomic, 
   proteomic and metabolomic data by workflows that have been constructed and enacted using Taverna.

###Publications

A [poster](http://www.mygrid.org.uk/files/2008/09/peter-li-poster.pdf) by Peter Li 
   describing the systems biology workflows was presented at the International Conference of Systems Biology 2006 
   and he has written several publications about the work.

Many of the workflows make use of Systems Biology Markup Language 
   ([SBML](http://sbml.org/)) as described in the 
   [paper](http://bioinformatics.oxfordjournals.org/content/24/2/287.full.pdf) 
   *Automated manipulation of systems biology models using libSBML within Taverna workflows* by Li et al.

An example [workflow](http://www.myexperiment.org/workflows/79) using SBML is available on 
   [myExperiment](http://www.myexperiment.org).

<a name="sb-os"></a>
##Systems Biology Operational Software (SB.OS)

[SB.OS](http://www.sbos.eu/doku.php) is a live DVD based on Ubuntu Linux that comes with 
   a comprehensive list of Systems Biology Software. 
Text and video documentation material, 
   as well as an offline copy of the BioModels.net database and Taverna 2.1, are included.

<a name="metware"></a>
##MetWare

The MetWare project provides applications, databases and workflows for metabolomics. 
The MetWare project is a collaboration between several metabolomics groups in the Netherlands and Germany.

The work involving Taverna workflows is done by 
   [Steffen Neumanns group (Bioinformatics &amp; Mass Spectrometry)](http://www.ipb-halle.de/en/research/stress-and-developmental-biology/all-staff/).

They developed a Web-based player of Taverna workflows and also have uploaded their workflows on myExperiment at 
   <http://www.myexperiment.org/users/937/workflows>.

[Software project page](http://sourceforge.net/apps/mediawiki/metware/index.php?title=Main_Page) can be found at Sorceforge.

<a name="tav4sb"></a>
##Tav4SB

[Tav4SB project](http://bioputer.mimuw.edu.pl/tav4sb/) provides a grid environment with a set of Web services, 
   bundled together in Taverna workflows. 
Target application area is the system biology field, 
   in particular analysis of the kinetic models of biological systems.

<a name="ccpn"></a>
##CCPN
                    
**CCPN use of Taverna**
by Rasmus Fogh r.h.fogh@bioc.cam.ac.uk, Feb 2013

[WeNMR](http://www.wenmr.eu/) (Worldwide e-Infrastructure for NMR and structural biology) 
   is a virtual research community project that is funded as part of the 7th EU framework. 
The infrastructure lies within the fields of structural biology, NMR and SAXS. 
Its purpose is twofold: It provides an infrastructure for sharing documentation, outreach and communications.  
It also offers web portals where structural biology programs can be run, supports a grid infrastructure 
   for running associated relevant jobs and provides software that presents programs on the web portals and 
   pipes data between them for uploading and downloading.

Our contribution to the WeNMR project is the development of a dual use Workflow Management System (WMS) as shown in Fig.1. 
Its two methods of use are as a:

 - means to launch, manage, and gather results generated by structural biology calculations, 
      making use of programs present on the WeNMR portals, 
      in effect to serve as an entry port for WeNMR and associated calculations in general.

 - data tracking, management and access control system for structural biology laboratories.

![CCPN Use of Taverna](/img/CCPNuse.png)

<p align="center">Fig. 1</p>

Taverna is being used to encapsulate and combine protocols on our system, 
   so that the systems are available to, and can be combined with, 
   workflow components from other sources, 
   and to combine different protocols on our system into pipelines. 
The current test project is to develop a system to run four different structure calculation programs 
   from a single job start specification and collating the results into a single combined data source.

Whether Taverna is being used in a scientific role is down to the definition of its role within the project. 
We are developing scientific software, 
   which will be used to perform actual scientific research and analysis by end users – 
   we tend to categorise our role as that of methods developers for structural biology. 
Whether that categorises the role as computer science, structural biology, 
   or software engineering depends on the point of view.

The *methods* are established programs for calculating (mainly) macromolecular structures 
   from Nuclear Magnetic Resonance data, and are therefore used as the primary process for obtaining results. 
These types of calculation require the use of several different programs, sequentially, to process them. 
Passing the data and results from one program to another has been a problem for many years. 
CCPN has long been working on data exchange standards, data conversion software and integration with different programs, 
   and is now working explicitly on setting up pipelines. 
There is an ever-increasing demand for high-throughput calculations that allow the use of alternative programs and 
   that inexperienced users are able to utilise with ease. 
It is to meet these demands that Taverna is being used as a tool that enables the setup of flexible, 
   easy-to-use pipelines.

About me:

I am currently working at the University of Cambridge, Department of Biochemistry, 
   under Professor Ernest Laue. 
As part of my role I am attached to the [CCPN project](http://www.ccpn.ac.uk/), 
   led by Professor Vuister (University of Leicester), formerly led by Professor Laue.

<a name="planet"></a>
##PLANET

As part of the [PLANET](http://www.eu-plant-genome.net/) (A Network of European Plant Databases) project, 
   [URGI](http://www.breedwheat.fr/institutions.php?id=6) 
   (Unité de Recherche Génomique-Info) developed BioFloWeb.

BioFloWeb is a stand-alone Web application processing Web services. 
A given user can choose among predefined workflows or define their own with Taverna. 
BioFloWeb has been [demonstrated](http://biofloweb.sourceforge.net/) 
   for retrieval of information about Arabidopsis genes from several European databases.

BioFloWeb makes extensive use of [BioMoby](/introduction/taverna-in-use/annotation#adoption-by-moby) services.

