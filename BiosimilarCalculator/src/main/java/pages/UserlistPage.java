package pages;

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

public class UserlistPage extends WebDriverServiceImpl {

	public UserlistPage verifyColumnHeaders() throws InterruptedException {
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'User Name')]")), "User Name");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'User Email Address')]")),
				"User Email Address");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Manager Role')]")), "Manager Role");
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Admin Role')]")), "Admin Role");

		return this;
	}

	public UserlistPage verifyColwiseFilterResults(String col, String filterResult) throws InterruptedException {
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

	public UserlistPage verifyStartTextFilterResults(String col, String filterResult) throws InterruptedException {
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

	public UserlistPage verifyEndsWithTextFilterResults(String col, String filterResult) throws InterruptedException {
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

	public UserlistPage searchUserName_InUserListPage(String Name) throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("//input[@aria-label='User Name Filter']")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("//input[@aria-label='User Name Filter']")), Name, "UserName");
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='0']"))
				.getAttribute("textContent"), Name, "UserName");

		return this;
	}

	public UserlistPage searchUserName_WithStartsWithFilterOption(String Name) throws InterruptedException {
		Thread.sleep(3000);
		clickwithFieldName(
				getDriver().findElement(By.xpath(
						"//kendo-dropdownlist[@aria-label='Filter cell operators for User Name']//kendo-svgicon")),
				"Filter across username");
		for (int i = 0; i < 1; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.ENTER).build().perform();
		}

		Thread.sleep(7000);

		type(getDriver().findElement(By.xpath("//input[@aria-label='User Name Filter']")), Name, "UserName");
		Thread.sleep(10000);

		return this;
	}

	public UserlistPage searchUserEmailAddress_WithEndsWithFilterOption(String EmailAddress)
			throws InterruptedException {
		Thread.sleep(3000);
		clickwithFieldName(getDriver().findElement(By.xpath(
				"//kendo-dropdownlist[@aria-label='Filter cell operators for User Email Address']//kendo-svgicon")),
				"Filter across user email address");
		for (int i = 0; i < 1; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.ENTER).build().perform();
		}

		Thread.sleep(7000);

		type(getDriver().findElement(By.xpath("//input[@aria-label='User Email Address Filter']")), EmailAddress,
				"UserEmailAddress");
		Thread.sleep(10000);

		return this;
	}

	public UserlistPage searchUserEmailAddress_InUserListPage(String Email) throws InterruptedException {
		Thread.sleep(3000);
		type(getDriver().findElement(By.xpath("//input[@aria-label='User Email Address Filter']")), Email,
				"Email Address");
		Thread.sleep(3000);
		verifyExactContent(getDriver().findElement(By.xpath("//td[@data-kendo-grid-column-index='1']"))
				.getAttribute("textContent"), Email, "Email Address");

		return this;
	}

	public UserlistPage verifyListOfUserName(String col, String filterResult) throws InterruptedException {
		Thread.sleep(3000);
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {
			WebElement element = getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col + "]"));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			if (filterResult.contains(
					getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]//td[" + col + "]")).getText())) {
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

	public UserlistPage clickPage1Icon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Page 1']")), "Page 1 Icon");
		Thread.sleep(10000);
		return this;
	}

	public UserlistPage clickPage2Icon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Page 2']")), "Page 2 Icon");
		Thread.sleep(10000);
		return this;
	}

	public UserlistPage clickGoToPreviousPageIcon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Go to the previous page']")),
				"Go to the previous page Icon");
		Thread.sleep(10000);
		return this;
	}

	public UserlistPage clickGoToNextPageIcon() throws InterruptedException {
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//button[@title='Go to the next page']")), "Go to the next page Icon");
		Thread.sleep(10000);
		return this;
	}

	public UserlistPage verifyDefaultItemsPerPageCount() throws InterruptedException {
		Thread.sleep(5000);
		verifyDisplayed(getDriver().findElement(By.xpath("//kendo-pager-info[contains(text(),'1 - 15')]")),
				"Default Items Per page count");
		Thread.sleep(5000);
		return this;
	}

	public UserlistPage searchManagerRole_InUserListPage(String Col, String ColNum) throws InterruptedException {
		Thread.sleep(3000);
		String defaultText = getDriver()
				.findElement(By.xpath("//span[@aria-label='Boolean filter cell for Manager Role']"))
				.getAttribute("textContent");
		if(defaultText.equalsIgnoreCase("(All)"))
		{
		setReport().log(Status.PASS, defaultText + " is displayed by default in Manager Role dropdown ",
				screenshotCapture());
		}
		clickwithFieldName(
				getDriver().findElement(By.xpath("//span[@aria-label='Boolean filter cell for Manager Role']")),
				"Manager Role Filter");
		for (int i = 0; i < 1; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.ENTER).build().perform();
		}
		Thread.sleep(7000);
		isManagerRoleUnchecked(Col,ColNum);
		Thread.sleep(7000);
		return this;
	}

	public UserlistPage isManagerRoleUnchecked(String Col, String ColNum) throws InterruptedException {
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		for (int i = 1; i <= rowCount; i++) {
			if (!Boolean.valueOf(String
					.valueOf(getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]/td[" + ColNum + "]//input"))
							.getAttribute("checked")))) {
				setReport().log(Status.PASS, "Checkbox is unchecked as expected", screenshotCapture());
			}

		}
		return this;
	}
		
	public UserlistPage searchAdminRole_InUserListPage(String Col, String ColNum) throws InterruptedException {
		Thread.sleep(3000);
		String defaultText = getDriver()
				.findElement(By.xpath("//span[@aria-label='Boolean filter cell for Admin Role']"))
				.getAttribute("textContent");
		if(defaultText.equalsIgnoreCase("(All)"))
		{
		setReport().log(Status.PASS, defaultText + " is displayed by default in Admin Role dropdown ",
				screenshotCapture());
		}
		clickwithFieldName(
				getDriver().findElement(By.xpath("//span[@aria-label='Boolean filter cell for Admin Role']")),
				"Admin Role Filter");
		for (int i = 0; i < 1; i++) {
			Actions action1 = new Actions(getDriver());
			action1.sendKeys(Keys.DOWN).build().perform();
			action1.sendKeys(Keys.ENTER).build().perform();
		}
		Thread.sleep(7000);
		isAdminRoleChecked(Col,ColNum);
		Thread.sleep(7000);
		return this;
	}

	public UserlistPage isAdminRoleChecked(String Col, String ColNum) throws InterruptedException {
		Thread.sleep(7000);
		int rowCount = getTableRowCount(getDriver().findElements(By.xpath("//tbody//tr")), "Table");
		int i = 1;
		while (i <= rowCount) {
			if (Boolean.valueOf(String
					.valueOf(getDriver().findElement(By.xpath("//tbody//tr[" + (i) + "]/td[" + ColNum + "]//input"))
							.getAttribute("checked")))) {
				setReport().log(Status.PASS, "Checkbox is checked as expected", screenshotCapture());
			}
			i++;
		}
		return this;
	}

	public UserlistPage verifySearchFields_UserName_UserEmailAddress() throws InterruptedException {
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//input[@aria-label='User Name Filter']")),
				"User Name Filter");
		Thread.sleep(3000);
		verifyDisplayed(getDriver().findElement(By.xpath("//input[@aria-label='User Email Address Filter']")),
				"User Email Address Filter");
		Thread.sleep(3000);
		return this;
	}

	public UserlistPage clearFilterResults() throws InterruptedException {

		Thread.sleep(1000);
		clickwithFieldName(
				getDriver().findElement(
						By.xpath("//kendo-dropdownlist//following::button[@title='Clear']//kendo-svgicon")),
				"Clear Icon");
		Thread.sleep(10000);
		return this;
	}

	public UserlistPage verifySortingonAllColumns(String Col, String ColNum) throws InterruptedException {
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
	public UserlistPage clickColumnHeader(String colName) throws InterruptedException {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",
				getDriver().findElement(By.xpath("//th//span[contains(text(),'" + colName + "')]")));
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//th//span[contains(text(),'" + colName + "')]")), colName);
		Thread.sleep(10000);
		return this;
	}

	public UserlistPage verifySortingonCheckboxColumns(String Col, String ColNum) throws InterruptedException {
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

}
