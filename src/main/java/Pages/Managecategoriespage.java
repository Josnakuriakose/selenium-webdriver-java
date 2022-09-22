package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managecategoriespage {
    public WebDriver driver;
    public Managecategoriespage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);}
    @FindBy(xpath = "//span[text()='Manage Categories']")
    public WebElement managecategoriesicon;
    @FindBy(name = "CategoriesSearch[name]")
    public WebElement categorynamesearch;
    @FindBy(xpath = "//a[text()='Name']")
    public WebElement namefield;
    @FindBy(xpath = "//span[@class='glyphicon glyphicon-trash']")
    public WebElement deletecategory;

public WebElement managecategoriesicon(){
    return managecategoriesicon;
}
    public WebElement categorynamesearch(){
        return categorynamesearch;
    }
    public WebElement namefield(){
    return namefield;
    }
    public WebElement deletecategory(){
    return deletecategory;
    }
}
