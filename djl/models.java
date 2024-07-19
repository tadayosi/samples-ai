///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.29.0@pom
//DEPS ai.djl:api
//DEPS ai.djl:model-zoo
//DEPS ai.djl.pytorch:pytorch-model-zoo
//DEPS ai.djl.tensorflow:tensorflow-model-zoo
//DEPS ai.djl.mxnet:mxnet-model-zoo
//DEPS org.slf4j:slf4j-simple:2.0.13

import static java.lang.System.out;

import java.util.Arrays;
import java.util.function.Function;

import ai.djl.Application;
import ai.djl.repository.Artifact;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.util.JsonUtils;

public class models {

    public static void main(String... args) throws Exception {
        var application = Arrays.stream(args).findFirst().map(Application::of);
        var models = ModelZoo.listModels();
        models.forEach((app, artifacts) -> {
            if (application.isPresent() && !application.get().equals(app)) return;

            out.println(app);
            Function<Artifact, String> artifactId = a -> "%s:%s:%s".formatted(
                    a.getMetadata().getGroupId(),
                    a.getMetadata().getArtifactId(),
                    a.getVersion());
            Function<Artifact, String> props = a -> JsonUtils.GSON.toJson(a.getProperties());
            Function<Artifact, String> toRow = a -> "| | `%s` | %s".formatted(artifactId.apply(a), props.apply(a));
            artifacts.forEach(a -> out.println(toRow.apply(a)));
        });
    }
}
