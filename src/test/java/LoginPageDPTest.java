import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Webdriver;

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
            Assert.assertTrue(loginPage.getIncorrectMessageIsDisplayed(), "Нет сообщения о некорректных данных");
        }
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
