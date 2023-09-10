package org.testing1;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager; 

public class EmailPageLogin extends BaseClass{
	@BeforeClass
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
			launchUrl("https://www.google.com/");

		}
		
	
	

	@Test
	private void tc1() throws AWTException, IOException {
		getTitle();
		currentUrl();
		WebElement textemail = driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']"));
		fillTheTextBox(textemail, "gmail");
		robot();
		takeScreenShot();
		driver.navigate().to("https://www.google.com/search?q=gmail+&sca_esv=563286194&sxsrf=AB5stBg2fe4MLp4LnpEDlwGoksPpPwWGUg%3A1694058376107&source=hp&ei=iEf5ZNuWBMH3wAPhu5awAg&iflsig=AD69kcEAAAAAZPlVmD7MgGPbo-dj7k5NNEpbRX1da0iX&ved=0ahUKEwjb-u-dy5eBAxXBO3AKHeGdBSYQ4dUDCAk&uact=5&oq=gmail+&gs_lp=Egdnd3Mtd2l6IgZnbWFpbCAyBxAjGIoFGCcyBxAjGIoFGCcyCxAAGIoFGLEDGJECMggQABiABBixAzIIEAAYgAQYsQMyCBAAGIAEGLEDMggQABiABBixAzILEAAYgAQYsQMYgwEyCxAAGIAEGLEDGIMBMgUQABiABEjV-qUBUMGXX1jJmWBwA3gAkAEAmAGmAqABmQuqAQUwLjIuNLgBA8gBAPgBAagCCsICBxAjGOoCGCfCAg0QLhjHARivARjqAhgnwgIREC4YgAQYsQMYgwEYxwEY0QPCAgUQLhiABA&sclient=gws-wiz");
		
	
	
		WebElement clickemail = driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
		clickemail.click();

	}
	@AfterClass
	private void afterClass() throws IOException {
		takeScreenShot();
		closeBrowser();
		

	}
	

}
