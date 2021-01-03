package divtagdropdownspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagSelectSingleElementUsingXpath
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
		driver.findElement(By.xpath("//*[@data-value='christian']")).click();
		Thread.sleep(2000);
		System.out.println("Element selected");
		Thread.sleep(3000);
		//Close site
		driver.close();
	}
}