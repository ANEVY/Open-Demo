package pages;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Login {
    WebDriver driver;
    public Login() throws IOException {
        driver =  DriverManager.get_instance().get_driver();
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
    @FindBy(css="#alert .alert")
    WebElement alert;

    public void login_user(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
    }
    public WebElement getAlert(){
        return this.alert;
    }
    public WebElement getForgottenPassword(){
        return this.forgottenPassword;
    }
}
