package services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import base.WebDriverService;
import driver.Driver;
import events.WebDriverEvents;

public class WebDriverServiceImpl extends WebDriverEvents implements WebDriverService{

	private ExtentTest reporter;
	public static String screenshotPath;
	static MediaEntityModelProvider img;
	//public static int failCount=0;
	public byte[] encodedPassword ;
	public String encodedData;
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public ExtentTest setReport()
	{
		this.reporter = Driver.test;
		return reporter;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static String getScreenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        screenshotPath = System.getProperty("user.dir") +"/Screenshots/"+java.time.LocalDate.now()+"/"+System.currentTimeMillis()+".png";
        File destination = new File(screenshotPath);
        FileUtils.copyFile(source, destination);  
        return screenshotPath;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static MediaEntityModelProvider screenshotCapture() 
	{
		try {
			img= MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build();	
		} catch (IOException e) {
			e.printStackTrace();
			Driver.failCount++;
		}
		return img;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public WebElement locateElement(String locator, String locValue)  {
		try {
			switch (locator) {
			case "id": return getDriver().findElement(By.id(locValue));
			case "name": return getDriver().findElement(By.name(locValue));
			case "class": return getDriver().findElement(By.className(locValue));
			case "link" : return getDriver().findElement(By.linkText(locValue));
			case "xpath": return getDriver().findElement(By.xpath(locValue));		
			default: break;
			}

		} catch (NoSuchElementException e) {
			setReport().log(Status.FAIL, "The element with locator "+locator+" not found ");
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while finding  "+locator+" with the value "+locValue);
			Driver.failCount++;
			throw e;
		}
		return null;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public WebElement locateElement(String locValue) {
		return getDriver().findElement(By.id(locValue));
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void type(WebElement ele, String data, String fieldName)  {
		try {
		
			ele.clear();
			ele.sendKeys(data);
			String sExpectedValue= ele.getAttribute("value");
		if (fieldName.equalsIgnoreCase("password"))
		{
			String data1=data;
			encodedPassword = Base64.getEncoder().encode(data1.getBytes());
			if (sExpectedValue.equalsIgnoreCase(data))
			{
				encodedData=new String(encodedPassword);
				setReport().log(Status.PASS, "The data: "+encodedData+" successfully entered in  "+fieldName+ " field",screenshotCapture());
			}
			else
			{
				setReport().log(Status.FAIL, "The data: "+encodedData+" is NOT entered in : "+fieldName,screenshotCapture());
				Driver.failCount++;
			}
		}
		else
		{
			if (sExpectedValue.equalsIgnoreCase(data))
			{
				setReport().log(Status.PASS, "The data: "+data+" successfully entered in  "+fieldName+ " field",screenshotCapture());
			}
			else
			{
				setReport().log(Status.FAIL, "The data: "+data+" is NOT entered in : "+fieldName,screenshotCapture());
				Driver.failCount++;
			}
		}
	
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+" could not be entered in  : "+fieldName, screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+" in "+fieldName, screenshotCapture());	
			Driver.failCount++;
			throw e;
		}
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	public void typeAndChoose(WebElement ele, String data,String field)  {
		try {
		//	ele.clear();
			ele.sendKeys(data, Keys.TAB);
			setReport().log(Status.PASS, "The data: "+data+" entered successfully in  :"+field,screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+" could not be entered in the field :"+field,screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+" in the field :"+field,screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void clickAndChoose(WebElement ele, String data, String field)  {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.valueOf(data));
			setReport().log(Status.PASS, "The data: "+data+"entered successfully in the field :"+field,screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+"could not be entered in the field :"+field,screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+"in the field :"+field);
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	public void typeAndEnter(WebElement ele, String data,String field) {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.ENTER);
			setReport().log(Status.PASS, "The data: "+data+" entered successfully in the field :"+field,screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+" could not be entered in the field :"+field,screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+" in the field :"+field,screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void click(WebElement ele,String field)  {
		try {
			//WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			ele.click();
			setReport().log(Status.PASS,"Clicked on "+field, screenshotCapture());	
		}
		catch (InvalidElementStateException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL,field+" could not be clicked", screenshotCapture());	
			Driver.failCount++;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field : "+field,screenshotCapture());	
			Driver.failCount++;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
	
	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();			
			//setReport().log(Status.PASS, text+" is clicked",screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, text+" could not be clicked",screenshotCapture());
			e.printStackTrace();
			Driver.failCount++;
			
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field : "+text,screenshotCapture());		
			e.printStackTrace();
			Driver.failCount++;
			throw e;
		} 
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getTextValue(WebElement ele, String field) {	
	String bReturn = "";
	try {
		
		bReturn = ele.getText();
		if(bReturn != null && !bReturn.isEmpty()){
			setReport().log(Status.PASS, bReturn+" is displayed in "+field,screenshotCapture());
		}
		else {
			setReport().log(Status.FAIL, bReturn+" is NOT displayed in "+field,screenshotCapture());
			Driver.failCount++;
		}
	} catch (WebDriverException e) {
		setReport().log(Status.FAIL, ele+"could not be found",screenshotCapture());
		Driver.failCount++;
		throw e;
	}
	return bReturn;
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public void scrollUp(WebElement ele) {
		String text = "";
		try {

			((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
		//	setReport().log(Status.PASS, text+" is clicked 3",screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, text+ " could not be clicked",screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field :"+text,screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  getDriver().getTitle();
			setReport().log(Status.PASS, "The Title: "+bReturn+" is displayed",screenshotCapture());	
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown Exception Occured While fetching Title",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
		return bReturn;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public String getAttribute(WebElement ele, String attribute,String field) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
			setReport().log(Status.PASS, bReturn+" is displayed in :"+field,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, ele+"could not be found",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
		return bReturn;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void selectDropDownUsingVisibleText(WebElement ele, String value,String field) {
		try {
			new Select(ele).selectByVisibleText(value);
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL,  field+" could not be found",screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void selectDropDownUsingIndex(WebElement ele, int index,String field) {
		try {
			new Select(ele).selectByIndex(index);
			setReport().log(Status.PASS, ele+" is selected with index "+index+"in "+field,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "The element: "+ele+"could not be found in "+field,screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public boolean verifyExactTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				setReport().log(Status.PASS, "The title of the page matches with the value : "+title,screenshotCapture());
				bReturn= true;
			}else {
				setReport().log(Status.FAIL, "The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title,screenshotCapture());
				Driver.failCount++;
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the title",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
		return bReturn;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public boolean verifyPartialTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().contains(title)) {
				setReport().log(Status.PASS, "The title of the page matches with the value : "+title,screenshotCapture());
				bReturn= true;
			}else {
				setReport().log(Status.FAIL, "The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title,screenshotCapture());
				Driver.failCount++;
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the title",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
		return bReturn;		
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void verifyExactText(WebElement ele, String expectedText,String field) {
		String bReturn=ele.getText();
		try {
			if(bReturn.equalsIgnoreCase(expectedText)) {
				setReport().log(Status.PASS, "The text :"+bReturn+" matches with the value in "+field+" field",screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The text :"+bReturn+" did not match with the value in "+field+" field",screenshotCapture());
				Driver.failCount++;
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the Text in "+field+" field",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void verifyPartialText(WebElement ele, String expectedText,String field) {
		String bReturn=ele.getText();
		String s=ele.getAttribute("title");
		try {
			if(bReturn.contains(expectedText)) {
				setReport().log(Status.PASS, "The "+field+" contains "+expectedText,screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The "+field+" does not contain "+expectedText,screenshotCapture());
				Driver.failCount++;
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the Text",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void verifyExactAttribute(WebElement ele, String attribute, String value,String field) {
		try {
			if(getAttribute(ele, attribute,field).equals(value)) {
				setReport().log(Status.PASS, "The "+field+ " contains "+ ": "+value,screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The "+field+ "doen not contains "+ ": "+value,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the attribute",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void verifyPartialAttribute(WebElement ele, String attribute, String value,String field) {
		try {
			if(getAttribute(ele, attribute,field).contains(value)) {
				setReport().log(Status.PASS, "The "+field+ " contains "+ ": "+value,screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The "+field+ "doen not contains "+ ": "+value,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the attribute",screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				setReport().log(Status.PASS, ele+" is selected",screenshotCapture());
			} else {
				setReport().log(Status.FAIL, ele+" is not selected",screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException : \"+e.getMessage()",screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void verifyDisplayed(WebElement ele,String field) {
		try {
			if(ele.isDisplayed()) {
				setReport().log(Status.PASS, field+" is displayed",screenshotCapture());
			} else {
				setReport().log(Status.FAIL, field+" is not displayed",screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException : \"+e.getMessage()",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = getDriver().getWindowHandles();
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			getDriver().switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			setReport().log(Status.FAIL, "The driver could not move to the given window by index "+index,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void switchToFrame(WebElement ele) {
		try {
			
			getDriver().switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void switchToDefaultContent() {
		try {
			getDriver().switchTo().defaultContent();
			//setReport().log(Status.PASS, "switch out to Default Content ",screenshotCapture());
		} catch (NoSuchFrameException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.accept();
			setReport().log(Status.PASS, "The alert "+ text+" is accepted",screenshotCapture());	
		} catch (NoAlertPresentException e) {
			setReport().log(Status.PASS, "There is no alert present",screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException "+e.getMessage(),screenshotCapture());
			Driver.failCount++;
			throw e;
		}  
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			setReport().log(Status.PASS, "The alert "+ text+" is dismissed",screenshotCapture());
		} catch (NoAlertPresentException e) {
			setReport().log(Status.PASS, "There is no alert present",screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException  "+e.getMessage(),screenshotCapture());
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			setReport().log(Status.FAIL, "There is no alert present",screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException "+e.getMessage(),screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
		return text;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void closeActiveBrowser() {
		try {
			getDriver().close();
			setReport().log(Status.PASS, "The browser is closed",screenshotCapture());
		} catch (Exception e) {
			setReport().log(Status.FAIL, "The browser could not be closed",screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void closeAllBrowsers() {
		try {
			getDriver().quit();
			setReport().log(Status.PASS, "The opened browsers are closed");
		} catch (Exception e) {
			setReport().log(Status.FAIL, "Unexpected error occured in Browser",screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			setReport().log(Status.PASS, "The dropdown "+ ele  +" is selected with text : "+value,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "The dropdown "+ele+ " could not be found",screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
	
	

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void scrollDown(WebElement ele) {
		String text = "";
		try {
			((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			//ele.click();	
			//setReport().log(Status.PASS, text+" is clicked 3",screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, text+ " could not be clicked",screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field :"+text,screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@Override
	public void waitForLoaderToDisapper() {
		// TODO Auto-generated method stub
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public String getText(WebElement ele) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void clearAndType(WebElement ele, String data,String field)  {
		try {
			//ele.clear();
			ele.sendKeys(Keys.BACK_SPACE);
			ele.sendKeys(data);		
			String sExpectedValue= ele.getAttribute("value");
			if (sExpectedValue.equalsIgnoreCase(data))
			{
				setReport().log(Status.PASS, "The data: "+data+" successfully entered in  "+field+ " field",screenshotCapture());
			}
			else
			{
				setReport().log(Status.FAIL, "The data: "+data+" is NOT entered in : "+field,screenshotCapture());
				Driver.failCount++;
			}
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+" could not be entered in  : "+field, screenshotCapture());
			Driver.failCount++;
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+" in "+field, screenshotCapture());
			Driver.failCount++;
			throw e;
		}
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void verifyIsEnabled(WebElement ele,String field) {
		boolean bReturn =true;
		bReturn=ele.isDisplayed();
		try {
			if(bReturn==false) {
				setReport().log(Status.PASS, "The "+field+" is enabled",screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The "+field+" is disabled",screenshotCapture());
				Driver.failCount++;
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the Text",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void verifyExactContent(String actualText, String expectedText,String field) {
		//String bReturn=ele.getText();
		try {
			if(actualText.equalsIgnoreCase(expectedText)) {
				setReport().log(Status.PASS, "The text :"+actualText+" matches with the value in "+field+" field",screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The text :"+actualText+" did not match with the value in "+field+" field",screenshotCapture());
				Driver.failCount++;
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the Text in "+field+" field",screenshotCapture());
			Driver.failCount++;
			throw e;
		} 
	}

	// Checks if the file is downloaded to the mentioned path
			public boolean isFileDownloaded(String downloadPath, String fileName) {
				File dir = new File(downloadPath);
				File[] dirContents = dir.listFiles();
				int i = 1;
				try {
					while (i < dirContents.length) {
						if (dirContents[i].getName().contains(fileName)) {
							setReport().log(Status.PASS, "The downloaded filename contains " + fileName + " as expected",
									screenshotCapture());
							 dirContents[i].delete();
							break;
						} else
							i++;
					}
				} catch (WebDriverException e) {
					setReport().log(Status.FAIL, "Unknown exception occured while verifying the Text", screenshotCapture());
					Driver.failCount++;
					throw e;
				}
				return false;
			}
}

