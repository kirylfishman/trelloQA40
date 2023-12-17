package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    static Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    static EventFiringWebDriver driver;
    static String browser;

    public ApplicationManager() {
        browser = System.getProperty("browser", BrowserType.FIREFOX);
    }

//    public ApplicationManager(String browser) { this.browser = browser;
//    }

    public static void init() {
        ApplicationManager app = new ApplicationManager();
        System.out.println("browser: " + browser);
        if(browser.equals(BrowserType.CHROME)) {
            //   if(true) {
            driver = new EventFiringWebDriver(new ChromeDriver());
            // driver = new EventFiringWebDriver(WebDriverManager.chromedriver().create());
            logger.info("Test started on Chrome");
        } else if(browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("started firefox browser");
        }
        //   driver = new EventFiringWebDriver(new ChromeDriver());
        navigateToMainPage();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.register(new WDListener());
    }

    public static void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void navigateToMainPage() {
        // driver.navigate().to("https://trello.com/home");
        driver.navigate().to(ConfigProperties.getProperty("url"));
    }

}
