package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.DashboardPage;
import pages.LoginPage;
/**
 * 
 * @author marco llano
 *
 */
public class featureSuiteSetup {
	LoginPage login = new LoginPage();
	DashboardPage dashboard = new DashboardPage();

	@BeforeSuite
	public void beforeSuite() {
		String email = "Marco.Llano@fundacion-jala.org";
		String password = "369xlbuj25";
		String title="automationTest";		
		login.loginJAT(email,password);
		dashboard.clickNewProjectButton(title);
	}
	@AfterSuite
	public void afterSuite() {	
		dashboard.deleteCreatedProject();
		login.logoutJAT();
	}

}
