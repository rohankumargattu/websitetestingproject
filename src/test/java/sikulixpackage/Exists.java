package sikulixpackage;

import org.sikuli.script.Screen;

public class Exists 
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(3000);
		if(s.exists("eclipse.png")!=null)
		{
			s.click("eclipse.png");
		}
	}
}
