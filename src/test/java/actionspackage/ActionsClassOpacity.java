package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassOpacity 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//Get element style details before focused
		WebElement e=driver.findElement(By.xpath("(//*[text()='Gmail'])[1]"));
		String o1=e.getCssValue("opacity");
		String td1=e.getCssValue("text-decoration");
		//Focus on the element and get style details
		Actions a=new Actions(driver);
		a.moveToElement(e).clickAndHold().build().perform();
		String o2=e.getCssValue("opacity");
		String td2=e.getCssValue("text-decoration");
		a.release().build().perform();
		System.out.println("Before Focus - "+o1+"\nAfter Focus - "+o2);
		System.out.println("Before Focus - "+td1+"\nAfter Focus - "+td2);
		//Close site
		driver.close();
	}
}
