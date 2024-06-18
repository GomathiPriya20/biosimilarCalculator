package testcases.Calculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_05 {

//TC_08:DrugDashboard_Filter

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickIVIGCalculatorMenu();

		new CalculatorPage()
				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				// 1. Trade Name
	/*			.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName))

				// 2. NDC
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "NDCHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForNDC", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC_Ivig", sDataSheetName))
				.clearFilterResults(DataInputProvider.getCellData_ColName(iRowNumber, "NDCHeader", sDataSheetName))

				// 3. Form
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "FormHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description_Ivig",
								sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForForm", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Dosage_Form_Description_Ivig",
								sDataSheetName))
				.clearFilterResults(DataInputProvider.getCellData_ColName(iRowNumber, "FormHeader", sDataSheetName))

				// 4. Package Size/Dose Per Vial
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageQuantityHeader_Type2", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize_Ivig", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForPackageSize", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Adjusted_PackageSize_Ivig", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageQuantityHeader_Type2", sDataSheetName))

				// 5. Package Quantity
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageQuantityHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity_Ivig", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForPackageQuantity", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Drug_Package_Quantity_Ivig", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageQuantityHeader", sDataSheetName))
*/
				// 6. Generic Name
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName_Ivig", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForGenericName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName_Ivig", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericNameHeader", sDataSheetName));

	}
}
