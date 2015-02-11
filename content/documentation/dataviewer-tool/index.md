Title:     DataViewer Tool
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

DataViewer Tool is a utility for viewing Baclava data files. 
Baclava is an XML format used to save workflow inputs and/or outputs from the 
   [Workbench](/documentation) or [Command Line Tool](/documentation/command-line-tool) for later 
   re-use or inspection. 
It is useful for saving all workflow inputs or outputs in a single file but is not really meant 
   for reading by humans as the data inside is Base64-encoded.

DataViewer Tool comes in the form of a command prompt script called *dataviewer*. 
In Taverna 1.x, the script used to be bundled together with the Workbench. 
It has now been updated to use the Taverna 2 codebase and is available as a 
   [separate download](http://www.taverna.org.uk/download/associated-tools/dataviewer-tool/). 
The functionality of the tool remained (almost) the same as in the previous 1.x version. 
Check out the a 
   [release notes](http://www.taverna.org.uk/download/associated-tools/dataviewer-tool/release-notes/) 
for the minor changes in the latest version.

##Creating Baclava files

From the Workbench, you can save the inputs you have specified for a workflow to a Baclava file 
   from the *Run Dialog* (which is used to launch a workflow). 
From the same dialog you can also load inputs from a previously saved Baclava file so you do 
   not have to specify them manually.

From the *Results Perspective* of the Workbench you can save workflow inputs and outputs, 
   once workflow has finished executing and results become available. 
You have the option to select input and output ports which you want to include in the saved 
   Baclava file.

[Command Line Tool](/documentation/command-line-tool) can load workflow inputs from a Baclava 
  data file using the <code>-inputdoc</code> option and save the workflow results in a Baclava 
  data file using the <code>-outputdoc</code>option.
