package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriver webDriverManager(){

        FileInputStream fileInputStream;
        Properties properties = null;

        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                    "\\src\\test\\resources\\global.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(driver == null) {
            assert properties != null;
            if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(properties.getProperty("url"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            }
        }
        return driver;
    }
}
