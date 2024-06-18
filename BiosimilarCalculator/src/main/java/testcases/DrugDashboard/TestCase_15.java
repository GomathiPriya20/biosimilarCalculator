package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

// TC_15: IVIG_DrugDashboard_ ExportToExcel

public class TestCase_15 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu()

				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCalculatorType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForCalculatorType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type", sDataSheetName))
				.verifyExportToExcelButtonInDrugsDashboardPage().clickExportToExcelButtonInDrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "downloadedPath", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "downloadedExcelFileName", sDataSheetName));
	}
}
