package tests.FormsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Forms.FormsPage;
import pages.Forms.PracticeFormPage;
import testData.TestData;

import static utils.ProjectConstants.*;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testNavigationToPracticeFormPage() {
        FormsPage practiceFormPage = openBaseURL()
                .clickFormsMenu()
                .clickPracticeForm();

        String actualUrl = practiceFormPage.getCurrentURL();
        String actualTitle = practiceFormPage.getTitle();
        String actualHeader = practiceFormPage.getH2Header();

        Assert.assertNotEquals(actualUrl, BASE_URL);
        Assert.assertEquals(actualUrl, PRACTICE_FORMS_URL);
        Assert.assertEquals(actualTitle, TITLE);
        Assert.assertEquals(actualHeader, PRACTICE_FORMS_HEADER);
    }
    @Ignore
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
