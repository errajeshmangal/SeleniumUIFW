package utils;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumHelper {

	WebDriver driver;

	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	public void typeTextElement(WebElement element, String textToBeEntered, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeEntered);
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public WebElement pageLocatory(String locator, String name)

	{
		return driver.findElement(By.xpath(String.format(locator, name)));

	}
	
	public String selectOptionFromDropdown(By by , long durationInSeconds) {
		WebElement webElement = waitForElement(driver.findElement(by), durationInSeconds);
		String dropdownOption = "//*[contains(text(),'%s')]";
		String data = null;
		try { 		
 		
		List<String> options = driver.findElements(by).stream().map(str -> str.getText()).filter(text -> !text.contains("Please select")).filter(text -> !text.isBlank()).toList();	
//			options.stream().forEach(str -> arrayList.add(!str.getText().equals("Please select")));
		System.out.println("data on options in helper "+options);
			data = options.get(new Random().nextInt(options.size()));
			System.out.println("data on method "+data);
			//to scroll for dropdown option
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", pageLocatory(dropdownOption, data) );
			Thread.sleep(250);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}
	
	
	
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	public void scrollToElement(WebElement element)

	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		try
		{
			je.executeScript("argument[0].scrollIntoView(true);",element);
		}
		catch(Exception e)
		{
			je.executeScript("argument[0].scrollIntoView(true);",element);
		}
	}
	
	public void refreshWebPage() {
		driver.navigate().refresh();
	}
}
