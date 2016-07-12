Title:     Introduction
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

##What is Taverna?##

Taverna is an open source domain independent 
   [Workflow Management System](/introduction/what-is-a-workflow-management-system) - 
   a suite of tools used to design and execute 
   [scientific workflows](/introduction/why-use-workflows).
Taverna was started by the [myGrid project](http://www.mygrid.org.uk).

<p class="row text-center">
<a href="/img/Taverna_Intro_slide1.png">
   <img width="680" height="382" title="Taverna_Intro_slide1" src="/img/Taverna_Intro_slide1.png" 
        alt="" usemap="#tavernamap" /></a></p>
<map name="tavernamap">
<area shape="rect" coords="200,100,300,193" 
   href="http://www.taverna.org.uk/download/workbench/" alt="Taverna Workbench" />
<area shape="rect" coords="316,102,415,196" 
   href="http://www.taverna.org.uk/developers/work-in-progress/taverna-lite/" alt="Taverna Lite" />
<area shape="rect" coords="100,143,184,188" href="http://www.panacea-lr.eu/" alt="Panacea" />
<area shape="rect" coords="3,137,98,177" href="http://www.biocatalogue.org/" alt="Biocatalogue" />
<area shape="rect" coords="14,184,169,218" 
   href="https://www.biodiversitycatalogue.org/" alt="Bio Diversity Catalogue" />
<area shape="rect" coords="26,69,181,107" href="http://www.myexperiment.org/" alt="My Experiment" />
<area shape="rect" coords="28,264,86,308" href="http://soaplab.sourceforge.net/soaplab1/" alt="SoapLab" />
<area shape="rect" coords="84,268,177,301" href="http://www.unicore.eu/" alt="UNICORE" />
<area shape="rect" coords="29,300,80,335" href="http://www.r-project.org/" alt="R Project" />
<area shape="rect" coords="80,300,131,335" href="http://www.biomart.org/" alt="Biomart" />
<area shape="rect" coords="131,300,182,335" href="http://www.beanshell.org/" alt="BeanShell" />
<area shape="rect" coords="38,337,101,379" href="http://sadiframework.org/content/" alt="SADI" />
<area shape="rect" coords="120,332,166,374" href="http://office.microsoft.com/en-gb/excel/" alt="Excel" />
<area shape="rect" coords="632,165,678,207" href="http://office.microsoft.com/en-gb/excel/" alt="Excel" />
<area shape="rect" coords="478,87,554,145" href="http://www.biovel.eu/" alt="Biovel" />
<area shape="rect" coords="584,83,646,138" href="http://www.evo-uk.org/" alt="EVO" />
<area shape="rect" coords="436,164,537,209" href="https://main.g2.bx.psu.edu/" alt="Galaxy" />
<area shape="rect" coords="536,161,637,206" 
   href="http://code.google.com/p/google-refine/" alt="Google Refine" />
<area shape="rect" coords="194,216,313,285" 
   href="/documentation/taverna-2-x/provenance/" alt="Provenance" />
<area shape="rect" coords="194,279,313,341" 
   href="http://www.taverna.org.uk/developers/work-in-progress/components/" alt="Taverna Components" />
<area shape="rect" coords="321,215,427,292" 
   href="/documentation/taverna-2-x/server/" alt="Taverna Server" />
<area shape="rect" coords="319,283,425,341" 
   href="/developers/work-in-progress/interaction/" alt="Interaction Server" />
<area shape="rect" coords="434,221,552,288" 
   href="/developers/work-in-progress/taverna-player/" alt="Taverna Player" />
<area shape="rect" coords="554,222,678,290" 
   href="download/server/2-2/" alt="Taverna Virtual Machine" />
<area shape="rect" coords="434,284,558,352" 
   href="/download/commandline/" alt="Command Line Tool" />
<area shape="rect" coords="560,290,678,358" 
   href="http://www.osgi.org/Main/HomePage" alt="OSGi Alliance" />
<area shape="rect" coords="200,344,422,380" 
   href="/documentation/faq/security/" alt="Security" /> 
</map>
</p>
<p class="row text-center"> 
[Download a (Non Apache) presentation slide of the above](http://www.taverna.org.uk/pages/wp-content/uploads/2013/05/Taverna-Intro-slide1.pptx)
 </p>

The Taverna suite is written in Java and includes the Taverna Engine 
   (used for enacting workflows) that powers both 
   [Taverna Workbench](/download/workbench/) (the desktop client application) and 
   [Taverna Server](/documentation/server/)
   (which executes remote workflows). 
Taverna is also available as a [Command-line Tool](/download/commandline/) 
   for faster execution of workflows from a terminal without the overhead of a GUI.
Taverna automates experimental methods through the use of a number of different (local or remote) services from 
   a diverse set of domains &#8211; biology, chemistry and medicine to music, meteorology and social sciences.

Effectively, Taverna enables a scientist who has a limited background in computing, 
   limited technical resources and support, 
   to construct highly complex analyses over data and computational resources that are both public and private, 
   all from a standard PC, UNIX box or Apple computer.

<p class="row text-center">
<a href="/img/Taverna_Spectrum_Slide.png">
    <img title="Taverna_Spectrum_Slide" src="/img/Taverna_Spectrum_Slide.png" alt="" width="680" height="400" />
    </a>
</p>

<p class="row text-center">
<a href="http://www.taverna.org.uk/pages/wp-content/uploads/2013/05/Taverna_Spectrum_Slide.pptx">Download a (Non Apache) presentation slide of the above</a>
</p>

See a full list of [Taverna's features](/introduction/taverna-features) or 
   [videos](/documentation/videos/) of Taverna in action.   
The screenshot shown below shows the Taverna Workbench 2.x during the design of a workflow.

<p class="row text-center">
<img src="/img/Taverna_Workbench.png" alt="Taverna 2.1 Workbench Design Perspective" width="606" height="392" />
</p>
