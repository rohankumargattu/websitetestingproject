package simonstewart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsMethod
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.mercurytravels.co.in/");
		//Maximize
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("No, thanks"))).click();
		
		//Count of links in page
		//Way1
		List<WebElement> l1=driver.findElements(By.tagName("a"));
		System.out.println("Links count is "+l1.size());
		//Way2
		List<WebElement> l2=driver.findElements(By.xpath("//a"));
		System.out.println("Links count is "+l2.size());
		
		//Count of total tags in a page
		List<WebElement> l3=driver.findElements(By.xpath("//*"));
		System.out.println("Tags count is "+l3.size());
		
		//Count of select tag dropdowns in page
		//Way1
		int count1=0;
		int count2=0;
		List<WebElement> l4=driver.findElements(By.tagName("select"));
		System.out.println("Total select tag dropdowns count is "+l4.size());
		for(int i=0;i<l4.size();i++)
		{
			if(l4.get(i).isDisplayed())
			{
				count1=count1+1;
			}
			else
			{
				count2=count2+1;
			}
		}
		System.out.println("Visible select tag dropdowns count is "+count1);
		System.out.println("Invisible select tag dropdowns count is "+count2);
		
		//Way2
		List<WebElement> l5=driver.findElements(By.xpath("//select"));
		System.out.println("Total select tag dropdowns count is "+l5.size());
		
		//Count of text boxes in page
		//Way1
		int count=0;
		List<WebElement> l6=driver.findElements(By.tagName("input"));
		for(int i=0;i<l6.size();i++)
		{
			String value=l6.get(i).getAttribute("type");
			if(value.equals("text"))
			{
				count=count+1;
			}
		}
		System.out.println("Total text boxes in page are "+count);
		//Way2
		int c=0;
		List<WebElement> l7=driver.findElements(By.xpath("//input"));
		for(int i=0;i<l7.size();i++)
		{
			String value=l7.get(i).getAttribute("type");
			if(value.equals("text"))
			{
				c=c+1;
			}
		}
		System.out.println("Total text boxes in page are "+c);		
		//Way3
		List<WebElement> l8=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Total text boxes in page are "+l8.size());
		
		//Count of images with <input> and <img>
		//Way1
		List<WebElement> l9=driver.findElements(By.xpath("//input[@type='image']"));
		List<WebElement> l10=driver.findElements(By.xpath("//img"));
		System.out.println(l9.size()+l10.size());
		//Way2
		List<WebElement> l11=driver.findElements(By.xpath("(//input[@type='image']) || (//img)"));
		System.out.println(l11.size());
		
		
	}
}
