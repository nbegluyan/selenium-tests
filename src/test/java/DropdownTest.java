import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {


    @Test
    public void successLogin() {
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.selectOptionCustom("Option 2");




    }
}
