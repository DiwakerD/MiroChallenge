
package org.miro.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class BasePage extends PageClass {
    private static final Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver, WebDriverWait wait) throws IOException {
        super(driver, wait);
    }

    @Override
    public WebElement getElement(By locator) {
        WebElement element;
        try {
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void waitForElementPresent(By locator) {
        try {
            this.setImplicitwait(0);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            this.setImplicitwait(10);
            logger.info("Waiting for the Visibility of Element Located By " + locator);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean clickElement(By locator) {

        try {
            WebElement element = getElement(locator);
            element.click();
            logger.info("Clicked At Element " + element);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean sendKeys(By locator, String keys) {
        try {
            if (elementIsPresentAndEnabled(locator)) {
                getElement(locator).sendKeys(keys);
                logger.info("Sent Keys At  " + locator);
            } else {
                waitForElementPresent(locator);
                getElement(locator).sendKeys(keys);
                logger.info("Took Time To Sent Keys At  " + locator);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean elementIsPresentAndEnabled(By locator) {
        return getElement(locator).isDisplayed() && getElement(locator).isEnabled();
    }

    public boolean elementIsVisible(By locator) {
        try {
            getElement(locator).isDisplayed();
            logger.info("Element Located By " + locator+" Is Displayed");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean elementIsVisibleForAValue(String locatorName) {
        try {
            getElement(By.xpath(locatorName)).isDisplayed();
            logger.info("Element Located By " + locatorName+" Is Displayed");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public boolean clickElementUsingJS(By locator) {
        try {
            javascriptExecutor.executeScript("arguments[0].click();", getElement(locator));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
