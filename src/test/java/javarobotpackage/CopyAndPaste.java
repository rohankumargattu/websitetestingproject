package javarobotpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class CopyAndPaste
{
	public static void main(String[] args) throws Exception
	{
		ChromeDriver driver=new ChromeDriver();
		Robot r=new Robot();
		Screen s=new Screen();
		
		//For Paste
		//Selenium
		if(System.getProperty("os.name").contains("Windows"))
		{
			driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.META,"v"));
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
		}
		
		//Java Robot
		if(System.getProperty("os.name").contains("Windows"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			r.keyPress(KeyEvent.VK_META);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_META);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		//SikuliX
		if(System.getProperty("os.name").contains("Windows"))
		{
			s.keyDown(Key.CTRL);
			s.type("v");
			s.keyUp(Key.CTRL);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			s.keyDown(Key.META);
			s.type("v");
			s.keyUp(Key.META);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			s.keyDown(Key.CTRL);
			s.type("v");
			s.keyUp(Key.CTRL);
		}
		
		//For Copy
		//Selenium
		if(System.getProperty("os.name").contains("Windows"))
		{
			driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.META,"c"));
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ALT,"c"));
		}
		
		//Java Robot
		if(System.getProperty("os.name").contains("Windows"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			r.keyPress(KeyEvent.VK_META);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_META);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_ALT);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		//SikuliX
		if(System.getProperty("os.name").contains("Windows"))
		{
			s.keyDown(Key.CTRL);
			s.type("c");
			s.keyUp(Key.CTRL);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			s.keyDown(Key.META);
			s.type("c");
			s.keyUp(Key.META);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			s.keyDown(Key.CTRL);
			s.keyDown(Key.ALT);
			s.type("c");
			s.keyUp(Key.ALT);
			s.keyUp(Key.CTRL);
		}
	}
}
