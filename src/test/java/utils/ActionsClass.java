package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
    Actions actions;

    public ActionsClass(WebDriver driver){
        this.actions = new Actions(driver);
    }

    public void moveToUserElement(WebElement element) {
        actions.moveToElement(element)
                .build()
                .perform();
    }

    public void mouseMovementUserElementOnlyX(WebElement element, int start, int finish) {
        actions.moveToElement(element, start, 0)
                .clickAndHold()
                .moveByOffset(finish, 0)
                .release()
                .build()
                .perform();
    }
}
