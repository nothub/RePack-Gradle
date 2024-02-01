package lol.hub.repack;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.OutputDirectory;

import java.nio.file.Path;

public class Extension {

    private Property<Path> input;
    private Property<Path> output;

    public Extension(Project project) {
        this.input = project.getObjects().property(Path.class);
        this.input.convention(project.getLayout().getProjectDirectory()
                .dir("repack")
                .getAsFile().toPath());
        this.output = project.getObjects().property(Path.class);
        this.output.convention(project.getLayout().getBuildDirectory()
                .dir("repack").get()
                .getAsFile().toPath());
    }

    @InputDirectory
    public Property<Path> getInput() {
        return input;
    }

    public void setInput(Property<Path> input) {
        this.input = input;
    }

    @OutputDirectory
    public Property<Path> getOutput() {
        return output;
    }

    public void setOutput(Property<Path> output) {
        this.output = output;
    }

}
