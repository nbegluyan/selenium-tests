import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SelectPage extends BasePage {
    @FindBys(
            {
                    @FindBy(css = "#checkboxes input")
            }
    )
    public List<WebElement> checkboxes;

    public SelectPage() {
        super();
        driver.get(getUrl());
    }

    public String getUrl() {
        return "http://the-internet.herokuapp.com/checkboxes";
    }

    public boolean isCheckboxChecked(int index) {
        if (checkboxes.get(index).getAttribute("checked") != null) {
            return Boolean.valueOf(checkboxes.get(index).getAttribute("checked"));
        } else {
            return false;
        }
    }

    public boolean isCheckboxCheckedWithSelected(int index) {
        return checkboxes.get(index).isSelected();
    }

    public void clickCheckbox(int index) {
        checkboxes.get(index).click();
    }

    public boolean isCheckboxChecked(String text) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals(text)) {
                String attribute = checkbox.getAttribute("checked");
                if (attribute != null) {
                    return Boolean.valueOf(attribute);
                } else {
                    return false;

                }
            }
        }
        return false;

    }

    public void clickCheckbox(String text){
        for(WebElement checkbox : checkboxes){
            if(checkbox.getText().equals(text)){
                click(checkbox);
                break;
            }
        }
    }
}






