286-compliant-portlet-samples
=============================

## Purpose
To provide a set of portlet samples running on any Java Portal framework, such as GateIn or Liferay.

## Testing environment
These samples are deployed and tested successfully in GateIn 3.5.0.Final. You could click [here](http://www.redhat.com/j/elqNow/elqRedir.htm?ref=http://downloads.jboss.org/gatein/Releases/Portal/3.5.0.Final/GateIn-3.5.0.Final-tomcat7.zip) to download GateIn portal Tomcat packaging.


## Installation
In general, you just need to deploy the [portlet-samples.war](http://trongtt.github.io/286-compliant-portlet-samples/download/portlet-samples.war) to your PORTAL application server.

### eXo Add-on
With eXo Platform portal, you can easily install this portlet samples as an eXo add-on by following command:
./addon install portlet-samples --catalog=http://trongtt.github.io/286-compliant-portlet-samples/download/exo-addon-catalog.json


TODO:
* Cookies example
* Portlet Session example
* ETag example
