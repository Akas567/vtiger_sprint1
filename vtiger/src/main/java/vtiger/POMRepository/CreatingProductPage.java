package vtiger.POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vtiger.genericUtility.WebDriverUtility;

public class CreatingProductPage {
	WebDriver driver;

	public CreatingProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name = "productname")
	private WebElement productNameTextField;

	@FindBy(name = "sales_start_date")
	private WebElement ProductStartDate;

	@FindBy(name = "productcategory")
	private WebElement ProductCategoryDropDown;

	@FindBy(name = "sales_end_date")
	private WebElement salesEndDate;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement vendorNameLookIcon;

	public WebElement getProductName() {
		return productNameTextField;
	}

	public WebElement getProductStartDate() {
		return ProductStartDate;
	}

	public WebElement getProductCategoryDropDown() {
		return ProductCategoryDropDown;
	}

	public WebElement getProductEndDate() {
		return salesEndDate;
	}

	public WebElement getVendorNameLookIcon() {
		return vendorNameLookIcon;
	}

	public WebElement getProductImageUploadButton() {
		return productImageUploadButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getVendorSearchTextField() {
		return vendorSearchTextField;
	}

	public WebElement getVendorSearchInDropDown() {
		return vendorSearchInDropDown;
	}

	public WebElement getVendorSearchButton() {
		return vendorSearchButton;
	}

	@FindBy(id = "my_file_element")
	private WebElement productImageUploadButton;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(name = "search_text")
	private WebElement vendorSearchTextField;

	@FindBy(name = "search_field")
	private WebElement vendorSearchInDropDown;

	@FindBy(name = "search")
	private WebElement vendorSearchButton;
	
	public void enterProductName(String productName)
	{
	 productNameTextField.sendKeys( productName);
	}
	
	public void entersalesStartDate(String dateIn_YYYY_MM_DD_Format)
	{
		ProductStartDate.sendKeys(dateIn_YYYY_MM_DD_Format);
		
	}
	
	
	public void selectFromProductCategoryDropDown(String option)
	{
		Select select = new Select(ProductCategoryDropDown);
		select.selectByVisibleText(option);
	}
	
	public void entersalesEndDate(String dateIn_YYYY_MM_DD_Format)
	{
		salesEndDate.sendKeys(dateIn_YYYY_MM_DD_Format);
	}
	
	public void selectVendorNameFromVendorLookUpPage(String childWindowTitle,String vendorName, String parentWindowTitle) throws InterruptedException
	{
		vendorNameLookIcon.click();
		WebDriverUtility wUtils=new WebDriverUtility();
		wUtils.switchToWindow(driver,childWindowTitle);
		vendorSearchTextField.sendKeys(vendorName);
		vendorSearchButton.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		wUtils.switchToWindow(driver, parentWindowTitle);
	}
	
	public void uploadProductImage(String filePath)
	{
		String userDir = System.getProperty("user.dir");
		productImageUploadButton.sendKeys(userDir+filePath);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
}
