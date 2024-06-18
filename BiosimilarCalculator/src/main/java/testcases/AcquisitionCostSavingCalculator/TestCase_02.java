package testcases.AcquisitionCostSavingCalculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TC_02: Check that the respective Columns are getting displayed in the "Switch from Originator to Biosimilar and Save $$$" table

public class TestCase_02 {

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();

		new CalculatorPage()

				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				.verifyIfSwitchFromOriginatorToBiosimilarTableIsAvailable()

				// 1. TradeName
				.verifyColumnHeaderForLockedColumnsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName))

				// 2. Strength
				.verifyColumnHeaderForLockedColumnsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "StrengthHeader", sDataSheetName))

				// 3. Adjusted Package Size
				.verifyColumnHeaderForLockedColumnsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "AdjustedPackageSizeHeader", sDataSheetName))

				// 4. Contract Price --> Saving per Unit ($$)
				.verifyColumnHeaderInTable2FirstSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"contractPriceSavingperUnit($$)Header", sDataSheetName))

				// 5. Contract Price --> Saving per Unit (%)
				.verifyColumnHeaderInTable2FirstSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"contractPriceSavingperUnit(%)Header", sDataSheetName))

				// 6. Contract Price --> Total Saving
				.verifyColumnHeaderInTable2FirstSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"contractPriceTotalSavingHeader", sDataSheetName))

				// 7. WAC Price --> Saving per Unit ($$)
				.verifyColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"WACPriceSavingperUnit($$)Header", sDataSheetName))

				// 8. WAC Price --> Saving per Unit (%)
				.verifyColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"WACPriceSavingperUnit(%)Header", sDataSheetName))

				// 9. WAC Price --> Total Saving
				.verifyColumnHeaderInTable2SecondSet(
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceTotalSavingHeader", sDataSheetName))

				// 10. Max Savings $$$ --> Contract Price
				.verifyColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"MaxSavings$$$ContractPriceHeader", sDataSheetName))

				// 11. Max Savings $$$ --> WAC Price
				.verifyColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"MaxSavings$$$WACPriceHeader", sDataSheetName))

		;

	}
}
