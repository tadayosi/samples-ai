///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.29.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.pytorch:pytorch-engine
//DEPS ai.djl.mxnet:mxnet-model-zoo
//DEPS org.slf4j:slf4j-simple:2.0.13

import static java.lang.System.*;

import ai.djl.*;
import ai.djl.ndarray.*;
import ai.djl.repository.zoo.*;
import ai.djl.training.util.*;

public class word_embedding {

    public static void main(String... args) throws Exception {
        var criteria = Criteria.builder()
                .optApplication(Application.NLP.WORD_EMBEDDING)
                .setTypes(String.class, NDList.class)
                .optArtifactId("glove")
                .optProgress(new ProgressBar())
                .build();
        var model = criteria.loadModel();

        var input = "test";
        try (var predictor = model.newPredictor()) {
            var ndlist = predictor.predict(input);
            out.println(ndlist);
        }
    }
}
