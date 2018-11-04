import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.DriverHelper.getDriver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class LoginTest  {


    @Test
    public void successLogin() {

        getDriver().get("https://google.com");

        assertTrue(getDriver().getCurrentUrl().contains("https://www.google.com"),
                "The page was not load correctly");

    }

    @Test
    public void githubFailedLogin() {

          LoginPage loginPage = new LoginPage();
         // assertFalse(loginPage.isErrorMessageDisplayed(), "Error message should not displayed");
          loginPage.loginWith("satenik@gmail.com", "pakkss");
          assertTrue(loginPage.isErrorMessageDisplayed(), "Error was not appear");

    }




}


