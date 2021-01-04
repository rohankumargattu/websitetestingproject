package javarobotpackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class OStoOSDifferences
{
	public static void main(String[] args) throws Exception
	{
		//Creating a static array
		String[] list1={"selenium","javarobot","sikulix"};
		System.out.println("Size of array is "+list1.length);
		
		//Creating objects
		Screen s=new Screen();
		Robot r=new Robot();
		
		//String platform=System.getProperty("os.name");
		
		for(int i=0;i<list1.length;i++)
		{
			//Copy data to clip-board
			StringSelection data=new StringSelection("p nageswara rao testing tools");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(data,null);
			//Launch browser
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			//Maximize
			driver.manage().window().maximize();
			//Open site
			driver.get("http://www.google.com");
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
			if(list1[i].equalsIgnoreCase("selenium"))
			{
				if(System.getProperty("os.name").contains("Windows"))
				{
					//Paste data
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"v"),Keys.ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					//Select all and Copy
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));
					Thread.sleep(2000);
					//Navigate to another site
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					//Paste copied data
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"v"),Keys.ENTER);
					Thread.sleep(5000);
					//Close site
					driver.quit();
				}
				else if(System.getProperty("os.name").contains("Mac"))
				{
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.META,"v"),Keys.ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.META,"a"),Keys.chord(Keys.META,"c"));
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.META,"v"),Keys.ENTER);
					Thread.sleep(5000);
					driver.quit();
				}
				else if(System.getProperty("os.name").contains("Linux"))
				{
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"v"),Keys.ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,Keys.ALT,"c"));
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"v"),Keys.ENTER);
					Thread.sleep(5000);
					driver.quit();
				}
			}
			else if(list1[i].equalsIgnoreCase("javarobot"))
			{
				if(System.getProperty("os.name").contains("Windows"))
				{
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(2000);
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_ALT);
				}
				else if(System.getProperty("os.name").contains("Mac"))
				{
					r.keyPress(KeyEvent.VK_META);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_META);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					r.keyPress(KeyEvent.VK_META);
					r.keyPress(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_META);
					Thread.sleep(2000);
					r.keyPress(KeyEvent.VK_META);
					r.keyPress(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_META);
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					r.keyPress(KeyEvent.VK_META);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_META);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_ALT);
				}
				else if(System.getProperty("os.name").contains("Linux"))
				{
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(2000);
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_ALT);
					r.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_F4);
					r.keyRelease(KeyEvent.VK_ALT);
				}
			}	
			else if(list1[i].equalsIgnoreCase("sikulix"))
			{
				if(System.getProperty("os.name").contains("Windows"))
				{
					s.keyDown(Key.CTRL);
					s.type("v");
					s.keyUp(Key.CTRL);
					s.keyDown(Key.ENTER);
					s.keyUp(Key.ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					s.keyDown(Key.CTRL);
					s.type("a");
					s.keyUp(Key.CTRL);
					Thread.sleep(2000);
					s.keyDown(Key.CTRL);
					s.type("c");
					s.keyUp(Key.CTRL);
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					s.keyDown(Key.CTRL);
					s.type("v");
					s.keyUp(Key.CTRL);
					s.keyDown(Key.ENTER);
					s.keyUp(Key.ENTER);
					Thread.sleep(5000);
					s.click("close.png");
				}
				else if(System.getProperty("os.name").contains("Mac"))
				{
					s.keyDown(Key.META);
					s.type("v");
					s.keyUp(Key.META);
					s.keyDown(Key.ENTER);
					s.keyUp(Key.ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					s.keyDown(Key.META);
					s.type("a");
					s.keyUp(Key.META);
					Thread.sleep(2000);
					s.keyDown(Key.META);
					s.type("c");
					s.keyUp(Key.META);
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					s.keyDown(Key.META);
					s.type("v");
					s.keyUp(Key.META);
					s.keyDown(Key.ENTER);
					s.keyUp(Key.ENTER);
					Thread.sleep(5000);
					s.click("close.png");
				}
				else if(System.getProperty("os.name").contains("Linux"))
				{
					s.keyDown(Key.CTRL);
					s.type("v");
					s.keyUp(Key.CTRL);
					s.keyDown(Key.ENTER);
					s.keyUp(Key.ENTER);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
					driver.findElement(By.name("q")).click();
					Thread.sleep(2000);
					s.keyDown(Key.CTRL);
					s.type("a");
					s.keyUp(Key.CTRL);
					Thread.sleep(2000);
					s.keyDown(Key.CTRL);
					s.keyDown(Key.ALT);
					s.type("c");
					s.keyUp(Key.ALT);
					s.keyUp(Key.CTRL);
					Thread.sleep(2000);
					driver.navigate().to("https://www.google.com/");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
					s.keyDown(Key.CTRL);
					s.type("v");
					s.keyUp(Key.CTRL);
					s.keyDown(Key.ENTER);
					s.keyUp(Key.ENTER);
					Thread.sleep(5000);
					s.click("close.png");
				}
			}
		}
	}
}
