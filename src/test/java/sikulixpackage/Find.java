package sikulixpackage;

import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Find 
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(2000);
		Match e=s.find("thispc.png");
		s.doubleClick(e);
		Thread.sleep(3000);
		s.click("close.png");
		Thread.sleep(2000);
		//s.click("eclipse.png");
	}
}