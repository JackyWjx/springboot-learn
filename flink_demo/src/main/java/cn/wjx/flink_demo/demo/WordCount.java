package cn.wjx.flink_demo.demo;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import scala.concurrent.ExecutionContextExecutor;

/**
 * @Author: wjx
 * @Description:
 * @Date: create in 2020-12-31 23:25
 */
public class WordCount {
    public static void main(String[] args) {
        //创建执行环境
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();

        //从文件中读取数据
        String filePath = "E:\\JavaProject\\springboot-learn\\flink_demo\\src\\main\\resources\\hello.txt";
        DataSet<String> dataSet = executionEnvironment.readTextFile(filePath);

        //对数据进行处理，按空格分词展开，转化成（word,1） 二元组进行统计
        dataSet.flatMap(new FlatMapper()).groupBy(0)//按照第一个位置的word分组
        .sum(1);//将第二个位置上的数据求和
    }

    public static class FlatMapper implements FlatMapFunction<String, Tuple2<String,Integer>>{

        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
            //按空格分词
            String[] words = s.split(" ");
            //遍历所有word，包成二元组输出
            for (String word:words){
                collector.collect(new Tuple2<>(word,1));
            }
        }
    }
}
