package org.bistromath.catalina.ant;

import org.apache.catalina.ant.AbstractCatalinaTask;
import org.apache.tools.ant.*;
import org.apache.tools.ant.property.LocalProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractCatalinaHostListCommandTask extends AbstractCatalinaTask implements TaskContainer {

    protected List<Task> tasks = new ArrayList<Task>();
    protected List<String> hosts = new ArrayList<String>();
    protected String property = null;

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    protected void handleOutput(String output, int priority) {
        if (priority == 0) {
            super.handleOutput(output, priority);
        } else {
            if (!output.startsWith("OK - ")) {
                if (output != null && output.charAt(output.length()-1) == ':') {
                    hosts.add(output.substring(0, output.length()-1));
                }
            }
        }
    }

    protected Task getTask(Task task, String host) throws BuildException {
        if (!(task instanceof UnknownElement)) {
            throw new BuildException("Can't create task: expected UnknownElement but got " + task.getClass().getName());
        }

        PropertyHelper propertyHelper = PropertyHelper.getPropertyHelper(getProject());
        LocalProperties props = LocalProperties.get(getProject());
        props.enterScope();

        if (property != null) {
            props.addLocal(property);
            props.set(property, host, propertyHelper);
        }

        UnknownElement taskCopy = ((UnknownElement) task).copy(getProject());
        taskCopy.maybeConfigure();

        props.exitScope();

        return taskCopy.getTask();
    }

    protected void performTasks(String hostname) {
        for (Iterator<Task> it = tasks.iterator(); it.hasNext();) {
            Task task = getTask(it.next(), hostname);
            task.perform();
        }
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
