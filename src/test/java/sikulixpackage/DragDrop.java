package sikulixpackage;

import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class DragDrop
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("minimize.png");
		Thread.sleep(3000);
		s.dragDrop("newtextdocument.png","newfolder.png");
		/*Match e1=s.find("newtextdocument.png");
		Match e2=s.find("newfolder.png");
		s.dragDrop(e1,e2);*/
		Thread.sleep(3000);
		s.dragDrop("newfolder.png","recyclebin.png");
		Thread.sleep(3000);
		Location l=new Location(300,300);
		s.wheel(l,Button.LEFT,0);
		s.dragDrop("recyclebin.png",l);
		/*Match e3=s.find("recyclebin.png");
		int x=e3.getX();
		int y=e3.getY();
		Location l2=new Location(x+450,y+200);
		s.dragDrop(e3,l2);*/
		Thread.sleep(3000);
		//s.click("eclipse.png");	
	}
}