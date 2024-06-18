package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_10: Check that the Sorting functionality is working as expected in all the four columns of the UserList page

public class TestCase_10 {

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

				.verifySortingonAllColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "UserNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserName", sDataSheetName))

				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "UserEmailAddressHeader", sDataSheetName))
				.verifySortingonAllColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "UserEmailAddressHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUserEmailAddress", sDataSheetName))

				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "ManagerRoleHeader", sDataSheetName))
				.verifySortingonCheckboxColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "ManagerRoleHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForManagerRole", sDataSheetName))

				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "AdminRoleHeader", sDataSheetName))
				.verifySortingonCheckboxColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "AdminRoleHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForAdminRole", sDataSheetName))

		;

	}
}
