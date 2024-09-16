package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	/**
	 * Identify the elements of contact information Page 
	 */
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="dvHeaderText")
	private WebElement headertxt;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement headerStartDateInfo;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement headerEndDateMsgInfo;
	
	@FindBy(id="mouseArea_Reports To")
	private WebElement reportsToInfo;
	
	public WebElement getHeadertxt() {
		return headertxt;
	}
	public WebElement getReportsToInfo() {
		return reportsToInfo;
	}
	public WebElement getContactInfo() {
		return contactInfo;
	}
		public WebElement getHeaderStartDateInfo() {
		return headerStartDateInfo;
	}
	
	public WebElement getHeaderEndDateMsgInfo() {
		return headerEndDateMsgInfo;
	}
	
}
