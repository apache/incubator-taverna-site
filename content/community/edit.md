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
[dev@taverna mailing list](http://taverna.incubator.apache.org/community/contact/), where
an Apache Taverna committer will review your change before making it live 
on the Apache Taverna website.
Please sign up to [dev@taverna](http://taverna.incubator.apache.org/community/contact/)
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
[dev@taverna](http://taverna.incubator.apache.org/community/contact/) mailing list,
which you should subscribe to in order to respond to any feedback.



## Anonymous use of CMS

It is possible to log on to the 
[CMS without an Apache account](http://www.apache.org/dev/cmsref.html#faq), 
by using the username [`anonymous` and an empty password](https://anonymous@cms.apache.org/taverna/).
This can be beneficial if you
prefer not to use GitHub, or if you want to suggest larger changes that 
involve renames, etc.

Note that in this case your suggested edit will be sent as an suggested patch to the 
[dev@taverna](http://taverna.incubator.apache.org/community/contact/) mailing list, 
which you should subscribe to in order to respond to any feedback.



## CMS usage for committers

For details, see the [Apache CMS reference](http://www.apache.org/dev/cmsref.html).

In short, follow this pattern:

 * `Get taverna Working Copy`
 * `[Update this directory]`
 * `Browse` to the correct folder
 * `[Edit]` the file
 * Tick `Quick Commit : [ ]` and click `Submit`
 * 


If for some reason the edit page does not match the staged or production page, 
this could be because your version of cms is not up to date with the underlying svn repository.
Clicking on the [update] or [Update this directory] link, and then update this resource should solve that issue.



