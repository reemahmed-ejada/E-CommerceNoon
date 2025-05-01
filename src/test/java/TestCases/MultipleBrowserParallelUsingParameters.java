package TestCases;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserParallelUsingParameters {

   public  WebDriver driver;
    @BeforeTest
    @Parameters("drivervalue")
    public void setUp(String drivervalue){

        if (drivervalue.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (drivervalue.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }
    @Test
    public void TestMultiple(){
        driver.get("https://stackoverflow.com/questions/54948789/how-to-add-listeners-class-in-testng-xml");
        System.out.println(driver.toString());

    }
    @AfterTest
    public void tearDown(){
      driver.close();
    }
}
