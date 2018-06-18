package fr.inria.spirals.launcher;

import fr.inria.spirals.processor.DontReturnPrivateAPITypeProcessor;
import spoon.MavenLauncher;
import spoon.compiler.Environment;

public class ProcessorLauncher {
    public static void main(String[] args) {
        String projectPath = ".";

        MavenLauncher launcher = new MavenLauncher(projectPath, MavenLauncher.SOURCE_TYPE.APP_SOURCE);

        Environment environment = launcher.getEnvironment();
        environment.setCommentEnabled(true);
        environment.setAutoImports(true);

        launcher.addProcessor(new DontReturnPrivateAPITypeProcessor());
        launcher.run();
    }
}
