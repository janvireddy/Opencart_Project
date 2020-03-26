package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tablets
{
	WebDriver dr;
	String productName=null;
	
	 //To assign the local dr with the browser launched dr
	public Tablets(WebDriver dr)
	{
		this.dr=dr;
	}
	
	//Adds product from the Tablets category
	public String add_Tablets_To_Cart()
	{
		dr.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[4]/a")).click();//Clicks on Tablets icon
		
		productName=dr.findElement(By.xpath("//*[@id='content']//following::a[3]")).getText();//Gets the name of the first product displayed
		
		dr.findElement(By.xpath("//*[@class='button-group']//following::button[1]")).click();//Adds the displayed first product to the cart
		
		try 
		{
			Thread.sleep(5000);//Waits the script untill product is successfully added to the cart
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		return productName;//returns the added product name
	}
}
