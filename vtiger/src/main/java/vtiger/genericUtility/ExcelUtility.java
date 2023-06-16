package vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Neha
 *
 */

public class ExcelUtility {
	/**
	 * 
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String fetchStringDataFromExcelSheet(String SheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IPATHConstant.EXCELFILEPATH);
		return WorkbookFactory.create(fis).getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	/**
	 * 
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int fetchNumericDataFromExcelSheet(String SheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IPATHConstant.EXCELFILEPATH);
		return (int)WorkbookFactory.create(fis).getSheet(SheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	/**
	 * 
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public boolean fetchBooleanDataFromExcelSheet(String SheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IPATHConstant.EXCELFILEPATH);
		return WorkbookFactory.create(fis).getSheet(SheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}
	
	

}
