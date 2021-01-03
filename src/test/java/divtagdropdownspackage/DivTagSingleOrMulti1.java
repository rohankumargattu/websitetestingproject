package divtagdropdownspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagSingleOrMulti1
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
		String x=driver.findElement(By.xpath("(//*[contains(@class,'ui fluid selection dropdown')])[1]")).getAttribute("class");
		x=x.toLowerCase();
		if(x.contains("multiple"))
		{
			System.out.println("Dropdown is MultiSelect");
		}
		else
		{
			System.out.println("Dropdown is SingleSelect");
		}
		//Close site
		driver.close();
	}
}
