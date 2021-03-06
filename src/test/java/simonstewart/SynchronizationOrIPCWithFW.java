package simonstewart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SynchronizationOrIPCWithFW 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().window().maximize();
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(20,TimeUnit.SECONDS);
		wait.pollingEvery(2,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Accept Cookies']")));
		driver.findElement(By.xpath("//*[text()='Accept Cookies']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("13")));
		driver.findElement(By.linkText("13")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.findElement(By.linkText("13")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.findElement(By.linkText("31")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		String x=driver.findElement(By.xpath("//*[@class='label']")).getText();
		System.out.println(x);	
		//Close site
		driver.close();
	}
}
