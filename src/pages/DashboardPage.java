package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.SeleniumDriverManager;
/**
 * 
 * @author marco llano
 *
 */
public class DashboardPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By emailInDashboardNameLocator = By.xpath("//ul/span[@title='email']");
	By createNewProjectButtonLocator = By.xpath("html/body/div[1]/section/div/div/div/div/div[1]/div[2]/button");
	By deleteCreatedProjectLocator = By.xpath("html/body/div[1]/section/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/div/a");
	By buttonYesPopupLocator = By.xpath(".//*[@id='button-0']");
	
	public DashboardPage(){
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	}
	public CreateNewProjectPage clickNewProjectButton(String title){	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(createNewProjectButtonLocator));
		driver.findElement(createNewProjectButtonLocator).click();;
		return new CreateNewProjectPage(title);
	}
	public void deleteCreatedProject(){
		clickDeleteCreatedProject();
		clickPopupYesButton();
	}
	public void clickDeleteCreatedProject(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(createNewProjectButtonLocator));
		driver.findElement(deleteCreatedProjectLocator).click();
	}
	public void clickPopupYesButton(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonYesPopupLocator));
		driver.findElement(buttonYesPopupLocator).click();
	}
}
