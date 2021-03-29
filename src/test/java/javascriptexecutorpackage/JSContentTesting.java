package javascriptexecutorpackage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSContentTesting
{
	public static void main(String[] args) throws Exception
	{
		//Take data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word to search");
		String word=sc.nextLine();
		System.out.println("Enter related reference word to search word");
		String refword=sc.nextLine();
		sc.close();
		//Launch browser
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys(word,Keys.ENTER);
		int page=0;
		int trc=0;
		while(true)	//infinite loop
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
			page++;
			String rtext=(String) driver.executeScript("return(document.documentElement.innerText);");
			Pattern p=Pattern.compile(refword,Pattern.CASE_INSENSITIVE);
			Matcher m=p.matcher(rtext);
			int prc=0;
			while(m.find())
			{
				prc++;
				trc++;
			}
			System.out.println("\""+refword+"\""+" found "+prc+" times in page "+page+" of results");
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']"))).click();
			}
			catch(Exception ex)
			{
				break;
			}
		}
		System.out.println("\""+refword+"\""+" found "+trc+" times in all results pages");
		//Close site
		driver.close();
	}
}
