///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.28.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.timeseries:timeseries
//DEPS ai.djl:model-zoo
//DEPS ai.djl.pytorch:pytorch-model-zoo
//DEPS ai.djl.tensorflow:tensorflow-model-zoo
//DEPS ai.djl.mxnet:mxnet-model-zoo
//DEPS org.slf4j:slf4j-simple:1.7.36

import static java.lang.System.*;
import java.util.*;

import ai.djl.*;
import ai.djl.modality.*;
import ai.djl.modality.cv.*;
import ai.djl.repository.zoo.*;
import ai.djl.training.util.*;
import ai.djl.translate.*;
import ai.djl.util.*;

/**
 * Input/output types for each model.
 */
public class models_inout {

    public static void main(String... args) throws Exception {
        var application = Arrays.stream(args).findFirst().map(Application::of);
        var models = ModelZoo.listModels();
        models.forEach((app, artifacts) -> {
            if (application.isPresent() && !application.get().equals(app)) return;

            artifacts.forEach(a -> {
                out.println("%s :: %s".formatted(app, a));
                var arguments = a.getArguments();
                out.println("  - Args: %s".formatted(arguments));
                var factoryName = ArgumentsUtil.stringValue(arguments, "translatorFactory");
                if (factoryName == null) {
                    out.println();
                    return;
                }
                out.println("  - Factory: %s".formatted(factoryName));

                var cl = ClassLoaderUtils.getContextClassLoader();
                var factory = ClassLoaderUtils.initClass(cl, TranslatorFactory.class, factoryName);
                var inouts = factory.getSupportedTypes();
                inouts.forEach(io -> {
                    out.println("  - In/Out: %s => %s".formatted(io.getKey().getTypeName(), io.getValue().getTypeName()));
                });
                out.println();
            });
        });
    }
}
