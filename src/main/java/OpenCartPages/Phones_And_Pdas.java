package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Phones_And_Pdas 
{
	
	WebDriver dr;
	String productName=null;
	
	//To assign the local dr with the browser launched dr
	public Phones_And_Pdas(WebDriver dr)
	{
		this.dr=dr;
	}
	
	//To select a prodcut from phones category and add it cart
	public String add_Phone_To_Cart()
	{
		
		dr.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[6]/a")).click();//Clicks on the Phones & PDAS
		
		productName=dr.findElement(By.xpath("//*[@id='content']//following::a[3]")).getText();//Gets the First product name
		
		dr.findElement(By.xpath("//*[@class='button-group']//following::button[1]")).click();//Adds the first product displayed to the shopping cart
		
		try 
		{
			Thread.sleep(5000);//used to wait the script until the prodcut added successfully
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		return productName;//returns the added product name
	}


}
