package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_09: Check that the Page navigation functionalities are working as expected in the UserList page

public class TestCase_09 {

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

				.verifyDefaultItemsPerPageCount()

				.clickPage2Icon()
				.verifyListOfUserName(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "listOfUsersInPage2", sDataSheetName))

				.clickGoToPreviousPageIcon()
				.verifyListOfUserName(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "listOfUsersInPage1", sDataSheetName))

				.clickGoToNextPageIcon()
				.verifyListOfUserName(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "listOfUsersInPage2", sDataSheetName))

				.clickPage1Icon().verifyListOfUserName(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "listOfUsersInPage1", sDataSheetName))

		;

	}
}
