package divtagdropdownspackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagSelectMultipleElementUsingScanner
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of items to select");
		int n=Integer.parseInt(sc.nextLine());
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("Enter "+n+" elements to be selected");
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter element"+(i+1)+":");
			al.add(sc.nextLine());
		}
		sc.close();
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dropdown'][@class='ui header'])[1]")));
		WebElement e=driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(1000);
		List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/div[2]/div"));
		System.out.println("No of elements in <div> tag dropdown are "+l.size());
		try
		{
			for(int i=0;i<n;i++)
			{
				while(2>1)
				{
					String x=driver.findElement(By.xpath("(//*[@class='item selected'])[1]")).getText();
					if(x.equalsIgnoreCase(al.get(i)))
					{
						a.sendKeys(Keys.ENTER).build().perform();
						break;
					}
					else
					{
						a.sendKeys(Keys.DOWN).build().perform();
						Thread.sleep(1000);
					}
				}
			}
			//Get all selected elements
			List<WebElement> l2=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/a"));
			System.out.println("Selected list is:");
			for(int i=0;i<l2.size();i++)
			{
				System.out.println((i+1)+"."+l2.get(i).getText());
			}
			Thread.sleep(2000);
			//Deselect 2nd element in selected elements
			driver.findElement(By.xpath("(//*[@class='delete icon'])[2]")).click();
			Thread.sleep(2000);
			//Get all elements after deselecting some elements
			List<WebElement> l3=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/a"));
			System.out.println("Final Selected list is:");
			for(int i=0;i<l3.size();i++)
			{
				System.out.println((i+1)+"."+l3.get(i).getText());
			}
			Thread.sleep(2000);
			a.sendKeys(Keys.ESCAPE).build().perform();
			Thread.sleep(2000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Close site
		driver.close();
	}
}
