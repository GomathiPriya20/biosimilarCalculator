package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_08: Check that on clicking the Clear filter icon near the Search field and Drop down field, the search result is disappeared and default data getting loaded.

public class TestCase_08 {

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
				.clearFilterResults()

				.verifyListOfUserName(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "listOfUsersInPage1", sDataSheetName));

	}
}
