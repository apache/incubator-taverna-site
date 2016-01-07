Title:     Scufl2-WorkflowBundle
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

The entry point of the Taverna Workflow Bundle.

Defines the *workflows* and *profiles* of a 
   [Taverna Workflow Bundle](/documentation/scufl2/taverna_bundle).
The *main workflow* is also normally defined, which would be the top-level workflow to execute. 
The profiles define how these workflows can be realised and *executed* on different environments, 
   one of which can be suggested as the *main profile*.

##Bundle path and root files

The **workflow bundle document** in RDF/XML format **should** be in `/workflowBundle.rdf` within the bundle archive.

If the archive is a [workflow bundle](/documentation/scufl2/taverna_bundle), 
   i.e. `/mimetype` is `application/vnd.taverna.scufl2.workflow-bundle`, 
   then the `META-INF/container.xml` can define **root files** at alternative paths and media types. 
This specification requires that one of those formats is `application/rdf+xml`.

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

The code above defines the RDF/XML root file to be `/workflowBundle.rdf`, with `workflowBundle.ttl` being an alternate representation of the resource in Turtle format.

SCUFL2-compliant workflow bundle writers:

 - **Must** set the bundle **mimetype** to `application/vnd.taverna.scufl2.workflow-bundle`.
 - **Must** add a workflow bundle document in `application/rdf+xml` format.
 - **Should** store the workflow bundle document in `/workflowBundle.rdf`.
 - **Must not** contain a resource called `/workflowBundle.rdf` that is not the workflow bundle document.
 - **May** add additional representation of the workflow bundle document (and other documents). 
     Alternates of the workflow bundle document **should** be included in the `META-INF/container.xml`, 
     but only if they can be considered to fully specify the workflow bundle as in the RDF/XML format. 
     (So for instance, a `text/html` or `image/png` representation would not normally be considered a 
     **rootfile** if it does not include all the structural information from the RDF/XML representation 
     as specified here.)

SCUFL2-compliant workflow bundle writers have additional constraints.

- If the `application/rdf+xml` representation is not in `/workflowBundle.rdf`, 
     the writer **must** include `META-INF/container.xml` with the required `<rootfile>` entries.
- `META-INF/container.xml`, if present, **must** contain one and only one `rootfile` with the media-type 
     `application/rdf+xml`. Rootfiles of other media-types **may** be included, but their formats and restrictions are not defined by this specification.


It is possible to include a workflow bundle document within a different kind of archive or bundle, 
   for instance in a data bundle.
In this case, the bundle is not considered an `application/vnd.taverna.scufl2.workflow-bundle`.

Producers of these different kinds of archives:

 - **Should** store the workflow bundle document in `/workflowBundle.rdf`, 
      unless the workflow bundle is not to be considered to have a 'main' or 'prominent' role within the archive. 
   (For instance, if the archive is a collection of workflow bundles.)
 - **Should** have a `mimetype` and `META-INF/container.xml` resource that declares the archive's main entry point, 
     like the data bundle document. 
   The mime type **must not** be `application/vnd.taverna.scufl2.workflow-bundle`, and 
      the root files **should not** be the workflow bundle document.
 - **Should** link to the workflow bundle document from a resource within the archive, which (ultimately) 
      is linked-to from one of the `rootfile` documents. 
   Such documents **should** be in RDF/XML format.
 - **Should** declare the media type of the RDF/XML workflow bundle document as `application/rdf+xml` 
      in its `META-INF/manifest.xml`

SCUFL2-compliant workflow bundle readers:

 - **Should** assume that `/workflowBundle.rdf` - if present - 
       is the root workflow bundle in the `application/rdf+xml` format specified here.
 - **Should** assume that if the archive's `mimetype` is `application/vnd.taverna.scufl2.workflow-bundle`, 
       then the `rootfile` in `META-INF/container.xml` with the media type `application/rdf+xml` 
       is the root workflow bundle document.
 - **May** assume that any alternate formats listed as a `rootfile` in an `application/vnd.taverna.scufl2.workflow-bundle` 
       archive would fully cover the specification of the RDF/XML representation, and read such formats instead.
 - **May** assume that any `application/rdf+xml` document with a `xsi:type="WorkflowBundleDocument"` 
       can be parsed according to the Scufl2 XML schema.

