package simonstewart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods2
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.google.in");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		String title=driver.getTitle();
		System.out.println("Page title is "+title);
		String page_source=driver.getPageSource();
		System.out.println("Page source is in Project folder in \"pagesource\" text file");
		File f=new File("pagesource.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Page source code is: \n"+page_source);
		String url=driver.getCurrentUrl();
		System.out.println("Page url is "+url);
		if(url.contains("https"))
		{
			System.out.println("Secured Site");
		}
		else
		{
			System.out.println("Unsecured Site");
		}
		//Close site
		driver.close();
	}
}
