package cn.wjx.flink_demo.demo;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2021-01-04 15:52
 */
public class StreamWordCount {
    public static void main(String[] args) throws Exception {

        //定于环境
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        //修改并行度
        executionEnvironment.setParallelism(16);

        //从监控端口（socket 文本流）获取数据
        DataStreamSource<String> dataStream = executionEnvironment.socketTextStream("localhost", 7777);
        /*

        //读取文件数据
        String filePath = "E:\\JavaProject\\springboot-learn\\flink_demo\\src\\main\\resources\\hello.txt";
        DataStream<String> dataStream = executionEnvironment.readTextFile(filePath);

        */

        //基于数据流进行转化计算
        DataStream<Tuple2<String, Integer>> sum = dataStream.flatMap(new WordCount.FlatMapper()).keyBy(0).sum(1);
        sum.print();

        //执行任务
        executionEnvironment.execute();

        /**
         * 处理分区                     结果
         * 3         >                (are,1)
         * 6         >                (is,1)
         * 4         >                (you,1)
         * 6         >                (and,1)
         * 4         >                (my,1)
         * 1         >                (wjx,1)
         * 5         >                (how,1)
         * 4         >                (you,2)
         * 5         >                (good,1)
         * 3         >                (name,1)
         * 3         >                (yes,1)
         */

    }

}
