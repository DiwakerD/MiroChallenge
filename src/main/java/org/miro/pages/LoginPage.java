package org.miro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoginPage extends BasePage {
    private final By insertName = By.id("name");
    private final By getStartedNow = By.xpath("//*[text()='Get started now']");
    private final By miroTitleLogo = By.xpath("//*[name()='svg']//*[text()='Miro Logo']");
    private final By insertEmailId = By.id("email");
    private final By emailError = By.id("emailError");
    private final By nameError = By.id("nameError");
    private final By termsError = By.id("termsError");
    private final By passwordError = By.xpath("//*[normalize-space(text())='Please enter your password.']");
    private final By insertPassword = By.id("password");
    private final By agreeToTerms = By.id("signup-terms");

    public LoginPage(WebDriver driver, WebDriverWait wait) throws IOException {
        super(driver, wait);
    }

    public boolean insertEmailID(String emailID) {
        return sendKeys(insertEmailId, emailID);
    }

    public boolean clickOnGetStartedNow() {
        javascriptExecutor.executeScript("javascript:window.scrollBy(0,250)");
        return clickElement(getStartedNow);
    }

    public boolean clickOnAgreeToTerms() {
        return clickElementUsingJS(agreeToTerms);
    }

    public boolean isMiroTitleIsVisible() {
        return elementIsVisible(miroTitleLogo);
    }

    public boolean isEnterEmailErrorVisible() {
        return elementIsVisible(emailError);
    }

    public boolean isEnterNameErrorVisible() {
        return elementIsVisible(nameError);
    }

    public boolean isEnterPasswordErrorVisible() {return elementIsVisible(passwordError);}

    public boolean isPleaseAgreeWithTermsErrorVisible() {return elementIsVisible(termsError);}

    public boolean isCheckYourEmailIsVisible(String emailId) {
        String checkYourEmailPre = "//*[@class='signup__subtitle-form']//*[text()='";
        String checkYourEmailPost = "']";
        return elementIsVisibleForAValue(checkYourEmailPre +emailId+ checkYourEmailPost);
    }

    public boolean insertName(String name) {
        return sendKeys(insertName, name);
    }

    public boolean insertPassword(String password) {
        return sendKeys(insertPassword, password);
    }

}
