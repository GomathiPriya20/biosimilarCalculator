package testcases.Biosimilar_340B;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_09:BiosimilarCalculator_Biosimilar_ 340BFacilityType_DifferentUnits_MCGtoG

public class TestCase_09 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu().addDrugForCalculation_Biosimilar_DrugsDashboardPage(
				DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type_IntCode", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "GroupName_IntCode", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "IsOriginator", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "SupplierName", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "GenericName", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ContractPrice", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPrice", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "WACPrice", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthUnitIntCode", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASP", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "AspDrugStrengthUnitsIntCode", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Number", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Facility340BPriceAdjustment", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "BiosimilarUseFacility340BPriceAdjustment",
						sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "HCPCScode", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.update_CreatedOnToExcel(
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))
				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))
				.select_340B_Checkbox()

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))

				.calculate340BFacilityPricetoBillingUnits_Customize(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "multiplicationFactor", sDataSheetName))

				.calculateASPPriceinContractUnits_Customize(
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "multiplicationFactor", sDataSheetName))

				// Calculate Values for 340B Price
				// Reimbursement column
				.calculate_Biosimilar_340BPrice_Reimbursement(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPPriceinContractUnits", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName))

				// Differential column
				.calculate_Biosimilar_340BPrice_Differential(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPPriceinContractUnits", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName))

				// Differential per User input Units column
				.calculate_Biosimilar_340BPrice_Differential_per_User_input_Units(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPPriceinContractUnits", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName))

				// Calculate Values for WAC Price
				// Reimbursement column
				.calculate_Biosimilar_WACPrice_Reimbursement(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPPriceinContractUnits", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName))

				// Differential column
				.calculate_Biosimilar_WACPrice_Differential(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPPriceinContractUnits", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName))

				// Differential per User input Units column
				.calculate_Biosimilar_WACPrice_Differential_per_User_input_Units(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPPriceinContractUnits", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName))

				.verifyTableValuesForSpecificNDCInCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GroupName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "IsOriginator", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "CreatedOn", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Units", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Units", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Reimbursement_340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Differential_340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialperUserinputUnits_340BPrice",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Reimbursement_WACPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Differential_WACPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialperUserinputUnits_WACPrice",
								sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.clickRemoveButtonInDrugsDashboardPage();

	}
}
