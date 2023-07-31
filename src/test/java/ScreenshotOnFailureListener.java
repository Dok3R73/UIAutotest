import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.IOException;

public class ScreenshotOnFailureListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {

        try {
            takeScreenshot(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public Screenshot takeScreenshot(ITestResult result) throws IOException {
        LoginPageTest loginPageTest = (LoginPageTest) result.getInstance();
        WebDriver driver = loginPageTest.getDriver();
        return new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
    }
}



