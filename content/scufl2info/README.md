scufl2info
==========

Provides reasonable guesses to scufl2 Linked Data

This service used to run at http://guess.taverna.org.uk/ before moving to Apache infrastructure.
Apache does not have a way to host servlets (as scufl2-info is implemented as), so temporarily
this uses a slow cgi-bin hack.

TODO: Rewrite as a python CGI-script?


/scufl2info/ is redirected to from auto-generated URLs like http://ns.taverna.org.uk/2011/run/385c794c-ba11-4007-a5b5-502ba8d14263/ - see:
  
  * [/ns/2011/run/](../ns/2011/run/)
  * [/ns/2011/data/](../ns/2011/run/)
  * [/ns/2010/workflowBundle/](../ns/2010/workflowBundle/)


`.htaccess` redirects to [/cgi-bin/scufl2info.cgi](../../cgi-bin/scufl2info.cgi)
which executes the jar of [scufl2-info](../../scripts/scufl2-info/) - see the
[scufl2-info README](../../scripts/scufl2-info/README.d) for details.


Note that as the cgi-bin script has a very slow startup (~ 4 seconds/request), 
`/scufl2info/` and `/cgi-bin/` are is excluded in [robots.txt](../robots.txt).

