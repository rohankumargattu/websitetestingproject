package divtagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DivTagGetItemsAndDisplayJS
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='ui fluid search selection dropdown'])[1]")));
		//driver.findElement(By.xpath("(//*[@class='ui fluid search selection dropdown'])[1]")).click();
		List<WebElement> l=driver.findElements(By.xpath("(//*[@class='ui fluid search selection dropdown'])[1]/div[2]/div"));
		for(int i=0;i<l.size();i++)
		{
			WebElement e=l.get(i);
			driver.executeScript("var v=arguments[0].textContent;window.alert(v)",e);
			//wait.until(ExpectedConditions.alertIsPresent());
			//Thread.sleep(500);
			String country=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			System.out.println((i+1)+"."+country);
		}
		//close site
		driver.close();			
	}
}
