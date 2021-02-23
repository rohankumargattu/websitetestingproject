package simonstewart;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksGoogle
{
	public static void main(String[] args) throws Exception
	{
		// get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word to search");
		String word=sc.nextLine();
		sc.close();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		//pagination on results pages
		int pc=0;
		//int trc=0;
		while(true)
		{
			pc++;
			System.out.println("page"+pc);
			System.out.println("-----------");
			//collect all elements in current page
			List<WebElement> l=driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//script)|(//base)|(//div)"));
			//go to each one via looping
			int tl=0;
			int cwl=0;
			int bl=0;
			for(int i=0;i<l.size();i++)
			{
				try
				{
					WebElement e=l.get(i);
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
					if(ex.getMessage().contains("stale element reference"))
					{
						//recollect again to avoid stale exception
						l=driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//script)|(//base)|(//div)"));
						i--;
					}
				}
			}//for loop completion

			System.out.println("total links count is "+tl);
			System.out.println("correctly working links count is"+cwl);
			System.out.println("broken links count is"+bl);
			//go to next page
			try
			{
				driver.findElement(By.xpath("//span[text()='Next')")).click();
				Thread.sleep(2000);
			}
			catch(Exception ex)
			{
				break;

			}
		}
		//close site
		driver.close();
	}
}
