package sikulixpackage;

import org.sikuli.script.Screen;

public class Click 
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(3000);
		s.click("eclipse.png");
	}
}