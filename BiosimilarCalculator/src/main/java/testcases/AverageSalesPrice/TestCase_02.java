package testcases.AverageSalesPrice;

import java.awt.AWTException;

import pages.AverageSalesPrice;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_02: Check that the respective data is getting displayed in the "Average Sales Price" page

public class TestCase_02 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApp(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickAverageSalesPriceMenu();

		new AverageSalesPrice().verifySelectFilesButton().verifyTableHeadersInAverageSalesPricePage(
				DataInputProvider.getCellData_ColName(iRowNumber, "HCPCS_CodeHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ShortDescriptionHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "HCPCSCodeDosageHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASPDrugStrengthNumberHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "ASPDrugStrengthUnitsHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Payment_LimitHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "CreatedOnHeader", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "CreatedByHeader", sDataSheetName));

	}
}
