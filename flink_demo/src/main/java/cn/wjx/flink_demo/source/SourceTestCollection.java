package cn.wjx.flink_demo.source;

import cn.wjx.flink_demo.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-01-04 16:53
 */
public class SourceTestCollection {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        environment.setParallelism(1);
        DataStreamSource<SensorReading> collectionData = environment.fromCollection(Arrays.asList(
                new SensorReading("sensor_1", 1547718199L, 35.8),
                new SensorReading("sensor_6", 1547718201L, 15.4),
                new SensorReading("sensor_7", 1547718202L, 6.7),
                new SensorReading("sensor_10", 1547718205L, 38.1)
                )
        );

        DataStreamSource<Integer> intData = environment.fromElements(1, 5, 6, 9, 78, 99, 124, 512, 1011);

        collectionData.print("SensorReading");

        intData.print("element");

        environment.execute();
    }
}
