package com.crm.tp.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.tp.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContactPage {
	WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name = "lastname")
	private WebElement lastnameText;
	@FindBy(name = "search_text")
	private WebElement searchText;
	@FindBy(name = "search_field")
	private WebElement searchtextDD;
	@FindBy(name = "search")
	private WebElement searchBtnOrg;
	/**
	 * Identify element of report to textfield
	 */
	@FindBy(xpath="//input[@name='contact_name']/ancestor::td[@class='dvtCellInfo']/descendant::img")
	private WebElement reporttoLookup;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchtxtfield;
	@FindBy(name = "search_field")
	private WebElement searchContactText;
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;
	@FindBy(name = "support_end_date")
	private WebElement supportDate;
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement LookupImg;
	@FindBy(name="contact_name")
	private WebElement reportsToEdit;
	@FindBy(id="search_txt")
	private WebElement reportsSearchEdit;

	public WebElement getReportsSearchEdit() {
		return reportsSearchEdit;
	}
	public WebElement getReportsToEdit() {
		return reportsToEdit;
	}
	public WebElement getLookupImg() {
		return LookupImg;
	}

	public WebElement getLastnameText() {
		return lastnameText;
	}

	public WebElement getSearchDD() {
		return searchText;
	}

	public WebElement getSearchtextDD() {
		return searchtextDD;
	}

	public WebElement getSearchBtnOrg() {
		return searchBtnOrg;
	}

	public WebElement getSearchtxtfield() {
		return searchtxtfield;
	}
	public WebElement getReporttoLookup() {
		return reporttoLookup;
	}

	public WebElement getSearchContactText() {
		return searchContactText;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportDate() {
		return supportDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContactWithLastname(String lastname) {
		lastnameText.sendKeys(lastname);
		saveBtn.click();

	}

	public void createContactWithOrg(String lastname, String orgName) {
		lastnameText.sendKeys(lastname);
		LookupImg.click();
		wlib.switchChildToBrowser(driver, "module=Accounts&action");
		searchtextDD.click();
		searchText.sendKeys(orgName);
		searchBtnOrg.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wlib.switchToTheParentBrowser(driver, "module=Contacts&action");
		saveBtn.click();

	}
	public void createContactWithReportTo(String lastname) throws InterruptedException {
	    lastnameText.sendKeys(lastname);
		reporttoLookup.click();
		wlib.switchChildToBrowser(driver, "Popup_picker&popuptype=specific&form");
		searchContactText.click();
		searchtxtfield.sendKeys(lastname);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()=' "+lastname+"']")).click();
		wlib.switchToTheParentBrowser(driver, "return_action=DetailView&parenttab=Marketing");
		Thread.sleep(2000);
		saveBtn.click();
	}
}
