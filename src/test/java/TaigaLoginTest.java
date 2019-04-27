import api.Client;
import base.BasePage;
import base.DriverHelper;
import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class TaigaLoginTest extends BaseSelenium {

    @Test
    public void TaigaTest() throws IOException {
        TaigaLoginPage taigaLoginPage = new TaigaLoginPage();
        login("sat.mkrtchyan@gmail.com", "bilgakov12345");

        new TaigaLoginPage();


    }

}

