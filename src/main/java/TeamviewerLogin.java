import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class TeamviewerLogin extends BasePage{

    public WebDriver driver;
    private By email = By.id("UserName");
    private By pass = By.id("Password");
    private By signing = By.id("btn-sign-in");


    public TeamviewerLogin(){
        super();
        driver.get(getUrl());
    }

    public String getUrl(){
        return "https://login.teamviewer.com/LogOn/PopUp/iot?returnUrl=%2Foauth2%2Fauthorize%2Fiot%3Fresponse_type%3Dcode%26client_id%3D209938-0kMGByUKTmp4d3b5CRAA%26redirect_uri%3Dhttps%253a%252f%252fapi.teamviewer-iot.com%253a443%252fcallback%26state%3DMTU1ODU5MzM2NDEwM3xodHRwczovL3RlYW12aWV3ZXItaW90LmNvbQ%253d%253d%26display%3Dpopup";

    }

    public void Login(String usernam, String password){
        type(email,usernam );
        type(pass, password );
        click(signing);
    }





}
