import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {
    @FindBy(id = "dropdown")
    private WebElement dropdown;

    @FindBys(
            {
            @FindBy(css = "#dropdown option")
            }
    )
    public List<WebElement> options;


    public DropdownPage() {
        super();
        PageFactory.initElements(driver, this);
        driver.get(getUrl());
    }


    public String getUrl() {
        return "http://the-internet.herokuapp.com/dropdown";
    }

    public void selectOption(int index) {
        Select select = new Select(find(By.id("dropdown")));
        select.selectByIndex(index);
    }

    public void isOptionEnabled(int index) {
        Select select = new Select(find(By.id("dropdown")));
        select.getOptions().get(index).isEnabled();
    }

    public void selectOptionCustom(String text) {
        this.dropdown.click();
        List<WebElement> options = this.options;
        for (WebElement option : options) {
            if (option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }
}
