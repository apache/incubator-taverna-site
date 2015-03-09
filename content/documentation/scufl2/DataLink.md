Title:     Scufl2-DataLink
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

The definition of a data link.

    Bundle path: /workflow/\$workflowName.n3

Datalink should be described in the same file as their containing workflow.

##Identifier

Each datalink is uniquely identified by their source and destination ports, in addition to the optional merge position.

Datalinks are globally identified as <http://ns.taverna.org.uk/2010/researchObject/$researchObjectUUID/workflow/$workflow/datalink?from=$fromPort&to=$toPort&mergePosition=$mergePosition> - for instance <http://ns.taverna.org.uk/2010/researchObject/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/datalink?from=processor/A/out/result&to=processor/B/in/db> defines the link in workflow "HelloWorld" from the output port "result" in the processor "A" going to the input port "db" for the processor "B". As there is no mergePosition there can't be any other links going to the "db" port.

As these URIs can be tricky to construct or maintain, feel free to use anonymous nodes, or construct alterative URIs as <datalink/$number>, the number here would not have any semantic meaning except it must be unique per datalink in that workflow.

##Example

workflow/Helloworld.n3: (out of Date)


    @base <workflow/Helloworld> .
    @prefix scufl2: <http://ns.taverna.org.uk/2010/scufl2/ontology/> .
    @prefix dc: <http://purl.org/dc/elements/1.1/> .
     
    <>
        a scufl2:Workflow ;
        scufl2:name "Helloworld" ;
        scufl2:workflowIdentifier <http://ns.taverna.org.uk/2010/workflow/00626652-55ae-4a9e-80d4-c8e9ac84e2ca/> ;
        scufl2:inputWorkflowPort <in/yourName> ;
        scufl2:outputWorkflowPort <out/results> ;
        scufl2:datalink _:datalink1, <datalink/5>, <datalink?from=processor/Hello/out/greeting&to=out/results&mergePosition=0> ;
        scufl2:processor <processor/Hello> .
     
    <in/yourName> a scufl2:InputWorkflowPort ;
        scufl2:name "yourName" ;
        scufl2:portDepth 0 .
     
    <out/results> a scufl2:OutputWorkflowPort ;
        scufl2:name "results" .
     
    _:datalink1 a scufl2:DataLink ;
        scufl2:receivesFrom <in/yourName> ;
        scufl2:sendsTo <processor/Hello/in/name> .
     
    <datalink/5> a scufl2:DataLink ;
        scufl2:receivesFrom <in/yourName> ;
        scufl2:sendsTo <out/results> ;
        scufl2:mergePosition 1 .
     
    <datalink?from=processor/Hello/out/greeting&to=out/results&mergePosition=0> a scufl2:DataLink ;
        scufl2:receivesFrom <processor/Hello/out/greeting> ;
        scufl2:sendsTo <out/results> ;
        scufl2:mergePosition 0 .

This example defines three datalinks.

The first link `_:datalink1` is just an anonymous node without an identifier. It defines a data link from the input port "yourName" to the processor input port "name". This link could also have been written embedded with the workflow:

    <> a scufl2:Workflow ;
      ...
        scufl2:datalink [
            scufl2:receivesFrom <in/yourName> ;
            scufl2:sendsTo <processor/Hello/in/name>
        ] .

The second datalink `<datalink/5>>` defines a link directly from the workflow input port "yourName" to the output port "results".
Links must go from a scufl2:SendingPort sending to a scufl2:ReceivingPort, 
   meaning from a workflow input port or processor output port, going to either a workflow output port or processor input port. 
Several links can receive from the same sending port.
	Merges

> Merges is a way Taverna allows you to connect several links to the
> same scufl2:ReceivingPort, that is to a processor input port or
> workflow output port. When executing, values from each link will be
> inserted into the specified scufl2:mergePosition in a new list.
> 
> You only need to specify scufl2:mergePosition if more than one link is
> connected to the same processor input port or workflow output port. If
> there is more than one link connected to the same receiving port, all
> of them need to specify a unique mergePosition, starting from 0, with
> no gaps. If you specify a single link to the port with a mergePosition
> of 0, that port input would still be wrapped in a list.

The third datalink, specified using the 'full' URI `<datalink?from=processor/Hello/out/greeting&to=out/results&mergePosition=0>`,
  defines the link from the output port "out" in processor "Hello", linking to the workflow output port "results". 
As now two links go to that receiving port, they both need to specify a unique mergePosition. 
The second link specifies position 1, and the third position 0. 
That means that the output port will receive a list Scufl2-DataLink. 
The second element 'yourName' would arrive first (as it is sent before "Hello" produces "greeting"), 
   but it would be arriving in position 1 rather than 0.
	

> URI templates not enough
> 
> The full URIs such as
> <http://ns.taverna.org.uk/2010/researchObject/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/datalink?from=processor/A/out/result&to=processor/B/in/db>
> are meant to be helpful, not defining. The workflow definitions should
> be complete without having to be parse these URIs. Such URIs are
> however useful to be able to annotate or talk about workflow elements
> outside of the workflow definition.
> 
> Although a resource is specified using a full URI which uniquely
> identifies it, such as in the datalink above, the resource must still
> be defined, such as the datalink must define the properties
> scufl2:receivesFrom, scufl2:sendsTo (and optionally)
> scufl2:mergePosition. Similarly the input port <in/yourName> must
> still be defined with a scufl2:name "yourName".
 
The nested resources for this workflow, such as InputProcessorPort ,
OutputProcessorPort, DispatchStack, IterationStrategyStack and their
children should be described in the same file as owning workflow
itself. Additional metadata should be added to an /annotations/ file.

##Properties

 - *scufl2:receivesFrom* (required) The *scufl2:SendingPort* this link is receiving data from. 
   The port must be in the same workflow as the link.
 - *scufl2:sendsTo* (required) The *scufl2:ReceivingPort* this link is sending data to. 
   The port must be in the same workflow as the link.
 - *scufl2:mergePosition* (optional) An integer, starting from 0. 
   Must be set where more than one datalinks *sendsTo* the same ReceivingPort. 
   The positions for a port must be sequentially assigned from 0 without gaps.



