Title:     Apache Taverna source code and APIs
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

Apache Taverna's source code is hosted at [git.apache.org](http://git.apache.org/), with read-only mirroring to 
[GitHub](https://github.com/apache/?query=taverna-).

[TOC]

### Checking out Apache Taverna

If you are a committer on Apache Taverna, or have firewall restrictions, select `[Apache Committer]` below, e.g.:

    git clone https://git-wip-us.apache.org/repos/asf/incubator-taverna-*****.git

To check out Apache Taverna anonymously, select `[Apache git]` below, e.g.:

    git clone git://git.apache.org/incubator-taverna-****.git

To check out Apache Taverna on github, select `[Github]` below, e.g.:

    git clone https://github.com/apache/incubator-taverna-****.git

You can also `[Browse]` the code through the GitHub mirrors. 
Using GitHub you are free to *fork* the projects and raise *pull requests* to 
[contribute to Apache Taverna](#contribute-to-apache-taverna).


## Source code repositories


<select id="picker" onChange='check()'>
  <option value="Apache Committer">Apache Committer</option>
  <option value="Apache git">Apache git</option>
  <option value="Github">Github</option>
</select>
Click on the textbox and copy the value.

The <strong>Apache Taverna</strong> source code is organized into multiple [git](http://www.git-scm.com/) repositories:

<table class="table table-hover">
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-maven-parent">incubator-taverna-maven-parent</a></td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-maven-parent"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-maven-parent">Browse</a></td>
  <td>Common Maven parent for the below</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-language">incubator-taverna-language</a></td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-language"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-language">Browse</a></td>
  <td>API for workflow definitions (SCUFL2) and workflow inputs/outputs (DataBundle)</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-osgi">incubator-taverna-osgi</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-osgi"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-osgi">Browse</a></td>
  <td>OSGi-based plugin system</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-engine">incubator-taverna-engine</a> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-engine"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-engine">Browse</a>
  <td>Taverna workflow engine</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-common-activities">incubator-taverna-common-activities</a></td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-common-activities"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-common-activities">Browse</a></td>
  <td>Common activity implementation for engine (e.g. WSDL, REST, Tool, Interaction)</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-commandline">incubator-taverna-commandline</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-commandline"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
 <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-commandline">Browse</a></td>
  <td>Command line for running Taverna workflows</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-server">incubator-taverna-server</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-server"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-server">Browse</a></td>
  <td>A REST and WSDL service for running Taverna workflows</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-workbench">incubator-taverna-workbench</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-workbench"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-workbench">Browse</a></td>
  <td>Graphical workbench for editing and running Taverna workflows</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-workbench-common-activities">incubator-taverna-workbench-common-activities</a></td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-workbench-common-activities"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-workbench-common-activities">Browse</a></td> 
  <td>Common activities UI (discovery+configuration for Workbench</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-workbench-product">incubator-taverna-workbench-product</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-workbench-product"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-workbench-product">Browse</a></td>
  <td>Distribution of Taverna Workbench</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-plugin-component">incubator-taverna-plugin-component</a></td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-plugin-component"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-plugin-component">Browse</a></td> 
  <td>Plugin for component activity and registry</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-plugin-bioinformatics">incubator-taverna-plugin-bioinformatics</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-plugin-bioinformatics"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-plugin-bioinformatics">Browse</a></td>
  <td>Plugin for bioinformatics-specific activities</td>
</tr>

<tr>
  <td><a href="https://github.com/apache/incubator-taverna-databundle-viewer">incubator-taverna-databundle-viewer</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-databundle-viewer"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-databundle-viewer">Browse</a></td>
  <td>Web-based Data Bundle viewer (GSOC2015 project)</td>
</tr>
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-mobile">incubator-taverna-mobile</a></td> 
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-mobile"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="btn btn-primary" href="https://github.com/apache/incubator-taverna-mobile">Browse</a></td>
  <td>Android app for running Taverna workflows remotely (GSOC2015 project)</td>
</tr>
</table>

<div class="alert alert-warning" role="alert"><p><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
  <strong>Note:</strong>
The source code above is for Apache Taverna 3.
The <a href="https://github.com/taverna/">source code for Taverna 2</a> 
remains available separately, but is not maintained by the Apache Taverna project.
</div>

## Building Apache Taverna

You need [Apache Maven 3.2](https://maven.apache.org/download.html) or newer to build Taverna. 
To build a checked out repository:

    mvn clean install

If you want to skip tests (these can be time-consuming):

    mvn clean install -DskipTests

If you get license header warnings from the 
[Apache RAT plugin](https://creadur.apache.org/rat/apache-rat-plugin/), 
and you are not a committer (who should fix those before a release),
you can skip these checks with:

    mvn clean install -Drat.skip=true

The build order is roughly the order of the above list, but as regular 
[snapshots](#snapshot-builds) are picked up from the snapshot repository, 
usually you only need to build the modules you have changed. 
Note that a repository might depend on a released version of an upstream Taverna
repository, so if you want to be sure that a build picks up the `SNAPSHOT` version 
you built instead, check the `<properties>` section within the `pom.xml`.


## Contribute to Apache Taverna

### Patches
**Patches welcome!** Apache Taverna is a volunteer project, and we rely on the community to help
improve the code base. Anyone can suggest a change to Apache Taverna, not just the existing [committers](/about/).

For many developers, the easiest method is to **Fork** the corresponding repository on *GitHub*, and submit the suggested 
changes as a **Pull request**. The pull request is automatically forwarded to the 
[dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/) mailing list. Subscribe to this mailing list to receive feedback for your patch.

Alternatively, you may checkout directly from the repositories above,
use [git format-patch](https://www.kernel.org/pub/software/scm/git/docs/git-format-patch.html), 
and send your patches to the [dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/)
mailing list after subscribing. Note that large patch files might not be accepted by
the mailing list software.

For larger contributions, we might ask you to sign a 
[Contributor License Agreement](https://www.apache.org/licenses/#clas) (CLA) to grant a license to 
the Apache Software Foundation that covers your contribution. 

For any questions about using or modifying the Apache Taverna source code and APIs, 
please subscribe to and contact the [dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/) mailing list.

### Bug Fixes

Use the Apache Taverna JIRA [issue tracker](/community/jira.md) to **report or track a bug.** 

## Snapshot builds

A corresponding set of [automatic Jenkins builds for Apache Taverna](https://builds.apache.org/user/stain/my-views/view/taverna/) deploy to  [Apache's snapshot Maven repository](http://repository.apache.org/snapshots/org/apache/taverna/)
based on the latest `master` branch of each repository (updated every ~7 minute).

Note that the snapshot builds are *not* official releases and should be considered unstable.

To use the snapshot repository, add to your Maven pom.xml:

    <repositories>
      <repository>
        <id>apache.snapshots</id>
        <name>Apache Snapshot Repository</name>
        <url>http://repository.apache.org/snapshots</url>
        <releases>
          <enabled>false</enabled>
        </releases>
      </repository>
    </repositories>

This means that as a developer, you only need to build the repositories you are modifying, as the remaining modules will be retrieved from the Maven repository. 

You will however always need to build the distribution product (command line or workbench) to incorporate your changes. (Make sure that references the correct <code>SNAPSHOT</code> version!)




## Taverna Extras

The separate GitHub group [taverna-extras](https://github.com/taverna-extras) host independent community-submitted plugins for Apache Taverna. 
Unlike Apache Taverna, the taverna-extras include plugins covered by the licenses [LGPL](https://www.gnu.org/licenses/lgpl.html) and [GPL](https://www.gnu.org/licenses/gpl.html).
Note that the taverna-extras are not affiliated with or released by Apache Taverna, although you may recognize many of the same committers.

Some plugins that were previously part of Taverna 2 have or will migrate to taverna-extras due to [licensing incompatibility](http://dev.mygrid.org.uk/wiki/display/developer/Third-party+licenses). This includes:

* RShell activity
* [Table activity](https://github.com/taverna-extras/table-activity)

<script>
function check() {
   var x = document.getElementsByClassName("gitlink");
   var i;
   if ( document.getElementById("picker").value == "Apache Committer"){
      for (i = 0; i < x.length; i++) {
         x[i].value = "https://git-wip-us.apache.org/repos/asf/" +x[i].id + ".git";
      }
   }
   if ( document.getElementById("picker").value == "Apache git"){
      for (i = 0; i < x.length; i++) {
         x[i].value = "git://git.apache.org/" +x[i].id + ".git";
      }
      
   }
   if ( document.getElementById("picker").value == "Github"){
      for (i = 0; i < x.length; i++) {
        x[i].value = "https://github.com/apache/" +x[i].id + ".git";
      }
   }
}
check ();
</script>





