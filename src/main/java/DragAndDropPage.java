import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {
    @FindBy(css = "#draggable")
    private WebElement source;

    @FindBy(css = "#droppable")
    private WebElement target;



    public DragAndDropPage(){
        super();
        PageFactory.initElements(driver, this);
        driver.get(getUrl());
    }

    @Override
    public String getUrl(){
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }


    public void dragAndDrop(){
        getActions().dragAndDrop(source, target).build().perform();
    }

    public String getColum1Text(){
        return source.getText();
    }

    public String getColum2Text(){
        return source.getText();
    }


}
