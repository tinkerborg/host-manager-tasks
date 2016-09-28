package org.bistromath.catalina.ant;

import org.apache.tools.ant.BuildException;

public class StartHostTask extends AbstractCatalinaHostCommandTask {

    @Override
    public void execute() throws BuildException {
        super.execute();
        execute(createQueryString("/start").toString());
    }

}
