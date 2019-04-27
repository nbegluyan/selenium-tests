import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MultipleWindowTest extends  BaseSelenium{
    @Test
    public void multipleWindowCheck() {
        MultipleWindowPage multipleWindowPage = new MultipleWindowPage();

        multipleWindowPage.clickOnClickHere();
        multipleWindowPage.changeTab(1);

        assertEquals(multipleWindowPage.getNewTabText(), "New Window",
                "New Tab was not opened!");
        assertTrue(multipleWindowPage.getCurrentUrl().contains("windows/new"),
                "New Tab url is not correct!");
    }
}
