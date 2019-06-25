package Research_D1_Sap;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sap_Demo {

	WebDriver driver;
	JavascriptExecutor jse;
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		Sap_Demo demoObj = new Sap_Demo();
		
		demoObj.invokeBrowser();
		demoObj.initializeSAPFiory();
		demoObj.forecastMD61();
		demoObj.runMRPME59N();

	}
	
	
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "U:\\Research Paper\\Selenium\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	public void initializeSAPFiory()
	{
		
		try 
		{
			Thread.sleep(1200);
			driver.get("https://dijon.cob.csuchico.edu:8042/erp");
			driver.findElement(By.id("USERNAME_FIELD-inner")).sendKeys("H4");
			Thread.sleep(1200);
			
			driver.findElement(By.id("PASSWORD_FIELD-inner")).sendKeys("Onsjhjsa1087");
			Thread.sleep(1200);
			
			driver.findElement(By.id("CLIENT_FIELD-inner")).clear();
			Thread.sleep(1200);
			
			driver.findElement(By.id("CLIENT_FIELD-inner")).sendKeys("485");
			Thread.sleep(1200);
			
			driver.findElement(By.xpath("//span[@class='sapMBtnContent sapMLabelBold sapUiSraDisplayBeforeLogin']")).click();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void forecastMD61()
	{
		
		try {
			driver.findElement(By.id("erpsim-tcode-btn-img")).click();
			Thread.sleep(1200);
			
			driver.findElement(By.id("TCode-input-inner")).sendKeys("MD61");
			Thread.sleep(1200);
			
			driver.findElement(By.id("TCode-launchBtn-content")).click();
			//Thread.sleep(1200);
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			driver.switchTo().frame("ITSFRAME1");
			driver.findElement(By.id("M0:46:::4:2-imgStd")).click();
		    driver.findElement(By.id("M0:46:::4:26")).clear();
		    driver.findElement(By.id("M0:46:::4:26")).sendKeys("HH-F");
		    driver.findElement(By.id("M0:50::btn[0]")).click();	
		    driver.switchTo().defaultContent();
		    Thread.sleep(8000);
		    
		    //driver.switchTo().defaultContent();
		    /*Thread.sleep(40000);
		    
		    driver.switchTo().frame(driver.findElement(By.id("tbl626533[1,8]_c")));
		    driver.switchTo().frame("ITSFRAME1");
		    driver.findElement(By.id("tbl626533[1,8]_c")).clear();
		    driver.findElement(By.id("tbl626533[1,8]_c")).sendKeys("800");*/
		    
		    //driver.switchTo().window(tabs.get(1));
		    //driver.switchTo().frame("ITSFRAME1");
		    
		    /*WebDriverWait wait = new WebDriverWait(driver, 40);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tbl623932[1,8]_c']")));*/
		    
		    /*driver.findElement(By.xpath("//input[@id='tbl623932[1,8]_c']")).clear();
		    driver.findElement(By.xpath("//input[@id='tbl623932[1,8]_c']")).sendKeys("800");*/
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}//End of Forecast
	
	public void runMRPME59N() throws InterruptedException
	{
		Thread.sleep(1200);
		driver.get("https://dijon.cob.csuchico.edu:8042/erp");
		
		driver.findElement(By.id("erpsim-tcode-btn-img")).click();
		Thread.sleep(1200);
		
		driver.findElement(By.id("TCode-input-inner")).sendKeys("ME59N");
		Thread.sleep(1200);
		
		driver.findElement(By.id("TCode-launchBtn-content")).click();
		Thread.sleep(1200);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		driver.switchTo().frame("ITSFRAME1");
		driver.findElement(By.id("M0:50::btn[8]")).click();
		driver.findElement(By.id("M0:50::btn[8]")).click();
		driver.findElement(By.id("M0:50::btn[8]")).click();
	
	}//End of MRP
	
	
	
}//End of Class
