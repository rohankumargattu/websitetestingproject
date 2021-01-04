package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSDisableAnElement4
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://demo.guru99.com/test/newtours/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER")));
		driver.findElement(By.linkText("REGISTER")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		//Disable an element
		WebElement e1=driver.findElement(By.name("city"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('disabled','true');",e1);
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).click();
		Actions a=new Actions(driver);
		for(int i=0;i<8;i++)
		{
			a.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1500);
		}
		//Enable element
		js.executeScript("arguments[0].removeAttribute('disabled');",e1);
		a.keyDown(Keys.SHIFT).build().perform();
		for(int i=0;i<8;i++)
		{
			a.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1500);
		}
		a.keyUp(Keys.SHIFT).build().perform();
		//Close site
		driver.close();
	}
}
