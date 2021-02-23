package simonstewart;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesTesting
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site and do login via form filling
		WebDriverWait wait =new WebDriverWait(driver,10);
        driver.get("http://expenseus.com/user/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user[email]"))).sendKeys("magnitiait@gmail.com");
        driver.findElement(By.name("user[password]")).sendKeys("abdulkalam");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Thread.sleep(5000);
        try
        {
        	if(driver.findElement(By.linkText("Logout")).isDisplayed())
        	{
        		System.out.println("Successful login");
        	}
        }
        catch(Exception exc)
        {
        	System.out.println("Unsuccessful login");
        }
        //Get and display all cookies
        Set<Cookie> cl=driver.manage().getCookies();
        ArrayList<Cookie> ca=new ArrayList<Cookie>(cl);
        /*for(Cookie c:ca)
        {
        	System.out.println(c.getName());
        }*/
        for(int i=0;i<ca.size();i++)
        {
        	System.out.println(ca.get(i).getName());
        }
        //Remember session cookie via Cookie object and delete for browser
        Cookie loginCookie=driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookieNamed("PHPSESSID");
        Thread.sleep(20000);
        //Launch site and do login by adding session cookie to browser
        System.out.println("Using cookie");
        driver.manage().addCookie(loginCookie);
        driver.get("http://expenseus.com");
        try
        {
        	if(driver.findElement(By.linkText("Logout")).isDisplayed())
        	{
        		System.out.println("Successful login");
        	}
        }
        catch(Exception exc)
        {
        	System.out.println("Unsuccessful login");
        }
        Thread.sleep(20000);
		//Close site
		driver.close();
	}
}