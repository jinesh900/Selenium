package learn;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.ExcelUtils;

public class automation1 {

			 
	    WebDriver driver;
	    private String sTestCaseName;
	    
	   private int iTestCaseRow;
	    
	 
	  @DataProvider(name = "Authentication")
	 
	  public  Object[][] credentials() throws Exception {
	 
	      
	 
	        return new Object[][] { { "Sri Lanka" }, { "Singapore"}};
	 
	  }
	
	@Test (dataProvider="Authentication")
	//public static void main (String[] args) {
	public void test(String sSearchText) {
		System.setProperty("webdriver.chrome.driver", "D:\\Jinesh\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		//Dimension d = new Dimension(300,500);
		//driver.manage().window().setSize(d);
		driver.manage().window().maximize();
		String title =driver.getTitle();
		System.out.println(title);
		if (title.equals("Google")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
			
		}
		WebElement el = driver.findElement(By.name("q"));
		el.sendKeys(sSearchText);
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("btnK"))));
		driver.findElement(By.name("btnK")).click();
		title=driver.getTitle();
		//SoftAssert softAssert = new SoftAssert();
		Assert.assertFalse(title.contains(sSearchText), "actual title is "+title);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		driver.close();
		//softAssert.assertAll();
	}
	
	@Test (dataProvider="Authentication")
	//public static void main (String[] args) {
	public void test1(String sSearchText) {
		System.setProperty("webdriver.chrome.driver", "D:\\Jinesh\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("http://www.google.com");
		//Dimension d = new Dimension(300,500);
		//driver.manage().window().setSize(d);
		driver.manage().window().maximize();
		String title =driver.getTitle();
		System.out.println(title);
		if (title.equals("Google")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
			
		}
		WebElement el = driver.findElement(By.name("q"));
		el.sendKeys(sSearchText);
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("btnK"))));
		driver.findElement(By.name("btnK")).click();
		title=driver.getTitle();
		//SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(title.contains(sSearchText), "actual title is "+title);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		driver.close();
		//softAssert.assertAll();
	}
	
	@AfterClass
	public void testTeadDown() {
		WebDriver driver1=this.driver;
		driver1.quit();
		System.out.println("Class Teardown");
		
	}
	
	
}
