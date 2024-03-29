import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.Login;

import java.io.IOException;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    DriverManager driverManager;
    Login login;
    @BeforeTest
    public void set_driver_manager() throws IOException {
        login = new Login();
        driverManager = DriverManager.get_instance();
        driver = driverManager.get_driver();
        driver.get("https://demo.opencart.com/admin/index.php");
    }

    @Test(priority = -1)
    public void login_with_valid_username_wrong_password(){
        login.login_user("demo", "pass1243");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(d -> login.getAlert().isDisplayed());
        assert login.getAlert().getText().contains("No match for Username and/or Password.");
    }
    @Test(priority = 0)
    public void login_with_no_username_or_password(){
        login.login_user("", "");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(90));
        wait.until(ExpectedConditions.visibilityOf(login.getAlert()));
        assert login.getAlert().getText().contains("No match for Username and/or Password.");
    }
    @Test(priority = 2)
    public void login_with_valid_credentials(){
        login.login_user("demo", "demo");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        assert driver.getCurrentUrl().contains("dashboard");
    }
    @Test(priority = 1)
    public void verify_forgotten_password_Link(){
        login.getForgottenPassword().click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("forgotten"));
        assert driver.getCurrentUrl().contains("forgotten");
    }
    @AfterTest
    public void close_driver_manager(){
        driverManager.quit_driver_instance();
    }
}
