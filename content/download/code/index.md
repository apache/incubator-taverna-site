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

Apache Taverna's source code is hosted at [gitbox.apache.org](https://gitbox.apache.org/), with two-way mirroring with
[GitHub](https://github.com/apache?utf8=%E2%9C%93&q=taverna).

[TOC]

### Checking out Apache Taverna

To check out Apache Taverna from GitHub, select `[GitHub HTTPS]` below, e.g.:

    git clone https://github.com/apache/incubator-taverna-****.git

**Tip**: Taverna [committers](/about) who have linked their ASF accounts on
[GitBox](https://gitbox.apache.org/) may push directly to GitHub, although
the convention is to raise *pull requests* to discuss changes.

If you have a GitHub account with [SSH
keys](https://help.github.com/articles/generating-a-gpg-key/) configured, then
use `[GitHub SSH]` instead.

If you are unable to use GitHub or prefer using ASF's git server, select
`[Apache GitBox]` below, e.g.:

    git clone https://gitbox.apache.org/repos/asf/incubator-taverna-****.git 

**Tip**: Taverna committers can always push to GitBox using ASF credentials.
Changes are synchronized both ways.

If you want to access using the 
[`git://` protocol](https://git-scm.com/book/en/v2/Git-on-the-Server-The-Protocols#_the_git_protocol),
then use `[GitHub git]`. This is typically the fastest way to check out, but
require firewall access to port 9418 and is **not secure**; verify the 
latest commit ID against the _Browse_ button.

You can `[Browse]` the code through GitHub or Apache GitBox below.
Using GitHub you are free to *fork* the projects and raise *pull requests* to
[contribute to Apache Taverna](#contribute-to-apache-taverna), in which 
case you should push changes to your fork instead of the below repository.


## Source code repositories


<select id="picker" onChange='check()'>
  <option value="GitHub">GitHub HTTPS</option>
  <option value="GitHubSSH">GitHub SSH</option>
  <option value="GitHubGit">GitHub git</option>
  <option value="ApacheGitBox">Apache GitBox</option>
</select>
Click on the textbox and copy the value.

The <strong>Apache Taverna</strong> source code is organized into multiple [git](http://www.git-scm.com/) repositories:

<table class="table table-hover">
<tr>
  <td><a href="https://github.com/apache/incubator-taverna-mobile">incubator-taverna-mobile</a>
        <br><a href="https://github.com/apache/incubator-taverna-mobile/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-mobile.svg?maxAge=86400" /></a>  
      <!--
      <a href="https://builds.apache.org/job/incubator-taverna-mobile/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-mobile.svg?maxAge=86400" 
      /></a>
      Use Travis instead: -->
      <a href="https://travis-ci.org/apache/incubator-taverna-mobile"><img src="https://travis-ci.org/apache/incubator-taverna-mobile.svg?branch=master"></a>
        
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-mobile"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-mobile">Browse</a></td>
  <td>Android app for running Taverna workflows remotely</td>
</tr>

<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-maven-parent">incubator-taverna-maven-parent</a>
    <br><a href="https://github.com/apache/incubator-taverna-maven-parent/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-maven-parent.svg?maxAge=86400" /></a>
    <a href="https://builds.apache.org/job/incubator-taverna-maven-parent/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-maven-parent.svg?maxAge=86400" /></a>    

  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-maven-parent"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-maven-parent">Browse</a></td>
  <td>Common Maven parent for the below</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-language">incubator-taverna-language</a>
    <br><a href="https://github.com/apache/incubator-taverna-language/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-language.svg?maxAge=86400" /></a>
    <a href="https://builds.apache.org/job/incubator-taverna-language/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-language.svg?maxAge=86400" /></a>
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-language"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-language">Browse</a></td>
  <td>API for workflow definitions (SCUFL2) and workflow inputs/outputs (DataBundle)</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-osgi">incubator-taverna-osgi</a>
    <br><a href="https://github.com/apache/incubator-taverna-osgi/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-osgi.svg?maxAge=86400" /></a>
    <a href="https://builds.apache.org/job/incubator-taverna-osgi/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-osgi.svg?maxAge=86400" /></a>
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-osgi"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-osgi">Browse</a></td>
  <td>OSGi-based plugin system</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-engine">incubator-taverna-engine</a>
    <br><a href="https://github.com/apache/incubator-taverna-engine/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-engine.svg?maxAge=86400" /></a>
      <a href="https://builds.apache.org/job/incubator-taverna-engine/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-engine.svg?maxAge=86400" /></a>    
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-engine"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-engine">Browse</a>
  <td>Taverna workflow engine</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-common-activities">incubator-taverna-common-activities</a>
    <br><a href="https://github.com/apache/incubator-taverna-common-activities/pulls"><img
        src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-common-activities.svg?maxAge=86400" /></a>
      <a href="https://builds.apache.org/job/incubator-taverna-common-activities/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-common-activities.svg?maxAge=86400" /></a>
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-common-activities"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-common-activities">Browse</a></td>
  <td>Common activity implementation for engine (e.g. WSDL, REST, Tool, Interaction)</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-commandline">incubator-taverna-commandline</a>
    <br><a href="https://github.com/apache/incubator-taverna-commandline/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-commandline.svg?maxAge=86400" /></a>
      <a href="https://builds.apache.org/job/incubator-taverna-commandline/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-commandline.svg?maxAge=86400" /></a>    
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-commandline"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
 <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-commandline">Browse</a></td>
  <td>Command line for running Taverna workflows</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-server">incubator-taverna-server</a>
    <br><a href="https://github.com/apache/incubator-taverna-server/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-server.svg?maxAge=86400" /></a>
      <a href="https://builds.apache.org/job/incubator-taverna-server/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-server.svg?maxAge=86400" /></a>
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-server"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-server">Browse</a></td>
  <td>A REST and WSDL service for running Taverna workflows</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-workbench">incubator-taverna-workbench</a>
    <br><a href="https://github.com/apache/incubator-taverna-workbench/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-workbench.svg?maxAge=86400" /></a>
      <a href="https://builds.apache.org/job/incubator-taverna-workbench/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-workbench.svg?maxAge=86400" /></a>

  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-workbench"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-workbench">Browse</a></td>
  <td>Graphical workbench for editing and running Taverna workflows</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-workbench-common-activities">incubator-taverna-workbench-common-activities</a>
    <br><a href="https://github.com/apache/incubator-taverna-workbench-common-activities/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-workbench-common-activities.svg?maxAge=86400" /></a>
      <a href="https://builds.apache.org/job/incubator-taverna-workbench-common-activities/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-workbench-common-activities.svg?maxAge=86400" /></a>
    
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-workbench-common-activities"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-workbench-common-activities">Browse</a></td>
  <td>Common activities UI (discovery+configuration for Workbench</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-workbench-product">incubator-taverna-workbench-product</a>
      <br><a href="https://github.com/apache/incubator-taverna-workbench-product/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-workbench-product.svg?maxAge=86400" /></a>
      <a href="https://builds.apache.org/job/incubator-taverna-workbench-product/"><img src="https://img.shields.io/jenkins/s/https/builds.apache.org/job/incubator-taverna-workbench-product.svg?maxAge=86400" /></a>
      
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-workbench-product"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-workbench-product">Browse</a></td>
  <td>Distribution of Taverna Workbench</td>
</tr>
<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-plugin-gis">incubator-taverna-plugin-gis</a>
      <br><a href="https://github.com/apache/incubator-taverna-plugin-gis/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-plugin-gis.svg?maxAge=86400" /></a>
      
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-plugin-gis"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-plugin-gis">Browse</a></td>
  <td>Plugin for Geographical Information System (GIS) and OGC web services</td>
</tr>

<tr>
  <td>
    <a href="https://github.com/apache/incubator-taverna-databundle-viewer">incubator-taverna-databundle-viewer</a>
        <br><a href="https://github.com/apache/incubator-taverna-plugin-databundle-viewer/pulls"><img src="https://img.shields.io/github/issues-pr/apache/incubator-taverna-databundle-viewer.svg?maxAge=86400" /></a>
  </td>
  <td>
    <input class="gitlink" type="text" id="incubator-taverna-databundle-viewer"
           value="" readonly="readonly"
           onClick="this.setSelectionRange(0, this.value.length)">
  </td>
  <td><a class="gitbrowse btn btn-primary" href="https://github.com/apache/incubator-taverna-databundle-viewer">Browse</a></td>
  <td>Web-based Data Bundle viewer</td>
</tr>
</table>

<div class="alert alert-warning" role="alert"><p><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
  <strong>Note:</strong>
The source code above is for Apache Taverna 3.
For archival purposes the <a href="https://github.com/taverna/">source code for Taverna 2</a>
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

Use the Apache Taverna JIRA [issue tracker](/community/issue-tracker) to **report or track a bug.**

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

Some plugins that were previously part of Taverna 2 have migrated to taverna-extras due to [licensing incompatibility](http://dev.mygrid.org.uk/wiki/display/developer/Third-party+licenses) or lack of maintenance. This includes:

* [RShell activity](https://github.com/taverna-extras/taverna-rshell-activity) and [UI](https://github.com/taverna-extras/taverna-rshell-activity-ui)
* [Table activity](https://github.com/taverna-extras/table-activity)
* [Component plugin](https://github.com/taverna-extras/taverna-plugin-component)
* [Bioinformatics plugin](https://github.com/taverna-extras/taverna-plugin-bioinformatics)

<script>
function check() {
   var x = document.getElementsByClassName("gitlink");
   var y = document.getElementsByClassName("gitbrowse");
   var i;
   if ( document.getElementById("picker").value == "ApacheGitBox"){
      for (i = 0; i < x.length; i++) {
         x[i].value = "https://gitbox.apache.org/repos/asf/" +x[i].id + ".git";
      }
      for (i = 0; i < y.length; i++) {
         y[i].href = "https://gitbox.apache.org/repos/asf/?p=" +x[i].id + ".git;a=tree";
      }
   }
   if ( document.getElementById("picker").value == "GitHub"){
      for (i = 0; i < x.length; i++) {
        x[i].value = "https://github.com/apache/" +x[i].id + ".git";
      }
      for (i = 0; i < y.length; i++) {
        y[i].href = "https://github.com/apache/" +x[i].id;
      }
   }
   if ( document.getElementById("picker").value == "GitHubSSH"){
      for (i = 0; i < x.length; i++) {
        x[i].value = "git@github.com:apache/" +x[i].id + ".git";
      }
      for (i = 0; i < y.length; i++) {
        y[i].href = "https://github.com/apache/" +x[i].id;
      }
   }
   if ( document.getElementById("picker").value == "GitHubGit"){
      for (i = 0; i < x.length; i++) {
        x[i].value = "git://github.com/apache/" +x[i].id + ".git";
      }
      for (i = 0; i < y.length; i++) {
        y[i].href = "https://github.com/apache/" +x[i].id;
      }
   }
}
check ();
</script>
