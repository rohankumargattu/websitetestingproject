package selecttagdropdownspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassIsMultipleSingleSelect
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.mercurytravels.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='white-text']")));
		driver.findElement(By.xpath("//*[@class='white-text']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nights")));
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		if(s.isMultiple())
		{
			System.out.println("Dropdown is Multiselect Dropdown");
		}
		else
		{
			System.out.println("Dropdown is Singleselect Dropdown");
		}
		//Close site
		driver.close();
	}
}
