package vtiger.genericUtility;






import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import vtiger.POMRepository.HomePage;
import vtiger.POMRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	
	public WebDriverUtility wUtils=new WebDriverUtility();
	public FileUtility fUtils=new FileUtility();
	public ExcelUtility eUtils=new ExcelUtility();
	public static WebDriver sDriver;
	
	
	
	@BeforeSuite
	public void bsConfig() 
	{
		
	}
	
	@BeforeClass
	public void bcConfig() throws IOException 
	{
		String url = fUtils.toFetchDataFromPropertyFile(IPATHConstant.URL_KEY);
		driver=new ChromeDriver();
		System.out.println("The browser has been launched");
		wUtils.maximizeTheWebPage(driver);
		wUtils.implictWait(driver);
		driver.get(url);
		System.out.println("The url has been navigated");
		sDriver=driver;
		
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String username = fUtils.toFetchDataFromPropertyFile(IPATHConstant.USERNAME_KEY);
		String password = fUtils.toFetchDataFromPropertyFile(IPATHConstant.PASSWORD_KEY);
		LoginPage login=new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("The "+username+" has logged in");
	}
	
	@AfterMethod
	public void amConfig() throws IOException
	{
		String username = fUtils.toFetchDataFromPropertyFile(IPATHConstant.USERNAME_KEY);
		HomePage home=new HomePage(driver);
		home.logoutAction();
		System.out.println("The "+username+" has logged out");
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("The Browser has been closed");
	}
	
	@AfterSuite
	public void asConfig() 
	{
		
	}
	
	}
	
	


