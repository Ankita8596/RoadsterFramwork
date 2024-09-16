package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	/**
	 * identify the elements of Contacts page and initialization the object using constructor
	 */
	WebDriver driver;
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement Imglookuplink;
	@FindBy(name="search_text")
	private WebElement searchtextfield;
	@FindBy(name="search_field")
	private WebElement searchfieldDD;
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public WebElement getImglookuplink() {
		return Imglookuplink;
	}
	public WebElement getSearchtextfield() {
		return searchtextfield;
	}
	public WebElement getSearchfieldDD() {
		return searchfieldDD;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	

}
