Title:     Editing the Website
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

The Apache Taverna website is maintained through a community effort.
No matter your affiliation to the project, please help us improve the website by
suggesting edits of any of the pages!


## Overview

Apache Taverna's web pages are managed by the [Apache CMS](http://www.apache.org/dev/cmsref.html) system, and most are written in [Markdown](https://www.apache.org/dev/cmsref.html#markdown). (These will have a `.md` file extension.)

>Edit the web pages using either
<a href="#github">GitHub pull requests</a>
or the <a href="#apache-cms">Apache CMS</a>, as described below.

Please follow the <a href="#editing-tips">editing guidelines</a> when making changes.

(Raw pages are stored in the <a href="https://svn.apache.org/repos/asf/incubator/taverna/site/trunk">SVN repository asf/incubator/taverna/site</a>.)


-----
<a name=github></a>
## GitHub pull requests

The source for the Apache Taverna website is mirrored to the GitHub project
[incubator-taverna-site](https://github.com/apache/incubator-taverna-site/tree/trunk/content),
where you can navigate to the source for the page you want to edit.

>*Anyone with a GitHub account*
can suggest an edit to an Apache Taverna page directly in the browser.

Note that **GitHub's rendering of the Markdown is not 100% equivalent** to the resulting Apache CMS HTML.  In particular, the `Title:` and `License:` headers at the top
of every `.md` file will not be rendered as shown on GitHub.

To submit your suggested change, raise a
[GitHub pull request](https://github.com/apache/incubator-taverna-site/pulls).
This will send an email on your behalf to the
[dev@taverna mailing list](/community/lists#devtaverna), where
an Apache Taverna committer will review your change before making it live
on the website.
Please sign up to [dev@taverna](/community/lists#devtaverna)
to watch for any follow-up comments about your changes.


-----
<a name=apache-cms></a>
## Apache CMS

If you are an **Apache Taverna committer**, use the
[Apache CMS](http://www.apache.org/dev/cmsref.html) directly from
[https://cms.apache.org/taverna/](https://cms.apache.org/taverna/) using your `@apache.org` account as login.

>Committers can also drag the
<a href="javascript:void(location.href='https://cms.apache.org/redirect?uri='+escape(location.href))">Edit in CMS</a>
 bookmarklet to your browser toolbar or bookmark collection.

<a href="#cms-for-committers">CMS usage for committers</a> describes how to use the Apache CMS.

### Non-Taverna Apache committers

If you are an existing
[Apache committer](https://people.apache.org/phonebook.html?unix=committers),
but are not in the `incubator` group,  your suggested edit will be sent as a patch to the
[dev@taverna](/community/lists#devtaverna) mailing list.
Subscribe to the mailing list to respond to any feedback.


### Anonymous login

>It is possible to login to the
[CMS without an Apache account](http://www.apache.org/dev/cmsref.html#faq),
by using the username `anonymous` and an empty password.

This can be beneficial if you
prefer not to use GitHub, or if you want to suggest larger changes that
involve renames, etc.

In this case, your suggested edit will be sent as a patch to the
[dev@taverna](/community/lists#devtaverna) mailing list. Please subscribe to the mailing list to receive and respond to any feedback.


<a name=cms-for-committers></a>
### How to use the CMS

Before editing an Apache Taverna web page, familiarize yourself with the [CMS information flow](http://www.apache.org/dev/cmsref.html#flow).

>IMPORTANT: *[Update]* the page or directory before you start editing. Otherwise, you may not be working on the current version.

For details, see the [Apache CMS reference](http://www.apache.org/dev/cmsref.html).

**Opening the file.**
Open the file in the editor using the **Edit in CMS** bookmarklet:

 * Navigate to the page you want to edit.

 * Click the bookmarklet and log in.

 * Click `[Update]` to refresh the page.

 * Click `[Edit]` to enter the editor.

*Or* use the **[Apache CMS](https://cms.apache.org/taverna/)**:

 * Click `Get taverna Working Copy`.

 * Click on `Parent Directory`, and then click `[Update this directory]`.

 * `Browse` to the correct folder under `content/`.

 * `[Edit]` the file(s).

**Committing and publishing your changes.**

 * Tick `Quick Commit : [ ]`, enter a commit message, and click `Submit`.
 \**You forgot the Quick Commit? No problem! Click `[Commit]` and enter your message followed by `Submit`.

 * Click `[View Staging Build]` to see if the CMS has built your changes. (Usually
   this is quite quick.) Refresh the page, as necessary, to make sure there are no "Current" or "Pending" jobs before you continue.

 * Click `[Staging]` to see the result of your change (and anyone else's at the same time)
   at the temporary
   [http://taverna.staging.apache.org/](http://taverna.staging.apache.org/) site.

 * If you are happy, go back and click `[Publish]` followed by `[Submit]`,
   otherwise keep editing


-----
<a name=editing-tips></a>
## Editing tips

### Writing tips

 * **Keep it simple.** Use [Plain English](https://en.wikipedia.org/wiki/Plain_English).

 * **Focus on the main questions** you imagine will be faced by someone new to the topic, rather than explaining every possibility.


### Linking tips

  * **Avoid [click here](http://www.cs.tut.fi/~jkorpela/www/click.html) links.**
Link text should be understandable and flow with the text. Rewrite the sentence, if needed.

    * YES: *"Code is generated automatically by the [CodeGenerator](#) class."*

    * NO: *"Code generation is automatic. More information is in [svn](#)."*


  * **Don't duplicate information.** Link to existing pages - but provide sufficient context.

    * YES: `Contact the [dev@taverna mailing list](/community/lists) for questions about the Maven plugin.`  

    * NO: `Contact the [dev@taverna mailing list](/community/lists).`  


  * **Everything is easier with a link.**

    * Link to the right place in the documentation rather than saying, "You can find more in the documentation."

    * Deep-links are good, unless the target pages become confusing.

  * **Don't break existing hyperlinks** to our pages. (They could be linked-to anywhere on the web.)

    * Keep the URI of a page as much as possible, or use `.htaccess` redirections.

    * If a page has been deleted, leave a placeholder page explaining why.

    * Remove/update internal links to deleted/moved pages. (<code>svn</code> and <code>grep</code> are your friends.)


  * **Start internal links with `/`** unless they are part of the same sub-folder.

  * **Don't include extensions** (`.html` or `.cgi`) in the internal links. It not only looks nice, but also gives us flexibility to later use a folder `page/` instead of `page.html`.

    * YES: `/introduction/why-use-workflows`

    * NO:  `/introduction/why-use-workflows.html`   

  * **Link to source code.** More people may appreciate it than you think. Who knows, maybe a patch is around the corner? **Deep-link to source folder/file** under the `incubator-taverna-*` project at
   [GitHub](http://github.com/apache/)

### Adding a new page

  * **Use a short, neutral and sensible URI**

    * YES: `community/lists`

    * NO: `the%20taverna%20community/contact-us-2`

  * **Link from/to relevant existing Apache Taverna pages** (not just the hierarchical parent).
  For example, if `/code` describes the source code, and `/community` different ways to contribute, `/code` should link to the `/community` page and vice versa.

  * **Include the page in the [navigation menu bar](https://github.com/apache/incubator-taverna-site/blob/trunk/templates/navbar.html)** and in the listing of a higher-level page.
