package javarobotpackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class JavaRobotBasic4 
{
	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k");
		Thread.sleep(3000);
		//Set data to clipboard
		StringSelection cmd1=new StringSelection("java");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(cmd1,null);
		//Paste that data in active window screen
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		//Click Enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		//Set data to clipboard
		StringSelection cmd2=new StringSelection("exit");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(cmd2,null);
		//Paste that data in active window screen
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		//Click Enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
