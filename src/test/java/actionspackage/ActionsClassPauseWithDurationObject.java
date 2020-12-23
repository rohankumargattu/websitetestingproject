package actionspackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassPauseWithDurationObject
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.seleniumhq.org/");
		Actions a=new Actions(driver);
		Duration d=Duration.ofSeconds(5);
		//Duration d=Duration.of(5,ChronoUnit.SECONDS);
		a.pause(d).build().perform();
		WebElement e=driver.findElement(By.linkText("Download"));
		a.click(e).build().perform();
		a.pause(d).build().perform();
		//Close site
		driver.close();
	}
}
