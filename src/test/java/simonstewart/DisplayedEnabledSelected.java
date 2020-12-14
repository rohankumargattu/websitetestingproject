package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisplayedEnabledSelected 
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flights']")));
		driver.findElement(By.xpath("//*[@id='flights']")).click();
		try
		{
			if(driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).isDisplayed())
			{
				if(driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).isEnabled())
				{
					if(driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).isSelected())
					{
						System.out.println("Is already selected");
					}
					else
					{
						driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).click();
						if(driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).isSelected())
						{
							System.out.println("Is now selected");
						}
					}
				}
				else
				{
					System.out.println("Element is disabled");
				}
			}
			else
			{
				System.out.println("Is already Invisible");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Close site
		driver.close();	
	}
}
