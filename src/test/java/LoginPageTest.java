import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import utils.Webdriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    public static final String USERNAME = "angular";
    public static final String PASSWORD = "password";
    public static final String CASE_USERNAME = "AnGulaR";
    public static final String CASE_PASSWORD = "pAssWoRd";
    public static final String INCORRECT_USERNAME_AND_PASSWORD = "test";


    public static WebDriver driver = Webdriver.getChromeDriver();
    public static MainPage mainPage = new MainPage(driver);
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static Actions actions = new Actions(driver);

    @BeforeMethod
    public void setup() throws InterruptedException {
        beforeMethod();
    }

    public void beforeMethod() throws InterruptedException {
        driver.get(Webdriver.TESTING_LOGIN_URL);
        // driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }
}
