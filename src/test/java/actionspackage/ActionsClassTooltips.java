package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassTooltips 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Open site
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		//Maximize
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Top')]")));
		//Get tool-tip value
		WebElement e1=driver.findElement(By.linkText("JAVASCRIPT"));
		Actions a=new Actions(driver);
		a.moveToElement(e1).build().perform();
		String ttv1=e1.getAttribute("title");
		System.out.println("Tooltip Value for JAVASCRIPT element is "+ttv1);
		Thread.sleep(2000);
		WebElement e2=driver.findElement(By.xpath("//div[contains(text(),'Top')]"));
		a.moveToElement(e2).clickAndHold().build().perform();
		String ttv2=driver.findElement(By.xpath("//div[contains(text(),'Top')]/span")).getText();
		a.release().build().perform();
		System.out.println("Tooltip Value for Top element is "+ttv2);
		Thread.sleep(2000);
		WebElement e3=driver.findElement(By.xpath("//div[contains(text(),'Right')]"));
		a.moveToElement(e3).clickAndHold().build().perform();
		String ttv3=driver.findElement(By.xpath("//div[contains(text(),'Right')]/span")).getText();
		a.release().build().perform();
		System.out.println("Tooltip Value for Right element is "+ttv3);
		Thread.sleep(2000);
		WebElement e4=driver.findElement(By.xpath("//div[contains(text(),'Bottom')]"));
		a.moveToElement(e4).clickAndHold().build().perform();
		String ttv4=driver.findElement(By.xpath("//div[contains(text(),'Bottom')]/span")).getText();
		a.release().build().perform();
		System.out.println("Tooltip Value for Bottom element is "+ttv4);
		Thread.sleep(2000);
		WebElement e5=driver.findElement(By.xpath("//div[contains(text(),'Left')]"));
		a.moveToElement(e5).clickAndHold().build().perform();
		String ttv5=driver.findElement(By.xpath("//div[contains(text(),'Left')]/span")).getText();
		a.release().build().perform();
		System.out.println("Tooltip Value for Left element is "+ttv5);
		Thread.sleep(2000);
		//Close site
		driver.close();
	}
}
