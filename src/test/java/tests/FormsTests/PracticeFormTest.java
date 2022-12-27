package tests.FormsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Forms.FormsPage;
import pages.Forms.PracticeFormPage;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testNavigationToPracticeFormPage() {
        String expectedUrl = "https://demoqa.com/automation-practice-form";
        String expectedTitle = "ToolsQA";
        String expectedHeader = "Practice Form";

        FormsPage practiceFormPage = openBaseURL()
                .clickFormsMenu()
                .clickPracticeForm();

        String actualUrl = practiceFormPage.getCurrentURL();
        String actualTitle = practiceFormPage.getTitle();
        String actualHeader = practiceFormPage.getH2LogoHeaderText();

        Assert.assertNotEquals(actualUrl, BASE_URL);
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void testStudentRegistrationPracticeFormPage() {
        String name = "Vasily";
        String sureName = "Peremoga";
        String email = "peremoga@google.com";
        String gender = "Male";
        String number = "0123456789";

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
