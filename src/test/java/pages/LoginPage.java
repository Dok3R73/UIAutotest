package pages;

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
    private WebElement fieldUsername2;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement loginBtn;

    @FindBy(xpath = "(//p[normalize-space()=\"You're logged in!!\"])[1]")
    private WebElement passedLoginText;

    @FindBy(xpath = "//div[@class='alert alert-danger ng-binding ng-scope']")
    private WebElement incorrectMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void inputFieldUsername(String username){
        fieldUsername.sendKeys(username);
    }

    public void inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }

    public void inputFieldUsername2(String username){
        fieldUsername2.sendKeys(username);
    }

    public WebElement getPassedLoginText() {
        return passedLoginText;
    }

    public WebElement getIncorrectMessage() {
        return incorrectMessage;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public void clearAllField(){
        fieldUsername.clear();
        fieldPassword.clear();
        fieldUsername2.clear();
    }
}
