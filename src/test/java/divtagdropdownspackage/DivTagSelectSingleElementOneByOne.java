package divtagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagSelectSingleElementOneByOne 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dropdown'][@class='ui header'])[1]")));
		driver.findElement(By.xpath("(//*[contains(@class,'ui fluid selection dropdown')])[1]")).click();
		Thread.sleep(2000);
		List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid selection dropdown')])[1]/div[2]/div"));
		System.out.println("No of elements in dropdown are "+l.size());
		//Select all elements in the drop-down one by one
		for(int i=0;i<l.size();i++)
		{
			l.get(i).click();
			System.out.println("Element"+(i+1)+" selected");
			Thread.sleep(1000);
			//Open drop-down for next item selection
			driver.findElement(By.xpath("(//*[contains(@class,'ui fluid selection dropdown')])[1]")).click();
			Thread.sleep(1000);
		}
		//To close drop-down after all elements selected
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(2000);
		//Close site
		driver.close();
	}
}
