///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.29.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.onnxruntime:onnxruntime-engine
//DEPS org.slf4j:slf4j-simple:2.0.13
///DEPS org.slf4j:slf4j-nop:2.0.13

import static java.lang.System.out;

import java.nio.file.Path;
import java.util.Collections;

import ai.djl.Application;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.DataType;
import ai.djl.repository.zoo.Criteria;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;

public class ocr {

    static final Path MODEL_PATH = Path.of("data/ppocr/en_PP-OCRv3_det_infer.onnx");
    static final String IMAGES_DIR = "data/images";

    public static void main(String... args) throws Exception {
        var criteria = Criteria.builder()
                .setTypes(Image.class, DetectedObjects.class)
                .optApplication(Application.CV.OBJECT_DETECTION)
                .optModelPath(MODEL_PATH)
                .optTranslator(new TextDetectionTranslator())
                .optProgress(new ProgressBar())
                .build();
        var model = criteria.loadModel();

        var input = ImageFactory.getInstance().fromFile(Path.of(IMAGES_DIR, "camels_song.jpg"));
        try (var predictor = model.newPredictor()) {
            var result = predictor.predict(input);
            out.println(result);
        }
    }

    static class TextDetectionTranslator implements Translator<Image, DetectedObjects> {
        @Override
        public NDList processInput(TranslatorContext ctx, Image input) {
            NDManager manager = ctx.getNDManager();
            return new NDList(input.toNDArray(manager).toType(DataType.FLOAT32, false));
        }

        @Override
        public DetectedObjects processOutput(TranslatorContext ctx, NDList list) {
            return new DetectedObjects(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        }
    }
}
