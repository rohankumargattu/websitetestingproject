package sikulixpackage;

import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class MouseMove
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(2000);
		s.mouseMove("thispc.png");
		Thread.sleep(2000);
		s.mouseMove(300,300); //this method takes offset values for x and y(distances to be moved from current cursor position)
		Thread.sleep(2000);
		Location l=new Location(800,500);
		s.mouseMove(l);
		Thread.sleep(2000);
		s.click("eclipse.png");	
	}
}
