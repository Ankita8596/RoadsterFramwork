package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganization {
	WebDriver driver;
	public CreatingNewOrganization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement OrgNameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameInfo;
	
	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}

	public WebElement getOrgNameEdit() {
		return OrgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName) {
		OrgNameEdit.sendKeys(orgName);
		saveBtn.click();
	}
}
