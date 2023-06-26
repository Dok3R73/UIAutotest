import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Epic("Авторизация")
@Severity(SeverityLevel.NORMAL)
public class LoginPageDPTest {
    public static final String USERNAME = "angular";
    public static final String PASSWORD = "password";
    public static final String CASE_USERNAME = "Angular";
    public static final String CASE_PASSWORD = "pAssWoRd";
    public static final String INCORRECT_USERNAME_AND_PASSWORD = "test";

    public static WebDriver driver = Webdriver.getChromeDriver();
    public static LoginPage loginPage = new LoginPage(driver);

    @BeforeMethod
    public void setup() {
        driver.get(Webdriver.TESTING_LOGIN_URL);
    }

    @DataProvider(name = "loginData")
    public Object[][] testData() {
        return new Object[][]{
                {CASE_USERNAME, CASE_PASSWORD},
                {USERNAME, CASE_PASSWORD},
                {INCORRECT_USERNAME_AND_PASSWORD, INCORRECT_USERNAME_AND_PASSWORD},
                {USERNAME, PASSWORD}
        };
    }

    @Test(dataProvider = "loginData", priority = 1)
    @Feature("Валидация полей")
    @Story("Проверка авторизации с различными данными")
    public void loginTest(String username, String password) {
        loginPage.inputFieldUsername(username)
                .inputFieldPassword(password)
                .inputFieldUsernameCheck(username)
                .clickLoginBtn();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            Assert.assertTrue(loginPage.getPassedLoginTextIsDisplayed(), "Нет сообщения об успешной авторизации");
        } else {
            Assert.assertTrue(loginPage.getIncorrectMessageIsDisplayed(), "Нет  сообщения о некорректных данных");
        }
    }

    @AfterMethod
    public void afterEachTest(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        }
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
