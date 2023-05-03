import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.Webdriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    public static final String TITLE = "Get Online Selenium";
    public static final String TITLE_BLOG = "Blog";
    public static final String TITLE_LIFETIME_COURSE = "Lifetime Membership Club | Free Selenium, Webservices Tutorials";
    public static final String TITLE_PRACTICE_SITE_ONE = "Welcome to the Test Site";

    public static WebDriver driver = Webdriver.getChromeDriver();
    public static MainPage mainPage = new MainPage(driver);
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static Actions actions = new Actions(driver);

    @BeforeMethod
    public void setup() throws InterruptedException {
        beforeMethod();
    }

    public void beforeMethod() throws InterruptedException {
        driver.get(Webdriver.TESTING_URL);
        // driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }

    @Test
    public void downloadWebSite() {
        Assert.assertTrue(driver.getTitle().contains(TITLE));
    }

    @Test
    public void horizontMenuTest() {
        Assert.assertTrue(mainPage.getHorizontMenu().isDisplayed());
    }

    @Test
    public void headerTest() {
        Assert.assertTrue(mainPage.getHeader().isDisplayed());
    }

    @Test
    public void windowAD() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        boolean ad;
        try {
            jse.executeScript("arguments[0].click();", mainPage.getCloseADBtn());
            ad = true;
        } catch (Exception e) {
            ad = false;
        }

        Assert.assertTrue(ad);
    }

    @Test
    public void menuScrollTest() {
        jse.executeScript("window.scrollBy(0,2500)");
        mainPage.clickBlogBtnMenu();

        Assert.assertTrue(driver.getTitle().contains(TITLE_BLOG));
    }

    @Test
    public void footerTest() {
        Assert.assertTrue(mainPage.getFooter().isDisplayed());
    }

    @Test
    public void courseTest() {
        Assert.assertTrue(mainPage.getCourse().isDisplayed());

        mainPage.clickLifetimeBtn();

        Assert.assertTrue(driver.getTitle().contains(TITLE_LIFETIME_COURSE));
    }

    /*
        @Test
        public void testingmethod() {
           actions.moveToElement(mainPage.getSliderCourse(), 700, 200)
                   .clickAndHold()
                   .moveToElement(mainPage.getSliderCourse(), 100, 200)
                   .release()
                   .build()
                   .perform();

            //mainPage.clickTESTING();
        }
    */

    @Test
    public void sliderMenuCourseTest() {
        actions.moveToElement(mainPage.getAllCoursePosition()).build().perform();

        Assert.assertTrue(mainPage.getDevOpsBtn().isDisplayed());
    }

    @Test
    public void practcieSiteOneTest() {
        actions.moveToElement(mainPage.getResourcesMenuSlider()).build().perform();
        mainPage.clickPracticeSiteOne();

        Assert.assertTrue(driver.getTitle().contains(TITLE_PRACTICE_SITE_ONE));
    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }
}
