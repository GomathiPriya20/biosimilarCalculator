package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_17 {

//TC_17: IVIG_DrugDashboard_ Filter

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu()

				// 1. NDC
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForNDC", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForNDC", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "NDC", sDataSheetName))
				.clearFilterResults(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForNDC", sDataSheetName))

				// 2. Trade Name
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForTradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForTradeName", sDataSheetName))

				// 3. Calculator Type
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCalculatorType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForCalculatorType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCalculatorType", sDataSheetName))

				// 4. Supplier
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForSupplier", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SupplierName", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForSupplier", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "SupplierName", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForSupplier", sDataSheetName))

				// 5. Generic Name
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForGenericName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForGenericName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericName", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForGenericName", sDataSheetName))

				// 6. Contract Number
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractNumber", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractNumber", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractNumber", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractNumber", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractNumber", sDataSheetName))

				// 7. HCPCS code
				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForHCPCScode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "HCPCScode", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForHCPCScode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "HCPCScode", sDataSheetName))
				.clearFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForHCPCScode", sDataSheetName));

	}
}
