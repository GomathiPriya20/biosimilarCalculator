package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class LoginPage extends WebDriverServiceImpl{

	public LoginPage loginToApplication(String username, String password) throws InterruptedException {
		type(getDriver().findElement(By.id("identifier")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@value='Next']")),"Next");
		Thread.sleep(3000);
		type(getDriver().findElement(By.id("password")),password,"Password");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//input[@value='Sign In']")),"Signin");	
		Thread.sleep(5000);
		return this;
	}
	
	public LoginPage typeUsername(String username) throws InterruptedException {
		type(getDriver().findElement(By.id("identifier")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@value='Next']")),"Next");
		Thread.sleep(3000);
		return this;
	}
		
	public LoginPage typePassword(String password) throws InterruptedException {
		type(getDriver().findElement(By.id("password")),password,"Password");
		Thread.sleep(3000);
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
