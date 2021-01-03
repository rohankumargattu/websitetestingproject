package divtagdropdownspackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagDDAllowCharacterMatchingCountNumOfCountriesWithGivenChar
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
		//Collect all elements which starts with "i"
		WebElement e1=driver.findElement(By.xpath("(//*[contains(@class,'ui fluid search selection dropdown')])[1]"));
		Actions a=new Actions(driver);
		a.click(e1).build().perform();
		Thread.sleep(1000);
		a.sendKeys("i").build().perform();
		Thread.sleep(1000);
		List<WebElement> l1=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid search selection dropdown')])[1]/div[2]/div"));
		ArrayList<String> cl=new ArrayList<String>();
		for(int i=0;i<l1.size();i++)
		{
			String cv=l1.get(i).getAttribute("class");
			if(!cv.equals("item filtered"))
			{
				cl.add(l1.get(i).getText());
			}
		}
		System.out.println("Country names matching with given character are: "+cl.size());
		for(int i=0;i<cl.size();i++)
		{
			System.out.println(cl.get(i));
		}
		//Close site
		driver.close();
	}
}
