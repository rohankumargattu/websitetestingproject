package simonstewart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionFindElements
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.mercurytravels.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flights']")));
		List<WebElement> l1=driver.findElements(By.xpath("//*"));
		int lae=l1.size();
		System.out.println("count of all elements in page is "+lae);
		List<WebElement> l2=driver.findElements(By.xpath("//a"));
		int lol=l2.size();
		System.out.println("count of links in page is "+lol);
		List<WebElement> l3=driver.findElements(By.xpath("(//img)|(//input[@type='image'])"));
		int loi=l3.size();
		System.out.println("count of images in page is "+loi);
		String x=l3.get(10).getAttribute("alt");
		System.out.println("alt value for 11th image is "+x);
		int lotb=driver.findElements(By.xpath("//input[@type='text']")).size();
		System.out.println("count of text boxes in page is "+lotb);
		//Close site
		driver.close();
	}
}
