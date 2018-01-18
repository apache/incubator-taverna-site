Title:     Download
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

## Which Taverna to download?

Many, but not all, of the original Taverna tools have been migrated to Apache Taverna. 
(Taverna was started in 2001 by the [myGrid project](http://www.esciencelab.org.uk/about/#history) and in 2014 entered incubation 
at the [Apache Software Foundation](http://incubator.apache.org/).) 

Links to Pre-Apache versions are provided for tools that have yet to be migrated. See below for links to complete
<a href="#pre-Apache">earlier Taverna releases</a> as well as a list of Taverna 2.x tools that are 
<a href="#no-migration">not planned for migration</a>.


### Tools
There are several Taverna tools you can download:

- [Apache Taverna Command-line Tool](/download/commandline) enables you to run
  workflows from a command prompt.
  This enables scripted execution of workflows, e.g. on a Linux server.

- [Apache Taverna Server](/download/server) provides a REST and WSDL web service 
  for executing Taverna workflows remotely and integrating workflow execution
  into web applications.

- Pre-Apache Taverna (2.x)
    - [Taverna Workbench](/download/workbench) enables you to graphically create, edit and
   run workflows on your computer.
   Taverna 2.5 Workbench (non-Apache) is the latest series of the Workbench;
   it is highly recommended that you use this version if you are new to Taverna.

    - [Taverna Plugins](/documentation/plugins) - because the design of Taverna is modular,
 various plugins can be added to increase its functionality.

### Taverna libraries

The Taverna Command-line, Workbench, and Server share several Java libraries
for constructing and executing workflows. These libraries can be downloaded
separately for development usage:

- [Apache Taverna Language](/download/language) gives programmatic access to
 inspecting, modifying and converting Taverna's
 [SCUFL2](/documentation/scufl2/) workflow definitions and
 [Research Object Bundles](https://w3id.org/bundle).

- [Apache Taverna OSGi](/download/osgi) is a generic plugin system for Java-based
 console/desktop applications using OSGi, including an online update mechanism.

- [Apache Taverna Engine](/download/engine) is the API for the _workflow engine_
  that executes workflows defined with _Taverna Language_.

- [Apache Taverna Common Activities](/download/common-activities) are plugins
  for the _Taverna Engine_ that provide implementations to invoke local and
  remote tools and web services.

- [Apache Taverna Maven Parent](https://repo1.maven.org/maven2/org/apache/taverna/apache-taverna-parent/) 
  provides common Maven build settings for the rest of the Taverna source code.
  You would only need this if your build system is unable to contact Maven Central.



## Source code

You might be interested in the [source code](/download/code) of Apache Taverna, or
[earlier non-Apache releases](pre-apache). Unreleased tools that are under development
include the [Apache Taverna Databundle Viewer](https://github.com/apache/incubator-taverna-databundle-viewer) web app
and the Android app: [Apache Taverna Mobile](https://github.com/apache/incubator-taverna-mobile).


## License

Apache Taverna is distributed under the [Apache Software License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
See the `NOTICE` file in the source code downloads for required attributions,
and the `LICENSE` file for details of any embedded third-party source code.

Dependencies of Taverna are
[compatible with Apache License 2.0](http://www.apache.org/legal/resolved.html)
according to Apache Software Foundation policies.


<a name=no-migration></a>
## Pre-Apache tools
There are a number of third-party tools available to use with Taverna 2.

> **Note**: There are currently **no plans to release Apache Taverna 3
> versions** of these tools. If you are interested in migrating any of these tools
> to Apache Taverna, please [contact us](/community).

 - [Taverna 2-Galaxy](http://www.taverna.org.uk/download/taverna-galaxy/) is a tool for automatic generation and exposure of
   Taverna workflows as [Galaxy](http://galaxy.psu.edu/) tools.
   Galaxy is an open, Web-based platform for data intensive biomedical research.
 - [DataViewer Tool](http://www.taverna.org.uk/download/associated-tools/dataviewer-tool/)
 - [API Consumer Tool](http://www.taverna.org.uk/download/associated-tools/api-consumer-tool)
 - [Interaction Service](http://dev.mygrid.org.uk/wiki/display/taverna/Interaction+service)
 - [Web service Data Proxy](http://www.taverna.org.uk/download/associated-tools/webservice-data-proxy)
 - [Workflow Monitor](http://www.taverna.org.uk/download/associated-tools/workflow-monitor)
 - [Seahawk Applet](http://www.taverna.org.uk/download/associated-tools/seahawk-applet/)
 - [Taverna Player portal](https://github.com/myGrid/taverna-player-portal)
 - [taverna-t2flow Ruby gem](https://rubygems.org/gems/taverna-t2flow/)

<a name=pre-Apache></a>
## Pre-Apache Taverna releases

Taverna releases from 2001 to 2014 (e.g. Taverna 2.5) were made before Apache incubation:

 - [Earlier non-Apache releases](/download/pre-apache)

Note that Taverna releases pre-Apache were licensed as [LGPL 2.1](http://www.gnu.org/licenses/old-licenses/lgpl-2.1.en.html).
