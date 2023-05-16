package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@data-section='section-primary-header-builder']")
    private WebElement horizontalMenu;

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//i[@class='eicon-close']")
    private WebElement closeADBtn;

    @FindBy(xpath = "(//span[contains(@class,'menu-text')][normalize-space()='Blog'])[2]")
    private WebElement blogBtnMenu;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//div[@class='elementor-icon-box-content']")
    private WebElement course;

    @FindBy(xpath = "(//a[@role='button'])[1]")
    private WebElement courseLifetimeBtn;

    @FindBy(xpath = "//span[@class='menu-text'][normalize-space()='Resources']")
    private WebElement resourcesMenuSlider;

    @FindBy(xpath = "(//div[@class='elementor-slide-heading'][normalize-space()='Selenium 4.0 Latest Live batch'])[2]")
    private WebElement sliderElement;

    @FindBy(xpath = "//div[@class='elementor-swiper']")
    private WebElement sliderCourse;

    @FindBy(xpath = "(//span[@class='menu-text'][normalize-space()='All Courses'])")
    private WebElement allCoursePosition;

    @FindBy(xpath = "(//span[@class='menu-text'][normalize-space()='DevOps'])[1]")
    private WebElement devOpsBtn;

    @FindBy(xpath = "(//span[@class='menu-text'][normalize-space()='Practice Site 1'])[1]")
    private WebElement practiceSiteOne;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickBlogBtnMenu() {
        blogBtnMenu.click();
    }

    public void clickPracticeSiteOne() {
        practiceSiteOne.click();
    }

    public void clickCloseADBtn() {
        closeADBtn.click();
    }

    public void clickLifetimeBtn() {
        courseLifetimeBtn.click();
    }

    public WebElement getSliderCourse() {
        return sliderCourse;
    }

    public Boolean getDevOpsBtnIsDisplayed() {
        return devOpsBtn.isDisplayed();
    }

    public Boolean getSliderElementIsDisplayed(){
        return sliderElement.isDisplayed();
    }

    public WebElement getAllCoursePosition() {
        return allCoursePosition;
    }

    public Boolean getHeaderIsDisplayed() {
        return header.isDisplayed();
    }

    public Boolean getCourseIsDisplayed() {
        return course.isDisplayed();
    }

    public WebElement getResourcesMenuSlider() {
        return resourcesMenuSlider;
    }

    public Boolean getHorizontalMenuIsDisplayed() {
        return horizontalMenu.isDisplayed();
    }

    public Boolean getCloseADBtnIsDisplayed() {
        return closeADBtn.isDisplayed();
    }

    public Boolean getFooterIsDisplayed() {
        return footer.isDisplayed();
    }

    public WebElement getHeader() {
        return header;
    }

}
