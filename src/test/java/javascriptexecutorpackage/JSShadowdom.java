package javascriptexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSShadowdom
{
	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site using base url given by developer
		driver.get("https://material-components.github.io/material-components-web-components/demos/switch.html"); 
		Thread.sleep(5000);
		//Locate html parent 
		WebElement p1=driver.findElement(By.xpath("//mwc-switch[1]"));
		//Now we can use it to find the shadow root element
		driver.executeScript("arguments[0].shadowRoot.querySelector('input').click();",p1);
		//Locate html parent 
		WebElement p2=driver.findElement(By.xpath("//mwc-switch[2]"));
		//Now we can use it to find the shadow root element
		driver.executeScript("arguments[0].shadowRoot.querySelector('input').click();",p2);

	}

}
