package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import driver.Driver;
import services.WebDriverServiceImpl;

public class AverageSalesPrice extends WebDriverServiceImpl {

	public AverageSalesPrice verifyColwiseFilterResults(String col, String filterResult) throws InterruptedException {
		Thread.sleep(3000);
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {

			if (getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col + "]")).getText()
					.equalsIgnoreCase(filterResult)) {
				setReport().log(Status.PASS, "Search results are displayed as expected", screenshotCapture());
			} else {
				setReport().log(Status.FAIL, "Search results are not displayed as expected", screenshotCapture());
				Driver.failCount++;
			}
		}

		return this;
	}

	public AverageSalesPrice verifySelectFilesButton() {
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),' Select files... ')]")),
				"Select files button");
		verifyDisplayed(getDriver().findElement(By.xpath("//div[contains(text(),'Drop files here to upload')]")),
				"Drop files here to upload text");

		return this;
	}

	public AverageSalesPrice verifyStartTextFilterResults(String col, String filterResult) throws InterruptedException {
		Thread.sleep(3000);
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {

			if (getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col + "]")).getText()
					.startsWith(filterResult)) {
				setReport().log(Status.PASS,
						"Search result " + getDriver()
								.findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col + "]")).getText()
								+ " is displayed as expected",
						screenshotCapture());
			} else {
				setReport().log(Status.FAIL, "Search results are not displayed as expected", screenshotCapture());
				Driver.failCount++;
			}
		}
		return this;
	}

	public AverageSalesPrice verifyEndsWithTextFilterResults(String col, String filterResult)
			throws InterruptedException {
		Thread.sleep(3000);
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {

			if (getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col + "]")).getText()
					.endsWith(filterResult)) {
				setReport().log(Status.PASS,
						"Search result " + getDriver()
								.findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col + "]")).getText()
								+ " is displayed as expected",
						screenshotCapture());
			} else {
				setReport().log(Status.FAIL, "Search results are not displayed as expected", screenshotCapture());
				Driver.failCount++;
			}
		}
		return this;
	}

	public AverageSalesPrice searchHCPCScode_InAverageSalesPricePage(String HCPCScode) throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("(//input[@aria-label='HCPCS_Code Filter'])[1]")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//input[@aria-label='HCPCS_Code Filter'])[1]")), HCPCScode,
				"HCPCScode");
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='0']"))
				.getAttribute("textContent"), HCPCScode, "HCPCScode");

		return this;
	}

	public AverageSalesPrice searchHCPCScode_WithStartsWithFilterOption(String HCPCScode) throws InterruptedException {
		Thread.sleep(3000);
		clickwithFieldName(getDriver().findElement(By.xpath("//a[@title='HCPCS_Code Filter Menu']//kendo-svgicon")),
				"Filter across HCPCScode");
		for (int i = 0; i < 1; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.ENTER).build().perform();
		}

		Thread.sleep(7000);

		type(getDriver().findElement(By.xpath("(//input[@aria-label='HCPCS_Code Filter'])[1]")), HCPCScode,
				"HCPCScode");
		Thread.sleep(10000);

		return this;
	}

	public AverageSalesPrice searchShortDescription_WithEndsWithFilterOption(String ShortDescription)
			throws InterruptedException {
		Thread.sleep(3000);
		clickwithFieldName(
				getDriver().findElement(By.xpath("//a[@title='Short Description Filter Menu']//kendo-svgicon")),
				"Filter across Short Description");
		for (int i = 0; i < 1; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.ENTER).build().perform();
		}

		Thread.sleep(7000);

		type(getDriver().findElement(By.xpath("(//input[@aria-label='Short Description Filter'])[1]")),
				ShortDescription, "ShortDescription");
		Thread.sleep(10000);

		return this;
	}

	public AverageSalesPrice searchShortDescription_InAverageSalesPricePage(String ShortDescription)
			throws InterruptedException {
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("(//input[@aria-label='Short Description Filter'])[1]")),
				ShortDescription, "ShortDescription");
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='1']"))
				.getAttribute("textContent"), ShortDescription, "ShortDescription");

		return this;
	}

	/*
	 * public AverageSalesPrice verifyListOfUserName(String col, String
	 * filterResult) throws InterruptedException { Thread.sleep(3000); int rowCount
	 * = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")),
	 * "Table"); for (int i = 1; i <= rowCount; i++) { WebElement element =
	 * getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col +
	 * "]")); ((JavascriptExecutor)
	 * getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	 * Thread.sleep(3000); if (filterResult.contains(
	 * getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col +
	 * "]")).getText())) { setReport().log(Status.PASS, "Search result " +
	 * getDriver() .findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col +
	 * "]")).getText() + " is displayed as expected", screenshotCapture()); } else {
	 * setReport().log(Status.FAIL, "Search results are not displayed as expected",
	 * screenshotCapture()); Driver.failCount++; } } return this; }
	 */
	public AverageSalesPrice clickPage1Icon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Page 1']")), "Page 1 Icon");
		Thread.sleep(10000);
		return this;
	}

	public AverageSalesPrice clickPage2Icon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Page 2']")), "Page 2 Icon");
		Thread.sleep(10000);
		return this;
	}

	public AverageSalesPrice clickGoToPreviousPageIcon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Go to the previous page']")),
				"Go to the previous page Icon");
		Thread.sleep(10000);
		return this;
	}

	public AverageSalesPrice clickGoToNextPageIcon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Go to the next page']")), "Go to the next page Icon");
		Thread.sleep(10000);
		return this;
	}

	public AverageSalesPrice verifyDefaultItemsPerPageCount() throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(getDriver().findElement(By.xpath("//kendo-pager-info[contains(text(),'1 - 100')]")),
				"Default Items Per page count");
		Thread.sleep(5000);
		return this;
	}

	public AverageSalesPrice clearFilterResults() throws InterruptedException {

		Thread.sleep(1000);
		clickwithFieldName(getDriver().findElement(By.xpath("//a//following::button[@type='reset']")), "Clear Icon");
		Thread.sleep(10000);
		return this;
	}

	public AverageSalesPrice verifySortingonAllColumns(String Col, String ColNum) throws InterruptedException {
		ArrayList<String> obtainedList = new ArrayList<>();
		String bReturn = null;
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {
			bReturn = getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]/td[" + ColNum + "]")).getText();
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

	// Clicks on Column header based on the user input
	public AverageSalesPrice clickColumnHeader(String colName) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("//th//span[contains(text(),'" + colName + "')]")));
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//th//span[contains(text(),'" + colName + "')]")), colName);
		Thread.sleep(10000);
		return this;
	}

	public AverageSalesPrice verifySortingonCheckboxColumns(String Col, String ColNum) throws InterruptedException {
		ArrayList<String> obtainedList = new ArrayList<>();
		String bReturn = null;
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {
			bReturn = String
					.valueOf(getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]/td[" + ColNum + "]//input"))
							.getAttribute("checked"));
			obtainedList.add(bReturn);

		}
		ArrayList<String> sortedList = new ArrayList<>();
		int listSize = obtainedList.size();
		for (int j = 1; j <= listSize; j++) {
			sortedList.add(obtainedList.get(j - 1));
		}

		for (int i = 1; i < rowCount; i++) {
			compareValuesForCheckboxEntries(obtainedList.get(i), sortedList.get(i));
		}

		Assert.assertTrue(sortedList.equals(obtainedList));
		setReport().log(Status.PASS, Col + " column is in Sorted order", screenshotCapture());
		Thread.sleep(5000);
		return this;
	}

	// Function to bring null values at top during ascending sort
	public int compareValuesForCheckboxEntries(String Val1, String Val2) {
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

	public AverageSalesPrice verifyTableHeadersInAverageSalesPricePage(String HCPCS_CodeHeader,
			String ShortDescriptionHeader, String HCPCSCodeDosageHeader, String ASPDrugStrengthNumberHeader,
			String ASPDrugStrengthUnitsHeader, String Payment_LimitHeader, String CreatedOnHeader,
			String CreatedByHeader) throws InterruptedException {

		Thread.sleep(5000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='HCPCS_Code']//span[contains(text(),'HCPCS_Code')]")),
				HCPCS_CodeHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Short Description']//span[contains(text(),'Short Description')]")),
				ShortDescriptionHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='HCPCS Code Dosage']//span[contains(text(),'HCPCS Code Dosage')]")),
				HCPCSCodeDosageHeader);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='ASP Drug Strength Number']//span[contains(text(),'ASP Drug Strength Number')]")),
				ASPDrugStrengthNumberHeader);
		verifyDisplayed(getDriver().findElement(By.xpath(
				"//th[@aria-label='ASP Drug Strength Units']//span[contains(text(),'ASP Drug Strength Units')]")),
				ASPDrugStrengthUnitsHeader);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//th[@aria-label='Payment_Limit']//span[contains(text(),'Payment_Limit')]")),
				Payment_LimitHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Created On']//span[contains(text(),'Created On')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Created On']//span[contains(text(),'Created On')]")),
				CreatedOnHeader);

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver()
				.findElement(By.xpath("//th[@aria-label='Created By']//span[contains(text(),'Created By')]")));
		Thread.sleep(3000);
		verifyDisplayed(
				getDriver()
						.findElement(By.xpath("//th[@aria-label='Created By']//span[contains(text(),'Created By')]")),
				CreatedByHeader);

		return this;
	}

}
