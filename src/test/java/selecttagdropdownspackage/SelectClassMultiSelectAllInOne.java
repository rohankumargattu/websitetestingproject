package selecttagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassMultiSelectAllInOne
{
	public static void main(String[] args) throws Exception
	{
		//Open Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("iframeResult")));
		WebElement e1=driver.findElement(By.name("iframeResult"));
		driver.switchTo().frame(e1);
		//driver.switchTo().frame(1);
		//driver.switchTo().frame("iframeResult");
		//Single or Multi select
		WebElement e2=driver.findElement(By.name("cars"));
		Select s=new Select(e2);
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
		
		//Select multiple elements in a dropdown
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL).build().perform();
		//a.click(totallist.get(1)).build().perform();
		//a.click(totallist.get(2)).build().perform();
		//a.click(totallist.get(3)).build().perform();
		s.selectByVisibleText(totallist.get(1).getText());
		Thread.sleep(1500);
		s.selectByVisibleText(totallist.get(2).getText());
		Thread.sleep(1500);
		s.selectByVisibleText(totallist.get(3).getText());
		Thread.sleep(1500);
		a.keyUp(Keys.CONTROL).build().perform();
		
		//Get selected elements in a select tag drop down
		List<WebElement> selectedlist=s.getAllSelectedOptions();
		System.out.println("Total no of elements selected are "+selectedlist.size());
		for(int i=0;i<selectedlist.size();i++)
		{
			System.out.println(selectedlist.get(i).getText());
		}
		
		//Get first selected element in a select tag drop down
		WebElement fisrtselected=s.getFirstSelectedOption();
		System.out.println("First selected element in the selection is "+fisrtselected.getText());
		
		//Deselect specific elements in selection
		s.deselectByVisibleText("Opel");
		Thread.sleep(1500);
		s.deselectByVisibleText("Saab");
		Thread.sleep(1500);
		s.deselectByVisibleText("Audi");
		Thread.sleep(1500);
		
		//Select all elements in the dropdown
		a.keyDown(Keys.CONTROL).build().perform();
		for(int i=0;i<totallist.size();i++)
		{
			s.selectByVisibleText(totallist.get(i).getText());
			Thread.sleep(1500);
		}
		a.keyUp(Keys.CONTROL).build().perform();
		
		//Deselect All
		s.deselectAll();
		Thread.sleep(1500);
		
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}
