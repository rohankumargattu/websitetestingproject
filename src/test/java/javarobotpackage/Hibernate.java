package javarobotpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.Screen;

public class Hibernate 
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize");
		Thread.sleep(3000);
		Robot r=new Robot();
		if(s.exists("minimize")!=null)
		{
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_D);
			r.keyRelease(KeyEvent.VK_D);
			r.keyRelease(KeyEvent.VK_WINDOWS);
		}
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
