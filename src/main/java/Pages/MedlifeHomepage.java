package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedlifeHomepage {
    public WebDriver driver;
    public MedlifeHomepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='siteadmin']")
    public WebElement siteadminbutton;
   // @FindBy(xpath = "//a[text()='Sign out']")
    @FindBy(xpath = "//a[@class='btn btn-default btn-flat']")
    public WebElement signoutbutton;
    @FindBy(xpath = "//i[@class='fa fa-bell']")
    public WebElement notification;
    @FindBy(xpath = "//li[text()='No notifications to show']")
    public WebElement notificationmsg;
    @FindBy(xpath = "//span[@class='logo-lg']")
    public WebElement homepagelogo;

    public WebElement siteadminbutton(){
        return siteadminbutton;
    }
    public WebElement signoutbutton(){
        return signoutbutton;
    }
    public WebElement notification(){
        return notification;
    }
    public WebElement notificationmsg(){
        return notificationmsg;
    }
    public WebElement homepagelogo(){
        return homepagelogo;
    }
}
