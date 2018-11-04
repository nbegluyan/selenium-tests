import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamviewerLoginTest {
    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
        driver = new ChromeDriver();
    }


    @Test

    public void TVLogin(){
        TeamviewerLogin login = new TeamviewerLogin();
        login.Login("qamco2@teamvievver.de","Qw123456");

    }


}
