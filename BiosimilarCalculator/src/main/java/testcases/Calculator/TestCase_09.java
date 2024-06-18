package testcases.Calculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_09: Check that the values are getting displayed in the "Contract Strength" column as per the changes made in the columns of the Drugs Dashboard table

public class TestCase_09 {

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

//Verify if updated values are reflected right in Biosimilar calculator page
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

//Update back the original values
		new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.updateDrugDetailsForContractStrengthCalculation_DrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthUnitIntCode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "UpdateToExistingValue", sDataSheetName));

//Update Drug details for IVIG calculator
		new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))
				.updateDrugDetailsForContractStrengthCalculation_DrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Number_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_DrugStrengthUnitIntCode_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Volume_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Form_Code_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "UpdateToNewValue", sDataSheetName));

//Verify if updated values are reflected right in IVIG calculator page
		new GeneralDashboardPage().clickCalculatorMenu().clickIVIGCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))

				.verify_ContractStrength_ForSpecificNDCInIvigCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Number_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Units_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Strength_Volume_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Updated_Drug_Form_Code_Ivig",
								sDataSheetName));

//Update back the original values
		new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))
				.updateDrugDetailsForContractStrengthCalculation_DrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthUnit_Ivig_IntCode",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "UpdateToExistingValue", sDataSheetName));
	}
}
