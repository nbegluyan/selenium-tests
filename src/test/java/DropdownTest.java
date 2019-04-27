import org.testng.annotations.Test;

public class DropdownTest extends BaseSelenium {


    @Test
    public void dropDown() {
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.selectOptionCustom("Option 2");




    }
}
