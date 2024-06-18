package testcases.DrugDashboard;

import java.awt.AWTException;

import pages.GeneralDashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_09 {

	// TC_09:DrugDashboard_Sorting

	public static void calculator(int iRowNumber, String sDataSheetName)
			throws Exception, InterruptedException, AWTException {

		new LoginPage().loginToApplication(DataInputProvider.getCellData_ColName(iRowNumber, "EmailId", sDataSheetName),
				DataInputProvider.getCellData_ColName(iRowNumber, "Password", sDataSheetName));

		new GeneralDashboardPage().clickDrugsDashboardMenu()

				.search_FieldName_InDrugDashboardPage(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForTradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "TradeName", sDataSheetName))

				// 1. NDC
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForNDC", sDataSheetName))
				.verifySortingForLockedColumn(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForNDC", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForNDC", sDataSheetName))

				// 2. TradeName
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForTradeName", sDataSheetName))
				.verifySortingForLockedColumn(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForTradeName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForTradeName", sDataSheetName))

				// 3. Healthcare type
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForHealthCareType", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForHealthCareType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForHealthcareType", sDataSheetName))

				// 4. Calculator Type
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCalculatorType", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCalculatorType", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForCalculatorType", sDataSheetName))

				// 5. Group
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForGroup", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForGroup", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForGroup", sDataSheetName))

				// 6. Is Originator
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForIsOriginator", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForIsOriginator", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForIsOriginator", sDataSheetName))

				// 7. Supplier
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForSupplier", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForSupplier", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForSupplier", sDataSheetName))

				// 8. Generic Name
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForGenericName", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForGenericName", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForGenericName", sDataSheetName))

				// 9. Contract Number
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractNumber", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractNumber", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractNumber", sDataSheetName))

				// 10. Contract Price
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractPrice", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPrice", sDataSheetName))

				// 11. Contract Price Type
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractPriceType",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForContractPriceType",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForContractPriceType", sDataSheetName))

				// 12. 340B Price
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameFor340BPrice", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameFor340BPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumFor340BPrice", sDataSheetName))

				// 13. WAC Price
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForWACPrice", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForWACPrice", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForWACPrice", sDataSheetName))

				// 14. Drug Dosage Form
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugDosageForm", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugDosageForm", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDrugDosageForm", sDataSheetName))

				// 15. Drug Strength Number
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugStrengthNumber",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugStrengthNumber",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDrugStrengthNumber",
								sDataSheetName))

				// 16. Drug Strength Units
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugStrengthUnits",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugStrengthUnits",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDrugStrengthUnits", sDataSheetName))

				// 17. Drug Strength Volume
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugStrengthVolume",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugStrengthVolume",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDrugStrengthVolume",
								sDataSheetName))

				// 18. Drug Form Code
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugFormCode", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugFormCode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDrugFormCode", sDataSheetName))

				// 19. Adjusted Drug Package Size
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber,
						"colNameForAdjustedDrugPackageSize", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForAdjustedDrugPackageSize",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForAdjustedDrugPackageSize",
								sDataSheetName))

				// 20. Drug Package Quantity
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugPackageQuantity",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForDrugPackageQuantity",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForDrugPackageQuantity",
								sDataSheetName))

				// 21. ASP
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASP", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASP", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASP", sDataSheetName))

				// 22. ASP Adjustment
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASPAdjustment", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASPAdjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASPAdjustment", sDataSheetName))

				// 23. ASP Drug Strength Units
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASPDrugStrengthUnits",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASPDrugStrengthUnits",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASPDrugStrengthUnits",
								sDataSheetName))

				// 24. ASP Drug Strength Number
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASPDrugStrengthNumber",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForASPDrugStrengthNumber",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForASPDrugStrengthNumber",
								sDataSheetName))

				// 25. Facility 340B Price Adjustment
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber,
						"colNameForFacility340BPriceAdjustment", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForFacility340BPriceAdjustment",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForFacility340BPriceAdjustment",
								sDataSheetName))

				// 26. Biosimilar Use Facility 340B Price Adjustment
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber,
						"colNameForBiosimilarUseFacility340BPriceAdjustment", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber,
								"colNameForBiosimilarUseFacility340BPriceAdjustment", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber,
								"colNumForBiosimilarUseFacility340BPriceAdjustment", sDataSheetName))

				// 27. Sequestration Reduction
				.clickColumnHeader(DataInputProvider.getCellData_ColName(iRowNumber, "colNameForSequestrationReduction",
						sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForSequestrationReduction",
								sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForSequestrationReduction",
								sDataSheetName))

				// 28. HCPCS code
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForHCPCScode", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForHCPCScode", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForHCPCScode", sDataSheetName))

				// 29. Created On
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCreatedOn", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCreatedOn", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForCreatedOn", sDataSheetName))

				// 30. Created By
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCreatedBy", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForCreatedBy", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForCreatedBy", sDataSheetName))

				// 31. Updated On
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForUpdatedOn", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForUpdatedOn", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUpdatedOn", sDataSheetName))

				// 32. Updated By
				.clickColumnHeader(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForUpdatedBy", sDataSheetName))
				.verifySortingAlongWithNullValueCheckforOtherColumns(
						DataInputProvider.getCellData_ColName(iRowNumber, "colNameForUpdatedBy", sDataSheetName),
						DataInputProvider.getCellData_ColName(iRowNumber, "colNumForUpdatedBy", sDataSheetName))

		;

	}

}
