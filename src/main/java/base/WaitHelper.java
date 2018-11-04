package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.DriverHelper.getDriver;

public class WaitHelper {
    public static WaitHelper getWait(){
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }

    public static void waitForElementToBeVisible(By location) {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(location));
    }
    public static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(getDriver(), 15)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
