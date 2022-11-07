package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	private ExtentReports report;
	private ExtentTest test;
	public static ExtentTest stest;

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("VTiGer");
		spark.config().setReportName("Vtiger");
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Girish");
		report.setSystemInfo("OS", "Unknow");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("failed");
		test.fail(result.getMethod().getMethodName()+"Fail");
		new WebDriverUtility().getScreenshot( Baseclass.sjavautility,Baseclass.sdriver, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"Skipped");
		}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("OnTestStart");
		}

	@Override
	public void onTestSuccess(ITestResult result) {
	test.pass(result.getMethod().getMethodName()+"Passed");
		}
	public void onFinish(ITestContext context) {
		report.flush();
	}

	

}
