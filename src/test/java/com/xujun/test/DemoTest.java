package com.xujun.test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/16/ 21:49
 * @Description :
 */
public class DemoTest {
	@Test
	public void test(){
		//在内存中创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作表，指定工作表名称
		HSSFSheet sheet = workbook.createSheet("POI测试");
		//创建行，0表示第一行
		HSSFRow row = sheet.createRow(0);
		//创建单元格，0表示第一个单元格
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("PV");//商品每日访问次数
		row.createCell(1).setCellValue("UV");//访客数
		row.createCell(2).setCellValue("TIME");//每页平均停留时间

		HSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue(1000);
		row1.createCell(1).setCellValue(2000);
		row1.createCell(2).setCellValue(3000);

		//通过输出流将workbook对象输出到磁盘
		try {
			FileOutputStream out = new FileOutputStream("F://goods.xls");
			workbook.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
