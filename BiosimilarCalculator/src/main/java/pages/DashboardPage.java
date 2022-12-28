package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import services.WebDriverServiceImpl;

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

	public DashboardPage verifyColumnHeadersInDrugsDashboardPage() throws InterruptedException {
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'command')]")), "command");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'NDC')]")), "NDC");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Trade Name')]")), "Trade Name");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'HealthCare Type')]")),
				"HealthCare Type");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Calculator Type')]")),
				"Calculator Type");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Group')]")), "Group");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Is Originator')]")), "Is Originator");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Supplier')]")), "Supplier");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Generic Name')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Generic Name')]")), "Generic Name");
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
				getDriver().findElement(By.xpath("//span[contains(text(),'Drug Form Code')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Drug Form Code')]")),
				"Drug Form Code");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//span[contains(text(),'Adjusted Drug Package Size')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Adjusted Drug Package Size')]")),
				"Adjusted Drug Package Size");

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

	public DashboardPage addDrugForCalculation_Biosimilar_DrugsDashboardPage(String GroupNameIntCode,
			String IsOriginator, String NDC, String TradeName, String GenericName, String ContractNumber,
			String ContractPrice, String The_340BPrice, String WACPrice, String Drug_Dosage_Form_Description,
			String Drug_Strength_Number, String DrugStrengthUnitIntCode, String Drug_Form_Code,
			String Adjusted_PackageSize, String Drug_Package_Quantity, String ASP, String ASP_Adjustment,
			String AspDrugStrengthUnitsIntCode, String ASP_Drug_Strength_Number, String Facility340BPriceAdjustment,
			String BiosimilarUseFacility340BPriceAdjustment, String SequestrationReduction, String HCPCScode)
			throws InterruptedException {

		click(getDriver().findElement(By.xpath("//span[contains(text(),'Add new')]")), "Add New Button");
		Thread.sleep(5000);

		// NDC
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[1]")), NDC, "NDC");
		Thread.sleep(2000);

		// TradeName
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[2]")), TradeName, "Trade Name");
		Thread.sleep(2000);

		// GroupName
		// select from dropdown
		getDriver().findElement(By.xpath("//kendo-dropdownlist[@textfield='Name']/span/span")).click();// click on that
																										// combo

		int groupName = Integer.parseInt(GroupNameIntCode);
		for (int i = 0; i <= groupName; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();// press down arrow key
		}
		Thread.sleep(10000);

		// IsOriginator - false - hence dont click
		// checkbox
		// (//td[@kendogridcell]//input)[3]
		// click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[3]")),
		// "Is Originator" );
		// Thread.sleep(2000);

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

		// Drug_Form_Code
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[12]")), Drug_Form_Code, "Drug Form Code");
		Thread.sleep(2000);

		// Drug_Package_Size/Adjusted PackageSize
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[13]")), Adjusted_PackageSize,
				"Adjusted Package Size");
		Thread.sleep(2000);

		// Drug_Package_Quantity
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[14]")), Drug_Package_Quantity,
				"Drug Package Quantity");
		Thread.sleep(2000);

		// ASP
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[15]")), ASP, "ASP");
		Thread.sleep(2000);

		// ASP_Adjustment
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[16]")), ASP_Adjustment, "ASP Adjustment");
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
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[17]")), ASP_Drug_Strength_Number,
				"ASP Drug Strength Number");
		Thread.sleep(2000);

		// Facility340BPriceAdjustment
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[18]")), Facility340BPriceAdjustment,
				"Facility 340B Price Adjustment");
		Thread.sleep(2000);

		// BiosimilarUseFacility340BPriceAdjustment - false - hence dont click
		// checkbox
		// (//td[@kendogridcell]//input)[19]
		// click(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[19]")),
		// "Biosimilar UseFacility 340B PriceAdjustment" );
		// Thread.sleep(2000);

		// SequestrationReduction
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[20]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[20]")), SequestrationReduction,
				"Sequestration Reduction");
		Thread.sleep(2000);

		// HCPCScode
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//td[@kendogridcell]//input)[21]")), HCPCScode, "HCPCS code");
		Thread.sleep(2000);

		click(getDriver().findElement(By.xpath("//button[@kendogridsavecommand]/span[contains(text(),'Add')]")),
				"Add button");
		Thread.sleep(5000);
		return this;
	}

}
