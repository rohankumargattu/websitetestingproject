package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods3
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
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("gatturohankumar");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("gatturohan@134");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		driver.findElement(By.name("to")).sendKeys("gatturohankumar@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Via Automation",Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"),Keys.TAB,Keys.chord(Keys.CONTROL,"v"),"\n",Keys.chord(Keys.CONTROL,"v"));
		Thread.sleep(3000);
		driver.findElement(By.name("subjectbox")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("subjectbox")).sendKeys("Via Automation");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Send']")));
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message sent')]")));
		String x=driver.findElement(By.xpath("//*[contains(text(),'Message sent')]")).getText();
		System.out.println("Text of Message sent element is: "+x);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label,'Google Account')]/span")));
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Sign out']")));
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.get("http://www.google.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		Thread.sleep(5000);
		String y=driver.findElement(By.name("q")).getAttribute("maxlength");
		System.out.println("Value of an attribute is "+y);
		//Close site
		driver.close();
	}
}
