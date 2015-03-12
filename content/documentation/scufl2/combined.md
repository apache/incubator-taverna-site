Title:     SCUFL2 Taverna Language
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


SCUFL2 is the new (since Taverna 3) mechanism for specifying Taverna workflows. 
SCUFL2 defines a model, a workflow bundle file format (.wfbundle), and a Java API for working with workflow structures. 
SCUFL2 is the workflow language for Taverna 3, and replaces Taverna 2's t2flow format.

##Summary

SCUFL2 is the Taverna 3 mechanism for specifying Taverna workflows. 
SCUFL2 adopts Linked Data technology and preservation methodologies to create a platform-independent workflow language 
   that can be inspected, modified, created and executed.

SCUFL2 comes with a [Java API](/documentation/scufl2/api) that can be used for programmatic access to read and write SCUFL2 
   [workflow bundles](/documentation/scufl2/bundle). 
A workflow bundle is a structured ZIP file with the workflow definitions included as XML documents. 
Those workflow documents are described by an XML Schema and are also valid RDF/XML. 
The XML Schema allows tools to read and write SCUFL2 workflow definitions as regular structured XML. 
The RDF allows RDF-enabled tools to link workflow definitions with external resources.

The workflow structure is defined using an [OWL ontology](/documentation/scufl2/ontology)
   and annotated with URIs so that third parties can form semantic statements about any component of a Scufl2 workflow, 
   for example to state that a particular service produces outputs of a certain type, 
   or that a data link was added by a specific researcher.

Semantic annotations and a manifest for the bundle declare the purpose of, 
   and links between the different components forming a workflow. 
This allows third parties to extract and append annotations about data and services used by the workflow.

##Motivation

The t2flow serialization format suffers from being very close to the Java object model, 
   and contains various items that are simply Java beans serialized using *XMLBeans*. 
As the t2flow format is very verbose, it can be difficult to deal with for third party software to do 
   **inspection** ("Which services does this workflow use?"), **modification** 
   ("Change all calls to *broken.com* to *fixed.com*") and **generation** 
   ("Build a custom workflow from a button").

Developers have informed us that the old SCUFL format of Taverna 1 was significantly easier to work with. 
However, this format also has its caveats, like no schema, 
   unidentified ways to extend service definitions for Taverna plugins and 
   not supporting various new features in the Taverna 2 engine.

We have therefore decided to form a new serialisation format for workflows, called **SCUFL2**.

##Overview

SCUFL2 consists of:

 - [SCUFL2 language](/documentation/scufl2/language)
 - SCUFL2 [Workflow Bundle](/documentation/scufl2/bundle) format
 - [SCUFL2 API](/documentation/scufl2/api) for Java



# Scufl2-WorkflowBundle

The entry point of the Taverna Workflow Bundle.

Defines the *workflows* and *profiles* of a 
   [Taverna Workflow Bundle](/documentation/scufl2/taverna_bundle).
The *main workflow* is also normally defined, which would be the top-level workflow to execute. 
The profiles defines how these workflows can be realised and *executed* on different environments, 
   one of which can be suggested as the *main profile*.

##Bundle path and root files

The **workflow bundle document** in RDF/XML format **should** be in in `/workflowBundle.rdf` within the bundle archive.

If the archive is a [workflow bundle](/documentation/scufl2/taverna_bundle), 
   i.e. `/mimetype` is `application/vnd.taverna.scufl2.workflow-bundle`, 
   then the `META-INF/container.xml` can define **root files** at alternative paths and media types. 
This specification requires that one of those formats is `application/rdf+xml` according to this specification. 

Example `META-INF/container.xml`: (may be outdated)

    <?xml version=&quot;1.0&quot;?>
    <container version="1.0"
        xmlns=";urn:oasis:names:tc:opendocument:xmlns:container">
        <rootfiles>
            <rootfile full-path="workflowBundle.ttl"
             media-type="text/turtle" />  
             <rootfile full-path="workflowBundle.rdf"
             media-type="application/rdf+xml" />  
        </rootfiles>
    </container>   

This defines the RDF/XML root file to be `/workflowBundle.rdf` - 
   with `workflowBundle.ttl` being an alternate representation the resource in Turtle format.

