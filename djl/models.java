///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.28.0@pom
//DEPS ai.djl:api
//DEPS ai.djl:model-zoo
//DEPS ai.djl.pytorch:pytorch-model-zoo
//DEPS ai.djl.tensorflow:tensorflow-model-zoo
//DEPS ai.djl.mxnet:mxnet-model-zoo
//DEPS org.slf4j:slf4j-simple:1.7.36

import static java.lang.System.*;

import ai.djl.*;
import ai.djl.modality.*;
import ai.djl.modality.cv.*;
import ai.djl.repository.zoo.*;
import ai.djl.training.util.*;

public class models {

    public static void main(String... args) throws Exception {
        var models = ModelZoo.listModels();
        models.forEach((app, artifacts) -> {
            out.println(app);
            artifacts.forEach(a -> out.println("  - " + a));
        });
    }
}
