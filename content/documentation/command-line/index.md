Title:     Command Line Tool
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

Command Line Tool is a script that runs Taverna workflows from a terminal. 
It comes in a form of a command line script called *executeworkflow* 
   (*executeworkflow.bat* on Windows and *executeworkflow.sh* on  Linux/UNIX).

You can [download the Command Line Tool](download/command-line-tool) from the Taverna Web site 
   or use the *executeworkflow.sh* or *executeworkflow.bat* that comes 
   bundled with the Taverna Workbench installation.

- [Extended version](http://dev.mygrid.org.uk/wiki/display/tav250/Extended+version)

##![](/img/information.png)What is the difference between the bundled and standalone executeworkflow?

 - The standalone command line tool has a **separate configuration** 
      [home directory](http://dev.mygrid.org.uk/wiki/display/tav250/Taverna+home+directory), 
      called *taverna-cmdline-2.x.x* - while the bundled tool uses the same configuration from 
      *taverna* as the Taverna Workbench.
	
   - Any [proxy settings](http://dev.mygrid.org.uk/wiki/display/tav250/HTTP+proxy+preferences)
        have to be configured manually - copy 
        *conf/HttpProxy-B307A902-F292-4D2F-B8E7-00CC983982B6.config* from a configured 
        Workbench home directory.

 - The bundled tool will load all the <strong>plugins</strong> installed for the workbench, 
      including third-party plugins. 
   However it will also load various GUI-supporting functions which might consume extra memory.

   -  To install service plugins for the command line tool, one will have to manually edit the 
         *plugins/plugins.xml* of the installation or home directory. 
      The *<plugin>... </plugin>* block can be copied from the *plugins/plugins.xml* from 
         the [home directory](http://dev.mygrid.org.uk/wiki/display/tav250/Taverna+home+directory) 
         of a Workbench installation where the plugin is installed.
	
 - The standalone installation and download is smaller than the workbench - but keeping both 
      installed will use more disk space. 
   (Note: the command line tool could use the {repository}} folder from the workbench using 
      symlinks or modifiying *plugins/plugins.xml*

 - The standalone tool can easily be installed and used on remote servers without GUI access.

 - Running the embedded tool with the database and provenance enabled allows the command line 
     runs to show up in the workbench 
     "[Workflow runs](http://dev.mygrid.org.uk/wiki/display/tav250/Result+Perspective)".

 - On the other hand the tool will have to use *-clientserver* if the workbench is already 
     running, or if shut down either a standalone *-startdb* database server process or 
     *-embedded*.

 - The standalone tool would not be in conflict with the database of the workbench 
     (as it's in a different home directory) - but could be in conflict with parallel runs of 
     the command line tool - in which case a separate *-startdb* process should be started with 
     the other calls using *-clientserver* - see 
     [#Running the script with database](#CommandLineTool-Runningthescriptwithdatabase)

<h2 id="CommandLineTool-ExecuteworkflowScript">Executeworkflow Script</h2>

<p>To get help and a full set of options for the executeworkflow script type the following in the command prompt:</p>

<div class="code panel" style="border-width: 1px;"><div class="codeContent panelContent">
<script type="syntaxhighlighter" class="theme: Eclipse; brush: java; gutter: false"><![CDATA[$ sh executeworkflow.sh -help]]></script>
</div></div>

<p>It will give the following usage options:</p>

<div class="preformatted panel" style="border-width: 1px;"><div class="preformattedContent panelContent">
<pre>usage: executeworkflow [options] [workflow]
 -clientserver                                  connects as a client to a
                                                derby server instance.
 -cmdir &lt;Credential Manager&#39;s directory path&gt;   Absolute path to the
                                                directory on the disk
                                                where Credential Manager&#39;s
                                                files are located
 -cmpassword                                    Indicates that the master
                                                password for Credential
                                                Manager will be provided
                                                on standard input
 -dbproperties &lt;filename&gt;                       loads a properties file to
                                                configure the database
 -embedded                                      connects to an embedded
                                                Derby database. This can
                                                prevent mulitple
                                                invocations
 -help                                          displays comprehensive
                                                help information
 -inmemory                                      runs the workflow with
                                                data stored in-memory
                                                rather than in a database.
                                                This can give performance
                                                inprovements, at the cost
                                                of overall memory usage
 -inputdelimiter &lt;inputname delimiter&gt;          causes an inputvalue or
                                                inputfile to be split into
                                                a list according to the
                                                delimiter. The associated
                                                workflow input must be
                                                expected to receive a list
 -inputdoc &lt;document&gt;                           load inputs from a Baclava
                                                document
 -inputfile &lt;inputname filename&gt;                load the named input from
                                                file or URL
 -inputvalue &lt;inputname value&gt;                  directly use the value for
                                                the named input
 -janus &lt;file&gt;                                  saves Janus RDF/XML trace
                                                of execution to FILE or
                                                &#39;provenance-janus.rdf&#39;
 -logfile &lt;filename&gt;                            the logfile to which more
                                                verbose logging will be
                                                written to
 -opm &lt;file&gt;                                    saves Open Provenance
                                                Model (OPM) RDF/XML trace
                                                of execution to FILE or
                                                &#39;provenance-opm.rdf&#39;
 -outputdir &lt;directory&gt;                         save outputs as files in
                                                directory, default is to
                                                make a new directory
                                                workflowName_output
 -outputdoc &lt;document&gt;                          save outputs to a new
                                                Baclava document
 -port &lt;portnumber&gt;                             the port that the database
                                                is running on. If set
                                                requested to start its own
                                                internal server, this is
                                                the start port that will
                                                be used.
 -provenance                                    generates provenance
                                                information and stores it
                                                in the database.
 -startdb                                       automatically starts an
                                                internal Derby database
                                                server.

(..)

</pre>
</div></div>


<p>If this directory already exists then an new directory is created, and appended with <code>_&lt;n&gt;</code>, where <code>n</code> is incremented to the next available index.</p>

<p>Results are written out to files named after the output port for that  result. If a result is composed of lists, then a directory is created  for the output port and individual list items are named after the list  element index (with 1 being the first index). The the output is the  result of an error, the filename is appended with ‘.error’.</p>

<p>You can provide your own output directory with the <code>-outputdir</code> option. There will be an error if the directory already exists.</p>

<p>You can <a href="http://dev.mygrid.org.uk//wiki/display/tav250/Provenance+export+to+OPM+and+Janus">export the provenance</a> using the <code>-opm</code> or <code>-janus</code> options.</p>

<p>You can also record your results to a Baclava document using <code>-outputdoc</code> option. The document will be overwritten if it already exists. You can use the <a href="http://dev.mygrid.org.uk/wiki/display/tav250/DataViewer+Tool">DataViewer Tool</a> to view Baclava files.</p>

<p>Inputs can be provided in three ways. Both <code>-inputfile</code> and <code>-inputvalue</code> options can be used together; <code>-inputdoc</code> option must be used on its own. <code>-inputfile</code> and <code>-inputvalue</code> options both take two additional arguments, the name of the port for  the input, and either a file containing the input data, or the input  value itself respectively.</p>

<p>If one of more of you workflow inputs is described as a list, you can create a list by using the <code>-inputdelimiter</code> option, which may be used with either <code>-inputfile</code> or <code>-inputvalue</code>. This option takes two parameters – an input name and the delimiter by which to split the input into a list.</p>

<p>The delimiter may be a simple character, such as a comma or a  new-line character, or a regular expression. The input string, or file,  will then be converted into a list being split by the delimiter specified.</p>

<p>If a list of greater depth (i.e. a list or lists or deeper) is required then you will need to use the <code>-inputdocoption</code> to pass data from a Baclava file. However, if you provide an input of  lower depth to that required, then it will automatically be wrapped in  one or more lists up to the required depth. Providing an input of  greater depth than that required will result in an error.</p>

<h3 id="CommandLineTool-Runningthescriptwithdatabase">Running the script with database</h3>

<p>If a workflow has a high memory requirement, then it may be better to  run it using a database to store data rather than storing it in memory,  which is the default option. There are three options for using a  database:</p>
<ul>
	<li><code>-embedded</code> option, runs with an embedded database. This  is slightly faster than -clientserver option (below), but has the  limitation that only one <code>executeworkflow</code> script may be executed simultaneously.</li>
	<li><code>-clientserver</code> option allows the workflow to be executed  backed by the database running as a server. By default a database is  not started for you, but may be started using <code>-startdb</code> option.</li>
	<li><code>-startdb</code> option starts a database. It may be used  without providing a workflow to allow a database to be started  separately, allowing multiple simultaneous <code>executeworkflow</code> script runs.</li>
</ul>


<p>More advanced database configurations can be specified using <code>-dbproperties</code> option, allowing you to take full control over the database used. This  takes a second argument, the filename of the propeties file, for which  the following example contains the default settings used:</p>

<div class="preformatted panel" style="border-width: 1px;"><div class="preformattedContent panelContent">
<pre>in_memory = true
provenance = false
connector = derby
port = 1527
dialect = org.hibernate.dialect.DerbyDialect
start_derby = false
driver = org.apache.derby.jdbc.EmbeddedDriver
jdbcuri = jdbc:derby:t2-database;create=true;upgrade=true
</pre>
</div></div>


<p>If you want to run the Derby database with client/server setting  instead of with the embedded driver, change the properties in the <code>-dbproperties</code> file (described above) as follows:</p>

<div class="preformatted panel" style="border-width: 1px;"><div class="preformattedContent panelContent">
<pre>driver=org.apache.derby.jdbc.ClientDriver
start_derby=true
</pre>
</div></div>

<p>If you wish to run your own separate Derby server instance, then do not define the <code>start_derby</code> option and define the port on which you are running you Derby server as <code>port=&lt;port&gt;</code>.</p>

<p>If you want to use MySQL database rather than Derby, first you need to drop the mysql-connector-java-5.1.5.jar file from the <a href="http://dev.mysql.com/downloads/connector/j/" class="external-link" rel="nofollow">mySQL</a> website into the lib folder of the Taverna installation directory (Taverna installation directory if where you are running the script from).</p>

<p>You need to edit the <code>-dbproperties</code> file as follows:</p>

<div class="preformatted panel" style="border-width: 1px;"><div class="preformattedContent panelContent">
<pre>connector=mysql
jdbcuri=jdbc:mysql://localhost/T2Provenance
dialect=org.hibernate.dialect.MySQLDialect
driver=com.mysql.jdbc.Driver
username=&lt;username&gt;
password=&lt;password&gt;
port=&lt;port&gt;
</pre>
</div></div>
<p>It is essential that the database name in the <code>jdbcuri</code> property is T2Provenance, as this database is hard-coded into the MySQL provenance SQL queries.</p>

<p>If you do not specify the port, the script will try to connect to the default port for MySQL server, which is 3306.</p>


<div class='panelMacro'><table class='noteMacro'><colgroup><col width='24'><col></colgroup><tr><td valign='top'><img src="/wiki/images/icons/emoticons/warning.png" width="16" height="16" align="absmiddle" alt="" border="0"></td><td><p>When using <code>-dbproperties</code> together with other options, the other options take precedence.</p></td></tr></table></div>

<h2 id="CommandLineTool-Examples">Examples</h2>

<p>Some examples on how the script can be invoked are shown below.</p>

<div class="code panel" style="border-width: 1px;"><div class="codeContent panelContent">
<script type="syntaxhighlighter" class="theme: Eclipse; brush: java; gutter: false"><![CDATA[$ sh executeworkflow.sh &quot;/Users/alex/Taverna Workflows/wf-1.t2flow&quot;]]></script>
</div></div>


<p>The above line executes the workflow located in <code>/Users/alex/Taverna Workflows/wf-1.t2flow</code> that has no inputs and uses the memory for data storage (the default option). Make sure to enclose the file path in quotes if it contains spaces. The <code>&lt;workflowName&gt;_outputdirectory</code> will be created in the current directory and outputs will be written to it.</p>

<div class="code panel" style="border-width: 1px;"><div class="codeContent panelContent">
<script type="syntaxhighlighter" class="theme: Eclipse; brush: java; gutter: false"><![CDATA[
$ sh executeworkflow.sh -embedded -inputvalue in1 aaa -inputvalue in2 &quot;bb b&quot; -outputdir /tmp/wf-2/ wf-2.t2flow

]]></script>
</div></div>


<p>The above line executes the workflow <code>wf-2.t2flow</code> from the current directory passing the value “aaa” to the input port <code>in1</code> and value “bb b” to the input port <code>in2</code>. If input values contain spaces make sure to enclose them in quotes. Uses the embedded Derby database to store the data. Outputs will be written to  the <code>/tmp/wf-2/</code> directory.</p>

<div class="code panel" style="border-width: 1px;"><div class="codeContent panelContent">
<script type="syntaxhighlighter" class="theme: Eclipse; brush: java; gutter: false"><![CDATA[
$ sh executeworkflow.sh -inputvalue in1 aaa -inputfile in2 input2.txt -inputdelimiter in2 &quot;\n&quot; wf-3.t2flow

]]></script>
</div></div>


<p>The above line executes the workflow <code>wf-3.t2flow</code> from the current directory passing the value “aaa” to the input port <code>in1</code> and splitting the content of file <code>input2.txt</code> using “\n” (new line character) as the delimiter and passing the resulting list to the input port <code>in2</code>. Make sure to out the delimiter in quotes, even if it is just a single character, like “;”. The <code>&lt;workflowName&gt;_outputdirectory</code> will be created in the current directory and outputs will be written to it.</p>

<div class="code panel" style="border-width: 1px;"><div class="codeContent panelContent">
<script type="syntaxhighlighter" class="theme: Eclipse; brush: java; gutter: false"><![CDATA[
$ sh executeworkflow.sh -inputdoc /tmp/input-doc.xml -outputdoc /tmp/output-doc.xml &quot;/Users/alex/Taverna Workflows/wf-4.t2flow&quot;

]]></script>
</div></div>


<p>The above line executes the workflow <code>/Users/alex/Taverna Workflows/wf-4.t2flow</code>, loading inputs from the Baclava document in <code>/tmp/input-doc.xml</code>, and writing the outputs to a Baclava document <code>/tmp/output-doc.xml</code>.</p>
