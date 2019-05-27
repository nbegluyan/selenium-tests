import base.BasePage;
import base.WaitHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVLogin extends BasePage {

    @FindBy(id = "UserName")
    private WebElement usename;

    @FindBy(id = "Password")
    private WebElement pass;

    @FindBy(id = "btn-sign-in")
    private WebElement signin;

    @FindBy(id = "dashboard-page-btn")
    private WebElement dashboard;

    @FindBy(xpath = "//div[contains(@class,\"widget-wrapper\")]//div[contains(@class, \"inner__dropdown-indicator\")]")
    private WebElement dropdown;

    @FindBy(xpath = "//div[text()=\"Live\"]")
    private WebElement livestream;

    public TVLogin(){
        super();
        PageFactory.initElements(driver,this);
        driver.get(getUrl());
    }
    public String getUrl(){
        return "https://login.teamviewer.com/LogOn/PopUp/iot?returnUrl=%2Foauth2%2Fauthorize%2Fiot%3Fresponse_type%3Dcode%26client_id%3D209938-0kMGByUKTmp4d3b5CRAA%26redirect_uri%3Dhttps%253a%252f%252fapi.teamviewer-iot.com%253a443%252fcallback%26state%3DMTU1ODU5MzM2NDEwM3xodHRwczovL3RlYW12aWV3ZXItaW90LmNvbQ%253d%253d%26display%3Dpopup";
    }


    public void loginTV(String username, String password){
        type(usename, username);
        type(pass, password);
        click(signin);
        WaitHelper.waitForElementToBeVisible(dashboard);
        click(dashboard);
        WaitHelper.waitForElementToBeVisible(dropdown);
        click(dropdown);
        click(livestream);


    }

    public String getSensorIdFromSocket(){
        String sensorId = "";
        try {
            Thread.sleep(8000);

            LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
            driver.close();
            driver.quit();

            for(LogEntry entry : logEntries){
                JSONObject messageJSON = null;
                try {
                    messageJSON = new JSONObject(entry.getMessage());
                    String method = messageJSON.optJSONObject("message").optString("method");
                    JSONObject resp = messageJSON.optJSONObject("message").optJSONObject("params");
                    if(resp.has("response")){
                        String payload = resp.optJSONObject("response").optString("payloadData");
                        if (method.equalsIgnoreCase("Network.webSocketFrameReceived")) {
                            System.out.println("Message Received: ");
                            System.out.println(payload);
                            if(payload.indexOf("sensorId") != -1){
                                payload = payload.substring(2);
                                sensorId = new JSONArray(payload).getJSONObject(1).getJSONArray("data").getJSONObject(0).getString("sensorId");
                                System.out.println("sensorID:" + sensorId);
                                return sensorId;
                            }
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return sensorId;
    }



}

