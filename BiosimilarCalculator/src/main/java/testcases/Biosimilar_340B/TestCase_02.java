package testcases.Biosimilar_340B;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_02:BiosimilarCalculator_Biosimilar_ 340BFacilityType_SameUnits_MG

public class TestCase_02 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu()

				.addDrugForCalculation_Biosimilar_DrugsDashboardPage(
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
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthUnitIntCode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Adjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "AspDrugStrengthUnitsIntCode",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Facility340BPriceAdjustment",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "BiosimilarUseFacility340BPriceAdjustment",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "HCPCScode", sDataSheetName))

		;
		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))
				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))
				.select_340B_Checkbox()

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))

				.verifyTableHeadersInCalulatorPage_340B(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDCHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "FormHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "AdjustedPackageSizeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageQuantityHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "BiosimilarGroupHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "IsOriginatorHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceTypeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractStrengthHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPStrengthHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractUnitsHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ReimbursementHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialPerUnitsHeader", sDataSheetName))

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
