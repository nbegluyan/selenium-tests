import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TVLoginTest extends BaseSelenium {
    @Test

    public void  logintv (){
       TVLogin login = new TVLogin();
       login.loginTV("satenikm@teamvievver.de", "Qw123456");
       String sensorId = login.getSensorIdFromSocket();
       System.out.println("id: " + sensorId);
       assertEquals(sensorId, "89597", "chashxateeeec");

    }
}
