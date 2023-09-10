package org.testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution {
	static WebDriver driver;
	@Parameters("browser")
	@Test
	public static  void parallel(String browsername) {
		
		if(browsername.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	
		
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
