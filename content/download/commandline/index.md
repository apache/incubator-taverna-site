Title:     Download Taverna Command-line Tool
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
jsonld: {
    "@context" : "http://schema.org",
    "@type" : "SoftwareApplication",
    "@id": "https://taverna.incubator.apache.org/download/commandline/",
    "url": "https://taverna.incubator.apache.org/download/commandline/",
    "applicationSuite": "Apache Taverna (incubating)",
    "name" : "Apache Taverna Command Line (incubating)",
    "description" : "Apache Taverna Command Line Tool (incubating) runs Taverna workflows, usable from shell scripts and the command line.",
    "publisher" : { "@type" : "Organization",
                    "@id" : "https://www.apache.org/",
                   "url" : "https://www.apache.org/",
                    "name" : "The Apache Software Foundation (ASF)" },
    "downloadUrl" : "https://www-eu.apache.org/dist/incubator/taverna/source/taverna-commandline-3.1.0-incubating/apache-taverna-commandline-3.1.0-incubating-source-release.zip",
    "softwareVersion": "3.1.0-incubating",
    "fileSize": "607KB",
    "applicationCategory": "Scientific Workflows",
    "operatingSystem": ["Windows", "OS/X", "Linux", "Java"],     
    "datePublished": "2016-06-31",
    "releaseNotes" : "https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332251&projectId=12318322",
     "author": { "@id": "https://taverna.incubator.apache.org/about/",
                 "url": "https://taverna.incubator.apache.org/about/",
                 "type": "Organization",
                 "name": "Apache Taverna PPMC" }
  }  

<div class="alert alert-info" role="alert"><p><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
Taverna has transitioned to the Apache Incubator.

Users of <a class="alert-link" href="/download/workbench">Taverna Workbench 2.x</a>
are still recommended to use the
<strong>archived</strong>
non-Apache releases of
<a class="alert-link" href="http://www.taverna.org.uk/download/command-line-tool/2-5/">Taverna Command Line 2.5</a>
in production, and
try the Apache Taverna Command-line Tool 3.1.0 for development. We appreciate
any <a class="alert-link" href="/community">feedback and contributions</a>!
</div>


Taverna [Command-line Tool](/documentation/command-line) enables you to run workflows from a
  command prompt. The Tool is essentially the Taverna Workbench stripped of its GUI so you can run
   workflows headlessly from a command prompt (i.e., without the graphical environment).

Apache Taverna Command-line Tool can run workflows defined with
[Apache Taverna Language](/download/language) in
[SCUFL2 format](/documentation/scufl2) (`.wfbundle`).
In addition, you can execute many
[Taverna 2](/download/workbench)
workflows (`.t2flow`) , depending
on which activities they require.

Support for executing
[Common Workflow Language](http://commonwl.org/)
workflows is planned. Please contact the
[dev@taverna](/community/lists#devtaverna) mailing list
for details.



## Source code

Below you can find all Taverna Command-line Tool source releases.

After downloading the files,
[verify the PGP signatures](https://www.apache.org/info/verification.html)
using the Apache Taverna [KEYS](https://www.apache.org/dist/incubator/taverna/KEYS)
file.

### taverna-commandline-3.1.0-incubating

**Apache Taverna Command-line 3.1.0-incubating** was published on 2016-07-01, and is available for download
from official mirrors of the
ASF Distribution Directory [incubator/taverna/](https://www.apache.org/dyn/closer.cgi/incubator/taverna/):

* [taverna-commandline-3.1.0-incubating-source-release.zip](https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-commandline-3.1.0-incubating/apache-taverna-commandline-3.1.0-incubating-source-release.zip)
  ([asc](https://www.apache.org/dist/incubator/taverna/source/taverna-commandline-3.1.0-incubating/apache-taverna-commandline-3.1.0-incubating-source-release.zip.asc),
  [md5](https://www.apache.org/dist/incubator/taverna/source/taverna-commandline-3.1.0-incubating/apache-taverna-commandline-3.1.0-incubating-source-release.zip.md5),
  [sha1](https://www.apache.org/dist/incubator/taverna/source/taverna-commandline-3.1.0-incubating/apache-taverna-commandline-3.1.0-incubating-source-release.zip.sha1)),
  [sha256](https://www.apache.org/dist/incubator/taverna/source/taverna-commandline-3.1.0-incubating/apache-taverna-commandline-3.1.0-incubating-source-release.zip.sha256)),
  [sha512](https://www.apache.org/dist/incubator/taverna/source/taverna-commandline-3.1.0-incubating/apache-taverna-commandline-3.1.0-incubating-source-release.zip.sha512))


The Taverna Command-line Tool [changelog](https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332251&projectId=12318322)
is available from the [Apache Taverna Jira](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20component%20%3D%20%22Taverna%20Command-line%20Tool%22).


Note that when building Taverna Command-line Tool, it will require other Taverna modules:

* [Apache Taverna Language](/download/language)
* [Apache Taverna OSGi](/download/osgi)
* [Apache Taverna Engine](/download/engine)
* [Apache Taverna Common Activities](/download/common-activities)

You can either compile those Taverna modules first,
or let Maven fetch them from
[Maven Central](https://repo1.maven.org/maven2/org/apache/taverna/).
See the `<properties>` file in the Command-line Tool's `pom.xml` for version
information.


### Source code repositories

For the latest developments you may also be interested in the corresponding
 [source code](/download/code/) repositories:

* [incubator-taverna-commandline](https://github.com/apache/incubator-taverna-commandline)
* [incubator-taverna-common-activities](https://github.com/apache/incubator-taverna-common-activities)
* [incubator-taverna-engine](https://github.com/apache/incubator-taverna-engine)
* [incubator-taverna-osgi](https://github.com/apache/incubator-taverna-osgi)
* [incubator-taverna-language](https://github.com/apache/incubator-taverna-language)

Each release also has a tag corresponding to its version, e.g., `3.1.0-incubating`.

## Binary distribution

Version 3.1.0 is the first release
of the Apache Taverna 3 Command-line Tool. It is only available as
source code, as we think this release is mainly useful for
development and testing.

Apache Taverna is planning to include a binary distribution of
the Taverna Command-line Tool with its next release. Please contact
the [dev@taverna](/community/lists#devtaverna) mailing list
for details.

The previous non-Apache release of
[Taverna Command Line 2.5](http://www.taverna.org.uk/download/command-line-tool/2-5/)
remains available in binary distributions and installers.
(see below).

## Archived releases

For all archived Apache Taverna releases, see
[archive.apache.org](https://archive.apache.org/dist/incubator/taverna/).

Taverna 2.5 and earlier were released before incubating
to the Apache Software Foundation.
[Taverna Command Line 2.5 and earlier](http://www.taverna.org.uk/download/command-line-tool/)
remain available for archival purposes.

Users of the [Taverna Workbench 2.x](/download/workbench) are still recommended to use the
non-Apache release of
[Taverna Command Line 2.5](http://www.taverna.org.uk/download/command-line-tool/2-5/)
in production. Note however that Taverna 2.5 is
**no longer maintained** - users are encouraged to evaluate
Apache Taverna Command-line Tool and provide
[feedback](/community) to its development.

Taverna Command Line 2.5 can be [downloaded from BitBucket](https://bitbucket.org/taverna/taverna-commandline-product/downloads/).
Note that these non-Apache releases are licensed under
[LGPL 2.1](https://www.gnu.org/licenses/old-licenses/lgpl-2.1.en.html) or
[GPL 3.0](https://www.gnu.org/licenses/gpl-3.0.html).
