Title:     Download Taverna Engine
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
    "@id": "https://taverna.incubator.apache.org/download/engine/",
    "url": "https://taverna.incubator.apache.org/download/engine/",
    "applicationSuite": "Apache Taverna (incubating)",
    "name" : "Apache Taverna Engine (incubating)",
    "description" : "Apache Taverna Engine (incubating) is a workflow engine for executing Taverna workflows.",
    "publisher" : { "@type" : "Organization",
                    "@id" : "https://www.apache.org/",
                   "url" : "https://www.apache.org/",
                    "name" : "The Apache Software Foundation (ASF)" },    
    "softwareVersion": "3.1.0-incubating",
    "downloadUrl" : "https://www-eu.apache.org/dist/incubator/taverna/source/taverna-engine-3.1.0-incubating/apache-taverna-engine-3.1.0-incubating-source-release.zip",
    "fileSize": "1.7MB",
    "applicationCategory": "Scientific Workflows",
    "operatingSystem": ["Windows", "OS/X", "Linux", "Java"],             
    "datePublished": "2016-06-31",
    "releaseNotes" : "https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332249&projectId=12318322",
    "author": { "@id": "https://taverna.incubator.apache.org/about/",
                 "url": "https://taverna.incubator.apache.org/about/",
                 "type": "Organization",
                 "name": "Apache Taverna PPMC" }
  }  

**Apache Taverna Engine** (incubating) is the workflow engine of
Apache Taverna.

The engine executes a Taverna workflow, defined using
[Apache Taverna Language](/download/language/).

Note that the engine also needs the
[activity implementations](/download/common-activities/)
that actually perform work (e.g., calling a REST service). To
run Taverna workflows, use the
[Apache Taverna Command Line](/download/command-line/)
or [Taverna Server](/download/server/).

All Taverna Engine modules are also valid [OSGi](http://www.osgi.org/) bundles,
providing OSGi [Spring services](#spring-services).


## Maven artifacts

Apache Taverna Engine is available from
[Maven Central](https://repo1.maven.org/maven2/org/apache/taverna/engine/),
mirrored from
[ASF's Maven repository](https://repository.apache.org/content/repositories/releases/org/apache/taverna/engine/).
For the convenience of IDE users, the Maven artifacts include `-javadoc.jar` and
`-sources.jar`; however, you might prefer the
online [API javadoc](/javadoc/taverna-engine/)
and the [source code releases](#source-code) (see below).


To use Taverna Engine APIs with [Maven](https://maven.apache.org/), add
one or more of these to your `pom.xml`:

    <dependencies>
        <dependency>
            <groupId>org.apache.taverna.engine</groupId>
            <artifactId>taverna-run-api</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.engine</groupId>
            <artifactId>taverna-execution-api</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.engine</groupId>
            <artifactId>taverna-credential-manager-api</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.engine</groupId>
            <artifactId>taverna-capability-api</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.engine</groupId>
            <artifactId>taverna-report-api</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.engine</groupId>
            <artifactId>taverna-workflowmodel-api</artifactId>
            <version>3.1.0-incubating</version>
        </dependency>
    </dependencies>

The above `<version>` might not be up-to-date.
See the [source code releases](#source-code) below to find the latest version.

To use the OSGi implementations of these services, replace `-api` with `-impl` above.
Note that you would need either to manually wire the services together or use
[Spring services](#spring-services) (see below).



## Usage

See the complete
[list of Taverna Engine modules](https://github.com/apache/incubator-taverna-engine/#modules),
a description of [which module does what](https://github.com/apache/incubator-taverna-engine/#which-module-does-what),
and the [Javadoc for Taverna Engine](/javadoc/taverna-engine/).

### Spring services

The OSGi services should be
discoverable as [Spring](https://spring.io/) services,
e.g. by adding to
your `META-INF/spring/update-context-osgi.xml`:

    <beans:beans xmlns="http://www.springframework.org/schema/osgi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:beans="http://www.springframework.org/schema/beans"
      xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/osgi http://www.springframework.org/schema/osgi/spring-osgi.xsd">

      <reference id="executionService" interface="org.apache.taverna.platform.execution.api.ExecutionService"/>
      <reference id="runService" interface="org.apache.taverna.platform.run.api.RunService"/>
      <reference id="credentialManager" interface="org.apache.taverna.security.credentialmanager.CredentialManager" />
      <reference id="databaseConfiguration" interface="org.apache.taverna.configuration.database.DatabaseConfiguration" />
      <reference id="databaseManager" interface="org.apache.taverna.configuration.database.DatabaseManager" />

    </beans:beans>


## Source code

Below you can find all Taverna Engine source releases.

After downloading the files,
[verify the PGP signatures](https://www.apache.org/info/verification.html)
using the Apache Taverna [KEYS](https://www.apache.org/dist/incubator/taverna/KEYS)
file.

### taverna-engine-3.1.0-incubating

**Apache Taverna Engine 3.1.0-incubating** was published on 2016-07-01, and is available for download
from official mirrors of the
ASF Distribution Directory [incubator/taverna/](https://www.apache.org/dyn/closer.cgi/incubator/taverna/):

* [taverna-engine-3.1.0-incubating-source-release.zip](https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-engine-3.1.0-incubating/apache-taverna-engine-3.1.0-incubating-source-release.zip)
  ([asc](https://www.apache.org/dist/incubator/taverna/source/taverna-engine-3.1.0-incubating/apache-taverna-engine-3.1.0-incubating-source-release.zip.asc),
  [md5](https://www.apache.org/dist/incubator/taverna/source/taverna-engine-3.1.0-incubating/apache-taverna-engine-3.1.0-incubating-source-release.zip.md5),
  [sha1](https://www.apache.org/dist/incubator/taverna/source/taverna-engine-3.1.0-incubating/apache-taverna-engine-3.1.0-incubating-source-release.zip.sha1),
  [sha256](https://www.apache.org/dist/incubator/taverna/source/taverna-engine-3.1.0-incubating/apache-taverna-engine-3.1.0-incubating-source-release.zip.sha256),
  [sha512](https://www.apache.org/dist/incubator/taverna/source/taverna-engine-3.1.0-incubating/apache-taverna-engine-3.1.0-incubating-source-release.zip.sha512))

The Taverna Engine [changelog](https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332249&projectId=12318322)
is available from the [Apache Taverna Jira](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20component%20%3D%20%22Taverna%20Engine%22).


### Source code repositories

For the latest developments you may also be interested in the corresponding
[source code](/download/code/) repositories:

* [incubator-taverna-engine](https://github.com/apache/incubator-taverna-engine)

Each release has a corresponding tag, e.g. `3.1.0-incubating`.

### Archived releases

For all archived Apache Taverna releases, see
[archive.apache.org](https://archive.apache.org/dist/incubator/taverna/).

The source code for Taverna Engine before migrating to Apache
(Taverna 2.5 and earlier) is available
as a series of `old/` tags in the git repository, e.g.
[core-1.5](https://github.com/apache/incubator-taverna-engine/tree/old/core-1.5),
note that the older code was licensed under LGPL 2.1.

Binaries for older releases are also available in the
[myGrid repository](/download/maven/#pre-apache-releases-and-snapshots),
e.g. as [net.sf.taverna.t2.core](https://repository.mygrid.org.uk/artifactory/mygrid-all/net/sf/taverna/t2/core/)
and other groupIds. The myGrid repository is not affiliated with the
Apache Software Foundation and is provided for archival purposes only.

