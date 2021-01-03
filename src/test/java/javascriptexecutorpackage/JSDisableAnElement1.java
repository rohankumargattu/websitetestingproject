package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSDisableAnElement1
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://demo.guru99.com/test/newtours/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER")));
		driver.findElement(By.linkText("REGISTER")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		//Disable an element
		WebElement e1=driver.findElement(By.name("city"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('disabled','true');",e1);
		Thread.sleep(3000);
		js.executeScript("arguments[0].removeAttribute('disabled');",e1);
		driver.findElement(By.name("firstName")).sendKeys("Rohan");
		driver.findElement(By.name("lastName")).sendKeys("Kumar");
		driver.findElement(By.name("phone")).sendKeys("9030957386");
		driver.findElement(By.name("userName")).sendKeys("gatturohankumar@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("207");
		driver.findElement(By.name("address2")).sendKeys("India");
		if(driver.findElement(By.name("city")).isEnabled())
		{
			driver.findElement(By.name("city")).sendKeys("Hyderabad");
		}
		driver.findElement(By.name("state")).sendKeys("Telangana");
		driver.findElement(By.name("postalCode")).sendKeys("500035");
		WebElement e2=driver.findElement(By.name("country"));
		Select s=new Select(e2);
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email")).sendKeys("gatturohankumar");
		driver.findElement(By.name("password")).sendKeys("gatturohankumar134");
		driver.findElement(By.name("confirmPassword")).sendKeys("gatturohankumar134");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("register")));
		driver.findElement(By.name("register")).click();
		//driver.findElement(By.name("register")).submit();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
