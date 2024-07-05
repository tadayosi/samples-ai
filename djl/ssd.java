///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.28.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.pytorch:pytorch-model-zoo
//DEPS ai.djl.pytorch:pytorch-engine
//DEPS org.slf4j:slf4j-simple:1.7.36

import static java.lang.System.*;
import java.nio.file.*;

import ai.djl.*;
import ai.djl.modality.*;
import ai.djl.modality.cv.*;
import ai.djl.modality.cv.output.*;
import ai.djl.repository.zoo.*;
import ai.djl.training.util.*;

public class ssd {

    static final String DIR = "data/images";

    public static void main(String... args) throws Exception {
        var criteria = Criteria.builder()
            .optApplication(Application.CV.OBJECT_DETECTION)
            .setTypes(Image.class, DetectedObjects.class)
            .optArtifactId("ssd")
            .optProgress(new ProgressBar())
            .build();
        var model = criteria.loadModel();

        try (var predictor = model.newPredictor()) {
            Files.list(Path.of(DIR)).forEach(file -> {
                try {
                    var input = ImageFactory.getInstance().fromFile(file);
                    var detectedObjects = predictor.predict(input);
                    out.print("%s => ".formatted(file.getFileName()));
                    out.println(detectedObjects);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
