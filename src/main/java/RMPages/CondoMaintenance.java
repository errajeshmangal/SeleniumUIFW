//Importing packages

package RMPages;
import utils.FakerHelper;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import utils.ConfigReader;
import utils.SeleniumHelper;

public class CondoMaintenance {
	SeleniumHelper helper;
	ConfigReader config;
	
	
	//locating the elements using page factory

	@FindBy(xpath = "//*[@aria-label = 'Condo Maintenance ID Filter Input']")
	WebElement condoIDSearchFilter;
	
	@FindBy(xpath = "//*[contains(@role,'combobox')]")
	WebElement areaCodeDD;
	
	@FindBy(xpath = "//input[@type='checkbox']//parent::div")
	WebElement activeCheck;
	
	@FindBy(xpath = "//*[@aria-label = 'Condo Maintenance ID Filter Input']")
	WebElement condoIDSearchbox;
	
	@FindBy(xpath = "//textarea[@id='comment']")
	WebElement commentSection;
	
	@FindBy(xpath = "//mat-icon[@data-mat-icon-name='app-edit']//parent::button")
	WebElement commentsEditButton;
	
	@FindBy(xpath = "//mat-icon[@data-mat-icon-name='app-delete']//parent::button")
	WebElement commentsDeleteButton;
	
	
	//locating the element by passing as By
	
	private static By options = By.xpath("//div[@role = 'listbox']//mat-option");
	
	
	//locating the elements by passing dynamic values
	

	public WebElement condoLink(String ID) {
		return helper.getElement("//a[text()='" + ID + "']");
	}

	public WebElement elementWithText(String text) {
		return helper.getElement("//*[contains(text(),'" + text + "')]");
	}
	
	public WebElement elementWithID(String id) {
		return helper.getElement("//input[@id='" + id + "']");
	}

	public WebElement condoRecordPanel(String text) {
		return helper.getElement("//*[contains(text(),'" + text + "')]");
	}

	/* Creating constructor and calling the objects */
	public CondoMaintenance(WebDriver driver) {
		PageFactory.initElements(driver, this);
		helper = new SeleniumHelper(driver);
		config = ConfigFactory.create(ConfigReader.class);

	}

	public String enterCondoCode(String id) {
		String idNumber = FakerHelper.getUserId();
		/* Entering the text to data field */
		helper.typeTextElement(elementWithID(id), idNumber, (config.timeout()));
		// returning the idNumber for further verification as we are taking it from faker
		return idNumber;
	}

	public void enterCondoDescription(String description) {
		String condoDescription = FakerHelper.getDescription();
		helper.typeTextElement(elementWithID(description), condoDescription, (config.timeout()));
	}

	public void enterPhase(String condoPhase) {
		String phase = FakerHelper.getRandomNumber();
		helper.typeTextElement(elementWithID(condoPhase), phase, (config.timeout()));
	}

	public void enterTownCode(String tCode) {
		String code = FakerHelper.getUserId();
		helper.typeTextElement(elementWithID(tCode), code, (config.timeout()));
	}

	public void clickAreaCOdeDD(String valueOfDD) throws Exception {
		helper.clickOnElement(areaCodeDD, (config.timeout()));
		Thread.sleep(3000);
		String option = helper.selectOptionFromDropdown(options, (config.timeout()));
		System.out.println("option value :"+option);
//		Thread.sleep(20000);
		helper.clickOnElement(elementWithText(option), (config.timeout()));
		
//		helper.pageLocatory(elementWithText, valueOfDD).click();
	}

	public void enterTownDirection(String tDirection) {
		String direction = FakerHelper.getDirection();
		helper.typeTextElement(elementWithID(tDirection), direction, (config.timeout()));
	}

	public void enterRange(String condoRange) {
		String range = FakerHelper.getUserId();
		helper.typeTextElement(elementWithID(condoRange), range, (config.timeout()));
	}

	public void enterRangeDirection(String condoRangeDirection) {
		String rdirection = FakerHelper.getUserId();
		helper.typeTextElement(elementWithID(condoRangeDirection), rdirection, (config.timeout()));
	}

	public void enterLiber(String condoLiber) {
		String liber = FakerHelper.getRandomShortDescription();
		helper.typeTextElement(elementWithID(condoLiber), liber, (config.timeout()));
	}

	public void enterPage(String condoPage) {
		String page = FakerHelper.getRandomShortDescription();
		helper.typeTextElement(elementWithID(condoPage), page, (config.timeout()));
	}

	public void clickOnActiveCheckBox() {
		helper.clickOnElement(activeCheck,(config.timeout()));
	}

	public void verifySuccessMessage(String message) throws Exception {
		Thread.sleep(2000);
		Assert.assertEquals(elementWithText(message).getText(), message);
		System.out.println("User verifies success message");
		Thread.sleep(10000);
	}


	/* To perform click action on a web element which can be identified through text */
	public void clickOnButtonWithText(String name) {
		helper.clickOnElement(elementWithText( name),(config.timeout()));
		System.out.println("User clicked on " + name + " button");
	}

	public void searchForCOndoID(String ID) {
		try {
			Thread.sleep(5000);
			helper.refreshWebPage();
			helper.waitForElement(condoIDSearchFilter, (config.timeout()));
			helper.typeTextElement(condoIDSearchFilter, ID, (config.timeout()));
			Assert.assertTrue(condoLink(ID).isDisplayed());
		} catch (Exception e) {
			System.out.println("page not loaded properly");
		}
	}

	public void clickOnCondoIDLink(String ID) {
		helper.waitForElement(condoLink(ID), (config.timeout()));
		helper.clickOnElement(condoLink(ID), (config.timeout()));
	}

	public void verifyDataInHistoryTab(String data) throws Exception {
		Thread.sleep(2000);
		helper.waitForElement(elementWithText(data), (config.timeout()));
		Assert.assertTrue(elementWithText(data).isDisplayed());
		System.out.println("User verified "+data+ "in condo history");
	}

	public void clickOnCondoRecordTab(String tabName) throws Exception {
//		helper.waitForElement(condoRecordPanel(tabName), (config.timeout()));
		helper.clickOnElement(condoRecordPanel(tabName), (config.timeout()));
		Thread.sleep(2000);
	}
	
	public String enterCondoComments() {
		String condoComment = FakerHelper.getDescription();
		helper.typeTextElement(commentSection, condoComment, (config.timeout()));
		return condoComment;
		
	}
	public void verifyDataInCommentTab(String comment) throws Exception {
		Assert.assertTrue(elementWithText(comment).isDisplayed());
		System.out.println("User verified "+comment+ "in condo comment");
	}
	
	public void verifyEditDeleteButtonDisplayed() {
		Assert.assertTrue(commentsEditButton.isDisplayed());
		Assert.assertTrue(commentsDeleteButton.isDisplayed());
	}
	
	public void clickOnEditButton() {
		helper.clickOnElement(commentsEditButton, (config.timeout()));
	}
	
	public void clickOnDeleteButton() {
		helper.clickOnElement(commentsDeleteButton, (config.timeout()));
	}

	

	
}
