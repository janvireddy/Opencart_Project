package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shopping_Cart 
{
WebDriver dr;
String productName=null;
String productPrice=null;
	
    //To assign the local dr with the browser launched dr
	public Shopping_Cart(WebDriver dr)
	{
		this.dr=dr;
	}
	
	//Searches for the added product and returns its name
	public String view_Shopping_Cart()
	{
	    dr.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a")).click();//Clicks on shopping cart icon
	    
	    try 
	    {
			Thread.sleep(5000);//waits for the shopping cart to be loaded
		} 
	    catch (InterruptedException e) 
	    {
			e.printStackTrace();
		}
	    
		productName=dr.findElement(By.xpath("//*[@id='content']//following::a[2]")).getText();//Gets the name of the added product
		
		return productName;//returns added prodcut name
	}
	
	//To remove the added product from the shopping cart
	public String remove_product()
	{
	    dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[4]/div/span/button[2]")).click();//clicks on the remove product
	    
	    try 
	    {
			Thread.sleep(5000);//waits for the product to be removed
		} 
	    catch (InterruptedException e) 
	    {
			e.printStackTrace();
		}
	    
		productPrice=dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")).getText();//Gets the price of the product still present in the cart
		
		return productPrice;//returns the readed product price
	}
}
