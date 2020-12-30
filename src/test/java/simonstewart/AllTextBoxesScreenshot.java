package simonstewart;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllTextBoxesScreenshot 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.mercurytravels.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("holidays")));
		//Take screenshot of all images in page
		List<WebElement> tbs=driver.findElements(By.xpath("//input[@type='text']"));
		int c=tbs.size();
		System.out.println("Total no of text boxes are: "+c);
		for(int i=0;i<tbs.size();i++)
		{
			if(tbs.get(i).isDisplayed())
			{
				int x=tbs.get(i).getLocation().getX();
				int y=tbs.get(i).getLocation().getY();
				int w=tbs.get(i).getSize().getWidth();
				int h=tbs.get(i).getSize().getHeight();
				//Get Page Screenshot
				File src=driver.getScreenshotAs(OutputType.FILE);
				BufferedImage bfull=ImageIO.read(src);
				BufferedImage bele=bfull.getSubimage(x, y, w, h);
				ImageIO.write(bele,"png",src);
				File dest=new File("E:\\Automation\\simonstewart\\mercurytravelsimages\\eless"+(i+1)+".png");
				FileHandler.copy(src, dest);	
			}	
		}
		//Close site
		driver.close();
	}
}
