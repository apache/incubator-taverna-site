Title:     Plugins
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

## Overview
Taverna's modular design allows various plugins to be added, increasing its functionality.
In Taverna 2, plugins are specific to versions of Taverna.
We are hoping to change this in future, when we move to the [OSGi](http://www.osgi.org/)
   platform (see our [Roadmap](/introduction/roadmap) for details).

Several different plugins can connect with Taverna.
Of most interest are plugins that enable search and invocation of a specific service type from
   worflows. One example would be a Web service plugin that enables adding a Web service, based on its
   WSDL description document, and invoking it from a workflow.

## Installing plugins

To install a plugin for Taverna, use the *Plugin Manager* - it can be found under
  *Updates and plugins* from the *Advanced* menu.
If your plugin is not visible, select ‘Find New Plugins’.
You may need to add the plugin site using ‘Add Plugin Site’ for specific plugins.
Check the box for the plugin and click install.
You may need to restart Taverna for the plugin to become visible and fully functional.

## Available plugins

Various plugins for Taverna 2 have been developed by us or by third parties in collaboration
  with the Taverna team:

 - [AstroTaverna](#astrotaverna) plugin
 - [OAuth](#oauth) plugin
 - [Taverna PROV](#taverna-prov) plugin
 - [VAMDC](#vamdc) plugin
 - [BIFI](#bifi) plugin
 - [VPH-Share](#vphshare) plugin
 - [Interaction](#interaction) plugin
 - [XPath](#xpath) plugin
 - [REST](#rest) plugin
 - [BioCatalogue](#biocatalogue_plugin) plugin
 - [PBS](#pbs) plugin
 - [SADI](#sadi_plugin) plugin
 - [External Tools](#usecase_plugin) (UseCase) plugin
 - [UNICORE plugin](#unicore)
 - [CDK](#cdk) plugin
 - [caGrid](#cagrid_plugin) plugin
 - [XWS plugin](#xws)
 - [gLite plugin](#glite)

## Plugin descriptions
<a name="astrotaverna"></a>
### AstroTaverna plugin

*Available for Taverna 2.4, 2.5, included in
   [Taverna Workbench Astronomy 2.5](http://www.taverna.org.uk/download/workbench/2-5/astronomy/)*.

[AstroTaverna](http://amiga.iaa.es/p/290-astrotaverna.htm) is a plugin that enables the
   building of astronomy workflows using [Virtual Observatory](http://www.ivoa.net/) services
   discovery and efficient manipulation of
   [VOTable](http://www.ivoa.net/documents/VOTable/)s .
It integrates [SAMP](http://www.ivoa.net/documents/SAMP/) - enabled software,
   allowing data exchange and communication among local VO tools,
   as well as the ability to execute [Aladin](http://aladin.u-strasbg.fr/) scripts and macros.
AstroTaverna was developed by the [Wf4Ever](http://www.wf4ever-project.org/) and
   [CANUBE](http://amiga.iaa.es/p/294-open-science-canube.htm) projects by
   [IAA Amiga](http://amiga.iaa.es/) group and the [myGrid group](http://www.mygrid.org.uk/)
   at University of Manchester.

<a name="oauth"></a>
### OAuth plugin

*Available for Taverna 2.4 and 2.5.*

The OAuth [plugin](http://dev.mygrid.org.uk/wiki/display/taverna/OAuth+services) allows users
   to call REST services that are protected by [OAuth](http://oauth.net/).
It was developed by Mark Borkum of the University of Southampton.

<a name="taverna-prov"></a>
### Taverna PROV plugin

*Available for Taverna 2.4. Integrated in Taverna 2.5.*

The [Wf4Ever project](http://www.wf4ever-project.org/) further developed the
   [provenance support](/documentation/provenance) in Taverna to export
   [W3C PROV-O](http://www.w3.org/TR/prov-o/) compliant provenance traces.

The plugin is part of Taverna since 2.5. <a href="https://github.com/taverna/taverna-prov">Description and source code</a> are at GitHub.</p>

<a name="vamdc"></a>
### VAMDC plugin

*Available for Taverna 2.2, 2.3, 2.4. Included in
   [Taverna Workbench Astronomy 2.5](http://www.taverna.org.uk/download/workbench/2-5/astronomy/)*.

The [VAMDC](http://www.vamdc.eu/) has created
   [integrated plugins](http://voparis-twiki.obspm.fr/twiki/bin/view/VAMDC/TavernaUserGuide)
   for Taverna Workflow to run XSAMS Queries, and specific VAMDC Codes.
Since Taverna 2.5 the VAMDC plugin is part of the
   [Astronomy edition]((http://www.taverna.org.uk/download/workbench/2-5/astronomy/).

<a name="bifi"></a>
### BIFI (Beautiful Interfaces for Inputs) plugin

*Available for Taverna 2.4.*

The [BIFI (Beautiful Interfaces for Inputs)](http://www.xworx.org/#!bifi-plugin/c1tou) plug-in
   for Taverna Workbench provides a GUI definition language that is used to lay out user
   interfaces and define parameter options for Taverna workflows.
BIFI is also able to submit GUI definition files (GDF) directly to or locate appropriate
   instances from the repository configured.
Moreover, BIFI includes an algorithm used to generate a default user interface if no GDF can be
   found in the repository by making use of the meta-information from process definitions.

<a name="vphshare"></a>
### VPH-Share plugin

*Available for Taverna 2.4 and 2.5.*

The [VPH-Share](http://www.vph-share.eu/) project has developed a
  [plugin]http://www.vph-share.eu/content/vph-share-taverna-plugin) for Taverna that allows the
  usage of any VPH-Share Web Service to be included as services within a Taverna workflow.

The VPH-Share services are run on virtual machines (VM) within a cloud,
   but the VPH-Share Plugin makes this transparent to the users.
VPH-Share manages the handling of VMs, so the user can connect to the available Web Services
   like any other Web Service, without dealing with starting or shutting down the virtual
   machines.
VPH-Share also handles user access control in all steps of the workflow composition and
   execution.

The [VPH-Share Plugin](http://www.vph-share.eu/content/vph-share-taverna-plugin) works with
   Taverna Workbench as well as with Taverna Server.
Planned improvements include allowing web-based composition of workflows with VPH-Share
   services through [Taverna Online](/documentation/online).

This [VPH-Share Plugin](http://www.vph-share.eu/content/vph-share-taverna-plugin) is currently
   under development by the Scientific Software Development Team of
   [CISTIB](http://www.cistib.org/) (Center for Computational Imaging & Simulation Technologies
   in Biomedicine), at [The University of Sheffield](http://www.shef.ac.uk/),
   and can be installed in Taverna by adding the
   [CISTIB Plugin Site](http://repository.cistib.org/nexus/content/repositories/releases/).
You can contact the development team at <ssd.cistib@lists.shef.ac.uk>.

<a name="interaction"></a>
### Interaction plugin

*Available for Taverna 2.4; integrated in Taverna 2.5*  

The Interaction plugin allows users to interact in a web browser within a workflow run using an Interaction service.
The run can be on [Taverna Workbench](/download/workbench) or on a
   [Taverna Server](/documentation/server).
A detailed description of the Interaction service can be found in the online
   [manual](http://dev.mygrid.org.uk/wiki/display/taverna/Interaction+service).

The Interaction service was developed by the [BioVeL project](http://www.biovel.eu).

<a name="xpath"></a>
### XPath plugin

*Available for Taverna 2.2; integrated in Taverna 2.3, 2.4 and 2.5*

XPath plugin provides enhanced support for creating and executing XPath expressions over XML
   data in order to extract specific fragments of the data.
This plugin offers an intuitive and easy-to-use way of creating XPath expressions and does not
   require detailed knowledge of the XPath language - expressions are generated by selection of
   relevant nodes in the tree-like view of the provided example XML data.
Ability to modify automatically-generated XPath expressions and control over namespace handling
   make this a powerful tool.
This plugin was written by Sergejs Aleksejevs.

<a name="rest"></a>
### REST plugin

*Available for Taverna 2.2; integrated in Taverna 2.3, 2.4 and 2.5.*

REST plugin allows users to access remote services via four different types of HTTP requests:
   GET, POST, PUT and DELETE.
Configuration options of the plugin include MIME types of the sent and received data and the
   URL template that can have configurable parameters
   (with an individual input port created for each).
The plugin integrates with the Credential Manager of the Workbench for added convenience when
   accessing secure web services.
This plugin was written by Sergejs Aleksejevs.

<a name="biocatalogue_plugin"></a>
### BioCatalogue plugin

*Available for Taverna 2.1.2, 2.2; integrated in Taverna 2.3, 2.4 and 2.5.*

BioCatalogue plugin alpha for Taverna 2.1.2 allows users to browse services in the
   [BioCatalogue](http://www.biocatalogue.org/) Life Sciences Web Services registry from the
   Workbench and add them to workflows.
Being an alpha, some pieces of functionality have not been fully implemented.
The plugin has been developed by Sergejs Aleksejevs.

The plugin for Taverna 2.2 is still an alpha but several small fixes and improvements have been
   made in this version:

 - Services added to the Service Panel are now saved and re-appear in the Service Panel when
     the Workbench is restarted
 - An option to choose which BioCatalogue instance to work with has been added
     (available from *File* -> *Preferences* -> *BioCatalogue*).
   This means that Taverna can use not only the main instance of BioCatalogue,
     but also other instances (e.g. the [BioDiversity](https://www.biodiversitycatalogue.org/)
     catalogue that is based on the BioCatalogue codebase).
 - The user interface of the tree with Filtering options (in the Filter Services tab of the
      BioCatalogue Perspective) has been fixed - now it looks identical on Windows, Linux and
      Mac OS.
 - Contextual views are not shown for the types of workflow elements that the BioCatalogue does
      not work with.

<a name="pbs"></a>
### PBS plugin

*Available for Taverna 2.2.*

[TavernaPBS](http://cphg.virginia.edu/mackey/projects/sequencing-pipelines/tavernapbs/) plugin
   is developed by the [Mackey Lab](http://obx.cphg.virginia.edu/mackey/),
   Center for Public Health Genomics, University of Virginia, US.
It allows a user to define workflows that can then be run using a computational cluster that
   uses a [PBS](http://en.wikipedia.org/wiki/Portable_Batch_System) (Portable Batch System)
   queuing system.
The workflows represent next generation sequencing analysis pipelines.

To most efficiently make use of their myriad of UNIX command line tools, the project has
   developed a custom [Beanshell](/documentation/glossary/#beanshell) - based library to enable
   workflows composed of UNIX command line invocations.
Furthermore, they have abstracted the command execution such that each step could be executed
   as an independent “job” on a remote high performance computing or grid environment.
By doing so, they have essentially turned Taverna into a distributed workflow “compiler”.

You can download the code from the project's
   [pages at SourceForge](http://sourceforge.net/projects/tavernapbs/).

<a name="sadi_plugin"></a>
### SADI plugin

*Available for Taverna 2.1.2, 2.2.*

[Semantic Automated Discovery and Integration](http://sadiframework.org/content/) (SADI) is a
   set of standards-compliant best practices that simplify interoperability between semantic
   Web services.
The SADI codebase make it easy for people to deploy services that adhere to the SADI framework
   practices.
The SADI plugin allows semantic services to be accessed from Taverna.
The plugin has been developed by David Withers
   (with the support of the
   [Genome Canada Bioinformatics Platform](http://www.gcbioinformatics.ca)).
It requires Java 6.

<a name="usecase_plugin"></a>
### External Tools (UseCase) plugin

*Available for Taverna 2.1.2, 2.2; integrated in Taverna 2.3, 2.4 and 2.5.*

[External Tools (previously UseCase) plugin](http://taverna.nordugrid.org/) that was developed
   for Taverna 1.7 as part of the [KnowARC project](http://www.knowarc.eu/) (previously ARC
   project) has now been updated to work with Taverna 2.x and extended in functionality.
The plugin was originally written by Hajo Krabbenhöft and Steffen Möller and updated to work
   with Taverna 2.2 by Alan Williams.
It allows users to run tools on a grid, or a remote/local machine using grid or ssh
   authentication.  
At the moment a prototype set of tool descriptions is available.
Read more on
   [how to use the plugin](http://www.mygrid.org.uk/dev/wiki/display/developer/Calling+external+commands+from+Taverna).

<a name="unicore"></a>
### UNICORE plugin

*Available for Taverna 2.3*

Sonja Holl of the Distributed Systems and Grid Computing division of the Jülich Supercomputing
   Centre (JSC) in Germany developed a [UNICORE](http://www.unicore.eu/) plugin for Taverna.
   “UNICORE (Uniform Interface to Computing Resources) offers a ready-to-run Grid system and
   makes distributed computing and data resources available in a seamless and secure way.”  
The UNICORE plugin for Taverna enables users to submit jobs from Taverna Workbench to any
   UNICORE resource.

To get access to UNICORE resources from Taverna, the user registers a new UNICORE registry in
   Taverna's [Service Panel](/documentation/glossary/#service_panel).
This UNICORE registry is then queried and the UNICORE services orchestrator returns a list of
   available applications.
The applications are selected from various UNICORE resources, as each installation holds a file
   that describes the available applications, including metadata on the specific resource.

The list of applications is then used in Taverna to display available UNICORE services
   (applications), which can be added as services to Taverna workflows.
The metadata is used to create input and output ports of the specific application/service.
Users can than connect inputs/outputs to other workflow services in the usual manner.

During the worfklow execution, a job description is created and submitted to the UNICORE
   service orchestrator(SO).
Files are being uploaded and stored under a logical filename.
The SO then manages the execution and file transmission.
The status of the submitted job is polled in the background from Taverna.
After the job finished, some files are downloaded, and for further modification,
   only the logical file name is retrieved.

Additionally, the UNICORE services are using Taverna's
   [Credential Manager](/documentation/glossary/#credential_manager) to get access to the
   user's X.509 certificate, which user has to load prior to service invocation,
   along with the other CA's certificates.
The UNICORE services then access the user's certificate and use it for job submission
   (since UNICORE's security concept is based upon grid security and X.509 certificates).

To install the plugin, follow the
   [installation instructions](http://www.mygrid.org.uk/dev/wiki/display/taverna/Finding+plugins)
   from the User Manual and use the following URL when installing the plugin:
   <http://unicore-dev.zam.kfa-juelich.de/taverna/plugins/>.

<a name="cdk"></a>
### CDK plugin

*Available for Taverna 2.2, 2.3.*
<a href="mailto:atruszkowski@gmx.de">Andreas Truszkowski</a> has updated the plugin that the
   [Chemistry Development Kit (CDK) project](/introduction/taverna-in-use/chemistry#chemistry-development-kit/)
   have developed for Taverna 1.7.2, to allow the CDK tools to be used within Taverna 2
   workflows as services.
More information about the plugin is available from their
   [wiki pages](http://cdk-taverna-2.ts-concepts.de/wiki/index.php?title=Main_Page).

See our
   [User Manual pages](http://www.mygrid.org.uk/dev/wiki/display/taverna23/CDK-Taverna+plugin)
   for more information on how to download, install and use the plugin.

<a name="cagrid_plugin"></a>
### caGrid plugin

*Available for Taverna 2.1.2.*

The Taverna team together with the caGrid team have developed the caGrid service discoverer
   plugin for Taverna 2.1.2.
This plugin is used to query caGrid services from the caGrid Index Service.
This allows you to easily find the available caGrid services, add them in Taverna's
   [Service Panel](/documentation/glossary#service_panel) and then invoke them from workflows.
The [documentation](http://wiki.cagrid.org/display/workflow13/Taverna+Users+Guide) for the
   plugin is available on-line, as well as the
   [source code](https://github.com/NCIP/taverna-grid).   
*Note: As of May 2013, this plugin does not install correctly from the caGrid plugin site.
Users are advised to build the plugin from [source code](https://github.com/NCIP/taverna-grid).*

<a name="cagrid_remote_execution_plugin"></a>
### caGrid remote execution plugin

*Available for Taverna 2.1.2.*

The caGrid team have also developed a remote workflow execution service plugin for
   Taverna 2.1.2.
The plugin passes a workflow definition file, including the appropriate inputs,
   to a generic remote caGrid service, where the workflow is then executed.
This is useful in instances where the workflow is long-running and relies on constant access to
   the caGrid to execute properly.
The [documentation](http://wiki.cagrid.org/display/workflow13/Taverna+Users+Guide) for the
   plugin is available on-line, as well as the
   [source code](https://github.com/NCIP/taverna-grid).
*Note: As of May 2013, this plugin does not install correctly from the caGrid plugin site.
Users are advised to build the plugin from [source code](https://github.com/NCIP/taverna-grid).*

<a name="xws"></a>
### XWS plugin

*Available for Taverna 2.0.*

[Egon Willighagen](http://chem-bla-ics.blogspot.com/) then at Uppsala University, Sweden, has
   developed a [plugin](http://github.com/egonw/xws-taverna/tree/master) that allows workflows
   to include XWS (XMPP IO-DATA) cloud services.

<a name="glite"></a>
### gLite plugin

*Available for Taverna 2.0.*

Richard Holland of [Eagle Genomics](http://www.eaglegenomics.com/) while working for
   [Sara Grid](http://grid.sara.nl/) has developed a
   [gLite plugin](https://grid.sara.nl/wiki/index.php/TavernaGrid) that allows workflows to
   include services that run on a grid.
