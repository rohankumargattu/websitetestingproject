package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassMoveByOffset
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.flipkart.com/");
		WebDriverWait wait = null;
		try
		{
			wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_2KpZ6l _2doB4z']")));
			if(driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).click();
			}
		}
		catch(Exception ex)
		{
			System.out.println("Banner was not displayed");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Women']")));
		WebElement e=driver.findElement(By.xpath("//*[text()='Women']"));
		Actions a=new Actions(driver);
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		a.moveByOffset(x+40, y+20).build().perform();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
