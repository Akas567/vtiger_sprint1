package vtiger.genericUtility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Neha
 *
 */

public class JavaUtility {
	/**
	 * This method return a random number depending on the user input
	 * @param limit
	 * @return
	 */
	
public int generateRandom(int limit)
{
	Random random = new Random();
	return random.nextInt(limit);
}
/**
 * This method generate system date and time
 * @return
 */

public String generateSystemDataAndTime()
{
	Date date = new Date();
	return date.toString().replace(" ", " _").replace(":","_");
}

public String generateDateInYYYY_MM_DD_Format()
{
	LocalDateTime date = LocalDateTime.now();
	int year = date.getYear();
	int month = date.getMonthValue();
	int day = date.getDayOfMonth();
	String newMonth="";
	String newDay="";
	if(month<10)
	{
		newMonth="0"+month;
		return year+"_"+newMonth+"_"+day;
	}
	if(day<10)
	{
		newDay="0"+day;
		return year+"_"+month+"_"+newDay;
	}
	
	else
		
		return year+"_"+month+"_"+"_"+day;
	  
	
}

}




