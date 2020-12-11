package simonstewart;

import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveElement 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.switchTo().activeElement().sendKeys("gatturohankumar");
		Thread.sleep(5000);
		//Close site
		driver.close();	
	}
}
