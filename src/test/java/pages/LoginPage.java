package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Webdriver;

public class LoginPage {

    private Webdriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement fieldUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;

    @FindBy(id = "formly_1_input_username_0")
    private WebElement fieldUsernameCheck;

    @FindBy(xpath = "(//button[normalize-space()='Login'])")
    private WebElement loginBtn;

    @FindBy(xpath = "(//p[normalize-space()=\"You're logged in!!\"])")
    private WebElement passedLoginText;

    @FindBy(xpath = "//div[@ng-if='Auth.error']")
    private WebElement incorrectMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Нажимает кнопку login")
    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }

    @Step("Заполняет поле username значением {username}")
    public LoginPage inputFieldUsername(String username){
        fieldUsername.sendKeys(username);
        return this;
    }

    @Step("Заполняет поле password значением {password}")
    public LoginPage inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
        return this;
    }

    @Step("Заполняет поле usernameCheck значением {username}")
    public LoginPage inputFieldUsernameCheck(String username){
        fieldUsernameCheck.sendKeys(username);
        return this;
    }

    @Step("Проверяет что отображается текст успешной авторизации")
    public Boolean getPassedLoginTextIsDisplayed() {
        return passedLoginText.isDisplayed();
    }

    @Step("Проверяет что отображается сообщение о некорректных данных")
    public Boolean getIncorrectMessageIsDisplayed() {
        return incorrectMessage.isDisplayed();
    }

    @Step("Проверяет кликабельность кнопки login")
    public Boolean getLoginBtnIsEnabled() {
        return loginBtn.isEnabled();
    }
}
