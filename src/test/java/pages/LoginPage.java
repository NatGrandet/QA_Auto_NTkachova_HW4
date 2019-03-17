package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void loginToJira(String login, String password) {
        WebElement enterUsername = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.elementToBeClickable(loginField));
        enterUsername.sendKeys(login);
        passwordField.sendKeys(password);
        logInButton.click();
    }


}
