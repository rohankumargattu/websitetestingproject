package divtagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagDDAllowCharacterMatchingCountNumOfCountriesWithEachChar
{
	public static void main(String[] args)
	{
		String c[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
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
		//Get the count of all elements which starts with each character
		driver.findElement(By.xpath("(//*[contains(@class,'ui fluid search selection dropdown')])[1]")).click();
		for(int i=0;i<c.length;i++)
		{
			List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid search selection dropdown')])[1]/div[2]/div[starts-with(text(),'"+c[i]+"')]"));
			System.out.println("Country names starting with \""+c[i]+"\" are :"+l.size());
			for(int j=0;j<l.size();j++)
			{
				System.out.println((j+1)+"."+l.get(j).getText());
			}
			System.out.println();
		}
		//Close site
		driver.close();
	}
}
