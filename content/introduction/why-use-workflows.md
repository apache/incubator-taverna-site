Title:     Why use workflows?
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

##History##

Workflow, as a concept, was defined in the business domain in 1996 by the Workflow Management Coalition as:

> “The automation of a business process, in whole or part, during which documents, 
   information or tasks are passed from one participant to another for action, 
   according to a set of procedural rules.”

##Scientific workflows##

Scientific workflows are widely recognised as a “useful paradigm to describe, manage, 
   and share complex scientific analyses”. They are the method often used by the 
   [in silico experimentation](/introduction/what-is-in-silico-experimentation).

Scientific workflows have emerged to tackle the problem of excessive complexity in scientific experiments and 
   applications. 
They provide a high-level declarative way of specifying what a particular in silico experiment modelled 
by a workflow is set to achieve, not how it will be executed.

Various types of tasks that can be performed within a workflow can be implemented by local services, 
   remote Web services, scripts, and sub-workflows (complete workflows used as subroutines in larger ones). 
Each component is only responsible for a small fragment of functionality, 
   therefore many components need to be chained in a pipeline in order to obtain a workflow that can perform 
   a useful task.

The process of linking components is known as workflow composition, 
   a result of which a conceptual model of the described scientific analysis is produced. 
This model is often represented as a graph-like structure (example can be seen in Figure 1 below) 
   that defines the flow of data within the workflow – and thus its semantic meaning. 
Representations of all required heterogeneous resources are integrated into this single workflow, 
   thus abstracting superfluous detail and concentrating on the real goal of the experiment.

An example of simple workflow that retrieves a weather forecast for the specified city

<p class="text-center">
<img title="Get weather forecast for a city workflow" src="/img/get_weather_workflow.png" 
   alt="An example of simple workflow that retrieves a weather forecast for the specified city" 
   width="195" height="269" />
</p>

<p class="text-center">
Figure 1. An example of a simple workflow that retrieves a weather forecast for the specified city
</p>

The use of workflows allows offloading much of the data processing to remote components and 
   makes it feasible to execute even larger and more complex workflows on regular personal computers. 
This is the reason why Web services are normally chosen to perform most of the core computation in workflows, 
   whereas local services and scripts are used to perform data format conversion procedures and 
   other auxiliary tasks.

A further advantage of using workflows is the potential to automate highly repetitive processing stages that 
   research work is known to involve. This, in turn, can stimulate the pace of research and 
   the overall productivity of experimentation through evident savings in time and effort.

To learn more about scientific workflows and their role in data-intensive experiments, have a look at:

  - [“The impact of workflow tools on data-centric research”](http://research.microsoft.com/en-us/collaboration/fourthparadigm/4th_paradigm_book_part3_goble_deroure.pdf)
      chapter by Carole Goble and David De Roure of the 
      [“The Fourth Paradigm: Data-Intensive Scientific Discovery“](http://research.microsoft.com/en-us/collaboration/fourthparadigm/)
      book.
  - [“Scientific workflows”](http://cnx.org/contents/8fedc2ef-93a4-4f55-9bca-52820a2586b7@3/Scientific_Workflows) 
       paper by Katy Wolstencroft,  Paul Fisher,  David De Roure and Carole Goble.

Massive power, minimal complexity

Because services within a workflow do not normally reside on the machine you use to create and run the workflow,
   your local machine does not have to be a supercomputer. 
By installing and using the Taverna 
   [Workflow Management System(/introduction/what-is-a-workflow-management-system) 
   you can tap into the resources of 
   a number of institutes, hundreds of analysis applications and literally thousands of CPUs worth of 
   computational power entirely for free, with no installation or support hassle for you.

Of course, if you already have significant resource in house it is a relatively simple matter to 
   integrate these resources in Taverna with those available from other sites.
