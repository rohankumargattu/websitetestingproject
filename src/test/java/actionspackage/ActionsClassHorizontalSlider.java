package actionspackage;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassHorizontalSlider
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter x offset value for forward slide");
		int xos=sc.nextInt();
		System.out.println("Enter y offset value for forward slide");
		int yos=sc.nextInt();
		System.out.println("Enter x offset value for backward slide");
		int xos2=sc.nextInt();
		System.out.println("Enter y offset value for backward slide");
		int yos2=sc.nextInt();
		sc.close();
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
		
		//Dimensions of slider
		WebElement slider=driver.findElement(By.xpath("//*[@id='slider']"));
		int sw=slider.getSize().getWidth();
		System.out.println("Width of slider is "+sw);
		
		//Location of element
		WebElement e1=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		int ex=e1.getLocation().getX();
		int ey=e1.getLocation().getY();
		System.out.println("Initial X value of element is "+ex);
		System.out.println("Initial Y value of element is "+ey);
		
		//Create actions class object
		Actions a=new Actions(driver);
		
		//Percentage of slider movement
		String distance1=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]")).getAttribute("style");
		String ps1=distance1.substring(6,distance1.length()-2);
		int num1=Integer.parseInt(ps1);
		System.out.println("Element is at "+num1+"% before sliding");
		
		//Automating slider
		//Forward slide
		if((ex+xos)<sw)
		{
			a.dragAndDropBy(e1, xos, yos).build().perform();
			int ex2=e1.getLocation().getX();
			int ey2=e1.getLocation().getY();
			System.out.println("X value of element after forward sliding is "+ex2);
			System.out.println("Y value of element after forward sliding is "+ey2);
			Thread.sleep(3000);
			String distance2=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]")).getAttribute("style");
			String ps2=distance2.substring(6,distance2.length()-2);
			int num2=Integer.parseInt(ps2);
			System.out.println("Element is at "+num2+"% after forward sliding");
			
			//Backward slide
			if((xos2+ex2)>0)
			{
				a.dragAndDropBy(e1, xos2, yos2).build().perform();
				int ex3=e1.getLocation().getX();
				int ey3=e1.getLocation().getY();
				System.out.println("X value of element after backward sliding is "+ex3);
				System.out.println("Y value of element after backward sliding is "+ey3);
				Thread.sleep(3000);
				String distance3=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]")).getAttribute("style");
				String ps3=distance3.substring(6,distance3.length()-2);
				int num3=Integer.parseInt(ps3);
				System.out.println("Element is at "+num3+"% after backward sliding");
			}
			else
			{
				System.out.println("Given Sliding Length is Out of Bound for Backward Slide");
			}
		}
		else
		{
			System.out.println("Given Sliding Length is Out of Bound for Forward Slide");
		}
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//Close site
		driver.close();	
	}
}
