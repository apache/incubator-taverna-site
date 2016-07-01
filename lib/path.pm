package path;

# taken from django's url.py

our @patterns = (
    #Using different templates
	[qr!/websiteMigration/test\.md(?:text)?$!, single_narrative => { template => "wide.html" }],
    [qr!/documentation/scufl2/.*\.md(?:text)?$!, single_narrative => { template => "scufl2_narrative.html" }],
    [qr!/download/language/.*\.md(?:text)?$!, single_narrative => { template => "scufl2_narrative.html" }],
	[qr!/introduction/.*\.md(?:text)?$!, single_narrative => { template => "single_with_taverna2_warning.html" }],
    [qr!/documentation/.*\.md(?:text)?$!, single_narrative => { template => "single_with_taverna2_warning.html" }],
    [qr!/community/news.md(?:text)?$!, single_narrative => { template => "twitter_narrative.html" }],
    
	[qr!\.md(?:text)?$!, single_narrative => { template => "single_narrative.html" }],
 
	[qr!/sitemap\.html$!, sitemap => { headers => { title => "Sitemap" }} ],

) ;

# for specifying interdependencies between files

our %dependencies = (
    "/sitemap.html" => [ grep s!^content!!, glob("content/*.mdtext"), glob "content/*.md" ],
);

1;

=head1 LICENSE

           Licensed to the Apache Software Foundation (ASF) under one
           or more contributor license agreements.  See the NOTICE file
           distributed with this work for additional information
           regarding copyright ownership.  The ASF licenses this file
           to you under the Apache License, Version 2.0 (the
           "License"); you may not use this file except in compliance
           with the License.  You may obtain a copy of the License at

             http://www.apache.org/licenses/LICENSE-2.0

           Unless required by applicable law or agreed to in writing,
           software distributed under the License is distributed on an
           "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
           KIND, either express or implied.  See the License for the
           specific language governing permissions and limitations
           under the License.


