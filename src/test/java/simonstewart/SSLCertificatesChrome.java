package simonstewart;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificatesChrome 
{
	public static void main(String[] args) throws Exception
	{
		//Code to accept SSL Certificates
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		//Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(dc);
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://cacert.org");
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
