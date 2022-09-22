package Pages;

import com.sun.xml.internal.ws.wsdl.writer.W3CAddressingMetadataWSDLGeneratorExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Servicepage {
    public WebDriver driver;
    public Servicepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Services']")
    public WebElement serviceicon;
    @FindBy(xpath = "//span[text()='Import Services']")
    public WebElement importserviceicon;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitbutton;
    @FindBy(xpath = "//label[text()='File']")
    public WebElement filefield;
    @FindBy(xpath = "//span[text()='Copy Services']")
    public WebElement copyservice;
    @FindBy(xpath = "//label[text()='Lab']")
    public WebElement labfield;

    public WebElement serviceicon(){
        return serviceicon;
    }
    public WebElement importserviceicon(){
        return importserviceicon;
    }
    public WebElement submitbutton(){
        return submitbutton;
    }
    public WebElement filefield(){
        return filefield;
    }
    public WebElement copyservice(){
        return copyservice;
    }
    public WebElement labfield(){
        return labfield;
    }
}

