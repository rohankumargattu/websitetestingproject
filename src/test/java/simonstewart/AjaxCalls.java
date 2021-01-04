package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxCalls 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("http://www.gmail.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("gatturohankumar");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("gatturohan@134");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		//Do logout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label,'Google Account')]/span")));
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Sign out']")));
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//Close site
		driver.close();	
	}
}
