package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSClearBrowserHistory
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
		
		//Clear browser History
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.history.go(0);");
		js.executeScript("history.go(0);");
		Thread.sleep(5000);
		
		//Close site
		driver.close();
	}
}
