package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver;

    private DriverManager(){
        this.setDriver();
    }
    public static DriverManager getInstance(){
        if (instance == null){
            instance = new DriverManager();
        }
        return instance;
    }
    private void setDriver(){
        String preferredDriver = "chrome";
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
