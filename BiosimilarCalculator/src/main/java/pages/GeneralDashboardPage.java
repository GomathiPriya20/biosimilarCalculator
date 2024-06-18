package pages;

import org.openqa.selenium.By;

import services.WebDriverServiceImpl;

public class GeneralDashboardPage extends WebDriverServiceImpl {

	/*
	 * Verify the header portion in the general dashboard page
	 */

	public GeneralDashboardPage verifyHeaderPortion(String home, String calculator, String drugsDashboard,String averageSalesPrice,String userlist, String welcomeText,
			String userName) {
		verifyDisplayed(getDriver().findElement(By.linkText("Home")), home);
		verifyDisplayed(getDriver().findElement(By.linkText("Calculator")), calculator);
		verifyDisplayed(getDriver().findElement(By.linkText("Drugs Dashboard")), drugsDashboard);
		verifyDisplayed(getDriver().findElement(By.linkText("Average Sales Price")), drugsDashboard);
		verifyDisplayed(getDriver().findElement(By.linkText("UserList")), userlist);
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

	public GeneralDashboardPage verifyCalculatorMenuOptions(String biosimilarCalculatorMenu,
			String IVIGcalculatorMenu) {
		verifyDisplayed(getDriver().findElement(By.xpath("//button[contains(text(),'Biosimilar Calculator')]")),
				biosimilarCalculatorMenu);
		verifyDisplayed(getDriver().findElement(By.xpath("//button[contains(text(),'IVIG Calculator')]")),
				IVIGcalculatorMenu);
		return this;
	}
	
	public GeneralDashboardPage clickCalculatorMenu() throws InterruptedException {
		click(getDriver().findElement(By.linkText("Calculator")), "Calculator Menu");
		Thread.sleep(10000);
		return this;
	}
	
	public GeneralDashboardPage clickBiosimilarCalculatorMenu() throws InterruptedException {
		click(getDriver().findElement(By.linkText("Biosimilar")), "Biosimilar Calculator Menu");
		Thread.sleep(10000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//div[@id='main']//h2[contains(text(),'Biosimilar Contract Advantage Calculator')]")),
				"Biosimilar Calculator Header");
		return this;
	}
	
	public GeneralDashboardPage clickIVIGCalculatorMenu() throws InterruptedException {
		click(getDriver().findElement(By.linkText("IVIG")), "IVIG Calculator Menu");
		Thread.sleep(10000);
		verifyDisplayed(
				getDriver().findElement(
						By.xpath("//div[@id='main']//h2[contains(text(),'IVIG Contract Advantage Calculator')]")),
				"IVIG Calculator Header");
		return this;
	}

	public DashboardPage clickDrugsDashboardMenu() throws InterruptedException {
		click(getDriver().findElement(By.linkText("Drugs Dashboard")), "Drugs Dashboard Menu");
		Thread.sleep(10000);
		verifyDisplayed(getDriver().findElement(By.xpath("//div[@id='main']//h2[contains(text(),'Drugs Dashboard')]")),
				"Drugs Dashboard Header");
		return new DashboardPage();
	}
	
	public UserlistPage clickUserlistMenu() throws InterruptedException {
		click(getDriver().findElement(By.linkText("UserList")), "UserList Menu");
		Thread.sleep(10000);
		verifyDisplayed(
				getDriver().findElement(By.xpath("//app-users-list//h1[contains(text(),'Users with their roles')]")),
				"User List Header");
		return new UserlistPage();
	}

}
