package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//div[@class='ast-builder-grid-row ast-builder-grid-row-has-sides ast-builder-grid-row-no-center']")
    private WebElement horizontMenu;

    @FindBy(xpath = "//body/div[@id='page']/header[@id='masthead']/div[@id='ast-desktop-header']/div[1]")
    private WebElement header;

    @FindBy(xpath = "//i[@class='eicon-close']")
    private WebElement closeADBtn;

    @FindBy(xpath = "(//span[contains(@class,'menu-text')][normalize-space()='Blog'])[2]")
    private WebElement blogBtnMenu;

    @FindBy(xpath = "//div[@data-id='3a83f54f']")
    private WebElement footer;

    @FindBy(xpath = "//div[@data-id='4fd7f709']")
    private WebElement course;

    @FindBy(xpath = "(//a[@role='button'])[1]")
    private WebElement courseLifetimeBtn;

    @FindBy(xpath = "//li[@id='menu-item-27617']//span[@class='menu-text'][normalize-space()='Resources']")
    private WebElement resourcesMenuSlider;

    @FindBy(xpath = "(//a[@class='elementor-button elementor-slide-button elementor-size-sm'][normalize-space()='Learn More'])[2]")
    private WebElement testingBUTTON;

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

    public void clickPracticeSiteOne(){
        practiceSiteOne.click();
    }

    public void clickTESTING() {
        testingBUTTON.click();
    }

    public void clickLifetimeBtn() {
        courseLifetimeBtn.click();
    }

    public WebElement getSliderCourse() {
        return sliderCourse;
    }

    public WebElement getDevOpsBtn() {
        return devOpsBtn;
    }

    public WebElement getAllCoursePosition() {
        return allCoursePosition;
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getCourse() {
        return course;
    }

    public WebElement getResourcesMenuSlider() {
        return resourcesMenuSlider;
    }

    public WebElement getHorizontMenu() {
        return horizontMenu;
    }

    public WebElement getCloseADBtn() {
        return closeADBtn;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getBlogBtnMenu() {
        return blogBtnMenu;
    }
}
