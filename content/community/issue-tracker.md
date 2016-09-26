Title:     Taverna Issue Tracker
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

## How to Use Taverna's Apache JIRA Issue Tracker

<div id="content"><div class="alert alert-info alert-dismissible" role="alert"><p><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
All contributors to the issue tracker are expected to follow ASF's
<a class="alert-link" href="https://www.apache.org/foundation/policies/conduct.html">Code of Conduct</a>.
</div></div>

Anyone can add an issue by
[creating an account](https://issues.apache.org/jira/secure/Dashboard.jspa) on Apache's
JIRA issue tracker. An account is also required to
*comment on*, *vote on*, or *watch* issues.
(If you only want to *search for* issues, you do not need an account.)

Once you are on the
[issue tracker](https://issues.apache.org/jira/browse/TAVERNA)
site, you have several options for viewing issues.

* [Summary](https://issues.apache.org/jira/browse/TAVERNA/?selectedTab=com.atlassian.jira.jira-projects-plugin:summary-panel)
  includes a graph and stream of recent activity.
* [Issues](https://issues.apache.org/jira/browse/TAVERNA/?selectedTab=com.atlassian.jira.jira-projects-plugin:issues-panel)
  provides statistics and a list of unresolved issues by component.
* [Components](https://issues.apache.org/jira/browse/TAVERNA/?selectedTab=com.atlassian.jira.jira-projects-plugin:components-panel)
  allows you to quickly see unresolved and recently updated issues for a given component.




## Adding an issue

After logging in to [Jira](https://issues.apache.org/jira/browse/TAVERNA),
use the [Create](https://issues.apache.org/jira/secure/CreateIssue!default.jspa?pid=12318322)
button at the top of the screen to add a new issue.

* Make sure **Apache Taverna** is selected as the _Project_.
* Give a brief title in _Summary_.
* Describe your issue under _Description_.
* Click **Create**.
* Now you may attach any log files, screenshots or workflows under
  _More_ --> **Attach files**.

Jira will email the
[dev@taverna list](/community/lists#dev)
using the issue key in the
Subject, (e.g. `TAVERNA-987`); you may join the
discussion there or correspond using Jira comments.

## Report a security issue

If you want to report a security concern
(e.g. a buffer exploit), then you should instead
email our [private list](/community/lists#private-mailing-list)
where the Apache Taverna PPMC members
will consider the issue in confidence.

## Example bug report

<img src="/img/jira-example.png" width="792" height="859"
     style="border: grey dashed 2px; max-width: 100%" />

A great bug report includes:

* Which program did you use? Which version?
* What operating system, which Java version?
* What did you try?
* What went wrong?
* What was expected?
* Error messages
* Logs and stack traces
* Attached workflow (if you are OK to share it publicly)
