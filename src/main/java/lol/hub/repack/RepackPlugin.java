package lol.hub.repack;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class RepackPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        PluginExtension extension = project.getExtensions().create("repack", PluginExtension.class, project);

        project.task("repack").doLast(task -> System.out.println("TEST: " + extension.getPath().get()));
    }

}
