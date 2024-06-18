package testcases.AcquisitionCostSavingCalculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_01: Check if user can able to see the "Switch from Originator to Biosimilar and Save $$$" table

public class TestCase_01 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();

		new CalculatorPage()

				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.verifyIfSwitchFromOriginatorToBiosimilarTableIsAvailable();

	}
}
