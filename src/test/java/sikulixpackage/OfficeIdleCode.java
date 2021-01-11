package sikulixpackage;

import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class OfficeIdleCode 
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		while(2>1)
		{
			Location l1=new Location(500,500);
			s.wheel(l1,Button.LEFT,0);
			Thread.sleep(600000);
			Location l2=new Location(800,500);
			s.wheel(l2,Button.LEFT,0);
			Thread.sleep(600000);
		}
	}
}
