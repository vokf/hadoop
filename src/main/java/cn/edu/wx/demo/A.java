package cn.edu.wx.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class A {
    public static void main(String[] args) throws Exception {
        int i;


        ArrayList<String[]> csvFileList = new ArrayList<String[]>();
        // 定义一个CSV路径
        //String csvFilePath = "E:\\item.csv";
        String csvFilePath = "D:\\item.csv";
        CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));

        // 跳过表头 如果需要表头的话，这句可以忽略
        //	reader.readHeaders();
        /**逐行读入除表头的数据*/
        try {
            while (reader.readRecord()) {
                // System.out.println("原数据"+reader.getRawRecord());
                csvFileList.add(reader.getValues());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        reader.close();


        //遍历读取的CSV文件
        CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
        for (int row = 0; row < csvFileList.size(); row++) {
            // 取得第row行第0列的数据
            String[] cell = csvFileList.get(row);
            for (i = 0; i < cell.length; i++) {
                //System.out.println(cell[i]);
                //cell[i]= cell[i].replaceAll("\r|\n|\r\n", "").replaceAll(",", "，").replaceAll("[ ]+", "");
                cell[i] = cell[i].replaceAll("\t", "")
                        .replace("\r", "")
                        .replace("\n", "")
                        .replace("||", "|")
                        .replace("||", "|")
                        .replace("||", "|")
                        .replace("||", "|")
                        .replace("||", "|")
                        .replace("||", "|")
                        .replace("||", "|")
                        .replace("'", "")
                        .replace("\"", "")
                        .replace("\n", "")
                        .replace("\\", "");
            }
            csvWriter.writeRecord(cell);
        }
        csvWriter.close();
        System.out.println("--------CSV已经修改------");
    }
}
