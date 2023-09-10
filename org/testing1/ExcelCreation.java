package org.testing1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCreation {
	public static String[][] getExcelData() throws IOException {
		// To create a excel by using script
//		File f = new File("C:\\Users\\arunk\\eclipse-workspace\\ForCheckingKnowledge\\ExcelWorksheet\\excel.xlsx");
//		Workbook w = new XSSFWorkbook();
//		Sheet sheet = w.createSheet("Login");
//		Row row = sheet.createRow(0);
//		Row row2 = sheet.createRow(1);
//		row.createCell(0).setCellValue("username");
//		row.createCell(1).setCellValue("password");
//		
//		sheet.createRow(2).createCell(0).setCellValue("arun");
//		
//		Cell cell3 = row2.createCell(0);
//		Cell cell4 = row2.createCell(1);
//		cell3.setCellValue("bhuvana");
//		cell4.setCellValue("4563214sdgjh");
//		
//		FileOutputStream fin = new FileOutputStream(f);
//		w.write(fin);
//		System.out.println("finished");
		
		
		// to get the particular data form the Excel
		File f = new File("C:\\Users\\arunk\\eclipse-workspace\\ForCheckingKnowledge\\ExcelWorksheet\\Sample1.xlsx");
		FileInputStream fin = new FileInputStream(f);
		
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet("Details");
//		Row row = sh.getRow(2);
//		Cell cell = row.getCell(2);
//		System.out.println(cell);
		
	// to fetch all the datas in the excel
		
		int size = sh.getPhysicalNumberOfRows();
		System.out.println(size);
		
		for (int i = 0; i <size; i++) {
			Row row = sh.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				//System.out.println(cell);
				
				int type = cell.getCellType();
				if (type==1) {
					String name = cell.getStringCellValue();
					System.out.println(name);
				}
				else if(DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					
					SimpleDateFormat simple = new SimpleDateFormat();
					String format = simple.format(date);
					System.out.println(format);
				}
				else {
					double d = cell.getNumericCellValue();
					long l =(long)d;
					String name = String.valueOf(l);
					System.out.println(name);
					
				}
				
			}
			
		}
		return null;
		
		
		
		
		
		
	}

}
