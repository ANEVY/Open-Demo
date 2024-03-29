import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ForgottenPassword;

import java.io.IOException;
import java.time.Duration;

public class ForgottenPasswordTest {
    WebDriver driver;
    ForgottenPassword forgottenPassword;
    DriverManager driverManager;

    @BeforeTest
    public void set_driver_manager() throws IOException {
        forgottenPassword = new ForgottenPassword();
        driverManager = DriverManager.get_instance();
        driver = driverManager.get_driver();
        driver.get("https://demo.opencart.com/admin/index.php?route=common/forgotten");
    }

    @Test
    public void validate_existing_email_reset_password(){
        forgottenPassword.send_forgot_password_email("neville@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(d-> forgottenPassword.getAlert().isDisplayed());
        assert forgottenPassword.getAlert().getText().contains("Warning: The E-Mail Address was not found in our records!");
    }

    @AfterTest
    public void close_driver_manager(){
        driverManager.quit_driver_instance();
    }
}