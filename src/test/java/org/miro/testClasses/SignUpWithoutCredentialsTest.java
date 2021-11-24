package org.miro.testClasses;

import org.miro.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpWithoutCredentialsTest extends BaseTest{

    @Test(description = "Verifying Title Is Visible")
    public void verifyPageTitle() {
        loginPage = page.getInstance(LoginPage.class);

        //Validate Miro Logo Title Is Visible
        Assert.assertTrue(loginPage.isMiroTitleIsVisible());
    }


    @Test(description = "Verifying User Clicks on Get Started Now",dependsOnMethods = "verifyPageTitle")
    public void verifyClicksOnGetStartedNow() {
        //Click on 'Get Started Now'
        Assert.assertTrue(loginPage.clickOnGetStartedNow());
    }

    @Test(description = "Validate 'Enter Your Name' Error Is Visible",dependsOnMethods = "verifyClicksOnGetStartedNow")
    public void verifyEnterYourNameErrorIsVisible() {
        //Verify 'Please enter your name.' Error is Visible
        Assert.assertTrue(loginPage.isEnterNameErrorVisible());
    }

    @Test(description = "Validate 'Enter Your Email' Error Is Visible",dependsOnMethods = "verifyClicksOnGetStartedNow")
    public void verifyEnterYourEmailErrorIsVisible() {
        //Verify 'Please enter your email address.' Error is Visible
        Assert.assertTrue(loginPage.isEnterEmailErrorVisible());
    }

    @Test(description = "Validate 'Enter Your Password' Error Is Visible",dependsOnMethods = "verifyClicksOnGetStartedNow")
    public void verifyEnterYourPasswordErrorIsVisible() {
        //Verify 'Please enter your password.' Error is Visible
        Assert.assertTrue(loginPage.isEnterPasswordErrorVisible());
    }

    @Test(description = "Validate 'Please Agree With Terms' Error Is Visible",dependsOnMethods = "verifyClicksOnGetStartedNow")
    public void verifyPleaseAgreeWithTermsErrorIsVisible() {
        //Verify 'Please agree with the Terms to sign up.' Error is Visible
        Assert.assertTrue(loginPage.isPleaseAgreeWithTermsErrorVisible());
    }


}
