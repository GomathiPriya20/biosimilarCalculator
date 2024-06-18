package driver;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import base.PreAndPost;
import utils.DataInputProvider;

public class Driver extends PreAndPost {

	public static int iTestCaseRowNum;
	public static String sTestCaseID;
	public static Properties properties = new Properties();
	public static String sRunMode;
	public static String sCategory;
	public static Method[] aMethod;
	public static int iTestCaseRowNumDriver;
	public static String sReleaseCategory;
	public static int failCount = 0;

	@Test()
	public void executeTestcase(ITestContext testContext) throws Exception, ClassNotFoundException {
		failCount = 0;
		properties.load(new FileInputStream(new File("./src/test/resources/environment.properties")));
		int currentCount = testContext.getAllTestMethods()[0].getCurrentInvocationCount();

		// Read test case id and runmode from Driver sheet
		sTestCaseID = DataInputProvider.getCellData_ColName(currentCount + 1, properties.getProperty("ColTestCaseName"),
				properties.getProperty("DriverSheetName"));
		sRunMode = DataInputProvider.getCellData_ColName(currentCount + 1, properties.getProperty("ColRunMode"),
				properties.getProperty("DriverSheetName"));
		iTestCaseRowNumDriver = DataInputProvider.getRowNum(properties.getProperty("DriverSheetName"), sTestCaseID);
		sCategory = DataInputProvider.getCellData_ColName(currentCount + 1, properties.getProperty("ColCategory"),
				properties.getProperty("DriverSheetName"));
		sReleaseCategory = DataInputProvider.getCellData_ColName(currentCount + 1, "ReleaseCategory",
				properties.getProperty("DriverSheetName"));

		// Get the row number of the test case which is marked as yes from actual
		// category sheet
		iTestCaseRowNum = DataInputProvider.getRowNum(sCategory, sTestCaseID);

		String name[] = sTestCaseID.split(":");
		String sTClassName[] = name[0].split("_");
		String sTestClassName = "TestCase_".concat(sTClassName[1].trim());
		// Execute the test cases which are marked as yes in run mode column in driver
		// sheet
		if (sCategory.equalsIgnoreCase("Biosimilar_340B")) {
			sTestClassName = "testcases.Biosimilar_340B.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("Biosimilar_Non340B")) {
			sTestClassName = "testcases.Biosimilar_Non340B.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("Originator_340B")) {
			sTestClassName = "testcases.Originator_340B.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("Originator_Non340B")) {
			sTestClassName = "testcases.Originator_Non340B.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("DrugDashboard")) {
			sTestClassName = "testcases.DrugDashboard.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("Calculator")) {
			sTestClassName = "testcases.Calculator.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("IVIG_Conversions")) {
			sTestClassName = "testcases.IVIG_Conversions.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("AcquisitionCostSavingCalculator")) {
			sTestClassName = "testcases.AcquisitionCostSavingCalculator.".concat(sTestClassName);
		} else if (sCategory.equalsIgnoreCase("AverageSalesPrice")) {
			sTestClassName = "testcases.AverageSalesPrice.".concat(sTestClassName);
		} else {
			sTestClassName = "testcases.Userlist.".concat(sTestClassName);
		}

		// Create instance of the class during run time
		Class<?> cls = Class.forName(sTestClassName);
		Object clsInstance = (Object) cls.getDeclaredConstructor().newInstance();
		test = extent.createTest(sTestCaseID);
		test.assignCategory(sCategory);
		test.assignCategory(sReleaseCategory);
		if (sRunMode.equalsIgnoreCase("Yes")) {
			// Get all methods of the class
			aMethod = clsInstance.getClass().getDeclaredMethods();
			beforeMethod();
			aMethod[0].invoke(clsInstance, iTestCaseRowNum, sCategory);
			closeAllBrowsers();
		} else {
			throw new SkipException("Skipping execution for  :" + sTestCaseID);
		}
	}

	@AfterMethod
	public void Reports(ITestResult result) throws Exception {
		try {
			String sTimeStamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
			if (result.getStatus() == ITestResult.FAILURE) {
				DataInputProvider.setCellData("Failed", iTestCaseRowNumDriver, "Result",
						Driver.properties.getProperty("DriverSheetName"));
				DataInputProvider.setCellData(sTimeStamp, iTestCaseRowNumDriver, "TimeStamp",
						Driver.properties.getProperty("DriverSheetName"));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(sTestCaseID + " FAILED due to below issues:", ExtentColor.RED));
				test.fail(result.getThrowable());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				if (failCount == 0) {
					DataInputProvider.setCellData("PASSED", iTestCaseRowNumDriver, "Result",
							Driver.properties.getProperty("DriverSheetName"));
					DataInputProvider.setCellData(sTimeStamp, iTestCaseRowNumDriver, "TimeStamp",
							Driver.properties.getProperty("DriverSheetName"));
					test.log(Status.PASS, MarkupHelper.createLabel(sTestCaseID + " PASSED", ExtentColor.GREEN));
				} else {
					DataInputProvider.setCellData("Failed", iTestCaseRowNumDriver, "Result",
							Driver.properties.getProperty("DriverSheetName"));
					DataInputProvider.setCellData(sTimeStamp, iTestCaseRowNumDriver, "TimeStamp",
							Driver.properties.getProperty("DriverSheetName"));
					test.log(Status.FAIL, MarkupHelper.createLabel(sTestCaseID + " FAILED :", ExtentColor.RED));
				}
			} else {
				DataInputProvider.setCellData("No Run", iTestCaseRowNumDriver, "Result",
						Driver.properties.getProperty("DriverSheetName"));
				DataInputProvider.setCellData("", iTestCaseRowNumDriver, "TimeStamp",
						Driver.properties.getProperty("DriverSheetName"));
				test.log(Status.SKIP, MarkupHelper.createLabel(sTestCaseID + " SKIPPED", ExtentColor.ORANGE));
				test.skip(result.getThrowable());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
