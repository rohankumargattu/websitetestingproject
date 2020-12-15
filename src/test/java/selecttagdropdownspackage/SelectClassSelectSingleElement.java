package selecttagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectClassSelectSingleElement
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.mercurytravels.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nights")));
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		//Collect elements of drop-down
		List<WebElement> l=s.getOptions();
		System.out.println("No of items in dropdown are: "+l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println((i+1)+"."+l.get(i).getText());
		}
		s.selectByIndex(7);
		Thread.sleep(3000);
		s.selectByVisibleText("26Nights+27Days");
		Thread.sleep(3000);
		s.selectByValue("32Nights / 33Days");
		Thread.sleep(3000);
		//Close site
		driver.close();	
	}
}
