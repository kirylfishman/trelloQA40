package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DatesUtils;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

public class WDListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(WDListener.class);
    public WDListener() {
        super();
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        super.beforeAlertAccept(driver);
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        super.afterAlertAccept(driver);
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        super.afterAlertDismiss(driver);
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        super.beforeAlertDismiss(driver);
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
        logger.info("try to navigate to url: " + url + " from the url: " + driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);
        logger.info("navigation to the url: " + url + " success");
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        super.beforeNavigateBack(driver);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        super.afterNavigateBack(driver);
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        super.beforeNavigateForward(driver);
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        super.afterNavigateForward(driver);
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        super.beforeNavigateRefresh(driver);
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        super.afterNavigateRefresh(driver);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("start to search element by: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("found element by locator: " + by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
        logger.info("before click on: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
        logger.info("after click on: " + element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
        // change value of attribute in DOM
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.afterChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        super.beforeScript(script, driver);
        // js executor
        logger.info("before implement the script: " + script);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        super.afterScript(script, driver);
        logger.info("after implement the script: " + script);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        super.afterSwitchToWindow(windowName, driver);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        super.beforeSwitchToWindow(windowName, driver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("we got an exception: " + throwable.toString());
        logger.error("with the message: " + throwable.getMessage());
        String name = "src/test/screenshots/screenshot-" + DatesUtils.getDateString() + ".png";
        takeScreenshot((TakesScreenshot)driver, name);
        logger.info("created screenshot: " + name);
    }

    private void takeScreenshot(TakesScreenshot takeScreenshot, String name) {
        try {
            File tmp = takeScreenshot.getScreenshotAs(OutputType.FILE);
            File screenshot = new File(name);
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        super.beforeGetScreenshotAs(target);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        super.afterGetScreenshotAs(target, screenshot);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        super.beforeGetText(element, driver);
        logger.info("before get text from the element: " + element.toString());
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
        logger.info("after get text from the element: " + element.toString());
    }
}