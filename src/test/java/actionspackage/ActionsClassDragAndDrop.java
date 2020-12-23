package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDragAndDrop
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://jqueryui.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Droppable']")));
		WebElement e1=driver.findElement(By.xpath("//*[text()='Droppable']"));
		Actions a=new Actions(driver);
		a.click(e1).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Droppable']")));
		driver.switchTo().frame(0);
		WebElement e2=driver.findElement(By.id("draggable"));
		WebElement e3=driver.findElement(By.id("droppable"));
		a.dragAndDrop(e2, e3).build().perform();
		String result=driver.findElement(By.xpath("//*[@id='droppable']/child::*")).getText();
		if(result.contains("Dropped"))
		{
			System.out.println("Drag and Drop Test Passed");
		}
		else
		{
			System.out.println("Drag and Drop Test Failed");
		}
		driver.switchTo().defaultContent();
		//Close site
		driver.close();	
	}
}
