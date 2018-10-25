import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private By loginField = By.name("login");
    private By passField = By.name("password");
    private By signIn = By.name("commit");
    private By error = By.cssSelector("#js-flash-container .flash-error");

    public LoginPage(WebDriver driver){
        super(driver);
        driver.get(getUrl());
    }

    public void loginWith(String username, String password){
        type(loginField, username);
        type(passField, password);
        click(signIn);


    }

    public boolean isErrorMessageDisplayed(){

        return driver.findElement(error).isDisplayed();
    }

    public String getUrl() {
        return "https://github.com/login";
    }
}
