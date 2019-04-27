import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowPage extends BasePage {
    @FindBy(css = ".example a")
    private WebElement clickHereLink;

    @FindBy(css = ".example h3")
    private WebElement newPageMessage;

    public MultipleWindowPage() {
        super();
        driver.get(getUrl());
    }

    public String getUrl() {
        return "http://the-internet.herokuapp.com/windows";
    }

    public void clickOnClickHere() {
        click(clickHereLink);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getNewTabText() {
        return newPageMessage.getText();
    }

    public void changeTab(int index) {
        Object[] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window(windows[1].toString());
    }


}

