package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import pages.UserlistPage;
import utils.DataInputProvider;

// TC_11: Check that the UserList page  column  has drop downs with default value as "All" and contains "Is True" and "Is False"

public class TestCase_11 {

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

				.searchManagerRole_InUserListPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "ManagerRoleHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForManagerRole", sDataSheetName))
				.clearFilterResults()

				.searchAdminRole_InUserListPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "AdminRoleHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForAdminRole", sDataSheetName))

		;

	}
}
