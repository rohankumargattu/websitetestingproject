package simonstewart;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindow 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.sbicard.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Login'])[4]")));
		driver.findElement(By.xpath("(//*[text()='Login'])[4]")).click();
		Thread.sleep(5000);
		ArrayList<String> al=new ArrayList<String>(driver.getWindowHandles());
		//Set<String> a=driver.getWindowHandles();
		//ArrayList<String> al=new ArrayList<String>(a);
		int c=al.size();
		System.out.println("No of tabs opened are: "+c);
		for(int i=0;i<al.size();i++)
		{
			System.out.println("Browser tab "+(i+1)+" is "+al.get(i));
		}
		driver.switchTo().window(al.get(1));
		driver.findElement(By.name("username")).sendKeys("rohan");
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(al.get(0));
		driver.findElement(By.xpath("(//*[text()='Pay Now'])[2]")).click();
		Thread.sleep(3000);
		//close browser
		driver.quit();
	}
}
