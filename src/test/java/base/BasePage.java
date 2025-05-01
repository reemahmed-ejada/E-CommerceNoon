package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ExtentReportManager;
import utils.PropertiesFileReader;
import utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected static ExtentReports extentReport;
    protected static ExtentTest extentTest;
    private static PropertiesFileReader propReader;
    @BeforeMethod
    public void setUp() {
       //Load properties File

        propReader = new PropertiesFileReader();
        propReader.getProperties();
        driver = WebDriverUtil.getDriver(PropertiesFileReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesFileReader.getProperty("timeout")), TimeUnit.SECONDS);
        driver.get(PropertiesFileReader.getProperty("baseUrl"));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    public String captureScreenshot(String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }

}
