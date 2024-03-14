package apachepoi.xmlread.propertyfileread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadFromExcelDemo {
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;

	@Test
	public void readFile() throws IOException {
		//fis = new FileInputStream("D:\\JavaLearning\\AutomationData.xlsx");
		fis = new FileInputStream("./excel/AutomationData.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Selenium");
		// rows information
		System.out.println("Total number of rows " + sheet.getPhysicalNumberOfRows());
		row = sheet.getRow(3);
		System.out.println(row.getCell(1));

		// Column information
		System.out.println("Total number of columns " + sheet.getRow(0).getPhysicalNumberOfCells());

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				String data = row.getCell(j).getStringCellValue();
				System.out.print(data + "  ");
				
				 if(i==4)
		          {
		        	  row.getCell(0).setCellValue("EnteredValue");
		        	  FileOutputStream fos = new FileOutputStream("./excel/AutomationData.xlsx");
		        	  workbook.write(fos);
		        	  //System.out.println(row.getCell(0));
		          }
			}
			
          System.out.println();
         
		}

	}

}
