import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Epic("Авторизация")
@Severity(SeverityLevel.NORMAL)
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
        driver.get(Webdriver.TESTING_LOGIN_URL);
    }

    @Test(priority = 1)
    @Feature("Валидация полей")
    @Story("Некорректный ввод логина и пароля (регистр)")
    public void incorrectCaseUsernameTest() {
        loginPage.inputFieldUsername(CASE_USERNAME)
                .inputFieldPassword(CASE_PASSWORD)
                .inputFieldUsernameCheck(CASE_USERNAME)
                .clickLoginBtn();
        Assert.assertTrue(loginPage.getIncorrectMessageIsDisplayed(), "Нет сообщения о некорректных данных");
    }

    @Test(priority = 2)
    @Feature("Валидация полей")
    @Story("Некорректный ввод пароля (регистр)")
    public void incorrectCasePasswordTest() {
        loginPage.inputFieldUsername(USERNAME)
                .inputFieldPassword(CASE_PASSWORD)
                .inputFieldUsernameCheck(USERNAME)
                .clickLoginBtn();
        Assert.assertTrue(loginPage.getIncorrectMessageIsDisplayed(), "Нет сообщения о некорректных данных");
    }

    @Test(priority = 3)
    @Feature("Валидация полей")
    public void emptyFieldTest() {
        loginPage.inputFieldUsernameCheck(USERNAME)
                .inputFieldPassword(PASSWORD);
        Assert.assertFalse(loginPage.getLoginBtnIsEnabled(), "Кнопка активна");
    }

    @Test(priority = 4)
    @Feature("Валидация полей")
    @Story("Некорректный ввод логина и пароля")
    public void incorrectUsernameAndPasswordTest() {
        loginPage.inputFieldUsername(INCORRECT_USERNAME_AND_PASSWORD)
                .inputFieldPassword(INCORRECT_USERNAME_AND_PASSWORD)
                .inputFieldUsernameCheck(INCORRECT_USERNAME_AND_PASSWORD)
                .clickLoginBtn();
        Assert.assertTrue(loginPage.getIncorrectMessageIsDisplayed(), "Нет сообщения о некорректных данных");
    }


    @Test(priority = 5)
    @Story("Успешная авторизация")
    public void correctLoginTest() {
        loginPage.inputFieldUsername(USERNAME)
                .inputFieldPassword(PASSWORD)
                .inputFieldUsernameCheck(USERNAME)
                .clickLoginBtn();
        Assert.assertTrue(loginPage.getPassedLoginTextIsDisplayed(), "Нет сообщения о успешной авторизации");
    }

    @Test(priority = 6)
    @Story("Проверка работы скриншота")
    public void correctLoginTestFail() {
        loginPage.inputFieldUsername(USERNAME)
                .inputFieldPassword(PASSWORD)
                .inputFieldUsernameCheck(USERNAME)
                .clickLoginBtn();
        Assert.assertTrue(loginPage.getPassedLoginTextIsDisplayed(), "Нет сообщения о успешной авторизации");
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
