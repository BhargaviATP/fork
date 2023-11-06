package genericUtilities;

import java.io.IOException;
import java.io.File;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility implements IAutoConstants{
	Workbook workbook;
	@DataProvider(name= "data")
	public Object[][] readExcel(){
		File file = new File(EXCEL_PATH);
		try {
		workbook  = WorkbookFactory.create(file);
		}catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet=workbook.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowcount][cellcount];
		for(int row=0; row<rowcount;row++) {
			Row actRow=sheet.getRow(row);
			for(int cell=0;cell<actRow.getPhysicalNumberOfCells();cell++) {
				data[row][cell]=actRow.getCell(cell).toString();
			}
		}
		return data;
	}

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                