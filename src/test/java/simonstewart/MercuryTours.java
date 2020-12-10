package simonstewart;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercuryTours
{
	public static void main(String[] args) throws Exception
	{
		//Declare Global objects
		RemoteWebDriver driver = null;
		
		//Take input from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String bn=sc.nextLine();
		sc.close();
		
		//Similar for all browsers
		//System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		//Bonigarcia dependency code to get compatible browser driver s/w automatically wrt browser
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.silentOutput","true");
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else
		{
			System.out.println("Enter correct browser name");
			System.exit(0); //Stop execution forcibly
		}
		
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://demo.guru99.com/test/newtours/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		driver.findElement(By.name("firstName")).sendKeys("Priyanka");
		driver.findElement(By.name("lastName")).sendKeys("Tummalapalli");
		driver.findElement(By.name("phone")).sendKeys("9030957386");
		driver.findElement(By.name("userName")).sendKeys("Priya");
		driver.findElement(By.name("address1")).sendKeys("In all our hearts");
		driver.findElement(By.name("city")).sendKeys("Eden Gardens");
		driver.findElement(By.name("state")).sendKeys("Telangana");
		driver.findElement(By.name("postalCode")).sendKeys("560050");
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("UNITED STATES");
		//s.selectByValue("UNITED STATES");
		driver.findElement(By.name("email")).sendKeys("Priyankat@minneapolis.com");
		driver.findElement(By.name("password")).sendKeys("rohan");
		driver.findElement(By.name("confirmPassword")).sendKeys("rohan");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("submit"))).click();
		String x=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your user name is Priyankat')]"))).getText();
		if(x.contains("Priyankat"))
		{
			System.out.println("Registration Test Passed");
		}
		else
		{
			System.out.println("Registration Test Failed");
		}
		//Close site
		driver.close();
	}
}
