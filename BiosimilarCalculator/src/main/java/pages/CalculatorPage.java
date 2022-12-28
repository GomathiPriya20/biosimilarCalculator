package pages;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class CalculatorPage extends WebDriverServiceImpl {

	public CalculatorPage verifyCalulatorPage(String calculatorHeader, String selectaDrugHeader)
			throws InterruptedException {
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//div[@id='main']//h2[contains(text(),'Biosimilar Contract Advantage Calculator')]")),
				calculatorHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//div[@id='main']//h4[contains(text(),'Select a drug')]")),
				selectaDrugHeader);
		return this;
	}

	public CalculatorPage verifyTableHeadersInCalulatorPage_340B(String TradeNameHeader, String NDCHeader,
			String FormHeader, String AdjustedPackageSizeHeader, String PackageQuantityHeader, String GenericNameHeader,
			String BiosimilarGroupHeader, String IsOriginatorHeader, String ContractPriceHeader,
			String ContractPriceTypeHeader, String The_340BPriceHeader, String WACPriceHeader,
			String ContractStrengthHeader, String ASPHeader, String ASPStrengthHeader, String ContractUnitsHeader,
			String ReimbursementHeader, String DifferentialHeader, String DifferentialPerUnitsHeader)
			throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Trade Name']//span[contains(text(),'Trade Name')]")),
				TradeNameHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='NDC']//span[contains(text(),'NDC')]")),
				NDCHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='Form']//span[contains(text(),'Form')]")),
				FormHeader);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Adjusted Package Size']//span[contains(text(),'Adjusted Package Size')]")),
				AdjustedPackageSizeHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Package Quantity']//span[contains(text(),'Package Quantity')]")),
				PackageQuantityHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Generic Name']//span[contains(text(),'Generic Name')]")),
				GenericNameHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Biosimilar Group']//span[contains(text(),'Biosimilar Group')]")),
				BiosimilarGroupHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Is Originator']//span[contains(text(),'Is Originator')]")),
				IsOriginatorHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')]")),
				ContractPriceHeader);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")),
				ContractPriceTypeHeader);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='340B Price']//span[contains(text(),'340B Price')]")),
				The_340BPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")),
				WACPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")),
				ContractStrengthHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")),
				ASPHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")),
				ASPStrengthHeader);

		// Contract units
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Contract Units']//span[contains(text(),'Contract Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Contract Units']//span[contains(text(),'Contract Units')]")),
				ContractUnitsHeader);

		// 340B Price
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Contract Price']//span[contains(text(),'340B Price')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Contract Price']//span[contains(text(),'340B Price')]")),
				The_340BPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Reimbursement']//span[contains(text(),'Reimbursement')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Reimbursement']//span[contains(text(),'Reimbursement')]")),
				ReimbursementHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Differential')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Differential')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")),
				DifferentialPerUnitsHeader);

		// wac price
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[2]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[2]")),
				WACPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Reimbursement']//span[contains(text(),'Reimbursement')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Reimbursement']//span[contains(text(),'Reimbursement')]")),
				ReimbursementHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Differential')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Differential')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")),
				DifferentialPerUnitsHeader);

		return this;
	}

	public CalculatorPage verifyTableHeadersInCalulatorPage_Non340B(String TradeNameHeader, String NDCHeader,
			String FormHeader, String AdjustedPackageSizeHeader, String PackageQuantityHeader, String GenericNameHeader,
			String BiosimilarGroupHeader, String IsOriginatorHeader, String ContractPriceHeader,
			String ContractPriceTypeHeader, String The_340BPriceHeader, String WACPriceHeader,
			String ContractStrengthHeader, String ASPHeader, String ASPStrengthHeader, String ContractUnitsHeader,
			String ReimbursementHeader, String DifferentialHeader, String DifferentialPerUnitsHeader)
			throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Trade Name']//span[contains(text(),'Trade Name')]")),
				TradeNameHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='NDC']//span[contains(text(),'NDC')]")),
				NDCHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='Form']//span[contains(text(),'Form')]")),
				FormHeader);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Adjusted Package Size']//span[contains(text(),'Adjusted Package Size')]")),
				AdjustedPackageSizeHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Package Quantity']//span[contains(text(),'Package Quantity')]")),
				PackageQuantityHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Generic Name']//span[contains(text(),'Generic Name')]")),
				GenericNameHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Biosimilar Group']//span[contains(text(),'Biosimilar Group')]")),
				BiosimilarGroupHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Is Originator']//span[contains(text(),'Is Originator')]")),
				IsOriginatorHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")),
				ContractPriceHeader);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")),
				ContractPriceTypeHeader);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='340B Price']//span[contains(text(),'340B Price')]")),
				The_340BPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")),
				WACPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")),
				ContractStrengthHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")),
				ASPHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")),
				ASPStrengthHeader);

		// Contract units
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Contract Units']//span[contains(text(),'Contract Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Contract Units']//span[contains(text(),'Contract Units')]")),
				ContractUnitsHeader);

		// contract Price
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[2]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[2]")),
				ContractPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Reimbursement']//span[contains(text(),'Reimbursement')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Reimbursement']//span[contains(text(),'Reimbursement')]")),
				ReimbursementHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Differential')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Differential')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")),
				DifferentialPerUnitsHeader);

		// wac price
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[2]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[2]")),
				WACPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Reimbursement']//span[contains(text(),'Reimbursement')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Reimbursement']//span[contains(text(),'Reimbursement')]")),
				ReimbursementHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Differential')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Differential')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(text(),'Differential Per Units')]")),
				DifferentialPerUnitsHeader);

		return this;
	}

	public CalculatorPage selectAdrug_CalulatorPage(String selectaDrug) throws InterruptedException {
		type(getDriver().findElement(By.xpath("//input[@placeholder='Select a drug...']")), selectaDrug, "Group Name");
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//input[@placeholder='Select a drug...']")))
				.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		return this;
	}

	public CalculatorPage type_Units_CalulatorPage(String units) throws InterruptedException {
		type(getDriver().findElement(By.xpath("//kendo-numerictextbox//input")), units, "Units");
		Thread.sleep(3000);
		return this;
	}

	public CalculatorPage select_340B_Checkbox() throws InterruptedException {
		click(getDriver().findElement(By.id("340BFacility")), "340B Facility checkbox");
		Thread.sleep(3000);
		return this;
	}

	public CalculatorPage select_NDCfromFilterMenu(String NDC) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//a[@title='NDC Filter Menu']//span")), "Filter Icon on NDC field");
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

	// 340B Facility Price to Billing Units
	public CalculatorPage calculate340BFacilityPricetoBillingUnits(String ASP_Drug_Strength_Number,
			String The_340BPrice, String Drug_Strength_Number, String Adjusted_PackageSize,
			String Drug_Package_Quantity, String SheetName) throws InterruptedException {

		// =(D67*D56)/(D59*D62*D63)
		// The_340BFacilityPricetoBillingUnits = (ASP_Drug_Strength_Number *
		// The_340BPrice)/
		// (Drug_Strength_Number * Adjusted_PackageSize * Drug_Package_Quantity)

		BigDecimal a = new BigDecimal(ASP_Drug_Strength_Number).multiply(new BigDecimal(The_340BPrice));

		BigDecimal b = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity));

		MathContext mc = new MathContext(10);
		BigDecimal The_340BFacilityPricetoBillingUnits = a.divide(b, mc);

		System.out.println("The_340BFacilityPricetoBillingUnits:" + The_340BFacilityPricetoBillingUnits);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(The_340BFacilityPricetoBillingUnits.toString(), Driver.iTestCaseRowNum,
					"340BFacilityPricetoBillingUnits", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS, "340BFacilityPricetoBillingUnits field   "
					+ The_340BFacilityPricetoBillingUnits + "  is updated in the testdata sheet", screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}

	// Contract Price Billing Units
	public CalculatorPage calculateContractPriceBillingUnits(String ASP_Drug_Strength_Number, String ContractPrice,
			String Drug_Strength_Number, String Adjusted_PackageSize, String Drug_Package_Quantity, String SheetName)
			throws InterruptedException {
		// =(D61*D50)/(D53*D56*D57)
		// ContractPriceBillingUnits = (ASP_Drug_Strength_Number * ContractPrice)/
		// (Drug_Strength_Number * Adjusted_PackageSize * Drug_Package_Quantity)

		BigDecimal a = new BigDecimal(ASP_Drug_Strength_Number).multiply(new BigDecimal(ContractPrice));

		BigDecimal b = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity));

		MathContext mc = new MathContext(10);
		BigDecimal ContractPriceBillingUnits = a.divide(b, mc);

		System.out.println("ContractPriceBillingUnits:" + ContractPriceBillingUnits);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(ContractPriceBillingUnits.toString(), Driver.iTestCaseRowNum,
					"ContractPriceBillingUnits", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS, "ContractPriceinContractUnits field   " + ContractPriceBillingUnits
					+ "  is updated in the testdata sheet", screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}

	public CalculatorPage calculateASPPriceinContractUnits(String Drug_Strength_Number, String Adjusted_PackageSize,
			String Drug_Package_Quantity, String ASP, String ASP_Drug_Strength_Number, String SheetName)
			throws InterruptedException {
		// (Contract_Drug_Strength_Number * Contract_Drug_Package_Size *
		// Contract_Drug_Package_Quantity * ASP) / (ASP_Drug_Strength_Number)

		BigDecimal a = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity)).multiply(new BigDecimal(ASP));

		MathContext mc = new MathContext(10);
		BigDecimal ASPPriceinContractUnits = a.divide(new BigDecimal(ASP_Drug_Strength_Number), mc);

		System.out.println("ASPPriceinContractUnits in String:" + ASPPriceinContractUnits.toString());

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(ASPPriceinContractUnits.toString(), Driver.iTestCaseRowNum,
					"ASPPriceinContractUnits", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS,
					"ASPPriceinContractUnits field   " + ASPPriceinContractUnits + "  is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}

	// Biosimilar - 340B Price - Reimbursement
	public CalculatorPage calculate_Biosimilar_340BPrice_Reimbursement(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String SheetName) throws InterruptedException {
		// Reimbursement
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100))

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal The_340BPrice_Reimbursement = sum.subtract(partC);

		BigDecimal Reimbursment340BPrice = The_340BPrice_Reimbursement.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("The_340BPrice_Reimbursement in rounded off to 2 decimal: " + Reimbursment340BPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(Reimbursment340BPrice.toString(), Driver.iTestCaseRowNum,
					"Reimbursement_340BPrice", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS,
					"Reimbursement_340BPrice field  " + Reimbursment340BPrice + "  is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}

	// Biosimilar - 340B Price - Differential
	public CalculatorPage calculate_Biosimilar_340BPrice_Differential(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String The_340BFacilityPrice, String SheetName)
			throws InterruptedException {

		// Differential
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// 340BFacilityPrice

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal The_340BPrice_Reimbursement = sum.subtract(partC);

		BigDecimal The_340BPrice_Differential = The_340BPrice_Reimbursement
				.subtract(new BigDecimal(The_340BFacilityPrice));

		BigDecimal Differential340BPrice = The_340BPrice_Differential.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("Differential340BPrice in rounded off to 2 decimal: " + Differential340BPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(Differential340BPrice.toString(), Driver.iTestCaseRowNum,
					"Differential_340BPrice", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS,
					"Differential_340BPrice field  " + Differential340BPrice + "  is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}

	// Biosimilar - 340B Price - Differential per User input Units
	public CalculatorPage calculate_Biosimilar_340BPrice_Differential_per_User_input_Units(
			String ASPPriceinContractUnits, String ASP_Adjustment, String SequestrationReduction,
			String The_340BFacilityPrice, String Units, String SheetName) throws InterruptedException {

		// Differential per User input Units
		// =(ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// 340BFacilityPrice) * Units

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal The_340BPrice_Reimbursement = sum.subtract(partC);

		BigDecimal The_340BPrice_Differential = The_340BPrice_Reimbursement
				.subtract(new BigDecimal(The_340BFacilityPrice));

		BigDecimal The_340BPrice_Differential_per_User_input_Units = The_340BPrice_Differential
				.multiply(new BigDecimal(Units));

		BigDecimal DifferentialperUserinputUnits340BPrice = The_340BPrice_Differential_per_User_input_Units.setScale(2,
				RoundingMode.HALF_EVEN);
		System.out.println("DifferentialperUserinputUnits340BPrice in rounded off to 2 decimal: "
				+ DifferentialperUserinputUnits340BPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(DifferentialperUserinputUnits340BPrice.toString(), Driver.iTestCaseRowNum,
					"DifferentialperUserinputUnits_340BPrice", Driver.properties.getProperty(SheetName));
			setReport().log(
					Status.PASS, "DifferentialperUserinputUnits_340BPrice field  "
							+ DifferentialperUserinputUnits340BPrice + "  is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		return this;
	}

	// WAC Price

	// Biosimilar - WAC Price - Reimbursement
	public CalculatorPage calculate_Biosimilar_WACPrice_Reimbursement(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String SheetName) throws InterruptedException {
		// Reimbursement
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100))

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal WACPrice_Reimbursement = sum.subtract(partC);

		BigDecimal ReimbursmentWACPrice = WACPrice_Reimbursement.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("WACPriceReimbursement in rounded off to 2 decimal: " + ReimbursmentWACPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(ReimbursmentWACPrice.toString(), Driver.iTestCaseRowNum,
					"Reimbursement_WACPrice", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS,
					"Reimbursement_WACPrice field  " + ReimbursmentWACPrice + " is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		return this;
	}

	// Biosimilar - WAC Price - Differential
	public CalculatorPage calculate_Biosimilar_WACPrice_Differential(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String WACPrice, String SheetName)
			throws InterruptedException {

		// Differential
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// WACPrice

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal WACPrice_Reimbursement = sum.subtract(partC);

		BigDecimal WACPrice_Differential = WACPrice_Reimbursement.subtract(new BigDecimal(WACPrice));

		BigDecimal DifferentialWACPrice = WACPrice_Differential.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("DifferentialWACPrice in rounded off to 2 decimal: " + DifferentialWACPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(DifferentialWACPrice.toString(), Driver.iTestCaseRowNum,
					"Differential_WACPrice", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS,
					"Differential_WACPrice field  " + DifferentialWACPrice + " is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		return this;
	}

	// Biosimilar - WAC Price - Differential per User input Units
	public CalculatorPage calculate_Biosimilar_WACPrice_Differential_per_User_input_Units(
			String ASPPriceinContractUnits, String ASP_Adjustment, String SequestrationReduction, String WACPrice,
			String Units, String SheetName) throws InterruptedException {

		// Differential per User input Units
		// =(ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// 340BFacilityPrice) * Units

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);

		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal WACPrice_Reimbursement = sum.subtract(partC);

		BigDecimal WACPrice_Differential = WACPrice_Reimbursement.subtract(new BigDecimal(WACPrice));

		BigDecimal WACPrice_Differential_per_User_input_Units = WACPrice_Differential.multiply(new BigDecimal(Units));

		BigDecimal DifferentialperUserinputUnitsWACPrice = WACPrice_Differential_per_User_input_Units.setScale(2,
				RoundingMode.HALF_EVEN);
		System.out.println("DifferentialperUserinputUnitsWACPrice in rounded off to 2 decimal: "
				+ DifferentialperUserinputUnitsWACPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(DifferentialperUserinputUnitsWACPrice.toString(), Driver.iTestCaseRowNum,
					"DifferentialperUserinputUnits_WACPrice", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS, "DifferentialperUserinputUnits_WACPrice "
					+ DifferentialperUserinputUnitsWACPrice + " field is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		return this;
	}

	// Biosimilar - contract Price - Reimbursement
	public CalculatorPage calculate_Biosimilar_ContractPrice_Reimbursement(String ASPPriceinContractUnits, String ASP,
			String ASP_Adjustment, String SequestrationReduction, String SheetName) throws InterruptedException {
		// Reimbursement
		// =ASPPriceinContractUnits + (( ASP * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100))

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASP).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal contractPrice_Reimbursement = sum.subtract(partC);

		BigDecimal ReimbursmentContractPrice = contractPrice_Reimbursement.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("contractPrice_Reimbursement in rounded off to 2 decimal: " + ReimbursmentContractPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(ReimbursmentContractPrice.toString(), Driver.iTestCaseRowNum,
					"Reimbursement_ContractPrice", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS, "ReimbursmentContractPrice field  " + ReimbursmentContractPrice
					+ "  is updated in the testdata sheet", screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		return this;
	}

	// Biosimilar - contract Price - Differential
	public CalculatorPage calculate_Biosimilar_ContractPrice_Differential(String ASPPriceinContractUnits, String ASP,
			String ASP_Adjustment, String SequestrationReduction, String ContractPrice, String SheetName)
			throws InterruptedException {

		// Differential
		// =ASPPriceinContractUnits + (( ASP * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// ContractPrice

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASP).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal contractPrice_Reimbursement = sum.subtract(partC);

		BigDecimal contractPrice_Differential = contractPrice_Reimbursement.subtract(new BigDecimal(ContractPrice));

		BigDecimal DifferentialContractPrice = contractPrice_Differential.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("Differential340BPrice in rounded off to 2 decimal: " + DifferentialContractPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(DifferentialContractPrice.toString(), Driver.iTestCaseRowNum,
					"Differential_ContractPrice", Driver.properties.getProperty(SheetName));
			setReport().log(Status.PASS, "Differential_ContractPrice field  " + DifferentialContractPrice
					+ "  is updated in the testdata sheet", screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		return this;
	}

	// Biosimilar - contract Price - Differential per User input Units
	public CalculatorPage calculate_Biosimilar_ContractPrice_Differential_per_User_input_Units(
			String ASPPriceinContractUnits, String ASP, String ASP_Adjustment, String SequestrationReduction,
			String ContractPrice, String Units, String SheetName) throws InterruptedException {

		// Differential per User input Units
		// =(ASPPriceinContractUnits + (( ASP * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// ContractPrice) * Units

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASP).multiply(new BigDecimal(ASP_Adjustment));

		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal a1 = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));

		BigDecimal partC = a1.divide(new BigDecimal(hundred), mc);

		BigDecimal sum = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal contractPrice_Reimbursement = sum.subtract(partC);

		BigDecimal contractPrice_Differential = contractPrice_Reimbursement.subtract(new BigDecimal(ContractPrice));

		BigDecimal contractPrice_Differential_per_User_input_Units = contractPrice_Differential
				.multiply(new BigDecimal(Units));

		BigDecimal DifferentialperUserinputUnitsContractPrice = contractPrice_Differential_per_User_input_Units
				.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("DifferentialperUserinputUnitsContractPrice in rounded off to 2 decimal: "
				+ DifferentialperUserinputUnitsContractPrice);

		// write the value back to excel after calculation
		try {
			DataInputProvider.setCellData(DifferentialperUserinputUnitsContractPrice.toString(), Driver.iTestCaseRowNum,
					"DifferentialperUserinputUnits_ContractPrice", Driver.properties.getProperty(SheetName));
			setReport().log(
					Status.PASS, "DifferentialperUserinputUnits_ContractPrice field  "
							+ DifferentialperUserinputUnitsContractPrice + "  is updated in the testdata sheet",
					screenshotCapture());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		return this;
	}

	public CalculatorPage verifyTableValuesForSpecificNDCInCalulatorPage(String TradeName, String NDC, String Form,
			String AdjustedPackageSize, String PackageQuantity, String GenericName, String BiosimilarGroup,
			String IsOriginator, String ContractPrice, String ContractPriceType, String The_340BPrice, String WACPrice,
			String Drug_Strength_Number, String Drug_Strength_Units, String Drug_Form_Code, String ASP,
			String ASP_Drug_Strength_Number, String ASP_Drug_Strength_Units, String Reimbursement_340BPrice,
			String Differential_340BPrice, String DifferentialPerUnits_340BPrice, String Reimbursement_WACPrice,
			String Differential_WACPrice, String DifferentialPerUnits_WACPrice) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("#,###.00");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='0']")).getText(),
				TradeName, "Trade Name");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='1']")).getText(), NDC,
				"NDC");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='2']")).getText(),
				Form, "Form");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='3']")).getText(),
				AdjustedPackageSize, "AdjustedPackageSize");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='4']")).getText(),
				PackageQuantity, "PackageQuantity");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='5']")).getText(),
				GenericName, "GenericName");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='6']")).getText(),
				BiosimilarGroup, "BiosimilarGroup");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='7']")).getText(),
				IsOriginator, "IsOriginator");

		Thread.sleep(3000);
		String ContractPricewith$ = "$" + ContractPrice;
		System.out.println("ContractPricewith$" + ContractPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='8']")).getText(),
				ContractPricewith$, "ContractPrice");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='9']")).getText(),
				ContractPriceType, "ContractPriceType");

		Thread.sleep(3000);
		String The_340BPrice_format = String.format("%.2f", new BigDecimal(The_340BPrice));
		// System.out.println(" The_340BPrice_format: " + The_340BPrice_format);
		String The_340BPricewith$ = "$" + The_340BPrice_format;
		System.out.println("The_340BPricewith$" + The_340BPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='10']")).getText(),
				The_340BPricewith$, "The_340BPrice");

		Thread.sleep(3000);
		String WACPricewith$ = "$" + WACPrice;
		System.out.println("WACPricewith$" + WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText(),
				WACPricewith$, "WACPrice");
		Thread.sleep(3000);

		String contractStrength = Drug_Strength_Number + Drug_Strength_Units + "/" + Drug_Form_Code;
		System.out.println("contractStrength" + contractStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='12']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='12']")).getText(),
				contractStrength, "Contract Strength");

		Thread.sleep(3000);
		String ASPwith$ = "$" + ASP;
		System.out.println("ASPwith$$" + ASPwith$);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='13']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='13']")).getText(),
				ASPwith$, "ASP");

		String ASPStrength = ASP_Drug_Strength_Number + ASP_Drug_Strength_Units + "/" + Drug_Form_Code;
		System.out.println("ASPStrength" + ASPStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='14']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='14']")).getText(),
				ASPStrength, "ASPStrength");

		Thread.sleep(3000);
		String Reimbursement_340BPricewith$ = "$" + Reimbursement_340BPrice;
		System.out.println("Reimbursement_340BPricewith$" + Reimbursement_340BPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='15']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='15']")).getText(),
				Reimbursement_340BPricewith$, "Reimbursement - 340B/Contract Price");

		Thread.sleep(3000);
		String Differential_340BPricewith$ = "$" + Differential_340BPrice;
		System.out.println("Differential_340BPricewith$" + Differential_340BPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='16']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='16']")).getText(),
				Differential_340BPricewith$, "Differential - 340B/Contract Price");

		Thread.sleep(3000);
		String formatted_DifferentialPerUnits_340BPriceWithComma = df
				.format(new BigDecimal(DifferentialPerUnits_340BPrice));
		// System.out.println("Formatted DifferentialPerUnits_340BPriceWithComma with
		// commas: "
		// + formatted_DifferentialPerUnits_340BPriceWithComma);
		String DifferentialPerUnits_340BPricewith$ = "$" + formatted_DifferentialPerUnits_340BPriceWithComma;
		System.out.println("DifferentialPerUnits_340BPricewith$" + DifferentialPerUnits_340BPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='17']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='17']")).getText(),
				DifferentialPerUnits_340BPricewith$, "DifferentialPerUnitsHeader - 340B/Contract Price");

		Thread.sleep(3000);
		String Reimbursement_WACPricewith$ = "$" + Reimbursement_WACPrice;
		System.out.println("Reimbursement_WACPricewith$" + Reimbursement_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='18']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='18']")).getText(),
				Reimbursement_WACPricewith$, "Reimbursement_WACPrice");

		Thread.sleep(3000);
		String Differential_WACPricewith$ = "$" + Differential_WACPrice;
		System.out.println("Differential_WACPricewith$" + Differential_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='19']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='19']")).getText(),
				Differential_WACPricewith$, "Differential_WACPrice");

		Thread.sleep(3000);
		String formatted_DifferentialPerUnits_WACPriceWithComma = df
				.format(new BigDecimal(DifferentialPerUnits_WACPrice));
		// System.out.println("Formatted DifferentialPerUnits_WACPrice with commas: "
		// + formatted_DifferentialPerUnits_WACPriceWithComma);
		String DifferentialPerUnits_WACPricewith$ = "$" + formatted_DifferentialPerUnits_WACPriceWithComma;
		System.out.println("DifferentialPerUnits_WACPricewith$" + DifferentialPerUnits_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='20']")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='20']")).getText(),
				DifferentialPerUnits_WACPricewith$, "DifferentialPerUnits_WACPrice");

		return this;
	}

}
