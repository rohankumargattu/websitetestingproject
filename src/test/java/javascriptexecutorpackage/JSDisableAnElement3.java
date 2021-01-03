package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSDisableAnElement3
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.facebook.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("pass")));
		WebElement e=driver.findElement(By.name("pass"));
		Thread.sleep(5000);
		e.sendKeys("rohan");
		Thread.sleep(5000);
		e.clear();
		//Disable an element
		driver.executeScript("arguments[0].removeAttribute('type');",e);
		Thread.sleep(5000);
		driver.executeScript("arguments[0].setAttribute('type','text');",e);
		Thread.sleep(5000);
		e.sendKeys("rohan");
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
