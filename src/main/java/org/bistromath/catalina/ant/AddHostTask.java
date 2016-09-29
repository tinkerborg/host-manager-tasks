package org.bistromath.catalina.ant;

import org.apache.tools.ant.BuildException;
import org.bistromath.util.QueryString;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AddHostTask extends AbstractCatalinaHostCommandTask {

    protected String aliases;
    protected String appBase;
    protected boolean autoDeploy = true;
    protected boolean deployOnStartup = true;
    protected boolean deployXML = true;
    protected boolean unpackWARs = true;
    protected boolean xmlNamespaceAware = false;
    protected boolean xmlValidation = false;
    protected boolean manager = true;


    @Override
    public void execute() throws BuildException {
        super.execute();
        execute(this.createQueryString("/add").toString());
    }

    protected StringBuilder createQueryString(String command) throws BuildException {
        StringBuilder buffer = super.createQueryString(command);

        StringBuilder builder = new QueryString(buffer)
                .put("aliases", aliases)
                .put("appBase", appBase)
                .put("autoDeploy", autoDeploy)
                .put("deployOnStartup", deployOnStartup)
                .put("deployXML", deployXML)
                .put("unpackWARs", unpackWARs)
                .put("xmlNamespaceAware", xmlNamespaceAware)
                .put("xmlValidation", xmlValidation)
                .put("manager", manager)
                .getStringBuilder();

        return builder;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public void setAppBase(String appBase) {
        this.appBase = appBase;
    }

    public void setAutoDeploy(boolean autoDeploy) {
        this.autoDeploy = autoDeploy;
    }

    public void setDeployOnStartup(boolean deployOnStartup) {
        this.deployOnStartup = deployOnStartup;
    }

    public void setDeployXML(boolean deployXML) {
        this.deployXML = deployXML;
    }

    public void setUnpackWARs(boolean unpackWARs) {
        this.unpackWARs = unpackWARs;
    }

    public void setXmlNamespaceAware(boolean xmlNamespaceAware) {
        this.xmlNamespaceAware = xmlNamespaceAware;
    }

    public void setXmlValidation(boolean xmlValidation) {
        this.xmlValidation = xmlValidation;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

}
