package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSCreatingAlert 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.alert('Ammaaa....... Oka paata padana, Oka paata');");
		Thread.sleep(1000);
		String y=driver.switchTo().alert().getText();
		System.out.println(y);
		driver.switchTo().alert().accept();
		//Close site
		driver.close();
	}
}
