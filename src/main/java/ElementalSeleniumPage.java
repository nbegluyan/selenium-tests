import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ElementalSeleniumPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = ".language")
    private WebElement dropdown;

    @FindBy(css = "input[type=checkbox]")
    private WebElement checkbox;

    @FindBys({
            @FindBy(css = ".language option")
    })
    public List<WebElement> dropdownOptions;

    @FindBy(css = "#submit")
    private WebElement submit;

    public ElementalSeleniumPage() {
        super();
        PageFactory.initElements(driver, this);
        driver.get(getUrl());
    }

    public String getUrl() {
        return "http://elementalselenium.com/";
    }

    public void SelectLanguage(String language) {
        this.dropdown.click();
        List<WebElement> options = this.dropdownOptions;
        for (WebElement option : options) {
            if (option.getText().equals(language)) {
                option.click();
                break;
            }
        }
    }

    public void SeleniumTrip(String username) {
        type(emailField, username);
        this.submit.click();

    }

    public boolean isSelected(WebElement checkbox) {
        return true;
    }

    public void isCheckedCource() {
        if (isSelected(checkbox) == true) {
            this.checkbox.click();
        }
    }

   /* public void pageNavigate(){
        driver.navigate().to("http://elementalselenium.com/subscribe/confirm?drip_email=www%40ttt.vo&drip_subscriber_id=niaxqtgx6ghtyqvoomar");
        driver.findElement(By.cssSelector(".subheader"));
        assertTrue(driver.getCurrentUrl().contains("http://elementalselenium.com/subscribe/confirm?drip_email=www%40ttt.vo&drip_subscriber_id=niaxqtgx6ghtyqvoomar"),"page was not opened");
    }*/


}







