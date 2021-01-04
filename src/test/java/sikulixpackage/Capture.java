package sikulixpackage;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Capture
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//Capture full screenshot
		File f1=new File("fullsssikulix.png");
		Screen s=new Screen();
		ScreenImage si1=s.capture();
		BufferedImage bi1=si1.getImage();
		ImageIO.write(bi1, "png", f1);
		//Capture part of screen as screenshot
		File f2=new File("partofscreensikulix.png");
		Region r=new Region(100,100,800,400);
		ScreenImage si2=s.capture(r);
		BufferedImage bi2=si2.getImage();
		ImageIO.write(bi2, "png", f2);
		//Close site
		driver.close();	
	}
}