##Identifiers

Workflow bundles and their resources **must** be declared with relative identifiers within the archive. 
   In an `application/vnd.taverna.scufl2.workflow-bundle` archive, 
   the workflow bundle **must** be identified as the root of the archive. 
   If the Workflow Bundle document is in `workflowBundle.rdf` within the archive, the workflow identifier is `./`. 
   This **should** be achieved by setting `xml:base="./"` and `rdf:about=""`.

One can mint a URI to refer to resources within the bundle archive, including the workflow bundle, workflows and representations. If `http://example.com/myWfBundle.scufl2` returns a [Scufl2 workflow bundle](/documentation/scufl2/taverna_bundle) archive of the content type `application/vnd.taverna.scufl2.workflow-bundle`, then (assuming default structure of the archive):

 - `http://example.com/myWfBundle.scufl2` identifies the Workflow Bundle representation (the *archive*).
 - `http://example.com/myWfBundle.scufl2/` identifies the *Workflow Bundle* (as described here).
 - `http://example.com/myWfBundle.scufl2/workflowBundle.rdf` identifies the Workflow Bundle representation in RDF/XML.
 - `http://example.com/myWfBundle.scufl2/workflow/HelloWorld/` identifies the "HelloWorld" 
      [workflow](/documentation/scufl2/workflow) within the bundle.
 - `http://example.com/myWfBundle.scufl2/workflow/HelloWorld.rdf` identifies the "HelloWorld" workflow representation in RDF/XML.
 - `http://example.com/myWfBundle.scufl2/workflow/HelloWorld/processor/Hello/` identifies the "Hello" 
      processor within the "HelloWorld" workflow.

###Embedded workflow bundles

If the archive is another type of bundle, which includes the workflow bundle 
   (but is not primarily playing the role as the format for this workflow bundle), 
   the local workflow identifier **should** be unique within the archive. 
This is most easily achieved by using the same folder technique as for the workflow representations:

 - `workflowBundle1.rdf` can define `workflowBundle1/`.
 - `exampleWorkflowBundles/hello.rdf` defines `exampleWorkflowBundles/hello/`.

Such embedded workflow bundles **should** include their constituent representations 
   (such as `workflow/HelloWorld.rdf`) within that folder. 
For instance, `exampleWorkflowBundles/hello/workflow/HelloWorld.rdf` defines 
   `exampleWorkflowBundles/hello/workflow/HelloWorld/`. But this could also be shared among bundles;
   for instance, both `workflowBundle1.rdf` and `workflowBundle2.rdf` might refer to `workflow/Shared.rdf`.

###Global workflow bundle identifiers

Workflow bundles **should** declare a **sameBaseAs** reference to a globally unique non-informational URI.

Anyone can generate such a URI using the form `http://ns.taverna.org.uk/2010/workflowBundle/UUID/`.
   One example would be: `http://ns.taverna.org.uk/2010/workflowBundle/28f7c554-4f35-401f-b34b-516e9a0ef731/` - 
   including the trailing slash.

