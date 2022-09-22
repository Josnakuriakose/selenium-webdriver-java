package Pages;

import Utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageTagPage {
    public WebDriver driver;
    public ManageTagPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Manage Tags']")
    public WebElement managetagicon;
    @FindBy(xpath = "//a[text()='Create Tags']")
    public WebElement createtagButton;
    @FindBy(name = "Tags[name]")
    public WebElement tagnametextbox;
    @FindBy(name = "Tags[description]")
    public WebElement tagdescriptionbox;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement tagcreatebutton;
    @FindBy(xpath = "//th[text()='Name']")
    public WebElement namefield;

    public WebElement managetagicon(){
        return managetagicon;
    }
    public WebElement createtagButton(){
        return createtagButton;
    }
    public WebElement tagnametextbox(){
        return tagnametextbox;
    }
    public WebElement tagdesscriptionbox(){
        return tagdescriptionbox;
    }
public WebElement tagcreatebutton(){
        return tagcreatebutton;
}
public WebElement namefield(){
        return namefield;
}

}
