package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.SeleniumDriverManager;
/**
 * 
 * @author marco llano
 *
 */
public class MainBoardPage {
	WebDriver driver;
	WebDriverWait wait;	
	By saveUserStoryButtonLocator = By.xpath(".//*[@id='createUS']");
	By addUserStoryButtonLocator = By.xpath(".//*[@id='newUserStory_link']");
	By userStoryTitleLocator = By.xpath(".//*[@id='us-title']");
	By getUserStoryFromIceBoxLocator = By.xpath(".//*[@id='icebox']/div/div/div/div");
	By targetBacklogFromIceboxLocator = By.xpath(".//*[@id='backlog']");
	By getUserStoryFromBacklogLocator = By.xpath("//div[@id='backlog']/div/div/div/div");
	By targetIceboxFromBacklogLocator = By.xpath(".//*[@id='icebox']");
	By userStoryFromIceboxLocator = By.xpath(".//*[@id='icebox']/div/div/div/div/div[3]");
	By userStoryFromBacklogLocator = By.xpath(".//*[@id='backlog']/div/div/div/div/div[3]");	
	By deleteUserStoryButtonInBacklogLocator = By.xpath("//div[2]/div/div/div/div/div[2]/div/div/form/div[2]");
	By popupYesButtonLocator = By.xpath("//li/div/div[2]/button[1]");
	By dashboardButtonInMainboard = By.xpath("html/body/div[1]/section[1]/div[1]/div/div[2]/div/a");
	By expandUserStoryInBacklogButtonLocator = By.xpath("//div/div/div[2]/div/div/div/div/div/div/span");
	By expandUserStoryInIceboxButtonLocator = By.xpath("//div/div/div[2]/div/div/div/div/div/div/span");
	By taskFieldInUserStoryLocator = By.xpath("//div/div/div/textarea");
	By clickAddTaskButtonLocator = By.xpath("(//button[@type='button'])[4]");
	
	public MainBoardPage(){
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	}
	public void createNewUserStory(String userStoryTitle){
		wait.until(ExpectedConditions.visibilityOfElementLocated(addUserStoryButtonLocator));
		clickAddStoryButton();
		setUserStoryTitle(userStoryTitle);
		clickSaveUserStoryButton();
	}
	public void setTaskForUserStory(String tasks){
		wait.until(ExpectedConditions.visibilityOfElementLocated(addUserStoryButtonLocator));
		driver.findElement(taskFieldInUserStoryLocator).sendKeys(tasks);
	}	
	public void clickAddTaskButton(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickAddTaskButtonLocator));
		driver.findElement(clickAddTaskButtonLocator).click();
	}	
	public void clickSaveUserStoryButton(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveUserStoryButtonLocator));
		driver.findElement(saveUserStoryButtonLocator).click();
	}
	public void clickAddStoryButton(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(addUserStoryButtonLocator));
		driver.findElement(addUserStoryButtonLocator).click();
	}	
	public void setUserStoryTitle(String userStoryTitle){
		wait.until(ExpectedConditions.visibilityOfElementLocated(userStoryTitleLocator));
		driver.findElement(userStoryTitleLocator).sendKeys(userStoryTitle);
	}
	public void deleteStoryFromIcebox(){
		clickExpandUserStoryButtonInIcebox();
		clickDeleteUserStoryButton();
		clickYesPopupButton();
	}
	public void deleteStoryFromBacklog(){
		clickExpandUserStoryButtonInIcebox();
		clickDeleteUserStoryButton();
		clickYesPopupButton();
	}
	public void clickExpandUserStoryButtonInBacklog(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(expandUserStoryInBacklogButtonLocator));
		driver.findElement(expandUserStoryInBacklogButtonLocator).click();
	}
	public void clickDeleteUserStoryButton(){
		driver.findElement(deleteUserStoryButtonInBacklogLocator).click();
	}	
	public void clickExpandUserStoryButtonInIcebox(){
		driver.findElement(expandUserStoryInIceboxButtonLocator).click();
	}
	public void clickYesPopupButton(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(popupYesButtonLocator));
		driver.findElement(popupYesButtonLocator).click();
	}
	
	public void moveUserStoryFromIceboxToBacklog(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(getUserStoryFromIceBoxLocator));
		(new Actions(driver)).dragAndDrop(driver.findElement(getUserStoryFromIceBoxLocator), 
			                  driver.findElement(targetBacklogFromIceboxLocator)).perform();
		}

	public void moveUserStoryFromBackLogToIcebox(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(getUserStoryFromBacklogLocator));
		(new Actions(driver)).dragAndDrop(driver.findElement(getUserStoryFromBacklogLocator), 
			                  driver.findElement(targetIceboxFromBacklogLocator)).perform();
		}
	public DashboardPage clickDashboardButtonInMainboard(){
		driver.findElement(dashboardButtonInMainboard).click();
		return new DashboardPage();
	}
	//get User Story from panel

	public String getUserStoryFromIcebox(){
		String UserStoryFromIcebox = driver.findElement(userStoryFromIceboxLocator).getText();
		return UserStoryFromIcebox;
	}
	public String getUserStoryFromBacklog(){
		String firstUsFromBacklog = driver.findElement(userStoryFromBacklogLocator).getText();
		return firstUsFromBacklog;
	}
	public String getTasksFromUserStory(){
		By storedTasksInUserStory = By.xpath("//div[7]/div/div[1]/div/div/div/div/div/div/div[1]/div/div");
		return driver.findElement(storedTasksInUserStory).getText();
	}
}
