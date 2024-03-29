package drivers;

import Utils.Helpers;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver;

    private DriverManager() throws IOException {
        this.set_driver();
    }
    public static DriverManager get_instance() throws IOException {
        if (instance == null){
            instance = new DriverManager();
        }
        return instance;
    }
    private void set_driver() throws IOException {
        String preferredDriver = Helpers.getProperty("browser");
        switch (preferredDriver){
            case "edge":
                driver = new EdgeBrowser().set_web_driver();
                break;
            case "firefox":
                System.out.println("We got here");
                driver = new FirefoxBrowser().set_web_driver();
                break;
            default:
                driver = new ChromeBrowser().set_web_driver();
                break;
        }
    }

    public void quit_driver_instance(){
        instance = null;
    }
    public WebDriver get_driver(){
        return driver;
    }

}
