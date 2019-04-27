package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverHelper {
    public static DriverHelper get(){
        DriverHelper driverHelper = new DriverHelper();
        return driverHelper;
    }
    public WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
    private static final String REMOTE = System.getProperty("selenium.remote", "false");

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public  WebDriver getDriver() {
        if (driverThread.get() == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
                    if (Boolean.valueOf((REMOTE))) {
                    driver = initRemoteDriver(DesiredCapabilities.chrome());
                    } else{
                        driver = new ChromeDriver();
                    }
                    driverThread.set(driver);
                    break;

                case "firefox": {
                    System.setProperty("webdriver.gecko.driver",
                            "./src/main/resources/drivers/geckodriver.exe");
                    if (Boolean.valueOf((REMOTE))) {
                        driver = initRemoteDriver(DesiredCapabilities.firefox());
                    } else{
                        driver = new FirefoxDriver();
                    }
                    driverThread.set(driver);
                    break;
                }
            }

        }
        return driverThread.get();

    }


    public RemoteWebDriver initRemoteDriver(DesiredCapabilities capabilities){
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL("https://SatenikMK:e227a5fd-2fa5-465b-9786-80ba541914c2@ondemand.saucelabs.com:443/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteWebDriver;
    }

    public  void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();

    }
}