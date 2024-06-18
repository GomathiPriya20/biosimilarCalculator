package testcases.Calculator;

import java.awt.AWTException;

import pages.CalculatorPage;
import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_04 {

	// TC_04: IVIGCalculator_ Sorting

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickCalculatorMenu().clickIVIGCalculatorMenu();

		new CalculatorPage()

				.selectAdrug_CalculatorPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName_Ivig", sDataSheetName))

				.type_Units_CalulatorPage(DataInputProvider.getCellData_ColName(iRowNumber, "Units", sDataSheetName))

				// 1. TradeName
				.clickColumnHeaderForLockedColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName))
				.verifySortingForLockedColumn(
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTradeName", sDataSheetName))

				// 2. NDC
				.clickColumnHeaderForLockedColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "NDCHeader", sDataSheetName))
				.verifySortingForLockedColumn(
						DataInputProvider.getCellData_ColName(iRowNumber, "NDCHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForNDC", sDataSheetName))

				// 3. Form
				.clickColumnHeaderForLockedColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "FormHeader", sDataSheetName))
				.verifySortingForLockedColumn(
						DataInputProvider.getCellData_ColName(iRowNumber, "FormHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForForm", sDataSheetName))

				// 4. Package Size/Dose Per Vial
				.clickColumnHeaderForLockedColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageSizeHeader", sDataSheetName))
				.verifySortingForLockedColumn(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageSizeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForPackageSize", sDataSheetName))

				// 5. Package Quantity
				.clickColumnHeaderForLockedColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageQuantityHeader", sDataSheetName))
				.verifySortingForLockedColumn(
						DataInputProvider.getCellData_ColName(iRowNumber, "PackageQuantityHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForPackageQuantity", sDataSheetName))

				// 6. Generic Name
				.clickColumnHeaderForLockedColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericNameHeader", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "GenericNameHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForGenericName", sDataSheetName))

				//Newly added column - Last Updated Time
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "LastUpdatedTimeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForLastUpdatedTime", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "LastUpdatedTimeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForLastUpdatedTime", sDataSheetName))
				
				// 7. Contract Price
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPrice", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPrice", sDataSheetName))

				// 8. Contract Price Type
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceTypeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPriceType", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractPriceTypeHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPriceType", sDataSheetName))

				// 9. 340B Price
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForThe_340BPrice", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "The_340BPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForThe_340BPrice", sDataSheetName))

				// 10. WAC Price
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForWACPrice", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "WACPriceHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForWACPrice", sDataSheetName))

				// 11. Contract Strength
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractStrengthHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractStrength", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "ContractStrengthHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractStrength", sDataSheetName))

				// 12. Total Units
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "TotalUnitsHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTotalUnits", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "TotalUnitsHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTotalUnits", sDataSheetName))

				// 14. Total Cost
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "TotalCostHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTotalCost", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "TotalCostHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTotalCost", sDataSheetName))

				// 15. ASP
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASP", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASP", sDataSheetName))

				// 16. ASP Strength
				.clickColumnHeaderForScrollableArea(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPStrengthHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASPStrength", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "ASPStrengthHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASPStrength", sDataSheetName))

				// 17. Reimbursement/Reimbursement 2% Sequestration included
				.clickColumnHeaderForScrollableArea2(
						DataInputProvider.getCellData_ColName(iRowNumber, "ReimbursementHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForReimbursementForSorting",
								sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "ReimbursementHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForReimbursement", sDataSheetName))

				// 18. Differential/Revenue or Loss (+/-)
				.clickColumnHeaderForScrollableArea2(
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDifferentialForSorting",
								sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDifferential", sDataSheetName))

				// 19. Differential Per Units/Revenue or Loss (+/-)	Per Units
				.clickColumnHeaderForScrollableArea2(
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialPerUnitsHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDifferentialPerUnitsForSorting",
								sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "DifferentialPerUnitsHeader", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDifferentialPerUnits",
								sDataSheetName))

		;

	}

}
