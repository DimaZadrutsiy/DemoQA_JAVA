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

        FormsPage AutomationPracticeFormPage = openBaseURL()
                .clickFormsMenu()
                .clickPracticeForm();

        String actualUrl = AutomationPracticeFormPage.getCurrentURL();
        String actualTitle = AutomationPracticeFormPage.getTitle();
        String actualHeader = AutomationPracticeFormPage.getH2LogoHeaderText();

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

        PracticeFormPage automationPracticeFormPage = openBaseURL()
                .clickFormsMenu()
                .clickPracticeForm();

        automationPracticeFormPage
                .inputPracticeFormFirstName(name)
                .inputPracticeFormLastName(sureName)
                .inputPracticeFormEmail(email)
                .inputPracticeFormGender()
                .inputPracticeFormNumber(number);

        Assert.assertEquals(automationPracticeFormPage.getNamePracticeForm(), name + " " + sureName);
        Assert.assertEquals(automationPracticeFormPage.getEmailPracticeForm(), email);
        Assert.assertEquals(automationPracticeFormPage.getGenderPracticeForm(), gender);
        Assert.assertEquals(automationPracticeFormPage.getNumberPracticeForm(), number);
    }
}
