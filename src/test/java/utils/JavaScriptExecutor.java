package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutor {

    JavascriptExecutor jse;

    public JavaScriptExecutor(WebDriver driver) {
        this.jse = (JavascriptExecutor) driver;
    }

    public void scrollPositive() {
        jse.executeScript("window.scrollBy(0,2500)");
    }

    public void scrollNegative() {
        jse.executeScript("window.scrollBy(0,-2500)");
    }
}
