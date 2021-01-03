package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSScrolling
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dropdown'][@class='ui header'])[1]")));
		
		//Scroll to bottom
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		//driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(3000);
		
		//Scroll to Top
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		//driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(3000);
		
		//Scroll to specific element
		//js.executeScript("document.getElementsByClassName(('(//*[@class='ui dropdown'])')[2]).scrollIntoView();");
		//driver.executeScript("document.getElementsByClassName(('(//*[@class='ui dropdown'])')[2]).scrollIntoView();");
		//Thread.sleep(3000);
		
		WebElement e=driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]"));
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(3000);
		js.executeScript("arguments[0].style.border='2px dashed red';",e);
		//driver.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(3000);
		
		//Close site
		driver.close();	
	}
}
