package testcases.AverageSalesPrice;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_03: Check that the filter option is available only in the "Trade Name" and "Adjusted Package Size" columns in the "Switch from Originator to Biosimilar and Save $$$" table

public class TestCase_03 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();

		new CalculatorPage()

				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				// 1. TradeName
				.search_FieldName_InTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_lowercase", sDataSheetName))
				.verifyColwiseFilterResults_BiosimilarCalculatorTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_lowercase", sDataSheetName))
				.clearFilterResultsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName))

				// 3. Adjusted Package Size
				.search_FieldName_InTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "AdjustedPackageSizeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName))
				.verifyColwiseFilterResults_BiosimilarCalculatorTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForAdjustedPackageSize",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName))
				.clearFilterResultsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "AdjustedPackageSizeHeader", sDataSheetName))

		;

	}
}
