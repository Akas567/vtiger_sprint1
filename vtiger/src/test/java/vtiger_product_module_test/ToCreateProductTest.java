package vtiger_product_module_test;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.POMRepository.CreatingNewVendorPage;
import vtiger.POMRepository.CreatingProductPage;
import vtiger.POMRepository.HomePage;
import vtiger.POMRepository.ProductInformationPage;
import vtiger.POMRepository.ProductPage;
import vtiger.POMRepository.VendorInformationPage;
import vtiger.POMRepository.VendorPage;
import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.IPATHConstant;

@Listeners(vtiger.genericUtility.ListenersImplementationClass.class)
public class ToCreateProductTest extends BaseClass {
	
	@Test
	
	public void toCreateProductAndToVerifyProductName() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Fetch Product related datas from excel sheet
	     String vendorName = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.PRODUCT_SHEETNAME, 17,2);
	   String productName = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.PRODUCT_SHEETNAME, 20, 2);
	  //String salesStartDate = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.PRODUCT_SHEETNAME, 21, 2);
	 // String salesEndDate = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.PRODUCT_SHEETNAME, 27, 2);
	
	 //Creating all the  objects
		HomePage home=new HomePage(driver);
		VendorPage vendor=new VendorPage(driver);
		ProductPage product=new ProductPage(driver);
		CreatingNewVendorPage createVendor=new CreatingNewVendorPage(driver);
		CreatingProductPage createProduct=new CreatingProductPage (driver);
		VendorInformationPage vendorInfo=new VendorInformationPage(driver);
		 ProductInformationPage productInfo=new  ProductInformationPage(driver);
		
		//Creating vendor to avoid data dependency
		 home.clickOnVedorModule();
		 vendor.clickOnVendorPlusButton();
		 createVendor.enterVendorName(vendorName);
		 createVendor.clickOnSaveButton();
		 System.out.println("The vendor has been created");
		
		 //verifying the vendor
		   
		   String actualVendorName = vendorInfo.verifyVendorInfo(vendorName);
		   Assert.assertTrue(actualVendorName.contains(vendorName));
		   System.out.println("Pass the vendor name is verified");
		   
		   //Creating the product
		   home.clickOnProductsModule();
		   product.clickOnProductPlusButton();
		   createProduct.enterProductName(productName);
		   createProduct.selectFromProductCategoryDropDown("Hardware");
		// createProduct.entersalesEndDate(salesStartDate);
		  // createProduct.entersalesEndDate(salesEndDate);
		   createProduct.selectVendorNameFromVendorLookUpPage(IPATHConstant.VENDOR_LOOKUP_PAGE_TITLE, vendorName,IPATHConstant.PRODUCT_LOOKUP_PAGE_TITLE);
		   createProduct.uploadProductImage(IPATHConstant.PRODUCT_IMAGE_PATH);
		   createProduct.clickOnSaveButton();
		   System.out.println("The product has been created");
		   
		 //Verifying the product
		   
			String actualProductName = productInfo.verifyProductInfo(productName);
			Assert.assertTrue(actualProductName.contains(productName));
			System.out.println("Pass: the product name has been verified");
		   
}		 
		
} 
	


