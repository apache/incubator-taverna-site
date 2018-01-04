Title:     Pre-Apache Taverna Server
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
Currently there is no Apache release of Taverna Server. 
</div>

Apache Taverna (incubating) is developing to release Taverna Server 3.1.

For now, the current version of the Server is based on the last pre-Apache release
Taverna 2.5 and is called **Taverna Server 2.5.4**.
[Documentation](/documentation/server/) for Taverna Server is available on-line.

##Installation

Taverna Server 2.5.4 was released before incubating at Apache Software Foundation, and Taverna 2.x is licensed as
[LGPL 2.1](https://www.gnu.org/licenses/old-licenses/lgpl-2.1.en.html); as these are not 
official releases from Apache Taverna this this page do not have direct download links, 
but rely on [LaunchPad's archive](https://launchpad.net/taverna-server/).

From [LaunchPad](https://launchpad.net/taverna-server/+milestone/2.5.4) 
right-click to download `TavernaServer-2.5.4.war`,
then follow the [installation instructions](/documentation/server/3.1/install)
to install the WAR file to a server like 
[Apache Tomcat](http://tomcat.apache.org/).

[Taverna Server 2.5.4](https://launchpad.net/taverna-server/+milestone/2.5.4) release:

- `TavernaServer-2.5.4.war` binary distribution (WAR, 196 MiB)
    - MD5: 20d27405b27a3418b783777171734514
    - SHA1:d2909ad0b222a001639c5337171b9e2b553f1cbc

- `install.pdf` Installation Guide (PDF, 7 MiB)
    - MD5: a91d2ccb0aca9322a92e9d456a1389aa
    - SHA1: d90daf85c09035caca48536cefd4d2d557aeca3a

- `usage.pdf` User Guide (PDF, 13 MiB)
    - MD5: 25f75e419a018d03252c63fbcd111a5f
    - SHA1: d080ea3765e8ef41a8cecc6564bf2aaf11b78199


The software distributor Launchpad has an archive of 
[earlier non-Apache releases of Taverna Server](https://launchpad.net/taverna-server/+series).

##System Requirements

####Operating system

The Server can currently be installed on Linux and Mac OS X.

####Java

You will need a Java 7 installation or newer. 
Either OpenJDK 7 or Oracle Java 7 are recommended.

> If using Oracle Java 7, you must install the 
>   **[Java Cryptography Extension extension for Java
>   1.7](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html)**
>   and follow the included README on how to install the JCE to
>   *lib/security/* of your Java installation. 
>   This is *not* necessary for OpenJDK 7.

####WebApp container

You will need a suitable servlet container.

The Server has been developed using [Tomcat 6.0.26](http://tomcat.apache.org/download-60.cgi)
   as the servlet container, but other versions of Tomcat are known to work 
   (back to at least Tomcat 6.0.20, and up to Tomcat 7.0.53) and other containers may also 
   function correctly, as no Tomcat-specific APIs are used in the deployable code. 
   We welcome feedback on which containers work, as well as on how to configure them.

##Source Code

The source code to Apache Taverna Server is available from the git repository
[incubator-taverna-server](https://github.com/apache/incubator-taverna-server)
which `master` tag corresponds to development of Taverna Server 3.1.

The 2.5.4 release was made automatically using Apache Maven from the 
[2.5.4](https://github.com/apache/incubator-taverna-server/releases/tag/old%2F2.5.4) git tag. 

If you encounter any problems, please [contact us](/community).

##Client side stuff
                   
To complement the Taverna Server, 
   we have developed several client side libraries and applications. 
They access the Server's functionality and can help you build your client applications around 
   the Server and provide exemplars of how such applications can  be implemented.

###General

 - A [Ruby gem](https://github.com/myGrid/taverna2-gem) that enables you to interact with 
     Taverna 2 workflows (.t2flow files). 
   You can generate a t2flow model using the gem, and then use it to retrieve various 
      information about the workflow by invoking different methods and attributes. You can also draw a workflow diagram using the gem.</li>
 - A [Ruby gem](https://rubygems.org/gems/taverna-baclava) for handling Baclava files.
