Title:     Chemistry Web Services
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

This document describes a set of chemistry services provided by [ChemSpider][1], [ChEBI][2] and [PubChem][3]
  that can be used for the construction of chemistry workflows from the Taverna Workbench.

Example workflows contained in the document show how some of the operations from the services in the set can
  be invoked.
They can also be downloaded as part of the [Chemistry Workflows pack][4] at myExperiment.

**Contents**


[TOC]

-----
<a name="chemspider"></a>
## ChemSpider

[ChemSpider][5] is a chemistry search engine that has been built with the intention of aggregating and indexing
   chemical structures and  their associated information into a single searchable repository and making it
   freely available to everybody.

ChemSpider provides several Web services, and these are listed below together with their WSDL locations.

### InChi Web service
WSDL: [http://www.chemspider.com/InChI.asmx?WSDL][6]

<img src="/img/biocatalogue-smallcog.png" alt="BioCatalogue icon" width="16" height="16" />
In BioCatalogue: [http://www.biocatalogue.org/services/2164][7]

The InChI Web service provides operations to manipulate InChI Strings and InChIKeys,
   including the conversion to and from the  MOL file format, validity checking of InChI identifiers,
   and searching  ChemSpider using InChI inputs.

Some of the Web service&#8217;s operations listed below require a &#8220;security  token&#8221;.
A security token can be obtained by completing the registration process for ChemSpider at
[http://www.chemspider.com/Register.aspx][8].

The following operations are contained within the InChI Web service:

 - **CSIDToMol**   
   Converts a ChemSpider identifier to a MOL file. A security token is required to get access to this
   service.   
   [Example workflow][9]

 - **GenerateInChI**   
   Generates an InChI string for a given chemical represented by its SMILES  string, SDF  or MOL file.   
   [Example workflow][10]

 - **GenerateInChIInfo**   
   Returns information relating to the InChI string for a given chemical compound.   
   [Example workflow][11]

 - **GenerateInChIKey**   
   Returns a hashed InChI key which is a fixed length (25 character) condensed digital representation of
      the input InChI string that is not  human-understandable.   
   [Example workflow][12]

 - **InChIKeyToCSID**   
   Converts an InChI key to a ChemSpider identifier.   
   [Example workflow][13]

 - **InChIKeyToInChI**   
   Converts an InChI key to an InChI string.   
   [Example workflow][14]

 - **InChIKeyToMol**   
   Converts an InChI key to a MOL file.   
   [Example workflow][15]

 - **InChIToCSID**   
   Convets an InChI string to a ChemSpider identifier.   
   [Example workflow][16]

 - **InChIToInChIKey**   
   Converts an InChI string to an InChI key. This only works for 1.02b InChI strings.   
   [Example workflow][17]

 - **InChIToMol**   
   Converts an InChI string to a MOL file. Uses [OpenBabel][18] internally to perform this operation.   
   [Example workflow][19]

 - **InChIToSMILES**   
   Converts an InChI string to a SMILES string. Uses [OpenBabel][20]</a> internally to perform this operation.   
   [Example workflow][21]

 - **IsValidInChIKey**   
   Checks that an InChI key is valid. Works only for v1.02b  InChI keys.   
   [Example workflow][22]

 - **MolToInChI**   
   Converts a MOL file into an InChI string (v1.02s).   
   [Example workflow][23]

 - **MolToInChIKey**   
   Converts a MOL file into an v1.02s InChI key.   
   [Example workflow][24]

 - **ResolveInChIKey**   
   This operation does not work at the moment. ChemSpider have been notified of the problem.

 - **SMILESToInChI**   
   Converts a SMILES string to an InChI string. The result is returned as a  v1.02s InChI string.   
   [Example workflow][25]

### OpenBabel Web service
WSDL: [http://www.chemspider.com/OpenBabel.asmx?WSDL][26]

 - **convert**   
   Converts a molecule represented in one format to another.
   For a list of valid format values, please visit [openbabel][27].
   An empty string is returned in case of failure.   
   [Example workflow][28]

### Mass spec API Web service

WSDL: [http://www.chemspider.com/MassSpecAPI.asmx?WSDL][29]   
<img src="/img/biocatalogue-smallcog.png" alt="BioCatalogue icon" width="16" height="16" />
In BioCatalogue: [http://www.biocatalogue.org/services/2040][30]


 - **GetCompressedRecordsSdf**   
   Returns a SDF file containing records of compounds found by an asynchronous search operation.
   A security token associated with &#8216;Service Subscriber&#8217;
   role is required to access this operation.   
   Example workflow not available since a &#8216;Service Subscriber&#8217; role is required by the user.

 - **GetDatabases**   
   Returns a list of datasources in ChemSpider.   
   [Example workflow][31]

 - **GetExtendedCompoundInfo**   
   Returns extended record details for a given ChemSpider identifier.
   A security token is required to access this service.   
   [Example workflow][32]

 - **GetExtendedCompoundInfoArray**   
   Returns an array of extended record details from an array of ChemSpider identifiers.
   A security  token is required to access this service.   
   [Example workflow][33]

 - **GetRecordMol**   
   Returns a ChemSpider record in MOL format or an empty string in case of  failure.
   The cacl3d parameter specifies whether 3D coordinates should be calculated before returning record data.
   A security token is required to access this service.    
   [Example workflow][34]

 - **GetRecordsSdf**   
   Returns a SDF file containing records found by an asynchronous search operation.  
   A security token associated with the &#8216;Service Subscriber&#8217;
      role is required to access this operation.   
   Example workflow not available since a Service Subscriber role is  required by the user.

 - **SearchByFormula**   
   Search ChemSpider compounds by molecular formula within a specified  list of datasources.
   This operation is deprecated and will be removed soon &#8211;  use SearchByFormulaAsync instead.   
   Example workflow not available since this operation is deprecated.

 - **SearchByFormula2**   
   Search ChemSpider compounds by molecular formula.   
   Example workflow not available since this operation is deprecated.

 - **SearchByFormulaAsync**   
   Searches ChemSpider compounds by molecular formula within a specified datasources list.
   Security token is required to get access to this  service.   
   [Example workflow][35]

 - **SearchByMass**   
   Searches ChemSpider compounds by mass +/- range within specified datasources list.
   This operation is deprecated and will be removed soon &#8211; use SearchByMassAsync instead.   
   Example workflow not available since this operation is deprecated.

 - **SearchByMass2**   
   Search ChemSpider compounds by mass +/- range.   
   Example workflow not available since this operation is deprecated.

 - **SearchByMassAsync**   
   Searches ChemSpider compounds by mass +/- range within a specified  datasources list.
   A security token is required to access this  service.

### Spectra Web service
WSDL: [http://www.chemspider.com/Spectra.asmx?WSDL][36]

 - **GetAllSpectraInfo**   
   Returns information for all open access spectra in ChemSpider   
   [Example workflow][37]

 - **GetCompoundSpectraInfo**   
   Returns information about spectra associated with a particular compound identified by the cmp_id parameter   
   [Example workflow][38]

 - **GetSpectrumInfo**   
   Returns information about a particular spectrum identified by its spc_id parameter   
   [Example workflow][39]

### Compound search Web service
WSDL: [http://www.chemspider.com/Search.asmx?WSDL][40]   
<img src="/img/biocatalogue-smallcog.png" alt="BioCatalogue icon" width="16" height="16" /> In BioCatalogue: </span>
<a href="http://www.biocatalogue.org/services/1932" target="_blank">http://www.biocatalogue.org/services/1932</a>

 - **AsyncSimpleSearch**   
   Searches for molecules based on the entered search terms.
   The operation returns a transaction ID which can be used to access the status of the search and results.
   A security token is required to access this service.    
   The result of this operation is a hash number which can be used to retrieve the actual results using
      the GetAsyncSearchResult operation below.   
   [Example workflow][41]

 - **CSID2ExtRefs**   
   Returns a list of external references (data sources) for a given compound.  
   A security token with the relevant role is required to access this service.

 - **GetAsyncSearchResult**   
   Returns a list of identifiers found by the asynchronous search operation.
   A security token is required to access this service.   
   [Example workflow][42]

 - **GetAsyncSearchStatus**   
   Queries the asynchronous operation status.
   A security token is required to access this service.   
   [Example workflow][43]

 - **GetCompoundInfo**   
   Returns the record details (CSID, InChIKey, InChI, SMILES) of a molecule by its ChemSpider identifier.
   A security  token is required to access this service.   
   [Example workflow][44]

 - **GetCompoundThumbnail**   
   Returns an image of a molecule&#8217;s 2D structure in PNG format.
   A security token is required to access this service.   
   [Example workflow][45]

 - **GetRecordDetails**   
   Returns a record details: CSID, InChIKey, InChI, SMILES.
   This operation is deprecated and will be removed soon &#8211; use GetCompoundInfo instead.   
   No example workflow due to deprecation of this operation.

 - **GetRecordImage**   
   Returns an image of a molecule&#8217;s structure in PNG format.
   This operation is deprecated and will  be removed soon &#8211; use GetCompoundThumbnail instead.   
   No example workflow due to deprecation of this operation.

 - **Mol2CSID**   
   Searches for structures matching a given MOL file within a given range.
   Returns a list of ChemSpider identifiers associated with matching structures.
   A security token with the &#8216;specific&#8217; role is required to access this service.   
   No example workflow due to specific role required for the operation.

 - **MolAndDS2CSID**   
   Searches for structures matching a given MOL file within the range specified by search options and
      within the specified list of datasources.  
   Returns a list of ChemSpider identifiers.
   A security token with the &#8216;specific&#8217; role is required to access this service.   
   No example workflow due to specific role required for the operation.

 - **SimpleSearch**   
   Performs a search using a given set of terms. Returns a list of ChemSpider identifiers.
   A security token is required to access this service.   
   [Example workflow][46]

 - **SimpleSearch2IdList**   
   Tries to find whatever is entered.
   Returns a list of ChemSpider IDs.
   This operation is deprecated and will be removed soon &#8211; use SimpleSearch  instead.   
   No example workflow due to deprecation of this operation.

### Synonyms
WSDL: [http://www.chemspider.com/Synonyms.asmx?WSDL][47]

 - **GetStructureSynonyms**   
   Returns synonym names for a given compound represented by its MOL file.   
   [Example workflow][48]

-----
<a name="chebi"></a>
## ChEBI

Chemical Entities of Biological Interest ([ChEBI][49]) is a freely available database of molecular entities
   focused on &#8216;small&#8217; chemical compounds.  
The term &#8216;molecular entity&#8217; refers to any constitutionally or isotopically distinct atom, molecule,
   ion, ion pair, radical, radical  ion, complex or conformer, identifiable as a separately distinguishable
   entity.
ChEBI incorporates an ontological classification, whereby the relationships between molecular entities or
   classes of entities and  their parents and/or children are specified.

ChEBI provides the following Web service with 7 operations.
WSDL: [http://www.ebi.ac.uk/webservices/chebi/2.0/webservice?wsdl][50]   
<img src="/img/biocatalogue-smallcog.png" alt="BioCatalogue icon" width="16" height="16" />
In BioCatalogue: [http://www.biocatalogue.org/services/2174][51]

 - **getLiteEntity**   
   Retrieves a list of &#8220;lite&#8221; entities containing only the ChEBI ASCII name and ChEBI identifier.
   The input parameters are a search string and a  search category.
   If the search category is null then it will search under all fields.
   The search string accepts the wildcard character &#8220;*&#8221; and also unicode characters.
   A maximum 5000  entries can be retrieved at a time.   
   [Example workflow][52]

 - **getCompleteEntity**   
   Retrieves the complete record of a molecule including synonyms, database links and  chemical structures,
      using the ChEBI identifier.   
   [Example workflow][53]

 - **getCompleteEntityByList**   
   Given a list of ChEBI accession numbers,
      retrieves the complete entity record associated with each accession number.  
   The maximum size of a given list is 50.   
   [Example workflow][54]

 - **getOntologyParents**   
   Retrieves the ontology parents of an entity including the relationship type, using a ChEBI identifier.   
   [Example workflow][55]

 - **getOntologyChildren**   
   Retrieves the ontology children of an entity including the relationship type, using a ChEBI identifier.   
   [Example workflow][56]

 - **getAllOntologyChildrenInPath**   
   Retrieves the ontology children of an entity including the relationship type, using a ChEBI identifier.   
   No example workflow available.

 - **getStructureSearch**   
   Does a substructure, similarity or identity search using a query structure.   
   [Example workflow][57]

-----
<a name="pubchem"></a>
## PubChem

[PubChem][58] is a free database of chemical structures of small organic molecules and information on
   their biological activities provided by the National Center for Biotechnology Information ([NCBI][59]),
   part of the United States National Institutes of Health ([NIH][60]).

PubChem provides the following Web service with 28 operations.
WSDL: [http://pubchem.ncbi.nlm.nih.gov/pug_soap/pug_soap.cgi?wsdl][61]

<img src="/img/biocatalogue-smallcog.png" alt="BioCatalogue icon" width="16" height="16" />
In BioCatalogue: [http://www.biocatalogue.org/services/2176][62]

 - **AssayDownload**   
   Given an assay key, prepares a file for download which contains an assay data table in the selected format.
   See the assay query section of the PUG service documentation
     ([http://pubchem.ncbi.nlm.nih.gov/pug/pughelp.html][63]) for more details on the supported formats.
   Compression is optional and  defaults to gzip (.gz). Returns a download key. Asynchronous.

 - **Download**   
   Given a list key, prepares a file for downloading which contains those records in the selected format.
   See the web download service documentation
      ([http://pubchem.ncbi.nlm.nih.gov/pc_fetch/pc_fetch-help.html][64])
      for more detail on the supported formats and file types.
   Returns a download key. Asynchronous.   
   [Example workflow][65]

 - **GetAssayColumnDescription**   
   Returns the description of a column (readout) in a BioAssay, which may be the  outcome, score,
      or a TID from the given AID. Synchronous.

 - **GetAssayColumnDescriptions**   
   Returns the description of all columns (readouts) in a BioAssay. Synchronous.

 - **GetAssayDescription**   
   Returns the descriptive information for a BioAssay, including the number of  user-specified readouts (TIDs)
      and whether a score readout is present.  
   Optionally get version information. Synchronous.

 - **GetDownloadUrl**   
   Given a download key, returns an FTP URL that may be used to download the requested file. Synchronous.

 - **GetEntrezKey**   
   Given a list key, returns an Entrez history key (db, query key, and  WebEnv) corresponding to that list.
   Synchronous.   
   [Example workflow][66]

 - **GetEntrezUrl**   
   Given an Entrez history key (db, query key, and WebEnv), returns an HTTP URL that may be used to view the
      list in Entrez. Synchronous.
   [Example workflow][67]

 - **GetIDList**   
   Given a list key, returns the identifiers as an array of integers. Synchronous.   
   [Example workflow][68]

 - **GetListItemsCount**   
   Returns the number of IDs in the set represented by a given list key. Synchronous.

 - **GetOperationStatus**   
   Given a key for any asynchronous operation, returns the status of that operation.
   Possible return values are: Success, the operation completed normally; HitLimit, TimeLimit: the operation
     finished normally, but one  of the limits was reached (e.g. before the entire database was  searched);
     ServerError, InputError, DataError, Stopped: there was a  problem with the input or on the server,
     and the job has died; Queued:  the operation is waiting its turn in the public queue; Running:
     the operation is in progress. Synchronous.   
   [Example workflow][69]

 - **GetStandardizedCID**   
   Given a structure key that has been processed by Standardize, returns the corresponding PubChem Compound
      database CID, or an empty value if the  structure is not present in PubChem. Synchronous.

 - **GetStandardizedStructure**   
   Given a structure key that has been processed by Standardize, returns the chemical structure in as SMILES
     or InChI strings. Synchronous.

 - **GetStandardizedStructureBase64**   
   Given a structure key that has been processed by Standardize, returns the  chemical structure as ASN, XML,
      or SDF, returned as a Base64-encoded  string. Synchronous.

 - **GetStatusMessage**   
   Given a key for any asynchronous operation, returns any system messages (error messages, job info, etc.)
      associated with the operation, if any. Synchronous.

 - **IdentitySearch**   
   Searches PubChem Compound for structures identical to the one given by the structure key input based on
      a user-selected level of chemical identity: connectivity only, match isotopes and/or stereo, etc.
   The search may be limited by elapsed time or number of records found, or restricted to search only within
      a previous result set (given by a list  key).
   Returns a list key. Asynchronous.   
   [Example workflow][70]

 - **InputAssay**   
   Specifies an assay table from a BioAssay AID.
   The table may be complete, concise, or include a ListKey-specified set of readouts (TIDs).
   By default, all tested substances are included, but can be restricted to a ListKey-specified set of SIDs
      or CIDs. Returns an assay key. Synchronous.

 - **InputEntrez**   
   Configures an Entrez history key (db, query key, and WebEnv).
   Returns a list key. Synchronous.

 - **InputList**   
   Configures a set of identifiers for a PubChem database, as an array of  integers.
   Returns a list key. Synchronous.

 - **InputListText**   
   Configures a set of identifiers for a PubChem database, as a simple string of integer values separated
      by commas and/or whitespace. Returns a list key. Synchronous.

 - **InputStructure**
   Configures a chemical structure as a simple (one-line) string, either SMILES or InChI.
   Returns a structure key. Synchronous.   
   [Example workflow][71]

 - **InputStructureBase64**   
   Configures a chemical structure in ASN.1 (text or binary), XML, or SDF  format.
   The structure must be encoded as a Base64 string.
   Currently only single structures are supported.
   Returns a structure key. Synchronous.   
   [Example workflow][72]

 - **MFSearch**   
   Searches PubChem Compound for structures of a given molecular formula,  
      optionally allowing elements not specified to be present.
   The search may  be limited by elapsed time or number of records found, or restricted to search only
      within a previous result set (given by a list key). Returns  a list key. Asynchronous.

 - **ScoreMatrix**   
   Computes a matrix of scores from one or two lists of IDs (if one, the IDs  will be self-scored),
     of the selected type and in the selected format.  
   Compression is optional and defaults to gzip (.gz). Returns a download key. Asynchronous.

 - **SimilaritySearch2D**   
   Searches PubChem Compound for structures similar to the one given by the structure key input,
      based on the given Tanimoto-based similarity score.  
   The search may be limited by elapsed time or number of records found,  
     or restricted to search only within a previous result set (given by a  list key).
   Returns a list key. Asynchronous.   
   [Example workflow][73]

 - **Standardize**   
   Standardizes the structure given by the structure key input,
      using the same algorithm PubChem uses to construct the Compound database.
   Returns a structure key. Asynchronous.

 - **SubstructureSearch**   
   Searches PubChem Compound for structures containing the one given by the structure key input,
      based on a user-selected level of chemical identity: connectivity only, match isotopes and/or stereo, etc.
   The search may be limited by elapsed time or number of records found,
      or restricted to search only within a previous result set (given by a list key).
   Returns a list key. Asynchronous.   
   [Example workflow][74]

 - **SuperstructureSearch**   
   Searches PubChem Compound for structures contained within the one given by the structure key input,
      based on a user-selected level of chemical identity: connectivity only, match isotopes and/or stereo, etc. The  search may be limited by elapsed time or number of records found, or  restricted to search only within a previous result set (given by a list  key). Returns a list key. Asynchronous.</li>



  [1]: #chemspider
  [2]: #chebi
  [3]: #pubchem
  [4]: http://www.myexperiment.org/packs/136
  [5]: http://www.chemspider.com/
  [6]: http://www.chemspider.com/InChI.asmx?WSDL
  [7]: http://www.biocatalogue.org/services/2164
  [8]: http://www.chemspider.com/Register.aspx
  [9]: http://www.myexperiment.org/workflows/1418
  [10]: http://www.myexperiment.org/workflows/1387
  [11]: http://www.myexperiment.org/workflows/1388
  [12]: http://www.myexperiment.org/workflows/1389
  [13]: http://www.myexperiment.org/workflows/1390
  [14]: http://www.myexperiment.org/workflows/1391
  [15]: http://www.myexperiment.org/workflows/1392
  [16]: http://www.myexperiment.org/workflows/1393
  [17]: http://www.myexperiment.org/workflows/1394
  [18]: http://openbabel.org/wiki/Main_Page
  [19]: http://www.myexperiment.org/workflows/1395
  [20]: http://openbabel.org/wiki/Main_Page
  [21]: http://www.myexperiment.org/workflows/1396
  [22]: http://www.myexperiment.org/workflows/1397
  [23]: http://www.myexperiment.org/workflows/1398
  [24]: http://www.myexperiment.org/workflows/1399
  [25]: http://www.myexperiment.org/workflows/1400
  [26]: http://www.chemspider.com/OpenBabel.asmx?WSDL
  [27]: http://openbabel.org/wiki/Category:Formats
  [28]: http://www.myexperiment.org/workflows/1401
  [29]: http://www.chemspider.com/MassSpecAPI.asmx?WSDL
  [30]: http://www.biocatalogue.org/services/2040
  [31]: http://www.myexperiment.org/workflows/1404
  [32]: http://www.myexperiment.org/workflows/1405
  [33]: http://www.myexperiment.org/workflows/1406
  [34]: http://www.myexperiment.org/workflows/1407
  [35]: http://www.myexperiment.org/workflows/1420
  [36]: http://www.chemspider.com/Spectra.asmx?WSDL
  [37]: http://www.myexperiment.org/workflows/1408
  [38]: http://www.myexperiment.org/workflows/1409
  [39]: http://www.myexperiment.org/workflows/1410
  [40]: http://www.chemspider.com/Search.asmx?WSDL
  [41]: http://www.myexperiment.org/workflows/1411
  [42]: http://www.myexperiment.org/workflows/1411
  [43]: http://www.myexperiment.org/workflows/1411
  [44]: http://www.myexperiment.org/workflows/1412
  [45]: http://www.myexperiment.org/workflows/1414
  [46]: http://www.myexperiment.org/workflows/1427
  [47]: http://www.chemspider.com/Synonyms.asmx?WSDL
  [48]: http://www.myexperiment.org/workflows/1415
  [49]: http://www.ebi.ac.uk/chebi/
  [50]: http://www.ebi.ac.uk/webservices/chebi/2.0/webservice?wsdl
  [51]: http://www.biocatalogue.org/services/2174
  [52]: http://www.myexperiment.org/workflows/1419
  [53]: http://www.myexperiment.org/workflows/1421
  [54]: http://www.myexperiment.org/workflows/1422
  [55]: http://www.myexperiment.org/workflows/1423
  [56]: http://www.myexperiment.org/workflows/1424
  [57]: http://www.myexperiment.org/workflows/1426
  [58]: http://pubchem.ncbi.nlm.nih.gov/
  [59]: http://en.wikipedia.org/wiki/National_Center_for_Biotechnology_Information
  [60]: http://en.wikipedia.org/wiki/National_Institutes_of_Health
  [61]: http://pubchem.ncbi.nlm.nih.gov/pug_soap/pug_soap.cgi?wsdl
  [62]: http://www.biocatalogue.org/services/2176
  [63]: http://pubchem.ncbi.nlm.nih.gov/pug/pughelp.html
  [64]: http://pubchem.ncbi.nlm.nih.gov/pc_fetch/pc_fetch-help.html
  [65]: http://www.myexperiment.org/workflows/1435
  [66]: http://www.myexperiment.org/workflows/1431
  [67]: http://www.myexperiment.org/workflows/1431
  [68]: http://www.myexperiment.org/workflows/1433
  [69]: http://www.myexperiment.org/workflows/1431
  [70]: http://www.myexperiment.org/workflows/1433
  [71]: http://www.myexperiment.org/workflows/1433
  [72]: http://www.myexperiment.org/workflows/1431
  [73]: http://www.myexperiment.org/workflows/1431
  [74]: http://www.myexperiment.org/workflows/1434
