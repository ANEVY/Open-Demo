package pages;

import drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ForgottenPassword {
    WebDriver driver;
    public ForgottenPassword() throws IOException {
        driver = DriverManager.get_instance().get_driver();
        PageFactory.initElements(driver,this);
    }
    //  Define Page Elements
    @FindBy(css = "#content > div > div > div > div > div.card-header")
    WebElement pageHeader;
    @FindBy(css = "#form-forgotten > p")
    WebElement description;
    @FindBy(css = "#form-forgotten label[for='input-email']")
    WebElement emailLabel;
    @FindBy(id = "input-email")
    WebElement email;
    @FindBy(css = "#form-forgotten button[type='submit']")
    WebElement submitButton;
    @FindBy(css = "#form-forgotten a[aria-label='Back']")
    WebElement loginButton;
    @FindBy(css="#alert .alert")
    WebElement alert;

    public void send_forgot_password_email(String email){
        this.email.sendKeys(email);
        this.submitButton.click();
    }
    public void go_to_login_page(){
        this.loginButton.click();
    }
    public WebElement getAlert(){
        return this.alert;
    }


}
