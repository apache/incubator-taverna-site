Title:     Components
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

Taverna Workflow Components are a system for creating shareable, reusable, 
   encapsulated sub-workflows that perform clearly defined tasks while abstracting away from 
   the details of how those tasks are performed. 
They are an integrated feature of Taverna Since Workbench 2.5.0 and Server 2.5.4.

As part of the BioVeL and SCAPE projects, 
  we have developed a system of service components for Taverna. 
This consists of tools for the creation, management and use of workflow components, 
   and a repository for the storage and sharing of those components. 
Workflow components within a given component family will work together cleanly, 
   for example by adhering to a tidy type system and being well described.

A set of minimal functional requirements for service component management has been developed 
   based upon previous component-related work carried out as part of the e-Lico project and 
   also an examination of the needs of BioVeL and SCAPE.

These requirements include:

 - The ability to create components
 - The specification of the characteristics that are necessary for a set of components to 
   ‘play’ together – called a ‘component profile’
 - Creating a component so it complies with a given profile
 - Checking that a component complies with a given profile
 - Publishing a component
 - Discovering a component
 - Including a component in a workflow
 - Executing the component within a workflow run

<img class="aligncenter" title="The Model of Components" src="/img/registry.png" alt="" 
     width="433" height="251" />

##Example

This is an example workflow that includes components, with internal ports hidden for simplicity:

<img class="alignnone" title="Componentized Workflow" src="/img/component_b_1.png" alt="" 
     width="679" height="294" />

Without components, using the same view, it would instead look like this:

[<img class="aligncenter" title="Un-componentized Workflow" src="/img/component_c.png" alt="" width="245" height="526" />](http://www.taverna.org.uk/pages/wp-content/uploads/2013/05/component_c.png)

##Including a component in a workflow

A component can be added into a Taverna workflow in the same way as an ordinary service, 
   by dragging it from the service panel of the workbench into the workflow design view. 
   Note that although it may be realized internally as a workflow, 
   a user sees it as a ‘black box’ and cannot (normally) edit the component’s workflow.

<img class="aligncenter" src="/img/arch3.png" alt="" width="500" height="401" />

It is intended that there will be consistency checks to ensure that components are only plugged 
   together in a sensible manner, and for the discovery of and connection to suitable components 
   based upon existing workflow structure.

##Executing a component in a workflow run

When a component is invoked during a workflow run, the underlying workflow is called with the 
   corresponding data. 
The results of the workflow are used as the output data for the component invocation. 
Note that the user sees the component invocation as a ‘black box’ and cannot see details of 
   what happens inside.

Note that if you publish a workflow containing a component, you *need* to make sure that the 
   component is publicly readable in a globally-accessible component registry; 
   myExperiment is such a suitable registry.

##Component creation

It was decided that the majority of the information necessary for a component will be specified 
   as a Taverna workflow. 
This allows complex internal component functionality and removes the need for extensive new 
   software to design components.

<img class="aligncenter" src="/img/arch1.png" alt="" width="340" height="433" />

##Component profile

A specification of the format for the component profile has been agreed. 
The format is in XML and an XML schema (xsd) has been created. 
An example [component profile](http://www.myexperiment.org/files/905/versions/1/download/Characterisation%20Component.xml) 
   is available. 
Components that share a profile will be collected together into component families. 
A [component profile editor](/documentation/components/component-profile-editor) 
   is being developed.

<p style="text-align: center;">
<img class="aligncenter" src="img/arch2.png" alt="" width="359" height="412" />
</p>

The SCAPE project has an 
   [extended discussion of component profiles](https://github.com/openpreserve/scape-component-profiles)
   available.

##Component creation against a profile

In order to conform to a component profile, it can be necessary to make semantic annotations 
   parts of the corresponding workflow. 
For example, the annotation of the type of format in which data is output by a port or 
   a service with the task it performs.

The component profile specifies the ontologies that will be used for the components within the 
   family, the correspondence between object classes within a workflow 
   (input port, service etc.) and the concepts within the ontologies.

##Checking a component against a profile

Although the components will be modified using a chosen profile, 
   it is unlikely that the components can be assured as being ‘correct by construction’. 
For this reason, a separate 
   [component validator](/documentation/components/component-validator)
   is being implemented. 
The component validator is included within 
   [myExperiment](http://www.myexperiment.org).

##Publishing a component

Since components are realized  as ‘extensions’ to Taverna workflows, 
   it was decided that rather than using a separate component repository, 
   the extensive capabilities of myExperiment  would be used. 
Thus a component is currently published and shared on myExperiment as (a pack containing) 
   a workflow. 
The components themselves are items within a pack corresponding to the component family.

To facilitate the development of components, a workflow can also be saved to the user’s local 
   machine.

When a user publishes a component either to myExperiment or to their local file system, 
   their service panel is updated to reflect the new component.

##Discovering a component

Since component families are realized as packs on myExperiment 
   (or by analogous structures in the user’s file system), 
   we use the existing Taverna code to talk to the myExperiment REST interface to give users 
   access to families of components. 
Users can then see the discovered families of components via the Taverna Workbench service 
   panel, and the components within those families. 
A component can then be added to a workflow.
