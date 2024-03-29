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
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        driver.get("https://demo.opencart.com/admin/index.php");
    }
    @Test
    public void login_with_valid_credentials(){
        login.login_user("demo", "demo");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        assert driver.getCurrentUrl().contains("dashboard");
    }
    @AfterTest
    public void close_driver_manager(){
        driverManager.quitDriverInstance();
    }
}
