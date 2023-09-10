package org.testing1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass{
	
	public PojoClass() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Email")
	private WebElement txtEmail;
	
	@FindBy(name="pass")
	private WebElement txtpass;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

}
