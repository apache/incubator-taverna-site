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


## Source code repositories

The Apache Taverna source code is organized into multiple [git](http://www.git-scm.com/) repositories:

  - [incubator-taverna-maven-parent](https://github.com/apache/incubator-taverna-maven-parent) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-maven-parent.git) 
    [[git]](git://git.apache.org/incubator-taverna-maven-parent.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-maven-parent)
    Common Maven parent for the below
  - [incubator-taverna-language](https://github.com/apache/incubator-taverna-language) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-language.git) 
    [[git]](git://git.apache.org/incubator-taverna-language.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-language)
    Taverna Language APIs for workflow definitions (SCUFL2) and workflow inputs/outputs/run (DataBundle). 
  - [incubator-taverna-osgi](https://github.com/apache/incubator-taverna-osgi) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-osgi.git) 
    [[git]](git://git.apache.org/incubator-taverna-osgi.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-osgi)
    OSGi-based plugin system
  - [incubator-taverna-engine](https://github.com/apache/incubator-taverna-engine) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-engine.git) 
    [[git]](git://git.apache.org/incubator-taverna-engine.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-engine)
    Taverna workflow engine
  - [incubator-taverna-common-activities](https://github.com/apache/incubator-taverna-common-activities)
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-common-activities.git) 
    [[git]](git://git.apache.org/incubator-taverna-common-activities.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-common-activities)
    Common activity implementation for engine (e.g. WSDL, REST, Tool, Interaction)
  - [incubator-taverna-commandline](https://github.com/apache/incubator-taverna-commandline) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-commandline.git) 
    [[git]](git://git.apache.org/incubator-taverna-commandline.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-commandline)
    Command line for running Taverna workflows
  - [incubator-taverna-server](https://github.com/apache/incubator-taverna-server) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-server.git) 
    [[git]](git://git.apache.org/incubator-taverna-server.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-server)
    A REST and WSDL service for running Taverna workflows
  - [incubator-taverna-workbench](https://github.com/apache/incubator-taverna-workbench) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-workbench.git) 
    [[git]](git://git.apache.org/incubator-taverna-workbench.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-workbench)
    Graphical workbench for editing and running Taverna workflows
  - [incubator-taverna-workbench-common-activities](https://github.com/apache/incubator-taverna-workbench-common-activities)
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-workbench-common-activities.git) 
    [[git]](git://git.apache.org/incubator-taverna-workbench-common-activities.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-workbench-common-activities) 
    Common activities UI (discovery+configuration for Workbench
  - [incubator-taverna-workbench-product](https://github.com/apache/incubator-taverna-workbench-product) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-workbench-product.git) 
    [[git]](git://git.apache.org/incubator-taverna-workbench-product.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-workbench-product)
    Distribution of Taverna Workbench
  - [incubator-taverna-plugin-component](https://github.com/apache/incubator-taverna-plugin-component)
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-plugin-component.git) 
    [[git]](git://git.apache.org/incubator-taverna-plugin-component.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-plugin-component) 
    Plugin for component activity and registry
  - [incubator-taverna-plugin-bioinformatics](https://github.com/apache/incubator-taverna-plugin-bioinformatics) 
    [[https]](https://git-wip-us.apache.org/repos/asf/incubator-taverna-plugin-bioinformatics.git) 
    [[git]](git://git.apache.org/incubator-taverna-plugin-bioinformatics.git) 
    [[GitHub]](https://github.com/apache/incubator-taverna-plugin-bioinformatics)
    Plugin for bioinformatics-specific activities

### Taverna 2 source code

The source code for Taverna 2 remains available at 
<a href="https://github.com/taverna/">taverna on GitHub</a> under the
`maintenance` branches. Note that this code is not maintained by the Apache Taverna project
 and is licensed under 
the [GNU Lesser Public License 2.1](https://www.gnu.org/licenses/lgpl-2.1.html)

### Checking out Apache Taverna

To check out Apache Taverna anonymously, use the `[git]` links from above, e.g.:

    git clone git://git.apache.org/incubator-taverna-language.git

If you are a committer on Apache Taverna, or have firewall restrictions, use the `[https]` links, e.g.:

    git clone https://git-wip-us.apache.org/repos/asf/incubator-taverna-engine.git

You can also browse the code using the `[GitHub]` links, which are mirrored read-only. 
Using GitHub you are free to *fork* the projects and raise *pull requests* to 
[contribute to Apache Taverna](#contribute-to-apache-taverna).


## Building Apache Taverna

You need [Apache Maven 3.2](https://maven.apache.org/download.html) or newer to build Taverna. 
To build a checked out repository:

    mvn clean install

If you want to skip tests (these can be time-consuming):

    mvn clean install -PskipTests

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

**Patches welcome!** Apache Taverna is a volunteer project, and we rely on the community to help
improve the code base. Anyone can suggest a change to Apache Taverna, not just the existing [committers](/about/).

For many developers the easiest is to **Fork** the corresponding repository on *GitHub*, and submit the suggested 
changes as a **Pull request**. The pull request is automatically forwarded to the 
[dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/) mailing list, which you 
should subscribe to in order to receive feedback for your patch.

Alternatively you may checkout directly from the repositories above,
use [git format-patch](https://www.kernel.org/pub/software/scm/git/docs/git-format-patch.html) 
and send your patches to the [dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/)
mailing list after subscribing. Note that large patch files might not be accepted by
the mailing list software.

For larger contributions we might ask you to sign a 
[Contributer License Agreement](https://www.apache.org/licenses/#clas) (CLA) to grant a license to 
the Apache Software Foundation that covers your contribution. 

For any questions about using or modifying the Apache Taverna source code and APIs, 
please subscribe to and contact the [dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/) mailing list.


## Snapshot builds

A corresponding set of [automatic Jenkins builds for Apache Taverna](https://builds.apache.org/user/stain/my-views/view/taverna/) deploy to  
[Apache's snapshot Maven repository](http://repository.apache.org/snapshots/org/apache/taverna/). 
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
Unlike Apache Taverna, the taverna-extras include plugins covered by the licenses [LGPL](https://www.gnu.org/licenses/;gpl.html) and [GPL](https://www.gnu.org/licenses/gpl.html).
Note that the taverna-extras are not affiliated with or released by Apache Taverna, although you may recognize many of the same committers.

Some plugins that were previously part of Taverna 2 have or will migrate to taverna-extras due to [licensing incompatibility](http://dev.mygrid.org.uk/wiki/display/developer/Third-party+licenses). This includes:

* RShell activity
* [Table activity](https://github.com/taverna-extras/table-activity)
