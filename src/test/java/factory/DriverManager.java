package factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
	
	public static WebDriver getdriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
		
	}
	
	public static void unload() {
		dr.remove();		
	}
	
	
	public static void initDriver(String browser) {
		DriverManager.setDriver(DriverFactory.getBrowser(browser));
	}

}
