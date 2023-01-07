package testData;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "FormsRegistrationData")
    public static Object[][] mainDataProvider() {

        return new Object[][]{
                {"Vasily", "Peremoga", "peremoga@google.com", "Male", "0123456789"}
        };
    }

    @DataProvider(name = "PracticeFormsAttribute")
    public static Object[][] attributeDataProvider() {

        return new Object[][]{
                {"https://demoqa.com/automation-practice-form", "ToolsQA", "Practice Form"}
        };
    }

    @DataProvider(name = "DifferentBooksSearching")
    public static Object[][] differentBooksSearching() {
        return new Object[][]{
                {0, "Java", "Learning JavaScript Design Patterns", 4},
                {1, "Git", "Git Pocket Guide", 1},
                {2, "API", "Designing Evolvable Web APIs with ASP.NET", 1},
                {3, "JS", "You Don't Know JS", 1}
        };
    }
}