SCUFL2-compliant workflow bundle writers:

 - **Must** set the bundle **mimetype** to `application/vnd.taverna.scufl2.workflow-bundle`
 - **Must** add a workflow bundle document in `application/rdf+xml` format
 - **Should** store the workflow bundle document in `/workflowBundle.rdf`
 - **Must not** contain a resource `/workflowBundle.rdf` which is not the workflow bundle document
 - If the `application/rdf+xml` representation is not in `/workflowBundle.rdf`, 
     the writer **must** include `META-INF/container.xml` with the required `<rootfile>` entries.
 - `META-INF/container.xml`, if present, **must** contain one and only one `rootfile` with the media-type 
     `application/rdf+xml`. 
   rootfiles of other media-types **may** be included, but their formats and restrictions are not defined by this specification.
 - **May** Add additional representation of the workflow bundle document (and other documents). 
   Alternates of the workflow bundle document **should** be included in the `META-INF/container.xml`, 
     but only if they can be considered to fully specify the workflow bundle as in the RDF/XML format. 
   (So for instance a `text/html` or `image/png` representation would not normally be considered a 
     **rootfile** if it does not include all the structural information from the RDF/XML representation as specified here)

It is possible to include a workflow bundle document within a different kind of archive or bundle, 
   for instance in a data bundle.
In this case the bundle is not considered an `application/vnd.taverna.scufl2.workflow-bundle` - 
   but producers of such archives:

 - **Should** store the workflow bundle document in `/workflowBundle.rdf`, 
      unless the workflow bundle is not to be considered to have a 'main' or 'prominent' role within the archive. 
   (For instance if the archive is a collection of workflow bundles).
 - **Should** have a `mimetype` and `META-INF/container.xml` resource which declares the archive's main entry point, 
     like the data bundle document. 
   The mime type **must not** be `application/vnd.taverna.scufl2.workflow-bundle` and 
      the root files **should not** be the workflow bundle document.</li>
 - **Should** link to the workflow bundle document from a resource within the archive which (ultimately) 
      is linked to from one of the `rootfile` documents. 
   Such documents **should** be in RDF/XML format.
 - **Should** declare the media type of the RDF/XML workflow bundle document as `application/rdf+xml` 
      in its `META-INF/manifest.xml`

SCUFL2 compliant workflow bundle readers:

 - **Should** assume that `/workflowBundle.rdf` - if present - 
       is the root workflow bundle in the `application/rdf+xml` format specified here.
 - **Should** assume that if the archive's `mimetype` is `application/vnd.taverna.scufl2.workflow-bundle`, 
       then the `rootfile` in `META-INF/container.xml` with the media type {{application/rdf+xml}) 
       is the root workflow bundle document.
 - **May** assume that any alternate formats listed as a `rootfile` in a `application/vnd.taverna.scufl2.workflow-bundle` 
       archive would fully cover the specification of the RDF/XML representation, and read such formats instead.
 - **May** assume that any `application/rdf+xml` document with a `xsi:type="WorkflowBundleDocument"` 
       can be parsed according to the Scufl2 XML schema

##Identifiers

Workflow bundles and their resources **must** be declared with relative identifiers within the archive. 
In a `application/vnd.taverna.scufl2.workflow-bundle` archive, 
  the workflow bundle **must** be identified as the root of the archive. 
If the Workflow Bundle document is in `workflowBundle.rdf` within the archive, the workflow identifier is `./`.  
This **should** be achieved by setting `xml:base="./"` and `rdf:about=""`.

This means that one can mint a URI to refer to resources within the bundle archive, including the workflow bundle, 
   workflows and representations. 
If `http://example.com/myWfBundle.scufl2` returns a [Scufl2 workflow bundle](/documentation/scufl2/taverna_bundle) 
   archive of the content type `application/vnd.taverna.scufl2.workflow-bundle`,  
   then (assuming default structure of the archive):

 - `http://example.com/myWfBundle.scufl2` identifies for the Workflow Bundle representation (the archive)
 - `http://example.com/myWfBundle.scufl2/` identifies the Workflow Bundle (as described here)
 - `http://example.com/myWfBundle.scufl2/workflowBundle.rdf` identifies the Workflow Bundle representation in RDF/XML
 - `http://example.com/myWfBundle.scufl2/workflow/HelloWorld/` identifies the "HelloWorld" 
      [workflow](/documentation/scufl2/workflow) within the bundle
 - `http://example.com/myWfBundle.scufl2/workflow/HelloWorld.rdf` identifies the "HelloWorld" workflow representation in RDF/XML
 - `http://example.com/myWfBundle.scufl2/workflow/HelloWorld/processor/Hello/` identifies the "Hello" 
      processor within the "HelloWorld" workflow.

###Embedded workflow bundles

If the archive is another type of bundle which includes the workflow bundle 
   (but is not primarily playing the role as the format for this workflow bundle), 
   the local workflow identifier **should** be unique within the archive. 
This is easiest achieved by using the same folder technique as for the workflow representations:

 - `workflowBundle1.rdf` can define `workflowBundle1/`
 - `exampleWorkflowBundles/hello.rdf` defines `exampleWorkflowBundles/hello/`

