package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Webdriver {

    public static final String TESTING_URL = "https://www.way2automation.com/";
    public static final String TESTING_LOGIN_URL = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";

    public static ChromeDriver getChromeDriver() {
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "\\webdrivers\\chromedriver113.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
