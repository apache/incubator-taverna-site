Title:
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
Currently there is no Apache release of any Taverna products.
This page is a template for the download page once an Apache version is available. 
</div>

##Pre Apache Releases and Snapshots

The pre Apache Taverna code is available as a maven download from 
  <http://repository.mygrid.org.uk/artifactory/mygrid-all/>

#### Release repository
    <repository>
        <id>mygrid-repository</id>
        <name>myGrid Repository</name>
        <url>http://www.mygrid.org.uk/maven/repository</url>
        <releases />
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>

#### Snapshot repository
    <repository>
        <id>mygrid-snapshot-repository</id>
        <name>myGrid Snapshot Repository</name>
        <url>http://www.mygrid.org.uk/maven/snapshot-repository</url>
        <releases>
            <enabled>false</enabled>
        </releases>
        <snapshots />
    </repository>

