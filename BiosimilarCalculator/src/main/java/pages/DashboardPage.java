package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class DashboardPage extends WebDriverServiceImpl {

	public DashboardPage verifyFieldsInDrugsDashboardPage(String calculatorHeader, String selectaDrugHeader)
			throws InterruptedException {
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//div[@id='main']//h2[contains(text(),'Biosimilar Contract Advantage Calculator')]")),
				calculatorHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//div[@id='main']//h4[contains(text(),'Select a drug')]")),
				selectaDrugHeader);
		return this;
	}

	public DashboardPage verifyAddNewButtonInDrugsDashboardPage() throws InterruptedException {
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Add new')]")), "Add New Button");
		return this;
	}

	public DashboardPage verifyExportToExcelButtonInDrugsDashboardPage() throws InterruptedException {
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Export to Excel')]")),
				"Export To Excel Button");
		return this;
	}

	public DashboardPage verifyEditButtonInDrugsDashboardPage() throws InterruptedException {
		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(text(),'Edit')])[1]")), "Edit Button");
		return this;
	}

	public DashboardPage verifyRemoveButtonInDrugsDashboardPage() throws InterruptedException {
		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(text(),'Remove')])[1]")), "Remove Button");
		return this;
	}

	public DashboardPage clickRemoveButtonInDrugsDashboardPage() throws InterruptedException {
		click(getDriver().findElement(By.xpath("(//span[contains(text(),'Remove')])[1]")), "Remove Button");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")), "Remove Button");
		Thread.sleep(3000);
		return this;
	}

	public DashboardPage clickExportToExcelButtonInDrugsDashboardPage(String downloadPath, String downloadFile)
			throws InterruptedException {
		Thread.sleep(1000);
		click((getDriver().findElement(By.xpath("//span[contains(text(),'Export to Excel')]"))),
				"Export To Excel Button");
		Thread.sleep(2000);
		isFileDownloaded(downloadPath, downloadFile);
		return this;
	}

	// Verify CreatedOn column is present
	public DashboardPage verifyCreatedOnColumn() throws InterruptedException {
		WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'Created On')]"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Created On')]")), "CreatedOn column");
		return this;
	}

	// Verify CreatedBy column is present
	public DashboardPage verifyCreatedByColumn() throws InterruptedException {
		WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'Created By')]"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Created By')]")), "CreatedBy column");
		return this;
	}

	// Click CreatedOn column
	public DashboardPage clickCreatedOnColumn() throws InterruptedException {
		Thread.sleep(1000);
		click((getDriver().findElement(By.xpath("//span[contains(text(),'Created On')]"))), "CreatedOn column");
		return this;
	}

	public DashboardPage select_NDCfromFilterMenu(String NDC) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//a[@title='NDC Filter Menu']//kendo-svgicon")));
		Thread.sleep(3000);

		WebElement element = getDriver().findElement(By.xpath("//a[@title='NDC Filter Menu']//kendo-svgicon"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);

		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//input[@kendotextbox])[1]")), NDC, "NDC");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//button[@type='submit']")),
				"Filter button on Filter Icon for the NDC field");
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='1']")).getText(), NDC,
				"NDC");
		return this;
	}
	
	public DashboardPage update_CreatedOnToExcel(String SheetName) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='29']")));
		Thread.sleep(3000);

		String CreatedOn = getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='29']"))
				.getAttribute("textContent");
		System.out.println("CreatedOn"+CreatedOn);
		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(CreatedOn, Driver.iTestCaseRowNum, "CreatedOn",
					Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS, "SheetName field  " + CreatedOn + " is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}
	
	public DashboardPage update_UpdatedOnToExcel(String SheetName) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='31']")));
		Thread.sleep(3000);

		String UpdatedOn = getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='31']"))
				.getAttribute("textContent");
		System.out.println("UpdatedOn"+UpdatedOn);
		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(UpdatedOn, Driver.iTestCaseRowNum, "UpdatedOn",
					Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS, "SheetName field  " + UpdatedOn + " is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}

	public DashboardPage verifyColumnHeadersInDrugsDashboardPage() throws InterruptedException {
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'command')]")), "command");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'NDC')]")), "NDC");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'TradeName')]")), "Trade Name");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'HealthCare Type')]")),
				"HealthCare Type");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Calculator Type')]")),
				"Calculator Type");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Group')]")), "Group");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Is Originator')]")), "Is Originator");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Supplier')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Supplier')]")), "Supplier");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Generic Name')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Generic Name')]")), "Generic Name");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Contract Number')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Contract Number')]")),
				"Contract Number");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//span[contains(text(),'Contract Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(text(),'Contract Price')])[1]")),
				"Contract Price");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Contract Price Type')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Contract Price Type')]")),
				"Contract Price Type");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//span[contains(text(),'340B Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(text(),'340B Price')])[1]")), "340B Price");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'WAC Price')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'WAC Price')]")), "WAC Price");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Drug Dosage Form')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Drug Dosage Form')]")),
				"Drug Dosage Form");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//span[contains(text(),'Drug Strength Number')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(text(),'Drug Strength Number')])[1]")),
				"Drug Strength Number");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//span[contains(text(),'Drug Strength Units')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(text(),'Drug Strength Units')])[1]")),
				"Drug Strength Units");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Drug Strength Volume')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Drug Strength Volume')]")),
				"Drug Strength Volume");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Drug Form Code')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Drug Form Code')]")),
				"Drug Form Code");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Dose Per Vial')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Dose Per Vial')]")),
				"Dose Per Vial");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Drug Package Quantity')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Drug Package Quantity')]")),
				"Drug Package Quantity'");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//span[contains(text(),'ASP')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("(//span[contains(text(),'ASP')])[1]")), "ASP");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'ASP Adjustment')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'ASP Adjustment')]")),
				"ASP Adjustment");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'ASP Drug Strength Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'ASP Drug Strength Units')]")),
				"ASP Drug Strength Units");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'ASP Drug Strength Number')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'ASP Drug Strength Number')]")),
				"ASP Drug Strength Number");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//span[contains(text(),'Facility 340B Price Adjustment')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(By.xpath("(//span[contains(text(),'Facility 340B Price Adjustment')])[1]")),
				"Facility 340B Price Adjustment");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//span[contains(text(),'Biosimilar Use Facility 340B Price Adjustment')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//span[contains(text(),'Biosimilar Use Facility 340B Price Adjustment')]")),
				"Biosimilar Use Facility 340B Price Adjustment");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Sequestration Reduction')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Sequestration Reduction')]")),
				"Sequestration Reduction");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'HCPCS code')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'HCPCS code')]")), "HCPCS code");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Created On')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Created On')]")), "Created On");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Created By')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Created By')]")), "Created By");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Updated On')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Updated On')]")), "Updated On");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Updated By')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Updated By')]")), "Updated By");

		return this;
	}

	public DashboardPage addDrugForCalculation_Biosimilar_DrugsDashboardPage(String NDC, String TradeName,
			String CalculatorTypeIntCode, String GroupNameIntCode, String IsOriginator, String Supplier,
			String GenericName, String ContractPrice, String The_340BPrice, String WACPrice,
			String Drug_Dosage_Form_Description, String Drug_Strength_Number, String DrugStrengthUnitIntCode,
			String DrugStrengthVolume, String Drug_Form_Code, String Adjusted_PackageSize, String Drug_Package_Quantity,
			String ASP, String ASP_Adjustment, String AspDrugStrengthUnitsIntCode, String ASP_Drug_Strength_Number,
			String Facility340BPriceAdjustment, String BiosimilarUseFacility340BPriceAdjustment,
			String SequestrationReduction, String HCPCScode) throws InterruptedException {
		// String ContractPriceTypeIntCode,
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Add new')]")), "Add New Button");
		Thread.sleep(5000);

		// NDC
		getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).clear();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).sendKeys(NDC);
		// type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")),
		// NDC, "NDC");
		Thread.sleep(2000);

		// TradeName
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[2]")), TradeName, "Trade Name");
		Thread.sleep(2000);

		// Calculator Type
		// select from dropdown
		getDriver().findElement(By.xpath("//kendo-dropdownlist[@textfield='CalculatorTypeDesc']/span/span")).click();// click

		int calType = Integer.parseInt(CalculatorTypeIntCode);
		for (int i = 0; i <= calType; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// GroupName
		// select from dropdown
		getDriver().findElement(By.xpath("//kendo-dropdownlist[@textfield='Name']/span/span")).click();// click on that
																										// // combo

		int groupName = Integer.parseInt(GroupNameIntCode);
		for (int i = 0; i <= groupName; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// IsOriginator - false - hence don't click
		if (IsOriginator.equalsIgnoreCase("Yes")) {
			click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[3]")), "Is Originator");
			Thread.sleep(2000);
		}

		// Supplier Name
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")));
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")), Supplier, "Supplier Name");
		Thread.sleep(3000);

		// GenericName
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[5]")), GenericName, "Generic Name");
		Thread.sleep(2000);

		// ContractPrice
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")), ContractPrice, "Contract Price");
		Thread.sleep(2000);

		// 340B Price
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")), The_340BPrice, "340B Price");
		Thread.sleep(2000);

		// WACPrice
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")), WACPrice, "WAC Price");
		Thread.sleep(2000);

		// Drug_Dosage_Form_Description
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")), Drug_Dosage_Form_Description,
				"Drug Dosage Form Description");
		Thread.sleep(2000);

		// Drug_Strength_Number
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")), Drug_Strength_Number,
				"Drug Strength Number");
		Thread.sleep(2000);

		// Drug_Strength_Units
		// dropdown
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")));
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")).click();

		int drugStrengthUnit = Integer.parseInt(DrugStrengthUnitIntCode);
		for (int i = 0; i <= drugStrengthUnit; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// Drug_Strength_Volume
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")), DrugStrengthVolume,
				"Drug Strength Volume");
		Thread.sleep(2000);

		// Drug_Form_Code
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")), Drug_Form_Code, "Drug Form Code");
		Thread.sleep(2000);

		// Drug_Package_Size/Adjusted PackageSize/Dose Per Vial
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")), Adjusted_PackageSize,
				"Dose Per Vial");
		Thread.sleep(2000);

		// Drug_Package_Quantity
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")), Drug_Package_Quantity,
				"Drug Package Quantity");
		Thread.sleep(2000);

		// ASP
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")), ASP, "ASP");
		Thread.sleep(2000);

		// ASP_Adjustment
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")), ASP_Adjustment, "ASP Adjustment");
		Thread.sleep(2000);

		// ASP_Drug_Strength_Units
		// dropdown
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")));
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")).click();

		int aspDrugStrengthUnits = Integer.parseInt(AspDrugStrengthUnitsIntCode);
		for (int i = 0; i <= aspDrugStrengthUnits; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// ASP_Drug_Strength_Number
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")), ASP_Drug_Strength_Number,
				"ASP Drug Strength Number");
		Thread.sleep(2000);

		// Facility340BPriceAdjustment
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")), Facility340BPriceAdjustment,
				"Facility 340B Price Adjustment");
		Thread.sleep(2000);

		// BiosimilarUseFacility340BPriceAdjustment - false - hence don't click
		if (BiosimilarUseFacility340BPriceAdjustment.equalsIgnoreCase("TRUE")) {
			click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[20]")),
					"Biosimilar UseFacility 340B PriceAdjustment");
			Thread.sleep(2000);
		}

		// SequestrationReduction
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")), SequestrationReduction,
				"Sequestration Reduction");
		Thread.sleep(2000);

		// HCPCScode
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")), HCPCScode, "HCPCS code");
		Thread.sleep(2000);

		click(getDriver().findElement(By.xpath("//button[@kendogridsavecommand]/span[contains(text(),'Add')]")),
				"Add button");
		Thread.sleep(5000);

		setReport().log(Status.PASS, "Added a drug detail successfully", screenshotCapture());

		return this;
	}

	public DashboardPage addDrugDetailWithallFieldValues_Biosimilar_DrugsDashboardPage(String NDC, String TradeName,
			String CalculatorTypeIntCode, String GroupNameIntCode, String IsOriginator, String Supplier,
			String GenericName, String ContractNumber, String ContractPrice, String ContractPriceTypeIntCode,
			String The_340BPrice, String WACPrice, String Drug_Dosage_Form_Description, String Drug_Strength_Number,
			String DrugStrengthUnitIntCode, String DrugStrengthVolume, String Drug_Form_Code,
			String Adjusted_PackageSize, String Drug_Package_Quantity, String ASP, String ASP_Adjustment,
			String AspDrugStrengthUnitsIntCode, String ASP_Drug_Strength_Number, String Facility340BPriceAdjustment,
			String BiosimilarUseFacility340BPriceAdjustment, String SequestrationReduction, String HCPCScode,
			String testUser) throws InterruptedException {
		// String ContractPriceTypeIntCode,
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Add new')]")), "Add New Button");
		Thread.sleep(5000);

		// NDC
		getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).clear();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).sendKeys(NDC);
		Thread.sleep(2000);

		// TradeName
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[2]")), TradeName, "Trade Name");
		Thread.sleep(2000);

		// Calculator Type
		// select from dropdown
		getDriver().findElement(By.xpath("//kendo-dropdownlist[@textfield='CalculatorTypeDesc']/span/span")).click();// click

		int calType = Integer.parseInt(CalculatorTypeIntCode);
		for (int i = 0; i <= calType; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// GroupName
		// select from dropdown
		getDriver().findElement(By.xpath("//kendo-dropdownlist[@textfield='Name']/span/span")).click();// click on that
																										// // combo

		int groupName = Integer.parseInt(GroupNameIntCode);
		for (int i = 0; i <= groupName; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// IsOriginator - false - hence don't click
		if (IsOriginator.equalsIgnoreCase("Yes")) {
			click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[3]")), "Is Originator");
			Thread.sleep(2000);
		}

		// Supplier
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")));
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")), Supplier, "Supplier Name");
		Thread.sleep(3000);

		// GenericName
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[5]")), GenericName, "Generic Name");
		Thread.sleep(2000);

		// ContractNumber
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[6]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[6]")), ContractNumber, "Contract Number");
		Thread.sleep(2000);

		// ContractPrice
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")), ContractPrice, "Contract Price");
		Thread.sleep(2000);

		// ContractPriceType
		// select from dropdown
		getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text']/span/span)[1]")).click();// click on
																											// that
		int contractPriceType = Integer.parseInt(ContractPriceTypeIntCode);
		for (int i = 0; i <= contractPriceType; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// 340B Price
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")), The_340BPrice, "340B Price");
		Thread.sleep(2000);

		// WACPrice
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")), WACPrice, "WAC Price");
		Thread.sleep(2000);

		// Drug_Dosage_Form_Description
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")), Drug_Dosage_Form_Description,
				"Drug Dosage Form Description");
		Thread.sleep(2000);

		// Drug_Strength_Number
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")), Drug_Strength_Number,
				"Drug Strength Number");
		Thread.sleep(2000);

		// Drug_Strength_Units
		// dropdown
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")));
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")).click();

		int drugStrengthUnit = Integer.parseInt(DrugStrengthUnitIntCode);
		for (int i = 0; i <= drugStrengthUnit; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// Drug_Strength_Volume
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")), DrugStrengthVolume,
				"Drug Strength Volume");
		Thread.sleep(2000);

		// Drug_Form_Code
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")), Drug_Form_Code, "Drug Form Code");
		Thread.sleep(2000);

		// Drug_Package_Size/Adjusted PackageSize/Dose Per Vial
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")), Adjusted_PackageSize,
				"Dose Per Vial");
		Thread.sleep(2000);

		// Drug_Package_Quantity
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")), Drug_Package_Quantity,
				"Drug Package Quantity");
		Thread.sleep(2000);

		// ASP
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")), ASP, "ASP");
		Thread.sleep(2000);

		// ASP_Adjustment
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")), ASP_Adjustment, "ASP Adjustment");
		Thread.sleep(2000);

		// ASP_Drug_Strength_Units
		// dropdown
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")));
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")).click();

		int aspDrugStrengthUnits = Integer.parseInt(AspDrugStrengthUnitsIntCode);
		for (int i = 0; i <= aspDrugStrengthUnits; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// ASP_Drug_Strength_Number
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")), ASP_Drug_Strength_Number,
				"ASP Drug Strength Number");
		Thread.sleep(2000);

		// Facility340BPriceAdjustment
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")), Facility340BPriceAdjustment,
				"Facility 340B Price Adjustment");
		Thread.sleep(2000);

		// BiosimilarUseFacility340BPriceAdjustment - false - hence don't click
		if (BiosimilarUseFacility340BPriceAdjustment.equalsIgnoreCase("TRUE")) {
			click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[20]")),
					"Biosimilar UseFacility 340B PriceAdjustment");
			Thread.sleep(2000);
		}

		// SequestrationReduction
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")), SequestrationReduction,
				"Sequestration Reduction");
		Thread.sleep(2000);

		// HCPCScode
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")), HCPCScode, "HCPCS code");
		Thread.sleep(2000);

		click(getDriver().findElement(By.xpath("//button[@kendogridsavecommand]/span[contains(text(),'Add')]")),
				"Add button");
		Thread.sleep(5000);

		setReport().log(Status.PASS, "Added a drug detail successfully", screenshotCapture());

		verifyCreatedOnColumn();
		clickCreatedOnColumn();
		Thread.sleep(2000);
		clickCreatedOnColumn();

		verifyCreatedByColumn();

		// verify value in createdBy column before editing
		String createdBy = getDriver().findElement(By.xpath("//*['kendogridtablebody']//tbody/tr[1]/td[28]")).getText();
		try {
			if (createdBy.contains(testUser)) {
				setReport().log(Status.PASS, "Created By column contains " + testUser, screenshotCapture());

			} else {
				setReport().log(Status.FAIL, "Created By column doesn't contains " + testUser, screenshotCapture());
				Driver.failCount++;
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying Created By column ",
					screenshotCapture());
			Driver.failCount++;
			throw e;
		}

		return this;
	}

	public DashboardPage search_FieldName_InDrugDashboardPage(String filterMenu, String fieldValue)
			throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = getDriver().findElement(By.xpath("//a[@title='" + filterMenu + " Filter Menu']"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		clickwithFieldName(getDriver().findElement(By.xpath("//a[@title='" + filterMenu + " Filter Menu']")), "Filter");
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//input[@aria-label='" + filterMenu + " Filter']")).sendKeys(Keys.CLEAR);
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("//input[@aria-label='" + filterMenu + " Filter']")), fieldValue,
				"Field Value");
		Thread.sleep(3000);
		clickwithFieldName(getDriver().findElement(By.xpath("//button[@type='submit']")), "Submit button");
		Thread.sleep(3000);
		// verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='1']"))
		// .getAttribute("textContent"), fieldValue, "Field Value");
		return this;
	}

	public DashboardPage clearFilterResults(String filterMenu) throws InterruptedException {
		WebElement element = getDriver().findElement(By.xpath("//a[@title='" + filterMenu + " Filter Menu']"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		clickwithFieldName(getDriver().findElement(By.xpath("//a[@title='" + filterMenu + " Filter Menu']")), "Filter");
		Thread.sleep(3000);
		clickwithFieldName(getDriver().findElement(By.xpath("//button[@type='reset']")), "Reset button");
		Thread.sleep(3000);
		return this;
	}

	// Verify col wise values in the table after applying filter
	public DashboardPage verifyColwiseFilterResults(String col, String filterResult) throws InterruptedException {
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//td[@data-kendo-grid-column-index='1']")),
				"Table");
		for (int i = 1; i <= rowCount; i++) {
			WebElement element = getDriver()
					.findElement(By.xpath("(//td[@data-kendo-grid-column-index='" + col + "'])[" + (i) + "]"));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(1000);
			verifyExactText(
					(getDriver()
							.findElement(By.xpath("(//td[@data-kendo-grid-column-index='" + col + "'])[" + (i) + "]"))),
					filterResult, " row num : " + i);
		}
		return this;
	}

	// Clicks on Column header based on the user input
	public DashboardPage clickColumnHeader(String colName) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("//th//span[contains(text(),'" + colName + "')]")));

		click(getDriver().findElement(By.xpath("//th//span[contains(text(),'" + colName + "')]")), colName);
		Thread.sleep(5000);
		return this;
	}

	// Verify Sorting
	public DashboardPage verifySortingAlongWithNullValueCheckforOtherColumns(String Col, String ColNum)
			throws InterruptedException {
		ArrayList<String> obtainedList = new ArrayList<>();
		String bReturn = null;
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("(//tbody)[2]//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {
			bReturn = getDriver().findElement(By.xpath("(//tbody)[2]//tr[" + (i) + "]/td[" + ColNum + "]")).getText();
			setReport().log(Status.PASS, bReturn + " is displayed in Row Num : " + (i), screenshotCapture());
			obtainedList.add(bReturn);

		}
		ArrayList<String> sortedList = new ArrayList<>();
		int listSize = obtainedList.size();
		for (int j = 1; j <= listSize; j++) {
			sortedList.add(obtainedList.get(j - 1));
		}

		for (int i = 1; i < rowCount; i++) {
			compareValuesIncludingNull(obtainedList.get(i), sortedList.get(i));
		}

		Assert.assertTrue(sortedList.equals(obtainedList));
		setReport().log(Status.PASS, Col + " column is in Sorted order", screenshotCapture());
		Thread.sleep(5000);
		return this;
	}

	// Function to bring null values at top during ascending sort
	public int compareValuesIncludingNull(String Val1, String Val2) {
		try {

			if (Val1 == null) {

				return (Val1 == null ? 0 : -1);
			}
			if (Val2 == null) {
				return (Val2 == null ? 0 : -1);
			}
			return Val2.compareTo(Val1);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	// Verify Sorting
		public DashboardPage verifySortingForLockedColumn(String Col, String ColNum)
				throws InterruptedException {
			ArrayList<String> obtainedList = new ArrayList<>();
			String bReturn = null;
			int rowCount = getTableRowCount(
					getDriver().findElements(By.xpath("//kendo-grid-list//div[@class='k-grid-content-locked']//tr")),
					"Table");
			for (int i = 1; i <= rowCount; i++) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
						getDriver().findElement(By.xpath("//kendo-grid-list//div[@class='k-grid-content-locked']//tr[" + (i)
								+ "]/td[" + ColNum + "]")));
				Thread.sleep(3000);
				bReturn = getDriver().findElement(By.xpath(
						"//kendo-grid-list//div[@class='k-grid-content-locked']//tr[" + (i) + "]/td[" + ColNum + "]"))
						.getText();
				setReport().log(Status.PASS, bReturn + " is displayed in Row Num : " + (i), screenshotCapture());
				obtainedList.add(bReturn);

			}
			ArrayList<String> sortedList = new ArrayList<>();
			int listSize = obtainedList.size();
			for (int j = 1; j <= listSize; j++) {
				sortedList.add(obtainedList.get(j - 1));
			}

			for (int i = 1; i < rowCount; i++) {
				// compare(obtainedList.get(i), sortedList.get(i));
				compareValuesIncludingNull(obtainedList.get(i), sortedList.get(i));
			}

			Assert.assertTrue(sortedList.equals(obtainedList));
			setReport().log(Status.PASS, Col + " column is in Sorted order", screenshotCapture());
			Thread.sleep(5000);
			return this;
		}
		
		public DashboardPage addDrugForCalculation_IVIG_DrugsDashboardPage(String NDC, String TradeName,
				String CalculatorTypeIntCode, String IsOriginator, String Supplier,
				String GenericName, String ContractPrice, String The_340BPrice, String WACPrice,
				String Drug_Dosage_Form_Description, String Drug_Strength_Number, String DrugStrengthUnitIntCode,
				String DrugStrengthVolume, String Drug_Form_Code, String Adjusted_PackageSize, String Drug_Package_Quantity,
				String ASP, String ASP_Adjustment, String AspDrugStrengthUnitsIntCode, String ASP_Drug_Strength_Number,
				String Facility340BPriceAdjustment, String BiosimilarUseFacility340BPriceAdjustment,
				String SequestrationReduction, String HCPCScode) throws InterruptedException {
		
			click(getDriver().findElement(By.xpath("//span[contains(text(),'Add new')]")), "Add New Button");
			Thread.sleep(5000);

			// NDC
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).click();
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).clear();
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).sendKeys(NDC);
			Thread.sleep(2000);

			// TradeName
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[2]")), TradeName, "Trade Name");
			Thread.sleep(2000);

			// Calculator Type
			// select from dropdown
			getDriver().findElement(By.xpath("//kendo-dropdownlist[@textfield='CalculatorTypeDesc']/span/span")).click();// click

			int calType = Integer.parseInt(CalculatorTypeIntCode);
			for (int i = 0; i <= calType; i++) {
				Actions action1 = new Actions(getDriver());
				action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			}
			Thread.sleep(10000);

			// IsOriginator - false - hence don't click
			if (IsOriginator.equalsIgnoreCase("Yes")) {
				click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[3]")), "Is Originator");
				Thread.sleep(2000);
			}

			// Supplier Name
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")));
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")), Supplier, "Supplier Name");
			Thread.sleep(3000);

			// GenericName
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[5]")), GenericName, "Generic Name");
			Thread.sleep(2000);

			// ContractPrice
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")), ContractPrice, "Contract Price");
			Thread.sleep(2000);

			// 340B Price
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")), The_340BPrice, "340B Price");
			Thread.sleep(2000);

			// WACPrice
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")), WACPrice, "WAC Price");
			Thread.sleep(2000);

			// Drug_Dosage_Form_Description
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")), Drug_Dosage_Form_Description,
					"Drug Dosage Form Description");
			Thread.sleep(2000);

			// Drug_Strength_Number
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")), Drug_Strength_Number,
					"Drug Strength Number");
			Thread.sleep(2000);

			// Drug_Strength_Units
			// dropdown
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")).click();

			int drugStrengthUnit = Integer.parseInt(DrugStrengthUnitIntCode);
			for (int i = 0; i <= drugStrengthUnit; i++) {
				Actions action1 = new Actions(getDriver());
				action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			}
			Thread.sleep(10000);

			// Drug_Strength_Volume
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")), DrugStrengthVolume,
					"Drug Strength Volume");
			Thread.sleep(2000);

			// Drug_Form_Code
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")), Drug_Form_Code, "Drug Form Code");
			Thread.sleep(2000);

			// Drug_Package_Size/Adjusted PackageSize/Dose Per Vial
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")), Adjusted_PackageSize,
					"Dose Per Vial");
			Thread.sleep(2000);

			// Drug_Package_Quantity
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")), Drug_Package_Quantity,
					"Drug Package Quantity");
			Thread.sleep(2000);

			// ASP
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")), ASP, "ASP");
			Thread.sleep(2000);

			// ASP_Adjustment
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")), ASP_Adjustment, "ASP Adjustment");
			Thread.sleep(2000);

			// ASP_Drug_Strength_Units
			// dropdown
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")).click();

			int aspDrugStrengthUnits = Integer.parseInt(AspDrugStrengthUnitsIntCode);
			for (int i = 0; i <= aspDrugStrengthUnits; i++) {
				Actions action1 = new Actions(getDriver());
				action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			}
			Thread.sleep(10000);

			// ASP_Drug_Strength_Number
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")), ASP_Drug_Strength_Number,
					"ASP Drug Strength Number");
			Thread.sleep(2000);

			// Facility340BPriceAdjustment
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")), Facility340BPriceAdjustment,
					"Facility 340B Price Adjustment");
			Thread.sleep(2000);

			// BiosimilarUseFacility340BPriceAdjustment - false - hence don't click
			if (BiosimilarUseFacility340BPriceAdjustment.equalsIgnoreCase("TRUE")) {
				click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[20]")),
						"Biosimilar UseFacility 340B PriceAdjustment");
				Thread.sleep(2000);
			}

			// SequestrationReduction
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")), SequestrationReduction,
					"Sequestration Reduction");
			Thread.sleep(2000);

			// HCPCScode
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")), HCPCScode, "HCPCS code");
			Thread.sleep(2000);

			click(getDriver().findElement(By.xpath("//button[@kendogridsavecommand]/span[contains(text(),'Add')]")),
					"Add button");
			Thread.sleep(5000);

			setReport().log(Status.PASS, "Added a drug detail successfully", screenshotCapture());

			return this;
		}
		
		public DashboardPage addDrugDetailWithallFieldValues_IVIG_DrugsDashboardPage(String NDC, String TradeName,
				String CalculatorTypeIntCode, String IsOriginator, String Supplier,
				String GenericName, String ContractNumber, String ContractPrice, String ContractPriceTypeIntCode,
				String The_340BPrice, String WACPrice, String Drug_Dosage_Form_Description, String Drug_Strength_Number,
				String DrugStrengthUnitIntCode, String DrugStrengthVolume, String Drug_Form_Code,
				String Adjusted_PackageSize, String Drug_Package_Quantity, String ASP, String ASP_Adjustment,
				String AspDrugStrengthUnitsIntCode, String ASP_Drug_Strength_Number, String Facility340BPriceAdjustment,
				String BiosimilarUseFacility340BPriceAdjustment, String SequestrationReduction, String HCPCScode,
				String testUser) throws InterruptedException {
			// String ContractPriceTypeIntCode,
			click(getDriver().findElement(By.xpath("//span[contains(text(),'Add new')]")), "Add New Button");
			Thread.sleep(5000);

			// NDC
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).click();
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).clear();
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")).sendKeys(NDC);
			Thread.sleep(2000);

			// TradeName
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[2]")), TradeName, "Trade Name");
			Thread.sleep(2000);

			// Calculator Type
			// select from dropdown
			getDriver().findElement(By.xpath("//kendo-dropdownlist[@textfield='CalculatorTypeDesc']/span/span")).click();// click

			int calType = Integer.parseInt(CalculatorTypeIntCode);
			for (int i = 0; i <= calType; i++) {
				Actions action1 = new Actions(getDriver());
				action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			}
			Thread.sleep(10000);

			// IsOriginator - false - hence don't click
			if (IsOriginator.equalsIgnoreCase("Yes")) {
				click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[3]")), "Is Originator");
				Thread.sleep(2000);
			}

			// Supplier
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")));
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[4]")), Supplier, "Supplier Name");
			Thread.sleep(3000);

			// GenericName
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[5]")), GenericName, "Generic Name");
			Thread.sleep(2000);

			// ContractNumber
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[6]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[6]")), ContractNumber, "Contract Number");
			Thread.sleep(2000);

			// ContractPrice
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[7]")), ContractPrice, "Contract Price");
			Thread.sleep(2000);

			// ContractPriceType
			// select from dropdown
			getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text']/span/span)[1]")).click();// click on
																												// that
			int contractPriceType = Integer.parseInt(ContractPriceTypeIntCode);
			for (int i = 0; i <= contractPriceType; i++) {
				Actions action1 = new Actions(getDriver());
				action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			}
			Thread.sleep(10000);

			// 340B Price
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[8]")), The_340BPrice, "340B Price");
			Thread.sleep(2000);

			// WACPrice
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[9]")), WACPrice, "WAC Price");
			Thread.sleep(2000);

			// Drug_Dosage_Form_Description
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")), Drug_Dosage_Form_Description,
					"Drug Dosage Form Description");
			Thread.sleep(2000);

			// Drug_Strength_Number
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")), Drug_Strength_Number,
					"Drug Strength Number");
			Thread.sleep(2000);

			// Drug_Strength_Units
			// dropdown
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")).click();

			int drugStrengthUnit = Integer.parseInt(DrugStrengthUnitIntCode);
			for (int i = 0; i <= drugStrengthUnit; i++) {
				Actions action1 = new Actions(getDriver());
				action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			}
			Thread.sleep(10000);

			// Drug_Strength_Volume
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")), DrugStrengthVolume,
					"Drug Strength Volume");
			Thread.sleep(2000);

			// Drug_Form_Code
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")), Drug_Form_Code, "Drug Form Code");
			Thread.sleep(2000);

			// Drug_Package_Size/Adjusted PackageSize/Dose Per Vial
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")), Adjusted_PackageSize,
					"Dose Per Vial");
			Thread.sleep(2000);

			// Drug_Package_Quantity
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")), Drug_Package_Quantity,
					"Drug Package Quantity");
			Thread.sleep(2000);

			// ASP
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")), ASP, "ASP");
			Thread.sleep(2000);

			// ASP_Adjustment
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")), ASP_Adjustment, "ASP Adjustment");
			Thread.sleep(2000);

			// ASP_Drug_Strength_Units
			// dropdown
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[3]/span/span")).click();

			int aspDrugStrengthUnits = Integer.parseInt(AspDrugStrengthUnitsIntCode);
			for (int i = 0; i <= aspDrugStrengthUnits; i++) {
				Actions action1 = new Actions(getDriver());
				action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			}
			Thread.sleep(10000);

			// ASP_Drug_Strength_Number
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")), ASP_Drug_Strength_Number,
					"ASP Drug Strength Number");
			Thread.sleep(2000);

			// Facility340BPriceAdjustment
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")), Facility340BPriceAdjustment,
					"Facility 340B Price Adjustment");
			Thread.sleep(2000);

			// BiosimilarUseFacility340BPriceAdjustment - false - hence don't click
			if (BiosimilarUseFacility340BPriceAdjustment.equalsIgnoreCase("TRUE")) {
				click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[20]")),
						"Biosimilar UseFacility 340B PriceAdjustment");
				Thread.sleep(2000);
			}

			// SequestrationReduction
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")), SequestrationReduction,
					"Sequestration Reduction");
			Thread.sleep(2000);

			// HCPCScode
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")));
			Thread.sleep(3000);
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[22]")), HCPCScode, "HCPCS code");
			Thread.sleep(2000);

			click(getDriver().findElement(By.xpath("//button[@kendogridsavecommand]/span[contains(text(),'Add')]")),
					"Add button");
			Thread.sleep(5000);

			setReport().log(Status.PASS, "Added a drug detail successfully", screenshotCapture());

			verifyCreatedOnColumn();
			clickCreatedOnColumn();
			Thread.sleep(2000);
			clickCreatedOnColumn();

			verifyCreatedByColumn();

			// verify value in createdBy column before editing
			String createdBy = getDriver().findElement(By.xpath("//*['kendogridtablebody']//tbody/tr[1]/td[28]")).getText();
			try {
				if (createdBy.contains(testUser)) {
					setReport().log(Status.PASS, "Created By column contains " + testUser, screenshotCapture());

				} else {
					setReport().log(Status.FAIL, "Created By column doesn't contains " + testUser, screenshotCapture());
					Driver.failCount++;
				}
			} catch (WebDriverException e) {
				setReport().log(Status.FAIL, "Unknown exception occured while verifying Created By column ",
						screenshotCapture());
				Driver.failCount++;
				throw e;
			}

			return this;
		}
		
		public DashboardPage verifyDrugStrengthVolumnColumn() throws InterruptedException {
			WebElement element = getDriver().findElement(By.xpath("//span[contains(text(),'Drug Strength Volume')]"));
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Drug Strength Volume')]")),
					"Drug Strength Volume Header");
			Thread.sleep(3000);
			if (!getDriver().findElement(By.xpath("(//td[@data-kendo-grid-column-index='17'])[1]"))
					.getAttribute("outerText").isEmpty()) {
				setReport().log(Status.PASS, "Drug Strength Volumn column has value in it as expected ",
						screenshotCapture());
			}
			Thread.sleep(2000);
			return this;
		}
		
		public DashboardPage updateDrugDetailsForContractStrengthCalculation_DrugsDashboardPage(
				String Drug_Strength_Number, String DrugStrengthUnitIntCode, String DrugStrengthVolume,
				String Drug_Form_Code, String update) throws InterruptedException {

			click(getDriver().findElement(By.xpath("//span[contains(text(),'Edit')]")), "Edit Button");
			Thread.sleep(5000);

			// Drug_Dosage_Form_Description
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[10]")));
			Thread.sleep(3000);

			// Drug_Strength_Number
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")).clear();
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[11]")), Drug_Strength_Number,
					"Drug Strength Number");
			Thread.sleep(2000);

			// Drug_Strength_Units
			// dropdown
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//kendo-dropdownlist[@textfield='Text'])[2]/span/span")).click();

			int drugStrengthUnit = Integer.parseInt(DrugStrengthUnitIntCode);
			for (int i = 0; i < drugStrengthUnit; i++) {
				Actions action1 = new Actions(getDriver());
				if (update.equalsIgnoreCase("New value")) {

					action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
				} else {
					action1.sendKeys(Keys.UP).build().perform();// press up arrow key
				}
			}

			Thread.sleep(10000);

			// Drug_Strength_Volume
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")).clear();
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")), DrugStrengthVolume,
					"Drug Strength Volume");
			Thread.sleep(2000);

			// Drug_Form_Code
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")));
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")).clear();
			type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")), Drug_Form_Code,
					"Drug Form Code");
			Thread.sleep(2000);

			click(getDriver().findElement(By.xpath("//button[@kendogridsavecommand]/span[contains(text(),'Update')]")),
					"Update button");
			Thread.sleep(5000);

			setReport().log(Status.PASS, "Updated drug details successfully", screenshotCapture());

			return this;
		}



}
