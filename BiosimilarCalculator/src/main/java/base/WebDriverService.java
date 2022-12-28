package base;

import java.io.IOException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public interface WebDriverService {


	
	/**
	 * This method will locate the element using any given locator
	 * @param locator  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Innovatix QA - GAVS
	
	 * @throws NoSuchElementException - When no element matches the given locator and the value, you will get this exception
	 */
	public WebElement locateElement(String locator, String locValue) throws IOException ;	


	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 * @throws ElementNotVisibleException - Element not visible to interact 
	 */
	public void type(WebElement ele, String data,String field) throws IOException ;

	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void click(WebElement ele,String field) throws IOException;

	/**
	 * This method will get the text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public String getText(WebElement ele) throws IOException;

	/**
	 * This method will select the drop down visible text
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void selectDropDownUsingVisibleText(WebElement ele, String value,String field) throws IOException ;

	/**
	 * This method will select the drop down using value
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value attribute to be selected from the dropdown 
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) throws IOException ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param index The index to be selected from the dropdown 
	 * @author Innovatix QA - GAVS
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index,String field) throws IOException ;

	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * @author Innovatix QA - GAVS
	 * @return boolean - True if the title matches else Not.
	 * @throws IOException 
	 */
	public boolean verifyExactTitle(String expectedTitle) throws IOException;
	
	/**
	 * This method will verify browser actual title with expected text using contains
	 * @param title - The expected title of the browser
	 * @author Innovatix QA - GAVS
	 * @return boolean - True if the title matches partially else Not.
	 * @throws IOException 
	 */
	public boolean verifyPartialTitle(String expectedTitle) throws IOException;


	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void verifyExactText(WebElement ele, String expectedText,String field) throws IOException;

	/**
	 * This method will verify given text contains actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void verifyPartialText(WebElement ele, String expectedText,String field) throws IOException;

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void verifyExactAttribute(WebElement ele, String attribute, String value,String field) throws IOException;

	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void verifyPartialAttribute(WebElement ele, String attribute, String value,String field) throws IOException;

	/**
	 * This method will verify if the element (Radio button, Checkbox)  is selected
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void verifySelected(WebElement ele) throws IOException;

	/**
	 * This method will verify if the element is visible in the DOM
	 * @param ele   - The Webelement to be checked
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void verifyDisplayed(WebElement ele,String field) throws IOException;

	/**
	 * This method will switch to the Window of interest
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void switchToWindow(int index) throws IOException;

	/**
	 * This method will switch to the specific frame
	 * @param ele   - The Webelement (frame) to be switched
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void switchToFrame(WebElement ele) throws IOException;

	/**
	 * This method will accept the alert opened
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void acceptAlert() throws IOException;

	/**
	 * This method will dismiss the alert opened
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void dismissAlert() throws IOException;

	/**
	 * This method will return the text of the alert
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public String getAlertText() throws IOException;

	/**
	 * This method will close the active browser
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void closeActiveBrowser() throws IOException;		

	/**
	 * This method will close all the browsers
	 * @author Innovatix QA - GAVS
	 * @throws IOException 
	 */
	public void closeAllBrowsers() throws IOException;
	
	
	/**
	 * This method should wait for the loader to disappear (max time: 10 seconds)
	 * @author Innovatix QA
	 * @since July 7, 2020
	 * @exception
	 */
	
	public void waitForLoaderToDisapper();

}


