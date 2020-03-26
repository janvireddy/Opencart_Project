package TestApplication;

import org.testng.annotations.Test;

import OpenCartPages.Account_Login;
import OpenCartPages.Phones_And_Pdas;
import OpenCartPages.Register_Account;
import OpenCartPages.Shopping_Cart;
import OpenCartPages.Tablets;
import Utilities.Baseclass;
import Utilities.ExcelRead;
import Utilities.Screenshot;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Test_In_Chrome extends Baseclass
{
  WebDriver dr;
  String actualResult=null;
  static int i=1,j=1,n=1,m=1;
  
  //Declared objects for POM pages
  Register_Account r;
  Account_Login l;
  Screenshot s;
  Tablets t;
  Phones_And_Pdas p;
  Shopping_Cart sc;
  ExcelRead e=new ExcelRead();
 
  
  @BeforeMethod
  public void beforeMethod() 
  {
	     dr=launch("chrome","https://demo.opencart.com/");//Launches the URL in the specified browser
	     
	     //Intialises the POM pages objects
		 r=new Register_Account(dr);
		 l=new Account_Login(dr);
		 s=new Screenshot(dr);
		 t=new Tablets(dr);
		 p=new Phones_And_Pdas(dr);
		 sc=new Shopping_Cart(dr);
  }
  

  //Test case for invalid registration by giving password mismatch
  @Test(dataProvider = "data1")
  public void a_Invalid_Registration(String firstName,String lastName,String email,String telephone,String password,String confirmPassword) 
  {
	  actualResult= r.register(firstName, lastName, email, telephone, password, confirmPassword);
	  
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  s.screenShot("RegistrationChrome["+i+"]");//takes screenshot by it's specified name
	  i++;
	  
	  Assert.assertTrue(actualResult.equals("Password confirmation does not match password!"));
  }
  
  
  
  //Test case to verify whether the product is successfully added to cart or not
  @Test(dataProvider = "data2")
  public void b_Adding_Product_To_Cart(String firstName,String lastName,String email,String telephone,String password,String confirmPassword) 
  {
	  r.register(firstName, lastName, email, telephone, password, confirmPassword);
	  r.logout();
	  l.login(email, confirmPassword);
	  
	  String expectedResult=t.add_Tablets_To_Cart();//Gets the name of the prodcut before it is added to the cart
	  
	  String actualResult=sc.view_Shopping_Cart();//Gets the name of the prodcut after it is added to the cart
	  
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  s.screenShot("AddingProductChrome["+j+"]");//Takes the screenshot of the addedd product
	  j++;
	  Assert.assertTrue(actualResult.equals(expectedResult));
  }
 
 
 
  //Test case to verify the product is removed from the cart or not and verifying the remaining product price 
  @Test(dataProvider = "data3")
  public void c_Adding_And_Removing_Products_From_Cart(String firstName,String lastName,String email,String telephone,String password,String confirmPassword) 
  {
	  r.register(firstName, lastName, email, telephone, password, confirmPassword);
	  r.logout();
	  l.login(email, confirmPassword);
	  
	  p.add_Phone_To_Cart();//Adds first product displayed in the Phone and PDA's category
	  
	  t.add_Tablets_To_Cart();//Adds first product displayed in the Tablets category
	  
	  sc.view_Shopping_Cart();
	  
	  s.screenShot("Before_Removing_ProductChrome["+n+"]");//takes the screenshot of the added products
	  n++;
	  
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  String actualResult=sc.remove_product();//removes first product from the cart
	  
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  s.screenShot("After_Removing_ProductChrome["+m+"]");//takes the screenshot after product one product is removed
	  m++;
	  
	  Assert.assertTrue(actualResult.equals("$100.00"));
  }
  
 
 
  @AfterMethod
  public void afterMethod() 
  {  
	  dr.quit();	//closes the browser after test execution is completed  
  }


  
  
  //Provides the data for the a_Invalid_Registration test method
  @DataProvider(name="data1")
  public String[][] dataProvider1() 
  {
	  String[][] s=new String[3][6];
	  s=e.readRows("chrome",1,3);//reads the data from specified rows in the excel file
	  return s;
  }
  
  
  
  //Provides data for b_Adding_Product_To_Cart test method
  @DataProvider(name="data2")
  public String[][] dataProvider2() 
  {
	  String[][] s=new String[3][6];
	  s=e.readRows("chrome",4, 6);//reads the data from specified rows in the excel file
	  return s;
  }
  
 
 
  //Provides the data for c_Adding_And_Removing_Products_From_Cart test method
  @DataProvider(name="data3")
  public String[][] dataProvider3() 
  {
	  String[][] s=new String[3][6];
	  s=e.readRows("chrome",7, 9);//reads the data from specified rows in the excel file
	  return s;
  }
  
  
}
