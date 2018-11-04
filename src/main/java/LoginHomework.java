import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHomework extends BasePage {

    public WebDriver driver;
    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By loginButton = By.cssSelector("button[class='radius']");
    public By errorMessage = By.id("flash");


    public LoginHomework(){
        super();
        driver.get(getUrl());
    }

    public String getUrl(){
        return "https://teamviewer-iot.com";
    }



    public void loginAction(String username, String password){

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed(){

        return driver.findElement(errorMessage).isDisplayed();
    }



}




