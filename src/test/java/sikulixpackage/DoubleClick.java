package sikulixpackage;

import org.sikuli.script.Screen;

public class DoubleClick
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(3000);
		s.doubleClick("thispc.png");
		Thread.sleep(3000);
		s.click("close.png");
		Thread.sleep(3000);
		s.click("eclipse.png");
	}
}