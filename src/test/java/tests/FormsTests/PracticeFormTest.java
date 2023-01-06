package tests.FormsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Forms.FormsPage;
import pages.Forms.PracticeFormPage;
import testData.TestData;

public class PracticeFormTest extends BaseTest {

    @Test(dataProviderClass = TestData.class, dataProvider = "PracticeFormsAttribute")
    public void testNavigationToPracticeFormPage(
            String expectedUrl, String expectedTitle, String expectedHeader) {
        final String expectedBasedURL = "https://demoqa.com/";

        FormsPage practiceFormPage = openBaseURL()
                .clickFormsMenu()
                .clickPracticeForm();

        String actualUrl = practiceFormPage.getCurrentURL();
        String actualTitle = practiceFormPage.getTitle();
        String actualHeader = practiceFormPage.getH2LogoHeaderText();

        Assert.assertNotEquals(actualUrl, expectedBasedURL);
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "FormsRegistrationData")
    public void testStudentRegistrationPracticeFormPage(
            String name, String sureName, String email, String gender, String number) {

        PracticeFormPage practiceFormPage = openBaseURL()
                .clickFormsMenu()
                .clickPracticeForm();

        practiceFormPage
                .inputPracticeFormFirstName(name)
                .inputPracticeFormLastName(sureName)
                .inputPracticeFormEmail(email)
                .inputPracticeFormGender()
                .inputPracticeFormNumber(number);

        Assert.assertEquals(practiceFormPage.getNamePracticeForm(), name + " " + sureName);
        Assert.assertEquals(practiceFormPage.getEmailPracticeForm(), email);
        Assert.assertEquals(practiceFormPage.getGenderPracticeForm(), gender);
        Assert.assertEquals(practiceFormPage.getNumberPracticeForm(), number);
    }
}
