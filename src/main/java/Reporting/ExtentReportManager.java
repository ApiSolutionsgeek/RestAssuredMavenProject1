package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {

   public static ExtentReports extentReport;
   public static ExtentReports createInstance(String fileName,String reportName,String documentTitle)
   {
      ExtentSparkReporter extentSparkreporter= new ExtentSparkReporter(fileName);
       extentSparkreporter.config().setReportName(reportName);
       extentSparkreporter.config().setDocumentTitle(documentTitle);
       extentSparkreporter.config().setTheme(Theme.DARK);
       extentSparkreporter.config().setEncoding("utf-8");

       extentReport=new ExtentReports();
       extentReport.attachReporter(extentSparkreporter);
        return extentReport;
   }
public static String generateReportNameWithTimeStamp()
    {
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("YYYY_MM_DD_HH_mm_ss");
        LocalDateTime localDateTime= LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName="TestReport"+ formattedTime + ".html";
          return reportName;
    }
    public static void logPassDetails(String log)
    {
    Setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailureDetails(String log)
    {
        Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logExceptionDetails(String log)
    {
        Setup.extentTest.get().fail((log));
    }
    public static void logInfoDetails(String log)
    {
        Setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logWarningDetails(String log)
    {
        Setup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
    public static void logJson(String json)
    {
        Setup.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }
    public static void logHeaders(List<Header> headerList)
    {
        String [][] arrayHeaders= headerList.stream().map(header->new String [] { header.getName(),header.getValue()}).toArray(String[][] ::new);
        Setup.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }
}
