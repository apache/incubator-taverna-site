Title:     Scufl2-Processors
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

The definition of a processor.

- Bundle path: `/workflow/\$workflowName.n3`

Processors should be described in the same file as their containing 
   [workflow](/documentation/scufl2/workflow).

##Identifier

Each processor **must** have a **scufl2:name**, which uniquely identifies this processor within its owning workflow.

Processors are globally identified as 
   `<http://ns.taverna.org.uk/2010/researchObject/$researchId/workflow/$workflowName/processor/$processorName/>` - 
   for instance  
   `<http://ns.taverna.org.uk/2010/researchObject/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/Helloworld/processor/Hello/>`.

Within the workflow bundle the processors should be linked to relatively, for instance `<processor/Hello>` 
  within a workflow file, or `<workflow/Helloworld/processor/Hello>` within a profile file.

##Example

workflow/Helloworld.n3: (Outdated)

    @base &lt;workflow/Helloworld/&gt;
    @prefix scufl2: &lt;http://ns.taverna.org.uk/2010/scufl2/ontology/&gt; .
    
    &lt;processor/Hello&gt; a scufl2:Processor ;
        scufl2:name &quot;Hello&quot; ;
        scufl2:inputProcessorPort &lt;processor/Hello/in/name&gt; ;
        scufl2:outputProcessorPort &lt;processor/Hello/out/greeting&gt; ;
        scufl2:dispatchStack &lt;http://ns.taverna.org.uk/2010/scufl2/taverna#defaultDispatchStack&gt; ;
        scufl2:iterationStrategyStack (&lt;processor/Hello/iterationStrategy/0&gt;) .
    
    &lt;processor/Hello/in/name&gt; a scufl2:InputProcessorPort ;
        scufl2:name &quot;name&quot;;
        scufl2:portDepth 0 ;
        scufl2:granularPortDepth 0 .
    
    &lt;processor/Hello/out/greeting&gt; a scufl2:OutputProcessorPort ;
        scufl2:name &quot;greeting&quot; .
    ]]>

This example defines the processor "Hello" in the workflow "Helloworld". 
It contains one processor input port "name" and one processor output port "greeting". 
Additionally the processor has a dispatch stack and an iteration strategy stack.

The nested resources for this workflow, such as InputProcessorPort, OutputProcessorPort, DispatchStack, 
  IterationStrategyStack and their children **should** be described in the same file as owning workflow itself. 
Additional metadata should be added to an `/annotations/` file.

##Properties

 - **scufl2:name** (required) gives the programmatic short-name for this processor within this particular workflow. 
   This must be unique among the other processors.
 - **scufl2:inputProcessorPort** (optional) All processor input ports defined for this processor.
 - **scufl2:outputProcessorPort** (optional) All processor output ports defined for this processor.
 - **scufl2:dispatchStack** (optional) The dispatch stack for this processor.
 - **scufl2:iterationStrategyStack** (optional) The IterationStrategyStack, required if more than 1 input is connected

##Bundle links</h2>

All nested processor resources should also be defined in the same archive file as this workflow. 
Their URIs **must** be relative to this processor, their type and **scufl2:name**. 
So for instance &lt;processor/Hello/out/greeting&gt; is a **scufl2:OutputProcessorPort** in &lt;processor/Hello&gt;, 
   and has a **scufl2:name** "greeting".
    

