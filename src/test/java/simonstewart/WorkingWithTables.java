package simonstewart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithTables
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Open site
		driver.get("http://www.gmail.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//Maximize
		driver.manage().window().maximize();
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("gatturohankumar");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("gatturohan@134");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		//Get count of mails in mail box table
		List<WebElement> nom=driver.findElements(By.xpath("(//*[@role='tabpanel'])[1]/descendant::table/tbody/tr"));
		System.out.println("No of mails in 1st page is "+nom.size());
		//Get count of columns for each row(1 mail) in mail box table
		List<WebElement> noc=driver.findElements(By.xpath("(//*[@role='tabpanel'])[1]/descendant::table/tbody/tr[1]/td"));
		System.out.println("No of columns for each mail is "+noc.size());
		//Select 1st mail in mail box
		driver.findElement(By.xpath("(//*[@role='tabpanel'])[1]/descendant::table/tbody/tr[1]/td[2]/div")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='G-Ni G-aE J-J5-Ji']/div[3])[1]/div")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='G-Ni G-aE J-J5-Ji']/div[3])[1]/div")));
		driver.findElement(By.xpath("(//*[@class='G-Ni G-aE J-J5-Ji']/div[3])[1]/div")).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'moved to Trash')]")));
		//Do logout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label,'Google Account')]/span")));
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Sign out']")));
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//Close site
		driver.close();	
	}
}
