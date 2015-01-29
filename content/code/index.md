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
[GitHub](https://github.com/apache/).

<div class="alert alert-warning" role="alert"><p><strong>Warning:</strong> As of 2015-01-29, the Taverna source code 
has not yet been migrated to the Apache Incubator infrastructure.</p>
<p>The actively maintaned source code is still maintained at the 
<a href="https://github.com/taverna/" class="alert-link">taverna GitHub repositories</a>. 
For now, the links below are to the temporary <strong>staging repository</strong>
<a href="https://github.com/taverna-incubator" class="alert-link">taverna-incubator</a> at GitHub. 
</p><p>
The repositories called <code>incubator-*</code> should build, 
are ready to be migrated to <code>git.apache.org</code>, and use
groupId and Java package names on the form <code>org.apache.taverna.*</code>
</p><p>
The remaining <code>taverna-*</code> repositories are <strong>drafts</strong> of
the proposed git restructure and probably <em>won't build</em> correctly. 
Unlike the <code>incubator-*</code> repositories, these drafts don't correctly
preserve git history from pre-Apache.
Note that the structure of the staging repositories might change significantly 
before the code has been migrated.

</div>


## Source code repositories

The Apache Taverna source code is organized into multiple [git](http://www.git-scm.com/) repositories:

  - [incubator-taverna-maven-parent](https://github.com/taverna-incubator/incubator-taverna-maven-parent) - Common Maven parent for the below
  - [incubator-taverna-language](https://github.com/taverna-incubator/incubator-taverna-language) - Taverna Language APIs for workflow definitions (SCUFL2)
and workflow inputs/outputs/run (DataBundle). 
  - [incubator-taverna-osgi](https://github.com/taverna-incubator/incubator-taverna-osgi) - Generic OSGi extensions
  - [incubator-taverna-engine](https://github.com/taverna-incubator/incubator-taverna-engine) - Taverna workflow engine
  - [incubator-taverna-common-activities](https://github.com/taverna-incubator/incubator-taverna-common-activities) - Common activity implementation for engine (e.g. WSDL, REST, Tool, Interaction)
  - [incubator-taverna-commandline](https://github.com/taverna-incubator/incubator-taverna-commandline) - Command line for running Taverna workflows
  - [taverna-server](https://github.com/taverna-incubator/taverna-server) - A REST and WSDL interface for running Taverna workflows
  - [taverna-workbench](https://github.com/taverna-incubator/taverna-workbench) - Graphical workbench for editing Taverna workflows
  - [taverna-workbench-common-activities](https://github.com/taverna-incubator/taverna-workbench-common-activities) - Common activities UI (discovery+configuration for Workbench
  - [taverna-workbench-product](https://github.com/taverna-incubator/taverna-workbench-product) - Distribution of Taverna Workbench
  - [taverna-plugin-component](https://github.com/taverna-incubator/taverna-plugin-component) Component plugin
  - [taverna-plugin-bioinformatics](https://github.com/taverna-incubator/taverna-plugin-bioinformatics)

## Building Apache Taverna

You need [Apache Maven 3.2](https://maven.apache.org/download.html) or newer to build Taverna. 
To build a checked out repository:

    mvn clean install

If you want to skip tests (these can be time-consuming):

    mvn clean install -PskipTests

If you get license header warnings from the 
[Apache RAT plugin](https://creadur.apache.org/rat/apache-rat-plugin/), 
and you are not a committer (who should fix those :) ),
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

For many developers the easiest is to *Fork* the repository on *GitHub*, and submit your suggested 
changes as a *Pull request*. The pull request is automatically forwarded to the 
[dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/) mailing list, which you 
should subscribe to in order to receive feedback for your patch.

Alternatively you may checkout directly from the repositories above,
use [git format-patch](https://www.kernel.org/pub/software/scm/git/docs/git-format-patch.html) 
and send your patches to the [dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/)
mailing list after subscribing. Note that large patch files might not be accepted by
the mailing list software.

For any questions about using or modifying the Apache Taverna source code and APIs, 
please subscribe to and contact the [dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/) mailing list.


## Snapshot builds

A corresponding set of [automatic Jenkins builds for Apache Taverna](http://build.mygrid.org.uk/ci/view/incubator-taverna/) deploy to the 
[<del>Apache</del> Taverna Maven snapshot repository](http://repository.mygrid.org.uk/artifactory/incubator-snapshot-local/). 
Note that these builds and repository are currently hosted outside of Apache, but will soon move to Apache.org infrastructure.

This means that as a developer, you only need to build the repositories you are modifying, as the remaining modules will be retrieved from the Maven repository. 
You will however always need to build the distribution product (command line or workbench) to incorporate your changes. (Make sure that references your <code>SNAPSHOT</code> version!)

## Taverna Extras

The separate GitHub group [taverna-extras](https://github.com/taverna-extras) host independent community-submitted plugins for Apache Taverna. 
Unlike Apache Taverna, the taverna-extras include plugins covered by the licenses [LGPL](https://www.gnu.org/licenses/;gpl.html) and [GPL](https://www.gnu.org/licenses/gpl.html).
Note that the taverna-extras are not affiliated with or released by Apache Taverna, although you may recognize many of the same committers.

Some plugins that were previously part of Taverna 2 have or will migrate to taverna-extras due to [licensing incompatibility](http://dev.mygrid.org.uk/wiki/display/developer/Third-party+licenses). This includes:

* RShell activity
* [Table activity](https://github.com/taverna-extras/table-activity)
