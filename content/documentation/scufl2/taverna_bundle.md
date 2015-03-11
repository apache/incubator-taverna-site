Title:     Taverna Workflow Bundle
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

The primary [SCUFL2](/documentation/scufl2) file format is the Taverna *workflow bundle*.

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
