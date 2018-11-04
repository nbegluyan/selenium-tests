import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passField;

    @FindBy(name = "commit")
    private WebElement signIn;

    @FindBy(css = "js-flash-container .flash-error")
    private WebElement error;


    public LoginPage(){
        super();
        PageFactory.initElements(driver, this);
        driver.get(getUrl());
    }
    public String getUrl(){
        return "https://github.com/login";
    }

    public void loginWith(String username, String password){
        type(loginField, username);
        type(passField, password);
        click(signIn);

    }

    public boolean isErrorMessageDisplayed(){

        return isDisplayed(error);
    }


}
