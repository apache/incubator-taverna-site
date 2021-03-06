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

## Preparations

* Email dev@taverna to say a release is imminent. This gives the community a chance
to finish up anything they want to get into the next release.
* Check Jira for [issues](https://issues.apache.org/jira/browse/TAVERNA) on the corresponding
[components](https://issues.apache.org/jira/browse/TAVERNA/?selectedTab=com.atlassian.jira.jira-projects-plugin:components-panel).
If you find any that are blocking or in progress, consult with the dev@taverna list first.
* Create and maintain a Jira task to keep track of the subtasks. You may want to be
inspired by [TAVERNA-902](https://issues.apache.org/jira/browse/TAVERNA-902)

### Jira updates

Check the [Jira versions](https://issues.apache.org/jira/plugins/servlet/project-config/TAVERNA/versions)
have a corresponding version for the release you are preparing, and a new version
for the following development version.  E.g. you are preparing the release
candidate taverna-language 0.15.1, so make sure `language 0.15.1` exists, and create
`language 0.16.0` for the next development. You should also check that the earlier
published version is marked as Published in Jira - you may need to find the _Published
date_ by looking in the email archives.

Go through the *open issues* for the components you are preparing to release,
e.g. [Unresolved for Taverna Maven Parent](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20resolution%20%3D%20Unresolved%20AND%20component%20%3D%20%22Taverna%20Maven%20Parent%22%20ORDER%20BY%20priority%20DESC) - close those that are done, and reschedule
_Fix Version_ to a later version if their "Fix Version" is set to the one
you are preparing (or earlier).

Now go through issues that are resolved since the previous release
(e.g. [Done/In Review Taverna Language issues with Fix For No/Unreleased ](https://issues.apache.org/jira/issues/?jql=project%20%3D%20TAVERNA%20AND%20status%20in%20%28Done%2C%20%22In%20Review%22%29%20AND%20fixVersion%20in%20%28EMPTY%2C%20unreleasedVersions%28%29%29%20AND%20component%20%3D%20%22Taverna%20Language%22%20ORDER%20BY%20updated%20DESC)),
and set their _Fix version_ to your release candidate version, so that
they will appear in the generated
[Release notes](https://issues.apache.org/jira/secure/ReleaseNote.jspa?projectId=12318322&version=12332247)
(click _Configure Release Notes_).


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

Then let's have a **clean Maven Repository** to ensure the build works out of the box.

    cd ~/.m2/
    mv repository repository-old
    rm -rf repository-old &

Similarly we'll use a **fresh check out** from git to a new folder,
to ensure uncommitted files are not being included in the release.
For the examples below, we'll create and use `~/src/rc1`
as the working directory.

    mkdir rc1
    cd rc1

### GPG keys

You need to have `gpg` and preferably a *GPG Agent* installed on the machine
you will build the release on. This needs to be configured with your
[GPG release key](https://www.apache.org/dev/release-signing.html).

Check that the Apache Taverna
[KEYS](https://dist.apache.org/repos/dist/release/incubator/taverna/KEYS) file
contains your correct key and fingerprint. If not, then:

Find your PGP fingerprint:

    stain@biggie-utopic:~/src/rc1/dist$ gpg --fingerprint stain@apache.org
    pub   1024D/A0FFD119 2002-01-20
    Key fingerprint = DDDE E876 12E9 FB95 F5C8  D91E 4110 63A3 A0FF D119
    uid                  Stian Soiland-Reyes <stian@soiland-reyes.com>
    uid                  Stian Soiland <stian@soiland.no>
    uid                  Stian Soiland <stain@nvg.org>
    uid                  Stian Soiland <stain@soiland.no>
    uid                  [jpeg image of size 9477]
    uid                  Stian Soiland <stain@s11.no>
    uid                  Stian Soiland-Reyes <soiland-reyes@cs.manchester.ac.uk>
    uid                  Stian Soiland-Reyes <stain@apache.org>
    sub   4096R/4BBAC7C6 2014-06-05 [expires: 2016-06-10]

Edit your details on [id.apache.org](https://id.apache.org/)
to provide your *OpenPGP Public Key Primary Fingerprint*,
e.g.:

    DDDE E876 12E9 FB95 F5C8  D91E 4110 63A3 A0FF D119

Check your key has **not expired** - you can use `gpg --edit-key`
and `gpg --send-key` to update.

Now verify that the
[people.apache.org taverna.asc](https://people.apache.org/keys/group/taverna.asc)
file now includes the correct key fingerprint, and update on dist:

    svn co https://dist.apache.org/repos/dist/release/incubator/taverna/
    cd taverna
    wget https://people.apache.org/keys/group/taverna.asc
    cat KEYS.template taverna.asc > KEYS
    rm taverna.asc  
    svn commit -m "Updated KEYS" KEYS


### Fresh checkouts

Then we'll clone the Taverna git repositories that we are going to release.
Be sure to clone using the *Apache Committer* URLs, as found on the
[/download/code/](repositories) page:

    git clone https://git-wip-us.apache.org/repos/asf/incubator-taverna-maven-parent.git
    git clone https://git-wip-us.apache.org/repos/asf/incubator-taverna-language.git

Note that you do not need to clone the repositories which are already
released and which don't form part of this release.

## Git config

Make sure that each new checkout have the correct
user name information and your `@apache.org` email address, as
the Maven Release plugin will be doing the tagging on your behalf.

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
your apache.org committer credentials for the servers
`apache.snapshots.https` and `apache.releases.https`:

    <?xml version="1.0" encoding="UTF-8"?>
    <settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
      <servers>
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
Do not touch the other repositories from other projects.

## Creating release candidate

### Figure out release order

If more than one git repository needs to be released,
e.g. because the newer SNAPSHOT version is needed, then those
repositories needs to be released in incremental order. The
dependency order is generally from top to bottom of the list on
the [code download page](/download/code), e.g. `taverna-language`
before `taverna-engine` before `taverna-workbench`.

### Fix versions

Edit the top-level `pom.xml` of each project to release, ensuring there
are no `-SNAPSHOT` dependencies in its `<parent>` and
`<properties>`.

**Do not fix** the `<version>` of the Maven project itself or
its submodules, as they must be on the form `*-SNAPSHOT` in
order for the Maven Release Plugin to modify them.

Check if a newer `apache-taverna-maven-parent` or other `taverna.*.version`
dependencies are needed. This is usually indicated by depending on an
unreleased `-SNAPSHOT` version.  Accordingly, after the release process,
do *not* update `master` to use the bumped SNAPSHOT versions, as that would
wrongly indicate that a newer dependency is needed. (_After the
release_ you should change the `master` branch `pom.xml` so that
the `<properties>` and `<parent>` use the current public release
(not the release candidate, as it is not yet public).)

For compile/test purposes, update all `taverna.*.version` properties
to the *latest released version* - or the staging version if you
need to depend on a release candidate version that is being
prepared together with this one.

Exception to the rule: - when OSGi backwards-compatibility is
needed, e.g. an updated wsdl-activity that should work also with an
older taverna-engine-api release.

Remember that in OSGi, as long as we follow semantic
versioning and don't break API compatibility, an upstream
dependency can be updated without forcing an update release
of its downstream users.

If you are updating `apache-taverna-maven-parent`, then try to
update this to use the latest version of the
[Apache super-pom](http://central.maven.org/maven2/org/apache/apache/) - be aware
that this could change Maven build settings.

Commit your `pom.xml` changes (if any) and push.

    git commit -m "Dependency updates for release 1.2.3" pom.xml
    git push

### Prepare release candidate

We use the
[Maven release plugin](https://maven.apache.org/maven-release/maven-release-plugin/)
to release candidates as it ensures a consistent release process:

    mvn release:prepare -DautoVersionSubmodules=true

**Note:** Maven will use `gpg` multiple times to tag and sign the
artifacts - so you might want to install and configure
a **GPG Agent** to avoid repeatedly providing your
GPG passphrase.


The defaults for "What is the release version for" is usually good (assuming the SNAPSHOT version has been
correctly bumped for any major/minor/patch changes to the code),
but check the [policy for version numbers below](#Version_numbers).

    [INFO] Checking dependencies and plugins for snapshots ...
    What is the release version for "Apache Taverna Language APIs (Scufl2, Databundle)"? (org.apache.taverna.language:taverna-language) 0.15.0-incubating: :
    What is the release version for "Apache Taverna Baclava support"? (org.apache.taverna.language:taverna-baclava-language) 0.15.0-incubating: :
    What is the release version for "Apache Taverna Scufl 2 UCF Package"? (org.apache.taverna.language:taverna-scufl2-ucfpackage) 0.15.0-incubating: :
    What is the release version for "Apache Taverna Scufl 2 API"? (org.apache.taverna.language:taverna-scufl2-api) 0.15.0-incubating: :

If you do not include `-DautoVersionSubmodules=true` you will be asked for each
submodule what version they should have - generally their version should be
the same as their parent (except to explicitly allow API backward compatibility).

**Note**: Take care to use the correct version number if preparing a
second release candidate, as Maven could suggest a higher version
number based on the bumped `-SNAPSHOT` version.  

**Important**: If Maven prompts for the new
_development_ *parent* version remember to set it back to the previous
`*-incubating-SNAPSHOT` (where `*`` is what is now in the parent pom).
The reason for this is that the taverna-maven-parent
release candidate will remain in the staging repository
and can't be used by developers until it is released - and if
you bump this to the next SNAPSHOT version early, then other modules
that may rely on the previous SNAPSHOT will stop working as the
Nexus repository wipes older SNAPSHOTS regularly - and this
could break Jenkins builds and developer builds.
(Too late? You can always fix this manually in the pom and
commit manually after the release has been performed/deployed.)


#### Version numbers

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

Use `git diff` against the previous release tag for a rough check for changes.

    git diff 0.15.0-incubating-RC2

Note that as we use of OSGi, the public Java API is usually just what is exposed
by the `*-api` modules, meaning that implementation changes normally should
just warrant a new patch version. We should also consider indirect APIs, such
as an Activity's expected JSON configuration or
the REST API of the Taverna Server.  

Check with dev@taverna if you are not sure. Usually bumping minor
(e.g. from `1.5.2` to `1.6.0`) is the right option, as we release all
modules in the git repository.


#### Tagging and next SNAPSHOT version

For the tag, use the proposed format (`0.15.0-incubating-RC1`), but
modify `-RC1` for any subsequent release candidates.

    What is SCM release tag or label for "Apache Taverna Language APIs (Scufl2, Databundle)"? (org.apache.taverna.language:taverna-language) 0.15.0-incubating-RC1: :

**Module-specific release**: If a hot-patch update of a
particular Maven module is being released from within its subfolder,
then prefix the tag-name with the module name,
e.g. `taverna-scufl2-t2flow-0.15.1-incubating-RC1`. Note that preparing a
single module release requires careful consideration for
setting the `<parent>` and `<dependency>` versions and
should generally be avoided.

The next development version should usually be one *patch version* higher,
or for taverna-maven-parent simply the next number:

    What is the new development version for "Apache Taverna Language APIs (Scufl2, Databundle)"? (org.apache.taverna.language:taverna-language) 0.15.1-incubating-SNAPSHOT: :
    What is the new development version for "Apache Taverna Baclava support"? (org.apache.taverna.language:taverna-baclava-language) 0.15.1-incubating-SNAPSHOT: :
    What is the new development version for "Apache Taverna Scufl 2 UCF Package"? (org.apache.taverna.language:taverna-scufl2-ucfpackage) 0.15.1-incubating-SNAPSHOT: :
    What is the new development version for "Apache Taverna Scufl 2 API"? (org.apache.taverna.language:taverna-scufl2-api) 0.15.1-incubating-SNAPSHOT: :


Maven will now transform your poms, create the tag, and push changes
back to Apache's git repository.

If you abort, you can start the process again using `mvn release:prepare`,
which will pick up your answers so far from the file `release.profiles`.



#### Rolling back

If anything goes wrong at this stage, you will need to undo,
edit and commit required changes, and start again:

    mvn release:rollback
    vi foo/pom.xml
    git commit
    git push
    mvn release:prepare


### Deploying the release candidate

If the preparation was successful, then you should now be able to do:

    mvn release:perform

This will check out the tag, build it, then sign and
deploy the packaged source code and compiled JARs
to `repository.apache.org`.



### Locate the staging repository

On Apache's Nexus instance, locate the
[Staging Repository](https://repository.apache.org/#stagingRepositories)
for the code you just released. It should be called something like
`orgapachetaverna-1001` -- check the *Updated* time stamp and click to
verify its *Content*.

You can leave the staging repository *Open* until you have released all the
projects that will form part of this *[VOTE]*, e.g. you can deploy both
`taverna-maven-parent` and `taverna-language` using the same staging repository.

**Important** - When all artifacts to be deployed are in the staging repository, tick the box
next to it and click *Close*.

**DO NOT CLICK RELEASE YET** - the release candidate must pass *[VOTE]* emails
on both dev@taverna and general@incubator before we release.

Once closing has finished (check with *Refresh*), browse to the
*URL*  of the
[staging repository](https://repository.apache.org/content/repositories)
which should be something like
`https://repository.apache.org/content/repositories/orgapachetaverna-1003/`


### Uploading to dist.apache.org

The release candidate source code, checksums and signatures
should be uploaded to the `dev` area of
[dist.apache.org](https://dist.apache.org/repos/dist/dev/incubator/taverna/)
using `svn` - which we'll check out to a new folder `~/src/rc1/dist`:

    svn co https://dist.apache.org/repos/dist/dev/incubator/taverna dist

The `source` folder of `dev` should normally be empty -- if
you find remains of an earlier RC that is not
still under *[VOTE]*, first remove them with `svn rm`:

    cd dist/source
    svn rm *

Now go back to the *dist* directory. Retrieve the source archives from the staging repository by looking for
`-*source-release.zip` (not `sources.jar`!) in the
staging repository, located under the
folder corresponding to the groupID and artifactId of the
top-level project, e.g. `org/apache/taverna/language/0.15.0-incubating/`
containing `taverna-language-0.15.0-incubating-source-release.zip`

For consistency checking you also need to include the
PGP signature `.asc` and the checksums
`.sha1` and `.md5`

Here's a convenient `wget` command to get all the release archives,
their checksums and signatures:

    wget -e robots=off --recursive --no-parent --no-directories -A "*-source-release*" https://repository.apache.org/content/repositories/orgapachetaverna-1002/org/apache/taverna/

Make sure you have not got any extra files in your `dist/` folders, like
`index.html` or duplicates like `*.zip.1`.  You can delete any files ending in `.asc.md5`.

    stain@biggie-utopic:~/src/rc1/dist$  ls
    binaries/ source/
    taverna-language-0.15.0-incubating-source-release.zip	   taverna-language-0.15.0-incubating-source-release.zip.sha1  taverna-parent-1-incubating-source-release.zip.md5
    taverna-language-0.15.0-incubating-source-release.zip.asc  taverna-parent-1-incubating-source-release.zip	       taverna-parent-1-incubating-source-release.zip.sha1
    taverna-language-0.15.0-incubating-source-release.zip.md5  taverna-parent-1-incubating-source-release.zip.asc

Under `source/`, make a corresponding versioned folder for each product,
and *include the RC number*, avoiding confusion in case you need to
make a second release candidate:

    mkdir source/taverna-language-0.15.0-incubating-RC2
    mkdir source/taverna-parent-1-incubating-RC2
    mv *language*release* source/taverna-language-0.15.0-incubating-RC2
    mv *parent*release* source/taverna-parent-1-incubating-RC2


Now add them to the `source` folder with `svn add` and `svn commit`

    svn add taverna-language-0.15.0-incubating-RC1 taverna-parent-1-incubating-RC1
    svn commit -m "taverna-language 0.15.0-incubating-RC1"

If any binary distributions are also be provided from the
[Download page](/download) (e.g. Taverna Workbench installers and
Taverna Server `war`s), then download them as well *from the staging
repository* and add them under equivalent versioned folders in `binaries/`,
including their corresponding
`.asc`, `.md5` and `.sha1` files,

Versioned folders make it easier to tidy up after a dropped release
candidate, and easier to promote the release.

Now verify that the files are available on
[https://dist.apache.org/repos/dist/dev/incubator/taverna/](https://dist.apache.org/repos/dist/dev/incubator/taverna/) -
you might need a *Refresh* in the browser.



## Voting

Any Apache release must be approved through a
[vote](http://www.apache.org/foundation/voting.html)
of the project's PMC. As Apache Taverna is an incubating project, a Taverna release must be
approved by both the  [Apache Taverna PPMC](/about) followed by the
[Apache Incubator IPMC](http://incubator.apache.org/guides/ppmc.html).

Before an Apache Taverna release can be distributed, it must thus pass two stages:

* [VOTE] on dev@taverna
* [VOTE] on general@incubator

Each of the *[VOTE]* threads should be open for **at least 72 hours**, allowing time for
sufficient [review](#Reviewing), and catering for differences in
holidays and timezones.

Including 24 hours grace period for the download mirrors to update,
this means a release takes a minimum of a week before
a release candidate might be published and released.

Anyone in the [community](/community) can participate in the
review and vote, not just PMC members or committers. Only votes
from IPMC members (e.g. our mentors) are **binding**.


### Vote email to dev@taverna

To start the release vote, modify the below example and send to dev@taverna.
Remember `[VOTE]` in the subject line and change the version number to match the
release candidate.

```
Subject: [VOTE] Release Apache Taverna Language 0.15.0-incubating RC2

I am pleased to be calling this vote for the source release of

  Apache Taverna Maven Parent 1-incubating
  Apache Taverna Language 0.15.0-incubating

To discuss this release candidate, use the corresponding [DISCUSS] thread.


Apache Taverna Language is a set of APIs for workflow definitions (SCUFL2)
and workflow inputs/outputs/run (DataBundle), as consumed and produced by the
Apache Taverna workflow system. The API includes support for working with
Research Object Bundles, and loading/saving Taverna workflows in different
formats.


The release candidates to be voted over are available at:

  https://dist.apache.org/repos/dist/dev/incubator/taverna/source/taverna-parent-1-incubating-RC2/
  https://dist.apache.org/repos/dist/dev/incubator/taverna/source/taverna-language-0.15.0-incubating-RC2/

  SHA-1 checksums:
  8199880048a59cde622e0caa24c3bc3d83bc5d5a  taverna-parent-1-incubating-source-release.zip
  7032e9d2be834f7c029aae562b62613481bf6939  taverna-language-0.15.0-incubating-source-release.zip

  MD5 checksums:
  7f9b107b9f1dc0407783ac0ad484d6ea  taverna-parent-1-incubating-source-release.zip
  35d3085b596b2dd4b30a0234259efade  taverna-language-0.15.0-incubating-source-release.zip


Build the release candidate in the above order, using:

    mvn clean install

The release candidates correspond to the following git commits:

  https://git-wip-us.apache.org/repos/asf?p=incubator-taverna-maven-parent.git;a=commit;h=3ba669c78782d3fc3b548e2a512d201ee922b34a
  https://git-wip-us.apache.org/repos/asf?p=incubator-taverna-language.git;a=commit;h=3340e2090e604b40ac0b88675f57c1d12032d060



Release candidates are signed with a GPG key available at:

  https://dist.apache.org/repos/dist/release/incubator/taverna/KEYS

A staged Maven repository is available for review at:

  https://repository.apache.org/content/repositories/orgapachetaverna-1003/

The changelog for this release is available from JIRA:

  https://issues.apache.org/jira/secure/ReleaseNote.jspa?projectId=12318322&version=12332247
  https://issues.apache.org/jira/secure/ReleaseNote.jspa?projectId=12318322&version=12332246



Please vote on releasing these packages as:

  Apache Taverna Maven Parent 1-incubating
  Apache Taverna Language 0.1.0-incubating


The vote is open for at least 72 hours and passes if a
majority of at least three +1 Apache Taverna PPMC votes are cast.

[ ] +1 Release this package
[ ]  0 I don't feel strongly about it, but don't object
[ ] -1 Do not release this package because...

Anyone can participate in testing and voting, not just
committers, please feel free to try out the release candidate
and provide your votes.
```

### Discuss email to dev@taverna

It is also recommended to start the discussion around the release candidate with
a separate thread with subject  

> [DISCUSS]: Release Apache Taverna Language 0.15.0-incubating RC2  

Remember to change the version number as appropriate for the release candidate.

**Tip:** Do not use the "Reply to All" button from the `[VOTE]` email to create the
`[DISCUSS]` thread - as then they would still appear as a single thread
due to the `In-Reply-To` email header.


### Tallying the vote

After at least 72 hours, count the votes in the [VOTE] thread. You need to
count separately the **binding** votes from mentors, as these can
carry over to the general@incubator vote.

You can find URLs for individual emails (e.g. the binding votes) in the
[dev@taverna archive](http://mail-archives.apache.org/mod_mbox/incubator-taverna-dev/)
by clicking a message and then clicking *Permalink*.  Note that the email
archive may be slow to update.


To close the vote thread, send a `[RESULT][VOTE]` email to dev@taverna, e.g.

```
Subject: [RESULT][VOTE] Release Apache Taverna Parent 1-incubating-RC4 & Apache Taverna Language 0.15.0-incubating RC4

Voting for Apache Taverna Parent 1-incubating & Apache Taverna
Language 0.15.0-incubating is now closed.  The release has
*passed* with the following tally:

Binding +1s:

Marlon Pierce (see
http://mail-archives.apache.org/mod_mbox/incubator-taverna-dev/201507.mbox/%3CD1E0E778.447EC%25marpierc%40iu.edu%3E)

Andy Seaborne (see
http://mail-archives.apache.org/mod_mbox/incubator-taverna-dev/201508.mbox/%3C55C86B79.3040006%40apache.org%3E)


Non binding +1s:

Ian Dunlop
Alan Williams
Stian Soiland-Reyes
Donal K. Fellows
```

If the vote has not passed (at least +3, or more negative than positive)
then you will need to pull the release candidate and start over after
addressing the concerns.

If there are any `-1` or `0` votes, then those concerns should be addressed.
Often it can be sufficient to just track these in Jira as scheduled
for the next release - while other times the concern could be grave
enough to pull the release (e.g. doesn't compile).



### Vote email to general@incubator

Using the tally count, now you can send another `[VOTE]` email to the
[general@incubator](http://mail-archives.apache.org/mod_mbox/incubator-general/)
list (which you must be subscribed to):


```
Subject: [VOTE] Release Apache Taverna Parent 1-incubating-RC4 & Apache Taverna Language 0.15.0-incubating RC4

The Apache Taverna Incubator PPMC has voted +5 to release

Apache Taverna Parent 1-incubating (RC4)
Apache Taverna Language 0.15.0-incubating (RC4)

Incubator PMC members please review and vote on this incubator release.

Apache Taverna Language is a set of APIs for workflow definitions
(SCUFL2) and workflow inputs/outputs/run (DataBundle), as consumed and
produced by the Apache Taverna workflow system. The API includes
support for working with Research Object Bundles, and loading/saving
Taverna workflows in different formats.

Please see original [VOTE] thread
http://mail-archives.apache.org/mod_mbox/incubator-taverna-dev/201507.mbox/%3C55B8DBC7.2040806%40manchester.ac.uk%3E

and [DISCUSS] thread
http://mail-archives.apache.org/mod_mbox/incubator-taverna-dev/201507.mbox/%3C55B8DC3F.2070602%40manchester.ac.uk%3E


The release candidates to be voted over are available at:

  (.. copy the download/test details from previous email)

Please vote on releasing these packages as:

Apache Taverna Maven Parent 1-incubating
Apache Taverna Language 0.15.0-incubating

The vote will be open for a minimum of 72 hours.

[ ] +1 Release this package
[ ] 0 I don't feel strongly about it, but don't object
[ ] -1 Do not release this package because...
```



## Dropping a release candidate

If a release candidate is to be dropped, e.g. it fails the *[VOTE]*, then:

In Nexus, tick the [staging repository](https://repository.apache.org/#stagingRepositories) and *Drop*.

Delete the old tag:

    git push origin :0.15.0-incubating-RC1

Roll back the SNAPSHOT version number:

    mvn release:update-versions -DautoVersionSubmodules=true -DdevelopmentVersion=0.15.0-incubating-SNAPSHOT`

In your `dist` checkout, `svn rm` the dropped RC folders:

    svn rm *RC*

Raise Jira issues for the reasons that caused the RC to be dropped.

## Distributing

Once a *[VOTE] [Results]* email has been agreed on general@incubator,
then:

* Promote the release candidate to a release
* Update download page
* Send announcement email

### Moving to release area

Use full URL `svn mv` to move the accepted release candidate
to the `release` folder structure on dist.apache.org,
e.g. at
[https://dist.apache.org/repos/dist/release/incubator/taverna/source/](https://dist.apache.org/repos/dist/release/incubator/taverna/source/)
but **remember to remove the `-RC1`** part from the folder name.

    svn mv https://dist.apache.org/repos/dist/dev/incubator/taverna/source/taverna-language-0.15.0-incubating-RC2 https://dist.apache.org/repos/dist/release/incubator/taverna/source/taverna-language-0.15.0-incubating -m "Releasing apache taverna-language-0.15.0-incubating"
    svn mv https://dist.apache.org/repos/dist/dev/incubator/taverna/source/taverna-parent-1-incubating-RC2 https://dist.apache.org/repos/dist/release/incubator/taverna/source/taverna-parent-1-incubating -m "Releasing apache taverna-parent-1-incubating"

### Releasing Maven repository

Tick the correct [staging repository](https://repository.apache.org/#stagingRepositories) (perhaps do a quick check of an SHA1 sum against the vote email), then click *Release*.
It should then propagate to [Apache's release Maven repository](https://repository.apache.org/content/repositories/releases/org/apache/taverna/)
and eventually mirrored to [Maven Central](http://central.maven.org/maven2/org/apache/taverna/).


### Update download page

Wait 24 hours for the download mirrors
to pick up the new release from `dist.apache.org`, otherwise eager
users (or users who just happened to want to download that day)
may get `404 Not Found` errors.

Update (or make) the corresponding pages under https://taverna.incubator.apache.org/download/
including the correct version number for the Maven dependencies and the release dates.

Download links should be using the mirror redirector https://www.apache.org/dyn/closer.cgi, e.g.
https://www.apache.org/dyn/closer.cgi/incubator/taverna/source/taverna-language-0.15.0-incubating/taverna-language-0.15.0-incubating-source-release.zip

The asc/md5/sha1 links should go directly to https://www.apache.org/dist/ - e.g. https://www.apache.org/dist/incubator/taverna/source/taverna-language-0.15.0-incubating/taverna-language-0.15.0-incubating-source-release.zip.asc
(important bit: `https`)



### Removing old versions

**After** the download page has been published, the download mirrors have synchronized
and the new version is live
you must **remove the old versions** from https://dist.apache.org/repos/dist/release/incubator/taverna/source/

    svn rm https://dist.apache.org/repos/dist/release/incubator/taverna/source/taverna-language-0.14.0-incubating/
    svn rm https://dist.apache.org/repos/dist/release/incubator/taverna/source/taverna-parent-1-incubating/

Older versions are archived under http://archive.apache.org/dist/incubator/taverna/source/
but won't appear on the download mirrors.
