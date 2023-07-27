package utils;

import lombok.Getter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;
@Getter
public class Webdriver {

    public static ChromeDriver driver;

    public static final String TESTING_URL = "https://www.way2automation.com/";
    public static final String TESTING_LOGIN_URL = "https://www.way2automation.com/angularjs-protractor/registeration/#/login";

    public static ChromeDriver getChromeDriver() {
        if (driver == null) {
            String path = System.getProperty("user.dir");
            String chromeDriverPath = path + "\\webdrivers\\chromedriver114.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.addArguments("--remote-allow-origins=*");


            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
