Title:     Scufl2 URIs
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

 - [URI tree of example workflow bundle](#Scufl2URIs-URItreeofexampleworkflowbundle)
 - [Complete URI tree for example workflow bundle](#Scufl2URIs-CompleteURItreeforexampleworkflowbundle)

<a name="Scufl2URIs-URItreeofexampleworkflowbundle"></a>
##URI tree of example workflow bundle

<ul> <!--markdown can not nest deep enought-->
	<li><code>&lt;http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/&gt;</code>
	<ul>
		<li><code>workflow/HelloWorld/</code>
		<ul>
			<li><code>in/yourName</code></li>
			<li><code>out/results</code></li>
			<li><code>processor/wait4me/</code>
			<ul>
				<li><code>iterationstrategy/</code>
				<ul>
					<li><code>0/</code></li>
				</ul>
				</li>
				<li><code>dispatchstack/</code>
				<ul>
					<li><code>0/</code></li>
					<li><code>1/</code></li>
					<li><code>2/</code></li>
					<li><code>3/</code></li>
					<li><code>4/</code></li>
					<li><code>5/</code></li>
				</ul>
				</li>
			</ul>
			</li>
			<li><code>processor/Hello/</code>
			<ul>
				<li><code>in/name</code></li>
				<li><code>out/greeting</code></li>
				<li><code>iterationstrategy/</code>
				<ul>
					<li><code>0/</code></li>
				</ul>
				</li>
				<li><code>dispatchstack/</code>
				<ul>
					<li><code>0/</code></li>
					<li><code>1/</code></li>
					<li><code>2/</code></li>
					<li><code>3/</code></li>
					<li><code>4/</code></li>
					<li><code>5/</code></li>
				</ul>
				</li>
			</ul>
			</li>
			<li><code>datalink?from=processor/Hello/out/greeting&amp;to=out/results&amp;mergePosition=0</code></li>
			<li><code>datalink?from=in/yourName&amp;to=out/results&amp;mergePosition=1</code></li>
			<li><code>datalink?from=in/yourName&amp;to=processor/Hello/in/name</code></li>
			<li><code>control?block=processor/Hello/&amp;untilFinished=processor/wait4me/</code></li>
		</ul>
		</li>
		<li><code>profile/tavernaWorkbench/</code>
		<ul>
			<li><code>activity/HelloScript/</code>
			<ul>
				<li><code>in/personName</code></li>
				<li><code>out/hello</code></li>
			</ul>
			</li>
			<li><code>processorbinding/Hello/</code>
			<ul>
				<li><code>in/name</code></li>
				<li><code>out/greeting</code></li>
			</ul>
			</li>
			<li><code>configuration/Hello/</code></li>
		</ul>
		</li>
		<li><code>profile/tavernaServer/</code>
		<ul>
			<li><code>activity/HelloScript/</code>
			<ul>
				<li><code>in/personName</code></li>
				<li><code>out/hello</code></li>
			</ul>
			</li>
			<li><code>processorbinding/Hello/</code>
			<ul>
				<li><code>in/name</code></li>
				<li><code>out/greeting</code></li>
			</ul>
			</li>
			<li><code>configuration/Hello/</code></li>
		</ul>
		</li>
	</ul>
	</li>
</ul>


<a name="Scufl2URIs-CompleteURItreeforexampleworkflowbundle"></a>
##Complete URI tree for example workflow bundle

    http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/
      http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/in/yourName
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/out/results
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/iterationstrategy/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/iterationstrategy/0/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/dispatchstack/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/dispatchstack/0/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/dispatchstack/1/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/dispatchstack/2/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/dispatchstack/3/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/dispatchstack/4/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/wait4me/dispatchstack/5/
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/in/name
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/out/greeting
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/iterationstrategy/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/iterationstrategy/0/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/dispatchstack/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/dispatchstack/0/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/dispatchstack/1/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/dispatchstack/2/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/dispatchstack/3/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/dispatchstack/4/
            http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/processor/Hello/dispatchstack/5/
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/datalink?from=processor/Hello/out/greeting&amp;to=out/results&amp;mergePosition=0
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/datalink?from=in/yourName&amp;to=out/results&amp;mergePosition=1
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/datalink?from=in/yourName&amp;to=processor/Hello/in/name
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/control?block=processor/Hello/&amp;untilFinished=processor/wait4me/
      http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/activity/HelloScript/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/activity/HelloScript/in/personName
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/activity/HelloScript/out/hello
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/processorbinding/Hello/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/processorbinding/Hello/in/name
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/processorbinding/Hello/out/greeting
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaWorkbench/configuration/Hello/
      http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/activity/HelloScript/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/activity/HelloScript/in/personName
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/activity/HelloScript/out/hello
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/processorbinding/Hello/
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/processorbinding/Hello/in/name
          http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/processorbinding/Hello/out/greeting
        http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/profile/tavernaServer/configuration/Hello/
    ]]>