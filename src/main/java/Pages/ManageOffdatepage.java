package Pages;

import Utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageOffdatepage {
    public WebDriver driver;
    public ManageOffdatepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Manage Off Dates']")
    public WebElement manageoffdateicon;
    @FindBy(xpath = "//a[text()='Mark Off dates']")
    public WebElement manageoffdatebutton;
   // @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    @FindBy(xpath = "//b[@role='presentation']")
    public WebElement clicklabdropdown;
    @FindBy(xpath = "//span[text()='AsterLabs']")
    public WebElement asterlabs;
    @FindBy(xpath = "//ul[@class='select2-results__options']")
    public WebElement selectlabdropdown;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement selectoffcities;
    @FindBy(id = "select2-labid-container")
    public WebElement labnamesfromdropdown;
    @FindBy(xpath = "//li[text()='AsterLabs']")
    public WebElement Asterlabs;
    @FindBy(id = "offdates-year")
    public WebElement Datepickerbutton;
    @FindBy(xpath = "//span[@class='year']")
    public WebElement Yearoffdates;
    @FindBy(xpath = "//ul[@class='select2-selection__rendered']")
    public WebElement selectOffcitiesfield;
    @FindBy(id = "offdates-saturday_off")
    public WebElement saturdaydropdown;
    @FindBy(id = "offdates-sunday_off")
    public WebElement sundaydropdown;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement nextbtn;
    @FindBy(xpath = "//a[text()='Cityname2493']")
    public WebElement OffDatefield;

    @FindBy(xpath = "//i[@class='fa fa-trash-o ']")
    public WebElement detetebutton;
    @FindBy(xpath = "//a[text()='Lab Name']")
    public WebElement labnamefield;


    public WebElement manageoffdateicon(){
        return manageoffdateicon;
    }
    public WebElement manageoffdatebutton(){
        return manageoffdatebutton;
    }
    public WebElement clicklabdropdown(){
        return clicklabdropdown;
    }
    public WebElement selectlabdropdown(){
        return selectlabdropdown;

    }
    public WebElement selectoffcities(){
        return selectoffcities;
    }
    public WebElement asterlabs(){
        return asterlabs;
    }
    public WebElement labnamesfromdropdown(){
        return labnamesfromdropdown;
    }
    public WebElement Asterlabs(){
        return Asterlabs;
    }
    public WebElement Datepickerbutton(){
        return Datepickerbutton;
    }
    public WebElement Yearoffdates(){
        return Yearoffdates;
    }
    public WebElement selectoffcitiesfields(){
        return selectOffcitiesfield;
    }
public WebElement saturdaydropdown(){
        return saturdaydropdown;
}
public WebElement sundaydropdown(){
        return sundaydropdown;
}
public WebElement nxtbtn(){
        return nextbtn;
}
public WebElement OffDateField(){
        return OffDatefield;
}


    public WebElement deletebutton(){
        return detetebutton;
    }
    public WebElement labnamefield(){
        return labnamefield;
    }
}
