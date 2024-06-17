///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.28.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.mxnet:mxnet-model-zoo
///DEPS ai.djl.mxnet:mxnet-native-mkl:1.9.1:osx-x86_64

import static java.lang.System.*;

import ai.djl.*;
import ai.djl.modality.*;
import ai.djl.modality.cv.*;
import ai.djl.repository.zoo.*;

public class mnist {

    public static void main(String... args) throws Exception {
        var input = ImageFactory.getInstance().fromUrl("https://resources.djl.ai/images/0.png");
        var criteria = Criteria.builder()
                .optApplication(Application.CV.IMAGE_CLASSIFICATION)
                .setTypes(Image.class, Classifications.class)
                .optArtifactId("mlp")
                .build();
        var model = criteria.loadModel();
        try (var predictor = model.newPredictor()) {
            var classifications = predictor.predict(input);
            out.println(classifications);
        }
    }
}
