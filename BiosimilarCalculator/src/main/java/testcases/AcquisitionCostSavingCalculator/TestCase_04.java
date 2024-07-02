package testcases.AcquisitionCostSavingCalculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_04 {

	// TC_04: Check that the sorting option is working in the columns of the "Switch
	// from Originator to Biosimilar and Save $$$" table.

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickBiosimilarCalculatorMenu();

		new CalculatorPage()

				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				// 1. TradeName
				.clickColumnHeaderForLockedColumnsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTradeName", sDataSheetName))

				// 2. Strength
				.clickColumnHeaderForLockedColumnsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "StrengthHeader", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "StrengthHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForStrength", sDataSheetName))

				// 3. Adjusted Package Size/Dose per vial
				.clickColumnHeaderForLockedColumnsInTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "AdjustedPackageSizeHeader", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "AdjustedPackageSizeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForAdjustedPackageSize",
								sDataSheetName))

	/*			// 4. Contract Price --> Saving per Unit ($$)
				.clickColumnHeaderInTable2FirstSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"contractPriceSavingperUnit($$)Header", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "contractPriceSavingperUnit($$)Header",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPriceSavingsPerUnit$$",
								sDataSheetName))

				// 5. Contract Price --> Saving per Unit (%)
				.clickColumnHeaderInTable2FirstSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"contractPriceSavingperUnit(%)Header", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "contractPriceSavingperUnit(%)Header",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPriceSavingsPerUnit%",
								sDataSheetName))

				// 6. Contract Price --> Total Saving
				.clickColumnHeaderInTable2FirstSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"contractPriceTotalSavingHeader", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "contractPriceTotalSavingHeader",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPriceTotalSavings",
								sDataSheetName))

				// 7. WAC Price --> Saving per Unit ($$)
				.clickColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"WACPriceSavingperUnit($$)Header", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceSavingperUnit($$)Header",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForWACPriceSavingsPerUnit$$",
								sDataSheetName))

				// 8. WAC Price --> Saving per Unit (%)
				.clickColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"WACPriceSavingperUnit(%)Header", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceSavingperUnit(%)Header",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForWACPriceSavingsPerUnit%",
								sDataSheetName))

				// 9. WAC Price --> Total Saving
				.clickColumnHeaderInTable2SecondSet(
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceTotalSavingHeader", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceTotalSavingHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForWACPriceTotalSavings",
								sDataSheetName))

				// 10. Max Savings $$$ --> Contract Price
				.clickColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"MaxSavings$$$ContractPriceHeader", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "MaxSavings$$$ContractPriceHeader",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForMaxSavings$$$ContractPrice",
								sDataSheetName))

				// 11. Max Savings $$$ --> WAC Price
				.clickColumnHeaderInTable2SecondSet(DataInputProvider.getCellData_ColName(iRowNumber,
						"MaxSavings$$$WACPriceHeader", sDataSheetName))
				.verifySortingForAllColumninTable2(
						DataInputProvider.getCellData_ColName(iRowNumber, "MaxSavings$$$WACPriceHeader",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForMaxSavings$$$WACPrice",
								sDataSheetName))
*/
		;

	}

}
