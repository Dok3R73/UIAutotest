import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.ActionsClass;
import utils.JavaScriptExecutor;
import utils.Webdriver;

public class MainPageTest {

    public static final String TITLE = "Get Online Selenium";
    public static final String TITLE_BLOG = "Blog";
    public static final String TITLE_LIFETIME_COURSE = "Lifetime Membership Club | Free Selenium, Webservices Tutorials";
    public static final String TITLE_PRACTICE_SITE_ONE = "Welcome to the Test Site";

    public static WebDriver driver = Webdriver.getChromeDriver();
    public static MainPage mainPage = new MainPage(driver);
    public static JavaScriptExecutor jse = new JavaScriptExecutor(driver);
    public static ActionsClass actions = new ActionsClass(driver);

    @BeforeMethod
    public void setup() {
        driver.get(Webdriver.TESTING_URL);
        // driver.manage().window().fullscreen();
    }

    @Test
    public void downloadWebSite() {
        Assert.assertTrue(driver.getTitle().contains(TITLE), "Заголовок неправильный");
    }

    @Test
    public void horizontalMenuTest() {
        Assert.assertTrue(mainPage.getHorizontalMenuIsDisplayed(), "Горизонтальное меню не отображается");
    }

    @Test
    public void headerTest() {
        Assert.assertTrue(mainPage.getHeaderIsDisplayed(), "Хидер не отображается");
    }

    @Test
    public void windowAD() {
        actions.moveToUserElement(mainPage.getHeader());

        Assert.assertTrue(mainPage.getCloseADBtnIsDisplayed(), "Реклама не отображается");
    }

    @Test
    public void menuScrollTest() {
        jse.scrollPositive();

        mainPage.clickBlogBtnMenu();

        Assert.assertTrue(driver.getTitle().contains(TITLE_BLOG), "Заголовок неправильный");
    }

    @Test
    public void footerTest() {
        Assert.assertTrue(mainPage.getFooterIsDisplayed(), "Подвал не отображается");
    }

    @Test
    public void courseTest() {
        actions.moveToUserElement(mainPage.getHeader());

        Assert.assertTrue(mainPage.getCourseIsDisplayed(), "Курсы не отображаются");

        mainPage.clickLifetimeBtn();

        Assert.assertTrue(driver.getTitle().contains(TITLE_LIFETIME_COURSE), "Заголовок неправильный");
    }

    @Test
    public void sliderBlockTest() {
        actions.moveToUserElement(mainPage.getSliderCourse());

        mainPage.clickCloseADBtn();

        actions.mouseMovementUserElementOnlyX(mainPage.getSliderCourse(), 300, -500);

        mainPage.clickRegisterNowBtn();

        Assert.assertTrue(driver.getTitle().contains(TITLE_LIFETIME_COURSE), "Заголовок неправильный");
    }

    @Test
    public void sliderMenuCourseTest() {
        actions.moveToUserElement(mainPage.getAllCoursePosition());

        Assert.assertTrue(mainPage.getDevOpsBtnIsDisplayed(), "Кнопака devOps не отображается");
    }

    @Test
    public void practiceSiteOneTest() {
        actions.moveToUserElement(mainPage.getResourcesMenuSlider());

        mainPage.clickPracticeSiteOne();

        Assert.assertTrue(driver.getTitle().contains(TITLE_PRACTICE_SITE_ONE), "Заголовок неправильный");
    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }
}
