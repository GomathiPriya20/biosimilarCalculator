package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_12: IVIG_DrugDashboard_Add_ErrorMsg

public class TestCase_12 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {
		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu().drugDetail_ErrorMsg_IVIG_DrugsDashboardPage(
				DataInputProvider.getCellData_ColName(iRowNumber, "NDC_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Calculator_Type_IntCode", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "SupplierName_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "GenericName_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "WACPrice _ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DrugDosageForm _ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthNumber_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthUnit_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DrugStrengthVolume_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DrugFormCode_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DosePerVial_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "DrugPackQuantity_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASP_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASPAdjustment_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASPDrugStrengthUnit_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASPDrugStrengthNumber_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Facility340BPriceAdjustment_ErrorMsg",
						sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "SequestrationReduction_ErrorMsg", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "HCPCS_ErrorMsg", sDataSheetName));

	}
}
