package cn.edu.wx.demo;

/**
 * @author 王旭
 */
public class Test {
    /**分布式*/
    /**
     * Map-Reduce 编程模型
     * 核心：先拆分，再合并
     * 大任务在一台计算不了，就拆分成许多小任务进行计算，然后将小任务计算的结果合并成一个完整的结果
     * 程序主要是用来解决大数据计算机问题
     *
     */
    /**
     * 大数据：商品推荐 1.大量的订单如何存储 如何进行计算
     * 天气预报 大量的天气数据如何存储，
     * 解决的核心问题 数据的存储（分布式文件系统 HDFS），数据的计算（MapReduce）
     * 根据谷歌发布的MapReduce论文提出的计算模型
     * 问题PageRank（网页排名）最重要的排在前面
     */
    /**
     * 一个完整的MapReduce需要三个class
     * 一个mapreduce的任务就叫一个Job
     * job 可以由一个map + 一个 reduce
     * map 的输出是reduce的输入
     * 所有的输入和输出都是<key value>的形式
     * 所有的数据类型只能是Hadoop自己的数据类型，不能是Java中的数据类型
     * int --- IntWritable    long --- LongWritable   String -- Text  null --- NullWritable
     */
    /**
     *WordCount 单词计数
     * 运行命令
     *
     * hadoop jar hadoop-mapreduce-examples-2.7.3.jar wordcount /input/计数文件 /output/输出文件夹名（每次输出文件名都不一样）
     * 查看结果命令
     *
     * hdfs fs -ls /output/输出文件名
     * hdfs dfs -cat output/
     * 读取数据按行读取
     */
}
