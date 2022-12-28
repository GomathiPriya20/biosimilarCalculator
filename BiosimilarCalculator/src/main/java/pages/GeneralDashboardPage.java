package pages;

import org.openqa.selenium.By;

import services.WebDriverServiceImpl;

public class GeneralDashboardPage extends WebDriverServiceImpl {

	/*
	 * Verify the header portion in the general dashboard page
	 */

	public GeneralDashboardPage verifyHeaderPortion(String calculator, String drugsDashboard, String welcomeText,
			String userName) {
		verifyDisplayed(getDriver().findElement(By.linkText("Calculator")), calculator);
		verifyDisplayed(getDriver().findElement(By.linkText("Drugs Dashboard")), drugsDashboard);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),'Welcome, ')]")), welcomeText);
		verifyDisplayed(getDriver().findElement(By.xpath("//span[contains(text(),' " + userName + "')]")), userName);

		return this;
	}

	/*
	 * Click Premier logo on top left
	 */

	public GeneralDashboardPage clickPremierLogo() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//img[@alt='Premier logo']")), "Premier Logo");
		Thread.sleep(10000);
		return this;
	}

	/*
	 * Validate if Premier page is getting loaded
	 */

	public GeneralDashboardPage verifyPremierPage(String PremierURL) throws InterruptedException {
		verifyExactContent(getDriver().getCurrentUrl(), PremierURL, "Premier URL");
		Thread.sleep(5000);
		getDriver().navigate().back();
		Thread.sleep(5000);
		return this;
	}

	public GeneralDashboardPage clickCalculatorMenu() throws InterruptedException {
		click(getDriver().findElement(By.linkText("Calculator")), "Calculator Menu");
		Thread.sleep(10000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//div[@id='main']//h2[contains(text(),'Biosimilar Contract Advantage Calculator')]")),
				"Calculator Header");
		return this;
	}

	public DashboardPage clickDrugsDashboardMenu() throws InterruptedException {
		click(getDriver().findElement(By.linkText("Drugs Dashboard")), "Drugs Dashboard Menu");
		Thread.sleep(10000);
		verifyDisplayed(getDriver().findElement(By.xpath("//div[@id='main']//h2[contains(text(),'Drugs Dashboard')]")),
				"Drugs Dashboard Header");
		return new DashboardPage();
	}

}
