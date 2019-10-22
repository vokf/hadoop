package cn.edu.wx.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


public class readCSV {
	public static void main(String[] args)throws IOException{
	int i;	
	
	
	ArrayList<String[]> csvFileList = new ArrayList<String[]>();
	// ???????CSV¡¤??
				//String csvFilePath = "E:\\item.csv";
				String csvFilePath = "C:\\Users\\wwwqq\\Desktop\\item02.csv";
	 CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
	
				// ??????? ???????????????????????
//				 reader.readHeaders();
				// ???§Ø?????????????
	 			try{
				 while (reader.readRecord()) {
//				 System.out.println("?????"+reader.getRawRecord()); 
				 csvFileList.add(reader.getValues()); 
				 }
	 			}catch(Exception e){
	 				e.printStackTrace();
	 			}
				 reader.close();
				
				 
				 
				 
				 
				 //?????????CSV???
	CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));  
	for (int row = 0; row < csvFileList.size(); row++) {
				 // ????row?§Ö?0?§Ö?????
		
			 String[] cell = csvFileList.get(row);  
			 for(i=0;i<cell.length ;i++)
			 {
				 //System.out.println(cell[i]); 
				 //cell[i]= cell[i].replaceAll("\r|\n|\r\n", "").replaceAll(",", "??").replaceAll("[ ]+", "");
				 cell[i]= cell[i].replaceAll("\t", "").replace("\r", "").replace("\n", "").replace("||", "|")
				 .replace("||", "|").replace("||", "|").replace("||", "|").replace("||", "|").replace("||", "|")
				 .replace("||", "|").replace("'", "").replace("\"", "").replace("\n", "").replace("\\", "");
				
			 }

			 
			 csvWriter.writeRecord(cell); 
				
	}
			   csvWriter.close();


	System.out.println("--------CSV??????§Õ??--------");  
	}
	
}

