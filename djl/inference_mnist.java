///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS ai.djl:bom:0.31.0@pom
//DEPS ai.djl:api
//DEPS ai.djl:basicdataset
//DEPS ai.djl:model-zoo
//DEPS ai.djl.pytorch:pytorch-engine
//DEPS org.slf4j:slf4j-simple:2.0.16

import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ai.djl.Model;
import ai.djl.basicmodelzoo.basic.Mlp;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.util.NDImageUtils;
import ai.djl.ndarray.NDList;
import ai.djl.translate.Batchifier;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;

public class inference_mnist {

    public static void main(String... args) throws Exception {
        var img = ImageFactory.getInstance().fromUrl("https://resources.djl.ai/images/0.png");
        img.getWrappedImage();

        var modelDir = Path.of("build/mlp");
        var model = Model.newInstance("mlp");
        model.setBlock(new Mlp(28 * 28, 10, new int[] { 128, 64 }));
        model.load(modelDir);

        var translator = new Translator<Image, Classifications>() {
            @Override
            public NDList processInput(TranslatorContext ctx, Image input) {
                var array = input.toNDArray(ctx.getNDManager(), Image.Flag.GRAYSCALE);
                return new NDList(NDImageUtils.toTensor(array));
            }

            @Override
            public Classifications processOutput(TranslatorContext ctx, NDList list) {
                var probabilities = list.singletonOrThrow().softmax(0);
                var classNames = IntStream.range(0, 10).mapToObj(String::valueOf).collect(Collectors.toList());
                return new Classifications(classNames, probabilities);
            }

            @Override
            public Batchifier getBatchifier() {
                return Batchifier.STACK;
            }
        };
        var predictor = model.newPredictor(translator);
        var classifications = predictor.predict(img);
        System.out.println(classifications);
    }
}
