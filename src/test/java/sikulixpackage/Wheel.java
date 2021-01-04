package sikulixpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class Wheel
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.seleniumhq.org/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Downloads']")));
		//X,Y,Width and Height of browser window/tab
		int x1=driver.manage().window().getPosition().getX();
		int y1=driver.manage().window().getPosition().getY();
		int w1=driver.manage().window().getSize().getWidth();
		int h1=driver.manage().window().getSize().getHeight();
		x1=x1+8; //since x1 and y1 are -8 beyond the browser, moving to which we loose the cursor visibility
		y1=y1+8; //since x1 and y1 are -8 beyond the browser, moving to which we loose the cursor visibility
		Screen s=new Screen();
		s.click("minimize.png"); //Browser
		Thread.sleep(2000);
		s.click("minimize.png"); //Eclipse
		Thread.sleep(2000);
		Location l1=new Location(x1,y1); 
		s.wheel(l1,Button.LEFT,0);
		Thread.sleep(2000);
		int x2=x1+(w1/2);
		int y2=y1+(h1/2);
		Location l2=new Location(x2,y2);
		s.wheel(l2,Button.LEFT,0);
		Thread.sleep(2000);
		Location l3=new Location(300,300);
		s.wheel(l3,Button.RIGHT,1);
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(2000);
		s.click("chrome.png");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Downloads']")));
		driver.findElement(By.xpath("//*[text()='Downloads']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Downloads'])[2]")));
		s.wheel(l3,Button.LEFT,0);
		s.wheel(Button.WHEEL_DOWN,100);
		Thread.sleep(2000);
		s.wheel(Button.WHEEL_UP,100);
		Thread.sleep(2000);
		//Close site
		s.click("close.png");
		s.click("eclipse.png");	
	}
}