///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.29.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.pytorch:pytorch-engine
//DEPS ai.djl.pytorch:pytorch-model-zoo
///DEPS org.slf4j:slf4j-simple:2.0.13
//DEPS org.slf4j:slf4j-nop:2.0.13

import static java.lang.System.out;

import ai.djl.Application;
import ai.djl.modality.nlp.qa.QAInput;
import ai.djl.repository.zoo.Criteria;

public class bertqa {

    public static void main(String... args) throws Exception {
        if (args.length < 2) {
            out.println("Usage:");
            out.println("  ./bertqa.java <question> <paragraph>");
            return;
        }

        var criteria = Criteria.builder()
                .optApplication(Application.NLP.QUESTION_ANSWER)
                .setTypes(QAInput.class, String.class)
                .optArtifactId("bertqa")
                //.optProgress(new ProgressBar())
                .build();
        var model = criteria.loadModel();

        var input = new QAInput(args[0], args[1]);
        try (var predictor = model.newPredictor()) {
            var answer = predictor.predict(input);
            out.println("=> " + answer);
        }
    }
}
