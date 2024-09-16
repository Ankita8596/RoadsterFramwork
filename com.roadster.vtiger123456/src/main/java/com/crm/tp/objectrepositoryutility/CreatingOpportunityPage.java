package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.tp.generic.webdriverutility.WebDriverUtility;

public class CreatingOpportunityPage {
	WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver;
	public CreatingOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="potentialname")
	private WebElement potentialNameTxt;
	@FindBy(xpath="//select[@id='related_to_type']/parent::td[contains(.,'Related To')]/following-sibling::td[@class='dvtCellInfo']/img")
	private WebElement relatedTolookupimg;
	//@FindBy(xpath="//img[@alt='Select']")
	//private WebElement lookupImg;
	
	@FindBy(name="search_text")
	private WebElement searchtxtfield;
	
	@FindBy(name="related_to_display")
	private WebElement relatedToTxtField;
	@FindBy(id="related_to_type")
	private WebElement relatedTxtDD;
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getPotentialNameTxt() {
		return potentialNameTxt;
	}
	

	public WebElement getRelatedTxtDD() {
		return relatedTxtDD;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getRelatedToDD() {
		return relatedTolookupimg;
	}
	
	//public WebElement getLookupImg() {
		//return lookupImg;
	//}
	
	
	public WebElement getRelatedToTxtField() {
		return relatedToTxtField;
	}
	public WebElement getSearchtxtfield() {
		return searchtxtfield;
	}
	public void createOpportunity(String OpportunityName,String Orgname) {
		potentialNameTxt.sendKeys(OpportunityName);
		wlib.selectByvisbleText(relatedTxtDD, Orgname);
		relatedTolookupimg.click();
		wlib.switchChildToBrowser(driver, "module=Potentials&action");
		searchtxtfield.click();
		relatedToTxtField.sendKeys(Orgname);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='orgName']")).click();
		wlib.switchToTheParentBrowser(driver, "related_to&srcmodule=Potentials&forrecord");
		saveBtn.click();
		
	}
}
