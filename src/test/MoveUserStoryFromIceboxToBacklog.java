package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.MainBoardPage;
/**
 * 
 * @author marco llano
 *
 */
public class MoveUserStoryFromIceboxToBacklog {
	DashboardPage dashBoard = new DashboardPage();
	MainBoardPage mainBoard = new MainBoardPage();
	String userStoryTitle="automationTest";
	/**
	 * Verify that a user story is able to move from Icebox to Backlog
	 */
  @Test
  public void verifyDragAndDropIceboxToBacklog() {
		mainBoard.moveUserStoryFromIceboxToBacklog();
		String actualFirstUsFromBacklog = mainBoard.getUserStoryFromBacklog();
		Assert.assertEquals(userStoryTitle, actualFirstUsFromBacklog);
  }
  @BeforeMethod
  public void beforeMethod(){
	  mainBoard.createNewUserStory(userStoryTitle);
  }

  @AfterMethod
  public void afterTest() {
	  mainBoard.deleteStoryFromBacklog();
  }

}
