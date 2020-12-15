package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiveElement 
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
		Thread.sleep(5000);
		//Do login
		driver.switchTo().activeElement().sendKeys("gatturohankumar");
		Thread.sleep(3000);
		driver.findElement(By.name("identifier")).clear();
		Thread.sleep(3000);
		//Close site
		driver.close();	
	}
}
