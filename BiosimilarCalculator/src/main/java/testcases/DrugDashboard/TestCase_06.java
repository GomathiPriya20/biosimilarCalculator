package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//Testcase:06_DrugsDashboard_ExportToExcel

public class TestCase_06 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName))
				.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName))
				.clickSignIn().closePopupOnDashboardPage().clickClinicalResourcesApplication(
						DataInputProvider.getCellData_ColName(iRowNumber, "calculatorPageUrl", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu().verifyExportToExcelButtonInDrugsDashboardPage()
				.clickExportToExcelButtonInDrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "downloadedPath", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "downloadedExcelFileName", sDataSheetName));
	}
}
