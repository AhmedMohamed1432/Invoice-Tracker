
package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginObject ; 
	
	@Test (priority = 1) //TC_LOGIN_003
	public void UserLoginFailWrongEmail () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("wrong@gmail.com", "awad36148"); // Wrong Email , password
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div[2]")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Wrong email or password";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 4) //TC_LOGIN_004
	public void UserLoginFailWrongEmailWrongPass () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("wrong@gmail.com", "awad0118"); // Wrong Email , password
		Thread.sleep(1000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div[2]")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Wrong email or password";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	@Test (priority = 5) //TC_LOGIN_005
	public void UserLoginFailSpecialCharEmail () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("wrong#$@gmail.com", "awad36148"); // Wrong Email , password
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[2]/div/form/div[1]/p")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Invalid email address";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
	}
	@Test (priority = 6) //TC_LOGIN_006
	public void UserLoginFailNoSpecialCharEmail () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("wronggmail.com", "awad36148"); // Wrong Email , password
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[2]/div/form/div[1]/p")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Invalid email address";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	@Test (priority = 7) //TC_LOGIN_007
	public void UserLoginFailBlankEmail () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("", "awad36148"); // Wrong Email , password
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[2]/div/form/div[1]/p")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Please Enter a valid Email";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	@Test (priority = 11) //TC_LOGIN_008
	public void UserLoginFailBlankEmailBlankPassword () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("", ""); // Wrong Email , password
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[2]/div/form/div[1]/p")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Please Enter a valid Email";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	@Test (priority = 9) //TC_LOGIN_009
	public void UserLoginFailBlankPassword () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("boogado@yahoo.com", ""); // Wrong Email , password
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[2]/div/form/div[2]/p")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Please Enter a valid Password";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
	}
	
	@Test (priority = 10) //TC_LOGIN_010
	public void UserLoginExpiredPassword () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("boogado6@yahoo.com", "awad36148"); 
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div[2]")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Password is expired. Please contact your administrator";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}
	@Test (priority = 8) //TC_LOGIN_0011
	public void UserLoginDisabledUser () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("boogado5@yahoo.com", "awad36148"); 
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div[2]")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "User is disabled. Please contact your administrator";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
		
	}

	
	@Test (priority = 2) //TC_LOGIN_002
	public void UserLoginFailWrongPassword () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("boogado@yahoo.com", "12345678"); // Correct Email ,Wrong password
		Thread.sleep(2000);
		WebElement MessageString= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div[2]")); //  message id
		String messageString = MessageString.getText();
		String actualMessage= "Wrong email or password";
		Assert.assertEquals(actualMessage, messageString);
		Thread.sleep(2000);
	}



	@Test (priority = 12) //TC_LOGIN_001
	public void UserCanLoginSuccssfully () throws InterruptedException
	{
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("boogado@yahoo.com", "awad36148"); // Correct Input Data
		String actualUrlString = "https://invoice-tracker-frontend.herokuapp.com/employee";  // Profile page link
		Thread.sleep(2000);
		String foundUrlString = driver.getCurrentUrl();		
		Assert.assertEquals( actualUrlString, foundUrlString);
		
	}
}
