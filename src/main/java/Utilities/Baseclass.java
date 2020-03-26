package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass 
{

WebDriver dr;
	
    //To Launch the URL in a selected browser
	public WebDriver launch(String browser, String url)
	{
		//To Launch the URL using CHROME Browser
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","src/test/resources/DRIVERS/chromedriver_V79.exe");
			dr=new ChromeDriver();
		}
		
		//To Launch the URL using FIREFOX Browser 
		else if(browser.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","src/test/resources/DRIVERS/geckodriver.exe");
			dr=new FirefoxDriver();
		}
		
		//If the selected browser option is not available it will display following message
		else
		{
			System.out.println("Selected browser options not available");
		}
		
		dr.get(url);  //Enters URL in the launched browser
		
		dr.manage().window().maximize();	//To maximize the window
		
		return dr;
	}
}
