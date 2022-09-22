package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageLabspage {
    public WebDriver driver;
    public ManageLabspage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Manage Labs']")
    public WebElement managelabicon;
    @FindBy(xpath = "//a[text()='Lab Name']")
    public WebElement labnamefield;
    @FindBy(name = "LabSearch[name]")
    public WebElement labnamesearchbox;

    public WebElement managelabicon(){
        return managelabicon;
    }
    public WebElement labnamefiled(){
        return labnamefield;
    }
    public WebElement labnameserachbox(){
        return labnamesearchbox;
    }
}
