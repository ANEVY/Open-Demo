package pages.dashboard;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Dashboard {
    WebDriver driver;
    public Dashboard() throws IOException {
        driver = DriverManager.get_instance().get_driver();
        PageFactory.initElements(driver,this);
    }
    //Define Dashboard element
    @FindBy(css = "#modal-security > div > div > div.modal-header > button")
    WebElement closeSecurityModalButton;
    @FindBy(css = "#header > div > a")
    WebElement logo;
    @FindBy(css = "#header-notification > a")
    WebElement notificationLink;
    @FindBy(css = "#header-profile > a")
    WebElement userAccount;
    @FindBy(css = "#header-logout > a")
    WebElement logout;
    @FindBy(linkText = "Your Profile")
    WebElement profileLink;
    @FindBy(linkText = "Your Store")
    WebElement storeLink;
    @FindBy(linkText = "OpenCart Homepage")
    WebElement homepageLink;
    @FindBy(linkText = "Documentation")
    WebElement documentationLink;
    @FindBy(linkText = "Support Forum")
    WebElement supportForumLink;

    public void click_logo(){
        this.logo.click();
    }
    public void click_notification_icon(){
        this.notificationLink.click();
    }
    public void click_user_account_icon(){
        this.userAccount.click();
    }
}
