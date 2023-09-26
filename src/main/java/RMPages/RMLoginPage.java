package RMPages;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.SeleniumHelper;


public class RMLoginPage {

	SeleniumHelper helper ;
	ConfigReader config;
	
	public RMLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		helper = new SeleniumHelper(driver);
		 config = ConfigFactory.create(ConfigReader.class);
	}
	
	private static String menuLocator = "//div[contains(text(),'%s')]";
	
	public void clickOnMenu(String menuName) {
		
		helper.waitForElement(helper.pageLocatory(menuLocator,menuName), (config.timeout()));
		helper.pageLocatory(menuLocator,menuName).click();
	}
	
	
	
}
