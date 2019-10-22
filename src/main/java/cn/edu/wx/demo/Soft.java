package cn.edu.wx.demo;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Soft {
    public static void main(String[] args) {

        String company_financing_stage = "", company_industry = "", company_location = "", company_name = "", company_nature = "", company_overview = "", company_people = "", job_edu_require = "", job_exp_require = "", job_info = "", job_name = "", job_salary = "", job_tag = "", job_welfare = "";

        try {
            final String path ="C:\\Users\\王旭\\Desktop\\2019-8-1\\1.xlsx";
            File f = new File(path);

            FileInputStream inp = new FileInputStream("C:\\Users\\王旭\\Desktop\\2019-8-1\\item.csv");

            XSSFWorkbook wb = new XSSFWorkbook(inp);
            System.out.println("1");
            // Sheet1
            XSSFSheet sheet = wb.getSheetAt(0);
            // 去掉标题
            for (Row row : sheet) {
                if (row.getCell(0) != null) {
                    company_financing_stage = row.getCell(0).getStringCellValue().trim();
                    company_financing_stage = company_financing_stage.replaceAll("\r|\n|\r\n", "")
                            .replaceAll("[ ]+", " ");
                    row.getCell(0).setCellValue(company_financing_stage);
                }
                // 去掉多余的空格https://blog.csdn.net/kaukiyou/article/details/46829375
                if (row.getCell(1) != null) {
                    company_industry = row.getCell(1).getStringCellValue().trim();
                    company_industry = company_industry.replaceAll("\r|\n|\r\n", "").
                            replaceAll("[ ]+", " ");
                    row.getCell(1).setCellValue(company_industry);
                }

                if (row.getCell(2) != null) {
                    company_location = row.getCell(2).getStringCellValue().trim();
                    company_location = company_location.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(2).setCellValue(company_location);
                }

                if (row.getCell(3) != null) {
                    company_name = row.getCell(3).getStringCellValue().trim();
                    company_name = company_name.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(3).setCellValue(company_name);
                }

                if (row.getCell(4) != null) {
                    company_nature = row.getCell(4).getStringCellValue().trim();
                    company_nature = company_nature.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(4).setCellValue(company_nature);
                }

                if (row.getCell(5) != null) {
                    company_overview = row.getCell(5).getStringCellValue().trim();
                    company_overview = company_overview.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(5).setCellValue(company_overview);
                }

                if (row.getCell(6) != null) {
                    company_people = row.getCell(6).getStringCellValue().trim();
                    company_people = company_people.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(6).setCellValue(company_people);
                }

                if (row.getCell(7) != null) {
                    job_edu_require = row.getCell(7).getStringCellValue().trim();
                    job_edu_require = job_edu_require.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(7).setCellValue(job_edu_require);
                }

                if (row.getCell(8) != null) {
                    job_exp_require = row.getCell(8).getStringCellValue().trim();
                    job_exp_require = job_exp_require.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(8).setCellValue(job_exp_require);
                }

                if (row.getCell(9) != null) {
                    job_info = row.getCell(9).getStringCellValue().trim();
                    job_info = job_info.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(9).setCellValue(job_info);
                }

                if (row.getCell(10) != null) {
                    job_name = row.getCell(10).getStringCellValue().trim();
                    job_name = job_name.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(10).setCellValue(job_name);
                }

                if (row.getCell(11) != null) {
                    job_salary = row.getCell(11).getStringCellValue().trim();
                    job_salary = job_salary.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(11).setCellValue(job_salary);
                }

                if (row.getCell(12) != null) {
                    job_tag = row.getCell(12).getStringCellValue().trim();
                    job_tag = job_tag.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(12).setCellValue(job_tag);
                }

                if (row.getCell(13) != null) {
                    job_welfare = row.getCell(13).getStringCellValue().trim();
                    job_welfare = job_welfare.replaceAll("\r|\n|\r\n", "").replaceAll("[ ]+", " ");
                    row.getCell(13).setCellValue(job_welfare);
                }
            }

            //写入文件
            FileOutputStream fileOut = new FileOutputStream("workbook2.xlsx");
            wb.write(fileOut);
            //关闭文件
            fileOut.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
