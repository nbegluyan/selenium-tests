import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseSelenium implements IHookable {
    private static final Logger LOGGER = Logger.getLogger("BaseSelenium");
    private static WebDriver driver = DriverHelper.get().getDriver();
    @AfterMethod
    public void tearDown(){
       // System.out.println("Closing browser for method " + method.getName());
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }

    public void login(String username, String password) throws IOException {
        JsonObject jsonObject = Client.getAccessToken(username, password);
        new TaigaLoginPage();

        JavascriptExecutor js = (JavascriptExecutor) DriverHelper.get().getDriver();

        js.executeScript("window.localStorage.setItem('token', '" + jsonObject.get("auth_token") + "');");
        js.executeScript("window.localStorage.setItem('userInfo', '" + jsonObject + "');");
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if(testResult.getThrowable() != null){
            try {
                takeScreenshot(testResult.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Attachment(value = "Failure in method {0}", type = "image/png")

    private static byte[] takeScreenshot(String methodName) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target/screenshots/" + methodName + ".png"));
        System.out.println("*****Taking  screenshot on failure ******");
        LOGGER.info("*****Taking  screenshot on failure ******");
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
