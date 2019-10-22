package cn.edu.wx.demo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.IOException;

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
