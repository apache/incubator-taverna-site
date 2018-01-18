Title:     Download Taverna Common Activities
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
    "@id": "https://taverna.incubator.apache.org/download/common-activities/",
    "url": "https://taverna.incubator.apache.org/download/common-activities/",
    "applicationSuite": "Apache Taverna (incubating)",
    "name" : "Apache Taverna Common Activities (incubating)",
    "description" : "Apache Taverna Common Activities (incubating) are plugins for invoking common activity types from Taverna Engine, e.g. REST, WSDL, Beanshell and command line tools.",
    "publisher" : { "@type" : "Organization",
                    "@id" : "https://www.apache.org/",
                   "url" : "https://www.apache.org/",
                    "name" : "The Apache Software Foundation (ASF)" },
    "softwareVersion": "2.1.0-incubating",
    "downloadUrl" : "https://www-eu.apache.org/dist/incubator/taverna/source/taverna-common-activities-2.1.0-incubating/apache-taverna-common-activities-2.1.0-incubating-source-release.zip",
    "fileSize": "585KB",
    "applicationCategory": "Scientific Workflows",
    "operatingSystem": ["Windows", "OS/X", "Linux", "Java"],         
    "datePublished": "2016-06-31",
    "releaseNotes" : "https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332248&projectId=12318322",
     "author": { "@id": "https://taverna.incubator.apache.org/about/",
                 "url": "https://taverna.incubator.apache.org/about/",
                 "type": "Organization",
                 "name": "Apache Taverna PPMC" }
  }  

**Apache Taverna Common Activities** (incubating) provides the plugins for
invoking common activity types from [Taverna Engine](/download/engine),
including support for [REST]() and
[WSDL](https://en.wikipedia.org/wiki/Web_Services_Description_Language)
web services, [Beanshell](https://github.com/beanshell/beanshell/) scripts,
command line tools and user interaction.

## Maven artifacts

Apache Taverna Common Activities are available from
[Maven Central](https://repo1.maven.org/maven2/org/apache/taverna/common-activities/),
mirrored from
[ASF's Maven repository](https://repository.apache.org/content/repositories/releases/org/apache/taverna/common-activities/).
For the convenience of IDE users, the Maven artifacts include `-javadoc.jar` and
`-sources.jar`; however, you might prefer the
online [API javadoc](/javadoc/taverna-common-activities/)
and the [source code releases](#source-code) (see below).


To use Taverna Common Activities with [Maven](https://maven.apache.org/), add
one or more of these to your `pom.xml`:

    <dependencies>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-beanshell-activity</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-external-tool-activity</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-interaction-activity</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-rest-activity</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-spreadsheet-import-activity</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-wsdl-activity</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-wsdl-generic</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
        <dependency>
          <groupId>org.apache.taverna.commonactivities</groupId>
          <artifactId>taverna-xpath-activity</artifactId>
          <version>2.1.0-incubating</version>
        </dependency>
    </dependencies>

The above `<version>` might not be up-to-date.
See the [source code releases](#source-code) below to find the latest version.

In addition, `taverna-wsdl-generic` can be used as an independent library for
[parsing WSDL definitions](/javadoc/taverna-common-activities/org/apache/taverna/wsdl/parser/package-summary.html)
and [invoking WSDL-described SOAP services](/javadoc/taverna-common-activities/org/apache/taverna/wsdl/soap/package-summary.html).


### Spring services

The activities are all OSGi services, registering with
[Taverna Engine](/download/engine)'s
[ActivityService](/javadoc/taverna-engine/org/apache/taverna/platform/capability/api/ActivityService.html), which
should be discoverable as a [Spring](https://spring.io/) service,
e.g. by adding the following code to
your `META-INF/spring/update-context-osgi.xml`:

    <beans:beans xmlns="http://www.springframework.org/schema/osgi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns:beans="http://www.springframework.org/schema/beans"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans
                                     http://www.springframework.org/schema/beans/spring-beans.xsd
                                     http://www.springframework.org/schema/osgi
                                     http://www.springframework.org/schema/osgi/spring-osgi.xsd">
        <reference id="activityService" interface="org.apache.taverna.platform.capability.api.ActivityService" />
    </beans:beans>


## Source code

Below you can find all Taverna Common Activities source releases.

After downloading the files,
[verify the PGP signatures](https://www.apache.org/info/verification.html)
using the Apache Taverna [KEYS](https://www.apache.org/dist/incubator/taverna/KEYS)
file.

### taverna-common-activities-2.1.0-incubating

**Apache Taverna Common Activities 2.1.0-incubating** was published on 2016-07-01, and is available for download
from official mirrors of the
ASF Distribution Directory [incubator/taverna/](https://www.apache.org/dyn/closer.cgi/incubator/taverna/):

* [taverna-common-activities-2.1.0-incubating-source-release.zip](https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-common-activities-2.1.0-incubating/apache-taverna-common-activities-2.1.0-incubating-source-release.zip)
  ([asc](https://www.apache.org/dist/incubator/taverna/source/taverna-common-activities-2.1.0-incubating/apache-taverna-common-activities-2.1.0-incubating-source-release.zip.asc),
  [md5](https://www.apache.org/dist/incubator/taverna/source/taverna-common-activities-2.1.0-incubating/apache-taverna-common-activities-2.1.0-incubating-source-release.zip.md5),
  [sha1](https://www.apache.org/dist/incubator/taverna/source/taverna-common-activities-2.1.0-incubating/apache-taverna-common-activities-2.1.0-incubating-source-release.zip.sha1),
  [sha256](https://www.apache.org/dist/incubator/taverna/source/taverna-common-activities-2.1.0-incubating/apache-taverna-common-activities-2.1.0-incubating-source-release.zip.sha256),
  [sha512](https://www.apache.org/dist/incubator/taverna/source/taverna-common-activities-2.1.0-incubating/apache-taverna-common-activities-2.1.0-incubating-source-release.zip.sha512))

The Taverna Common Activities [changelog](https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332248&projectId=12318322)
is available from the [Apache Taverna Jira](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20component%20%3D%20%22Taverna%20Common%20Activities%22).


### Source code repositories

For the latest developments you may also be interested in the corresponding
 [source code](/download/code/) repositories:

* [incubator-taverna-common-activities](https://github.com/apache/incubator-taverna-common-activities)

Each release has a corresponding tag, e.g. `2.1.0-incubating`.

### Archived releases

For all archived Apache Taverna releases, see
[archive.apache.org](https://archive.apache.org/dist/incubator/taverna/).

The source code for Taverna Common Activities
before migrating to Apache
(Taverna 2.5 and earlier) is available
as a series of `old/` tags in the git repository, e.g.,
[xpath-activity-1.5](https://github.com/apache/incubator-taverna-common-activities/tree/old/xpath-activity-1.5).
Note that the older code was licensed under LGPL 2.1.

Binaries for older releases are also available in the
[myGrid repository](/download/maven/#pre-apache-releases-ands),
e.g., as
[net.sf.taverna.t2.activities](https://repository.mygrid.org.uk/artifactory/mygrid-all/net/sf/taverna/t2/activities/)
and other groupIds. The myGrid repository is not affiliated with the
Apache Software Foundation and is provided for archival purposes only.
