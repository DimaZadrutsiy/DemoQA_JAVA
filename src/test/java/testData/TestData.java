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
                {"https://demoqa.com/automation-practice-form", "DEMOQA", "Practice Form"}
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

    @DataProvider(name = "InteractionsSubmenu")
    public static Object[][] interactionsSubmenuDataProvider() {

        return new Object[][]{
                {0, "https://demoqa.com/sortable", "DEMOQA", "Sortable"},
                {1, "https://demoqa.com/selectable", "DEMOQA", "Selectable"},
                {2, "https://demoqa.com/resizable", "DEMOQA", "Resizable"},
                {3, "https://demoqa.com/droppable", "DEMOQA", "Droppable"},
                {4, "https://demoqa.com/dragabble", "DEMOQA", "Dragabble"}
        };
    }

    @DataProvider(name = "SelectableTabListData")
    public static Object[][] selectableTabListDataProvider() {

        return new Object[][]{
                {0, "mt-2 list-group-item list-group-item-action", "DEMOQA", "Cras justo odio"},
                {1, "mt-2 list-group-item list-group-item-action", "DEMOQA", "Dapibus ac facilisis in"},
                {2, "mt-2 list-group-item list-group-item-action", "DEMOQA", "Morbi leo risus"},
                {3, "mt-2 list-group-item list-group-item-action", "DEMOQA", "Porta ac consectetur ac"}
        };
    }

    @DataProvider(name = "CheckBoxTitle")
    public static Object[][] checkBoxDataProvider() {

        return new Object[][]{
                {0, "Home"},
                {1, "Desktop"},
                {2, "Notes"},
                {3, "Commands"},
                {4, "Documents"},
                {5, "WorkSpace"},
                {6, "React"},
                {7, "Angular"},
                {8, "Veu"},
                {9, "Office"},
                {10, "Public"},
                {11, "Private"},
                {12, "Classified"},
                {13, "General"},
                {14, "Downloads"},
                {15, "Word File"},
                {16, "Excel File"}
        };
    }

    @DataProvider(name = "SelectableTabGridData")
    public static Object[][] selectableTabGridDataProvider() {

        return new Object[][]{
                {0, "One", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {1, "Two", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {2, "Three", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {3, "Four", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {4, "Five", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {5, "Six", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {6, "Seven", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {7, "Eight", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"},
                {8, "Nine", "#ffffff", "#007bff", "list-group-item list-group-item-action", "list-group-item active list-group-item-action"}
        };
    }

    @DataProvider(name = "CorrectCodeAndNameLinks")
    public static Object[][] linksAndMassage() {

        return new Object[][]{
                {0, "Created", "201"},
                {1, "No Content", "204"},
                {2, "Moved Permanently", "301"},
                {3, "Bad Request", "400"},
                {4, "Unauthorized", "401"},
                {5, "Forbidden", "403"},
                {6, "Not Found", "404"}
        };
    }

    @DataProvider(name="AllBooksList")
    public static Object[][] allBooksList(){
        return new Object[][]{
            {0,"9781449325862","Git Pocket Guide","Richard E. Silverman",},
            {1,"9781449331818","Learning JavaScript Design Patterns","Addy Osmani"},
            {2,"9781449337711","Designing Evolvable Web APIs with ASP.NET","Glenn Block et al."},
            {3,"9781449365035","Speaking JavaScript", "Axel Rauschmayer"},
            {4,"9781491904244","You Don't Know JS","Kyle Simpson"},
            {5,"9781491950296","Programming JavaScript Applications","Eric Elliott"},
            {6,"9781593275846","Eloquent JavaScript, Second Edition","Marijn Haverbeke"},
            {7,"9781593277574","Understanding ECMAScript 6","Nicholas C. Zakas"}
        };
    }
}