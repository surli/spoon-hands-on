package fr.inria.spirals.launcher;

import fr.inria.spirals.processor.EmptyProcessor;
import spoon.MavenLauncher;
import spoon.compiler.Environment;

import java.io.File;

public class ProcessorLauncher {
    public static void main(String[] args) {
        String projectPath = ".";

        MavenLauncher launcher = new MavenLauncher(projectPath, MavenLauncher.SOURCE_TYPE.APP_SOURCE);

        Environment environment = launcher.getEnvironment();
        environment.setCommentEnabled(true);
        environment.setAutoImports(true);
        environment.setSourceOutputDirectory(new File("./target/spooned"));

        launcher.addProcessor(new EmptyProcessor());
        launcher.run();
    }
}
