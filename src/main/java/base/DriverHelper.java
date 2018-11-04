package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {
    public static WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
                    driver = new ChromeDriver();
                    break;

                case "firefox": {
                    System.setProperty("webdriver.gecko.driver",
                            "./src/main/resources/drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                }
            }


        }
        return driver;


    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}