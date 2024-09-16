package com.crm.tp.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.tp.generic.fileutility.ExcelUtility;
import com.crm.tp.generic.fileutility.FileUtility;
import com.crm.tp.generic.webdriverutility.JavaUtility;
import com.crm.tp.generic.webdriverutility.WebDriverUtility;
import com.crm.tp.objectrepositoryutility.HomePage;
import com.crm.tp.objectrepositoryutility.LoginPage;



public class BaseClass {
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public  WebDriver driver = null;
	public static WebDriver sdriver=null;
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("==Connect to db, report config==");
	}
	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("==Launch the browser==");
	    String BROWSER=flib.getCommonDataFromPropertiesFile("browser");
		//String BROWSER=System.getProperty("browser", flib.getDataFromProertyFile("browser"));
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("==login to application==");
		String URL = flib.getCommonDataFromPropertiesFile("url");
		String USERNAME = flib.getCommonDataFromPropertiesFile("username");
		String PASSWORD = flib.getCommonDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginTotheapp(URL, USERNAME, PASSWORD);
	}
	@AfterMethod
	public void configAfterMethod() {
		System.out.println("==Logout from browser==");
		HomePage hp = new HomePage(driver);
		hp.logoutToTheApplication();
	}

	@AfterClass

	public void configAC() {
		System.out.println("==close the browser==");
		driver.quit();
	}


	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("==Close dB report backup==");
	}

}



