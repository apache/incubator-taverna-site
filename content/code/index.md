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
[Github](https://github.com/apache/).

<div class="alert alert-warning" role="alert"><p><strong>Warning:</strong> As of 2014-12-19, the Taverna source code 
has not yet been migrated to the Apache Incubator infrastructure.</p>
<p>The current source code is still maintained at the 
<a href="https://github.com/taverna/" class="alert-link">taverna GitHub repositories</a>. 
</p></p>
The links below are to the temporary STAGING repository 
<a href="https://github.com/taverna-incubator" class="alert-link">taverna-incubator</a> at Github. The repositories called <code>incubator-*</code> should build, and are ready to be migrated to git.apache.org. The remaining <code>taverna-*</code> repositories are <strong>drafts</strong> of proposed git restructure and probably <em>won't build</em> correctly..
Note that the structure of the staging repositories might change significantly 
before the code has been migrated.

</div>


The Apache Taverna source code is organized into multiple repositories:

  - [incubator-taverna-maven-parent](https://github.com/taverna-incubator/incubator-taverna-maven-parent) - Common Maven parent for the below
  - [incubator-taverna-language](https://github.com/taverna-incubator/incubator-taverna-language) - Taverna Language APIs for workflow definitions (SCUFL2)
and workflow inputs/outputs/run (DataBundle). 
  - [incubator-taverna-osgi](https://github.com/taverna-incubator/incubator-taverna-osgi) - Generic OSGi extensions
  - [incubator-taverna-engine](https://github.com/taverna-incubator/incubator-taverna-engine) - Taverna workflow engine
  - [taverna-common-activities](https://github.com/taverna-incubator/taverna-engine-common-activities) - Common activity implementation for engine (e.g. WSDL, REST, Tool, Interaction)
  - [incubator-taverna-commandline](https://github.com/taverna-incubator/incubator-taverna-commandline) - Command line for running Taverna workflows
  - [taverna-workbench](https://github.com/taverna-incubator/taverna-workbench) - Graphical workbench for editing Taverna workflows
  - [taverna-workbench-common-activities](https://github.com/taverna-incubator/taverna-workbench-common-activities) - Common activities UI (discovery+configuration for Workbench
  - [taverna-server](https://github.com/taverna-incubator/taverna-server) - A REST and WSDL interface for running Taverna workflows

The build order is roughly the order of the above list, but as [snapshots](#snapshot-builds) are picked up from the snapshot repository, you do not need to build them all.

For any questions about the Taverna source code, please subscribe to and contact the 
[dev@taverna](http://mail-archives.apache.org/mod_mbox/taverna-dev/) mailing list.

## Snapshot builds

A corresponding set of [automatic Jenkins builds for Apache Taverna](http://build.mygrid.org.uk/ci/view/incubator-taverna/) deploy to the 
[Apache Taverna Maven snapshot repository](http://repository.mygrid.org.uk/artifactory/incubator-snapshot-local/). 
Note that these builds and repository will soon move to Apache.org infrastructure.

This means that as a developer, you only need to build the repositories you are modifying, as the remaining modules will be retrieved from the Maven repository. 
You will however always need to build the product (command line or workbench) to incorporate your changes.



## Taverna Extras

The separate GitHub group [taverna-extras](https://github.com/taverna-extras) host independent community-submitted plugins for Apache Taverna. 
Unlike Apache Taverna, the taverna-extras include plugins covered by the licenses [LGPL](https://www.gnu.org/licenses/;gpl.html) and [GPL](https://www.gnu.org/licenses/gpl.html).
Note that the taverna-extras are not affiliated with or released by Apache Taverna, although you may recognize many of the same committers.

Some plugins that were previously part of Taverna 2 have or will migrate to taverna-extras due to [licensing incompatibility](http://dev.mygrid.org.uk/wiki/display/developer/Third-party+licenses). This includes:

* RShell activity
* Beanshell activity
* [Table activity](https://github.com/taverna-extras/table-activity)
