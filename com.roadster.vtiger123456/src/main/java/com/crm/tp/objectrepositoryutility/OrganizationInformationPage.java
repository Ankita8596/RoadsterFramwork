package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgInfoheadertxt;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrgTxtInfo;
	
	public WebElement getOrgInfoheadertxt() {
		return OrgInfoheadertxt;
	}

	
	public WebElement getOrgTxtInfo() {
		return OrgTxtInfo;
	}


}
