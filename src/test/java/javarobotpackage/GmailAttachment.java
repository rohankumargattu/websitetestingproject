package javarobotpackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailAttachment 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("http://www.gmail.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("priyaselenium1");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']/parent::*"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("Selenium1!");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']/parent::*"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		driver.findElement(By.name("to")).sendKeys("priyaselenium1@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Mail by Automation");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Via Java Robot");
		//Click Attachment icon
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-tooltip='Attach files']/descendant::*[3]")));
		driver.findElement(By.xpath("//*[@data-tooltip='Attach files']/descendant::*[3]")).click();
		Thread.sleep(5000);
		//Java Robot
		StringSelection x=new StringSelection("C:\\Users\\gattu\\Pictures\\Screenshots\\Screenshot (100).png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='a1 aaA aMZ aF2']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='progressbar']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Send']")));
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message sent')]")));
		//Logout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label,'Google Account')]")));
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Sign out']")));
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Use another account']")));
		//close site
		driver.close();
	}
}
