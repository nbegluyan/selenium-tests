import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHomework {

    public WebDriver driver;
    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By loginButton = By.cssSelector("button[class='radius']");
    public By errorMessage = By.id("flash");


    public LoginHomework(WebDriver driver){
        this.driver = driver;
        driver.get("http://the-internet.herokuapp.com/login");
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




