package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GeneralSettings;
import pages.LoginPage;
import utils.ConfigProperties;

public class MainTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private GeneralSettings settings;
    private LoginPage loginPage;
    private Wait fluentWait;

    @BeforeTest
    public void SetUp() {
        settings = new GeneralSettings();
        loginPage = new LoginPage();

        settings.initializeDriver();
        settings.setPropertyWindow();
    }

    @Test
    public void logingJira() {
        settings.openURL(ConfigProperties.getTestProperty("jira.url"));
        Assert.assertEquals(settings.getTitle(), ConfigProperties.getTestProperty("login.page.title"));
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }

}
