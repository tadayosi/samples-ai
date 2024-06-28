///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS ai.djl:bom:0.28.0@pom
//DEPS ai.djl:api
//DEPS ai.djl.timeseries:timeseries
//DEPS ai.djl.pytorch:pytorch-engine
//DEPS ai.djl.pytorch:pytorch-model-zoo
//DEPS org.slf4j:slf4j-simple:1.7.36

import static java.lang.System.*;
import java.time.*;

import ai.djl.*;
import ai.djl.ndarray.*;
import ai.djl.repository.zoo.*;
import ai.djl.timeseries.*;
import ai.djl.timeseries.dataset.*;
import ai.djl.training.util.*;

public class forecasting {

    public static void main(String... args) throws Exception {
        var criteria = Criteria.builder()
                .optApplication(Application.TimeSeries.FORECASTING)
                .setTypes(TimeSeriesData.class, Forecast.class)
                .optArtifactId("deepar")
                .optProgress(new ProgressBar())
                .build();
        var model = criteria.loadModel();

        var input = new TimeSeriesData(10);
        input.setStartTime(LocalDateTime.now());
        try (var predictor = model.newPredictor();
            var manager = NDManager.newBaseManager("PyTorch")) {
            var data = manager.create(new float[] {
                1.0f, 2.0f, 3.0f, 1.0f, 2.0f,
                1.0f, 1.0f, 2.0f, 1.0f, 3.0f
            });
            input.setField(FieldName.TARGET, data);
            var forecast = predictor.predict(input);
            out.println("Mean: " + forecast.mean());
            out.println("Median: " + forecast.median());
        }
    }
}
