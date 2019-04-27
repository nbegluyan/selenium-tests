import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ElementalSeleniumTest  extends  BaseSelenium{
    @Test

    public void SeleniumSubmit(){
        ElementalSeleniumPage selenium = new ElementalSeleniumPage();
        selenium.SelectLanguage("Java");
        selenium.SeleniumTrip("satenik@gmail.com");
        //assertTrue(selenium.isSelected(true), "Was not checked");
        selenium.isCheckedCource();
      //  selenium.pageNavigate();

    }

}
