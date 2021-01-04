package javarobotpackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class SWDJRSikuliX
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
		//Select option in win-menu
		Robot r=new Robot();
		for(int i=0;i<6;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		ArrayList<String> al=new ArrayList<String>(driver.getWindowHandles());
		int c=al.size();
		System.out.println("No of browser tabs opened: "+c);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		StringSelection x=new StringSelection("//*[text()='Downloads']");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		Screen s=new Screen();
		s.click("cancel.png");
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
