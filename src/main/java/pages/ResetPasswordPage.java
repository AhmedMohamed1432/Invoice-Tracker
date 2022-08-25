package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends PageBase {

	public ResetPasswordPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = ".......") 
	WebElement PasswordTxtBox;
	@FindBy(id = ".......") 
	WebElement ConfirmPasswordTxtBox;
	@FindBy(id = ".......") 
	WebElement ResetBtn;
	
	public void ResetPass(String Password, String confirmpassword ) 
	{
		PasswordTxtBox.clear();
		ConfirmPasswordTxtBox.clear();
		setTextElementText(PasswordTxtBox, Password);
		setTextElementText(ConfirmPasswordTxtBox, confirmpassword);
		clickButton(ResetBtn);
	}
	
}

