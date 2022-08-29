package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class ForgetPasswordPageTest extends TestBase{
	
	LoginPage loginObject ; 
	ForgotPasswordPage ForgetPasswordOpject;
	
	@BeforeTest()
	public void openForgetPasswordPage() throws InterruptedException {
		loginObject = new LoginPage(driver); 
		loginObject.Forgotpass();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void UserEnterInvalidEmail() throws InterruptedException {
		ForgetPasswordOpject = new ForgotPasswordPage(driver);
		ForgetPasswordOpject.SendEmail("wrong@gmail.com");  // wrong Email
		Thread.sleep(1000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div[2]")); //  message id
		String messageString = MessageString.getText();
		//String actualMessage= "If the Entered Email is valied a reset password mail will be sent shotly.";
		String actualMessage= "We sent you an email";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	@Test(priority = 1)
	public void UserEnterblankEmail() throws InterruptedException {
		ForgetPasswordOpject = new ForgotPasswordPage(driver);
		ForgetPasswordOpject.SendEmail("");  // blank Email
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[1]/form/div[1]/p")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Please Enter a Valid Email";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 3)
	public void UserEnterCorrectEmail() throws InterruptedException {
		ForgetPasswordOpject = new ForgotPasswordPage(driver);
		ForgetPasswordOpject.SendEmail("boogado@yahoo.com");  // Correct Email
		Thread.sleep(1000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div[2]")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "We sent you an email";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
		
	}
	@Test(priority = 4)
	public void UserGoBackToLogin() throws InterruptedException {
		ForgetPasswordOpject = new ForgotPasswordPage(driver);
		ForgetPasswordOpject.GoBack();
		Thread.sleep(2000);
		String actualUrlString = "https://invoice-tracker-frontend.herokuapp.com/login";  // Profile page link
		String foundUrlString = driver.getCurrentUrl();		
		Assert.assertEquals( actualUrlString, foundUrlString);
		Thread.sleep(2000);
		
		
		
	}

}
