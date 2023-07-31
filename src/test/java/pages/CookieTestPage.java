package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookieTestPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='subm2']")
    private WebElement loginBtn;

    public void clickLoginBtn() {
        loginBtn.click();
    }

    @FindBy(xpath = "//img[@title='Выход...']")
    private WebElement btnExit;

    public CookieTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean getbtnExit() {
        return btnExit.isDisplayed();
    }
}
