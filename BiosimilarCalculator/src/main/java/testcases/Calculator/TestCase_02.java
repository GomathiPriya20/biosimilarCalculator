package testcases.Calculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_02: Check if the user can able to search an existing drug with Uppercase & lowercase text

public class TestCase_02 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				//.update_CreatedOnToExcel(
				//		DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName));
				.update_UpdatedOnToExcel(DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName));
		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))

				.verifyBasicTableValuesForSpecificNDCInBiosimilarCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GroupName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "IsOriginator", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "UpdatedOn", sDataSheetName),
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
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Units", sDataSheetName));

			new GeneralDashboardPage().clickDrugsDashboardMenu()
				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))
				//.update_CreatedOnToExcel(
				//		DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName));
				.update_UpdatedOnToExcel(DataInputProvider.getCellData_ColName(iRowNumber, "SheetName", sDataSheetName));
		new GeneralDashboardPage().clickCalculatorMenu().clickIVIGCalculatorMenu();
		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_lowercase", sDataSheetName))
				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))

				.verifyBasicTableValuesForSpecificNDCInIvigCalulatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "UpdatedOn", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPrice_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPrice_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPrice_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Units_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Volume_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Form_Code_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Ivig", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Number_Ivig",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ASP_Drug_Strength_Units_Ivig",
								sDataSheetName));

	}
}
