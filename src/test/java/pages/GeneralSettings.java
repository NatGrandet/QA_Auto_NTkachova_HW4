package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;


public class GeneralSettings {

    private WebDriver driver;

    void GeneralSettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }

    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
        handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new ChromeDriver(handlSSLErr);
        return driver;
    }

    public void setPropertyWindow(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.

    }


    public void openURL(String url) {

        driver.get(url);
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;

    }

    public void delay(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
