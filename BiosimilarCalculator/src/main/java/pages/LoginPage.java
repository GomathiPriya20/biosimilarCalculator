package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class LoginPage extends WebDriverServiceImpl{

	public LoginPage typeUsername(String username) {
		type(getDriver().findElement(By.id("identifier")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@value='Next']")),"Next");	
		return this;
	}
		
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(By.id("password")),password,"Password");
		return this;
	}

	public LoginPage clickSignIn() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//input[@value='Sign In']")),"Signin");	
		Thread.sleep(5000);
		return this;
	}
	
	public LoginPage closePopupOnDashboardPage() throws InterruptedException {
		click(getDriver().findElement(By.xpath("(//div[@id='root']//button)[6]")),"ClosePopup");	
		Thread.sleep(5000);
		return this;
	}
	
	public GeneralDashboardPage clickClinicalResourcesApplication(String calculatorPage) throws InterruptedException {
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Applications')]")),"Applications");	
		Thread.sleep(5000);
		scrollDown(getDriver().findElement(By.xpath("//div[contains(text(),'Biosimilar Calculator')]")));
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//div[contains(text(),'Biosimilar Calculator')]")),"Biosimilar Calculator");
		Thread.sleep(10000);
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));
		verifyExactContent(getDriver().getCurrentUrl(), calculatorPage, "calculatorPage Url");
		return new GeneralDashboardPage();
	}
}
