package vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains the method to fetch data from property file
 * @author Neha
 *
 */

public class FileUtility {
	/**
	 * This method fetches data from property file using the key
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	
	public String toFetchDataFromPropertyFile(String Key) throws IOException
	{
		
		FileInputStream fis=new FileInputStream(IPATHConstant.PROPERTYFILEPATH);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(Key);
	}
	
	

}
