package simonstewart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercuryToursDataDrivenForRegistrationDataExcel
{
	public static void main(String[] args) throws Exception
	{
		//Declare Global objects
		RemoteWebDriver driver = null;
		
		File f=new File("registrationdetails.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		int nouc=sh.getRow(0).getLastCellNum();
		//Give headings to results in excel file
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		String result=sf.format(dt);
		sh.getRow(0).createCell(nouc).setCellValue("Result on "+result);
		//Data Driven from 2nd row(index=1)
		for(int i=1;i<nour;i++)
		{
			//Read data from excel
			DataFormatter df=new DataFormatter();
			String fn=df.formatCellValue(sh.getRow(i).getCell(0));
			String ln=df.formatCellValue(sh.getRow(i).getCell(1));
			String ph=df.formatCellValue(sh.getRow(i).getCell(2));
			String uname=df.formatCellValue(sh.getRow(i).getCell(3));
			String add=df.formatCellValue(sh.getRow(i).getCell(4));
			String city=df.formatCellValue(sh.getRow(i).getCell(5));
			String state=df.formatCellValue(sh.getRow(i).getCell(6));
			String postalcode=df.formatCellValue(sh.getRow(i).getCell(7));
			String country=df.formatCellValue(sh.getRow(i).getCell(8));
			String email=df.formatCellValue(sh.getRow(i).getCell(9));
			String pass=df.formatCellValue(sh.getRow(i).getCell(10));
			String cpass=df.formatCellValue(sh.getRow(i).getCell(11));
			String bn=df.formatCellValue(sh.getRow(i).getCell(12));
			
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
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
				driver.findElement(By.name("firstName")).sendKeys(fn);
				driver.findElement(By.name("lastName")).sendKeys(ln);
				driver.findElement(By.name("phone")).sendKeys(ph);
				driver.findElement(By.name("userName")).sendKeys(uname);
				driver.findElement(By.name("address1")).sendKeys(add);
				driver.findElement(By.name("city")).sendKeys(city);
				driver.findElement(By.name("state")).sendKeys(state);
				driver.findElement(By.name("postalCode")).sendKeys(postalcode);
				WebElement e=driver.findElement(By.name("country"));
				Select s=new Select(e);
				s.selectByVisibleText(country);
				//s.selectByValue("UNITED STATES");
				driver.findElement(By.name("email")).sendKeys(email);
				driver.findElement(By.name("password")).sendKeys(pass);
				driver.findElement(By.name("confirmPassword")).sendKeys(cpass);
				wait.until(ExpectedConditions.elementToBeClickable(By.name("submit"))).click();
				String output=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your user name is "+email+"')]"))).getText();
				if(output.contains(email))
				{
					sh.getRow(i).createCell(nouc).setCellValue("Registration Test Passed for "+email);
				}
				else
				{
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(result+".png");
					FileHandler.copy(src, dest);
					sh.getRow(i).createCell(nouc).setCellValue("Registration Test Failed for "+email);
				}
			}
			catch(Exception ex)
			{
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(result+".png");
				FileHandler.copy(src, dest);
				sh.getRow(i).createCell(nouc).setCellValue(ex.getMessage()+" and see "+dest.getAbsolutePath());
			}
			
			//Close site
			driver.close();
		}
		sh.autoSizeColumn(nouc);
			
		//Save data back to excel
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		fi.close();
		fo.close();
		wb.close();
	}
}
