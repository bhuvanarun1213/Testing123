package org.testing1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	static WebDriver driver;
	@Parameters("browser")
	public static void browserLauch(String browsername) {
		if(browsername.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		}
		else if(browsername.equals("Ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	

	}
	
	public static void launchUrl(String url) {
		driver.get(url);

	}
	public static void maxmizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;
		
	}
	
	public static void fillTheTextBox(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	
	public static void btnClick(WebElement ele) {
		ele.click();
	}
	
	public static void takeScreenShot() throws IOException {
		TakesScreenshot tk =(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\arunk\\eclipse-workspace\\ForCheckingKnowledge\\screenshots\\SS001.png");
		FileUtils.copyFile(src, des);
	}
	
	public static void actions() {
		Actions act = new Actions(driver);
		
	}
	
	public static void robot() throws AWTException {
		Robot rob = new Robot();
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	
	
	
}