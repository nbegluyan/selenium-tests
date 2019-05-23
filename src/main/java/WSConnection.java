import base.DriverHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;


public class WSConnection {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = DriverHelper.get().getDriver();
        driver.navigate().to("https://teamviewer-iot.com/en/dashboards");
        Thread.sleep(5000);
        try {
            LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);

            driver.close();
            driver.quit();
            logEntries.forEach(entry -> {
                JSONObject messageJSON = null;
               try {
                    System.out.println(entry.getMessage());
                    messageJSON = new JSONObject(entry.getMessage());
                    String method = messageJSON.getJSONObject("message").getString("method");
                    if (method.equalsIgnoreCase("Network.webSocketFrameSent")) {
                        System.out.println("Message Sent: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
                    } else if (method.equalsIgnoreCase("Network.webSocketFrameReceived")) {
                        System.out.println("Message Received: " + messageJSON.getJSONObject("message").getJSONObject("params").getJSONObject("response").getString("payloadData"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            });
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}