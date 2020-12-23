package simonstewart;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementScreenshot 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//Take Screenshot of Page
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("fullss.png");
		FileHandler.copy(src, dest);
		//Take Screenshot of element
		WebElement e=driver.findElement(By.xpath("//img[@alt='Google']"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		File src1=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage bfull=ImageIO.read(src1);
		BufferedImage bele=bfull.getSubimage(x, y, w, h);
		ImageIO.write(bele, "png", src1);
		File dest1=new File("eless.png");
		FileHandler.copy(src1, dest1);
		//Close site
		driver.close();	
	}
}
