package learn;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class automation2 {
	public static WebDriver driver;
    String chrome_path;
    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    public static String file_location = "D:\\Jinesh\\Selenium\\TestData.xls";
    static String SheetName= "SearchString";
    public  String Res;
    //Write obj1=new Write();
    public int DataSet=-1;
    
    @DataProvider
    public static Object[][] ReadVariant() throws IOException
    {
    FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
        workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        HSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
         
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
                HSSFRow row= worksheet.getRow(i+1);
                 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        HSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
            }
 
        return Data;
    }
    
    @Test (dataProvider="ReadVariant")
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
		//driver.close();
		//softAssert.assertAll();
	}
	
	@AfterMethod
	public void testTeadDown() {
		driver.close();
		
	}
}


