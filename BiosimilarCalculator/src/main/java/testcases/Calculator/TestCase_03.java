package testcases.Calculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_03: Verify if two additional columns are added to to the IVIG calculator

public class TestCase_03 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickIVIGCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName))
				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))

				.verify_TwoNewColumns_InIvigCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPrice_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Units_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName));

	}
}
