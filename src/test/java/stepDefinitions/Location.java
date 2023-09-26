package stepDefinitions;

import org.openqa.selenium.WebDriver;
import RMPages.RMLoginPage;
import factory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Location {
	
	WebDriver driver;
	RMLoginPage loginPage;
	
	@And("user clicks on the {string} tab")
	public void user_clicks_on_the_location_tab(String tabName) {
		loginPage = new RMLoginPage(driver);
		loginPage.clickOnMenu(tabName);
		loginPage.clickOnMenu(tabName);
		loginPage.clickOnMenu(tabName);
	}
	
	

}
