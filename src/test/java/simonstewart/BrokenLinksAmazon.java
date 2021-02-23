package simonstewart;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksAmazon
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.amazon.com");
		Thread.sleep(5000);
		List<WebElement> l=driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//script)|(//base)|(//div)"));
		//go to each one via looping
		int tl=0;
		int cwl=0;
		int bl=0;
		for(WebElement e:l)
		{
			try
			{
				//test case1:element have href attribute r not
				if(e.getAttribute("href")!=null)
				{
					String x=e.getAttribute("href");

					//test case2:href attribute is url r not	
					if(x.startsWith("https")||x.startsWith("http"))
					{
						//testcase3:url related server responding r not	
						tl++;
						URL u=new URL(x);
						HttpURLConnection con=(HttpURLConnection) u.openConnection();
						con.connect();
						String y=con.getResponseMessage();
						int z=con.getResponseCode();
						con.disconnect();
						if(z>=200 && z<=299)
						{
							cwl++;
						}
						else
						{
							bl++;
							System.out.println(x+"send"+y+"with"+z);
						}
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}

		//loop completion
		System.out.println("total links count is"+tl);
		System.out.println("correctly working links are"+cwl);
		System.out.println("broken links are"+bl);
		//close site
		driver.close();
	}
}
