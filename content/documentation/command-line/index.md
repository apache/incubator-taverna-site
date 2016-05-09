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

You can [download the Command Line Tool](/download/commandline/) from the Taverna Web site 
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

<a name="CommandLineTool-ExecuteworkflowScript"></a>
##Executeworkflow Script

To get help and a full set of options for the executeworkflow script type the following in the 
   command prompt:

> $ sh executeworkflow.sh -help

It will give the following usage options:

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

If this directory already exists then an new directory is created, and appended with 
   *_&lt;n&gt;*, where *n* is incremented to the next available index.

Results are written out to files named after the output port for that result. 
If a result is composed of lists, then a directory is created  for the output port and 
   individual list items are named after the list element index (with 1 being the first index). 
The the output is the  result of an error, the filename is appended with ‘.error’.

You can provide your own output directory with the *-outputdir* option. 
There will be an error if the directory already exists.

You can 
   [export the provenance](http://dev.mygrid.org.uk//wiki/display/tav250/Provenance+export+to+OPM+and+Janus)
   using the *-opm* or *-janus* options.

You can also record your results to a Baclava document using *-outputdoc* option. 
The document will be overwritten if it already exists. 
You can use the [DataViewer Tool](http://dev.mygrid.org.uk/wiki/display/tav250/DataViewer+Tool)
   to view Baclava files.

Inputs can be provided in three ways. 
Both *-inputfile* and *-inputvalue* options can be used together; *-inputdoc* option must be 
   used on its own. 
*-inputfile* and *-inputvalue* options both take two additional arguments, the name of the port 
   for  the input, and either a file containing the input data, or the input  value itself 
   respectively.

If one of more of you workflow inputs is described as a list, you can create a list by using 
   the *-inputdelimiter* option, which may be used with either *-inputfile* or 
   *-inputvalue*. 
This option takes two parameters – an input name and the delimiter by which to split the input 
   into a list.

The delimiter may be a simple character, such as a comma or a  new-line character, 
   or a regular expression. 
The input string, or file, will then be converted into a list being split by the delimiter 
   specified. 

If a list of greater depth (i.e. a list or lists or deeper) is required then you will need to 
   use the *-inputdocoption* to pass data from a Baclava file. 
However, if you provide an input of lower depth to that required, then it will automatically be 
   wrapped in  one or more lists up to the required depth. 
Providing an input of  greater depth than that required will result in an error. 

<a name"CommandLineTool-Runningthescriptwithdatabase"></a>
###Running the script with database

If a workflow has a high memory requirement, then it may be better to run it using a database 
   to store data rather than storing it in memory, which is the default option. 
There are three options for using a  database: 

 - *-embedded* option, runs with an embedded database. 
   This is slightly faster than -clientserver option (below), but has the  limitation that only 
      one *executeworkflow* script may be executed simultaneously.
 - *-clientserver* option allows the workflow to be executed backed by the database running as 
      a server. 
   By default a database is not started for you, but may be started using *-startdb* option.
 - *-startdb* option starts a database. It may be used  without providing a workflow to allow 
      a database to be started separately, allowing multiple simultaneous *executeworkflow* 
      script runs.

More advanced database configurations can be specified using *-dbproperties* option, 
   allowing you to take full control over the database used. 
This takes a second argument, the filename of the propeties file, for which the following 
   example contains the default settings used: 

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

If you want to run the Derby database with client/server setting instead of with the embedded 
   driver, change the properties in the *-dbproperties* file (described above) as follows:

<pre>
driver=org.apache.derby.jdbc.ClientDriver
start_derby=true
</pre>

If you wish to run your own separate Derby server instance, then do not define the 
   *start_derby* option and define the port on which you are running you Derby server as 
   *port=&lt;port&gt;*. 

If you want to use MySQL database rather than Derby, first you need to drop the 
   mysql-connector-java-5.1.5.jar file from the 
   [mySQL](http://dev.mysql.com/downloads/connector/j/) website into the lib folder of the 
   Taverna installation directory (Taverna installation directory if where you are running the 
   script from). 

You need to edit the *-dbproperties* file as follows: 

<pre>
connector=mysql
jdbcuri=jdbc:mysql://localhost/T2Provenance
dialect=org.hibernate.dialect.MySQLDialect
driver=com.mysql.jdbc.Driver
username=&lt;username&gt;
password=&lt;password&gt;
port=&lt;port&gt;
</pre>

It is essential that the database name in the *jdbcuri* property is T2Provenance, 
   as this database is hard-coded into the MySQL provenance SQL queries. 

If you do not specify the port, the script will try to connect to the default port for MySQL 
   server, which is 3306. 

> ![](/img/warning.png) When using *-dbproperties* together with other
> options, the other options take precedence.

<a name=CommandLineTool-Examples"></a>
##Examples

Some examples on how the script can be invoked are shown below. 

> $ sh executeworkflow.sh &quot;/Users/alex/Taverna
> Workflows/wf-1.t2flow&quot;

The above line executes the workflow located in */Users/alex/Taverna Workflows/wf-1.t2flow* 
   that has no inputs and uses the memory for data storage (the default option). 
Make sure to enclose the file path in quotes if it contains spaces. 
The *&lt;workflowName&gt;_outputdirectory* will be created in the current directory and outputs 
   will be written to it. 

> $ sh executeworkflow.sh -embedded -inputvalue in1 aaa -inputvalue in2
> &quot;bb b&quot; -outputdir /tmp/wf-2/ wf-2.t2flow

The above line executes the workflow *wf-2.t2flow* from the current directory passing the value 
  “aaa” to the input port *in1* and value “bb b” to the input port *in2*. 
If input values contain spaces make sure to enclose them in quotes. 
Uses the embedded Derby database to store the data. 
Outputs will be written to  the */tmp/wf-2/* directory. 

> $ sh executeworkflow.sh -inputvalue in1 aaa -inputfile in2 input2.txt
> -inputdelimiter in2 &quot;\n&quot; wf-3.t2flow

The above line executes the workflow *wf-3.t2flow* from the current directory passing the value 
   “aaa” to the input port *in1* and splitting the content of file *input2.txt* using “\n” 
   (new line character) as the delimiter and passing the resulting list to the input port *in2*.
Make sure to out the delimiter in quotes, even if it is just a single character, like “;”. 
The *&lt;workflowName&gt;_outputdirectory* will be created in the current directory and outputs 
   will be written to it. 

> $ sh executeworkflow.sh -inputdoc /tmp/input-doc.xml -outputdoc
> /tmp/output-doc.xml &quot;/Users/alex/Taverna
> Workflows/wf-4.t2flow&quot;

The above line executes the workflow */Users/alex/Taverna Workflows/wf-4.t2flow*, loading 
   inputs from the Baclava document in */tmp/input-doc.xml*, and writing the outputs to a 
   Baclava document */tmp/output-doc.xml*. 
