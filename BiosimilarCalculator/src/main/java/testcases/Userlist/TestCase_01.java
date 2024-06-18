package testcases.Userlist;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

// TC_01: Check if user can able to see the "UserList" tab

public class TestCase_01 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().verifyHeaderPortion(
				DataInputProvider.getCellData_ColName(iRowNumber, "homeMenu", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "calculatorMenu", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "drugsDashboardMenu", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "averageSalesPriceMenu", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "userListMenu", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "welcomeText", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "userName", sDataSheetName))

		;
	}
}
