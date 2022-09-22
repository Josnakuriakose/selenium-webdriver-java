package Testcases;

import AutomationCore.Baseclass;
import Pages.*;
import Utilities.ExcelUtility;
import Utilities.PageUtility;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class MedlifeTestcases extends Baseclass {
    public WebDriver driver;
    public static Properties prop;
    FileInputStream fs;
    MedlifeLoginpage medlifeLoginpage;
    MedlifeHomepage medlifeHomepage;
    ManageCitiespage manageCitiespage;
    ManageLabspage manageLabspage;
    ManageOffdatepage manageOffdatepage;
    ManageTagPage manageTagPage;
    Servicepage servicepage;
    Managecategoriespage managecategoriespage;
    Managecustomerpage managecustomerpage;
    @BeforeMethod
    @Parameters({"browser"})

    public void initialization(String browser) throws Exception {
        driver = browserinitialization(browser);
        prop = new Properties();
        fs = new FileInputStream("D:\\Work\\Medlifeautomation\\src\\main\\resources\\Testdata\\testdata.properties");
        prop.load(fs);
        medlifeLoginpage=new MedlifeLoginpage(driver);
        medlifeHomepage=new MedlifeHomepage(driver);
        manageCitiespage=new ManageCitiespage(driver);
        manageLabspage=new ManageLabspage(driver);
        manageOffdatepage=new ManageOffdatepage(driver);
        manageTagPage=new ManageTagPage(driver);
        servicepage=new Servicepage(driver);
        managecategoriespage=new Managecategoriespage(driver);
        managecustomerpage=new Managecustomerpage(driver);
        String uname="labs";
        String pword="admin@990099";
        String url="http://"+uname+":"+pword+"@"+"ldmllabs.ndz.co.in/admin/site/login";
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void login()  {
        PageUtility.enterText(medlifeLoginpage.loginusername(),prop.getProperty("username"));
        PageUtility.enterText(medlifeLoginpage.loginpassword(),prop.getProperty("password"));
        PageUtility.clickOnElement(medlifeLoginpage.loginbutton());
    }
@Test
    public void TC01(){
    PageUtility.enterText(medlifeLoginpage.loginusername(),prop.getProperty("username"));
    PageUtility.enterText(medlifeLoginpage.loginpassword(),prop.getProperty("password"));
    String text=PageUtility.getElementText(medlifeLoginpage.loginusername());
    System.out.println(text);
    System.out.println("propertyfile"+prop.getProperty("username"));
    Assert.assertEquals(prop.getProperty("username"),"siteadmin");
    }
    @Test//verify user can login with valid username and valid password
    public void TC02() throws InterruptedException {
      PageUtility.enterText(medlifeLoginpage.loginusername(),prop.getProperty("username"));
      PageUtility.enterText(medlifeLoginpage.loginpassword(),prop.getProperty("password"));
      PageUtility.clickOnElement(medlifeLoginpage.loginbutton());
        sleep(4000);
        Assert.assertEquals(medlifeHomepage.homepagelogo().isDisplayed(),true);

    }
  @Test//verify user can login with invalid username and valid password
    public void TC03(){
        PageUtility.enterText(medlifeLoginpage.loginusername(),prop.getProperty("invalidusername"));
        PageUtility.enterText(medlifeLoginpage.loginpassword(),prop.getProperty("password"));
        PageUtility.clickOnElement(medlifeLoginpage.loginbutton());
        Assert.assertEquals(medlifeLoginpage.errormsg().isDisplayed(),true);
        System.out.println("passed");
        System.out.println("invalid username");
    }
    @Test//verify user can login with valid username and invalid password
    public void TC04(){
        PageUtility.enterText(medlifeLoginpage.loginusername(),prop.getProperty("username"));
        PageUtility.enterText(medlifeLoginpage.loginpassword(),prop.getProperty("invalidpassword"));
        PageUtility.clickOnElement(medlifeLoginpage.loginbutton());
        Assert.assertEquals(medlifeLoginpage.errormsg().isDisplayed(),true);
        System.out.println("passed");
        System.out.println("invalid password");
    }

    @Test//verify user can login with invalid username and invalid password
    public void TC05(){
        PageUtility.enterText(medlifeLoginpage.loginusername(),prop.getProperty("invalidusername"));
        PageUtility.enterText(medlifeLoginpage.loginpassword(),prop.getProperty("invalidpassword"));
        PageUtility.clickOnElement(medlifeLoginpage.loginbutton());
        Assert.assertEquals(medlifeLoginpage.errormsg().isDisplayed(),true);
        System.out.println("passed");
        System.out.println("invalid username and invalid password");
    }
    @Test//verify logo button is displayed in the loginpage
    public void TC06(){
        if (PageUtility.isElementDisplayed(medlifeLoginpage.medlifelogo())){
            System.out.println("logo is displayed");
        }
        else{
            System.out.println("logo is not displayed");
        }
        Assert.assertEquals(medlifeLoginpage.medlifelogo().isDisplayed(),true);
    }
    @Test//verify notification
    public void TC07() throws InterruptedException {
        login();
        sleep(5000);
        PageUtility.moveToWebElement(medlifeHomepage.notification(), driver);
        sleep(4000);
        PageUtility.clickOnElement(medlifeHomepage.notification());
        Assert.assertEquals(medlifeHomepage.homepagelogo().isDisplayed(), true);
    }
    @Test//verify user can signout
    public void TC08() throws InterruptedException {
        login();
        sleep(2000);
        PageUtility.clickOnElement(medlifeHomepage.siteadminbutton());
        sleep(5000);
       PageUtility.clickOnElement(medlifeHomepage.signoutbutton());
       sleep(5000);
        Assert.assertEquals(medlifeLoginpage.medlifelogo().isDisplayed(),true);
    }
    @Test
    public void TC09() throws InterruptedException {
        login();
        sleep(5000);
        PageUtility.moveToWebElement(manageCitiespage.managecitiesicon(),driver);
        PageUtility.clickOnElement(manageCitiespage.managecitiesicon());
        Assert.assertEquals(PageUtility.getElementText(manageCitiespage.statefield()),"State");

    }
    @Test//verify user can create cities
    public void TC10() throws InterruptedException {
        login();
        sleep(5000);
        PageUtility.moveToWebElement(manageCitiespage.managecitiesicon(),driver);
        PageUtility.clickOnElement(manageCitiespage.managecitiesicon());
        sleep(6000);
        PageUtility.clickOnElement(manageCitiespage.createcitiesbutton());
        sleep(6000);
        PageUtility.enterText(manageCitiespage.cityname(),prop.getProperty("cityname"));
        PageUtility.enterText(manageCitiespage.statename(),prop.getProperty("citystate"));
        PageUtility.clickOnElement(manageCitiespage.activeinactivebutton());
        PageUtility.enterText(manageCitiespage.tagcities(),prop.getProperty("tags"));
       PageUtility.enterText(manageCitiespage.pincode(),prop.getProperty("pincodes"));
       PageUtility.clickOnElement(manageCitiespage.createsuccessbutton());
        Assert.assertEquals(PageUtility.getElementText(manageCitiespage.namefield()),"Name");
    }
    @Test//search by name in managecity
    public void TC11() throws IOException {
        login();
        PageUtility.moveToWebElement(manageCitiespage.managecitiesicon(),driver);
        String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
        PageUtility.enterText(manageCitiespage.nametextboxsearchbox(), ExcelUtility.getString(1,0,excelpath,"createcityfields"));
        PageUtility.EnterkeyPress(driver,manageCitiespage.nametextboxsearchbox());
        Assert.assertEquals(PageUtility.getElementText(manageCitiespage.statefield()),"State");
    }
    @Test//search by state
    public void TC12() throws IOException {
        login();
        PageUtility.moveToWebElement(manageCitiespage.managecitiesicon(),driver);
        String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
        PageUtility.enterText(manageCitiespage.statesearchbox(),ExcelUtility.getString(1,1,excelpath,"createcityfields"));
        PageUtility.EnterkeyPress(driver,manageCitiespage.statesearchbox());
        Assert.assertEquals(PageUtility.getElementText(manageCitiespage.statefield()),"State");
    }
    @Test//search by status
public void TC13(){
        login();
        PageUtility.moveToWebElement(manageCitiespage.managecitiesicon(),driver);
        PageUtility.selectDropdownbyText(manageCitiespage.statussearchbox(),"Active");
        Assert.assertEquals(PageUtility.getElementText(manageCitiespage.statefield()),"State");

    }

    @Test//enable city
    public void TC14() throws IOException {
        login();
        PageUtility.moveToWebElement(manageCitiespage.managecitiesicon(),driver);
        String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
        PageUtility.enterText(manageCitiespage.nametextboxsearchbox(), ExcelUtility.getString(1,0,excelpath,"createcityfields"));
        PageUtility.EnterkeyPress(driver,manageCitiespage.nametextboxsearchbox());
        PageUtility.clickOnElement(manageCitiespage.enablecity());
        PageUtility.acceptAlert(driver);
        Assert.assertEquals(PageUtility.getElementText(manageCitiespage.statefield()),"State");

    }
    @Test//edit city
    public void TC15() throws IOException {
        login();
        PageUtility.moveToWebElement(manageCitiespage.managecitiesicon(),driver);
        String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
        PageUtility.enterText(manageCitiespage.nametextboxsearchbox(), ExcelUtility.getString(2,0,excelpath,"createcityfields"));
        PageUtility.EnterkeyPress(driver,manageCitiespage.nametextboxsearchbox());
        PageUtility.clickOnElement(manageCitiespage.editcity());
        PageUtility.clearText(manageCitiespage.editcityname());
        PageUtility.enterText(manageCitiespage.editcityname(), ExcelUtility.getString(1,0,excelpath,"createcityfields"));
        PageUtility.clickOnElement(manageCitiespage.updatebutton());
        Assert.assertEquals(PageUtility.getElementText(manageCitiespage.updatednamefield()),"Name");
    }
@Test//navigate managelab page
    public void TC16(){
        login();
        PageUtility.moveToWebElement(manageLabspage.managelabicon(),driver);
        PageUtility.clickOnElement(manageLabspage.managelabicon());
        Assert.assertEquals(PageUtility.getElementText(manageLabspage.labnamefiled()),"Lab Name");
}
@Test//managelab page search by name
    public void TC17() throws IOException {
        login();
    PageUtility.moveToWebElement(manageLabspage.managelabicon(),driver);
   String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
    PageUtility.enterText(manageLabspage.labnameserachbox(), ExcelUtility.getString(1,0,excelpath,"managelabfield"));
    PageUtility.EnterkeyPress(driver,manageLabspage.labnameserachbox());
    Assert.assertEquals(PageUtility.getElementText(manageLabspage.labnamefiled()),"Lab Name");
}
@Test//manageoffdate
    public void TC18() throws InterruptedException {
        login();
        PageUtility.moveToWebElement(manageOffdatepage.manageoffdateicon(), driver);
        PageUtility.clickOnElement(manageOffdatepage.manageoffdateicon());
        PageUtility.clickOnElement(manageOffdatepage.manageoffdatebutton());
        PageUtility.clickOnElement(manageOffdatepage.labnamesfromdropdown());
        PageUtility.clickOnElement(manageOffdatepage.Asterlabs());
        PageUtility.clickOnElement(manageOffdatepage.Datepickerbutton());
        PageUtility.clickOnElement(manageOffdatepage.Yearoffdates());
        Thread.sleep(5000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Alappuzha'",manageOffdatepage.selectoffcitiesfields());
        PageUtility.EnterkeyPress(driver,manageOffdatepage.selectoffcitiesfields());
        PageUtility.selectDropdownbyIndex(manageOffdatepage.saturdaydropdown(),1);
        PageUtility.selectDropdownbyIndex(manageOffdatepage.sundaydropdown(),1);
        PageUtility.clickOnElement(manageOffdatepage.nxtbtn());
    Assert.assertEquals(PageUtility.getElementText(manageOffdatepage.OffDateField()),"Cityname2493");

}
@Test//create tag in managetag
    public void TC19() throws IOException {
        login();
        PageUtility.moveToWebElement(manageTagPage.managetagicon(),driver);
        PageUtility.clickOnElement(manageTagPage.managetagicon());
        PageUtility.clickOnElement(manageTagPage.createtagButton());
        PageUtility.clickOnElement(manageTagPage.tagnametextbox());
    String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
    PageUtility.enterText(manageTagPage.tagnametextbox(), ExcelUtility.getString(1,0,excelpath,"createtagfields"));
    PageUtility.enterText(manageTagPage.tagdesscriptionbox(), ExcelUtility.getString(1,1,excelpath,"createtagfields"));
     PageUtility.clickOnElement(manageTagPage.tagcreatebutton());
    Assert.assertEquals(PageUtility.getElementText(manageTagPage.namefield()),"Name");
    }
    @Test//import service in service icon
    public void TC20(){
        login();
        PageUtility.moveToWebElement(servicepage.serviceicon(),driver);
        PageUtility.clickOnElement(servicepage.serviceicon());
        PageUtility.clickOnElement(servicepage.importserviceicon());
        Assert.assertEquals(PageUtility.getElementText(servicepage.filefield()),"File");
    }
    @Test//delete offdate in manageoffdate
    public void TC21(){
        login();
        PageUtility.moveToWebElement(manageOffdatepage.manageoffdateicon(), driver);
        PageUtility.clickOnElement(manageOffdatepage.deletebutton());
        PageUtility.acceptAlert(driver);
        Assert.assertEquals(PageUtility.getElementText(manageOffdatepage.labnamefield()),"Lab Name");
    }
    @Test//search name
    public void TC22() throws IOException {
        login();
        PageUtility.moveToWebElement(managecategoriespage.managecategoriesicon(),driver);
        String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
        PageUtility.enterText(managecategoriespage.categorynamesearch(), ExcelUtility.getString(2,0,excelpath,"categoriesfield"));
        PageUtility.EnterkeyPress(driver,managecategoriespage.categorynamesearch());
       Assert.assertEquals(PageUtility.getElementText(managecategoriespage.namefield()),"Name");
        }

    @Test//delete category
    public void TC23() throws IOException {
        login();
        PageUtility.moveToWebElement(managecategoriespage.managecategoriesicon(),driver);
        String excelpath="\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
        PageUtility.enterText(managecategoriespage.categorynamesearch(), ExcelUtility.getString(2,0,excelpath,"categoriesfield"));
        PageUtility.EnterkeyPress(driver,managecategoriespage.categorynamesearch());
        PageUtility.clickOnElement(managecategoriespage.deletecategory());
        PageUtility.acceptAlert(driver);
        Assert.assertEquals(PageUtility.getElementText(managecategoriespage.namefield()),"Name");
    }
    @Test//activate or deactivate managecustomer
    public void TC24() throws IOException {
        login();
        PageUtility.moveToWebElement(managecustomerpage.managecustomericon(), driver);
        String excelpath = "\\src\\main\\resources\\Testdata\\testdataExcel.xlsx";
        PageUtility.enterText(managecustomerpage.customersearch(), ExcelUtility.getString(1, 0, excelpath, "managecustomersheet"));
        PageUtility.EnterkeyPress(driver, managecustomerpage.customersearch());
        PageUtility.clickOnElement(managecustomerpage.customeractivebutton());
        PageUtility.acceptAlert(driver);
        Assert.assertEquals(PageUtility.getElementText(managecustomerpage.usernamefield()), "Username");
    }
    @Test//copy service in service icon
    public void TC25() {
        login();
        PageUtility.moveToWebElement(servicepage.serviceicon(), driver);
        PageUtility.clickOnElement(servicepage.serviceicon());
        PageUtility.clickOnElement(servicepage.copyservice());
        Assert.assertEquals(PageUtility.getElementText(servicepage.labfield()),"Lab");
    }

     @AfterMethod
    public void teardown() {
        driver.quit();
    }
}