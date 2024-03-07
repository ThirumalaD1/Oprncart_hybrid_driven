package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovlogin {
	
	@DataProvider(name="logindata")
	public String[][] getTestdata() throws IOException {
		
		String path= "C:\\Users\\justi\\eclipse-workspace\\Opencart_hybrid\\testdata\\Opencart_LoginData.xlsx";
		
		Excelutilities xlutils = new Excelutilities(path);
		int totalrows = xlutils.getRowCount("Sheet1");
		int totalcolumns = xlutils.getCellCount("Sheet1", totalrows);
		
		String data[][]=new String[totalrows][totalcolumns];
		
		
		for (int i = 1; i <=totalrows; i++) {
			for (int j = 0; j < totalcolumns; j++) {
				data[i-1][j]=xlutils.getCellData("Sheet1", i, j);
			}
		}
		return data;
		
	}
	
	

}
