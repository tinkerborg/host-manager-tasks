# host-manager-tasks

## Overview

Ant tasks to work with Tomcat's [HostManagerServlet](https://tomcat.apache.org/tomcat-7.0-doc/api/org/apache/catalina/manager/host/HostManagerServlet.html) API. 

### Installation

Copy host-manager-tasks JAR to ~/.ant/lib and use:

    <taskdef uri="antlib:org.bistromath.catalina.ant" resource="org/bistromath/catalina/ant/host-manager.tasks" />
    
or another location:

    <taskdef uri="antlib:org.bistromath.catalina.ant" resource="org/bistromath/catalina/ant/host-manager.tasks">
        <classpath>
            <pathelement location="path/to/host-manager-tasks.jar">
        </classpath>
    </taskdef>

with Ivy:

    <ivy:resolve organisation="org.bistromath" module="host-manager-tasks" revision="latest.integration" conf="master" type="jar" inline="true" log="download-only" resolveid="ivy.resolve.host-manager" />
    <ivy:cachepath inline="true" resolveid="ivy.resolve.host-manager" organisation="org.bistromath" module="host-manager-tasks" revision="latest.integration" conf="master" pathid="ivy.cache.host-manager.path" />
    <taskdef uri="antlib:org.bistromath.catalina.ant" resource="org/bistromath/catalina/ant/host-manager.tasks" classpathref="ivy.cache.host-manager.path" />      

Add tomcat namespace to project:

    <project xmlns:tomcat="org.bistromath.catalina.ant">
    
### Tasks

Add a virtual host:
    
    <tomcat:add-host hostname="www.example.org" url="http://localhost:8080/host-manager" username="admin" password="password" />
    
Remove a virtual host:
    
    <tomcat:remove-host hostname="www.example.org" url="http://localhost:8080/host-manager" username="admin" password="password" />
    
Start a virtual host:
    
    <tomcat:start-host hostname="www.example.org" url="http://localhost:8080/host-manager" username="admin" password="password" />

Stop a virtual host:
    
    <tomcat:stop-host hostname="www.example.org" url="http://localhost:8080/host-manager" username="admin" password="password" />
    
List virtual hosts:
    
    <tomcat:list-hosts url="http://localhost:8080/host-manager" username="admin" password="password" />
    
Loop through virtual hosts:

    <tomcat:each-host url="http://localhost:8080/host-manager" username="admin" password="password" property="host.name" />
        <echo>Virtual host: ${host.name}</echo>
    </tomcat:each-host>

Perform actions conditionally if a virtual host exists:

    <tomcat:if-host hostname="www.example.org" url="http://localhost:8080/host-manager" username="admin" password="password" property="host.name" />
        <echo>${host.name} exists!</echo>
    </tomcat:if-host>
    
Perform actions conditionally if a virtual host does not exists:

    <tomcat:if-host hostname="www.example.org" exists="false" url="http://localhost:8080/host-manager" username="admin" password="password" property="host.name" />
        <echo>${host.name} does not exist!</echo>
    </tomcat:if-host>


