package javarobotpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.Screen;

public class Hibernate2
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
		Thread.sleep(60000);
		s.click("windows.png");
		Thread.sleep(5000);
		s.click("powetbutton.png");
		Thread.sleep(5000);
		s.click("hibernate.png");
	}
}
