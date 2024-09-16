package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	WebDriver drriver;
	public OpportunityInformationPage(WebDriver driver) {
		this.drriver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="dtlview_Opportunity Name")
	private WebElement opportunityHeaderTxt;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerTextDD;
	public WebElement getOpportunityHeaderTxt() {
		return opportunityHeaderTxt;
	}
		public WebElement getHeaderTextDD() {
		return headerTextDD;
	}
}
