package com.stores.vemo.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader  {
	private static String path = "./Data/TestData.xlsx";
	private static Map<String, String> testData;

	@SuppressWarnings("deprecation")
	public static Map<String, String> loadTestData(String testNameKey, String sheet) {
		try {
			FileInputStream file = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet activeSheet = workbook.getSheet(sheet);
			testData = new LinkedHashMap<>();
			List<String> keys = new ArrayList<>();
			for (Cell cell : activeSheet.getRow(0)) {
				keys.add(cell.getStringCellValue());
			}
			for (Row row : activeSheet) {
				if (row.getCell(0).getStringCellValue().equals(testNameKey)) {
					int i = 0;
					for (int j = 0; j < row.getLastCellNum(); j++) {
						Cell cell = row.getCell(j);
						if (cell != null) {
							switch (cell.getCellTypeEnum()) {
							case STRING:
								testData.put(keys.get(i), cell.getStringCellValue());
								break;
							case NUMERIC:
								testData.put(keys.get(i), String.valueOf((int) cell.getNumericCellValue()));
								break;
							case BOOLEAN:
								testData.put(keys.get(i), String.valueOf(cell.getBooleanCellValue()));
								break;
							default:
								break;
							}
						} else
							testData.put(keys.get(i), "");
						i++;
					}
					break;
				}
			}
			workbook.close();
		} catch (IOException e) {
			System.out.println(e.toString());

		}

		return testData;
	}
	
}


