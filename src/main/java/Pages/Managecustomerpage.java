package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managecustomerpage {
    public WebDriver driver;
    public Managecustomerpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Manage Customers']")
    public WebElement managecustomericon;
    @FindBy(name = "UserSearch[username]")
    public WebElement customersearch;
    @FindBy(xpath = "//i[@class='fa fa-power-off']")
    public WebElement customeractivebutton;
    @FindBy(xpath = "//a[text()='Username']")
    public WebElement usernamefield;

    public WebElement managecustomericon(){
        return managecustomericon;
    }
    public WebElement customersearch(){
        return customersearch;
    }
    public WebElement customeractivebutton(){
        return customeractivebutton;
    }
    public WebElement usernamefield(){
        return usernamefield;
    }
}
