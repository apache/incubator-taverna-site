Title:     Apache Taverna namespaces
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

`/ns/` hosts the [Apache Taverna (incubating)](/)
XML namespaces and ontologies, including:

<ul>
 <li> <a href="2008/xml/t2flow">http://taverna.sf.net/2008/xml/t2flow</a></li>
 <li> <a href="2010/scufl2">http://ns.taverna.org.uk/2010/scufl2</a> (and 
	<a href="2010/scufl2.ttl">scufl2.xsd</a>
  <a href="2010/scufl2.ttl">scufl2.ttl</a> and
	<a href="2010/scufl2.rdf">scufl2.rdf</a>)
</li>
<li><a href="2010/taverna/2.2">http://ns.taverna.org.uk/2010/taverna/2.2/</a></li>
 <li><a href="2010/port">http://ns.taverna.org.uk/2010/</a></li>
 <li><a href="2010/xml/server">http://ns.taverna.org.uk/2010/xml/server/</a></li>
<li>http://ns.taverna.org.uk/2010/xml/server/admin/</a></li>
<li>http://ns.taverna.org.uk/2010/xml/server/feed/</a></li>
 <li><a href="2010/xml/server/rest">http://ns.taverna.org.uk/2010/xml/server/rest/</a></li>
 <li><a href="2010/xml/server/wadl">http://ns.taverna.org.uk/2010/xml/server/wadl/</a></li>
 <li>http://ns.taverna.org.uk/2010/xml/run/</a></li>
 <li>http://ns.taverna.org.uk/2010/xml/server/wsdl/</a></li>
 <li> <a href="2012/component/profile">http://ns.taverna.org.uk/2012/component/profile</a> </li>
 <li> <a
 href="2012/tavernaprov/">http://ns.taverna.org.uk/2012/tavernaprov/</a> (also 
     <a href="2012/tavernaprov.ttl">tavernaprov.ttl</a> and 
     <a href="2012/tavernaprov.rdf">tavernaprov.rdf</a>)
 </li>
</ul>


<p>
Unfortunately some namespaces within this space may not 
currently be available as XSDs or OWL files. 
</p>

<h2>ns.taverna.org.uk and apache.org</h2>
<p>
The namespaces have traditionally been at
<code>http://ns.taverna.org.uk/</code> - since October 2014 Taverna has joined
the <a href="https://www.apache.org/">Apache Software Foundation</a> 
as an incubator project. The existing Taverna websites 
originally hosted by <a href="http://www.mygrid.org.uk/">myGrid</a> at
University of Manchester is in the process of moving to be 
hosted at <code>apache.org</code> infrastructure. 
<p>
<a href="http://ns.taverna.org.uk/">http://ns.taverna.org.uk/*</a>
now redirects to <a href="http://taverna.incubator.apache.org/ns/">http://taverna.incubator.apache.org/ns/*</a>,
hosted as part of the 
<a href="http://taverna.incubator.apache.org/">Apache Taverna</a> website.
When the <code>taverna.org.uk</code> DNS ownership is transferred to Apache,
that redirect will be hosted by <code>apache.org</code> infrastructure.
</p>
<p>
As the new URIs includes the temporary <code>.incubator</code>, new namespaces should still be
minted under <code>http://ns.taverna.org.uk/2015/</code> (or later years).
</p>
<p>
To edit this content (e.g. to add a new namespace), use SVN and <code>https://svn.apache.org/repos/asf/incubator/taverna/site/trunk/content/ns/</code>
and then publish with <a href="https://cms.apache.org/taverna/">Apache CMS</a>.
</p>

<h2>Generated identifiers</h2>

Apache Taverna generates identifiers starting with:
<ul>
  <li>http://ns.taverna.org.uk/2011/run/</li>
  <li>http://ns.taverna.org.uk/2011/data/</li>
  <li>http://ns.taverna.org.uk/2010/workflowBundle/</li>
</ul>

<p>
Note that these URIs are <strong>not</strong> meant to be clickable
(HTTP resolvable) to retrieve the original definition or data.  The
reason for this is that Apache does not (and will not) store centrally
any workflow run information, data values or workflow definitions. It is
however still useful that each workflow definition, each workflow run
and each produced data value can be uniquely identified, therefore we
build these URIs using UUIDs that are generated within Apache Taverna. 
</p>

<p>
See <a href="http://dev.mygrid.org.uk/wiki/display/TAVOSGI/Data+Bundle">Data bundle</a> 
and [SCUFL2 workflow bundle](/documentation/scufl2/taverna_bundle).
</p>

<h3>Guessed information</h3>
<p>
  URIs within the <code>/2010/workflowBundle/</code> and
  <code>2011/run</code> namespaces currently give a <code>303 See
  Other</code> redirects to a <a
  href="/scufl2info/">scufl2info guessing service</a> that constructs a
  minimal Linked Data description of the resource based on information
  embedded in the URI. See <a
  href="https://github.com/apache/incubator-taverna-site/tree/trunk/scripts/scufl2-info">scufl2-info</a>
  for more information and source code.  </p>

<p>
For example. the URI below identifies the workflow run with a <a href="http://en.wikipedia.org/wiki/Universally_unique_identifier">UUID</a> <code>385c794c-ba11-4007-a5b5-502ba8d14263</code>:
</p>
<p>
    <a
    href="http://ns.taverna.org.uk/2011/run/385c794c-ba11-4007-a5b5-502ba8d14263/"><code>http://ns.taverna.org.uk/2011/run/385c794c-ba11-4007-a5b5-502ba8d14263/</code></a>
</p>

This URI identifies the "string1" input port within the processor "Concatenate_two_strings" in the "Hello_Anyone" within the workflow bundle with the UUID <code>01348671-5aaa-4cc2-84cc-477329b70b0d</code>:


<p>
  <a
  href="http://ns.taverna.org.uk/2010/workflowBundle/01348671-5aaa-4cc2-84cc-477329b70b0d/workflow/Hello_Anyone/processor/Concatenate_two_strings/in/string1">
  <code>http://ns.taverna.org.uk/2010/workflowBundle/01348671-5aaa-4cc2-84cc-477329b70b0d/workflow/Hello_Anyone/processor/Concatenate_two_strings/in/string1</code></a>
</p>


<h2>Contact us</h2>
<p>
<a href="/contact/">Contact dev@taverna.incubator.apache.org</a> 
if you are unable to locate the corresponding definitions for such a namespace,
or have other questions about our namespaces, schemas and ontologies.
</p>