Such embedded workflow bundles **should** include their constituent representations 
   (such as `workflow/HelloWorld.rdf`) within that folder, 
   for instance `exampleWorkflowBundles/hello/workflow/HelloWorld.rdf` to define 
   `exampleWorkflowBundles/hello/workflow/HelloWorld/` - but could also be shared among bundles, 
   for instance both `workflowBundle1.rdf` and `workflowBundle2.rdf` might refer to `workflow/Shared.rdf`.

###Global workflow bundle identifiers

Workflow bundles **should** declare a **sameBaseAs** reference to a globally unique non-informational URI.

Anyone can generate such a URI using the form `http://ns.taverna.org.uk/2010/workflowBundle/UUID/` - 
   for instance `http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/` - 
   including the trailing slash.

The semantics of **sameBaseAs** is a kind of recursive version of **owl:sameAs** - 
   so also resources which URI start with the same will be included.

So if:

    @prefix : <;http://ns.taverna.org.uk/2010/scufl2> .
    @prefix rdfs: <http://www.w3.org/2000/01/rdf-schema> .

    <./>     a :WorkflowBundle;
         :name "HelloWorld";
         :sameBaseAs <http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/>;
         :mainWorkflow <workflow/HelloWorld/>;
         :workflow <workflow/HelloWorld/>;

    <workflow/HelloWorld/>     a :Workflow;
         rdfs:seeAlso <workflow/HelloWorld.ttl> .


then also:

`<./> `= `<http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/>`   
`<workflow/HelloWorld/>` = `<http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld/>`   
`<workflow/HelloWorld.rdf>` = `<http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/workflow/HelloWorld.rdf>`

This allows anyone to make a statement about any resource within the workflow bundle, 
   even if the URL of the workflow bundle representation itself might change,
   be it on a local USB disk, DropBox folder, myExperiment, etc.

####Updating the UUID

It is up to the software editing or creating the workflow to assign a new UUID as soon as 
   any change has been done to any workflow, profile or workflow bundle, 
   as this is the globally unique identifier for this workflow archive, 
   and also the base URI for all the other resources in the archive.

> ![](/img/warning.png)**Not implemented by API** Scufl2 API do not yet
>
> automatically update the workflow bundle identifier. 
> [SCUFL2-41](http://www.mygrid.org.uk/dev/issues/browse/SCUFL2-41)
> 
> To update the URI, use `workflowBundle.setSameBaseAs(WorkflowBundle.generateIdentifier())`.

##Example representation in RDF/XML
(may be outdated)

    <?xml version="1.0"?>
    <rdf:RDF xmlns="http://ns.taverna.org.uk/2010/scufl2#"
        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://ns.taverna.org.uk/2010/scufl2# http://ns.taverna.org.uk/2010/scufl2/scufl2.xsd http://www.w3.org/1999/02/22-rdf-syntax-ns# http://ns.taverna.org.uk/2010/scufl2/rdf.xsd"
        xsi:type="WorkflowBundleDocument" xml:base="./">
        <WorkflowBundle rdf:about="">
            <name>HelloWorld</name>
            <sameBaseAs
                rdf:resource="http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/" />      
            <mainWorkflow rdf:resource="workflow/HelloWorld/" />
            <workflow>
                <Workflow rdf:about="workflow/HelloWorld/">
                    <rdfs:seeAlso rdf:resource="workflow/HelloWorld.rdf" />
                </Workflow>
            </workflow>
            <!--
            <workflow>
                <Workflow rdf:about="workflow/SomeNestedWorkflow/">
                    <rdfs:seeAlso rdf:resource="workflow/SomeNestedWorkflow.rdf" />
                </Workflow>
            </workflow>
            -->
            <mainProfile rdf:resource="profile/tavernaWorkbench/" />
            <profile>
                <Profile rdf:about="profile/tavernaServer/">
                    <rdfs:seeAlso rdf:resource="profile/tavernaServer.rdf" />
                </Profile>
            </profile>
            <profile>
                <Profile rdf:about="profile/tavernaWorkbench/">
                    <rdfs:seeAlso rdf:resource="profile/tavernaWorkbench.rdf" />
                </Profile>
            </profile>
            <rdfs:seeAlso rdf:resource="annotation/workflowBundle.rdf" />
        </WorkflowBundle>
    </rdf:RDF>

This example defines the workflow bundle "HelloWorld". 
It contains one workflow `workflow/HelloWorld`, which is also the **main workflow**. 
Any additional workflows are typically nested (and nested-nested, etc) workflows bound as activities in processors). 
Two execution profiles are provided, and `profile/tavernaWorkbench` is dedicated as the **main profile**.

