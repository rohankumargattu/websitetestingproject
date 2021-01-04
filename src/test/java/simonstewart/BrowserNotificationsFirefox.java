package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserNotificationsFirefox 
{
	public static void main(String[] args) throws Exception
	{
		FirefoxProfile fp=new FirefoxProfile();
		fp.setPreference("dom.webnotifications.enabled",false);
		//Launch browser
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
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
