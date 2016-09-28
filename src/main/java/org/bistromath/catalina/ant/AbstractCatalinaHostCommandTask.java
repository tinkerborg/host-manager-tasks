package org.bistromath.catalina.ant;

import org.apache.catalina.ant.AbstractCatalinaTask;
import org.apache.tools.ant.BuildException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class AbstractCatalinaHostCommandTask extends AbstractCatalinaTask {

    protected String hostname = null;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    protected StringBuilder createQueryString(String command) throws BuildException {
        StringBuilder buffer = new StringBuilder();

        try {
            buffer.append(command);
            if(this.hostname == null) {
                throw new BuildException("Must specify \'hostname\' attribute");
            } else {
                buffer.append("?name=");
                buffer.append(URLEncoder.encode(this.hostname, this.getCharset()));
            }
        } catch (UnsupportedEncodingException var4) {
            throw new BuildException("Invalid \'charset\' attribute: " + this.getCharset());
        }

        return buffer;
    }

}
