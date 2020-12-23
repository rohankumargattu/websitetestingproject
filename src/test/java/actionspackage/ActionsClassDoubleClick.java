package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDoubleClick
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryhome")));
		driver.switchTo().frame(0);
		WebElement e=driver.findElement(By.xpath("//p[contains(text(),'Double-click this paragraph')]"));
		Actions a=new Actions(driver);
		a.doubleClick(e).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World']")));
		try
		{
			if(driver.findElement(By.xpath("//*[text()='Hello World']")).isDisplayed())
			{
				System.out.println("Double click test passed");
			}
			else
			{
				System.out.println("Double click test failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		driver.switchTo().defaultContent();
		//Close site
		driver.close();	
	}
}
