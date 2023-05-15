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

    @FindBy(xpath = "//li[@id='menu-item-27617']//span[@class='menu-text'][normalize-space()='Resources']")
    private WebElement resourcesMenuSlider;

    @FindBy(xpath = "//div[@class='elementor-repeater-item-4508007 swiper-slide swiper-slide-active']//a[@class='elementor-button elementor-slide-button elementor-size-sm'][normalize-space()='Register Now']")
    private WebElement registerNowBtn;

    @FindBy(xpath = "//div[@class='elementor-swiper']")
    private WebElement sliderCourse;

    @FindBy(xpath = "//li[@id='menu-item-27580']//span[@class='sub-arrow']")
    private WebElement allCoursePosition;

    @FindBy(xpath = "//li[@id='menu-item-27592']")
    private WebElement devOpsBtn;

    @FindBy(id = "menu-item-27618")
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

    public void clickRegisterNowBtn() {
        registerNowBtn.click();
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
