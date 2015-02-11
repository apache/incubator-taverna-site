Title:     API Consumer Tool
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

This page contains information:

 - for [developers who want to use the API Consumer Tool](#api_developers) to wrap their Java 
      API for the subsequent use in Taverna workflows, and
 - for [users who want to use the wrapped Java API](#api_users) inside their workflows.

<a name="api_developers"></a>
##API Consumer Tool

Current version of the tool is 1.1. 
You can get it from the old 
   [download pages](http://www.taverna.org.uk/download/associated-tools/api-consumer-tool). 
Please also refer to the 
   [API Consumer Tool section on the User Manual](http://www.mygrid.org.uk/dev/wiki/display/taverna/API+Consumer+Tool).

The API Consumer Tool allows the selection of subsets of Java APIs which may then be imported 
   into Taverna Workbench and used as services in workflows. 
This tool is intended for API developers rather than end-users. 
It produces an XML API definition file which Taverna imports - this is file that you distribute 
  alongside your API to ‘Taverna enable’ it.

###Prerequisites

The API Consumer Tool is a Java Doclet and uses Ant to launch; you must therefore have Java and 
  Ant installed and available on the path. 
The Tool has been tested on Java 1.6; use other versions at your own risk.

###Setup

Before running the API Consumer Tool you need to place source files of your API within the 
   ‘target’ directory and any supporting libraries (i.e. dependencies) required in the 
   ‘lib’ directory. 
This is particularly important - if your API includes methods which consume or return a type 
   that is not available to the API Consumer Tool, the definitions it generates will be invalid.
For example, if your API contains a method “void foo(MagicClass bar)” and the MagicClass is in 
   some random package in a third party jar file that you have not included there is no way for 
   the Doclet to know the fully qualified classname of MagicClass. 
As Taverna requires full classnames, this will result in an API that cannot be invoked from 
   workflows. 
You can normally trap these issues by watching for the standard JavaDoc warning messages in the
   console.

###Usage

Once your source and any supporting files are present as described above, 
   from the API Consumer Tool directory you can either run the 
   “runme.bat”/”runme.sh script or call Ant directly (just type ‘ant’ on 
   the command line). 
The API Consumer Tool itself will be built from source and applied to the target source files 
   of your API. 
After some slight delay for this process (longer for very complex APIs) you should see a screen
   such as the following:

![API Consumer](/img/APIConsumer-InitialWindow.png)

The tree on the left hand side of the window shows the available classes (including inner 
   classes where present) along with a search box - the right hand side currently shows nothing.
Selecting a class from the tree produces a display like the following, this should be clearly 
   similar to the information produced by the standard JavaDoc tool:

![API Consumer](/img/APIConsumer-SummaryDisplay.png)

In the case of large APIs the search box can be used to display a subset of the complete class 
   tree - enter a pattern to match and hit return in this text box and the tree will be 
   expanded to show all matching nodes. 
To return to the view with all nodes expanded clear the text in this box and hit return.

###Adding methods to the API definition

The next step is to select methods to add to the API definition - these methods
   (static, instance or constructors) will appear as services within Taverna Workbench's 
   [Service Panel](/documentation/glossary#service_panel) when the definition file is imported.

####Using graphical interface

Methods can be manually added by choosing the class, opening the “Methods” tab and either 
   selecting individual methods or using the “Select all” and “Clear all” boxes:

![API Consumer - methods](/img/APIConsumer-Methods.png)

####Using JavaDoc tags

For APIs under your direct control there is an alternative based on JavaDoc tags. 
By adding the tag “@taverna.consume” to either classes or individual methods you can 
   automatically have these methods selected in the API consumer when it first scans the source 
   files. 
In the case of the tag at a class or interface level all constructors and methods will be 
   selected.

###API level metadata

To aid use of your exported API you can select the “API Description” tab and use it to provide 
   a name and description for the entire API subset:

![API Consumer - description](/img/APIConsumer-Description.png)

###Saving the API definition file

To save the API definition select the &“File” -> “Save as XML”. 
This should bring up a standard save dialogue, choose a filename and save. 
This is the file that is then imported into Taverna Workbench's Service Panel by selecting 
   “Import new services” -> “API Consumer services…”.

<a name="api_users"></a>
##Using API Consumer Services in Workflows

Please also refer to 
   [the API Consumer section of the User Manual](http://www.mygrid.org.uk/dev/wiki/display/taverna/API+Consumer).

In order to use the API Consumer services in Taverna workflows, you need the XML API Consumer 
   definition (of the Java library) XML file generated from the API Consumer tool, 
   the library to be used (compiled and packaged as a <code>jar</code>file) and any 
   dependencies of the library as well (i.e. their <code>jar</code> files).

To import the API Consumer definition file into Taverna, click on 
   **“Import new services” -> “API Consumer services…” ** in the Service Panel. 
Select the API Consumer XML definition file. 
A new branch should be added to the Service Panel, showing the class names and methods that 
   have been selected for inclusion using the API Consumer Tool.
![API Consumer - service panel](/img/APIConsumer-ServicePanel.png)

In this lightweight example, our exposed API only has a constructor and a single method. 
Using the API Consumer you have to build up the calls to the API as part of your workflow, 
   so as <code>sayHello()</code> is a method on the <code>HelloWorld</code> instance, 
   we first have to call the constructor <code>HelloWorld</code>, 
   and then call the method on the returned object. 
We will add both API Consumer services to the workflow. 
Each parameter of the method is exposed as an input port, and the return value is shown as an 
   output port. 
In our example, our methods do not take any parameters except the implicit object reference 
   <code>this</code>, which we will have to provide by connecting the <code>object</code> 
   output of the constructor <code>HelloWorld</code> to the <code>object</code> input of the 
   method <code>sayHello</code>.

![API Consumer - workflow](/img/APIConsumer-workflow.png)

As a convenience, methods also return the very same object in the output port 
   <code>object</code>, so that methods that needs to be run in a particular sequence can be 
   chained to pass their object reference, in effect preventing execution of the second method 
   before the first method is returning its result and object reference.

> Note that the Java objects can only be passed to other API Consumer
> services (and only if they are <strong>serializable</strong>); if you
> want any useful inputs and outputs to interact with your workflow you
> need to use basic types such as <code>String</code>. In our example,
> <code>sayHello()</code> returns a <code>String</code> that is
> connected to the workflow output called <code>sayHello_Result</code>

Static methods do not need the <code>object</code> reference, and hence do not need the 
   constructor call, unless you need to pass an instantiated object as a normal argument.

Before you can run the workflow you also need to copy the <code>jar</code> file of the 
   <code>HelloWorld</code> library and its dependencies in the <code>lib</code> directory of 
   your [TAVERNA_HOME directory](http://dev.mygrid.org.uk/wiki/display/taverna/Taverna+home+directory). 
After copying the jar files, you need to specify which dependencies to use for every API 
   Consumer service in a workflow. 
To do so, right-click on the service and select **“Configure API Consumer…”**. 
The default classloader sharing is “Shared for whole workflow”, so you only need to tick of 
   the dependency <code>jar</code> files on one of services using the same API Consumer, 
   for example the constructor.

> If your API is using JNI, or one of its dependencies uses JNI, which
> is a native library with binding for Java, you need to take some
> special considerations, as explained in the section on <a
> href="http://www.mygrid.org.uk/dev/wiki/display/taverna/Beanshell#Beanshell-JNIbasednativelibraries"
> target="_blank">JNI-based native libraries</a> under Beanshell
> services in the User Manual. In particular, you need to select the
> System classloader sharing for all your services and modify the
> Taverna startup scripts.

###A word of advice

Depending on the complexity of your API, building workflows in this way can turn out to be 
   very a cumbersome way to do graphical Java programming in a workflow. 
In many cases, writing a [Beanshell](/documentation/glossary#beanshell) script using the same 
   dependency mechanism can give you most of the benefits in a smaller amount of time. 
However, the API Consumer gives you one major advantage - the workflow designer do not need to 
   know much about Java and they will see a browsable structure of your API in the 
   Service Panel, just like the bundled services. The workflow designer does need to know how 
   to use your API though, but if you have explicitly designed it to be easy to use from 
   Taverna that barrier can be lowered significantly.

An API that is useful for many people could also be wrapped as a 
   [WSDL Web service](/documentation/glossary#wsdl), which would make it usable from any 
   Taverna Workbench without requiring installation of your JAR and API Consumer XML definition 
   files.
