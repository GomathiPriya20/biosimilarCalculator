package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_06: Check that the Filter functionalities are working as expected in "User Name" and "User Email Address" columns of the "UserList" page

public class TestCase_06 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage()

				.verifyCalculatorMenuOptions(
						DataInputProvider.getCellData_ColName(iRowNumber, "biosimilarCalculatorMenu", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "IVIGcalculatorMenu", sDataSheetName))
				.clickUserlistMenu();

		new UserlistPage()
				.searchUserName_WithStartsWithFilterOption(
						DataInputProvider.getCellData_ColName(iRowNumber, "userNameStartText", sDataSheetName))
				.verifyStartTextFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "userNameStartText", sDataSheetName))
				.clearFilterResults()

				.searchUserEmailAddress_WithEndsWithFilterOption(DataInputProvider.getCellData_ColName(iRowNumber,
						"userEmailAddressEndsWithText", sDataSheetName))
				.verifyEndsWithTextFilterResults(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserEmailAddress", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "userEmailAddressEndsWithText",
								sDataSheetName))
				.clearFilterResults();

	}
}
