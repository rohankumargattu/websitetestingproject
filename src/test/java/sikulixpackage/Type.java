package sikulixpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class Type
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
		Screen s=new Screen();
		s.type("googletextbox.png","virat kohli");
		Thread.sleep(1000);
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
		s.click("close.png");
		Thread.sleep(2000);
		//s.click("eclipse.png");
	}
}
