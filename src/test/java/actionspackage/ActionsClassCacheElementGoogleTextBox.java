package actionspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassCacheElementGoogleTextBox
{
	public static void main(String[] args) throws Exception
	{
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("virat");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='listbox']")));
		//Get elements in cache/auto complete
		List<WebElement> l=driver.findElements(By.xpath("//*[@role='listbox']/li/descendant::span"));
		System.out.println("Count of elements in cache are: "+l.size());
		Actions a=new Actions(driver);
		int flag=0;
		for(int i=0;i<l.size();i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(1000);
			String x=driver.findElement(By.name("q")).getAttribute("value");
			if(x.equalsIgnoreCase("virat kohli stats"))
			{
				flag=1;
				a.sendKeys(Keys.ENTER).build().perform();
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("Element not found in cache");
		}
		else
		{
			System.out.println("Element found in cache");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
		}
		//Close site
		driver.close();	
	}
}
