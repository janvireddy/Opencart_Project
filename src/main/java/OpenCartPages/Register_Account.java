package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Register_Account 
{
	WebDriver dr;
	String message=null;
	
	//To assign the local dr with the browser launched dr
	public Register_Account(WebDriver dr)
	{
		this.dr=dr;
	}

	//To register to the open cart website
	public String register(String firstName,String lastName,String email,String telephone,String password,String confirmPassword)
	{
		dr.findElement(By.xpath("//*[@id='top-links']//following::a[2]")).click();//To click on My Account
		
		dr.findElement(By.xpath("//*[@id='top-links']//following::a[3]")).click();//To choose Register from My Account dropdown
		
		dr.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys(firstName);//Enters the Firstname
		
		dr.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys(lastName);//Enter the Lastname
		
		dr.findElement(By.xpath("//*[@id='input-email']")).sendKeys(email);//Enter the Email	
		
		dr.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys(telephone);//Enters the Telephone number	
		
		dr.findElement(By.xpath("//*[@id='input-password']")).sendKeys(password);//Enters the Password
		
		dr.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys(confirmPassword);//Enters the Confirm password
		
		dr.findElement(By.xpath("//*[@name='agree']")).click();//Clicks on agree to privacy policy check box	
		
		dr.findElement(By.xpath("//*[@value='Continue']")).click();//Clicks on continue to register button
		
		try
		{
		message=dr.findElement(By.xpath("//*[@class='text-danger']")).getText();//Stores the displayed error message if the entered credentials are invalid
		}
		catch(NoSuchElementException e)
		{
			
		}
		
		dr.findElement(By.xpath("//*[@class='buttons']//a")).click();//Once again clicks on continue to register button
		
		return message;//returns the displayed error message or else rerturn NULL
		}
		
	
	public void logout()
	{
		dr.findElement(By.xpath("//*[@id='top-links']//following::a[2]")).click();//To click on My Account
		
		dr.findElement(By.xpath("//*[@id='top-links']//following::a[7]")).click();//To click on Log Out
		
		dr.findElement(By.xpath("//*[@class='buttons']//a")).click();//Clicks on continue to Log Out
	}
}
