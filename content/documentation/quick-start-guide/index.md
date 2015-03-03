Title:     Quick start guide
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

Taverna is a powerful scientific 
   [workflow management application](/introduction/what-is-a-workflow-management-system)
   that allows designing and executing workflows.

[Scientific workflows](/introduction/why-use-workflows) help tackle the problem of excessive 
   complexity of [*in silico* experimentation](/introduction/what-is-in-silico-experimentation)
   by helping scientists model what an experiment is set to achieve, 
   while abstracting out how it will be executed.

This quick start guide will help you open, create and run a workflow. 
Before you start, you should download the [Taverna Workbench](/download).

You should also refer to the 
   [User Manual](http://www.mygrid.org.uk/dev/wiki/display/taverna/User+Manual), 
   which contains a more comprehensive documentation on how to use Taverna.

##Opening an existing workflow

It is simple to open an existing workflow inside the Taverna Workbench.  
If you already have a Taverna workflow, go to *File -&gt;Open Workflow* 
   and navigate to your workflow file (it should be in .t2flow format).

When you click *OK*, if the workflow loads correctly, the 
   [*Workflow Diagram*](/documentation/glossary#workflow_diagram) and 
   [*Workflow Explorer*](/documentation/glossary/#workflow_explorer)
   panels are populated with the workflow defined in the file. 
There may be a short delay while Taverna contacts the network to get more information about 
   the resources (services) the workflow uses - if the delay is a very long one followed by 
   an error you probably need to check the configuration of your *HTTP Proxy Preferences*.

If you do not have an existing workflow, you can download and open one from 
   [*myExperiment*](http://www.myexperiment.org/). 
For bioinformatics examples, go to myExperiment and search for the Pack entitled 
   "[*Bioinformatics Workflow Examples*](http://www.myexperiment.org/packs/363.html)". 
From this pack, download the workflow entitled 
   "[*Blast_Align_and_Tree*]http://www.myexperiment.org/workflows/3369.html_" 
   by selecting it and selecting the Download option "*Download Workflow File/Package (T2FLOW*)". 
Alternatively, you can copy the link location from the *Run* section in the workflow entry page.
If you go to *File -&gt; Open Workflow Location... *in the workbench, you can paste this 
   [link](http://www.myexperiment.org/workflows/3369/download?version=1) directly into the 
   dialogue box.

To run the workflow, click the green 'play' button at the top of the workbench, or go to 
   *File -&gt; Run workflow*. 
In the pop-up workflow input box, add the first input (your email address), 
by selecting "*set value*" and typing it in the box. 
Change to the other input tab (sequence) at the top of the window and add a protein sequence 
   in *FASTA* format in the same way. 
An example is given and will be automatically added when you click on "set value", 
   but you can add your own instead if you wish. 
To launch the workflow, click "*Run workflow*" at the bottom of the input window.

For more general workflow examples, you can find and download workflows from the 
   Taverna starter packs 
  (see [Taverna 2.5 starter pack](http://www.myexperiment.org/packs/612.html) 
  for an example set).

You can additionally access the content of myExperiment directly from the Taverna Workbench by 
  selecting the *myExperiment Perspective* at the top of the workbench. 
The *Starter Pack* tab in the myExperiment Perspective contains the current Taverna starter
  pack of workflows.

##Creating a workflow

We will now create and run a very simple Taverna 2.x workflow to list some cities in a country. 
When you start the Workbench up, the default perspective you are presented with is the Design 
  Perspective which is used for creating and editing workflows. 
To start creating a new workflow, choose *New workflow* from the *File* menu.

##Adding a service into Taverna

Taverna 2.x does not, by default, “know” about a suitable service to perform the desired 
   functionality. 
To add a new [Web service](/documentation/glossary/#web_service) click *Import new services* 
   in the [*Service Panel*]/documentation/glossary/#service_panel) and then *WSDL service…*. 
Enter the URL of the WSDL, in this case
"http://www.webservicex.com/globalweather.asmx?WSDL" and click *OK*.

After a while, the service will become available in the *Service Panel*. 
If you filter the services by “globalweather” then you can see the two new services under 
   "WSDL @ http://www.webservicex.com/globalweather.asmx?WSDL".

##Adding a service into the workflow

To add a service we have just imported in Taverna into the workflow, 
   click on GetCitiesByCountry in the Service Panel and drag it into the *Workflow Diagram* or 
   to the tree in the *Workflow Explorer*.

##Creating the workflow inputs

The workflow needs to have an input, in this case the name of the country to query. 
You can create a new workflow input by right clicking in a blank area of the *Workflow Diagram* 
   and select *Insert* -&gt; *Workflow input port*. 
This will then ask you for a name for the input port, you can change this later but for now use 
   "country". 
Click *OK* and you should see your new input appear in the *Workflow Diagram* and 
   *Workflow Explorer*.

Similarly, the workflow will need an output. 
Follow an equivalent process but this time clicking on *Insert* -&gt; *Workflow output port* 
   and using the name "cities" to create an output. 
Again, you should see the output appear in the two panels of the Workbench.

##Splitting the WSDL inputs and outputs

For many services, you can connect their inputs and outputs directly. 
However, for [WSDL services](/documentation/glossary#wsdl) you may need to “split” the XML used 
   to hold the input and output values. 
To do this, right-click on the service GetCitiesByCountry in the *Workflow Diagram* or 
   *Workflow Explorer* and select *Show details*.

A description of the service will appear in the *Details* view of the *Workflow Explorer*. 
Scroll down and click both *Add input XML splitter* and *Add output XML splitter*, 
   choosing “parameters” in both cases.

##Connecting everything together

To link the input port, click on “country” and drag to the “GetCitiesByCountry_input”. 
A connection arrow will appear in the *Workflow Diagram*. 
If there had been several ports that you could have connected to, 
   then the multiple options would have been offered to you. 
Alternatively, you may right-click the “GetCitiesByCountry_input” input port of the service and 
   select *Connect with output from...* -&gt;*Workflow input ports* and select the 
   "country" workflow input port.

To connect from the “GetCitiesByCountry_output”, right-click on it and select 
   *Connect as input to...* -&gt;*Workflow output ports* and select the “cities” output port. 
Alternatively, you may start to draw a link (a green arrow will appear) from the 
“GetCitiesByCountry_output” output port of the service towards the workflow output port 
   “cities”.

##Running the workflow

You can now run the workflow you have just created.

Select *Run workflow* from the *File* menu. In the *Workflow Inputs Dialog*, 
   as there is only one input port, you can click *New value *button.  
Replace the string “Some input data goes here” by your chosen country name. 
After you have entered it, you can click *Run workflow*.

Taverna will automatically switch to the *Results Perspective*. 
The workflow run will be displayed in the *Monitor View *tabs 
   (either as a graph showing progress or as a progress table). 
This panel shows you the progress of the workflow - running services are shown green and 
   completed ones in grey. 
As the results are produced they are listed, for each output, in the Port Results View. 
After the workflow has run (indicated by GetCitiesByCountry turning grey), you will see a string “Value 1? appear in the lower left panel. This is the identifier of the output result. If you click on this, you will see the output appear in the *Rendered Result* panel of the *Port Results View*.

Congratulations, you have created and run a workflow.

##Closing the workflow

To close the current workflow, select *Close workflow* from the *File* menu.
