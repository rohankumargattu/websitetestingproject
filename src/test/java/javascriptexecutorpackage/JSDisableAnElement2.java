package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSDisableAnElement2
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.google.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		WebElement e=driver.findElement(By.name("q"));
		driver.executeScript("arguments[0].value='virat';",e);
		Thread.sleep(5000);
		driver.findElement(By.name("q")).clear();
		//Disable an element
		driver.executeScript("arguments[0].setAttribute('disabled','true');",e);
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.name("q")).sendKeys("kohli");
		}
		catch(Exception ex)
		{
			driver.executeScript("arguments[0].removeAttribute('disabled');",e);
			driver.findElement(By.name("q")).sendKeys("❤Shwethapriya❤");
		}
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
