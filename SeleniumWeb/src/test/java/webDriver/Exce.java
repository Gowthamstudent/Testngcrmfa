package webDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exce {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f =new File("./test-data/CRMFA Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		//XSSFWorkbook work =null;
		XSSFWorkbook work = new XSSFWorkbook(fin);
		XSSFSheet sheet = work.getSheetAt(0);
		int rowc = sheet.getLastRowNum();
		System.out.println(rowc);
		int colc = sheet.getRow(1).getLastCellNum();
		System.out.println(colc);
		String[][] data = new String[rowc][colc];
		for (int i = 1; i < rowc; i++) {
			XSSFRow rowv = sheet.getRow(i);
			for (int j = 0; j < colc; j++) {
				XSSFCell colv =rowv.getCell(j);
				DataFormatter df = new DataFormatter();
				String value = df.formatCellValue(colv);
				data[i-1][j]=value;	
			}
		}

	work.close();}

}
