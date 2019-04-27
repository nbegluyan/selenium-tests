package base;

import api.Client;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;
import java.util.NoSuchElementException;


public abstract class BasePage <T extends LoadableComponent<T>> extends LoadableComponent<T>{
    protected WebDriver driver;

    public  BasePage(){

        this.driver = DriverHelper.get().getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().equals(getUrl());

    }

    public abstract String getUrl();

    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public void type(By location, String text){
        type(find(location), text);
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }

    public void type(String cssSelector, String text){
        type(By.cssSelector(cssSelector), text);
    }

    public List<WebElement> findElements(By location){
        return driver.findElements(location);
    }

    public void click(WebElement element){
        System.out.println("Clicking on element with location" + element.toString());
        element.click();
    }

    public void click(By location){
        click(find(location));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

        public boolean isDisplayed(By location){
            try{
                return find(location).isDisplayed();
            } catch (NoSuchElementException e){
                return false;
            }


    }
    public Actions getActions(){
        return new Actions(driver);

    }





}
