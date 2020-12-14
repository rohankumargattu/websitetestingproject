package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Delete all cookies
		driver.manage().deleteAllCookies();
		//Open site
		driver.get("http://www.google.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//Check whether cookies were loaded or not(Get cookies count)
		int c=driver.manage().getCookies().size();
		System.out.println("No of cookies loaded are: "+c);
		if(c!=0)
		{
			System.out.println("Cookies were loaded");
		}
		else
		{
			System.out.println("Cookies were not loaded");
		}
		//Close site
		driver.close();
	}
}
