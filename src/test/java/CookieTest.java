import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.CookieTestPage;
import utils.CookiesMapper;
import utils.Webdriver;

import java.io.IOException;

public class CookieTest {
    private static WebDriver driver = Webdriver.getChromeDriver();
    public static CookieTestPage ctp = new CookieTestPage(driver);
    public CookiesMapper cookiesMapper = new CookiesMapper();


    @Test(priority = 1)
    public void loginAndUseSavedCookies(){
        if (cookiesMapper.existsFileCookies()) {
            driver.get("https://www.sql-ex.ru/");
            driver.navigate().refresh();
            driver.manage().deleteAllCookies();

            for (Cookie cookie : cookiesMapper.readCookiesFromFile()) {
                driver.manage().addCookie(cookie);
            }

            driver.navigate().refresh();
            Assert.assertTrue(ctp.getbtnExit());

        } else {
            driver.get("https://www.sql-ex.ru/");
            ctp.clickLoginBtn();
            cookiesMapper.saveCookiesToFile(driver.manage().getCookies());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

