package javarobotpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class JavaRobotBasic1
{
	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k");
		Thread.sleep(5000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
	}
}
