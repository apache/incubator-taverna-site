Title:     Command-line Tool
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

The Apache Taverna Command-line Tool is a script that runs Taverna workflows
from a terminal. The command-line script is called *executeworkflow*
 (*executeworkflow.bat* on Windows and *executeworkflow.sh* on  Linux/UNIX).

You can [download the Command-line Tool](/download/commandline/) from the
Taverna Web site or use the *executeworkflow.sh* or *executeworkflow.bat*
that is bundled with the Taverna Workbench installation.

- [Extended version](http://dev.mygrid.org.uk/wiki/display/tav250/Extended+version)


----------


##Contents

[What are the differences between the bundled and unbundled versions?](#differences)

[Other important information](#important)

[Executeworkflow Script](#CommandLineTool-ExecuteworkflowScript)

[Basic Operations](#basic-ops)

[Running the script with a database](#CommandLineTool-Runningthescriptwithdatabase)

[Examples](#CommandLineTool-Examples)

----------

<a name="differences"></a>
##![](/img/information.png)What are the differences between the bundled and standalone versions?

This section describes some of the differences between the bundled and standalone versions of 
*executeworkflow * Other important information is provided in the following section. 

- **Versions use different configuration directories.**
The standalone command-line tool stores its configuration settings in a **separate**
[home directory](http://dev.mygrid.org.uk/wiki/display/tav250/Taverna+home+directory),
called *taverna-cmdline-2.x.x* - while the bundled tool uses the same
directory and settings as the Taverna Workbench.

- **Bundled tool may use more memory.**
The bundled tool will load all
installed workbench plugins, including third-party plugins.
However, it will also load various GUI-supporting functions,
which may consume extra memory.

- **Standalone version has remote capability, GUI not required.**
The standalone version can easily be installed and used on remote servers without
GUI access.

- **With embedded version, runs can show up in workbench.**
Running the embedded
version with the database and provenance enabled allows the command-line runs
to show up in the workbench as
"[Workflow runs](http://dev.mygrid.org.uk/wiki/display/tav250/Result+Perspective)."
**However,** *if database and provenance are enabled* and the workbench is
already running, the command-line tool  must use the *-clientserver* option.
Alternatively, if the workbench is shut down, the command-line tool must use
either a standalone *-startdb* database server process or the *-embedded* option.


----------

<a name="important"></a>
##![](/img/information.png)Other important information
This section provides additional information on configuring proxy settings, 
installing service plugins, disk space considerations and potential conflicts.

- **Manually configure proxy settings.** 
Any [proxy settings](http://dev.mygrid.org.uk/wiki/display/tav250/HTTP+proxy+preferences)
must be manually configured.
Copy *conf/HttpProxy-B307A902-F292-4D2F-B8E7-00CC983982B6.config* from a
configured Workbench home directory.

- **Installing service plugins.**
To install service plugins for the
command-line tool, manually edit the *plugins/plugins.xml*
in the installation or home directory. The ``<plugin>... </plugin>`` block
can be copied from the *plugins/plugins.xml* in the [home directory](http://dev.mygrid.org.uk/wiki/display/tav250/Taverna+home+directory)
of a Workbench installation where the plugin is installed.

- **Disk space considerations.**
The standalone installation and download
is smaller than the workbench - but keeping both the standalone and embedded
versions installed will use more disk space than the workbench version alone.
(Note: the command-line tool could use the {repository}} folder
from the workbench using symlinks or modifiying *plugins/plugins.xml*.)

- **Potential conflicts.**
Although the standalone version would not be in
conflict with the workbench database (as it's in a different home directory),
it could be in conflict with parallel runs of the command-line tool.
In this case, a separate *-startdb* process should be started with the
other calls using the *-clientserver* option. See
[#Running the script with a database](#CommandLineTool-Runningthescriptwithdatabase)


----------


<a name="CommandLineTool-ExecuteworkflowScript"></a>
##Executeworkflow Script

To get help and a full set of options for the executeworkflow script,
type the following at the command prompt:

> $ sh executeworkflow.sh -help

This command will list the following usage options:

<pre>usage: executeworkflow [options] [workflow]

 -clientserver                                  Connects as a client to a
                                                Derby server instance.

 -cmdir &lt;Credential Manager&#39;s directory path&gt;   Absolute path to the
                                                directory on the disk
                                                where Credential Manager&#39;s
                                                files are located.

 -cmpassword                                    Indicates that the master
                                                password for Credential
                                                Manager will be provided
                                                on standard input.

 -dbproperties &lt;filename&gt;                       Loads a properties file to
                                                configure the database.

 -embedded                                      Connects to an embedded
                                                Derby database. This can
                                                prevent multiple
                                                invocations.

 -help                                          Displays comprehensive
                                                help information.

 -inmemory                                      Runs the workflow with
                                                data stored in-memory
                                                rather than in a database.
                                                This can give performance
                                                improvements, at the cost
                                                of overall memory usage.

 -inputdelimiter &lt;inputname delimiter&gt;          Causes an inputvalue or
                                                inputfile to be split into
                                                a list according to the
                                                delimiter. The associated
                                                workflow input must be
                                                expected to receive a list.

 -inputdoc &lt;document&gt;                           Loads inputs from a Baclava
                                                document.

 -inputfile &lt;inputname filename&gt;                Loads the named input from
                                                file or URL.

 -inputvalue &lt;inputname value&gt;                  Directly uses the value for
                                                the named input.

 -janus &lt;file&gt;                                  Saves Janus RDF/XML trace
                                                of execution to FILE or
                                                &#39;provenance-janus.rdf&#39;.

 -logfile &lt;filename&gt;                            Creates logfile to which more
                                                verbose logging will be
                                                written.

 -opm &lt;file&gt;                                    Saves Open Provenance
                                                Model (OPM) RDF/XML trace
                                                of execution to FILE or
                                                &#39;provenance-opm.rdf&#39;.

 -outputdir &lt;directory&gt;                         Save output as files in
                                                directory. Default is to
                                                make a new directory
                                                workflowName_output.

 -outputdoc &lt;document&gt;                          Saves output to a new
                                                Baclava document.

 -port &lt;portnumber&gt;                             Returns port number that
                                                database is running on.
                                                If set requested to start its own
                                                internal server, this is
                                                the start port that will
                                                be used.

 -provenance                                    Generates provenance
                                                information and stores it
                                                in the database.

 -startdb                                       Automatically starts an
                                                internal Derby database
                                                server.

(..)

</pre>


----------

<a name="basic-ops"></a>
##Basic Operations
This section describes inputs, outputs, and creating lists.

###Creating or exporting files and directories
If this directory already exists, then a new directory is created and appended
with *_&lt;n&gt;*, where *n* is incremented to the next available index.

Results are written to files named after the output port for that result.
If a result is composed of lists, then a directory is created for the output
port and individual list items are named after the list element index
(with 1 being the first index). If the output is the  result of an error,
the filename is appended with ‘.error’.

You can provide your own output directory with the *-outputdir* option.
(There will be an error if the directory already exists.)

You can
   [export provenance](http://dev.mygrid.org.uk//wiki/display/tav250/Provenance+export+to+OPM+and+Janus)
   using the *-opm* or *-janus* options.

You can also record your results to a Baclava document using *-outputdoc* option.
The document will be overwritten if it already exists.
(You can use the [DataViewer Tool](http://dev.mygrid.org.uk/wiki/display/tav250/DataViewer+Tool)
   to view Baclava files.)

###Inputting data
Inputs can be provided in three ways.

- **-inputdoc.** *-inputdoc* option must be
   used on its own.

- **-inputfile.** May be used with *-inputvalue.* Requires two additional
arguments: input port name and input filename.

- **-inputvalue.** May be used with *-inputfile.* Requires two additional
arguments: input port name and input value.

###Creating a list
If one or more of your workflow inputs is described as a list,
you can create a list using the *-inputdelimiter* option. This option
may be used with either *-inputfile* or *-inputvalue*.

The *-inputdelimiter* option takes two parameters: an input name
and the delimiter used to split the input into a list.
The delimiter may be a simple character, such as a comma or a
new-line character, or a regular expression. The input string (or file)
will then be converted into a list using the specified delimiter.

If a list of greater depth is required (i.e., a list or lists or deeper)
then you will need to use the *-inputdocoption* to pass data
from a Baclava file. However, if you provide an input of lower depth than
what is required, it will automatically be wrapped in one or more
list levels up to the required depth.
Providing an input of greater depth than that required will result in an error.


----------


<a name="CommandLineTool-Runningthescriptwithdatabase"></a>
##Running the script with a database

Storing data in memory is the default option. If a workflow has a high memory
requirement, then it may be better to store data in a database.
There are three options for using a database:

 - **-embedded** option, runs with an embedded database.
This is slightly faster than the -clientserver option (below), but only one
*executeworkflow* script may be executed at a time. (Simultaneous runs are not
allowed.)

 - **-clientserver** option, allows the workflow to be executed, backed by the
database running as a server. By default a database is not started for you.
You may start a database using the *-startdb* option.

 - **-startdb** option, starts a database. It may be used without providing
 a workflow to allow a database to be started separately. In this manner,
 you can have multiple simultaneous *executeworkflow* script runs.

###Advanced database operations
Advanced database configurations can be specified using the
*-dbproperties* option, allowing you to take full control over the database used.
This takes a second argument, the filename of the properties file. Below are
the default settings for the properties file.

<pre>
in_memory = true
provenance = false
connector = derby
port = 1527
dialect = org.hibernate.dialect.DerbyDialect
start_derby = false
driver = org.apache.derby.jdbc.EmbeddedDriver
jdbcuri = jdbc:derby:t2-database;create=true;upgrade=true
</pre>

###Use Derby
If you want to run the Derby database with client/server setting instead
of with the embedded driver, change the properties in the *-dbproperties*
file (described above) as follows:

<pre>
driver=org.apache.derby.jdbc.ClientDriver
start_derby=true
</pre>

If you want to run your own separate Derby server instance, then do not
define the *start_derby* option and instead define your Derby server port
as *port=&lt;port&gt;*.

###MySQL
If you want to use MySQL rather than Derby, first copy the
mysql-connector-java-5.1.5.jar file from the
[mySQL](http://dev.mysql.com/downloads/connector/j/) website into the lib folder
of the Taverna installation directory. (The Taverna installation directory is
where you are running the script.)

Edit the *-dbproperties* file as follows:

<pre>
connector=mysql
jdbcuri=jdbc:mysql://localhost/T2Provenance
dialect=org.hibernate.dialect.MySQLDialect
driver=com.mysql.jdbc.Driver
username=&lt;username&gt;
password=&lt;password&gt;
port=&lt;port&gt;
</pre>

Important: The database name in the *jdbcuri* property **must be** T2Provenance,
as this database name is hard-coded into the MySQL provenance SQL queries.

If you do not specify the port, the script will try to connect to the default
port for MySQL server, which is 3306.

> ![](/img/warning.png) When using *-dbproperties* together with other
> options, the other options take precedence.


----------


<a name="CommandLineTool-Examples"></a>
##Examples

Workflows names are listed at the end of the command, after any options.
You must enclose file paths and input values in quotes if they contain spaces.
Examples are shown below.

###Example 1

> $ sh executeworkflow.sh &quot;/Users/alex/Taverna
> Workflows/wf-1.t2flow&quot;

The command in Example 1 executes the workflow located in
*/Users/alex/Taverna Workflows/wf-1.t2flow*.
It has no input values and uses memory for data storage (the default option).
Because no output directory is specified, a subdirectory for output files
(*&lt;workflowName&gt;_outputdirectory*) will be created under the current
directory.

###Example 2

> $ sh executeworkflow.sh -embedded -inputvalue in1 aaa -inputvalue in2
> &quot;bb b&quot; -outputdir /tmp/wf-2/ wf-2.t2flow

The command in Example 2 executes the workflow *wf-2.t2flow* from the current
directory and uses the embedded Derby database to store the data.
It passes the value “aaa” to input port *in1* and the value “bb b”
to input port *in2*. Output files will be written to the */tmp/wf-2/*
directory.

###Example 3

> $ sh executeworkflow.sh -inputvalue in1 aaa -inputfile in2 input2.txt
> -inputdelimiter in2 &quot;\n&quot; wf-3.t2flow

The command in Example 3 executes the workflow *wf-3.t2flow* from the current
directory, passing the value “aaa” to  input port *in1*. It splits the
contents of file *input2.txt* using “\n” (new line character) as the delimiter
and passes the resulting list to input port *in2*.
**NOTE: The delimiter must be in quotes**, even if it is a single
character, such as “;”.
The *&lt;workflowName&gt;_outputdirectory* subdirectory will be created
under the current directory and will contain all output files.

###Example 4

> $ sh executeworkflow.sh -inputdoc /tmp/input-doc.xml -outputdoc
> /tmp/output-doc.xml &quot;/Users/alex/Taverna
> Workflows/wf-4.t2flow&quot;

The command in Example 4 executes the workflow
*/Users/alex/Taverna Workflows/wf-4.t2flow*,
loading inputs from the Baclava document in */tmp/input-doc.xml*, and creating
a Baclava document in the output directory: */tmp/output-doc.xml*.