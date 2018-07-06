package fr.inria.spirals.launcher;

import fr.inria.spirals.processor.EmptyProcessor;
import spoon.MavenLauncher;
import spoon.compiler.Environment;

import java.io.File;

/**
 * This class is only used as an example how to launch Spoon using the API
 */
public class ProcessorLauncher {
    public static void main(String[] args) {
        // if you imported the project in intelliJ "." point out to the directory of the parent pom.
        String projectPath = ".";

        // we create a launch for the whole maven project: we will process both modules
        // but we only process the application files, not the test files (here we don't have any test)
        MavenLauncher launcher = new MavenLauncher(projectPath, MavenLauncher.SOURCE_TYPE.APP_SOURCE);

        // specify some options before running it
        Environment environment = launcher.getEnvironment();

        // we want to output the comment after processing
        environment.setCommentEnabled(true);

        // we want to use java imports
        environment.setAutoImports(true);

        // here the produced files will be output in target/spooned
        environment.setSourceOutputDirectory(new File("./target/spooned"));

        // and we want to use a processor
        launcher.addProcessor(new EmptyProcessor());

        // let's run it!
        launcher.run();
    }
}
