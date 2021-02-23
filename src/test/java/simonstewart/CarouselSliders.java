package simonstewart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselSliders 
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.ebay.com");
		Thread.sleep(5000);
		//locate carousel slider specific for corresponding carousel slider
		WebElement cslider=driver.findElement(By.className("carousel__viewport"));
		//common cod
		//testcase-1 get count of visible slides
		String tn=cslider.getTagName();
		int count=0;
		List<WebElement> slides;
		if(tn.equals("div"))
		{
			//every child<div> is a slide
			slides=cslider.findElements(By.xpath("child::div"));
			for(WebElement slide:slides)
			{
				try
				{
					if(slide.getAttribute("data-clone").equals("false"))
					{
						count=count+1;
					}
				}
				catch(Exception ex)
				{
					//developer didnt used data clone concept
					count=count+1;
				}
			}
		}

		else//developed using <ul> or <ol>

		{
			//each slide is child<li> tag
			slides=cslider.findElements(By.xpath("child::li"));
			count=slides.size();
			//took all because all slides are visible by default
		}
		System.out.println("count of all visible slides is"+count);
		//testcase-2 2D or 3D slides
		String a=cslider.getCssValue("transform");
		if(a.equals("none"))
		{
			//take transform-style property value
			a=cslider.getCssValue("transform-style");

		}
		//verification
		if(a.contains("3d"))
		{
			System.out.println("3D slider");
		}
		else
		{
			System.out.println("2D slider");

		}
		//testcase-3:slides are moving or not automatically
		String b=cslider.getCssValue("transform");
		if(b.equals("none"))
		{
			System.out.println("not moving automaticlally");

		}
		else
		{
			System.out.println(" moving automaticlally");

			//testcase-4 get direction of moving slides
			System.out.println("transform property value is"+b);
			String c=b.substring(7,b.length()-1);
			String[] p=c.split(",");
			p[4]=p[4].trim();
			p[5]=p[5].trim();
			float x=Float.parseFloat(p[4]);
			float y=Float.parseFloat(p[5]);
			if(x<0 && y==0)
			{
				System.out.println("slides are moving from right to left");
			}
			else if(x>0 && y==0)
			{
				System.out.println("slides are moving from left to right");
			}
			else if(x==0 && y<0)
			{
				System.out.println("slides are moving from bottom to top");
			}
			else // y>0
			{
				System.out.println("slides are moving from top to bottom");
			}

			//testcase-5 get ease options:

			String d=cslider.getCssValue("transistion");
			System.out.println(d);
			String[] q=d.split(" ");//sepaartor is blank space
			if(q[2].equals("ease-in"))
			{
				System.out.println("slow start for each slide");

			}
			else if(q[2].equals("ease-out"))
			{
				System.out.println("slow end for each slide");
			}
			else //ease-in or ease-out
			{
				System.out.println("slow start slow end for each slide");
			}

			//testcase-6 get duration of slide

			System.out.println("duration of each slide is"+q[1]);

			//testcase-7 get dealy between slides

			q[3].replace(",", "");
			System.out.println("duration of each slide is"+q[3]);

		}
		//close site
		driver.close();
	}
}
