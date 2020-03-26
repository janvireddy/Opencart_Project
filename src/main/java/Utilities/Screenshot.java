package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot 
{
	WebDriver dr;
	
	//Assigns the local dr with the browser launched dr
	public Screenshot(WebDriver dr)
	{
		this.dr=dr;
	}
	
	//Takes the sreenshot by specified name
	public void screenShot(String name)
	{
		File f1=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		File f2=new File("src/test/resources/SCREENSHOTS/"+name+".png");
		
		try 
		{
			FileUtils.copyFile(f1,f2);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
}
