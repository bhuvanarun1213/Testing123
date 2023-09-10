package org.testing1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.utils.DataUtils;

public class Dataproviders {

	//	@Parameters({"emailId"})
	@Test(dataProvider = "getData", 
			dataProviderClass = DataUtils.class)
	public void login(String data[]) throws InterruptedException {
		//		System.err.println("from parameters: "+id);
		System.err.println("Email: "+data[0]);
		System.err.println("Pass: "+data[1]);

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://letcode.in/");
		driver.findElementByLinkText("Log in").click();
		driver.findElementByName("email") .sendKeys(data[0]);
		driver.findElementByName("password").sendKeys(data[1]);
		Thread.sleep(2000);
		driver.findElementByXPath("//button[.='LOGIN']").click(); 
		String title =
				driver.getTitle();
		System.out.println("Title is "+title); driver.quit();

	}

}


