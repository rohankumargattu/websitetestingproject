package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserNotificationsChrome 
{
	public static void main(String[] args) throws Exception
	{
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(co);
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://in.bookmyshow.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='View All Cities']")));
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
