package cn.edu.wx.demo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**@author 王旭*/
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
