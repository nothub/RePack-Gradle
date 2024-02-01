package lol.hub.repack;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;

public class PluginExtension {

    private Property<String> path;

    public PluginExtension(Project project) {
        this.path = project.getObjects().property(String.class);
    }

    public Property<String> getPath() {
        return path;
    }

    public void setPath(Property<String> path) {
        this.path = path;
    }
}
