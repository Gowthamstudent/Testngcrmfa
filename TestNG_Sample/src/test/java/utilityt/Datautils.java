package utilityt;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Datautils {

	@DataProvider()
	public static String[][] getdata() {

		//Excelclass a =new Excelclass();
		String[][] getexceldata =Excelclass.getexcel(); 
		return getexceldata;

	}

}
