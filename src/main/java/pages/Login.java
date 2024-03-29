package pages;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Login {
    WebDriver driver;
    public Login() throws IOException {
        driver =  DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver,this);
    }
    // Define Page elements
    @FindBy(css = "#content > div > div > div > div > div.card-header")
    WebElement loginHeader;
    @FindBy(css = "#form-login label[for='input-username']")
    WebElement usernameLabel;
    @FindBy(id = "input-username")
    WebElement username;
    @FindBy(css = "#form-login label[for='input-password']")
    WebElement passwordLabel;
    @FindBy(id = "input-password")
    WebElement password;
    @FindBy(linkText = "Forgotten Password")
    WebElement forgottenPassword;
    @FindBy(css = "#form-login button[type='submit']")
    WebElement submitButton;
    @FindBy(id="alert")
    WebElement alert;

    public void login_user(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
    }
}
