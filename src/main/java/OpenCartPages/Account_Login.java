package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Account_Login 
{
	WebDriver dr;
	
	//To assign the local dr with the browser launched dr
	public Account_Login(WebDriver dr)
	{
		this.dr=dr;
	}
	
	//To Login to the Opencart website
	public void login(String email,String password)
	{
		dr.findElement(By.xpath("//*[@id='top-links']//following::a[2]")).click();//To click on My Account
		
		dr.findElement(By.xpath("//*[@id='top-links']//following::a[4]")).click();//To Select Login from My Account dropdown
		
		dr.findElement(By.xpath("//*[@id='input-email']")).sendKeys(email);//Enters Email in the login page
		
		dr.findElement(By.xpath("//*[@id='input-password']")).sendKeys(password);//Enters password in the Login page
		
		dr.findElement(By.xpath("//*[@value='Login']")).click();//To click on Login
    }
}