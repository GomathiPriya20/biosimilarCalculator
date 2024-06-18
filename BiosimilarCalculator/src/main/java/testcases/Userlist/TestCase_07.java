package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_07: Check that the list of Users are getting displayed in the "UserList" page

public class TestCase_07 {

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
				.verifyListOfUserName(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "listOfUsersInPage1", sDataSheetName))

				.clickPage2Icon().verifyListOfUserName(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "listOfUsersInPage2", sDataSheetName));

	}
}
