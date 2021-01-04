package sikulixpackage;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class YoutubeProgram 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.youtube.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='search'])[2]")));
		Screen s=new Screen();
		s.type("youtubetextbox.png","abdul kalam speeches");
		s.click("youtubesearchbutton.png");
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Abdul Kalam in European Parliament")));
		driver.findElement(By.partialLinkText("Abdul Kalam in European Parliament")).click();
		Thread.sleep(5000);
		if(s.exists("skipad.png")!=null)
		{
			s.click("skipad.png");
		}
		else if(s.exists("skipads.png")!=null)
		{
			s.click("skipads.png");
		}
		s.wheel(Button.WHEEL_DOWN,10);
		Thread.sleep(2000);
		s.wheel(Button.WHEEL_UP,10);
		Thread.sleep(5000);
		Location l=new Location(300,300);
		s.wheel(l,Button.LEFT,0);
		s.click("pause.png");
		Thread.sleep(5000);
		s.wheel(l,Button.LEFT,0);
		Thread.sleep(5000);
		s.click("play.png");
		s.wheel(l,Button.LEFT,0);
		s.mouseMove("volume.png");
		Thread.sleep(3000);
		Match e=s.find("bubble.png");
		int x=e.getX();
		int y=e.getY();
		Location l1=new Location(x-20,y);
		s.dragDrop(e,l1);
		Thread.sleep(5000);
		Location l2=new Location(x+20,y);
		s.dragDrop(e,l2);
		Thread.sleep(5000);
		//Capture full screenshot
		File f1=new File("youtubefullsssikulix.png");
		ScreenImage si1=s.capture();
		BufferedImage bi1=si1.getImage();
		ImageIO.write(bi1, "png", f1);
		//Capture part of screen as screenshot
		File f2=new File("youtubepartofscreensikulix.png");
		Region r=new Region(100,100,800,400);
		ScreenImage si2=s.capture(r);
		BufferedImage bi2=si2.getImage();
		ImageIO.write(bi2, "png", f2);
		Thread.sleep(3000);
		s.click("close.png");
	}
}
