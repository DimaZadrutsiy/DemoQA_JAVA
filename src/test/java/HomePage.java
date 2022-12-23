import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BaseTest {

    @Test
    public void testUrl_WhenOpenPricingPage() {
        String expectedResult = "https://demoqa.com/";

        openBaseURL();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
