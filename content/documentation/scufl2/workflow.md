Title:     Scufl2-Workflow
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

The definition of a workflow, its processors, inputs/outputs and links.

 - Bundle path: `/workflow/\$name.n3`

Each nested workflow (and nested nested workflows etc.) exists in a separate file within the `/workflow/` folder in the bundle. 
The bundle's [research object](/documentation/scufl2/bundle) defines what is the top level workflow.

##Identifier

Each workflow **must** have a unique name within the bundle's workflow files. 
The base part of the file name (excluding extension) **must** match the **scufl2:name** of the workflow.

Workflows used in a particular research object are globally identified as 
   `<http://ns.taverna.org.uk/2010/researchObject/$uuid/workflow/$workflowName/>` - 
   for instance `<http://ns.taverna.org.uk/2010/researchObject/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/Helloworld/>`.

As it can be useful to identify nested workflows included in several workflow bundles, 
   each workflow must also have a *scufl2:workflowIdentifier* property, which URI **must** be on the form 
   `<http://ns.taverna.org.uk/2010/workflow/$uuid>`, for example 
   `<http://ns.taverna.org.uk/2010/workflow/efb1cdcd-1e19-408a-885a-303c6553a672/>`. 
It is responsibility of the software creating or modifying the workflow to generate a new workflowcIdentifier 
   as soon as the workflow has changed. 
(The randomly generated UUID of the workflow must **not** match the UUID of a research object or any other workflow.) 
The owning [research object](/documentation/scufl2/bundle) should then also be assigned a new UUID. 
(Note that editing metadata and bindings in other files don't update the workflow, but still update the research object.)

The workflow file **should** set the @base to the form `<workflow/$name>`} 
   so that nested resources can be referenced relatively, like {{&lt;processor/$processorName&gt;</code>.</p>

##Example

(Outdated)

    @base &lt;workflow/Helloworld/&gt;
    @prefix scufl2: &lt;http://ns.taverna.org.uk/2010/scufl2/ontology/&gt; .
    
    &lt;&gt;
        a scufl2:Workflow ;
        scufl2:name &quot;Helloworld&quot; ;
        scufl2:inputWorkflowPort &lt;in/yourName&gt; ;
        scufl2:outputWorkflowPort &lt;out/results&gt; ;
        scufl2:datalink &lt;datalink/1&gt;, &lt;datalink/2&gt; ;
        scufl2:processor &lt;processor/Hello&gt; .
    ]]>

This example defines the workflow "HelloWorld". 
It contains one workflow input port and one workflow output port, in addition to a single processor and two datalinks.

The nested resources for this workflow, such as InputWorkflowPort , OutputWorkflowPort, 
   [DataLink](/documentation/scufl2/datalink), Processor and their children **should** be described 
   in the same file as the workflow itself. 
Additional metadata should be added to an `/annotations/` file.

##Properties

 - **scufl2:name** (required) gives the programmatic short-name for this workflow within this bundle. 
   This must be unique among the other workflows.
 - **scufl2:workflowIdentifier** (required) gives the globally unique URI defining this workflow. 
   See *Identifier* above.
 - **scufl2:inputWorkflowPort** (optional) All workflow input ports defined for this workflow.
 - **scufl2:outputWorkflowPort** (optional) All workflow output ports defined for this workflow.
 - **scufl2:datalink** (optional) All [datalinks](/documentation/scufl2/datalink) 
      defined between workflow and processor ports in this workflow. 
   (Note that if this is a nested workflow, its outside links are defined in the parent workflow)
 - **scufl2:processor** (optional) All [processors](/documentation/scufl2/processors) in this workflow.

##Bundle links

All nested workflow resources should also be defined in the same archive file as this workflow. 
Their URIs **must** be relative to this workflow, their type and **scufl2:name**. 
So for instance &lt;workflow/Helloworld/processor/Hello&gt; is a **scufl2:Processor** in &lt;workflow/Helloworld&gt;, 
   and has a **scufl2:name** "Hello".
