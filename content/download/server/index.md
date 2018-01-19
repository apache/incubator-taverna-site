Title:     Apache Taverna Server
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
    "@type" : ["SoftwareSourceCode"],
    "@id": "https://taverna.incubator.apache.org/download/server/",
    "url": "https://taverna.incubator.apache.org/download/server/",
    "applicationSuite": "Apache Taverna (incubating)",
    "name" : "Apache Taverna Server (incubating)",
    "description" : "Apache Taverna Server (incubating) is a web service for executing Taverna workflows.",
    "publisher" : { "@type" : "Organization",
                    "@id" : "https://www.apache.org/",
                   "url" : "https://www.apache.org/",
                    "name" : "The Apache Software Foundation (ASF)" },    
    "softwareVersion": "3.1.0-incubating",
    "downloadUrl" : "https://www-eu.apache.org/dist/incubator/taverna/source/taverna-server-3.1.0-incubating/apache-taverna-server-3.1.0-incubating-source-release.zip",
    "fileSize": "0.8MB",
    "applicationCategory": "Scientific Workflows",
    "operatingSystem": ["Windows", "OS/X", "Linux", "Java"],             
    "datePublished": "2018-01-17",
    "releaseNotes" : "https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332252&projectId=12318322",
    "author": { "@id": "https://taverna.incubator.apache.org/about/",
                 "url": "https://taverna.incubator.apache.org/about/",
                 "type": "Organization",
                 "name": "Apache Taverna PPMC" }
  }  



Apache Taverna Server (incubating) is a REST/WSDL web service for executing Apache Taverna (incubating) workflows.

Taverna workflows are defined using [Apache Taverna Language](/download/language).


## Source code

Below you can find the latest Taverna Server source release.

After downloading the files,
[verify the PGP signatures](https://www.apache.org/info/verification.html)
using the Apache Taverna [KEYS](https://www.apache.org/dist/incubator/taverna/KEYS)
file.

After unpacking, follow the [build instructions](/documentation/server/3.1/). See the
[Taverna Server documentation](/documentation/server/) for details of 
installation, configuration and usage.

### taverna-server-3.1.0-incubating

**Apache Taverna Server 3.1.0-incubating** was published on 2018-01-17, and is available for download
from official mirrors of the
ASF Distribution Directory [incubator/taverna/](https://www.apache.org/dyn/closer.cgi/incubator/taverna/):

* [taverna-server-3.1.0-incubating-source-release.zip](https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-server-3.1.0-incubating/apache-taverna-server-3.1.0-incubating-source-release.zip)
  ([asc](https://www.apache.org/dist/incubator/taverna/source/taverna-server-3.1.0-incubating/apache-taverna-server-3.1.0-incubating-source-release.zip.asc),
  [md5](https://www.apache.org/dist/incubator/taverna/source/taverna-server-3.1.0-incubating/apache-taverna-server-3.1.0-incubating-source-release.zip.md5),
  [sha1](https://www.apache.org/dist/incubator/taverna/source/taverna-server-3.1.0-incubating/apache-taverna-server-3.1.0-incubating-source-release.zip.sha1),
  [sha256](https://www.apache.org/dist/incubator/taverna/source/taverna-server-3.1.0-incubating/apache-taverna-server-3.1.0-incubating-source-release.zip.sha256),
  [sha512](https://www.apache.org/dist/incubator/taverna/source/taverna-server-3.1.0-incubating/apache-taverna-server-3.1.0-incubating-source-release.zip.sha512))

The Taverna Server [changelog](https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332252&projectId=12318322)
is available from the [Apache Taverna Jira](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20component%20%3D%20%22Taverna%20Server%22).


Note that when building Taverna Server, it will require other Taverna modules:

* [Apache Taverna Language](/download/language)
* [Apache Taverna Command-line](/download/commandline)


### Source code repositories

For the latest developments you may also be interested in the corresponding
[source code](/download/code/) repositories:

* [incubator-taverna-server](https://github.com/apache/incubator-taverna-server)

Each release has a corresponding tag, e.g. `3.1.0-incubating`.


## Maven artifacts

Apache Taverna Server's Maven artifacts are available from
[Maven Central](https://repo1.maven.org/maven2/org/apache/taverna/server/),
mirrored from
[ASF's Maven repository](https://repository.apache.org/content/repositories/releases/org/apache/taverna/server/).
For the convenience of IDE users, the Maven artifacts include `-javadoc.jar` and
`-sources.jar`; however, you might prefer the
online [API javadoc](/javadoc/taverna-server/)
and the [source code releases](#source-code) (see below).


To use any Taverna Server modules with [Maven](https://maven.apache.org/), add
one or more of these to your `pom.xml`:

    <dependencies>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-client/</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-usagerecord</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-port-description</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-runinterface</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-rmidaemon</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-worker</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-unix-forker</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.server</groupId>
            <artifactId>taverna-server-webapp</artifactId>
            <version>3.1.0-incubating</version>
            <type>war</type>
        </dependency>
    </dependencies>

The above `<version>` might not be up-to-date.
See the [source code releases](#source-code) above to find the latest version.



# Client-side 
                   
To complement the Taverna Server, we have developed several client side libraries and applications. 

They access the Server's functionality and can help you build your client applications around 
the Server and provide exemplars of how such applications can be implemented.

 - [taverna-server-client](/javadoc/taverna-server/org/apache/taverna/server/client/package-summary.html) - a Java client library for Taverna Server's REST API, included in the taverna-server release.
 - [Taverna Language](/download/language/) - Java API for building and inspecting Taverna 3 workflows.
 - [Taverna Mobile](https://github.com/apache/incubator-taverna-mobile) - an Android app for executing Taverna workflows


## Third-party applications

These third-party applications use or interact with Taverna Server, but are not published or
endorsed by Apache Taverna:

 - [Taverna Player](https://github.com/myGrid/taverna-player) - a generic Rails engine for Taverna workflows
 - [Taverna Player portal](https://github.com/myGrid/taverna-player-portal) - a web portal for running Taverna workflows
 - [t2-server-gem](https://github.com/myGrid/t2-server-gem) a Ruby gem for interacting with Taverna Server
 - [t2-server-jar](https://github.com/myGrid/t2-server-jar) an older Java library to interact with Taverna Server
 - [workflow-runner](https://github.com/wf4ever/workflow-runner) a Clojure library for Taverna Server that can also re-expose runs [as a Research Object ROSRS API](https://github.com/wf4ever/apis/wiki/Wf-RO-transformation-service-API)
 - [BioVeL-seek](https://github.com/BioVeL/seek) a customized portal for running biodiversity workflows in Taverna Server


# Archived releases

For all archived Apache Taverna releases, see
[archive.apache.org](https://archive.apache.org/dist/incubator/taverna/).

The source code for Taverna Server before migrating to Apache Software Foundation
(Taverna 2.5 and earlier) is available
as a series of `old/` tags in the git repository, e.g.
[old/2.5.4](https://github.com/apache/incubator-taverna-server/releases/tag/old%2F2.5.4).

Note that Taverna 2.5 and older is licensed under 
[LGPL 2.1](https://www.gnu.org/licenses/old-licenses/lgpl-2.1.en.html).

Binary downloads for older releases are available from 
[LaunchPad's archive](https://launchpad.net/taverna-server/), for instance
[Taverna Server 2.5.4](https://launchpad.net/taverna-server/+milestone/2.5.4)
which you may need for executing some Taverna 2 `.t2flow` workflows.
