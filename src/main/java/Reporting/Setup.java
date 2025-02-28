package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<>();


    public void onStart(ITestContext context) {

         String reportName =   ExtentReportManager.generateReportNameWithTimeStamp();
         String fullReportPath= System.getProperty("user.dir")+ "\\reports\\" + reportName;
         extentReports= ExtentReportManager.createInstance(fullReportPath,"API automation report","Test Execution Report");

    }
    public void onFinish(ITestContext context) {
    if(extentReports!=null)
        extentReports.flush();

    }
    public void onTestStart(ITestResult result) {
       ExtentTest test=  extentReports.createTest("Test name"+ result.getTestClass().getName() + result.getMethod().getMethodName());
        extentTest.set(test);
    }
    public void onTestFailure(ITestResult result) {
       ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
       String stackTrace= Arrays.toString(result.getThrowable().getStackTrace());
       stackTrace= stackTrace.replaceAll("," , "<br>");
       String formattedTrace="<deatils>\n" +
                                     " <summary>Click here to see exception logs</summary>\n" +
                                      " "+stackTrace+"\n" +
                             "</deatils>\n" ;

        ExtentReportManager.logExceptionDetails(formattedTrace);
    }






}
