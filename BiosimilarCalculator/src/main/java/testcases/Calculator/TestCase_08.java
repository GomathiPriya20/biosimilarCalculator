package testcases.Calculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_08: Check that the values are getting displayed as per the calculation in the "Contract Strength" column of the Calculator page

public class TestCase_08 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))

				.verify_ContractStrength_ForSpecificNDCInBiosimilarCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Units", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickIVIGCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName))
				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))

				.verify_ContractStrength_ForSpecificNDCInIvigCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Units_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code_Ivig", sDataSheetName));

	}
}