##Properties

 - **name** (required) gives the human readable title for this workflow archive. 
     This is a subproperty of `dc:title`.
 - **sameBaseAs** (optional) gives a unique URI which is **owl:sameAs** with this workflow bundle and its children.
 - **workflow** (required) All [workflows](/documentation/scufl2/workflow) included in this bundle. 
     Each workflow must have an **rdfs:seeAlso** link to the bundle resource that defines the workflow, 
       typically `workflow/workflowName.rdf` corresponding to the non-information resource `workflow/workflowName/`.
 - **mainWorkflow** (optional) The reference to the top-level [workflow](/documentation/scufl2/workflow) of this bundle. 
   It is valid to have a workflow bundle without a main workflow, 
      for instance if the bundled workflows are unconnected "workflow fragments". 
   If there is a **mainProfile** the workflow bundle must also have a **mainWorkflow**. 
   The main workflow must always be listed under **workflow**.
 - **profile** (optional) <a href="/wiki/display/developer/Scufl2-Profile">profiles</a> specifying how to <strong>execute</strong> the bundled workflows. In particular the profile provides a set of configured activities bound to the processors for a particular run environment. If no profiles are specified this is an abstract workflow bundle.</li>
 - **mainProfile** (optional) the suggested <strong>main profile</strong>. Execution platforms unable to choose between the provided profiles can select this profile as a default. It is valid to have a workflow bundle without a main profile (even if it has other profiles), but any main profile must be listed under <strong>profile</strong>.</li>
 - **rdfs:seeAlso** (optional) link to annotations about the workflow bundle and its content. Traditionally found in <code>annotation/workflowBundle.rdf</code>, which should contain further links to annotations from different sources, for instance <code>annotation/myExperiment.rdf</code> for annotations included from myExperiment.</li>

##Bundle links

The workflow bundle document is the starting point for finding all workflow bundle resources within the archive. 
Each of the workflows and profiles must therefore have a **rdfs:seeAlso** link to the bundle resource that defines it.

