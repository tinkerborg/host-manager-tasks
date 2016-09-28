package org.bistromath.catalina.ant;

import org.apache.tools.ant.BuildException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AddHostTask extends AbstractCatalinaHostCommandTask {

    protected String aliases = null;
    protected boolean manager = false;

    @Override
    public void execute() throws BuildException {
        super.execute();
        execute(this.createQueryString("/add").toString());
    }

    protected StringBuilder createQueryString(String command) throws BuildException {
        StringBuilder buffer = super.createQueryString(command);

        if (manager) {
            buffer.append("&manager=true");
        }

        try {
            if (aliases != null) {
                buffer.append("&aliases=");
                buffer.append(URLEncoder.encode(this.aliases, this.getCharset()));
            }
        } catch (UnsupportedEncodingException e) {
            throw new BuildException("Invalid \'charset\' attribute: " + this.getCharset());
        }
        return buffer;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

}
