package vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 /**
  * 
  * @author Neha
  *
  */
// it will run the program again and again
public class RetryAnalyzerImplementationClass implements IRetryAnalyzer {
	 int limit=3;
	  int count=1;

	@Override
	public boolean retry(ITestResult result) {
		while(limit>=count)
		{
			count++;
			return true;
		}
		

		
		return false;
	}
	

}
