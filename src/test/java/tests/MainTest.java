package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigProperties;
import java.util.concurrent.TimeUnit;

public class MainTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private GeneralSettings settings;
    private LoginPage loginPage;


    @BeforeTest
    public void SetUp() {
        WebDriverManager.chromedriver().setup();

        DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
        handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        driver = new ChromeDriver(handlSSLErr);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 20);
        loginPage = new LoginPage();
        settings = new GeneralSettings();
    }

    @Test
    public void logingJira() {
        settings.openURL(ConfigProperties.getTestProperty("jira.url"));
        loginPage.loginToJira(ConfigProperties.getTestProperty("login.username"), ConfigProperties.getTestProperty("login.password"));
    }

}
