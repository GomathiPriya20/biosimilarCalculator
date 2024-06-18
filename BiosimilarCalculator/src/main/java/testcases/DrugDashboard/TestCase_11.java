package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

// TC_11: IVIG_DrugDashboard_ AddNewDrug_AllFields

public class TestCase_11 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu().addDrugDetailWithallFieldValues_IVIG_DrugsDashboardPage(
				DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type_IntCode", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "IsOriginator", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "SupplierName", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "GenericName", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ContractNumber", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ContractPrice", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceTypeIntCode", sDataSheetName),
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
				DataInputProvider.getCellData_ColName(iRowNumber, "HCPCScode", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "testUser", sDataSheetName))

				.select_NDCfromFilterMenu(DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.clickRemoveButtonInDrugsDashboardPage();

	}
}
