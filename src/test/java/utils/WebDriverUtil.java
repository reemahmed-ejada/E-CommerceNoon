package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

    public static WebDriver getDriver() {
       // WebDriverManager.chromedriver().setup();
       // WebDriverManager.edgedriver().setup();
       // return new EdgeDriver();

         WebDriverManager.firefoxdriver().setup();
         return new FirefoxDriver();
    }
}
