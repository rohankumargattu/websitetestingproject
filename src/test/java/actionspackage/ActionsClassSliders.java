package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassSliders 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://jqueryui.com/slider/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='demo-frame']")));
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement hs=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		Actions a=new Actions(driver);
		int x=hs.getLocation().getX();
		int y=hs.getLocation().getY();
		//Left to Right
		a.dragAndDropBy(hs, 400, 0).build().perform();
		Thread.sleep(3000);
		//Right to Left
		a.dragAndDropBy(hs, -200, 0).build().perform();
		Thread.sleep(3000);
		//Back to page
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Vertical slider']")));
		driver.findElement(By.xpath("//*[text()='Vertical slider']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='demo-frame']")));
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement vs=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		int p=vs.getLocation().getX();
		int q=vs.getLocation().getY();
		//Top to bottom
		a.dragAndDropBy(vs, 0, 80).build().perform();
		Thread.sleep(3000);
		//Bottom to top
		a.dragAndDropBy(vs, 0, -120).build().perform();
		Thread.sleep(3000);
		//Back to page
		driver.switchTo().defaultContent();
		//Close site
		driver.close();
	}
}
