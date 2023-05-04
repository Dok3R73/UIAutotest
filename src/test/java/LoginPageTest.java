import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Webdriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    public static final String USERNAME = "angular";
    public static final String PASSWORD = "password";
    public static final String CASE_USERNAME = "Angular";
    public static final String CASE_PASSWORD = "pAssWoRd";
    public static final String INCORRECT_USERNAME_AND_PASSWORD = "test";


    public static WebDriver driver = Webdriver.getChromeDriver();
    public static LoginPage loginPage = new LoginPage(driver);

    @BeforeMethod
    public void setup() {
        beforeMethod();
    }

    public void beforeMethod(){
        driver.get(Webdriver.TESTING_LOGIN_URL);
        // driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void incorrectCaseUsernameTest() {
        loginPage.inputFieldUsername(CASE_USERNAME);
        loginPage.inputFieldPassword(PASSWORD);
        loginPage.inputFieldUsername2(CASE_USERNAME);
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.getIncorrectMessage().isDisplayed());

    }

    @Test(priority = 2)
    public void incorrectCasePasswordTest() {
        loginPage.inputFieldUsername(USERNAME);
        loginPage.inputFieldPassword(CASE_PASSWORD);
        loginPage.inputFieldUsername2(USERNAME);
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.getIncorrectMessage().isDisplayed());
    }

    @Test(priority = 3)
    public void emptyFieldTest(){
        loginPage.inputFieldUsername2(USERNAME);
        loginPage.inputFieldPassword(PASSWORD);
        Assert.assertFalse(loginPage.getLoginBtn().isEnabled());
    }

    @Test(priority = 4)
    public void incorrectUsernameAndPasswordTest() {
        loginPage.inputFieldUsername(INCORRECT_USERNAME_AND_PASSWORD);
        loginPage.inputFieldPassword(INCORRECT_USERNAME_AND_PASSWORD);
        loginPage.inputFieldUsername2(INCORRECT_USERNAME_AND_PASSWORD);
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.getIncorrectMessage().isDisplayed());
    }


    @Test(priority = 5)
    public void correctLoginTest() {
        loginPage.inputFieldUsername(USERNAME);
        loginPage.inputFieldPassword(PASSWORD);
        loginPage.inputFieldUsername2(USERNAME);
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.getPassedLoginText().isDisplayed());
    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }
}
