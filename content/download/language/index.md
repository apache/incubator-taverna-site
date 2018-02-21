Title:     Download Taverna Language
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
    "@type" : "SoftwareSourceCode",
    "@id": "https://taverna.incubator.apache.org/download/language/",
    "url": "https://taverna.incubator.apache.org/download/language/",
    "applicationSuite": "Apache Taverna (incubating)",
    "name" : "Apache Taverna Language (incubating)",
    "description" : "Apache Taverna Language (incubating) is a Java API that gives programmatic access to inspecting, modifying and converting SCUFL2 workflow definitions and Research Object Bundles.",
    "publisher" : { "@type" : "Organization",
                    "@id" : "https://www.apache.org/",
                   "url" : "https://www.apache.org/",
                    "name" : "The Apache Software Foundation (ASF)" },
    "downloadUrl" : "https://www-eu.apache.org/dist/incubator/taverna/source/taverna-language-0.15.1-incubating/apache-taverna-language-0.15.1-incubating-source-release.zip",
    "fileSize": "1.4MB",
    "softwareVersion": "0.15.1-incubating",
    "datePublished": "2016-03-11",
    "softwareHelp": {"@id": "https://taverna.incubator.apache.org/documentation/scufl2/"},
    "releaseNotes" : "https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12333250&projectId=12318322",
     "author": { "@id": "https://taverna.incubator.apache.org/about/",
                 "url": "https://taverna.incubator.apache.org/about/",
                 "type": "Organization",
                 "name": "Apache Taverna PPMC" }
  }            

**Apache Taverna Language** (incubating) is a Java API that gives programmatic
access to inspecting, modifying and converting
[SCUFL2](/documentation/scufl2/) workflow definitions and
[Research Object Bundles](https://w3id.org/bundle).

## Maven artifacts

Apache Taverna Language is available from
[Maven Central](https://repo1.maven.org/maven2/org/apache/taverna/language/),
mirrored from
[ASF's Maven repository](https://repository.apache.org/content/repositories/releases/org/apache/taverna/language/).
For convenience of IDE users, the Maven artifacts include `-javadoc.jar` and
`-sources.jar`; however, you might prefer the
online [API javadoc](/javadoc/taverna-language/?org/apache/taverna/scufl2/api/package-summary.html)
and the [source code releases](#source-code) (see below).

To use Taverna Language with [Maven](https://maven.apache.org/),
add to your `pom.xml` a selection of:

    <dependencies>
        <dependency>
            <groupId>org.apache.taverna.language</groupId>
            <artifactId>taverna-robundle</artifactId>
            <version>0.15.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.language</groupId>
            <artifactId>taverna-databundle</artifactId>
            <version>0.15.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.language</groupId>
            <artifactId>taverna-scufl2-api</artifactId>
            <version>0.15.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.language</groupId>
            <artifactId>taverna-scufl2-wfbundle</artifactId>
            <version>0.15.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.language</groupId>
            <artifactId>taverna-scufl2-t2flow</artifactId>
            <version>0.15.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.language</groupId>
            <artifactId>taverna-scufl2-wfdesc</artifactId>
            <version>0.15.1-incubating</version>
        </dependency>
    </dependencies>

The `<version>` above might not be up to date,
see the [source code releases](#source-code) below to find the latest version.

See the [Taverna Language documentation](/documentation/scufl2/) for more details.


## Source code

Below you can find all Taverna Language source releases.

After downloading the files,
[verify the PGP signatures](https://www.apache.org/info/verification.html)
using the Apache Taverna [KEYS](https://www.apache.org/dist/incubator/taverna/KEYS)
file.

### taverna-language-0.15.1-incubating

**Apache Taverna Language 0.15.1-incubating** was published on 2016-03-11, and is available for download
from official mirrors of the
ASF Distribution Directory [incubator/taverna/](https://www.apache.org/dyn/closer.cgi/incubator/taverna/):

* [taverna-language-0.15.1-incubating-source-release.zip](https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-language-0.15.1-incubating/apache-taverna-language-0.15.1-incubating-source-release.zip)
  ([asc](https://www.apache.org/dist/incubator/taverna/source/taverna-language-0.15.1-incubating/apache-taverna-language-0.15.1-incubating-source-release.zip.asc),
  [md5](https://www.apache.org/dist/incubator/taverna/source/taverna-language-0.15.1-incubating/apache-taverna-language-0.15.1-incubating-source-release.zip.md5),
  [sha1](https://www.apache.org/dist/incubator/taverna/source/taverna-language-0.15.1-incubating/apache-taverna-language-0.15.1-incubating-source-release.zip.sha1),
  [sha256](https://www.apache.org/dist/incubator/taverna/source/taverna-language-0.15.1-incubating/apache-taverna-language-0.15.1-incubating-source-release.zip.sha256),
  [sha512](https://www.apache.org/dist/incubator/taverna/source/taverna-language-0.15.1-incubating/apache-taverna-language-0.15.1-incubating-source-release.zip.sha512))

The Taverna Language [changelog](https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12333250&projectId=12318322)
is available from the [Apache Taverna Jira](https://issues.apache.org/jira/browse/TAVERNA/component/12326808).



### taverna-parent-3-incubating

**Apache Taverna Maven Parent 3-incubating** was published on 2018-01-18, and is available as:

* [taverna-parent-3-incubating-source-release.zip](https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-parent-3-incubating/apache-taverna-parent-3-incubating-source-release.zip)
  ([asc](https://www.apache.org/dist/incubator/taverna/source/taverna-parent-3-incubating/apache-taverna-parent-3-incubating-source-release.zip.asc),
  [md5](https://www.apache.org/dist/incubator/taverna/source/taverna-parent-3-incubating/apache-taverna-parent-3-incubating-source-release.zip.md5),
  [sha1](https://www.apache.org/dist/incubator/taverna/source/taverna-parent-3-incubating/apache-taverna-parent-3-incubating-source-release.zip.sha1),
  [sha256](https://www.apache.org/dist/incubator/taverna/source/taverna-parent-3-incubating/apache-taverna-parent-3-incubating-source-release.zip.sha256),
  [sha512](https://www.apache.org/dist/incubator/taverna/source/taverna-parent-3-incubating/apache-taverna-parent-3-incubating-source-release.zip.sha512))

The Taverna Maven parent [changelog](https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12334882&projectId=12318322)
is available from the [Apache Taverna Jira](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20component%20%3D%20%22Taverna%20Maven%20Parent%22).

### Source code repositories

For the latest developments you may also be interested in the corresponding
 [source code](/download/code/) repositories:

* [incubator-taverna-language](https://github.com/apache/incubator-taverna-language)
* [incubator-taverna-maven-parent](https://github.com/apache/incubator-taverna-maven-parent/)

Each release has a corresponding tag, e.g. `0.15.1-incubating`.

### Archived releases

For all archived Apache Taverna releases, see
[archive.apache.org](https://archive.apache.org/dist/incubator/taverna/).

Historical releases before moving to Apache (2015) are available at
GitHub under:

* [wf4ever/robundle](https://github.com/wf4ever/robundle/releases)
* [taverna/taverna-databundle](https://github.com/taverna/taverna-databundle/releases)
* [taverna/taverna-scufl2](https://github.com/taverna/taverna-scufl2/releases)

See also [older SCUFL2 docs](http://dev.mygrid.org.uk/wiki/display/developer/SCUFL2+API)
provided by myGrid's wiki.

Note that the historical releases are not affiliated with the
Apache Software Foundation and the above is provided for archival purposes only.
