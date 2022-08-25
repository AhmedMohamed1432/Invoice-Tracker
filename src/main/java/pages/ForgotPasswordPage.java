package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends PageBase 
{

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath  = "/html/body/div/div[1]/form/div[1]/input") 
	WebElement EmailTxtBox;
	@FindBy(xpath = "/html/body/div/div[1]/form/div[2]/input") 
	WebElement sendEmailBtn;
	@FindBy(linkText = "Back To Login") 
	WebElement BackBtn;
	
	public void SendEmail(String email ) 
	
	{
		clearText(EmailTxtBox);;
		setTextElementText(EmailTxtBox, email);
		clickButton(sendEmailBtn);
	}
	public void GoBack() {
		clickButton(BackBtn);
		
	}

}
