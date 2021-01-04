package simonstewart;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificatesIE
{
	public static void main(String[] args) throws Exception
	{
		//Code to accept SSL Certificates
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		//Launch browser
		System.setProperty("webdriver.ie.driver","iedriverserver.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver(dc);
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://cacert.org");
		Thread.sleep(3000);
		//Close site
		driver.close();
	}
}
