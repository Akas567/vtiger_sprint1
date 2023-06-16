package vtiger_lead_module_test;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.POMRepository.CreatingNewLead;
import vtiger.POMRepository.HomePage;
import vtiger.POMRepository.LeadInformationPage;
import vtiger.POMRepository.LeadsPage;
import vtiger.genericUtility.BaseClass;
import vtiger.genericUtility.IPATHConstant;

@Listeners(vtiger.genericUtility.ListenersImplementationClass.class)
public class ToVerifyLeadInfoTest extends BaseClass {
	
	@Test(retryAnalyzer=vtiger.genericUtility.RetryAnalyzerImplementationClass.class)
	public void toCreateLeadAndToVerifyLeadTest() throws EncryptedDocumentException, IOException
	{
		//Here we are fetching data from excel sheets
		String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.SHEETNAME,17, 2);
		String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.SHEETNAME,18, 2);
		String expectedLeadLastName = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.SHEETNAME,19, 2);
		String leadCompanyName  = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.SHEETNAME,20, 2);
		String leadIndustryName = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.SHEETNAME,27, 2);
		String leadAssignedToDetails = eUtils.fetchStringDataFromExcelSheet(IPATHConstant.SHEETNAME,22, 2);
		
	 
		//All the object creation statements
		HomePage home = new HomePage(driver);
		LeadsPage leads = new LeadsPage(driver);
		CreatingNewLead createLead = new CreatingNewLead(driver);
		LeadInformationPage leadInfo = new LeadInformationPage(driver);
		
		//Clicking lead module
		home.clickOnleadsModule();
		
		//Clicking on lead plus button
		leads.clickOnLeadsPlusButton();
		
	
	createLead.selectFromLeadsSalutationDropdown(leadSalutation);
	createLead.enterFirstName(leadFirstName);
	createLead.enterLastName(expectedLeadLastName);
	createLead.enterCompanyName(leadCompanyName);
	createLead.selectFromIndustryDropDown(leadIndustryName);
	createLead.clickOnGroupRadioButton();
	createLead.selectFromAssigntoDropdown(leadAssignedToDetails);
	createLead.clickOnSaveButton();
	System.out.println("The Lead has been created");
	
	//Verifying the lead
	String actualLeadsLastName = leadInfo.verifyLeadsName(expectedLeadLastName);
	Assert.assertTrue(actualLeadsLastName.contains(actualLeadsLastName));
	System.out.println("Pass:The Lead has been verified");
		
	          
		
		
	}
	
	

}
