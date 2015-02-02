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
public class MoveUserStoryFromBacklogToIcebox {
	DashboardPage dashBoard = new DashboardPage();
	MainBoardPage mainBoard = new MainBoardPage();
	String userStoryTitle="automationTest";
/**
 * Verify that a user story is able to move from Backlog to Icebox panel
 */
	@Test
	public void verifyDragAndDropBacklogToIcebox(){		
		mainBoard.moveUserStoryFromBackLogToIcebox();
		String actualFirstUsFromIcebox = mainBoard.getUserStoryFromIcebox();

		Assert.assertEquals(userStoryTitle, actualFirstUsFromIcebox);
	}
	@BeforeMethod
	public void beforeTest(){
		mainBoard.createNewUserStory(userStoryTitle);
		mainBoard.moveUserStoryFromIceboxToBacklog();
	}
	
	@AfterMethod
	public void afterTest() {
		mainBoard.deleteStoryFromIcebox();		
	}	
}
