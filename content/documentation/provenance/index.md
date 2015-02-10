Title:     Provenance management
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

> Provenance is information about entities, activities, and people
> involved in producing a piece of data or thing, which can be used to
> form assessments about its quality, reliability or trustworthiness.  
- <small><a href="http://www.w3.org/TR/prov-overview/">W3C PROV-Overview</a>*</small>

For a scientific workflow system, provenance can have several aspects:

1. Provenance of the workflow definition
2. Provenance of a workflow run
3. Provenance of data

##Provenance of workflow definitions

Taverna does not capture provenance of editing a *workflow definition*, 
   but assume the scientist manages the evolution of workflow definitions through existing 
   means for versioning files, such as filenames and folders, 
   version control systems like [git](https://help.github.com/articles/set-up-git), 
   or workflow sharing websites like [myExperiment](http://www.myexperiment.org/).

Within Taverna, a 
   [workflow can be annotated](http://dev.mygrid.org.uk/wiki/display/taverna/Annotations) 
   to give *attribution* to the **Authors** of a workflow (or nested workflow). 
We recommend using comma or linefeed for multiple authors.

Taverna's workflow fileformat has an internal workflow identifier (UUID) which is updated for 
   every workflow change. 
A log of previous workflow identifiers is included within the workflow definition formats 
   [t2flow](http://taverna.googlecode.com/svn/taverna/dev/xsd/trunk/t2flow/t2flow.xsd) and 
   [Taverna 3 workflow bundle](http://dev.mygrid.org.uk/wiki/display/developer/Taverna+Workflow+Bundle),
   allowing 
   [detection of workflows with common ancestry](http://www.myexperiment.org/workflows/2899)>. 

##Provenance of workflow runs

Taverna can 
   [capture provenance of workflow runs](http://dev.mygrid.org.uk/wiki/display/taverna/Data+and+provenance+preferences),
   including individual processor iterations and their inputs and outputs. 
This provenance is kept in an internal database, 
   which is used to populate *Previous runs* and *Intermediate results* in the 
   [Results perspective](http://dev.mygrid.org.uk/wiki/display/taverna/Result+Perspective) 
   in the Taverna Workbench.

The provenance trace can be used by the 
   [Taverna-PROV plugin](https://github.com/wf4ever/taverna-prov)
   to export the workflow run, including the output and intermediate values, 
   and the provenance trace as a [PROV-O](http://www.w3.org/TR/prov-o/) RDF graph which can 
   be queried using [SPARQL](http://www.w3.org/TR/sparql11-overview/) and processed with other 
   PROV tools, such as the [PROV Toolbox](https://github.com/lucmoreau/ProvToolbox/).

We are planning to extend myExperiment to handle uploading of such provenance traces, 
   which would give a mechanism to present and browse values and details of a workflow runs 
   within the browser.

This [presentation about Taverna's provenance support](http://www.slideshare.net/soilandreyes/20130529-taverna-provenance)
   gives an overview of the model and software architecture.

##Provenance of data

Scientists using Taverna to perform analysis are often less concerned about the detailed provenance of a workflow run, which semantically just describes inputs and outputs to a chain of processes, but are rather interested in *derivation* and *attribution* of the data that is involved in a workflow. For instance, a workflow might be performing text-mining on a biomedical article to extract gene names, and then retrieve the genome sequences for those genes by looking up in a database. The sequences can then be said to be derived from that database and should (according to the license of the web service) also be attributed to its maintainers. The *list* of sequences can be said to be derived from the biomedical article.

The typical world of Taverna workflows is to combine web services &#8220;in the wild&#8221; (say found on <a href="">http://www.biocatalogue.org/</a> BioCatalogue) with local tools. Neither of these will typical have any facility to provide such &#8220;science-level provenance&#8221;. myGrid is planning a facility for such data provenance in different ways:

1. Merging and propagation of [PROV-AQ](http://www.w3.org/TR/prov-aq/) provided provenance 
     traces for [REST services](http://dev.mygrid.org.uk/wiki/display/taverna/REST) 
     (including matching data identity) -- “white-box service”
2. A provenance “backchannel” for [Components](developers/work-in-progress/components/), 
     which can be populated either by the underlying service directly or by shims within the 
     component. 
   This allows higher level provenance that is meaningful for a set of components instead of 
     service-specific execution details.
3. Annotation of workflow fragments by 
     [common motifs](http://www.slideshare.net/dgarijo/common-motifs-in-scientific-workflows-an-empirical-analysis),
     which can provide higher-level provenance for data generated by the workflow

The paper [Enhancing and Abstracting Scientific Workflow Provenance for Data 
     Publishing](http://www.edbt.org/Proceedings/2013-Genova/papers/workshops/a45-alper.pdf)
     (doi [10.1145/2457317.2457370](http://dx.doi.org/10.1145/2457317.2457370)) details these 
     approaches.

##Collaborations

myGrid actively participated in the 
   [W3C Provenance Working Group](http://www.w3.org/2011/prov/wiki/Main_Page)
   which developed the [PROV family of standards](http://www.w3.org/TR/prov-overview/). 
The [Taverna-PROV plugin](https://github.com/wf4ever/taverna-prov) has been developed for 
   Taverna that allows the export of workflow run provenance as 
   [PROV-O RDF](http://www.w3.org/TR/prov-o/).

The [wf4ever project](http://www.wf4ever-project.org) is investigating the sharing of workflows 
   and workflow runs as [research objects](http://www.researchobject.org/), in particular for 
   Taverna is the development of the [Research Object Bundle](https://w3id.org/bundle), 
   which will form a single archive of a workflow run, including run *provenance*, *inputs*, 
   *outputs*, *intermediate values*, *workflow definition* and (for Taverna 3) 
   information about the *run environment*.

##Past collaborations

Since early 2010, we are invited partners of the [NSF DataONE project](https://dataone.org/), 
   dedicated to large-scale preservation of scientific data, and founding members of the 
   Worklow and Provenance Working Group promoted by the project, along with Prof. Ludaescher 
   at UC Davis, USA  and Juliana Freire at University of Utah, USA.

Historically, work on provenance within the myGrid consortium and Taverna team has been 
   focusing on multiple aspects, beginning with the design and implementation of *Janus*, 
   a data model and software component for provenance capture and analysis for Taverna. 
Our research in this area is often pursued in collaboration with external partners:

 - A model and architecture for capturing provenance. 
     We have designed a data model for *Janus* that is at the same time specific to Taverna, 
     but can also be exported to other models, 
     notably the [Open Provenance Model](http://openprovenance.org/) (OPM), 
     to enable interoperability with third party provenance-generating systems. 
   Taverna has been retrofitted with provenance generation capabilities.
 - An expressive provenance query language and efficient query processing model for large 
     provenance graphs.
 - Investigation into provenance interoperability and exchange, using the OPM. 
   The Taverna provenance component now exports data as OPM graphs, 
     and can also import OPM graphs (with basic features) received from third parties.  
   We have also been working with the Kepler group on a project to promote provenance 
     interoperability, in collaboration with Prof. Ludaescher at UC Davis, CA, and 
     Ilkay Antintas at UCSD, CA .
 - Investigation into the role of semantics and of Linked Open Data (LOD) in provenance 
     modelling and management,  in collaboration with the Knoesis Centre at Wright University, 
     Ohio (Prof. Amit Sheth, Dr. Satya Sahoo) and with Jun Zhao of Oxford University.

Other past collaborations on the topic of provenance include:

 - Participation in the 
   [Third Provenance Challenge](http://twiki.ipaw.info/bin/view/Challenge/ThirdProvenanceChallenge)

 - [The Semantic Provenance project](http://www.mygrid.org.uk/projects/semantic-provenance-project/),
   with Ely Lilly and IU

