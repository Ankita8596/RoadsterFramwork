package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactlink;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitylink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Organizations")
	private WebElement OrgLink;

	public WebElement getOrgLink() {
		return OrgLink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getOpportunitylink() {
		return opportunitylink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public void logoutToTheApplication() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutLink.click();
		
	}

}
