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

public class DrawingsSquarePNRLogic
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
		drawSquare(driver,400,200,300,0);
		drawSquare(driver,700,200,0,300);
		drawSquare(driver,700,500,-300,0);
		drawSquare(driver,400,500,0,-300);
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
	
	public static void drawSquare(ChromeDriver driver,int x,int y,int xo,int yo) throws Exception
	{
		Point firstpoint=new Point(x,y);
		PointerInput mouse=new PointerInput(PointerInput.Kind.MOUSE,"mouse");
		Sequence square=new Sequence(mouse,1);
		square.addAction(mouse.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),firstpoint.x,firstpoint.y));
		square.addAction(mouse.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		Point nextpoint=new Point(x+xo,y+yo);
		square.addAction(mouse.createPointerMove(Duration.ofMillis(20),PointerInput.Origin.viewport(),nextpoint.x,nextpoint.y));
		square.addAction(mouse.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(square));
		Thread.sleep(2000);
	}
}
