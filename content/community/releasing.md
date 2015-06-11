Title:     Releasing Apache Taverna
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

Anyone in the [Apache Taverna community](/community/)
can propose a release, although usually a release is
prepared by one of the [committers](/about/).
This page describes the procedure for preparing and voting
over a release.

> Release early, release often

**Note**: This page is still a *draft* under development. See [TAVERNA-812](https://issues.apache.org/jira/browse/TAVERNA-812)
for tasks required for a release.

## Preparations

* Email dev@taverna to say a release is imminent. This gives the community a chance to finish up anything they want to get into the next release.
* Check Jira for [issues](https://issues.apache.org/jira/browse/TAVERNA) for the corresponding
[components](https://issues.apache.org/jira/browse/TAVERNA/?selectedTab=com.atlassian.jira.jira-projects-plugin:components-panel)

### Prepare your build machine

You need to build and release Apache Taverna from a machine you have control
over. Make sure you have a recent version of `java` and `mvn`:

    stain@biggie-utopic:~/src/taverna$ java -version
    openjdk version "1.8.0_45-internal"
    OpenJDK Runtime Environment (build 1.8.0_45-internal-b14)
    OpenJDK 64-Bit Server VM (build 25.45-b02, mixed mode)

    stain@biggie-utopic:~/src/taverna$ mvn -version
    Apache Maven 3.3.1 (cab6659f9874fa96462afef40fcf6bc033d58c1c; 2015-03-13T20:10:27+00:00)
    Maven home: /home/stain/software/maven
    Java version: 1.8.0_45-internal, vendor: Oracle Corporation
    Java home: /usr/lib/jvm/java-8-openjdk-amd64/jre
    Default locale: en_GB, platform encoding: UTF-8
    OS name: "linux", version: "3.19.0-18-generic", arch: "amd64", family: "unix"

Then let's have a clean Maven Repository to ensure the build works out of the box.

    cd ~/.m2/
    mv repository repository-old
    rm -rf repository-old &

Similarly we'll check out freshly from git to a new folder,
to ensure uncommitted files are not being included in the release.
For the examples below, we'll create and use `~/src/rc1`
as the working directory.

    mkdir rc1
    cd rc1


### Fresh checkouts

Then we'll clone the Taverna git repositories that we are going to release.
Be sure to clone using the *Apache Committer* URLs, as found on the
[/download/code/](repositories) page:

    git clone https://git-wip-us.apache.org/repos/asf/incubator-taverna-maven-parent.git
    git clone https://git-wip-us.apache.org/repos/asf/incubator-taverna-maven-language.git

Note that you do not need to clone the repositories which are already
released and which don't form part of this release.

## Git config

*Important*: Make sure that each new checkout have the correct
user name information and your `@apache.org` email address:

    cd incubator-taverna-maven-parent
    git config user.name "Your Name"
    git config user.email you@apache.org

    cd ../incubator-taverna-language
    git config user.name "Your Name"
    git config user.email you@apache.org


  


### Verify build  

Now we'll make sure they build normally, *pass all the tests* and
complete with `BUILD SUCCESS`:

    mvn clean verify

Note that this would download all the *dependencies* from Maven Central.

### Maven repository access

When releasing a stable version, Maven will deploy to Apache's
[Maven repository](https://repository.apache.org), a Nexus instance.
Here, a *staging repository* will be automatically created.

Ensure you can log in to the Nexus instance before performing a release.

To provide the Nexus credentials, edit your `~/.m2/settings.xml` to include
your apache.org committer credentials:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <!-- .. -->
  <servers>
    <!-- .. -->

    <server>
      <id>apache.snapshots.https</id>
      <username>johndoe</username>
      <password>fishsoup</password>
    </server>
    <server>
      <id>apache.releases.https</id>
      <username>johndoe</username>
      <password>fishsoup</password>
    </server>
  </servers>
</settings>
```


To check you have the correct credentials set up for
write-access to
[Apache's Maven repository](https://repository.apache.org/content/repositories/snapshots/org/apache/taverna/),
deploy the current SNAPSHOT:

    mvn deploy

This is best tested with a small repository like `taverna-maven-parent` as it
will perform a build.

### Closing old staging repositories

Check the list of open
[Staging Repositories](https://repository.apache.org/#stagingRepositories)
on the Nexus instance, and Close/Drop any old `orgapachetaverna-*` repositories.
Do not touch the other repositories.

## Creating release candidate

### Figure out release order

If more than one repository needs to be released, e.g. because the
newer SNAPSHOT version is needed, then those repositories needs
to be released in incrementing order. The dependency order is
generally from top to bottom of the list in
[code download page](/download/code)

### Fix versions

Edit the top-level `pom.xml` of the repository to ensure there
are no `-SNAPSHOT` dependencies in its `<parent>` and
`<properties>`.

Check if a newer `taverna-maven-parent` or other `taverna.*.version`
is needed. This is usually indicated by depending on an unreleased
SNAPSHOT version.  Accordingly, after the release, do *not* update
these versions to the bumped SNAPSHOT versions, as that would
wrongly indicate that a newer dependency is needed.

Update all `taverna.*.version` properties
to the *latest released version*.
(Exception to the rule - when OSGi backwards-compatibility is
needed, e.g. a wsdl-activity that should work also with an older
taverna-engine release).

Commit your `pom.xml` changes (if any) and push.

    git commit -m "Dependency updates for release 1.2.3" pom.xml
    git push

### Prepare release candidate

Using the
[Maven release plugin](https://maven.apache.org/maven-release/maven-release-plugin/)
is the recommended way to create
release candidates as it ensures a consistent release process:

    mvn release:prepare

(Note: The parameter `-Papache-release` is no longer needed, as it is activated by the
[maven-release-plugin configuration](https://github.com/apache/incubator-taverna-maven-parent/blob/master/pom.xml#L301)
in taverna-maven-parent)

The default for "What is the release version for" is usually good - but check the policy for version numbers below.

    [INFO] Checking dependencies and plugins for snapshots ...
    What is the release version for "Apache Taverna (incubating) Maven parent"? (org.apache.taverna:taverna-parent) 1-incubating: : 1-incubating

For the tag, use the proposed format, but append `-RC1` or equivalent to indicate
the release candidate number in the tag. (Note: the `RC1` string should *NOT* be part of
the version number, only the tag, as the released Maven artifacts would eventually
be published as-is). This ensures that there is a tag for the particular release
candidate that is subject to the *[VOTE]*.

    What is SCM release tag or label for "Apache Taverna (incubating) Maven parent"? (org.apache.taverna:taverna-parent) taverna-parent-1-incubating: : taverna-parent-1-incubating-RC1

The next development vesion should usually be one patch version higher,
or for taverna-maven-parent simply the next number:

    What is the new development version for "Apache Taverna (incubating) Maven parent"? (org.apache.taverna:taverna-parent) 2-incubating-SNAPSHOT: :

Maven will now transform your poms, create the tag, and push it back to
Apache's git repository.

If anything goes wrong, then you probably need to undo and start again:

    mvn release:rollback

### Deploying the release candidate

If the preparation was successful, then you should now be able to do:

    mvn release:perform

This will check out the tag, build it, then deploy the compiled artifacts,
and sign the packaged source code.

Note that this will use `gpg` to sign the artifacts - so you might want to
use a *GPG Agent* to avoid repeatedly providing your GPG passphrase.


### Policy for Apache Taverna version numbers

* Has to end in `-incubating` (while Apache Taverna is incubating)
* taverna-maven-parent is versioned with just major version, e.g. `4-incubating`
* All other repositories use [Semantic Versioning 2.0.0](http://semver.org/spec/v2.0.0.html),
e.g. `2.13.1-incubating`

Semantic versioning summary:

> Given a version number MAJOR.MINOR.PATCH, increment the:
>
> * MAJOR version when you make incompatible API changes,
> * MINOR version when you add functionality in a backwards-compatible manner, and
> * PATCH version when you make backwards-compatible bug fixes.

### Locate the staging repository

On Apache's Nexus instance, locate the
[Staging Repository](https://repository.apache.org/#stagingRepositories)
for the code you just released. It should be called something like
`orgapachetaverna-1001` -- check the *Updated* timestamp.

**DO NOT CLICK RELEASE** - the release candidate must pass *[VOTE]* emails
on both dev@taverna and general@incubator before we release.


## Voting

**TODO**

## Distributing
