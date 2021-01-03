package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSSendKeysOnAnElement
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('gb_70').click();");
		//driver.executeScript("document.getElementById('gb_70').click();");
		
		//WebElement e=driver.findElement(By.id("gb_70"));
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();",e);
		//driver.executeScript("arguments[0].click();",e);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		Thread.sleep(3000);
		
		js.executeScript("document.getElementById('identifierId').value='gatturohankumar';");
		//driver.executeScript("document.getElementById('identifierId').value='gatturohankumar';");
		
		//WebElement e=driver.findElement(By.name("identifier"));
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].value='gatturohankumar';",e);
		//driver.executeScript("arguments[0].value='gatturohankumar';",e);
		
		Thread.sleep(3000);
		
		//Close site
		driver.close();
	}
}
