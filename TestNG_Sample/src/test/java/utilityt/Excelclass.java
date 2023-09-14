package utilityt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelclass {

	public static String[][] getexcel() {
		String fileloc = "./test-data/CRMFA Data.xlsx";
		// File f =new File("G:\\Eclipse_Work_Space\\TestNG_Sample\\test-data\\CRMFA
		// Data.xlsx");
		// FileInputStream fin = new FileInputStream(f);
		XSSFWorkbook work = null;
		try {
			work = new XSSFWorkbook(fileloc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = work.getSheetAt(0);
		int rowc = sheet.getLastRowNum();
		System.out.println(rowc);
		int colc = sheet.getRow(0).getLastCellNum();
		System.out.println(colc);
		String[][] data = new String[rowc][colc];
		for (int i = 1; i <= rowc; i++) {
			XSSFRow rowv = sheet.getRow(i);
			for (int j = 0; j < colc; j++) {
				XSSFCell colv = rowv.getCell(j);
				DataFormatter df = new DataFormatter();
				String value = df.formatCellValue(colv);
				data[i - 1][j] = value;
				// System.out.println(value);
			}
		}

		return data;
	}

	/*
	 * Second Method Without Using DataProvider annotation
	 */
	public String excelRead(String sheet, int row, int cell) throws IOException {
		// String value=null;
		File f = new File("./test-data/CRMFA Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		DataFormatter d = new DataFormatter();
		String CellValue = d.formatCellValue(c);
		System.out.println(CellValue);
		w.close();
		return CellValue;

		/*
		 * If DataFormatter not Work Using Switch Statement
		 */
		// CellType celltype=c.getCellType(); c.get if (celltype==1) { }
		/*
		 * switch (c.getCellType()) { case BOOLEAN : if(DateUtil.isCellDateFormatted(c))
		 * { Date d=c.getDateCellValue(); SimpleDateFormat sim =new SimpleDateFormat();
		 * value = sim.format(d); System.out.println(value); }
		 * 
		 * break; case NUMERIC: double numericvalue= c.getNumericCellValue(); long l
		 * =(long)numericvalue; value = String.valueOf(l); System.out.println(value);
		 * break; case STRING: value=c.getStringCellValue(); System.out.println(value);
		 * break;}
		 */

	}

}
