[The Taverna suite of tools][1] are bringing together a range of features to make it easier for users to find, design and execute complex workflows and share them with other people.

Freely available

  - Java, open source, LPGL licensed (GPL for Astronomy versions)

Suite of tools to design, edit and execute workflows

  - Workflow design and execution in Taverna Workbench
  - Command line execution of workflows
  - Remote execution of workflows on a Taverna server
  - Invoke workflows from the Internet

Wide range of services and extensible architecture

  - Service discovery
  - Various service types available: WSDL-style and RESTful Web services, BioMart, BioMoby, SoapLab, R, 
         Beanshell, Excel and csv spreadsheets
  - Service creation for external tools or Java libraries
  - Calling tools/scripts on a local machine or remote machines (via ssh)
  - Extensible service plug-in architecture for adding new service types
  - [Fully integrated support for browsing curated service catalogues][2], 
         such as the [BioCatalogue][3], for Web services (WSDL/SOAP and REST)
  - Interaction with a running workflow within a web browser
  - Ability to define and share semantically annotated components, and have them used as services in workflows

Secure

  - Support for secure services (HTTP authentication, WS-Security, X.509 client authentication)
  - Secure management of users’ credentials

Versatile Workbench

  - Tabs for finding, designing and executing workflows
  - Fully graphical workflow design
  - Drag and drop workflow components
  - Comprehensive undo/redo
  - Built-in help facility
  - Annotations for describing workflows, services, inputs, outputs
  - Workflow validation and debugging

Create your own or start from existing workflows

  - Easy design of new workflows
  - Load existing workflows (from a disk, [myExperiment][4] or a URL)
  - View workflow layout and logic
  - Modify existing workflows
  - Load workflows in off-line mode (when disconnected from the Internet)
  - Nested workflows (sub workflows)
  - Workflow validation during design time for debugging while composing a workflow
  - Built-in detection when a service’s interface changes or a service go off-line during design time

Find workflows created by others and share yours

  - [Full myExperiment search options for browsing workflows][5]
  - Publish workflows on myExperiment for use by others

Execute and debug your workflows

  - Execute workflows
  - Remember previously used workflow inputs
  - Save workflow input values used to a file
  - Load workflow input values from a file
  - Pipelining and streaming of data
  - Implicit iteration of service calls
  - Conditional and repeated calling of services
  - Customizable looping over a service
  - Failover and retry of service calling
  - Parallel execution and configurable number of concurrent threads
  - Improved error handling and reporting for debugging during run time
  - Monitor workflow execution
  - Pause/resume or cancel workflow execution
  - Manage previous runs and workflow results
  - View intermediate results and debug workflows at run time
  - Filter and save intermediate and final workflow results

Track workflow runs and results

  - Record workflow execution provenance
  - Review provenance of previous workflow runs
  - Experimental export of provenance in the [OPM][6] and Janus formats

Support

  - End user technical support and e-mail help desk
  - Tutorials and workshops

##myExperiment integration##

[![www.myexperiment.org][7]][4]

[myExperiment][4] is a social networking site and Virtual Research Environment (VRE) designed for people to share, discover and reuse workflows.

myExperiment enables scientists to contribute to a pool of workflows that can be reused and repurposed by other scientists, promoting building of communities, forming of relationships and collaboration. In this way, myExperiment helps reduce time-to-experiment, share expertise and avoid reinvention.

It is widely used, as demonstrated by their being 8820 members in 304 groups. Its actual take up shows that there are 2415 workflows, consisting of 604 files. The number of packs (research objects) currently in use stands at 229.

###Find myExperiment workflows by others and share yours from Taverna###

As of version 2.1, Taverna has a built-in support for myExperiment, enabling users to browse myExperiment Web site from inside the Taverna Workbench.

Users can access the full myExperiment search options for browsing workflows, load existing workflows from myExperiment or publish their workflows on myExperiment for use by others.

A snapshot of the myExperiment Perspective in Taverna can be seen in the image below.

![myExperiment Perspective][8]


  [1]: /introduction/
  [2]: /introduction/taverna-features/biocatalogue-integration/
  [3]: http://www.biocatalogue.org/
  [4]: http://www.myexperiment.org/
  [5]: /introduction/taverna-features/myexperiment-integration/
  [6]: http://openprovenance.org/
  [7]: img/MyExperiment_logo_1672x320.png
  [8]: img/myExperimentPerspective.png