package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassVerticalSlider
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Vertical slider']")));
		driver.findElement(By.xpath("//*[text()='Vertical slider']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='demo-frame']")));
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		//Location of element
		WebElement e=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		System.out.println("X value of element is "+x);
		System.out.println("Y value of element is "+y);
		//Create actions class object
		Actions a=new Actions(driver);
		//Slide from top to bottom
		a.dragAndDropBy(e, 0, 100).build().perform();
		Thread.sleep(3000);
		//Slide from bottom to top
		a.dragAndDropBy(e, 0, -150).build().perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//Close site
		driver.close();	
	}
}
