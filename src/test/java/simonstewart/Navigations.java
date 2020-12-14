package simonstewart;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		driver.navigate().to("http://www.gmail.com");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
