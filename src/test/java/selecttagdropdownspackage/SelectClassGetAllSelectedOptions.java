package selecttagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectClassGetAllSelectedOptions 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tryhome")));
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL).build().perform();
		a.click(s.getOptions().get(0)).build().perform();
		Thread.sleep(1000);
		a.click(s.getOptions().get(2)).build().perform();
		Thread.sleep(1000);
		a.click(s.getOptions().get(3)).build().perform();
		a.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(3000);
		s.deselectByVisibleText("Opel");
		List<WebElement> sl=s.getAllSelectedOptions();
		System.out.println("No of items in selected list are: "+sl.size());
		for(int i=0;i<sl.size();i++)
		{
			System.out.println((i+1)+"."+sl.get(i).getText());
		}
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		//Close site
		driver.close();
	}
}
