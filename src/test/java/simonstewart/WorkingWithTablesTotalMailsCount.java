package simonstewart;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTablesTotalMailsCount
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("http://www.gmail.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("magnitiait");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']/parent::*"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("Magnitia@05");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']/parent::*"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		//Pagination
		int enoam=0;
		while(2>1)
		{
			List<WebElement> mails=driver.findElements(By.xpath("(//table)[7]/tbody/tr"));
			int nomp=mails.size();
			//Add count of mails in current page to total count
			enoam=enoam+nomp;
			//Go to next page
			try
			{
				if(driver.findElement(By.xpath("//*[@aria-label='Older']")).getAttribute("aria-disabled").equals("true"))
				{
					break;
				}
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath("//*[@aria-label='Older']")).click();
			}
		}
		
		//Get actual count all mails
		int anoam=Integer.parseInt(driver.findElement(By.xpath("//*[@aria-label='Show more messages']/span/span[2]")).getText());
		//Validations
		System.out.println("Program count is "+enoam);
		System.out.println("Website count is "+anoam);
		if(enoam==anoam)
		{
			System.out.println("Total mails count test passed");
		}
		else
		{
			System.out.println("Total mails count test failed");
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
			Date d=new Date();
			String fname=sf.format(d)+".png";
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(fname);
			FileHandler.copy(src, dest);
		}
		//Do logout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label,'Google Account')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Use another account']")));
		//Close site
		driver.close();	
	}
}
