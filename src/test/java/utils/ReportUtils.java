package utils;

import base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtils {

    private final static String H_LINE = ConsoleColors.CYAN + " ==========================================================================================\n";
    public final static String END_LINE = ConsoleColors.PURPLE_BRIGHT + "\n______________________________________________________________________________________________________________________________" + ConsoleColors.RESET;

    private static String getTestStatus(ITestResult result) {
        int status = result.getStatus();

        switch (status) {
            case 1:
                return "\u001B[32m" + "PASS" + "\u001B[0m";
            case 2:
                return "\u001B[31m" + "FAIL" + "\u001B[0m";
            default:
                return "UNDEFINED";
        }
    }

    private static String getTestRunTime(ITestResult result) {
        final long time = result.getEndMillis() - result.getStartMillis();

        return DateTimeUtils.getTimeInMinSecFormat(time);
    }

    public static String getReportHeader(ITestContext context) {

        String header = "\tTest Report\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "\n";
        String currentDate = "\tDate: "
                + DateTimeUtils.getCurrentDateTime()
                + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "\n";
        String projectName = "\tProject: DemoQA_JAVA" + "\n";
        String baseURL = "\tBASE_URL: " + BaseTest.getBaseUrl()
                + "\t\t\t\t\t\t\t\t\t\t\t" + "\n";

        return H_LINE + header + currentDate + projectName + baseURL + H_LINE;
    }

    public static String getClassNameTestName(Method method, ITestResult result) {
        String className = result.getTestClass().toString();
        String testName = method.getName();

        return className.substring(22, className.length() - 1) + "/" + testName;
    }

    public static String getTestStatistics(Method method, ITestResult result) {

        return getClassNameTestName(method, result)
                + "   ----   " + getTestStatus(result)
                + "\t Run Time: " + getTestRunTime(result)
                + END_LINE;
    }
}
