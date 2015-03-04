Title:     Edit Instructions
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

The Apache Taverna website is maintained as a community effort. 
No matter your affiliation to the project, please help us improve the website by 
suggesting edits of any of the pages!


# Overview

Apache Taverna's webpages are managed by the [Apache CMS](http://www.apache.org/dev/cmsref.html) system, and 
(if the file extension is `.md`) written in the [Markdown format](https://www.apache.org/dev/cmsref.html#markdown). 

The raw pages are stored in the <a href="http://svn.apache.org/repos/asf/incubator/taverna/site/">SVN repository asf/incubator/taverna/site</a>, but should be edited using one of the methods below:


# Github pull requests

The source for the Apache Taverna website is mirrored to the GitHub project 
[incubator-taverna-site](https://github.com/apache/incubator-taverna-site/tree/trunk/content), 
where you can navigate to the source for the page you want to edit. *Anyone with a GitHub account*
can suggest an edit to an Apache Taverna page directly in the browser.

Note that GitHub's rendering of the Markdown is not 100% equivalent to the resulting HTML
within the Apache CMS.  In particular, the `Title:` and `License:` headers at the top 
of every `.md` file will not be rendered as shown on GitHub.

To submit your suggested change, raise a 
[GitHub pull request](https://github.com/apache/incubator-taverna-site/pulls) 
which will send an email on your behalf to the 
[dev@taverna mailing list](http://taverna.incubator.apache.org/community/lists#devtaverna), where
an Apache Taverna committer will review your change before making it live 
on the Apache Taverna website.
Please sign up to [dev@taverna](http://taverna.incubator.apache.org/community/lists#devtaverna)
to watch for to any follow-up comments about your changes.




# Apache CMS 

If you are an Apache Taverna **committer**, then use the 
[Apache CMS](http://www.apache.org/dev/cmsref.html) directly from 
[https://cms.apache.org/taverna/](https://cms.apache.org/taverna/) using your `@apache.org` account as login.

You can also drag this bookmarklet to your browser toolbar or bookmark collection, 
which you can click from any Apache Taverna page you want to edit:

 * <a href="javascript:void(location.href='https://cms.apache.org/redirect?uri='+escape(location.href))">Edit in CMS</a>




## Non-Taverna committers

If you are an existing 
[Apache committer](https://people.apache.org/committer-index.html), 
but don't have write access to the pages 
(e.g. you are not in the `incubator` group), then your suggested edit will be sent as
 an suggested patch to the 
[dev@taverna](http://taverna.incubator.apache.org/community/lists) mailing list,
which you should subscribe to in order to respond to any feedback.



## Anonymous use of CMS

It is possible to log on to the 
[CMS without an Apache account](http://www.apache.org/dev/cmsref.html#faq), 
by using the username `anonymous` and an empty password.
This can be beneficial if you
prefer not to use GitHub, or if you want to suggest larger changes that 
involve renames, etc.

Note that in this case your suggested edit will be sent as an suggested patch to the 
[dev@taverna](http://taverna.incubator.apache.org/community/lists) mailing list, 
which you should subscribe to in order to respond to any feedback.



## CMS usage for committers

For details, see the [Apache CMS reference](http://www.apache.org/dev/cmsref.html).

In short, follow this pattern:

 * `Get taverna Working Copy`
 * Click on `Parent Directory` where you then click `[Update this directory]`
 * `Browse` to the correct folder under `content/`
 * `[Edit]` the file(s)

 * Tick `Quick Commit : [ ]` and click `Submit`
 ** You forgot the Quick Commit? Now click `[Commit]` followed by `Submit`
 * Click/Refresh `[View Staging Build]` to see if CMS has built your changes. Usually
   this is quite quick. there should be no "Current" or "Pending" jobs.
 * Click `[Staging]` to see the result of your change (and anyone elses at the same time)
   at the temporary
   [http://taverna.staging.apache.org/](http://taverna.staging.apache.org/) site. 
 * If you are happy, go back and click `[Publish]` followed by `[Submit]`, 
   otherwise keep editing


## Editing tips

Writing tips:
 
 * Keep it simple. Use [Plain English](https://en.wikipedia.org/wiki/Plain_English).
 * Rather than explaining every possibility, focus on the main questions you imagine faced by someone new to the topic.


Linking tips:

 * [click here](http://www.cs.tut.fi/~jkorpela/www/click.html) links considered harmful. 
   * Make link texts that make sense alone, but also flows with the text. Rewrite the sentence if needed.
   * Example: Instead of 
      * <del>*"Code generation is automatic. More information is in [svn](#)"*</del>, try: 
      * *"Code is generated automatically by the [CodeGenerator](#) class"*
 * Don't duplicate information. Link to existing pages - but provide sufficient context.
   * Example: `Contact the [dev@taverna mailing list](/community/lists) for questions about the Maven plugin"`
 * Everything is easier with a link. 
   * Don't just say "You can find more in the documentation" - link to the right place in the documentation.
   * Deep-links are good, unless the target pages becomes confusing out of context
 * Don't break existing hyperlinks to our pages (they could linked to anywhere on the web)
   * Keep the URI of a page as far as possible, or use `.htaccess` redirections.
   * If a page has been deleted, leave a placeholder page explaining why. 
     * Remove/update internal links to deleted/moved pages. (<code>svn</code> and <code>grep</code> are your friends)
 * Start internal links with `/` unless they are part of the same sub-folder.
 * **Don't** include extensions `.html` or `.cgi` in the internal links
  *  e.g. 
link to `/introduction/why-use-workflows` rather than `/introduction/why-use-workflows.html` 
   * It doesn't just look nice, this gives us flexibility to later use a folder `page/` instead of `page.html`
 * Don't be afraid to link to source code - more people may appreciate it than you think. Who knows, maybe a patch is around the corner?
   * Deep-link to source folder/file under the `incubator-taverna-*` project at
   [GitHub](http://github.com/apache/) 

If you are adding a new page:

 * Make sure the page has a short, neutral and sensible URI
   * e.g. `community/lists` rather than <del>`the%20taverna%20community/contact-us-2`</del>
 * Make sure the page is linked from/to relevant existing Apache Taverna pages (not just the hierarchical parent)
   * For example, if `/code` is describing the source code, and `/community` different ways to contribute, `/code` should link to the `/community` page and vice versa.
 * Ensure the page is included in the [navigation menu bar](https://github.com/apache/incubator-taverna-site/blob/trunk/templates/default_navbar.html) or in the listing of a higher-level page.
