///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.29.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.tensorflow:tensorflow-engine
//DEPS org.slf4j:slf4j-simple:2.0.13

import static java.lang.System.out;

import java.nio.file.Files;
import java.nio.file.Path;

import ai.djl.Application;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.DataType;
import ai.djl.repository.zoo.Criteria;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;

public class image_enhancement {

    static final String MODEL_URL = "https://storage.googleapis.com/tfhub-modules/captain-pool/esrgan-tf2/1.tar.gz";
    static final String IMAGES_DIR = "data/images";
    static final String OUTPUT_DIR = "output/image_enhancement";

    public static void main(String... args) throws Exception {
        var criteria = Criteria.builder()
                .setTypes(Image.class, Image.class)
                .optApplication(Application.CV.IMAGE_ENHANCEMENT)
                .optModelUrls(MODEL_URL)
                .optTranslator(new ImageEnhancementTranslator())
                .optProgress(new ProgressBar())
                .build();
        var model = criteria.loadModel();

        var input = ImageFactory.getInstance().fromFile(Path.of(IMAGES_DIR, "fox.png"));
        try (var predictor = model.newPredictor()) {
            var enhanced = predictor.predict(input);
            out.println(enhanced);
            Files.createDirectories(Path.of(OUTPUT_DIR));
            enhanced.save(Files.newOutputStream(Path.of(OUTPUT_DIR, "enhanced_fox.png")), "png");
        }
    }

    static class ImageEnhancementTranslator implements Translator<Image, Image> {
        @Override
        public NDList processInput(TranslatorContext ctx, Image input) {
            NDManager manager = ctx.getNDManager();
            return new NDList(input.toNDArray(manager).toType(DataType.FLOAT32, false));
        }

        @Override
        public Image processOutput(TranslatorContext ctx, NDList list) {
            NDArray output = list.get(0).clip(0, 255);
            return ImageFactory.getInstance().fromNDArray(output.squeeze());
        }
    }
}
