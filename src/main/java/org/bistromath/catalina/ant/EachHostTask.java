package org.bistromath.catalina.ant;

import org.apache.tools.ant.*;

public class EachHostTask extends AbstractCatalinaHostListCommandTask {

    @Override
    public void execute() throws BuildException {

        if (property == null) {
            throw new BuildException("Must specify a lexically-scoped property name with the 'property' attribute");
        }

        super.execute();
        this.execute("/list");

        for (String host : hosts) {
            log(host);

            performTasks(host);
        }
    }

}
