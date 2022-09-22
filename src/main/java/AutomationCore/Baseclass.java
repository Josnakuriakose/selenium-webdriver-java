package AutomationCore;

import com.google.common.io.Files;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Baseclass {
    public WebDriver driver;

    public WebDriver browserinitialization(String browsername) throws Exception {
        if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Work\\jo\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Work\\jo\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browsername.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "D:\\Work\\jo\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new Exception("invalid name exception");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
   public String getScreenshotPath(String testcasename,WebDriver driver)throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destinationfile=System.getProperty("user.dir")+"\\test-output\\"+testcasename+".png";
        Files.copy(source,new File(destinationfile));

        return destinationfile;
    }
}