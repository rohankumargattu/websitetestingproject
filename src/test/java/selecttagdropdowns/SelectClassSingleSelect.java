package selecttagdropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassSingleSelect
{
	public static void main(String[] args) throws Exception
	{
		//Open Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.facebook.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Create New Account']")));
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_month")));
		//Locate dropdown
		WebElement e=driver.findElement(By.name("birthday_month"));
		Select s=new Select(e);
		//Single or Multi select
		if(s.isMultiple())
		{
			System.out.println("Multi select dropdown");
		}
		else
		{
			System.out.println("Single select dropdown");
		}
		//Get all the elements in a select tag drop down
		List<WebElement> totallist=s.getOptions();
		System.out.println("Total no of elements in given dropdown is "+totallist.size());
		for(int i=0;i<totallist.size();i++)
		{
			System.out.println(totallist.get(i).getText());
		}
		//Select specific element
		s.selectByVisibleText("Apr");
		Thread.sleep(3000);
		s.selectByValue("11");
		Thread.sleep(3000);
		s.selectByIndex(6);
		Thread.sleep(3000);
		//Close site
		driver.close();
	}
}
