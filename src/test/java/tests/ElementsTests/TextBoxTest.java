package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.ElementsPage;


public class TextBoxTest extends BaseTest {

    @Test
    public void testSubmitTextBox() {
        final String fullName = "Jagadish Vasudev";
        final String email = "Jagadish@mailinator.com";
        final String currentAddress = "Isha Yoga Center, Coimbatore, Tamil Nadu, India";
        final String permanentAddress = "Mysore, Mysore State, India";
        final String expectedFullName = "Jagadish Vasudev";
        final String expectedEmail = "Jagadish@mailinator.com";
        final String expectedCurrentAddress = "Isha Yoga Center, Coimbatore, Tamil Nadu, India";
        final String expectedPermanentAddress = "Mysore, Mysore State, India";

        ElementsPage textBoxPage = openBaseURL()
                .clickElementsMenu()
                .clickTextBox()
                .inputFullName(fullName)
                .inputEmail(email)
                .inputCurrentAddress(currentAddress)
                .inputPermanentAdress(permanentAddress)
                .clickSubmit();

        textBoxPage.clickTextBox().isFullNameDisplayed();
        textBoxPage.clickTextBox().isEmailDisplayed();
        textBoxPage.clickTextBox().isCurrentAddressDisplayed();
        textBoxPage.clickTextBox().isPermanentAddressDisplayed();

        Assert.assertTrue(textBoxPage.clickTextBox().isNameContains(expectedFullName));
        Assert.assertTrue(textBoxPage.clickTextBox().isEmailContains(expectedEmail));
        Assert.assertTrue(textBoxPage.clickTextBox().isCurrentAddressContains(expectedCurrentAddress));
        Assert.assertTrue(textBoxPage.clickTextBox().isPermanentAddressContains(expectedPermanentAddress));
    }
}
