#   Licensed to the Apache Software Foundation (ASF) under one or more
#   contributor license agreements.  See the NOTICE file distributed with
#   this work for additional information regarding copyright ownership.
#   The ASF licenses this file to You under the Apache License, Version 2.0
#   (the "License"); you may not use this file except in compliance with
#   the License.  You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#
FROM tomcat:7-jre7
MAINTAINER "Stian Soiland-Reyes <orcid.org/0000-0001-9842-9718>"

RUN rm -rf /usr/local/tomcat/webapps/*

# Borrowed from https://registry.hub.docker.com/u/pandeiro/lein/dockerfile/
ENV LEIN_ROOT true
RUN wget -q -O /usr/bin/lein \
    https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein \
        && chmod +x /usr/bin/lein

WORKDIR /tmp

COPY project.clj /tmp/
COPY src /tmp/src/
COPY resources /tmp/resources/

RUN lein deps && lein ring uberwar && cp target/*war /usr/local/tomcat/webapps/ROOT.war && rm -rf /tmp/* /root/.lein /root/.m2
EXPOSE 8009
