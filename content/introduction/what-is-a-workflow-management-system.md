Title:     What is a Workflow Management System?
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

Workflow Management System (WMS) is a piece of software that provides an infrastructure to setup, execute, 
   and monitor [scientific workflows](/introduction/why-use-workflows). 
In other words, the WMS provide an environment where in 
   [silico experiments](/introduction/what-is-in-silico-experimentation) can be defined and executed.

An important function of an WMS during the workflow execution, or enactment, is the coordination of operation of individual components that constitute the workflow – the process also often referred to as orchestration.

As research becomes more data-intensive and more reliant on the use of computers, larger volumes of experimentation data are recorded quicker and with greater precision. This trend has spurred significant increase in complexity of scientific simulation software. Many tools only perform a small well-defined task, thus necessitating that several of them are joined in a pipeline to model a useful experiment.

Additional difficulties arise from the need to deal with the  incompatible data formats that various services produce or consume.  It is evident that considerable amount of computer science knowledge is required to overcome the  outlined problems; however, domain scientists across disciplines do not have sufficient relevant  expertise.

Scientific workflows and WMSs have emerged to solve this problem and provide an easy-to-use  way of specifying the tasks that have to be performed during a specific in silico experiment. The  need to combine several tools into a single research analysis still holds, but technical details of  workflow execution are now delegated to Workflow Management Systems.
