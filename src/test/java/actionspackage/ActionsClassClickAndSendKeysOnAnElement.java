package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassClickAndSendKeysOnAnElement
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
		//Enter UID via Actions class
		WebElement e1=driver.findElement(By.name("identifier"));
		Actions a=new Actions(driver);
		a.sendKeys(e1,"gatturohankumar").build().perform();
		//Click via Actions class
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		WebElement e2=driver.findElement(By.xpath("//*[text()='Next']"));
		a.click(e2).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//Close site
		driver.close();
	}
}
