import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver" , "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void successLogin() {

        driver.get("https://google.com");

        assertTrue(driver.getCurrentUrl().contains("https://www.google.com"),
                "The page was not load correctly");

    }

    @Test
    public void githubFailedLogin() {

          LoginPage loginPage = new LoginPage(driver);
          loginPage.loginWith("mail@mail.com", "pass");
          assertTrue(loginPage.isErrorMessageDisplayed(), "Error was not appear");

    }

    @Test
    public  void failedLoginHomework(){

        LoginHomework loginHomework = new LoginHomework(driver);
        loginHomework.loginAction("satenik", "password");
        assertTrue(loginHomework.isErrorDisplayed(), "Error was not appear");

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
}

}
