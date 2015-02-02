package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.SeleniumDriverManager;
/**
 * 
 * @author marco llano
 * This is the page where users need to pass alwais to login JAT
 */
public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;	
	By emailFieldLocator = By.xpath("//input[@type='text']");
	By passwordFieldLocator = By.xpath("//input[@type='password']");
	By signInButtonLocator = By.xpath("//input[@value='Sign in']");
	By displayLogoutButtonLocator = By.xpath("//div/span");
	By logoutButtonLocator = By.xpath("//a[contains(text(),'Logout')]");
	
	public LoginPage(){
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
		driver.get("http://172.20.8.22:3001/#/signin");
	}
	public void logoutJAT(){
		clickDisplayLogoutButton();
		clickOnLogoutButton();
		driver.quit();
	}
	public DashboardPage loginJAT(String email,String password){
		setEmailAddress(email);
		setEmailPassword(password);				
		return clickSignInButton();
	}
	public void setEmailAddress(String email){
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
		driver.findElement(emailFieldLocator).clear();
		driver.findElement(emailFieldLocator).sendKeys(email);
	}
	public void setEmailPassword(String password){
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
		driver.findElement(passwordFieldLocator).clear();
		driver.findElement(passwordFieldLocator).sendKeys(password);
	}
	public DashboardPage clickSignInButton(){
		driver.findElement(signInButtonLocator).click();
		return new DashboardPage();
	}
	public void clickDisplayLogoutButton(){
		driver.findElement(displayLogoutButtonLocator).click();		
	}
	public DashboardPage clickOnLogoutButton(){
		driver.findElement(logoutButtonLocator).click();
		SeleniumDriverManager.getManager().quitDriver();
		return new DashboardPage();
	}
}
