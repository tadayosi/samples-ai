///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS ai.djl:bom:0.31.0@pom
//DEPS ai.djl:api
//DEPS ai.djl:basicdataset
//DEPS ai.djl:model-zoo
//DEPS ai.djl.pytorch:pytorch-engine
//DEPS org.slf4j:slf4j-simple:2.0.16

import java.nio.file.Files;
import java.nio.file.Path;

import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.Mnist;
import ai.djl.basicmodelzoo.basic.Mlp;
import ai.djl.ndarray.types.Shape;
import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.EasyTrain;
import ai.djl.training.evaluator.Accuracy;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;
import ai.djl.training.util.ProgressBar;

public class train_mnist {

    public static void main(String... args) throws Exception {
        // Prepare dataset
        var batchSize = 32;
        var mnist = Mnist.builder().setSampling(batchSize, true).build();
        mnist.prepare(new ProgressBar());

        // Create model
        var model = Model.newInstance("mlp");
        model.setBlock(new Mlp(28 * 28, 10, new int[] { 128, 64 }));

        // Create trainer
        var config = new DefaultTrainingConfig(Loss.softmaxCrossEntropyLoss())
                .addEvaluator(new Accuracy())
                .addTrainingListeners(TrainingListener.Defaults.logging());
        var trainer = model.newTrainer(config);

        // Initialise training
        trainer.initialize(new Shape(1, 28 * 28));

        // Train model
        var epoch = 2;
        EasyTrain.fit(trainer, epoch, mnist, null);

        // Save model
        var modelDir = Path.of("build/mlp");
        Files.createDirectories(modelDir);
        model.setProperty("Epoch", String.valueOf(epoch));
        model.save(modelDir, "mlp");
        System.out.println(model);
    }
}
