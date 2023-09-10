package org.simpleprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicFunctions {
	static WebDriver driver;
	
	public static void main(String[]args) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://greenstech.in/selenium-course-content.html");
		
		Actions a = new Actions(driver);
		
		WebElement crs = driver.findElement(By.xpath("//div[@title='Courses']"));
		a.moveToElement(crs).perform();
		
		WebElement datasci = driver.findElement(By.xpath("//div[@title='Data Science']"));
		a.moveToElement(datasci).perform();
		
		WebElement datass = driver.findElement(By.xpath("//span[text()='Data Science with R Certification Training']"));
		datass.click();
		
	}
}
