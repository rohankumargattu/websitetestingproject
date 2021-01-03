package divtagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagDDAllowCharacterMatching2
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
		//Automate drop-down which allow character matching
		//Collect all elements which starts with "m"
		WebElement e1=driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]"));
		Actions a=new Actions(driver);
		a.click(e1).build().perform();
		Thread.sleep(1000);
		a.sendKeys("m").build().perform();
		Thread.sleep(1000);
		List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/div[2]/div[starts-with(text(),'M')]"));
		for(int i=0;i<l.size();i++)
		{
			System.out.println((i+1)+"."+l.get(i).getText());
		}
		//Close site
		driver.close();
	}
}
