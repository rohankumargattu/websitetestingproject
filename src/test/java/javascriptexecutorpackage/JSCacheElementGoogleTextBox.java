package javascriptexecutorpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSCacheElementGoogleTextBox
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
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
		System.out.println("Elements in cache are:");
		int flag=0;
		for(int i=0;i<l.size();i++)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("var x=arguments[0].textContent;window.alert(x);",l.get(i));
			Thread.sleep(1000);
			String y=driver.switchTo().alert().getText();
			System.out.println((i+1)+"."+y);
			driver.switchTo().alert().accept();
			if(y.equalsIgnoreCase("virat kohli stats"))
			{
				System.out.println("Element found in position"+(i+1)+" in cache");
				flag=1;
				driver.findElement(By.name("q")).clear();
				driver.findElement(By.name("q")).sendKeys(y);
				break;
			}
		}
		if(flag==1)
		{
			Actions a=new Actions(driver);
			a.sendKeys(Keys.ESCAPE).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@aria-label='Google Search'])[2]")));
			driver.findElement(By.xpath("(//*[@aria-label='Google Search'])[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
		}
		else
		{
			System.out.println("Element not found in cache");
		}
		//Close site
		driver.close();
	}
}
