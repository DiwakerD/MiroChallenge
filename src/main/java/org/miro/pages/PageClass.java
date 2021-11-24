package org.miro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class PageClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor javascriptExecutor;
    private final Properties prop;

    private long implicitwait = 30;
	public static final long PAGELOADTIMEOUT = 40;
	public static final long EXPLICITWAIT = 8;
    public static final String CONFIG_PROPERTIES = "\\src\\main\\java\\org\\miro\\utilities\\config.properties";

    protected PageClass(WebDriver driver, WebDriverWait wait) throws IOException {
        this.driver = driver;
        this.wait = wait;
        prop = new Properties();
        javascriptExecutor = (JavascriptExecutor)driver;
        try (FileInputStream file = new FileInputStream(System.getProperty("user.dir") + CONFIG_PROPERTIES)) {
            prop.load(file);
        }
    }

	public long getImplicitwait() {
		return implicitwait;
	}
	public void setImplicitwait(long implicitwait) {
		this.implicitwait = implicitwait;
	}

	public Properties getProp() {
		return prop;
	}

    public abstract WebElement getElement(By locator);

    public abstract void waitForElementPresent(By locator);


    public abstract boolean clickElement(By locator);


    public abstract boolean sendKeys(By locator, String keys);

    public abstract String takeScreenshot(WebDriver driver) throws IOException;


    public <pageClass extends BasePage> pageClass getInstance(Class<pageClass> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(driver, wait);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


}
