package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Setup_Class {
    public static String dir = System.getProperty("user.dir");

    private static final String Chromedriver = dir + "/src/main/java/Driver/chromedriver.exe";
    private static final String Firefox = dir + "/src/main/java/Test_Drivers/geckodriver.exe";

    private static WebDriver driver;

    // This method will be called from the Test and you will need to pass in the URL and Browser Choice ..e.g . ChRome or FireFOx
    public static WebDriver startBrowserOfChoice(String URL, String BrowserChoice) throws  InterruptedException {
        TimeUnit.SECONDS.sleep(10);

        if (BrowserChoice.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Chromedriver);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(options);
        } else if (BrowserChoice.equalsIgnoreCase("FireFox")) {
            System.setProperty("webdriver.gecko.driver", Firefox);
           // driver = new FirefoxDriver();
        }
        driver.get(URL);
        return driver;
    }
}
