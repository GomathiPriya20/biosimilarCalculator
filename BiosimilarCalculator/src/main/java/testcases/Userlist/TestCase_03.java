package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_03: Check that the header "User with their roles" is getting displayed at the top of the table

public class TestCase_03 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage()

				.verifyCalculatorMenuOptions(
						DataInputProvider.getCellData_ColName(iRowNumber, "biosimilarCalculatorMenu", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "IVIGcalculatorMenu", sDataSheetName))

				.clickUserlistMenu().verifyColumnHeaders();

		new UserlistPage()
				.searchUserName_InUserListPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "userName", sDataSheetName))
				
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "userName", sDataSheetName))

		;
	}
}
