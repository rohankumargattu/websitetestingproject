package simonstewart;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificatesOpera
{
	public static void main(String[] args) throws Exception
	{
		OperaOptions o=new OperaOptions();
		o.setBinary("C:\\Users\\gattu\\AppData\\Local\\Programs\\Opera\\58.0.3135.53\\opera.exe");
		//Code to accept SSL Certificates
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		dc.setCapability(OperaOptions.CAPABILITY,o);
		//Launch browser
		System.setProperty("webdriver.opera.driver","operadriver.exe");
		OperaDriver driver=new OperaDriver(dc);
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://cacert.org");
		Thread.sleep(3000);
		//Close site
		driver.close();
	}
}
