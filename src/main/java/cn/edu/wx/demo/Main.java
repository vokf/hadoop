package cn.edu.wx.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Main {


    /**
     * @author 王旭
     */
//K1         V1      K2      V2
    public class WorldCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        /**
         * Called once for each key/value pair in the input split. Most applications
         * should override this, but the default is the identity function.
         *
         * @param key1
         * @param value1
         * @param context 表示map的上下文 上文是HDFS 下文是reduce
         */
        @Override
        protected void map(LongWritable key1, Text value1, Context context) throws IOException, InterruptedException {
            //获取数据
            String data = value1.toString();
            //分词操作
            String[] words = data.split("");
            // 输出

            for (String w : words) {
                //             K2             V2
                context.write(new Text(w), new IntWritable(1));
            }
        }
    }

    /**
     * @author 王旭
     */
    public class WorldCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
//                                              K3      V3      K4      V4

        /**
         * This method is called once for each key. Most applications will define
         * their reduce class by overriding this method. The default implementation
         * is an identity function.
         *
         * @param key3
         * @param values3
         * @param context reducer 的上下文  上文是mapper 下文是HDFS
         */
        @Override
        protected void reduce(Text key3, Iterable<IntWritable> values3, Context context) throws IOException, InterruptedException {
            //对value3 进行求和
            int total = 0;
            for (IntWritable v : values3) {

                total = total + v.get();
            }
            //   输出      单词             次数
            context.write(key3, new IntWritable(total));

        }
    }

    public static void main(String[] args) throws Exception {
        /**模式固定*/
        //1、指定一个Job
        Job job = Job.getInstance(new Configuration());
        // 通过传入的class 找到job的jar包
        job.setJarByClass(Test.class);
        //2、指定任务的map
        job.setMapperClass(WorldCountMapper.class);
        /**key2*/
        job.setMapOutputKeyClass(Text.class);
        /**value2*/
        job.setMapOutputValueClass(IntWritable.class);
        //3、指定任务的reduce
        job.setReducerClass(WorldCountReducer.class);
        /** k4 的类型*/
        job.setOutputKeyClass(Text.class);
        /**V4的类型*/
        job.setOutputValueClass(IntWritable.class);
        //4、 指出任务的输入路径、输出路径 HDFS的路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        //5.执行任务
        job.waitForCompletion(true);

    }


}
