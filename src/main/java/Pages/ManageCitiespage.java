package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCitiespage {
    public WebDriver driver;
    public ManageCitiespage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Manage Cities']")
    public WebElement managecitiesicon;
    @FindBy(xpath = "//a[text()='Create Cities']")
    public WebElement createcitiesbutton;
    @FindBy(id = "cities-name")
    public WebElement cityname;
    @FindBy(id = "cities-state")
    public WebElement statename;
    @FindBy(xpath = "//span[@class='bootstrap-switch-handle-off bootstrap-switch-default']")
    public WebElement activeinactivebutton;
    @FindBy(name ="Cities[pincodes]")
    public WebElement pincode;
    @FindBy(id = "cities-tags")
    public WebElement tagcities;
    @FindBy(xpath ="//button[@class='btn btn-success']")
    public WebElement createsuccessbutton;
    @FindBy(xpath = "//th[text()='Name']")
    public WebElement namefield;
    @FindBy(name = "CitiesSearch[name]")
    public WebElement nametextboxsearch;
    @FindBy(name = "CitiesSearch[state]")
    public WebElement statesearchbox;
    @FindBy(name = "CitiesSearch[status]")
    public WebElement statussearchbox;
    @FindBy(xpath = "//i[@class='fa fa-power-off']")
    public WebElement enablecity;
    @FindBy(xpath = "//i[@class='fa fa-pencil-square-o ']")
    public WebElement editcity;
    @FindBy(name = "Cities[name]")
    public WebElement editcityname;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement updatebutton;
    @FindBy(xpath = "//th[text()='Name']")
    public WebElement updatednamefield;
    @FindBy(xpath = "//a[text()='State']")
    public WebElement statefield;

    public WebElement managecitiesicon(){
        return managecitiesicon;
    }
    public WebElement createcitiesbutton(){
        return createcitiesbutton;
    }
    public WebElement cityname(){
        return cityname;
    }
    public WebElement statename(){
        return statename;
    }
    public WebElement activeinactivebutton(){
        return activeinactivebutton;
    }
    public WebElement pincode(){
        return pincode;
    }
    public WebElement tagcities(){
        return tagcities;
    }
    public WebElement createsuccessbutton(){
        return createsuccessbutton;
    }
    public WebElement namefield(){
        return namefield;
    }
    public WebElement nametextboxsearchbox(){
        return nametextboxsearch;
    }
    public WebElement statesearchbox(){
        return statesearchbox;
    }
    public WebElement statussearchbox(){
        return statussearchbox;

    }
    public WebElement enablecity(){
        return enablecity;
    }
    public WebElement editcity(){
        return editcity;
    }
    public WebElement editcityname(){
        return editcityname;
    }
    public WebElement updatebutton(){
        return updatebutton;
    }
    public WebElement updatednamefield(){
        return updatednamefield;
    }
    public WebElement statefield(){
        return statefield;
    }
}

