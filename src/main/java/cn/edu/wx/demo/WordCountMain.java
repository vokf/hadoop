package cn.edu.wx.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author 王旭
 */
public class WordCountMain {
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
