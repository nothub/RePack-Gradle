package lol.hub.repack;

import org.crayne.rerepack.util.minecraft.VanillaItems;
import org.crayne.rerepack.workspace.Workspace;
import org.crayne.rerepack.workspace.WorkspaceBuilder;
import org.crayne.rerepack.workspace.compile.optifine.OptifineCompileTarget;
import org.crayne.rerepack.workspace.parse.RePackParserSpecification;
import org.gradle.api.Project;

import java.util.Optional;

public class Plugin implements org.gradle.api.Plugin<Project> {

    @Override
    public void apply(Project project) {
        Extension extension = project.getExtensions()
                .create("repack", Extension.class, project);

        project.task("repack").doLast(task -> {

            if (!extension.getInput().get().toFile().exists()) {
                throw new IllegalStateException("Input dir is missing: " + extension.getInput().get().toAbsolutePath());
            }
            extension.getOutput().get().toFile().mkdirs();

            VanillaItems.loadVanillaItems();

            final Optional<Workspace> workspace = WorkspaceBuilder.of(
                    RePackParserSpecification.INSTANCE.parser(),
                    extension.getInput().get().toFile());

            if (workspace.isEmpty()) throw new IllegalStateException("Workspace is empty!");

            final OptifineCompileTarget compileTarget = new OptifineCompileTarget(
                    extension.getOutput().get().toFile());
            compileTarget.compile(workspace.get());
        });
    }

}
