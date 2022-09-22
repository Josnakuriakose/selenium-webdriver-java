package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedlifeLoginpage {
    public WebDriver driver;
    public MedlifeLoginpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="loginform-username")
    public WebElement loginusername;
    @FindBy(id ="loginform-password")
    public WebElement loginpassword;
    @FindBy(name = "login-button")
    public WebElement loginbutton;
    @FindBy(xpath = "//div[@class='login-logo']")
    public  WebElement medlifelogo;
    @FindBy(xpath = "//p[text()='Incorrect username or password.']")
    public WebElement errormsg;

    public WebElement loginusername(){
        return loginusername;
    }
    public WebElement loginpassword(){
        return loginpassword;
    }
    public WebElement loginbutton(){
        return loginbutton;
    }
    public WebElement medlifelogo(){
        return medlifelogo;
    }
    public WebElement errormsg(){
        return errormsg;
    }
}
