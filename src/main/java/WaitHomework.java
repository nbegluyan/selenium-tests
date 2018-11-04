import base.BasePage;
import base.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WaitHomework extends BasePage {
    @FindBy(css = "#start button")
    private WebElement start;

    @FindBy(css = "#finish h4")
    private  WebElement loadedElement;


    public WaitHomework(){
        super();
        PageFactory.initElements(driver, this);
        driver.get(getUrl());
    }
    public String getUrl(){
        return "http://the-internet.herokuapp.com/dynamic_loading/1";
    }

    public void clickStart(){
        click(start);
        WaitHelper.getWait().waitForElementToBeVisible(loadedElement);
    }

    public boolean isFinishTextDisplayed(){
        return isDisplayed(loadedElement);
    }


    public String getFinishText() {
        return loadedElement.getText();

    }
    @Override
    public  void  isLoaded(){
        WaitHelper.getWait().waitForElementToBeVisible(start);
    }
}
