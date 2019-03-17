package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;


public class LoginPage {
    private WebDriver driver;
    private static WebDriverWait wait;


    public void LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(id = "login-form-username")
    WebElement loginField;

    @FindBy(id = "login-form-password")
    WebElement passwordField;


    @FindBy(id = "login")
    WebElement logInButton;


    public void enterLogin(){

        loginField.sendKeys(ConfigProperties.getTestProperty("login.username"));
    }

    public void enterPassword(){
        passwordField.sendKeys(ConfigProperties.getTestProperty("login.password"));
    }

    public void clickLogin(){
        logInButton.click();
    }

}
