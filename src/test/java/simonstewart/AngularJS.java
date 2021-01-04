package simonstewart;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AngularJS 
{
	public static void main(String[] args) throws Exception
	{
		//Enter a word
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word into the text box");
		String text1=sc.nextLine();
		sc.close();
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://angularjs.org/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[1]")));
		//Operate AngularJS element
		String text2=driver.findElement(By.xpath("(//*[@type='text'])[1]/following-sibling::*[2]")).getText();
		System.out.println("Element text before operating it is "+text2);
		driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys(text1);
		String text3=driver.findElement(By.xpath("(//*[@type='text'])[1]/following-sibling::*[2]")).getText();
		System.out.println("Element text after operating it is "+text3);
		if(text3.contains(text1))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//Close site
		driver.close();
	}
}
