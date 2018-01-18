Title:     Maven repository
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

<div class="alert alert-info" role="alert"><p><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
Taverna is transitioning to the Apache Incubator.
This page is a template for the download page once a complete Apache version is available.
</div>

**Contents**

[TOC]

## Apache releases

Apache Taverna releases are distributed in
[Apache's Maven repository](https://repository.apache.org/content/repositories/releases/org/apache/taverna/language/)
which is also mirrored to Maven's default
[Maven Central](https://repo.maven.apache.org/maven2/org/apache/taverna/).

Therefore, normally no `<repository>` should be needed to use
released Apache Taverna Maven artifacts, however in some situations you may
need to specify:

    <repository>
        <id>central</id>
        <name>Central Repository</name>
        <url>https://repo.maven.apache.org/maven2</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>      
    </repository>

See the individual [download pages](/download) for details of
Maven `<dependencies>`.

### Snapshots

[Snapshot builds](/download/code/#snapshot-builds) are available for developers
who want to take part in the Apache Taverna
[developer community](http://taverna.incubator.apache.org/community/).

    <repository>
        <id>apache.snapshots</id>
        <name>Apache Snapshot Repository</name>
        <url>https://repository.apache.org/snapshots</url>
        <releases>
            <enabled>false</enabled>
        </releases>
    </repository>

Note that the snapshot builds are _not_ official releases and should be
considered unstable.

It is recommended to subscribe to the
[dev@taverna mailing list](/community/lists#devtaverna)
before using the `-SNAPSHOT` builds.

## Pre-Apache releases and snapshots

The pre-Apache Taverna artifacts are available as a Maven download from
  <https://repository.mygrid.org.uk/artifactory/mygrid-all/>,
hosted by the [eScience Lab, University of Manchester](http://www.esciencelab.org.uk/)

> Note that these repositories are _not_ affiliated with Apache Software Foundation
and are maintained for archival purposes only.

You may need to use the Maven repository if developing plugins for Taverna 2.x:

#### Release repository

    <repository>
        <id>mygrid-repository</id>
        <name>myGrid Repository</name>
        <url>https://repository.mygrid.org.uk/artifactory/mygrid-all/</url>
        <releases />
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>

#### Snapshot repository

    <repository>
        <id>mygrid-snapshot-repository</id>
        <name>myGrid Snapshot Repository</name>
        <url>https://repository.mygrid.org.uk/artifactory/mygrid-snapshots/</url>
        <releases>
            <enabled>false</enabled>
        </releases>
        <snapshots />
    </repository>

