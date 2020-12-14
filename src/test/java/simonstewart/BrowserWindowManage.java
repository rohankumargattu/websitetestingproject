package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowManage
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Open site
		driver.get("http://www.gmail.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//Maximize browser window
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get size details of browser window
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println("Total Width of browser window is "+w+"\nTotal Height of browser window is "+h);
		//Set size for browser window
		Dimension d=new Dimension(200,100); //Width and Height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get position details of browser window
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println("X position of browser window is "+x+"\nY position of browser window is "+y);
		//Set position for browser window
		Point p=new Point(100,400); //X and Y
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//Close site
		driver.close();	
	}
}
