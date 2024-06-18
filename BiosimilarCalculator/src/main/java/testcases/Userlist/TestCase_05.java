package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_05: Check that the Search functionality is working as expected in the "User Name" and "User Email Address" columns

public class TestCase_05 {

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
				.clearFilterResults()

				.searchUserEmailAddress_InUserListPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName))
				.verifyColwiseFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserEmailAddress", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName));
	}
}
