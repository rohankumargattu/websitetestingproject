package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassPauseWithTimeInMilliSeconds
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.co.in");
		Actions a=new Actions(driver);
		a.pause(5000).build().perform();
		WebElement e=driver.findElement(By.name("q"));
		a.click(e).build().perform();
		a.pause(5000).build().perform();
		//Close site
		driver.close();
	}
}
