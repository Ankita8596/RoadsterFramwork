package com.crm.tp.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.tp.baseutility.BaseClass;
import com.crm.tp.objectrepositoryutility.ContactInformationPage;
import com.crm.tp.objectrepositoryutility.ContactsPage;
import com.crm.tp.objectrepositoryutility.CreatingNewContactPage;
import com.crm.tp.objectrepositoryutility.CreatingNewOrganization;
import com.crm.tp.objectrepositoryutility.HomePage;
import com.crm.tp.objectrepositoryutility.OrganizationInformationPage;
import com.crm.tp.objectrepositoryutility.OrganizationPage;

public class CreateContactTest extends BaseClass {
	/*
	 * Creating the contact with lastname
	 */
	@Test(groups="smokeTest")
	public void createContact() throws Throwable {

		String lastName = elib.getTestDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getImglookuplink().click();
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithLastname(lastName);
		// verify contact name with expected result
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actlastname = cip.getHeadertxt().getText();
		boolean status = actlastname.contains(lastName);
		Assert.assertEquals(status, true);

	}

	/*
	 * TestCaseName:Creating the contact with organization.
	 */
	@Test
	public void createContactWithOrgTest() throws Throwable, IOException {
		String orgName = elib.getTestDataFromExcel("orgName", 1, 2) + jlib.getRandomNumber();
		String contactLastname = elib.getTestDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrglink().click();
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		cno.getOrgNameEdit();
		cno.createOrg(orgName);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actorgName = oip.getOrgInfoheadertxt().getText();
		hp.getContactlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getImglookuplink().click();
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactWithOrg(contactLastname, orgName);
		ContactInformationPage cip = new ContactInformationPage(driver);
		actorgName = cip.getContactInfo().getText();
		boolean Status = actorgName.contains(contactLastname);
		Assert.assertEquals(Status, true);
		String actOrgName = oip.getOrgTxtInfo().getText();
		boolean Status1 = actOrgName.contains(orgName);
		Assert.assertEquals(Status1, true);
	}

	@Test
	public void createContactWithReportsToTest() throws Throwable, IOException {
		String lastName = elib.getTestDataFromExcel("contact", 1, 2) +jlib.getRandomNumber();
		//String ContactName = elib.getTestDataFromExcel("contact", 1, 2) +jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getImglookuplink().click();
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactWithLastname(lastName);	
		//click on contact link for reports to textfield
		hp.getContactlink().click();
		cp.getImglookuplink().click();
		cncp.createContactWithReportTo(lastName);
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actLastname = cip.getReportsToInfo().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actLastname, true);
	}
}