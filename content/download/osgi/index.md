Title:     Download Taverna OSGi plugin system
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
    "@id": "https://taverna.incubator.apache.org/download/osgi/",
    "url": "https://taverna.incubator.apache.org/download/osgi/",
    "applicationSuite": "Apache Taverna (incubating)",
    "name" : "Apache Taverna OSGi (incubating)",
    "description" : "Apache Taverna OSGi plugin system (incubating) is a plugin system for Java console and desktop applications using OSGi, including an online update mechanism.",
    "applicationCategory": "Scientific Workflows",
    "operatingSystem": ["Windows", "OS/X", "Linux", "Java"],
    "publisher" : { "@type" : "Organization",
                    "@id" : "https://www.apache.org/",
                   "url" : "https://www.apache.org/",
                    "name" : "The Apache Software Foundation (ASF)" },
    "softwareVersion": "0.2.1-incubating",
    "datePublished": "2016-03-11",
    "downloadUrl" : "https://www-eu.apache.org/dist/incubator/taverna/source/taverna-osgi-0.2.1-incubating/apache-taverna-osgi-0.2.1-incubating-source-release.zip",
    "fileSize": "185KB",
    "releaseNotes" : "https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332248&projectId=12318322",
     "author": { "@id": "https://taverna.incubator.apache.org/about/",
                 "url": "https://taverna.incubator.apache.org/about/",
                 "type": "Organization",
                 "name": "Apache Taverna PPMC" }
  }  


