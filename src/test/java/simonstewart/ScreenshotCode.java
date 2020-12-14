package simonstewart;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotCode 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.co.in");
		Thread.sleep(5000);
		
		//Way 1(Screenshot in Specified Location)
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\Automation\\bomma.png");
		FileHandler.copy(src, dest);
		
		//Way 2(Screenshot in Project folder)
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dest1=new File("bomma.png");
		FileHandler.copy(src1, dest1);
		
		//Way 3(Screenshot in Specified Location with dynamic name)
		SimpleDateFormat sf=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date dt=new Date();
		String fname=sf.format(dt)+".png";
		File src2=driver.getScreenshotAs(OutputType.FILE);
		File dest2=new File("E:\\Automation\\"+fname);
		FileHandler.copy(src2, dest2);
		
		//Way 4(Screenshot in project folder with dynamic name)
		SimpleDateFormat sf2=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		Date dt2=new Date();
		String fname2=sf.format(dt2)+".png";
		File src3=driver.getScreenshotAs(OutputType.FILE);
		File dest3=new File(fname2);
		FileHandler.copy(src3, dest3);
	}
}
