package org.bistromath.catalina.ant;

import org.apache.tools.ant.BuildException;

public class StopHostTask extends AbstractCatalinaHostCommandTask {

    @Override
    public void execute() throws BuildException {
        super.execute();
        execute(createQueryString("/stop").toString());
    }

}
