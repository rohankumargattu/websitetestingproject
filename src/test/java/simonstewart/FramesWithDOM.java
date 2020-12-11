package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesWithDOM
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert2");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tryhome']")));
		WebElement e=driver.findElement(By.name("iframeResult"));
		driver.switchTo().frame(e);		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Try it']")));
		driver.findElement(By.xpath("//*[text()='Try it']")).click();
		String x=driver.switchTo().alert().getText();
		System.out.println("Text from alert is: "+x);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//Close site
		driver.close();
	}
}
