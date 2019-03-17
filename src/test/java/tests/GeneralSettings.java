package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GeneralSettings {

    private WebDriver driver;
    private WebDriverWait wait;


    void GeneralSettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    void setDriver() {

    }


    public void openURL(String url) {
        driver.get(url);
    }


}
