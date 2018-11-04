import org.testng.annotations.AfterMethod;

import static base.DriverHelper.driver;
import static base.DriverHelper.getDriver;
import static base.DriverHelper.quitDriver;

public class BaseSelenium {

    @AfterMethod

    public void tearDown(){
        quitDriver();
    }
}
