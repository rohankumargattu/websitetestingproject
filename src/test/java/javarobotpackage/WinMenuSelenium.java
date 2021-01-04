package javarobotpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WinMenuSelenium 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.selenium.dev/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Downloads")));
		WebElement e=driver.findElement(By.linkText("Downloads"));
		if(driver.findElement(By.linkText("Downloads")).isDisplayed())
		{
			Actions a=new Actions(driver);
			a.contextClick(e).build().perform();
			Thread.sleep(3000);
		}
		//Select 1st option in win-menu
		Robot r=new Robot();
		for(int i=0;i<7;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//Quit site
		driver.quit();	
	}
}
