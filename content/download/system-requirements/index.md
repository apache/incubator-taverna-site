Title:     System requirements
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

<div class="alert alert-info" role="alert"><p><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
Taverna is transitioning to the Apache Incubator.
Currently there is no Apache-approved distribution.
</div>

## Operating system

Taverna [Workbench](/download/workbench) and [Command Line](/download/commandline)
  are available in either platform-specific or platform-neutral distributions.
We generally **recommend** the platform-specific distributions as they include any required
   third-party software.

**Platform-specific** distributions are available for <small>(and tested on)</small>:

 - Windows 64-bit (.exe installer) <small>(7, 8, 8.1)</small>
 - Windows 32-bit (.exe installer) <small>(7)</small>
 - Mac OS X 64-bit (.dmg disk image) <small>(10.8, 10.9)</small>
 - Linux 64-bit Debian-based (.deb package) <small>(Ubuntu 12.04.4, Bio-Linux 7)</small>
 - Linux 64-bit Redhat-based (.rpm package) <small>(Fedora 20)</small>

**Platform-neutral** distributions are available as:

 - Zip file

The platform-neutral distribution has [additional system requirements](#standalone).

### Linux: libgnome

If you want to use the
   [Interaction service](http://dev.mygrid.org.uk/wiki/display/taverna/Interaction+service)
   from Taverna, for some versions of Linux it may be necessary to install the **libgnome-2.0**
   package or equivalent.
This library allows Taverna to open pages in your preferred Web browser and
   connect to the interactive service being called from the workflow.

## Memory

It is a good idea for your machine to have **at least 2GB of RAM.**
Taverna will run with less memory, but its performance may be affected.

The Taverna Workbench installations for 64-bit operating systems will use by default up to
1 GB of working memory, plus up to 400 MB used by the Java runtime.
Installations for 32-bit operating systems and platform-independent installations will
use up to 700 MB of working memory, plus up to 200 MB used by Java runtime.

### Reduce memory usage
 If Taverna runs out of memory while running a workflow with
 large data or large amounts of data, you can set Taverna to store data
 in a database by going to **Preferences -> Data and Provenance** and
 removing the tick for **“In-memory storage.”**
 Using a database will slightly reduce execution speed, but should consume less memory.
 Also remember to remove any old runs you are no longer interested in.
 
 [User guide: Data and provenance preferences](http://www.mygrid.org.uk/dev/wiki/display/taverna/Data+and+provenance+preferences)
 has more details on the data settings in Taverna.

### Increase available memory
If you need to increase the available memory, for **Windows and Linux**, edit the
  *taverna.vmoptions* (and *executeworkflow.vmoptions*) file inside Taverna's installation
  directory (which might require administrator privileges).
You can then replace *-Xmx700m* or *-Xmx1g* with (for example) *-Xmx1500m* to use 1.5 GB.

For **OS X**, modify the *Info.plist* file and change the same
   parameter under JavaVM using the *Property List Editor*.
   (To modify *Info.plist*, right-click on Taverna application in Finder and select *Show Package Content*.
   Then, open the application bundle to find *Contents/Info.plist*.) 

For **platform-neutral** Taverna installations not using *.vmoptions*, you may instead have to
   modify the *taverna.sh/taverna.bat* (Windows) and *executeworkflow.bat/executeworkflow.sh* files.

[User guide: Memory allocation](http://dev.mygrid.org.uk/wiki/display/taverna/Memory+allocation)
   has more details on configuring memory allocation.

<a name=standalone></a>
## Taverna Standalone requirements

Java and Graphviz are included in the platform-specific downloads but not in the zip downloads.

### Java

If you download a platform-neutral Taverna installation, you will need to install Java 8 or
   higher.

For Oracle's Java 8, you will also need to install the
   [Java Cryptography Extension](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html)
   separately.

For [OpenJDK 8](http://openjdk.java.net/), the Java Cryptography Extension is already included.
   On Linux, *apt-get install openjdk-7-jdk*, or equivalent, is usually sufficient.

>On newer versions of **Mac OS X**, Taverna Workbench might need the
   [XQuarts](http://xquartz.macosforge.org/landing/) shared X11 libraries to be installed.

### GraphViz

If you download the platform-neutral Taverna Workbench installation,
   it includes binaries of the Graphviz tool,
   which is used for **generating workflow diagrams** in Taverna.
Binaries are included in the *bin* folder for OS X, Linux x86/x64, and Windows.

In most cases, Taverna should be able to pick up the location of the Graphviz binary *dot*
   from the download after you have installed it.
If this is not the case, see
   [User guide: Workbench preferences](http://www.mygrid.org.uk/dev/wiki/display/taverna/Workbench+preferences)
   on how to configure the location of *dot* executable in Taverna Workbench.
