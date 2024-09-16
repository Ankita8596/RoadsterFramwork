package com.crm.tp.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.tp.baseutility.BaseClass;
import com.crm.tp.objectrepositoryutility.ContactsPage;
import com.crm.tp.objectrepositoryutility.CreatingOpportunityPage;
import com.crm.tp.objectrepositoryutility.HomePage;
import com.crm.tp.objectrepositoryutility.OpportunitiesPage;
import com.crm.tp.objectrepositoryutility.OpportunityInformationPage;

public class CreateOpportunityTest extends BaseClass{
	@Test
	public void createOpportunityTest() throws EncryptedDocumentException, IOException {
		String opportunityName=elib.getTestDataFromExcel("Sheet1", 1, 2)+jlib.getRandomNumber();
		String OrgName=elib.getTestDataFromExcel("orgName", 1, 2)+jlib.getRandomNumber();
		HomePage hp =new HomePage(driver);
		hp.getOpportunitylink().click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getOpportunitylookupimg().click();
        CreatingOpportunityPage cop = new CreatingOpportunityPage(driver);
        cop.createOpportunity(opportunityName, OrgName);
        OpportunityInformationPage oip = new OpportunityInformationPage(driver);
        String actOpportunity=oip.getHeaderTextDD().getText();
	     if(actOpportunity.equals(opportunityName)) {
	    	 System.out.println(actOpportunity+"information ====>Pass");
	     }
	     else {
	    	 System.out.println(actOpportunity+"information ====>Fail");
	     }
	}

}
