package javascriptexecutorpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSHandlingInvisibleElementsByCreatingAlert
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
		//driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]")).click();
		List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/div[2]/div"));
		System.out.println("No of items in <div> tag dropdown are "+l.size());
		JavascriptExecutor js=(JavascriptExecutor) driver;
		for(int i=0;i<l.size();i++)
		{
			js.executeScript("var x=arguments[0].textContent;window.alert(x);",l.get(i));
			Thread.sleep(1000);
			String y=driver.switchTo().alert().getText();
			System.out.println((i+1)+"."+y);
			driver.switchTo().alert().accept();
		}
		//Close site
		driver.close();
	}
}
