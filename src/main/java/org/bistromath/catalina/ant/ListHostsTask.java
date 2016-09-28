package org.bistromath.catalina.ant;

import org.apache.catalina.ant.AbstractCatalinaTask;
import org.apache.tools.ant.BuildException;

public class ListHostsTask extends AbstractCatalinaTask {

    @Override
    public void execute() throws BuildException {
        super.execute();
        this.execute("/list");
    }

}
