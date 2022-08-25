package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase 
{

	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(id=":r0:")
	WebElement emailTxtBox ; 

	@FindBy(id=":r1:")
	WebElement passwordTxtBox ; 

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[2]/div/form/div[4]/button") // sign in button
	WebElement loginBtn ; 
	
	@FindBy(linkText = "Forgot your password?" )  // forgot password button
	WebElement forgotpassBtn ; 

	
	public void UserLogin(String email , String password) 
	{
		clearText(emailTxtBox);
		clearText(passwordTxtBox);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);

		clickButton(loginBtn);
	}
	public void Forgotpass() 
	{	
		clickButton(forgotpassBtn);
	}
}
