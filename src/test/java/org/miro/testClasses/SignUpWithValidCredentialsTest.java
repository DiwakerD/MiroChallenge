package org.miro.testClasses;

import org.miro.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpWithValidCredentialsTest extends BaseTest{

    String emailId;
    @Test(description = "Verifying Title Is Visible")
    public void verifyPageTitle() {
        loginPage = page.getInstance(LoginPage.class);

        //Validate Miro Logo Title Is Visible
        Assert.assertTrue(loginPage.isMiroTitleIsVisible());
    }

    @Test(description = "Verifying User Name and Email ID is Added",dataProvider="getUserData",dependsOnMethods = "verifyPageTitle")
    public void verifyUserDetailsAreAdded(String name,String emailId) {
        //Insert Name for SignUp
        this.emailId=emailId;
        Assert.assertTrue(loginPage.insertName(name));

        //Insert Email Id For Signup
        Assert.assertTrue(loginPage.insertEmailID(emailId));
    }

    @Test(description = "Verifying User Name and Email ID is Added",dependsOnMethods = "verifyUserDetailsAreAdded")
    public void verifyPasswordIsAdded() {
        //Insert Password
        Assert.assertTrue(loginPage.insertPassword(page.getProp().getProperty("PASSWORD")));
    }

    @Test(description = "Verifying User Selects I Agree to Terms",dependsOnMethods = "verifyPasswordIsAdded")
    public void verifyUserAgreeToTerms() {
        //Select 'I Agree To Term'
        Assert.assertTrue(loginPage.clickOnAgreeToTerms());
    }

    @Test(description = "Verifying User Clicks on Get Started Now",dependsOnMethods = "verifyUserAgreeToTerms")
    public void verifyClicksOnGetStartedNow() {
        //Click on 'Get Started Now'
        Assert.assertTrue(loginPage.clickOnGetStartedNow());
    }

    @Test(description = "Verifying 'Check your email Screen is Visible'",dependsOnMethods = "verifyClicksOnGetStartedNow")
    public void verifyCheckYourEmailScreenIsVisible() {
        //Verify 'Check You Email' Message is Visible
        Assert.assertTrue(loginPage.isCheckYourEmailIsVisible(emailId));
    }



}
