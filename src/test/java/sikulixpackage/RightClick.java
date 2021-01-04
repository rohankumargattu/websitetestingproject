package sikulixpackage;

import org.sikuli.script.Screen;

public class RightClick 
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(3000);
		s.rightClick("thispc.png");
		Thread.sleep(3000);
		s.click("open.png");
		Thread.sleep(3000);
		s.click("close.png");
		Thread.sleep(3000);
		s.click("eclipse.png");
	}
}
