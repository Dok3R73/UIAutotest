import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CookieTestPage;
import utils.CookiesMapper;
import utils.Webdriver;

@Epic("Cookies")
@Severity(SeverityLevel.NORMAL)
public class CookieTest {
    private static WebDriver driver;
    public static CookieTestPage ctp;
    public CookiesMapper cookiesMapper;

    @BeforeMethod
    public void setUp() {
        driver = Webdriver.getChromeDriver();
        ctp = new CookieTestPage(driver);
        cookiesMapper = new CookiesMapper();
    }

    @Test(priority = 1)
    @Feature("Использование cookies")
    @Story("Авторизация и сохранение cookies")
    public void saveCookie() {
        driver.get("https://www.sql-ex.ru/");
        ctp.clickLoginBtn();
        cookiesMapper.saveCookiesToFile(driver.manage().getCookies());
    }

    @Test(priority = 2)
    @Feature("Использование cookies")
    @Story("Проверка авторизации используя cookies")
    public void loginCookies() {
        driver.get("https://www.sql-ex.ru/");
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();

        for (Cookie cookie : cookiesMapper.readCookiesFromFile()) {
            driver.manage().addCookie(cookie);
        }

        driver.navigate().refresh();
        Assert.assertTrue(ctp.getbtnExit(), "Авторизация не удалась, cookies не загружены");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public void lastMethod() {
        cookiesMapper.deleteFileCookies();
    }
}
