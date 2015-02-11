Title:     Taverna Player
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

The Taverna Player is a Web-based interface (implemented as Ruby on Rails plugin) for executing 
  existing workflows through the [Taverna Server](/documentation/server). 
It can be considered analogous to playing videos on [YouTube](http://www.youtube.com). 
Workflows can be run with data supplied by the creator, or with new data uploaded by the user, 
   but the workflows themselves cannot be altered.

Taverna Player enables the running of Taverna workflows within a Ruby-on-Rails application. 
Taverna Player has a REST API that allows inputs to the workflow to be specified, 
   a run to be started and monitored, and the resultant outputs to be retrieved. 
Any interactions the workflow includes are presented to the user in a Web browser for them to 
  complete. 
Taverna Player has been released in the RubyGems registry and is used within the 
   [BioVeL Portal](http://www.biovel.eu/) to run a wide range of biodiversity workflows.

Taverna Player is not limited to the biodiversity domain – it is generic and can be used to run 
   any Taverna workflow and can be integrated into various online environments - for example it 
   can be embedded into (static) HTML pages to run specific workflows with pre-defined data.

For more information on Taverna Player or to download it, please see the following:

 - Package (Ruby on Rails plugin): <https://rubygems.org/gems/taverna-player>
 - Documentation: <http://mygrid.github.io/taverna-player/>
 - Source: <https://github.com/myGrid/taverna-player>
 - Metrics: <https://codeclimate.com/github/myGrid/taverna-player>

##Integration of Taverna Player into Web apps

###BioVeL Portal

[BioVeL](http://www.biovel.eu/) provides workflows for the processing of data in major areas of 
   biodiversity research: ecological niche modelling, ecosystem functioning, and taxonomy. 
Taverna Player has been successfully used within the [BioVeL Portal](https://portal.biovel.eu/)
   to submit and run a wide range of biodiversity workflows using the 
   [Taverna Server](/documentation/server).

###Scratchpads

[Scratchpads](http://scratchpads.eu/), developed as part of the [ViBRANT](http://vbrant.eu/) 
   project, are  online virtual research environments for biodiversity, allowing anyone to 
   share their data and create their own research networks. 
Sites are hosted at the Natural History Museum London, and offered freely to any scientist.

Taverna Player has been integrated with Scratchpads in two ways. 
Firstly, workflows can be embedded in a page in the same way as a video from YouTube would be 
  embedded; the workflow itself is running on the BioVeL Portal, but all data entry and 
  user-interaction is done in the embedded widget within the Scratchpads site. 
Secondly, the Scratchpads can use the Taverna Player REST API directly; 
   this allows workflows to be run with a higher degree of control and results to be ingested 
   back into the Scratchpads for further analysis. 
In both cases, data can be automatically injected into the workflow run from the host 
   Scratchpads site. 
The actual execution of the workflow is done by the Taverna Server - 
   the Player just interacts with the Server to submit a workflow for execution, 
   monitor its progress and fetch results.

Read more about 
   [Scratchpads integration](http://dev.mygrid.org.uk/wiki/display/TavernaStrategy/Scratchpads) 
   and see relevant publications.

###IPython Notebook

[IPython Notebook](http://ipython.org/) is a browser-based environment for interactive 
   computing. 
Users can write, edit and replay Python scripts. 
IPython Notebook has support for interactive data visualization and report presentation. 
A Notebook can be saved and shared. 
Notebooks can be replayed using the same or different data. 
The record of a Notebook “run” can be saved and displayed in a 
   [Notebook Viewer](http://nbviewer.ipython.org/).

Taverna Player, through its API and and the use of HTML iframes, enables the running of 
   workflows within a portal like the BioVeL Portal to be included as part of another Web site. 
It uses the REST API of the Taverna Player to allow workflow inputs to be specified, 
   a run started and monitored, and the resultant outputs retrieved - all within the IPython 
   Notebook.

Read more about 
   [IPython Notebook integration](http://dev.mygrid.org.uk/wiki/display/TavernaStrategy/IPython+Notebook)
   and see relevant publications.