If alternate formats other than the required RDF/XML format is included in the bundle, 
   these formats can therefore link to resources in other formats, for instance in an additional `workflowBundle.ttl` 
   ([Turtle format](http://www.w3.org/TeamSubmission/turtle/)):

    @prefix : <http://ns.taverna.org.uk/2010/scufl2#> .
    @prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .
     
    <./>     a :WorkflowBundle;
         :mainProfile <profile/tavernaWorkbench/>;
         :mainWorkflow <workflow/HelloWorld/>;
         :name "HelloWorld";
         :profile <profile/tavernaServer/>,
                <profile/tavernaWorkbench/>;
         :sameBaseAs <http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/>;
         :workflow <workflow/HelloWorld/>;
         rdfs:seeAlso <annotation/workflowBundle.ttl> .
     
    <profile/tavernaServer/>     a :Profile;
         rdfs:seeAlso <profile/tavernaServer.ttl> .
     
    <profile/tavernaWorkbench/>     a :Profile;
         rdfs:seeAlso <profile/tavernaWorkbench.ttl> .
     
    <workflow/HelloWorld/>     a :Workflow;
         rdfs:seeAlso <workflow/HelloWorld.ttl> .

##Parsing/writing

SCUFL2 compliant writers, when producing the workflow bundle document:

 - **Should** write the workflow bundle RDF/XML document according to the SCUFL2 XML schema, 
      use the default namespace `xmlns="http://ns.taverna.org.uk/2010/scufl2#"` and declare the 
      `xsi:type="WorkflowBundleDocument"`
 - **Must** ensure the workflow bundle RDF/XML document is valid [RDF/XML](http://www.w3.org/TR/REC-rdf-syntax/) 
     and includes the properties deemed required by this specification. 
   Conforming to the XML schema should ensure this.
 - **Should** set the `xml:base` property to`"./`
 - **Should** set **rdf:about** to `""` (or `"./"' if `xml:base` is not set))
 - **Should** declare a **mainWorkflow** and **mainProfile**
 - **Must**ensure that any **workflow**/**profile** has a relative **rdfs:seeAlso** link to a bundle resource in 
     `application/rdf+xml` which defines   
    that [workflow](/documentation/scufl2/workflow) / [profile](/documentation/scufl2/profile).

SCUFL2 compliant readers, when parsing a workflow bundle document:

**May** assume that a declared workflow/profile is defined in the referenced representation. 
  For instance, if:

    <workflow>
       <Workflow rdf:about="workflow/SomeNestedWorkflow/">
          <rdfs:seeAlso rdf:resource="workflow/SomeNestedWorkflow.rdf" />
       </Workflow>   
    </workflow>

then `workflow/SomeNestedWorkflow.rdf`> **must** contain a [workflow definition](/documentation/scufl2/workflow) 
   for `workflow/SomeNestedWorkflow/`.   
**May** parse the `/workflowBundle.rdf` as RDF/XML   
**May** parse the {/workflowBundle.rdf}} according to the XML schema if the `xsi:type="WorkflowBundleDocument"` 
   is set on the `rdf:RDF` element.


# Scufl2-Workflow

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

# Scufl2 Profile

Details of the Scufl2 profile still to be added.

# Taverna Workflow Bundle

The primary SCUFL2 file format is the Taverna *workflow bundle*.

<table><tbody>
<tr>
<th>Media type</th>
<td><code>application/vnd.taverna.scufl2.workflow-bundle</code></td>
</tr>
<tr>
<th>File extension</th>
<td><code>.wfbundle</code></td>
</tr>
<tr>
<th>File type</th>
<td>Zip archive</td>
</tr>
</tbody></table></div>

This file is a structured ZIP archive, based on the 
   [Adobe UCF](http://livedocs.adobe.com/navigator/9/Navigator_SDK9_HTMLHelp/wwhelp/wwhimpl/common/html/wwhelp.htm?context=Navigator_SDK9_HTMLHelp&amp;file=Appx_Packaging.6.31.html)
   format.
This is similar to the structured ZIPs used by the OpenOffice format [ODF](http://en.wikipedia.org/wiki/OpenDocument_technical_specification#Format_internals).

For a file to be a Taverna Workflow Bundle if it **must**:

 - Is a valid [ZIP container](http://livedocs.adobe.com/navigator/9/Navigator_SDK9_HTMLHelp/wwhelp/wwhimpl/common/html/wwhelp.htm?context=Navigator_SDK9_HTMLHelp&amp;file=Appx_Packaging.6.1.html#1522568)
 - Contains the file `mimetype` with the ASCII content `application/vnd.taverna.scufl2.workflow-bundle` (without LF/CR)
 - Contains the file `workflowBundle.rdf` as a valid [RDF/XML](http://www.w3.org/TR/rdf-syntax-grammar/) 
     document describing a [workflow bundle](/documentation/scufl2/bundle)

To be fully compliant, the bundle **should** also:

 - Contain a valid `META-INF/manifest.xml` file listing all files in the archive
 - Contain a valid `META-INF/container.xml` file including an entry for `workflowBundle.rdf`

The [workflow bundle document](/documentation/scufl2/bundle) is the top level entry point ("root file") 
   for the archive (think: `index.html`), and describes:

 - Which workflows are included in the bundle under `workflow/`
 - Which profiles are included in the bundle under `profile/`
 - Which of the workflows is the suggested *main workflow*
 - Which of the profiles is the suggested *main profile*
 - What is the global workflow bundle identifier.

A Workflow Bundle document can also be included as part of any other bundle, 
   archive or resource according to these specifications. 
In that case the resource name might or might not be `workflowBundle.rdf`, 
   this depends on the specification of that other format.

###Archive directory structure

<table><tbody>
<tr>
<th>Path</th>
<th>Type</th>
<th>Description</th>
</tr>
<tr>
<td>mimetype</td>
<td>Text</td>
<td>Mime type of bundle, ie. <code>application/vnd.taverna.scufl2.workflow-bundle</code></td>
</tr>
<tr>
<td>META-INF/</td>
<td>Folder</td>
<td>Reserved folder for manifest </td>
</tr>
<tr>
<td> META-INF/manifest.xml </td>
<td> XML </td>
<td> ODF 1.3-like manifest, listing each file, mime-type and file size </td>
</tr>
<tr>
<td> META-INF/container.xml </td>
<td> XML </td>
<td>Adobe UCF/OEBPS list of <a href="http://livedocs.adobe.com/navigator/9/Navigator_SDK9_HTMLHelp/wwhelp/wwhimpl/common/html/wwhelp.htm?context=Navigator_SDK9_HTMLHelp&amp;file=Appx_Packaging.6.31.html" class="external-link" rel="nofollow">root files</a> (ie. <code>workflowBundle.rdf</code>))</td>
</tr>
<tr>
<td> workflowBundle.rdf </td>
<td> RDF/XML </td>
<td> <a href="/wiki/display/developer/Scufl2-WorkflowBundle">Workflow Bundle Document</a> </td>
</tr>
<tr>
<td>vworkflow/ </td>
<td> Folder </td>
<td> Workflow definitions </td>
</tr>
<tr>
<td> workflow/HelloWorld.rdf </td>
<td> RDF/XML</td>
<td> <a href="/documentation/scufl2/workflow">Workflow definition</a> for &quot;HelloWorld&quot; </p></td>
</tr>
<tr>
<td>workflow/otherWorkflow.rdf</td>
<td> RDF/XML</td>
<td> Workflow definition for &quot;otherWorkflow&quot; </td>
</tr>
<tr>
<td> profile/ </td>
<td> Folder </td>
<td> Execution <a href="/wiki/display/developer/Scufl2-Profile">Profile </a> definitions </td>
</tr>
<tr>
<td> profile/someProfile.rdf </td>
<td> RDF/XML</td>
<td> Profile definition &quot;someProfile&quot; </td>
</tr>
<tr>
<td> profile/other.rdf </td>
<td> RDF/XML</td>
<td> Profile definition &quot;other&quot;</td>
</tr>
</tbody></table></div>

The archive must be a ZIP file, and should have the file extension `.wfbundle`. 
Some situations might require treating the workflow bundle as an unpacked set of folders. 
In this case the top folder should still have the file extension `.wfbundle`.

According to the Adobe UCF specifications, the `mimetype` file must be the *first file* in the folder, 
   and must be stored without compression, encryption or permission attributes, 
   to support detection by mimemagic and similar.

The file `META-INF/manifest.xml` - if present - must list every non-`META-INF` file and folder in the archive, 
   including the root folder. 
It should provide the mime-type - if known - for individual files. 
The root folder should have the same mime type as in the `mimetype` file - `application/vnd.taverna.scufl2.workflow-bundle`.

The file `META-INF/container.xml` - if present - should point to the 'root' workflow bundle document. 
One and only one entry which must be of the mime type `application/rdf+xml`, 
   and this entry must be called `workflowBundle.rdf`. 
Alternative representation of the workflow bundle root document can be included in other formats, 
   there's no similar restriction on their filenames, although it is recommended they match the RDF/XML filename, 
   for instance `workflowBundle.html`, `workflowBundle.json`, etc.

The folder `workflow` contain each of the workflow definitions as 
   [Workflow Documents](/documentation/scufl2/workflow). 
One of these is typically the *main workflow* while the others are *nested workflows*, 
   but there is no requirement that the workflows included are to be included as a nested workflow or a main workflow. 
Such 'dangling workflows' can be considered to be only *declared workflows* - 
   they might be there for historical reasons or because the workflow bundle is at an early stage of development 
   when there is no main workflow yet.

The execution details of workflows (such as activity choice, configuration) are described in the `profile` folder, 
   one [Profile Document](/documentation/scufl2/profile) per possible execution binding. 
(For instance, one profile for the graphical Workbench, one for the Taverna Server and one for the Taverna Portal.). 
One profile document can include execution details for several workflows, 
   but there could also be workflows which don't have any execution details in any profile - 
   these can be considered *abstract workflows*.

##workflowBundle.rdf

The workflow bundle document `workflowBundle.rdf` should list each of these *workflows* and *profiles*, 
   and **should** suggest the *main workflow* and *main profile*. 

##mimetype

This file is required, as a guide for mime magic and similar tools that guess the type of the archive. 
Therefore it must be added as the first file to the archive, uncompressed, 
   so that its content is available in cleartext in the first bytes of the ZIP archive.

The file must be in ASCII and **not** contain any line feeds. 
If the archive is a Taverna Workflow Bundle, the mime type should be `application/vnd.taverna.scufl2.workflow-bundle`. 
If `META-INF/manifest.xml` is present, this mime type must match the mime type of `"/"` in the manifest.

To add the file `mimetype` as the first uncompressed file, followed by the rest of the bundle (excluding the mimetype file), 
   try using InfoZip:

    $ zip -0 -X ../example.wfbundle mimetype
      adding: mimetype (stored 0%)
    
    $ zip -X -r ../example.wfbundle . -x mimetype
      adding: workflowBundle.rdf (deflated 74%)
      adding: workflow/ (stored 0%)
      adding: workflow/HelloWorld.rdf (stored 0%)
    ..
      adding: META-INF/ (stored 0%)
      adding: META-INF/manifest.xml (deflated 78%)
      adding: META-INF/container.xml (deflated 50%)

To verify:

    $ unzip -lv ../example.wfbundle
    Archive:  ../example.wfbundle
     Length   Method    Size  Cmpr    Date    Time   CRC-32   Name
    --------  ------  ------- ---- ---------- ----- --------  ----
          35  Stored       35   0% 2010-10-11 16:44 8373c7d8  mimetype
        3047  Defl:N      786  74% 2010-10-13 09:40 743ecfe4  workflowBundle.rdf
           0  Stored        0   0% 2010-10-06 14:57 00000000  workflow/
    ...
    
    $ python -c &quot;print open (&#39;../example.wfbundle&#39;).read(128)[38:84]&quot;
    print("code sample");`application/vnd.taverna.scufl2.workflow-bundle

##META-INF/manifest.xml

This file, if exists, should follow the OpenDocument container format, 
   and list every file in the bundle (except for the META-INF files). 
The main functionality provided by the manifest is to give the mime-type of additional resources. 
As a minimum the mime-type should distinguish between `text/plain` (UTF-8 text) and `application/octet-stream` (binary). 
If a mime-magick like tool has guessed a more detailed mime type, it can also be provided here.

Additionally the manifest may specify the file sizes, 
cccin general this can be useful when inspecting a larger workflow bundle remotely (exposed as a RESTful folder or similar).

The folder `/` represents the bundle itself, and must have the same mime type as in the file `mimetype`, 
   ie. `application/vnd.taverna.scufl2.workflow-bundle`. 
A different mime type might be used if the primary purpose of the archive is different from being a workflow bundle, 
   for instance being a Taverna Data Bundle.

The `workflowBundle.rdf` file must be listed in the manifest, and it must be listed with the `application/rdf+xml` mime type. 
Any alternative representations must also be listed, and their mime type must match those in `META-INF/container.xml` 
   (see below).

The other folders are not required to have a mimetype.

If there is no manifest in the workflow bundle, 
   all data value files should be treated to be binary `application/octet-stream`, 
   unless they have one of these file extensions:</p>

 - `*.txt` is `text/plain` in UTF-8 character set
 - `*.rdf` is `application/rdf+xml`

Example manifest:

    <?xml version="1.0" encoding="UTF-8"?>
    <manifest:manifest xmlns:manifest="urn:oasis:names:tc:opendocument:xmlns:manifest:1.0">
     <manifest:file-entry manifest:media-type="application/vnd.taverna.scufl2.workflow-bundle" manifest:full-path="/"/>
     
     <manifest:file-entry manifest:media-type="application/rdf+xml" manifest:full-path="workflowBundle.rdf"/>
     <manifest:file-entry manifest:media-type="application/rdf+xml" manifest:full-path="workflow/HelloWorld.rdf"/>
     <manifest:file-entry manifest:media-type="application/rdf+xml" manifest:full-path="annotation/workflow/HelloWorld.rdf"/>
     <manifest:file-entry manifest:media-type="application/rdf+xml" manifest:full-path="annotation/workflowBundle.rdf"/>
     <manifest:file-entry manifest:media-type="application/rdf+xml" manifest:full-path="profile/tavernaWorkbench.rdf"/>
     <manifest:file-entry manifest:media-type="application/rdf+xml" manifest:full-path="profile/tavernaServer.rdf"/>
     
     <manifest:file-entry manifest:media-type="text/turtle" manifest:full-path="workflowBundle.ttl"/>
     <manifest:file-entry manifest:media-type="text/turtle" manifest:full-path="workflow/HelloWorld.ttl"/>
     <manifest:file-entry manifest:media-type="text/turtle" manifest:full-path="annotation/workflow/HelloWorld.ttl"/>
     <manifest:file-entry manifest:media-type="text/turtle" manifest:full-path="annotation/workflowBundle.ttl"/>
     <manifest:file-entry manifest:media-type="text/turtle" manifest:full-path="profile/tavernaWorkbench.ttl"/>
     <manifest:file-entry manifest:media-type="text/turtle" manifest:full-path="profile/tavernaServer.ttl"/>
     
     <manifest:file-entry manifest:media-type="image/svg+xml" manifest:full-path="Thumbnails/thumbnail.svg"/>
     <manifest:file-entry manifest:media-type="image/png" manifest:full-path="Thumbnails/thumbnail.png"/>
     
     <manifest:file-entry manifest:media-type="image/svg+xml" manifest:full-path="diagram/workflow/HelloWorld.svg"/>
     <manifest:file-entry manifest:media-type="image/png" manifest:full-path="diagram/workflow/HelloWorld.png"/>
    </manifest:manifest>

##META-INF/container.xml

This file, if present, should point to the root workflow bundle document, 
   which in an `application/vnd.taverna.scufl2.workflow-bundle` must be  `workflowBundle.rdf`. 
Alternative representation of the same file are permitted, 
   but SCUFL2 compliant tools are only required to understand the  `application/rdf+xml` representations described here.

The Adobe UCF specification defines the 
   [format of this container file](http://livedocs.adobe.com/navigator/9/Navigator_SDK9_HTMLHelp/wwhelp/wwhimpl/common/html/wwhelp.htm?context=Navigator_SDK9_HTMLHelp&amp;file=Appx_Packaging.6.31.html).

![](//img/warning.png) *XML namespace in container.xml*

>     Adobe UCF have used the XML namespace `urn:oasis:names:tc:opendocument:xmlns:container` although this format
> is not defined by OASIS or the Open Document specification. 
>     
>     SCUFL2 compliant tools should therefore parse `container.xml` ignoring any default namespaces, and write using the default name
> space and `<container
> xmlns="urn:oasis:names:tc:opendocument:xmlns:container"`  as the root
> element.

If the archive is of the mime type `application/vnd.taverna.scufl2.workflow-bundle` 
   and contains other representations of the workflow bundle (for instance: JSON, 
Turtle, t2flow) then the bundle **must** have a container file and list these representations in addition to 
   `workflowBundle.rdf`. 
Derived representations such as SVG diagrams and HTML reports should generally **not** be listed as 'root files' 
   unless they can be considered to 'fully represent the workflow bundle', for instance by using RDFa.

A SCUFL2 compliant parser can assume that an archive which is *not* of the mime type 
   `application/vnd.taverna.scufl2.workflow-bundle`,
    but does contain a `META-INF/container.xml`-listed root file named `workflowBundle.rdf`, 
    that file **can** be read as an RDF/XML representation of a workflow bundle document, 
    even if it is not declared as having the `application/rdf+xml` mime type. 
This enables any future extensions superseeding this `application/vnd.taverna.scufl2.workflow-bundle` format.

All rootfiles must be equivalent and describe the same workflow structure, 
   although additional formats can include more or less information than the required format. 
There should be only one rootfile per media-type, and there must be a rootfile for the media type `application/rdf+xml`.

Example:

    <?xml version="1.0"?>
    <container version="1.0"
        xmlns="urn:oasis:names:tc:opendocument:xmlns:container">
        <rootfiles>
            <rootfile full-path="workflowBundle.ttl"
             media-type="text/turtle" /> 
            <rootfile full-path="workflowBundle.rdf"
             media-type="application/rdf+xml" /> 
        </rootfiles>
        <relationships>
            <relationship type="metadata" target="/annotation/$dir/$filename.$ext" />
        </relationships>
    </container>

##Unknown files and file types

Any other files in `workflow` and `profile` **should** be ignored by SCUFL2 compliant parsers, 
   regardless of if they have the `application/rdf+xml` mime type or not. 
When a SCUFL2 compliant tool has *modified* an existing Workflow Bundle, 
   it **should** remove such unknown files from `workflow` and `profile` when saving, 
   unless it has the capabilities to also update these. 
These files would typically be representations in other formats which would be out of date after the editing. 
On the other hand, if the tool has not structurally modified a workflow or profile, 
   the tool **should not** remove unknown files from `workflow` and `profile`.

On removal of files, the tool should also remove them from `META-INF/manifest.xml` and if necessary from 
   `META-INF/container.xml`.


##Additional resources

The workflow bundle format is an open-ended specification, so the archive can include additional resources not described here.

For instance the bundle can include:

 - Thumbnail of bundle (mini-diagram) (Recommendation: `META-INF/Thumbnails/thumbnail.png` and `Thumbnails/thumbnail.svg`)
 - Ontologies referenced from RDF/XML files, in particular from configurations 
      (Recommendation: `ontology/taverna2.2/beanshell.rdf`)
 - Diagrams of workflows (Recommendation: `diagram/workflow/HelloWorld.svg` and `.png`)
 - Alternative representations (RDF, JSON)  (Recommendation: Same naming conventions with different extensions)
 - Annotations (Recommendation: under `annotations/` in RDF/XML format) - 
     one file per annotation source, like `myExperiment.rdf)
 - Resources/binaries/data needed by workflow (Recommendation: under `resources/`
 - Example input and output data (Recommendation: as in data bundle)
 - Provenance and data of one or more workflow runs (Recommendation: under `run/`

A workflow bundle can also play 'double roles' by being other bundles, like a data bundle. 
It is the `mimetype` and *root file* that determines what is the "main function" of the bundle, 
   suggesting which tool should primarily open the bundle.
One can for instance imagine an UCF archive which primarily is an Adobe PDFXML file for a published paper 
   (see: [Mars project](http://labs.adobe.com/technologies/mars/)) and should be opened in Adobe Acrobat Reader. 
However, it can also contain `workflowBundle.rdf`, `workflow/importantResearch.rdf`, 
   and could therefore also be opened using SCUFL2 tools. 

# Scufl2-DataLink

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



# SCUFL2 API

Currently the most up to date information can be found in the github 
   [readme](https://github.com/apache/incubator-taverna-language)

###Previous Versions
For information on previous None Apache versions see the 
   [Mygrid pages](http://dev.mygrid.org.uk/wiki/display/developer/SCUFL2+API)
   
# SCUFL2 language

The SCUFL2 language is the abstract set of constructs that define a Taverna workflow.

This has been formalized in an [OWL ontology](/documentation/scufl2/ontology),
  which is used by the `scufl2-rdfxml` module of the [SCUFL2 API](/documentation/scufl2/api) 
  to serialise the [Taverna workflow bundle](/documentation/scufl2/taverna_bundle).

At the core of this is a [workflow bundle](/documentation/scufl2/bundle), 
  which combines a set of [workflows](/documentation/scufl2/workflow) and 
  [profiles](/documentation/scufl2/profile).

You can browse a serialisation of using the SCUFL2 ontology within a Taverna workflow bundle in this 
   example (Links to follow):

# Scufl2 URIs

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
    
# Scufl2 Ontology 

Details of the  Scufl2 Ontology will be available here later.


