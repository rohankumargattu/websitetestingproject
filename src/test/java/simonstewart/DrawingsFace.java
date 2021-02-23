package simonstewart;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DrawingsFace
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.groupboard.com/demo/groupboard-online-whiteboard-demo.shtml");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Got It!']"))).click();
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("centre"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("trash"))).click();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		Point headorgin=new Point(450,250);
		Point lefteye=headorgin.moveBy(-50,-50);
		Point righteye=headorgin.moveBy(50,-50);
		Point mouth=headorgin.moveBy(0,50);
		drawcircle(driver,headorgin,150,60,"full");
		drawcircle(driver,lefteye,20,20,"full");
		drawcircle(driver,righteye,20,20,"full");
		drawcircle(driver,mouth,25,20,"half");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.close();		
	}
	public static void drawcircle(ChromeDriver driver,Point orgin,double radius, int steps,String style)
	{
		Point firstpoint=new Point((int) (orgin.x+radius),orgin.y);
		PointerInput pi=new PointerInput(PointerInput.Kind.MOUSE,"mouse");
		Sequence circle=new Sequence(pi,1);
		circle.addAction(pi.createPointerMove(Duration.ofMillis(20),PointerInput.Origin.viewport(),firstpoint.x,firstpoint.y));
		circle.addAction(pi.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		int p=steps;
		if(style.equals("half"))
		{
			p=steps/2;
		}
		for(int i=1;i<=p;i++)
		{
			double theta=2*Math.PI*((double)i/steps);
			int xoffset=(int) Math.floor(Math.cos(theta)*radius);
			int yoffset=(int) Math.floor(Math.sin(theta)*radius);
			Point nextpoint=new Point(orgin.x+xoffset,orgin.y+yoffset);
			circle.addAction(pi.createPointerMove(Duration.ofMillis(50),PointerInput.Origin.viewport(),nextpoint.x,nextpoint.y));	
		}
		
		circle.addAction(pi.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(circle));
	}
}
