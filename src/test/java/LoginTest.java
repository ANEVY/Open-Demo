import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginTest {
    WebDriver driver;
    DriverManager driverManager;
    @BeforeTest
    public void setDriverManager() throws IOException {
        driverManager = DriverManager.getInstance();
        driver = driverManager.getDriver();
        driver.get("https://demo.opencart.com/admin/index.php");

    }
    @Test
    public void loginWithValidCredentials(){
        System.out.println("Hello America");
    }
    @AfterTest
    public void closeDriverManager(){
        driverManager.quitDriverInstance();
    }
}
