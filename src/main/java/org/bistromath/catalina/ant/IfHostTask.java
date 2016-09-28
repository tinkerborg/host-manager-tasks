package org.bistromath.catalina.ant;

import org.apache.tools.ant.*;
import org.apache.tools.ant.property.LocalProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IfHostTask extends AbstractCatalinaHostListCommandTask implements TaskContainer {

    private String hostname = null;
    private boolean exists = true;

    private List<Task> tasks = new ArrayList<Task>();

    @Override
    public void execute() throws BuildException {

        super.execute();
        this.execute("/list");

        boolean contains = hosts.contains(hostname);

        if (hosts.contains(hostname) == exists) {
            performTasks(hostname);
        }

    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

}
