package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

// TC_02:DrugDashboard_Add_MandatoryAndOptional

public class TestCase_02 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName))
				.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName))
				.clickSignIn().closePopupOnDashboardPage().clickClinicalResourcesApplication(
						DataInputProvider.getCellData_ColName(iRowNumber, "calculatorPageUrl", sDataSheetName));

		new GeneralDashboardPage()
				.verifyHeaderPortion(
						DataInputProvider.getCellData_ColName(iRowNumber, "calculatorMenu", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "drugsDashboardMenu", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "welcomeText", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "userName", sDataSheetName))
				.clickPremierLogo()
				.verifyPremierPage(DataInputProvider.getCellData_ColName(iRowNumber, "PremierURL", sDataSheetName));

		new CalculatorPage().verifyBlankCalulatorPage(
				DataInputProvider.getCellData_ColName(iRowNumber, "CalculatorHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "SelectaDrugHeader", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu().verifyAddNewButtonInDrugsDashboardPage()
				.verifyExportToExcelButtonInDrugsDashboardPage().verifyEditButtonInDrugsDashboardPage()
				.verifyRemoveButtonInDrugsDashboardPage()

				.verifyColumnHeadersInDrugsDashboardPage()
				.addDrugDetailWithallFieldValues_Biosimilar_DrugsDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GroupName_IntCode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "IsOriginator", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Supplier", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractNumber", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceTypeIntCode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Strength_Number", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthUnitIntCode", sDataSheetName),
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
						DataInputProvider.getCellData_ColName(iRowNumber, "HCPCScode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "testUser", sDataSheetName))

		;
	}
}
