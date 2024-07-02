package pages;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class CalculatorPage extends WebDriverServiceImpl {

	public CalculatorPage selectBiosimilarCalcultorMenu() {

		return this;
	}

	public CalculatorPage verifyBlankCalculatorPage(String calculatorHeader, String selectaDrugHeader)
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
			String BiosimilarGroupHeader, String IsOriginatorHeader, String LastUpdatedTimeHeader, String ContractPriceHeader,
			String ContractPriceTypeHeader, String The_340BPriceHeader, String WACPriceHeader,
			String ContractStrengthHeader, String ASPHeader, String ASPStrengthHeader, String ContractUnitsHeader,
			String ReimbursementHeader, String DifferentialHeader, String DifferentialPerUnitsHeader)
			throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Trade Name']//span[contains(text(),'Trade Name')]")),
				TradeNameHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'NDC')]")), NDCHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='Form']//span[contains(text(),'Form')]")),
				FormHeader);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Drug_Package_Size']//span[contains(text(),' Dose Per Vial ')]")),
				AdjustedPackageSizeHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Package Quantity']//span[contains(text(),'Package Quantity')]")),
				PackageQuantityHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Generic Name']//span[contains(text(),'Generic Name')]")),
				GenericNameHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Biosimilar Group']//span[contains(text(),'Biosimilar Group')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Biosimilar Group']//span[contains(text(),'Biosimilar Group')]")),
				BiosimilarGroupHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Is Originator']//span[contains(text(),'Is Originator')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Is Originator']//span[contains(text(),'Is Originator')]")),
				IsOriginatorHeader);
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")),
				LastUpdatedTimeHeader);
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")),
				ContractPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")),
				ContractPriceTypeHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='340B Price']//span[contains(text(),'340B Price')]")));
		Thread.sleep(3000);
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
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")),
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
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Revenue ')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Revenue ')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")),
				DifferentialPerUnitsHeader);
	
		return this;
	}

	public CalculatorPage verifyTableHeadersInCalulatorPage_Non340B(String TradeNameHeader, String NDCHeader,
			String FormHeader, String AdjustedPackageSizeHeader, String PackageQuantityHeader, String GenericNameHeader,
			String BiosimilarGroupHeader, String IsOriginatorHeader, String LastUpdatedTimeHeader, String ContractPriceHeader,
			String ContractPriceTypeHeader, String The_340BPriceHeader, String WACPriceHeader,
			String ContractStrengthHeader, String ASPHeader, String ASPStrengthHeader, String ContractUnitsHeader,
			String ReimbursementHeader, String DifferentialHeader, String DifferentialPerUnitsHeader)
			throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Trade Name']//span[contains(text(),'Trade Name')]")),
				TradeNameHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'NDC')]")), NDCHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='Form']//span[contains(text(),'Form')]")),
				FormHeader);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Drug_Package_Size']//span[contains(text(),' Dose Per Vial ')]")),
				AdjustedPackageSizeHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Package Quantity']//span[contains(text(),'Package Quantity')]")),
				PackageQuantityHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Generic Name']//span[contains(text(),'Generic Name')]")),
				GenericNameHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Biosimilar Group']//span[contains(text(),'Biosimilar Group')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Biosimilar Group']//span[contains(text(),'Biosimilar Group')]")),
				BiosimilarGroupHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Is Originator']//span[contains(text(),'Is Originator')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Is Originator']//span[contains(text(),'Is Originator')]")),
				IsOriginatorHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")),
				LastUpdatedTimeHeader);
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")),
				ContractPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")),
				ContractPriceTypeHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='340B Price']//span[contains(text(),'340B Price')]")));
		Thread.sleep(3000);
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
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")),
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
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Revenue ')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Revenue ')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")),
				DifferentialPerUnitsHeader);

		return this;
	}

	public CalculatorPage selectAdrug_CalculatorPage(String selectaDrug) throws InterruptedException {
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
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//a[@title='NDC Filter Menu']//kendo-svgicon")));
		Thread.sleep(3000);

		WebElement element = getDriver().findElement(By.xpath("//a[@title='NDC Filter Menu']//kendo-svgicon"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);

		// click(getDriver().findElement(By.xpath("//a[@title='NDC Filter
		// Menu']//kendo-svg-icon")), "Filter Icon on NDC field");
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

	// 340B Facility Price to Billing Units
	public CalculatorPage calculate340BFacilityPricetoBillingUnits_Customize(String ASP_Drug_Strength_Number,
			String The_340BPrice, String Drug_Strength_Number, String Adjusted_PackageSize,
			String Drug_Package_Quantity, String SheetName, String multiplicationFactor) throws InterruptedException {

		// =(D67*D56)/(D59*D62*D63)
		// The_340BFacilityPricetoBillingUnits = (ASP_Drug_Strength_Number *
		// The_340BPrice)/
		// (Drug_Strength_Number * Adjusted_PackageSize * Drug_Package_Quantity)

		BigDecimal a = new BigDecimal(ASP_Drug_Strength_Number).multiply(new BigDecimal(The_340BPrice));

		BigDecimal b = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity)).multiply(new BigDecimal(multiplicationFactor));

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

	// 340B Facility Price to Billing Units - M to MG
	public CalculatorPage calculate340BFacilityPricetoBillingUnits_GtoMG(String ASP_Drug_Strength_Number,
			String The_340BPrice, String Drug_Strength_Number, String Adjusted_PackageSize,
			String Drug_Package_Quantity, String SheetName) throws InterruptedException {

		// =(D67*D56)/(D59*D62*D63)
		// The_340BFacilityPricetoBillingUnits = (ASP_Drug_Strength_Number *
		// The_340BPrice)/
		// (Drug_Strength_Number * Adjusted_PackageSize * Drug_Package_Quantity * 0.001)

		BigDecimal a = new BigDecimal(ASP_Drug_Strength_Number).multiply(new BigDecimal(The_340BPrice));

		BigDecimal b = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity)).multiply(new BigDecimal(0.001));

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

	public CalculatorPage calculateASPPriceinContractUnits_GtoMG(String Drug_Strength_Number,
			String Adjusted_PackageSize, String Drug_Package_Quantity, String ASP, String ASP_Drug_Strength_Number,
			String SheetName) throws InterruptedException {
		// (Contract_Drug_Strength_Number * Contract_Drug_Package_Size *
		// Contract_Drug_Package_Quantity * ASP) / (ASP_Drug_Strength_Number * 0.001)

		BigDecimal a = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity)).multiply(new BigDecimal(ASP));

		BigDecimal b = new BigDecimal(ASP_Drug_Strength_Number).multiply(new BigDecimal(0.001));

		MathContext mc = new MathContext(10);
		BigDecimal ASPPriceinContractUnits = a.divide(b, mc);

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

	// Contract Price Billing Units
	public CalculatorPage calculateContractPriceBillingUnits_Customize(String ASP_Drug_Strength_Number,
			String ContractPrice, String Drug_Strength_Number, String Adjusted_PackageSize,
			String Drug_Package_Quantity, String SheetName, String multiplicationFactor) throws InterruptedException {
		// =(D61*D50)/(D53*D56*D57)
		// ContractPriceBillingUnits = (ASP_Drug_Strength_Number * ContractPrice)/
		// (Drug_Strength_Number * Adjusted_PackageSize * Drug_Package_Quantity)

		BigDecimal a = new BigDecimal(ASP_Drug_Strength_Number).multiply(new BigDecimal(ContractPrice));

		BigDecimal b = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity)).multiply(new BigDecimal(multiplicationFactor));

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

	public CalculatorPage calculateASPPriceinContractUnits_Customize(String Drug_Strength_Number,
			String Adjusted_PackageSize, String Drug_Package_Quantity, String ASP, String ASP_Drug_Strength_Number,
			String SheetName, String multiplicationFactor) throws InterruptedException {
		// (Contract_Drug_Strength_Number * Contract_Drug_Package_Size *
		// Contract_Drug_Package_Quantity * ASP) / (ASP_Drug_Strength_Number * 0.001)

		BigDecimal a = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Adjusted_PackageSize))
				.multiply(new BigDecimal(Drug_Package_Quantity)).multiply(new BigDecimal(ASP));

		BigDecimal b = new BigDecimal(ASP_Drug_Strength_Number).multiply(new BigDecimal(multiplicationFactor));

		MathContext mc = new MathContext(10);
		BigDecimal ASPPriceinContractUnits = a.divide(b, mc);

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
	public CalculatorPage calculate_Biosimilar_Originator_ContractPrice_Reimbursement(String ASPPriceinContractUnits,
			String ASP, String ASP_Adjustment, String SequestrationReduction, String SheetName)
			throws InterruptedException {
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
	public CalculatorPage calculate_Biosimilar_Originator_ContractPrice_Differential(String ASPPriceinContractUnits,
			String ASP, String ASP_Adjustment, String SequestrationReduction, String ContractPrice, String SheetName)
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
		System.out.println("Differential Contract Price in rounded off to 2 decimal: " + DifferentialContractPrice);

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
	public CalculatorPage calculate_Biosimilar_Originator_ContractPrice_Differential_per_User_input_Units(
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

	// Originator - 340B Price - Reimbursement
	public CalculatorPage calculate_Originator_340BPrice_Reimbursement(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String Facility340BPriceAdjustment, String SheetName)
			throws InterruptedException {
		// Reimbursement

		// =E73+((E73*E65/100))-((E73*E68/100))-((E73*E70/100))
		// =ASPPriceinContractUnits +
		// (( ASPPriceinContractUnits * ASP_Adjustment/100))-
		// ((ASPPriceinContractUnits * Facility340BPriceAdjustment/100))-
		// ((ASPPriceinContractUnits * SequestrationReduction/100))

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);
		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal The_340BPrice_Reimbursement = sum_ABC.subtract(partD);

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

	// Originator - 340B Price - Differential
	public CalculatorPage calculate_Originator_340BPrice_Differential(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String The_340BFacilityPrice,
			String Facility340BPriceAdjustment, String SheetName) throws InterruptedException {

		// Differential
		// =E73+((E73*E65/100))-((E73*E68/100))-((E73*E70/100))-E56
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * Facility340BPriceAdjustment/100))
		// ((ASPPriceinContractUnits * SequestrationReduction/100)) - 340BFacilityPrice

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);
		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal sum_ABCD = sum_ABC.subtract(partD);
		BigDecimal The_340BPrice_Differential = sum_ABCD.subtract(new BigDecimal(The_340BFacilityPrice));

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

	// Originator - 340B Price - Differential per User input Units
	public CalculatorPage calculate_Originator_340BPrice_Differential_per_User_input_Units(
			String ASPPriceinContractUnits, String ASP_Adjustment, String SequestrationReduction,
			String The_340BFacilityPrice, String Units, String Facility340BPriceAdjustment, String SheetName)
			throws InterruptedException {

		// Differential per User input Units
		// =(ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// 340BFacilityPrice) * Units

		// =(ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-
		// ((ASPPriceinContractUnits * Facility340BPriceAdjustment/100)) -
		// ((ASPPriceinContractUnits * SequestrationReduction/100)) - 340BFacilityPrice)
		// * Units

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal sum_ABCD = sum_ABC.subtract(partD);

		BigDecimal sum_ABCDE = sum_ABCD.subtract(new BigDecimal(The_340BFacilityPrice));

		BigDecimal The_340BPrice_Differential_per_User_input_Units = sum_ABCDE.multiply(new BigDecimal(Units));

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

	// Originator - WAC Price - Reimbursement
	public CalculatorPage calculate_Originator_WACPrice_Reimbursement(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String Facility340BPriceAdjustment, String SheetName)
			throws InterruptedException {
		// Reimbursement
		// =E73+((E73*E65/100))-((E73*E68/100))-((E73*E70/100))
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits *
		// ASP_Adjustment/100))-((ASPPriceinContractUnits *
		// Facility340BPriceAdjustment/100))
		// - ((ASPPriceinContractUnits * SequestrationReduction/100))

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal sum_ABCD = sum_ABC.subtract(partD);

		BigDecimal ReimbursmentWACPrice = sum_ABCD.setScale(2, RoundingMode.HALF_EVEN);
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

	// Originator - WAC Price - Differential
	public CalculatorPage calculate_Originator_WACPrice_Differential(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String WACPrice, String Facility340BPriceAdjustment,
			String SheetName) throws InterruptedException {

		// Differential
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// WACPrice
		// =E73+((E73*E65/100))-((E73*E68/100))-((E73*E70/100))-E57
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-
		// ((ASPPriceinContractUnits *
		// Facility340BPriceAdjustment/100))-((ASPPriceinContractUnits *
		// SequestrationReduction/100)) - WACPrice

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal sum_ABCD = sum_ABC.subtract(partD);

		BigDecimal WACPrice_Differential = sum_ABCD.subtract(new BigDecimal(WACPrice));

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

	// Originator - WAC Price - Differential per User input Units
	public CalculatorPage calculate_Originator_WACPrice_Differential_per_User_input_Units(
			String ASPPriceinContractUnits, String ASP_Adjustment, String SequestrationReduction, String WACPrice,
			String Units, String Facility340BPriceAdjustment, String SheetName) throws InterruptedException {

		// Differential per User input Units
		// =(E73+((E73*E65/100))-((E73*E68/100))-((E73*E70/100))-E57) *D5
		// =(ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-
		// ((ASPPriceinContractUnits *
		// Facility340BPriceAdjustment/100))-((ASPPriceinContractUnits *
		// SequestrationReduction/100)) - WACPrice) * Units

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);
		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal sum_ABCD = sum_ABC.subtract(partD);

		BigDecimal sum_ABCDE = sum_ABCD.subtract(new BigDecimal(WACPrice));
		BigDecimal WACPrice_Differential_per_User_input_Units = sum_ABCDE.multiply(new BigDecimal(Units));

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

	// Originator - Contract Price - Reimbursement
	public CalculatorPage calculate_Originator_ContractPrice_Reimbursement(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String Facility340BPriceAdjustment, String SheetName)
			throws InterruptedException {
		// Reimbursement

		// =E73+((E73*E65/100))-((E73*E68/100))-((E73*E70/100))
		// =ASPPriceinContractUnits +
		// (( ASPPriceinContractUnits * ASP_Adjustment/100))-
		// ((ASPPriceinContractUnits * Facility340BPriceAdjustment/100))-
		// ((ASPPriceinContractUnits * SequestrationReduction/100))

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);
		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal The_340BPrice_Reimbursement = sum_ABC.subtract(partD);

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

	// Originator - Contract Price - Differential
	public CalculatorPage calculate_Originator_ContractPrice_Differential(String ASPPriceinContractUnits,
			String ASP_Adjustment, String SequestrationReduction, String The_340BFacilityPrice,
			String Facility340BPriceAdjustment, String SheetName) throws InterruptedException {

		// Differential
		// =E73+((E73*E65/100))-((E73*E68/100))-((E73*E70/100))-E56
		// =ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * Facility340BPriceAdjustment/100))
		// ((ASPPriceinContractUnits * SequestrationReduction/100)) - 340BFacilityPrice

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);
		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal sum_ABCD = sum_ABC.subtract(partD);
		BigDecimal The_340BPrice_Differential = sum_ABCD.subtract(new BigDecimal(The_340BFacilityPrice));

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

	// Originator - Contract Price - Differential per User input Units
	public CalculatorPage calculate_Originator_ContractPrice_Differential_per_User_input_Units(
			String ASPPriceinContractUnits, String ASP_Adjustment, String SequestrationReduction,
			String The_340BFacilityPrice, String Units, String Facility340BPriceAdjustment, String SheetName)
			throws InterruptedException {

		// Differential per User input Units
		// =(ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-((ASPPriceinContractUnits * SequestrationReduction/100)) -
		// 340BFacilityPrice) * Units

		// =(ASPPriceinContractUnits + (( ASPPriceinContractUnits * ASP_Adjustment
		// /100))-
		// ((ASPPriceinContractUnits * Facility340BPriceAdjustment/100)) -
		// ((ASPPriceinContractUnits * SequestrationReduction/100)) - 340BFacilityPrice)
		// * Units

		String hundred = "100";
		BigDecimal a = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(ASP_Adjustment));
		MathContext mc = new MathContext(10);
		BigDecimal partB = a.divide(new BigDecimal(hundred), mc);

		BigDecimal b = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(Facility340BPriceAdjustment));
		BigDecimal partC = b.divide(new BigDecimal(hundred), mc);

		BigDecimal c = new BigDecimal(ASPPriceinContractUnits).multiply(new BigDecimal(SequestrationReduction));
		BigDecimal partD = c.divide(new BigDecimal(hundred), mc);

		BigDecimal sum_AB = new BigDecimal(ASPPriceinContractUnits).add(partB);

		BigDecimal sum_ABC = sum_AB.subtract(partC);
		BigDecimal sum_ABCD = sum_ABC.subtract(partD);

		BigDecimal sum_ABCDE = sum_ABCD.subtract(new BigDecimal(The_340BFacilityPrice));

		BigDecimal The_340BPrice_Differential_per_User_input_Units = sum_ABCDE.multiply(new BigDecimal(Units));

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

	public CalculatorPage verifyTableValuesForSpecificNDCInCalulatorPage(String TradeName, String NDC, String Form,
			String AdjustedPackageSize, String PackageQuantity, String GenericName, String BiosimilarGroup,
			String IsOriginator, String CreatedOn, String ContractPrice, String ContractPriceType, String The_340BPrice, String WACPrice,
			String Drug_Strength_Number, String Drug_Strength_Units, String Drug_Strength_Volume, String Drug_Form_Code,
			String ASP, String ASP_Drug_Strength_Number, String ASP_Drug_Strength_Units, String Reimbursement_340BPrice,
			String Differential_340BPrice, String DifferentialPerUnits_340BPrice, String Reimbursement_WACPrice,
			String Differential_WACPrice, String DifferentialPerUnits_WACPrice) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("#,##0.00");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='0']")).getText(),
				TradeName, "Trade Name");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='1']")).getText(), NDC,
				"NDC");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='2']")).getText(),
				Form, "Form");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='3']")).getText(),
				AdjustedPackageSize, "Dose Per Vial");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='4']")).getText(),
				PackageQuantity, "PackageQuantity");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='5']")).getText(),
				GenericName, "GenericName");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='6']")).getText(),
				BiosimilarGroup, "BiosimilarGroup");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='7']")).getText(),
				IsOriginator, "IsOriginator");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='8']"))
				.getAttribute("textContent"), CreatedOn, "Last Updated Time");
		
		Thread.sleep(3000);
		String formatted_ContractPriceWithComma = df.format(new BigDecimal(ContractPrice));
		String ContractPricewith$ = "$" + formatted_ContractPriceWithComma;
		System.out.println("ContractPricewith$: " + ContractPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='9']")).getText(),
				ContractPricewith$, "ContractPrice");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='10']")).getText(),
				ContractPriceType, "ContractPriceType");

		Thread.sleep(3000);
		String The_340BPrice_format = String.format("%.2f", new BigDecimal(The_340BPrice));
		// System.out.println(" The_340BPrice_format: " + The_340BPrice_format);
		String The_340BPricewith$ = "$" + The_340BPrice_format;
		System.out.println("The_340BPricewith$" + The_340BPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText(),
				The_340BPricewith$, "The_340BPrice");

		Thread.sleep(3000);
		String formatted_WACPriceWithComma = df.format(new BigDecimal(WACPrice));
		String Formatted_WACPricewith$ = "$" + formatted_WACPriceWithComma;
		System.out.println("Formatted_WACPricewith$: " + Formatted_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='12']")).getText(),
				Formatted_WACPricewith$, "WACPrice");
		Thread.sleep(3000);

		String contractStrength = Drug_Strength_Number + Drug_Strength_Units + "/ " + Drug_Strength_Volume
				+ Drug_Form_Code;
		System.out.println("contractStrength" + contractStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='13']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");

		Thread.sleep(3000);
		String ASPwith$ = "$" + ASP;
		System.out.println("ASPwith$" + ASPwith$);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='14']")).getText(),
				ASPwith$, "ASP");

		String ASPStrength = ASP_Drug_Strength_Number + ASP_Drug_Strength_Units;
		// + "/" + Drug_Form_Code;
		System.out.println("ASPStrength" + ASPStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='15']")).getText(),
				ASPStrength, "ASPStrength");

		Thread.sleep(3000);
		String formatted_Reimbursement_340BPriceWithComma = df.format(new BigDecimal(Reimbursement_340BPrice));
		String Reimbursement_340BPricewith$ = "$" + formatted_Reimbursement_340BPriceWithComma;
		if (Reimbursement_340BPricewith$.equalsIgnoreCase("$0.00")) {
			Reimbursement_340BPricewith$ = "0";
		}
		System.out.println("Reimbursement_340BPricewith$" + Reimbursement_340BPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Reimbursement']//span[contains(text(),'Reimbursement')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='16']")).getText(),
				Reimbursement_340BPricewith$, "Reimbursement - 340B/Contract Price");

		Thread.sleep(3000);
		String formatted_Differential_340BPriceWithComma = df.format(new BigDecimal(Differential_340BPrice));
		String Differential_340BPricewith$ = "$" + formatted_Differential_340BPriceWithComma;
		System.out.println("Differential_340BPricewith$" + Differential_340BPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='17']")).getText(),
				Differential_340BPricewith$, "Differential - 340B/Contract Price");

		Thread.sleep(3000);
		String formatted_DifferentialPerUnits_340BPriceWithComma = df
				.format(new BigDecimal(DifferentialPerUnits_340BPrice));
		String DifferentialPerUnits_340BPricewith$ = "$" + formatted_DifferentialPerUnits_340BPriceWithComma;
		System.out.println("DifferentialPerUnits_340BPricewith$" + DifferentialPerUnits_340BPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='18']")).getText(),
				DifferentialPerUnits_340BPricewith$, "DifferentialPerUnitsHeader - 340B/Contract Price");

		Thread.sleep(3000);
		String formatted_Reimbursement_WACPriceWithComma = df.format(new BigDecimal(Reimbursement_WACPrice));
		String Reimbursement_WACPricewith$ = "$" + formatted_Reimbursement_WACPriceWithComma;
		if (Reimbursement_WACPricewith$.equalsIgnoreCase("$0.00")) {
			Reimbursement_WACPricewith$ = "0";
		}
		System.out.println("Reimbursement_WACPricewith$" + Reimbursement_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Reimbursement']//span[contains(text(),'Reimbursement')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='19']")).getText(),
				Reimbursement_WACPricewith$, "Reimbursement_WACPrice");

		Thread.sleep(3000);
		String formatted_Differential_WACPriceWithComma = df.format(new BigDecimal(Differential_WACPrice));
		String Differential_WACPricewith$ = "$" + formatted_Differential_WACPriceWithComma;
		System.out.println("Differential_WACPricewith$" + Differential_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential']//span[contains(text(),'Revenue')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='20']")).getText(),
				Differential_WACPricewith$, "Differential_WACPrice");

		Thread.sleep(3000);
		String formatted_DifferentialPerUnits_WACPriceWithComma = df
				.format(new BigDecimal(DifferentialPerUnits_WACPrice));
		String DifferentialPerUnits_WACPricewith$ = "$" + formatted_DifferentialPerUnits_WACPriceWithComma;
		System.out.println("DifferentialPerUnits_WACPricewith$" + DifferentialPerUnits_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_WAC_Price_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='21']")).getText(),
				DifferentialPerUnits_WACPricewith$, "DifferentialPerUnits_WACPrice");

		return this;
	}

	public CalculatorPage verifyBasicTableValuesForSpecificNDCInBiosimilarCalulatorPage(String TradeName, String NDC,
			String Form, String AdjustedPackageSize, String PackageQuantity, String GenericName, String BiosimilarGroup,
			String IsOriginator, String CreatedOn, String ContractPrice, String ContractPriceType, String The_340BPrice, String WACPrice,
			String Drug_Strength_Number, String Drug_Strength_Units, String Drug_Strength_Volume, String Drug_Form_Code,
			String ASP, String ASP_Drug_Strength_Number, String ASP_Drug_Strength_Units) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("#,##0.00");

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
		
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='8']")).getAttribute("textContent"),
				CreatedOn, "Last Updated Time");

		Thread.sleep(3000);
		String formatted_ContractPriceWithComma = df.format(new BigDecimal(ContractPrice));
		String ContractPricewith$ = "$" + formatted_ContractPriceWithComma;
		System.out.println("ContractPricewith$: " + ContractPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='9']")).getText(),
				ContractPricewith$, "ContractPrice");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='10']")).getText(),
				ContractPriceType, "ContractPriceType");

		Thread.sleep(3000);
		if (The_340BPrice.equalsIgnoreCase("0")) {
			verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText(),
					The_340BPrice, "The_340BPrice");

		} else {
			String The_340BPrice_format = String.format("%.2f", new BigDecimal(The_340BPrice));
			String The_340BPricewith$ = "$" + The_340BPrice_format;
			System.out.println("The_340BPricewith$" + The_340BPricewith$);

			verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText(),
					The_340BPricewith$, "The_340BPrice");
		}

		Thread.sleep(3000);
		String formatted_WACPriceWithComma = df.format(new BigDecimal(WACPrice));
		String Formatted_WACPricewith$ = "$" + formatted_WACPriceWithComma;
		System.out.println("Formatted_WACPricewith$: " + Formatted_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='12']")).getText(),
				Formatted_WACPricewith$, "WACPrice");
		Thread.sleep(3000);

		String contractStrength = Drug_Strength_Number + Drug_Strength_Units + "/ " + Drug_Strength_Volume
				+ Drug_Form_Code;
		System.out.println("contractStrength" + contractStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='13']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");

		Thread.sleep(3000);
		String ASPwith$ = "$" + ASP;
		System.out.println("ASPwith$" + ASPwith$);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='14']")).getText(),
				ASPwith$, "ASP");

		String ASPStrength = ASP_Drug_Strength_Number + ASP_Drug_Strength_Units;
		// + "/" + Drug_Form_Code;
		System.out.println("ASPStrength" + ASPStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='15']")).getText(),
				ASPStrength, "ASPStrength");

		return this;
	}

	public CalculatorPage verify_ContractStrength_ForSpecificNDCInBiosimilarCalulatorPage(String Drug_Strength_Number,
			String Drug_Strength_Units, String Drug_Strength_Volume, String Drug_Form_Code)
			throws InterruptedException {

		Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);

		String contractStrength = Drug_Strength_Number + Drug_Strength_Units + "/ " + Drug_Strength_Volume
				+ Drug_Form_Code;
		System.out.println("contractStrength" + contractStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='13']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");

		return this;
	}

	public CalculatorPage verifyBasicTableValuesForSpecificNDCInIvigCalulatorPage(String TradeName, String NDC,
			String Form, String AdjustedPackageSize, String PackageQuantity, String GenericName, String CreatedOn, String ContractPrice,
			String ContractPriceType, String The_340BPrice, String WACPrice, String Drug_Strength_Number,
			String Drug_Strength_Units, String Drug_Strength_Volume, String Drug_Form_Code, String Units, String ASP,
			String ASP_Drug_Strength_Number, String ASP_Drug_Strength_Units) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("#,##0.00");

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

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='6']")).getAttribute("textContent"),
				CreatedOn, "Last Updated Time");
		
		Thread.sleep(3000);
		String formatted_ContractPriceWithComma = df.format(new BigDecimal(ContractPrice));
		String ContractPricewith$ = "$" + formatted_ContractPriceWithComma;
		System.out.println("ContractPricewith$: " + ContractPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='7']")).getText(),
				ContractPricewith$, "ContractPrice");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='8']")).getText(),
				ContractPriceType, "ContractPriceType");

		Thread.sleep(3000);
		if (The_340BPrice.equalsIgnoreCase("0")) {
			verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='9']")).getText(),
					The_340BPrice, "The_340BPrice");

		} else {
			String The_340BPrice_format = String.format("%.2f", new BigDecimal(The_340BPrice));
			String The_340BPricewith$ = "$" + The_340BPrice_format;
			System.out.println("The_340BPricewith$" + The_340BPricewith$);

			verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='9']")).getText(),
					The_340BPricewith$, "The_340BPrice");
		}

		Thread.sleep(3000);
		String formatted_WACPriceWithComma = df.format(new BigDecimal(WACPrice));
		String Formatted_WACPricewith$ = "$" + formatted_WACPriceWithComma;
		System.out.println("Formatted_WACPricewith$: " + Formatted_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='10']")).getText(),
				Formatted_WACPricewith$, "WACPrice");
		Thread.sleep(3000);

		if (Drug_Strength_Volume.equalsIgnoreCase("0")) {
			String contractStrength = Drug_Strength_Number + Drug_Strength_Units;
			System.out.println("contractStrength" + contractStrength);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath(
							"//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
			Thread.sleep(3000);
			verifyExactContent(
					getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText()
							.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
					contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");
		} else {

			String contractStrength = Drug_Strength_Number + Drug_Strength_Units + "/ " + Drug_Strength_Volume
					+ Drug_Form_Code;
			System.out.println("contractStrength" + contractStrength);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath(
							"//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
			Thread.sleep(3000);
			verifyExactContent(
					getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText()
							.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
					contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");
		}

		// Total units
		// Total Units = Drug Strength Number * Units + Drug Strength Units

		BigDecimal a = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Units));
		System.out.println("a " + a);
		String totalUnits = a + " " + Drug_Strength_Units;
		System.out.println("totalUnits" + totalUnits);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Units']//span[contains(text(),'Total Units')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='12']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				totalUnits.toString().replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Total Units");

		// Total Cost
		// Total Cost = Total Units * Contract price.
		BigDecimal totalCost = a.multiply(new BigDecimal(ContractPrice));
		System.out.println("totalCost " + totalCost);
		String totalCostwith$ = "$" + totalCost;
		System.out.println("totalCostwith$" + totalCostwith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Cost']//span[contains(text(),'Total Cost')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='13']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				totalCostwith$.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Total Cost");

		Thread.sleep(3000);
		String ASPwith$ = "$" + ASP;
		System.out.println("ASPwith$" + ASPwith$);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='14']")).getText(),
				ASPwith$, "ASP");

		String ASPStrength = ASP_Drug_Strength_Number + ASP_Drug_Strength_Units;
		// + "/" + Drug_Form_Code;
		System.out.println("ASPStrength" + ASPStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='15']")).getText(),
				ASPStrength, "ASPStrength");

		return this;
	}

	public CalculatorPage verify_ContractStrength_ForSpecificNDCInIvigCalulatorPage(String Drug_Strength_Number,
			String Drug_Strength_Units, String Drug_Strength_Volume, String Drug_Form_Code)
			throws InterruptedException {

		Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);

		if (Drug_Strength_Volume.equalsIgnoreCase("0")) {
			String contractStrength = Drug_Strength_Number + Drug_Strength_Units;
			System.out.println("contractStrength" + contractStrength);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath(
							"//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
			Thread.sleep(3000);
			verifyExactContent(
					getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText()
							.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
					contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");
		} else {

			String contractStrength = Drug_Strength_Number + Drug_Strength_Units + "/ " + Drug_Strength_Volume
					+ Drug_Form_Code;
			System.out.println("contractStrength" + contractStrength);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath(
							"//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
			Thread.sleep(3000);
			verifyExactContent(
					getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText()
							.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
					contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");
		}
		return this;
	}

	public CalculatorPage verify_TwoNewColumns_InIvigCalulatorPage(String ContractPrice, String Drug_Strength_Number,
			String Drug_Strength_Units, String Units) throws InterruptedException {

		// Total units
		// Total Units = Drug Strength Number * Units + Drug Strength Units

		BigDecimal a = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Units));
		System.out.println("a " + a);
		String totalUnits = a + " " + Drug_Strength_Units;
		System.out.println("totalUnits" + totalUnits);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Units']//span[contains(text(),'Total Units')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='12']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				totalUnits.toString().replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Total Units");

		// Total Cost
		// Total Cost = Total Units * Contract price.
		BigDecimal totalCost = a.multiply(new BigDecimal(ContractPrice));
		System.out.println("totalCost " + totalCost);
		String totalCostwith$ = "$" + totalCost;
		System.out.println("totalCostwith$" + totalCostwith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Cost']//span[contains(text(),'Total Cost')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='13']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				totalCostwith$.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Total Cost");
		return this;
	}

	// Clicks on Column header based on the user input
	public CalculatorPage clickColumnHeader(String colName) throws InterruptedException {
		Thread.sleep(5000);

		WebElement targetElement = getDriver()
				.findElement(By.cssSelector("tr[class='k-table-row'][data-kendo-grid-row-index='1'] >th:nth-child(2)"));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(targetElement).perform();

		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("(//th//*[contains(text(),'" + colName + "')])[1]")), colName);
		Thread.sleep(5000);
		return this;
	}

	// Clicks on Column header based on the user input
	public CalculatorPage clickColumnHeaderForScrollableArea(String colName, String colNum)
			throws InterruptedException {
		Thread.sleep(5000);

		WebElement targetElement = getDriver().findElement(
				By.cssSelector("tr[class='k-table-row'][data-kendo-grid-row-index='1'] >th:nth-child(" + colNum + ")"));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(targetElement).perform();

		Thread.sleep(2000);
		actions.click().perform();
		Thread.sleep(5000);
		return this;
	}

	// Clicks on Column header based on the user input
	public CalculatorPage clickColumnHeaderForLockedColumns(String colName) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("//h3[contains(text(),'Medicare Part B Reimbursement Rate')]")));

		click(getDriver().findElement(By.xpath("(//th//*[contains(text(),'" + colName + "')])[1]")), colName);
		Thread.sleep(5000);
		return this;
	}

	// Clicks on Column header based on the user input
	public CalculatorPage clickColumnHeaderForScrollableArea2(String colName, String colNum)
			throws InterruptedException {
		Thread.sleep(5000);
		WebElement targetElement = getDriver().findElement(
				By.cssSelector("tr[class='k-table-row'][data-kendo-grid-row-index='3'] >th:nth-child(" + colNum + ")"));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(targetElement).perform();
		Thread.sleep(2000);
		actions.click().perform();
		Thread.sleep(5000);
		return this;
	}

	public CalculatorPage verifyIfSwitchFromOriginatorToBiosimilarTableIsAvailable()
			throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")),
				"Switch from Originator to Biosimilar and Save $$$");

		Thread.sleep(5000);
		return this;
	}
	
	public CalculatorPage verifyColumnHeaderForLockedColumnsInTable2(String colName) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		verifyDisplayed(getDriver().findElement(By.xpath(
				"//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::th//*[contains(text(),'"
						+ colName + "')]")),
				colName);
		Thread.sleep(5000);
		return this;
	}
	
	public CalculatorPage verifyColumnHeaderInTable2FirstSet(String colName) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		verifyDisplayed(getDriver().findElement(By.xpath(
				"(//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::th//*[contains(text(),'"
						+ colName + "')])[1]")),
				colName);
		Thread.sleep(5000);
		return this;
	}
	
	public CalculatorPage verifyColumnHeaderInTable2SecondSet(String colName) throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver().findElement(By
				.xpath("(//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::th//*[contains(text(),'"
						+ colName + "')])[2]")));
		
		verifyDisplayed(getDriver().findElement(By.xpath(
				"(//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::th//*[contains(text(),'"
						+ colName + "')])[2]")),
				colName);
		Thread.sleep(2000);
		return this;
	}
		
	// Clicks on Column header based on the user input
	public CalculatorPage clickColumnHeaderForLockedColumnsInTable2(String colName) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		click(getDriver().findElement(By.xpath(
				"//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::th//*[contains(text(),'"
						+ colName + "')]")),
				colName);
		Thread.sleep(5000);
		return this;
	}
	
	public CalculatorPage clickColumnHeaderInTable2FirstSet(String colName) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		click(getDriver().findElement(By.xpath(
				"(//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::th//*[contains(text(),'"
						+ colName + "')])[1]")),
				colName);
		Thread.sleep(5000);
		return this;
	}
	
	public CalculatorPage clickColumnHeaderInTable2SecondSet(String colName) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		click(getDriver().findElement(By.xpath(
				"(//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::th//*[contains(text(),'"
						+ colName + "')])[2]")),
				colName);
		Thread.sleep(5000);
		return this;
	}
	
	// Verify Sorting
	public CalculatorPage verifySortingForLockedColumn(String Col, String ColNum) throws InterruptedException {
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

	// Verify Sorting
	public CalculatorPage verifySortingForAllColumninTable2(String Col, String ColNum) throws InterruptedException {
		ArrayList<String> obtainedList = new ArrayList<>();
		String bReturn = null;
		int rowCount = getTableRowCount(
				getDriver().findElements(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::tr")),
				"Table");
		int exactRowCount=rowCount-3;
		System.out.println("row count" +rowCount);
		System.out.println("exact row count" +exactRowCount);
		for (int i = 4; i <= rowCount; i++) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::tr[" + (i)
							+ "]/td[" + ColNum + "]")));
			Thread.sleep(3000);
			bReturn = getDriver().findElement(By.xpath(
					"//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::tr[" + (i) + "]/td[" + ColNum + "]"))
					.getText();
			setReport().log(Status.PASS, bReturn + " is displayed in Row Num : " + (i), screenshotCapture());
			obtainedList.add(bReturn);

		}
		ArrayList<String> sortedList = new ArrayList<>();
		int listSize = obtainedList.size();
		System.out.println("Obtained list size" +listSize);
		for (int j = 1; j <= listSize; j++) {
			sortedList.add(obtainedList.get(j - 1));
		}

		for (int i = 1; i < exactRowCount; i++) {
			// compare(obtainedList.get(i), sortedList.get(i));
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
	public CalculatorPage verifySortingAlongWithNullValueCheckforOtherColumns(String Col, String ColNum)
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

		/*
		 * System.out.println("Obtained list***************************"); for (String
		 * printList1 : obtainedList) { System.out.println(printList1); }
		 */
		for (int i = 1; i < rowCount; i++) {
			compareValuesIncludingNull(obtainedList.get(i), sortedList.get(i));
		}

		/*
		 * System.out.println("Sorted list***************************"); for (String
		 * printList : sortedList) { System.out.println(printList); }
		 */
		Assert.assertTrue(sortedList.equals(obtainedList));
		setReport().log(Status.PASS, Col + " column is in Sorted order", screenshotCapture());
		Thread.sleep(5000);
		return this;
	}

	public CalculatorPage ZoomoutBrowser() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String zoomoutChrome = "document.body.style.zoom='85.0%'";
		js.executeScript(zoomoutChrome);
		return this;
	}
	public CalculatorPage search_FieldName_InDrugDashboardPage(String filterMenu, String fieldValue)
			throws InterruptedException {
	
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("//h3[contains(text(),'Medicare Part B Reimbursement Rate')]")));

		Thread.sleep(2000);
		WebElement targetElement = getDriver()
				.findElement(By.xpath("(//a[@title='" + filterMenu + " Filter Menu'])[1]"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", targetElement);

		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//input[@aria-label='" + filterMenu + " Filter'])[1]")).sendKeys(Keys.CLEAR);
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//input[@aria-label='" + filterMenu + " Filter'])[1]")), fieldValue,
				"Field Value");
		Thread.sleep(3000);
		//clickwithFieldName(getDriver().findElement(By.xpath("//button[@type='submit']")), "Submit button");
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
				getDriver().findElement(By.xpath("//button[@type='submit']")));

		Thread.sleep(3000);
		return this;
	}

	public CalculatorPage clearFilterResults(String filterMenu) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("//h3[contains(text(),'Medicare Part B Reimbursement Rate')]")));

		Thread.sleep(2000);
		//clickwithFieldName(getDriver().findElement(By.xpath("//a[@title='" + filterMenu + " Filter Menu']")), "Filter");
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
				getDriver().findElement(By.xpath("//a[@title='" + filterMenu + " Filter Menu']")));
		Thread.sleep(3000);
		//clickwithFieldName(getDriver().findElement(By.xpath("//button[@type='reset']")), "Reset button");
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
				getDriver().findElement(By.xpath("//button[@type='reset']")));

		
		Thread.sleep(3000);
		return this;
	}

	// Verify col wise values in the table after applying filter
	public CalculatorPage verifyColwiseFilterResults(String col, String filterResult) throws InterruptedException {
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

	// Verify col wise values in the table after applying filter
	public CalculatorPage verifyColwiseFilterResults_BiosimilarCalculator(String col, String filterResult)
			throws InterruptedException {
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("(//kendo-grid-list//tbody//tr)[1]")),
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

	public CalculatorPage verifyTableHeaders_IVIG_CalulatorPage_Non340B(String TradeNameHeader, String NDCHeader,
			String FormHeader, String AdjustedPackageSizeHeader, String PackageQuantityHeader, String GenericNameHeader, String LastUpdatedTimeHeader,
			String ContractPriceHeader, String ContractPriceTypeHeader, String The_340BPriceHeader,
			String WACPriceHeader, String ContractStrengthHeader, String TotalUnitsHeader, String TotalCostHeader,
			String ASPHeader, String ASPStrengthHeader, String ContractUnitsHeader, String ReimbursementHeader,
			String DifferentialHeader, String DifferentialPerUnitsHeader) throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Trade Name']//span[contains(text(),'Trade Name')]")),
				TradeNameHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'NDC')]")), NDCHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='Form']//span[contains(text(),'Form')]")),
				FormHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//*[@aria-label='Drug_Package_Size']//*[contains(text(),' Dose Per Vial ')]")),
				AdjustedPackageSizeHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Package Quantity']//span[contains(text(),'Package Quantity')]")),
				PackageQuantityHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Generic Name']//span[contains(text(),'Generic Name')]")),
				GenericNameHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")),
				LastUpdatedTimeHeader);
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")),
				ContractPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")),
				ContractPriceTypeHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='340B Price']//span[contains(text(),'340B Price')]")));
		Thread.sleep(3000);
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

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Units']//span[contains(text(),'Total Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Total Units']//span[contains(text(),'Total Units')]")),
				TotalUnitsHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Cost']//span[contains(text(),'Total Cost')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Total Cost']//span[contains(text(),'Total Cost')]")),
				TotalCostHeader);

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
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")),
				DifferentialPerUnitsHeader);

		return this;
	}

	public CalculatorPage verifyTableHeaders_IVIG_CalulatorPage_340B(String TradeNameHeader, String NDCHeader,
			String FormHeader, String AdjustedPackageSizeHeader, String PackageQuantityHeader, String GenericNameHeader,
			String LastUpdatedTimeHeader, String ContractPriceHeader, String ContractPriceTypeHeader,
			String The_340BPriceHeader, String WACPriceHeader, String ContractStrengthHeader, String TotalUnitsHeader,
			String TotalCostHeader, String ASPHeader, String ASPStrengthHeader, String ContractUnitsHeader,
			String ReimbursementHeader, String DifferentialHeader, String DifferentialPerUnitsHeader)
			throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Trade Name']//span[contains(text(),'Trade Name')]")),
				TradeNameHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'NDC')]")), NDCHeader);
		verifyDisplayed(getDriver().findElement(By.xpath("//th[@aria-label='Form']//span[contains(text(),'Form')]")),
				FormHeader);
		
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//*[@aria-label='Drug_Package_Size']//*[contains(text(),' Dose Per Vial ')]")),
				AdjustedPackageSizeHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Package Quantity']//span[contains(text(),'Package Quantity')]")),
				PackageQuantityHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Generic Name']//span[contains(text(),'Generic Name')]")),
				GenericNameHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")),
				LastUpdatedTimeHeader);
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("(//th[@aria-label='Contract Price']//span[contains(text(),'Contract Price')])[1]")),
				ContractPriceHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver().findElement(By.xpath(
						"//th[@aria-label='Contract Price Type']//span[contains(text(),'Contract Price Type')]")),
				ContractPriceTypeHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='340B Price']//span[contains(text(),'340B Price')]")));
		Thread.sleep(3000);
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

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Units']//span[contains(text(),'Total Units')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Total Units']//span[contains(text(),'Total Units')]")),
				TotalUnitsHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Cost']//span[contains(text(),'Total Cost')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Total Cost']//span[contains(text(),'Total Cost')]")),
				TotalCostHeader);

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
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
						By.xpath("//th[@aria-label='Contract Price']//span[contains(text(),'340B Price')]")));
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
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")),
				DifferentialHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")),
				DifferentialPerUnitsHeader);

		return this;
	}
	
	public CalculatorPage verifyTableValuesForSpecificNDCInIVIGCalulatorPage(String TradeName, String NDC, String Form,
			String PackageSize, String PackageQuantity, String GenericName, String CreatedOn, String ContractPrice,
			String ContractPriceType, String The_340BPrice, String WACPrice, String Drug_Strength_Number,
			String Drug_Strength_Units, String Drug_Strength_Volume, String Drug_Form_Code, String Units, String ASP,
			String ASP_Drug_Strength_Number, String ASP_Drug_Strength_Units, String Reimbursement,
			String Differential, String DifferentialPerUnits) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("#,##0.00");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='0']")).getText(),
				TradeName, "Trade Name");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='1']")).getText(), NDC,
				"NDC");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='2']")).getText(),
				Form, "Form");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='3']")).getText(),
				PackageSize, "PackageSize");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='4']")).getText(),
				PackageQuantity, "PackageQuantity");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='5']")).getText(),
				GenericName, "GenericName");

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Last Updated Time']//span[contains(text(),'Last Updated Time')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='6']"))
				.getAttribute("textContent"), CreatedOn, "Last Updated Time");

		Thread.sleep(3000);
		String formatted_ContractPriceWithComma = df.format(new BigDecimal(ContractPrice));
		String ContractPricewith$ = "$" + formatted_ContractPriceWithComma;
		System.out.println("ContractPricewith$: " + ContractPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='7']")).getText(),
				ContractPricewith$, "ContractPrice");

		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='8']")).getText(),
				ContractPriceType, "ContractPriceType");

		Thread.sleep(3000);
		String The_340BPrice_format = String.format("%.2f", new BigDecimal(The_340BPrice));
		// System.out.println(" The_340BPrice_format: " + The_340BPrice_format);
		String The_340BPricewith$ = "$" + The_340BPrice_format;
		System.out.println("The_340BPricewith$" + The_340BPricewith$);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='9']")).getText(),
				The_340BPricewith$, "The_340BPrice");

		Thread.sleep(3000);
		String formatted_WACPriceWithComma = df.format(new BigDecimal(WACPrice));
		String Formatted_WACPricewith$ = "$" + formatted_WACPriceWithComma;
		System.out.println("Formatted_WACPricewith$: " + Formatted_WACPricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("(//th[@aria-label='WAC Price']//span[contains(text(),'WAC Price')])[1]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='10']")).getText(),
				Formatted_WACPricewith$, "WACPrice");
		Thread.sleep(3000);

		String contractStrength = Drug_Strength_Number + Drug_Strength_Units + "/ " + Drug_Strength_Volume
				+ Drug_Form_Code;
		System.out.println("contractStrength" + contractStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(
				By.xpath("//th[@aria-label='Contract Strength']//span[contains(text(),'Contract Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='11']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				contractStrength.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Contract Strength");

		/*
		 * total Units calculation
		 */
		// Total units
		// Total Units = Drug Strength Number * Units + Drug Strength Units

		BigDecimal a = new BigDecimal(Drug_Strength_Number).multiply(new BigDecimal(Units));
		System.out.println("a " + a);
		String totalUnits = a + " " + Drug_Strength_Units;
		System.out.println("totalUnits" + totalUnits);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Units']//span[contains(text(),'Total Units')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='12']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				totalUnits.toString().replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Total Units");

		// Total Cost
		// Total Cost = Total Units * Contract price.
		BigDecimal totalCost = a.multiply(new BigDecimal(ContractPrice));
		System.out.println("totalCost " + totalCost);
		String totalCostwith$ = "$" + totalCost;
		System.out.println("totalCostwith$" + totalCostwith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Total Cost']//span[contains(text(),'Total Cost')]")));
		Thread.sleep(3000);
		verifyExactContent(
				getDriver().findElement(By.xpath("// td[@data-kendo-grid-column-index='13']")).getText()
						.replaceAll("\\s", "").replaceAll("\\p{P}", ""),
				totalCostwith$.replaceAll("\\s", "").replaceAll("\\p{P}", ""), "Total Cost");

		Thread.sleep(3000);
		String ASPwith$ = "$" + ASP;
		System.out.println("ASPwith$" + ASPwith$);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath("//th[@aria-label='ASP']//span[contains(text(),'ASP')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='14']")).getText(),
				ASPwith$, "ASP");

		String ASPStrength = ASP_Drug_Strength_Number + ASP_Drug_Strength_Units;
		// + "/" + Drug_Form_Code;
		System.out.println("ASPStrength" + ASPStrength);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='ASP Strength']//span[contains(text(),'ASP Strength')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='15']")).getText(),
				ASPStrength, "ASPStrength");

		Thread.sleep(3000);
		String formatted_Reimbursement_PriceWithComma = df.format(new BigDecimal(Reimbursement));
		String Reimbursement_Pricewith$ = "$" + formatted_Reimbursement_PriceWithComma;
		if (Reimbursement_Pricewith$.equalsIgnoreCase("$0.00")) {
			Reimbursement_Pricewith$ = "0";
		}
		System.out.println("Reimbursement_Pricewith$" + Reimbursement_Pricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Reimbursement']//span[contains(text(),'Reimbursement')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='16']")).getText(),
				Reimbursement_Pricewith$, "Reimbursement 2% Sequestration included");
		System.out.println("Reimbursement 2% Sequestration included" + getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='15']")).getText());
		
		Thread.sleep(3000);
		String formatted_Differential_PriceWithComma = df.format(new BigDecimal(Differential));
		String Differential_Pricewith$ = "$" + formatted_Differential_PriceWithComma;
		System.out.println("Differential_Pricewith$" + Differential_Pricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential']//span[contains(text(),'Revenue ')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='17']")).getText(),
				Differential_Pricewith$, "Revenue or Loss (+/-)");
		System.out.println("Revenue or Loss (+/-)" + getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='16']")).getText());
		
		Thread.sleep(3000);
		String formatted_DifferentialPerUnits_PriceWithComma = df
				.format(new BigDecimal(DifferentialPerUnits));
		String DifferentialPerUnits_Pricewith$ = "$" + formatted_DifferentialPerUnits_PriceWithComma;
		System.out.println("DifferentialPerUnits_Pricewith$" + DifferentialPerUnits_Pricewith$);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(By.xpath(
						"//th[@aria-label='MCP_ContractUnit_ContractPrice_Differential_Per_Quantity']//span[contains(@title,'Differential Contract Unit Per Units formula')]")));
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='18']")).getText(),
				DifferentialPerUnits_Pricewith$, "Revenue or Loss (+/-) Per Units");
		System.out.println("Revenue or Loss (+/-) Per Units" + getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='17']")).getText());
		
		return this;
	}
	
	public CalculatorPage search_FieldName_InTable2(String filterMenu, String fieldValue)
			throws InterruptedException {
	
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		Thread.sleep(2000);
		WebElement targetElement = getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::a[@title='" + filterMenu + " Filter Menu']"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", targetElement);

		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::input[@aria-label='" + filterMenu + " Filter'])[1]")).sendKeys(Keys.CLEAR);
		Thread.sleep(3000);
		WebElement e= getDriver().findElement(By.xpath("(//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::input[@aria-label='" + filterMenu + " Filter'])[1]"));
		type(e, fieldValue,"Field Value");
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
		a.moveToElement(e)
				.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		//clickwithFieldName(getDriver().findElement(By.xpath("//button[@type='submit']")), "Submit button");
		//Thread.sleep(3000);
		return this;
	}
	
	public CalculatorPage clearFilterResultsInTable2(String filterMenu) throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver()
				.findElement(By.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]")));

		Thread.sleep(2000);
		clickwithFieldName(getDriver().findElement(By.xpath(
				"//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::a[@title='"
						+ filterMenu + " Filter Menu']")),
				"Filter");
		Thread.sleep(3000);
		clickwithFieldName(getDriver().findElement(By.xpath("//button[@type='reset']")), "Reset button");
		Thread.sleep(3000);
		return this;
	}

	// Verify col wise values in the table after applying filter
	public CalculatorPage verifyColwiseFilterResults_BiosimilarCalculatorTable2(String col, String filterResult)
			throws InterruptedException {
		String bReturn = null;
		int rowCount = getTableRowCount(
				getDriver().findElements(By.xpath(
						"//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::tr")),
				"Table");
		int exactRowCount = rowCount - 3;
		System.out.println("row count" + rowCount);
		System.out.println("exact row count" + exactRowCount);
		for (int i = 4; i <= rowCount; i++) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getDriver().findElement(By.xpath(
							"//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::tr["
									+ (i) + "]/td[" + col + "]")));
			Thread.sleep(3000);
			bReturn = getDriver().findElement(By
					.xpath("//h4[contains(text(),'Switch from Originator to Biosimilar and Save $$$')]//following::tr["
							+ (i) + "]/td[" + col + "]"))
					.getText();
			if (bReturn.equalsIgnoreCase(filterResult)) {
				setReport().log(Status.PASS, bReturn + " is displayed in Row Num : " + (i) + " as expected",
						screenshotCapture());
			} else {
				setReport().log(Status.FAIL,
						"Expected result " + filterResult + " is not displayed in row number " + (i),
						screenshotCapture());
				Driver.failCount++;
			}
		}
		return this;
	}

}
