/*importing  packages */

package stepDefinitions;

import org.openqa.selenium.WebDriver;
import RMPages.*;
import factory.DriverManager;
import io.cucumber.java.en.And;

public class CondoMaintenanceStepDefs {
	
	/* creation of object for web driver */
	WebDriver driver = DriverManager.getdriver();
	
	/* creation of object for RMLogin page */
	RMLoginPage loginPage = new RMLoginPage(driver);
	
	/* creation of object for Condo maintainence */
	CondoMaintenance cmPage = new CondoMaintenance(driver);
	
	/*Nullifying condoID */
	public String condoID = null;
	public String condoComm = null;

	@And("user clicks on {string} tab")
	public void user_clicks_on_tab(String tabName) {
		loginPage.clickOnMenu(tabName);
	}

	@And("user clicks on {string} button")
	public void user_clicks_on_button(String text) {
		cmPage.clickOnButtonWithText(text);
	}
	
	@And("user enter code in {string}")
	public void user_enter_code_in(String code) {
		// storing the condo code value in the string condoID
		condoID = cmPage.enterCondoCode(code);
	}


	@And("user enter description in {string}")
	public void user_enter_description_in(String description) {
		cmPage.enterCondoDescription(description);
	}

	@And("user enter phase in {string}")
	public void user_enter_phase_in(String phase) {
		cmPage.enterPhase(phase);
	}

	@And("user selects {string} from area code dropdown")
	public void user_selects_from_area_code_dropdown(String value) throws Exception {
		cmPage.clickAreaCOdeDD(value);
	}

	@And("user enter town in {string}")
	public void user_enter_town_in(String town) {
		cmPage.enterTownCode(town);
	}

	@And("user enter direction in {string}")
	public void user_enter_direction_in(String tdirection) {
		cmPage.enterTownDirection(tdirection);
	}

	@And("user enter range in {string}")
	public void user_enter_range_in(String range) {
		cmPage.enterRange(range);
	}

	@And("user enter rangedirection in {string}")
	public void user_enter_rangedirection_in(String rdirection) {
		cmPage.enterRangeDirection(rdirection);
	}

	@And("user enter liber in {string}")
	public void user_enter_liber_in(String liber) {
		cmPage.enterLiber(liber);
	}
	
	@And("user selects active checkbox")
	public void clickOnActiveCheckboxOption() {
		cmPage.clickOnActiveCheckBox();
	}

	@And("user enter page in {string}")
	public void user_enter_page_in(String page) {
		cmPage.enterPage(page);
	}
	
	@And("user verified the success message {string}")
	public void verifyMessage(String message)throws Exception {
		cmPage.verifySuccessMessage(message);
//		Thread.sleep(200000);
	}
	
	@And("user enter Id in Condo Maintenance ID Filter Input field")
	public void user_enter_id_in_condo_maintenance_id_filter_input_field() {
		cmPage.searchForCOndoID(condoID);
	}

	@And("user clicks on condo ID link")
	public void user_clicks_on_condo_id() {
	    cmPage.clickOnCondoIDLink(condoID);
	}
	
	@And("verify {string} is displayed")
	public void verify_is_displayed_in_history(String text)throws Exception {
	    cmPage.verifyDataInHistoryTab(text);
	    System.out.println("User verified data : "+text);
	}
	
	@And("user clicks on {string} tab in condo")
	public void user_clicks_on_tab_in_condo(String tabName) throws Exception {
		cmPage.clickOnCondoRecordTab(tabName);
	}
	/**
	*/
	
	@And("user enter comments")
	public void user_enter_comments() {
		condoComm = cmPage.enterCondoComments();
	}
	
	@And("verify comments is displayed in comment section")
	public void verify_is_displayed_in_comment_section() throws Exception {
		cmPage.verifyDataInCommentTab(condoComm);
	}
	
	@And("verify the edit delete buttons displayed in comments section")
	public void verifyButtonsInCOmmentSection() {
		cmPage.verifyEditDeleteButtonDisplayed();
		System.out.println("User verified edit and delete buttons");
	}
	@And("user clicks on edit icon")
	public void user_clicks_on_edit_icon() {
	    cmPage.clickOnEditButton();
	}

	@And("user clicks on delete icon")
	public void user_clicks_on_delete_icon() {
	    cmPage.clickOnDeleteButton();
	}

	
	
	
	

}
