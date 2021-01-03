package divtagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagSelectSingleElementUsingIndex
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
		//Select 4th element in the drop-down
		l.get(3).click();
		System.out.println("Element selected");
		Thread.sleep(3000);
		//Close site
		driver.close();
	}
}
