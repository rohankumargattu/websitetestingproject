package sikulixpackage;

import java.util.Iterator;

import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class FindAll 
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(2000);
		s.doubleClick("thispc.png");
		Thread.sleep(1000);
		s.doubleClick("edrive.png");
		Thread.sleep(1000);
		Iterator<Match> l=s.findAll("edrivefilefolder.png");
		for(int i=0;i<8;i++)
		{
			l.next().click();
			Thread.sleep(1000);
		}
		s.click("close.png");
		Thread.sleep(1000);
		s.click("eclipse.png");
	}
}