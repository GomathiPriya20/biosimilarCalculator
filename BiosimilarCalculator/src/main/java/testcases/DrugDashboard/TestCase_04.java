package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_04 {
//TC_04:DrugDashboard_Update_Existing
	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		// Update Drug details for Biosimilar calculator
		new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.updateDrugDetailsForContractStrengthCalculation_DrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Number",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_DrugStrengthUnitIntCode",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Volume",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Form_Code", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "UpdateToNewValue", sDataSheetName));

		// Verify if updated values are reflected right in Biosimilar calculator page
		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))

				.verify_ContractStrength_ForSpecificNDCInBiosimilarCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Number",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Units",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Volume",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Form_Code", sDataSheetName));

		// Update back the original values
		new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.updateDrugDetailsForContractStrengthCalculation_DrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthUnitIntCode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "UpdateToExistingValue", sDataSheetName));

	}
}
