package drivers;

import Utils.Helpers;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver;

    private DriverManager() throws IOException {
        this.setDriver();
    }
    public static DriverManager getInstance() throws IOException {
        if (instance == null){
            instance = new DriverManager();
        }
        return instance;
    }
    private void setDriver() throws IOException {
        String preferredDriver = Helpers.getProperty("browser");
        switch (preferredDriver){
            case "edge":
                driver = new EdgeBrowser().setWebDriver();
                break;
            case "firefox":
                System.out.println("We got here");
                driver = new FirefoxBrowser().setWebDriver();
                break;
            default:
                driver = new ChromeBrowser().setWebDriver();
                break;
        }
    }

    public void quitDriverInstance(){
        instance = null;
    }
    public WebDriver getDriver(){
        return driver;
    }

}