The semantics of **sameBaseAs** is a kind of recursive version of **owl:sameAs** - 
   so resources with URI having the same beginning will be included.

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
> Refer to [SCUFL2-41](http://www.mygrid.org.uk/dev/issues/browse/SCUFL2-41)
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

The above example defines the workflow bundle "HelloWorld". 
It contains one workflow (`workflow/HelloWorld`), which is also the **main workflow**. 
(Any additional workflows are typically nested (and nested-nested, etc) workflows bound as activities in processors). 
Two execution profiles are provided, and `profile/tavernaWorkbench` is dedicated as the **main profile**.

##Properties

 - **name** (required) gives the human readable title for this workflow archive. 
     This is a subproperty of `dc:title`.
 - **sameBaseAs** (optional) gives a unique URI which is **owl:sameAs** with this workflow bundle and its children.
 - **workflow** (required) must be included for all [workflows](/documentation/scufl2/workflow) included in this bundle. 
     Each workflow must have an **rdfs:seeAlso** link to the bundle resource that defines the workflow, 
       typically `workflow/workflowName.rdf` corresponding to the non-information resource `workflow/workflowName/`.
 - **mainWorkflow** (optional) refers to the top-level [workflow](/documentation/scufl2/workflow) of this bundle. 
   Workflow bundles without a main workflow can be valid if, for instance, the bundled workflows are unconnected "workflow fragments." 
   If there is a **mainProfile**, the workflow bundle must also have a **mainWorkflow**. 
   The main workflow must always be listed under **workflow**.
 - **profile** (optional) describes the <a href="/wiki/display/developer/Scufl2-Profile">profiles</a> that specify 
      how to <strong>execute</strong> the bundled workflows. In particular, the profile provides a set of configured 
      activities bound to the processors for a particular run environment. If no profiles are specified, this is an 
      abstract workflow bundle.
 - **mainProfile** (optional) specifies the suggested <strong>main profile</strong>. Execution platforms unable to choose 
      between the provided profiles can select this profile as a default. It is valid to have a workflow bundle 
      without a main profile (even if it has other profiles), but any main profile must also be listed under 
      <strong>profile</strong>.
 - **rdfs:seeAlso** (optional) describes a link to annotations about the workflow bundle and its content. Traditionally found 
      in <code>annotation/workflowBundle.rdf</code>, which should contain further links to annotations from different 
      sources. For instance, <code>annotation/myExperiment.rdf</code> lists annotations included from myExperiment.

##Bundle links

The workflow bundle document is the starting point for finding all workflow bundle resources within the archive. 
Therefore, each of the workflows and profiles must have a **rdfs:seeAlso** link to the bundle resource that defines it.

If alternate formats other than the required RDF/XML format are included in the bundle, 
   these formats can link to resources in other formats, for instance to a `workflowBundle.ttl` 
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

SCUFL2-compliant writers, when producing the workflow bundle document:

 - **Should** write the workflow bundle RDF/XML document according to the SCUFL2 XML schema, 
      use the default namespace `xmlns="http://ns.taverna.org.uk/2010/scufl2#"` and declare the 
      `xsi:type="WorkflowBundleDocument"`.
 - **Must** ensure the workflow bundle RDF/XML document is valid [RDF/XML](http://www.w3.org/TR/REC-rdf-syntax/) 
     and includes the properties deemed required by this specification. 
   Conforming to the XML schema should ensure this.
 - **Should** set the `xml:base` property to `"./"`.
 - **Should** set **rdf:about** to `""` (or `"./"` if `xml:base` is not set).
 - **Should** declare a **mainWorkflow** and **mainProfile**.
 - **Must** ensure that any **workflow**/**profile** has a relative **rdfs:seeAlso** link to a bundle resource in 
     `application/rdf+xml`, which defines 
    that [workflow](/documentation/scufl2/workflow) / [profile](/documentation/scufl2/profile).

SCUFL2-compliant readers, when parsing a workflow bundle document:

- **May** assume that a declared workflow/profile is defined in the referenced representation. 
  For instance, in the code example below, `workflow/SomeNestedWorkflow.rdf` **must** contain a 
  [workflow definition](/documentation/scufl2/workflow) for `workflow/SomeNestedWorkflow/`.   

        <workflow>
           <Workflow rdf:about="workflow/SomeNestedWorkflow/">
              <rdfs:seeAlso rdf:resource="workflow/SomeNestedWorkflow.rdf" />
           </Workflow>   
        </workflow>

- **May** parse the `/workflowBundle.rdf` as RDF/XML.
- **May** parse the `/workflowBundle.rdf` according to the XML schema if the `xsi:type="WorkflowBundleDocument"` 
   is set on the `rdf:RDF` element.
