package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BaseHelper {

    Logger logger = LoggerFactory.getLogger(BaseHelper.class);

    public WebElement findElementBase(By by) {
        return ApplicationManager.getDriver().findElement(by);
    }
public List<WebElement> findElementsBase (By by){
        return ApplicationManager.getDriver().findElements(by);
}
    public void clickBase(By by) {
        logger.info("By: " + by + " method click");
        findElementBase(by).click();
    }

    public void sendKeysBase(By by, String text) {
        WebElement el = findElementBase(by);
        el.click();
        el.clear();
        el.sendKeys(text);
    }
    public String getTextBase (WebElement element){
        return element.getText().toUpperCase().trim();
    }

    public boolean isTextActualEqualToExpected(By by, String text) {
        if(findElementBase(by).getText().toUpperCase().trim()
                .equals(text.toUpperCase().trim())) {
            return true;
        } else {
            System.out.println("actual result: " +
                    findElementBase(by).getText().toUpperCase().trim() +
                    " expected result: " + text.toUpperCase().trim());
            logger.info("actual result: " +
                    findElementBase(by).getText().toUpperCase().trim() +
                    " expected result: " + text.toUpperCase().trim());
            return false;
        }
    }

    public boolean isTextActualEqualToExpected2Strings(By by, String text, String text2) {
        if(findElementBase(by).getText().toUpperCase().trim()
                .equals(text.toUpperCase().trim())
                || findElementBase(by).getText().toUpperCase().trim()
                .equals(text2.toUpperCase().trim())) {
            return true;
        } else {
            System.out.println("actual result: " +
                    findElementBase(by).getText().toUpperCase().trim() +
                    " expected result: " + text.toUpperCase().trim() + " or "
                    + text.toUpperCase().trim());
            logger.info("actual result: " +
                    findElementBase(by).getText().toUpperCase().trim() +
                    " expected result: " + text.toUpperCase().trim() + " or "
                    + text.toUpperCase().trim());
            return false;
        }
    }

    public void pause(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateBack() {
        ApplicationManager.getDriver().navigate().back();
    }
}