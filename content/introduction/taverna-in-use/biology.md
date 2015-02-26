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
 - [Systems Biology Operational Software](sb-os) (SB.OS) - 
      a live DVD based on Ubuntu Linux that comes with a comprehensive list of Systems Biology Software (including Taverna)
 - [Tav4SB](#tav4sb) - Taverna workflows for systems biology, 
      in particular for analysis of the kinetic models of biological systems

Taverna is also used for analysis of plant biology:

 - [Automatic Functional Annotation in a distributed Web Service Environment](/introduction/taverna-in-use/annotation#afawe) 
   (AFAWE) – protein prediction and annotation by a tool that calls workflows
 - [PLANET (A Network of European Plant Databases](#planet) – calling of workflows from a portal


<a name="enfin"<a>
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
   [paper](http://www.mygrid.org.uk/outreach/publications/li2007/) 
   *Automated manipulation of systems biology models using libSBML within Taverna workflows* by Li et al.

An example [workflow](http://www.myexperiment.org/workflows/79) using SBML is available on 
   [myExperiment](http://www.myexperiment.org).

<a name="sb-os"></a>
##Systems Biology Operational Software (SB.OS)

[SB.OS](http://www.sbos.eu/doku.php) is a live DVD based on Ubuntu Linux that comes with 
   a comprehensive list of Systems Biology Software. 
Text and video documentation material, 
   as well as an offline copy of the BioModels.net database and Taverna 2.1, are included.

<a name="tav4sb"></a>
##Tav4SB

[Tav4SB project](http://bioputer.mimuw.edu.pl/tav4sb/) provides a grid environment with a set of Web services, 
   bundled together in Taverna workflows. 
Target application area is the system biology field, 
   in particular analysis of the kinetic models of biological systems.

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

