package seleniumassignments;

	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReader {

	    public static Object[][] readDataFromExcel(String excelFilePath) throws IOException {
	        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\StarAgile_SeleniumAssignments\\TestData\\Logindata.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet=workbook.getSheet("Sheet1");
	       
	        int rowCount = sheet.getLastRowNum();
	        //int colcount=sheet.getRow(0).getLastCellNum();
	        Object[][] data = new Object[rowCount][2]; // 2 columns for username and password

	        for (int i = 1; i <= rowCount; i++) { // Skip the header row
	            Row row = sheet.getRow(i);
	            data[i - 1][0] = row.getCell(0).getStringCellValue(); // Username
	            data[i - 1][1] = row.getCell(1).getStringCellValue(); // Password
	        }

	        return data;
	    }
	}

