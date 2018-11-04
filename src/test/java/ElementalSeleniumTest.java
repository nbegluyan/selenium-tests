import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ElementalSeleniumTest {
    @Test

    public void SeleniumSubmit(){
        ElementalSeleniumPage selenium = new ElementalSeleniumPage();
        selenium.SelectLanguage("Java");
        selenium.SeleniumTrip("satenik@gmail.com");
        selenium.isCheckedCource();
      //  assertTrue(selenium.isCheckedCource(), "Was not checked");
    }

}
