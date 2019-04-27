import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SelectPageTest extends BaseSelenium {
    @Test

    public void selectTest(){

        SelectPage selectPage = new SelectPage();

        assertFalse(selectPage.isCheckboxChecked(0), "first was  checked");
        assertTrue(selectPage.isCheckboxChecked(1), "First was not checked");
        selectPage.clickCheckbox(0);

        assertTrue(selectPage.isCheckboxChecked(0), "First checkbox was not checked!");
        assertTrue(selectPage.isCheckboxChecked(1), "First checkbox was not checked!");

        selectPage.clickCheckbox(1);
        assertTrue(selectPage.isCheckboxChecked(0), "First checkbox was not checked!");
        assertFalse(selectPage.isCheckboxChecked(1), "First checkbox was checked!");

    }
}
