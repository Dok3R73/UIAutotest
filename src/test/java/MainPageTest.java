import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.ActionsClass;
import utils.JavaScriptExecutor;
import utils.Webdriver;

@Severity(SeverityLevel.NORMAL)
@Epic("UI-тестирование")
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
    }

    @Test
    @Feature("Загрузка сайта")
    @Story("Заголовок страницы")
    public void downloadWebSite() {
        Assert.assertTrue(driver.getTitle().contains(TITLE), "Заголовок неправильный / сайт не загрузился");
    }

    @Test
    @Feature("Горизонтальное меню")
    @Story("Отображение горизонтального меню")
    public void horizontalMenuTest() {
        Assert.assertTrue(mainPage.getHorizontalMenuIsDisplayed(), "Горизонтальное меню не отображается");
    }

    @Test
    @Feature("Хидер")
    @Story("Отображение хидера")
    public void headerTest() {
        Assert.assertTrue(mainPage.getHeaderIsDisplayed(), "Хидер не отображается");
    }

    @Test
    @Feature("Главная страница")
    @Story("Отображение рекламы")
    public void windowAD() {
        actions.moveToUserElement(mainPage.getHeader());
        Assert.assertTrue(mainPage.getCloseADBtnIsDisplayed(), "Реклама не отображается");
    }

    @Test
    @Feature("Прокрутка главной страницы")
    @Story("Редирект на страницу блог в отображаемом меню при прокрутке страницы")
    public void menuScrollTest() {
        jse.scrollPositive();
        mainPage.clickBlogBtnMenu();
        Assert.assertTrue(driver.getTitle().contains(TITLE_BLOG), "Заголовок неправильный / нет редиректа");
    }

    @Test
    @Feature("Подвал")
    @Story("Отображение подвала")
    public void footerTest() {
        Assert.assertTrue(mainPage.getFooterIsDisplayed(), "Подвал не отображается");
    }

    @Test
    @Feature("Блок курсов")
    @Story("Отображение блока курсов и редирект на страницу курса при нажатии на кнопку read more")
    public void courseTest() {
        actions.moveToUserElement(mainPage.getHeader());
        Assert.assertTrue(mainPage.getCourseIsDisplayed(), "Курсы не отображаются");
        mainPage.clickLifetimeBtn();
        Assert.assertTrue(driver.getTitle().contains(TITLE_LIFETIME_COURSE), "Заголовок неправильный / нет редиректа");
    }

    @Test
    @Feature("Слайдер курсов")
    @Story("Отображение слайдера курсов и его работоспособность")
    public void sliderBlockTest() {
        actions.moveToUserElement(mainPage.getSliderCourse());
        mainPage.clickCloseADBtn();
        actions.mouseMovementUserElementOnlyX(mainPage.getSliderCourse(), 300, -500);
        actions.mouseMovementUserElementOnlyX(mainPage.getSliderCourse(), 300, -500);
        Assert.assertTrue(mainPage.getSliderElementIsDisplayed(), "Сладер не сработал");
    }

    @Test
    @Feature("Список урсов")
    @Story("Отображение списка курсов и отображение кнопки DevOps")
    public void sliderMenuCourseTest() {
        actions.moveToUserElement(mainPage.getAllCoursePosition());
        Assert.assertTrue(mainPage.getDevOpsBtnIsDisplayed(), "Кнопака devOps не отображается");
    }

    @Test
    @Feature("Практический сайт 1")
    @Story("Редирект на страницу Практического сайта 1 при нажатии на соответствующую кнопку в меню")
    public void practiceSiteOneTest() {
        actions.moveToUserElement(mainPage.getResourcesMenuSlider());
        mainPage.clickPracticeSiteOne();
        Assert.assertTrue(driver.getTitle().contains(TITLE_PRACTICE_SITE_ONE), "Заголовок неправильный / нет редиректа");
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
