package pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import services.WebDriverServiceImpl;
import utils.APIUtils;
import utils.JSONUtils;
import utils.SessionManager;

public class LoginPage extends WebDriverServiceImpl{

	public LoginPage loginToApplication(String username, String password) throws InterruptedException {
		/*type(getDriver().findElement(By.id("identifier")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@value='Next']")),"Next");
		Thread.sleep(3000);
		type(getDriver().findElement(By.id("password")),password,"Password");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//input[@value='Sign In']")),"Signin");	
		Thread.sleep(5000);*/
		type(getDriver().findElement(By.id("identifier")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@value='Next']")),"Next");
		Thread.sleep(3000);
		type(getDriver().findElement(By.name("loginfmt")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@type='submit']")),"Next");
		Thread.sleep(3000);

		try {
			type(((getDriver().findElement(By.name("passwd")))), password, "Password");
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
			Thread.sleep(10000);
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			type(((getDriver().findElement(By.name("passwd")))), password, "Password");
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
			Thread.sleep(10000);
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
		}
		return this;
	}
	
	@SuppressWarnings("deprecation")
	public LoginPage loginToApp(String username, String password) throws InterruptedException, IOException {
		type(getDriver().findElement(By.id("identifier")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@value='Next']")),"Next");
		Thread.sleep(3000);
		type(getDriver().findElement(By.name("loginfmt")),username,"Username");
		click(getDriver().findElement(By.xpath("//input[@type='submit']")),"Next");
		Thread.sleep(3000);

		try {
			type(((getDriver().findElement(By.name("passwd")))), password, "Password");
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
			Thread.sleep(10000);
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			type(((getDriver().findElement(By.name("passwd")))), password, "Password");
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
			Thread.sleep(10000);
			click(getDriver().findElement(By.id("idSIButton9")), "Sign in");
		}
		
		// Create a file to store Login Information  - use it for 1st time
		File file = new File("./src/test/resources/Cookiefile.data"); 
		
		//Store the cookie for 1st time 
		try{ 
		// Delete old file if already exists
		file.delete(); 
		file.createNewFile(); 
		FileWriter filew = new FileWriter(file); 
		BufferedWriter Bwritecookie = new BufferedWriter(filew); //Getting the cookie information 
		for(Cookie ck : getDriver().manage().getCookies()) {
		System.out.println("cookie details: " + "\nName: " + ck.getName() + "\nValue: " + ck.getValue()
							+ "\nDomain: " + ck.getDomain() + "\nPath: " + ck.getPath() + "\nExpiry: " + ck.getExpiry()
							+ "\nIsSecure: " + ck.isSecure());
		Bwritecookie.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure())); 
		Bwritecookie.newLine(); 
		} 
		Bwritecookie.close(); 
		filew.close(); 
		}
		catch(Exception ex) 
		{ 
		ex.printStackTrace(); 
		} 
	
		
		//Read cookie information - use from 2nd time
	/*	try{
			//File file = new File("Cookie.data");
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;
			while ((strline = Buffreader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(strline, ";");
				while (token.hasMoreTokens()) {
					String name = token.nextToken();
					String value = token.nextToken();
					String domain = token.nextToken();
					String path = token.nextToken();
					Date expiry = null;
					String val;
					if (!(val = token.nextToken()).equals("null")) {
						expiry = new Date(val);
					}
					@SuppressWarnings("removal")
					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					System.out.println("cookie details: " + "\nName: " + ck.getName() + "\nValue: " + ck.getValue()
							+ "\nDomain: " + ck.getDomain() + "\nPath: " + ck.getPath() + "\nExpiry: " + ck.getExpiry()
							+ "\nIsSecure: " + ck.isSecure());

					getDriver().manage().addCookie(ck);
				}
			} Buffreader.close();
			}catch(Exception ex){
			ex.printStackTrace();
			}
			getDriver().get("https://stage-acute-care-reimbursement-calculators.premierinc.com/calculators-dashboard");
			//type(getDriver().findElement(By.id("identifier")),username,"Username");
			//click(getDriver().findElement(By.xpath("//input[@value='Next']")),"Next");
			Thread.sleep(3000);
			
	*/
			
		/**
   		 * test code to store session information
   		 * 
   		 */
   	  // Get Cookies

       //SessionManager sessionManager = new SessionManager(getDriver());

        // Method 1:
       // sessionManager.storeSessionFile("biosimilar","Gomathipriya_nathan@premierinc.com");

        //sessionManager.usePreviousLoggedInSession("biosimilar");

        // Method 2:

        /* 
        // Completely bypass UI

        //  POST - https://stage-acute-care-reimbursement-calculators.premierinc.com/

        JSONObject payload = new JSONObject();
        payload.put("email","Gomathipriya_nathan@premierinc.com");
        payload.put("password","Welcome@0724");
        String Uri = "https://stage-acute-care-reimbursement-calculators.premierinc.com/calculators-dashboard";

        Map<String, String> cookies =  new APIUtils().postCallGetCookies(payload,Uri);

        sessionManager.byPassLoginUsingCookies(cookies,"https://stage-acute-care-reimbursement-calculators.premierinc.com/");
 */
        
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