**Apache Taverna OSGi plugin system** (incubating) is a plugin system for
Java console and desktop applications using [OSGi](https://www.osgi.org/),
including an online update mechanism.

## Maven artifacts

Apache Taverna OSGi is available from
[Maven Central](https://repo1.maven.org/maven2/org/apache/taverna/osgi/),
mirrored from
[ASF's Maven repository](https://repository.apache.org/content/repositories/releases/org/apache/taverna/osgi/).
For convenience of IDE users, the Maven artifacts include `-javadoc.jar` and
`-sources.jar`; however, you might prefer the
online [API javadoc](/javadoc/taverna-osgi/)
and the [source code releases](#source-code) (see below).


To use Taverna OSGi APIs with [Maven](https://maven.apache.org/), add
one or more of these to your `pom.xml`:

    <dependencies>
        <dependency>
            <groupId>org.apache.taverna.osgi</groupId>
            <artifactId>taverna-app-configuration-api</artifactId>
            <version>0.2.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.osgi</groupId>
            <artifactId>taverna-configuration-api</artifactId>
            <version>0.2.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.osgi</groupId>
            <artifactId>taverna-download-api</artifactId>
            <version>0.2.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.osgi</groupId>
            <artifactId>taverna-plugin-api</artifactId>
            <version>0.2.1-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taverna.osgi</groupId>
            <artifactId>taverna-update-api</artifactId>
            <version>0.2.1-incubating</version>
        </dependency>
    </dependencies>

The `<version>` above might not be up to date,
see the [source code releases](#source-code) below to find the latest version.

To use the OSGi implementations of these services, replace `-api` with `-impl` above.



## Usage

See the [taverna-osgi javadoc](/javadoc/taverna-osgi/)
for details on each OSGi service. In brief:

* The [OsgiLauncher](/javadoc/taverna-osgi/org/apache/taverna/osgilauncher/OsgiLauncher.html)
  starts the OSGi framework and installs the provided OSGi bundles. It is used by the
  [taverna-commandline-launcher](https://github.com/apache/incubator-taverna-commandline/blob/master/taverna-commandline-launcher/src/main/java/org/apache/taverna/commandline/TavernaCommandLine.java#L64)
  `main()` method.
* The [PluginManager](/javadoc/taverna-osgi/org/apache/taverna/plugin/PluginManager.html) service
  from [taverna-plugin-api](https://github.com/apache/incubator-taverna-osgi/blob/master/taverna-plugin-api/)
  allow managing of
  plugins in an OSGi application, including online installation and updates of plugins. Each
  [Plugin](/javadoc/taverna-osgi/org/apache/taverna/plugin/Plugin.html) provides a collection
  of OSGi bundles that are activated. The plugins and application profile are described in XML according to the
  [taverna-osgi-schemas](https://github.com/apache/incubator-taverna-osgi/blob/master/taverna-osgi-schemas/src/main/resources).
* The [UpdateManager](/javadoc/taverna-osgi/org/apache/taverna/update/UpdateManager.html)
  can update the installed plugins by downloading from the configured plugin site URI.
* The [taverna-maven-plugin](https://github.com/apache/incubator-taverna-osgi/blob/master/taverna-maven-plugin/)   allows creating plugins for the Taverna `PluginManager`
  using Apache Maven, including deployment to plugin sites.
* The [DownloadManager](/javadoc/taverna-osgi/org/apache/taverna/download/DownloadManager.html)
  service from [taverna-download-api](https://github.com/apache/incubator-taverna-osgi/blob/master/taverna-download-api/) provides convenience methods for downloading a `URI`
  to a `Path`, including hashsum checking using neighbouring `.sha1` or `.md5` URIs. Used by `PluginManager` and `UpdateManager`.
* The [ApplicationConfiguration](/javadoc/taverna-osgi/org/apache/taverna/configuration/app/ApplicationConfiguration.html)
  service provides application installation details  like the startup directory and home directory for user configuration. The application should have a [conf/taverna.app.properties](https://github.com/apache/incubator-taverna-commandline/blob/master/taverna-commandline-product/src/main/etc/conf/taverna.app.properties)
  file in its startup folder, e.g. `taverna.app.name=taverna-cl-3.0.0` means `~/.taverna-cl-3.0.0/` will be the
  application's home directory on Unix.
* The [ConfigurationManager](/javadoc/taverna-osgi/org/apache/taverna/configuration/ConfigurationManager.html)
  service from [taverna-configuration-api](https://github.com/apache/incubator-taverna-osgi/blob/master/taverna-configuration-api/) can configure any
  [Configurable](/javadoc/taverna-osgi/org/apache/taverna/configuration/Configurable.html)
  like the [HTTPProxyConfiguration](/javadoc/taverna-osgi/org/apache/taverna/configuration/proxy/HttpProxyConfiguration.html)
  and the [workbench](https://github.com/apache/incubator-taverna-workbench/blob/master/taverna-configuration-api/src/main/java/org/apache/taverna/workbench/configuration/workbench/WorkbenchConfiguration.java)
  using preferences stored in the application home directory  
* The [xml-parser-service](https://github.com/apache/incubator-taverna-osgi/blob/master/xml-parser-service/)
  and [xml-transformer-service](https://github.com/apache/incubator-taverna-osgi/tree/master/xml-transformer-service)
  re-exposes Xalan's and Xerces's XML parser and XML transformer implementations within SOGi

### Spring services

The OSGi services should be
discoverable as [Spring](https://spring.io/) services,
e.g. by adding to
your `META-INF/spring/update-context-osgi.xml`:

    <beans:beans xmlns="http://www.springframework.org/schema/osgi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns:beans="http://www.springframework.org/schema/beans"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans
                                     http://www.springframework.org/schema/beans/spring-beans.xsd
                                     http://www.springframework.org/schema/osgi
                                     http://www.springframework.org/schema/osgi/spring-osgi.xsd">
        <reference id="applicationConfiguration" interface="org.apache.taverna.configuration.app.ApplicationConfiguration" />
        <reference id="proxyConfiguration" interface="org.apache.taverna.configuration.proxy.HttpProxyConfiguration" />
        <reference id="configurationManager" interface="org.apache.taverna.configuration.ConfigurationManager" />
        <reference id="downloadManager" interface="org.apache.taverna.download.DownloadManager" />
        <reference id="pluginManager" interface="org.apache.taverna.plugin.PluginManager" />
        <reference id="updateManager" interface="org.apache.taverna.update.UpdatenManager" />
    </beans:beans>

## Source code

Below you can find all Taverna OSGi source releases.

After downloading the files,
[verify the PGP signatures](https://www.apache.org/info/verification.html)
using the Apache Taverna [KEYS](https://www.apache.org/dist/incubator/taverna/KEYS)
file.

### taverna-osgi-0.2.1-incubating

**Apache Taverna OSGi 0.2.1-incubating** was published on 2016-03-11, and is available for download
from official mirrors of the
ASF Distribution Directory [incubator/taverna/](https://www.apache.org/dyn/closer.cgi/incubator/taverna/):

* [taverna-osgi-0.2.1-incubating-source-release.zip](https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-osgi-0.2.1-incubating/apache-taverna-osgi-0.2.1-incubating-source-release.zip)
  ([asc](https://www.apache.org/dist/incubator/taverna/source/taverna-osgi-0.2.1-incubating/apache-taverna-osgi-0.2.1-incubating-source-release.zip.asc),
  [md5](https://www.apache.org/dist/incubator/taverna/source/taverna-osgi-0.2.1-incubating/apache-taverna-osgi-0.2.1-incubating-source-release.zip.md5),
  [sha1](https://www.apache.org/dist/incubator/taverna/source/taverna-osgi-0.2.1-incubating/apache-taverna-osgi-0.2.1-incubating-source-release.zip.sha1),
  [sha256](https://www.apache.org/dist/incubator/taverna/source/taverna-osgi-0.2.1-incubating/apache-taverna-osgi-0.2.1-incubating-source-release.zip.sha256),
  [sha512](https://www.apache.org/dist/incubator/taverna/source/taverna-osgi-0.2.1-incubating/apache-taverna-osgi-0.2.1-incubating-source-release.zip.sha512))

The Taverna OSGi [changelog](https://issues.apache.org/jira/secure/ReleaseNote.jspa?version=12332248&projectId=12318322)
is available from the [Apache Taverna Jira](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20component%20%3D%20%22Taverna%20OSGi%22).


### Source code repositories

For the latest developments you may also be interested in the corresponding
 [source code](/download/code/) repositories:

* [incubator-taverna-osgi](https://github.com/apache/incubator-taverna-osgi)

Each release has a corresponding tag, e.g. `0.2.1-incubating`.

### Archived releases

For all archived Apache Taverna releases, see
[archive.apache.org](https://archive.apache.org/dist/incubator/taverna/).
