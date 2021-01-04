package javarobotpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class JavaRobotBasic3 
{
	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
	}
}
