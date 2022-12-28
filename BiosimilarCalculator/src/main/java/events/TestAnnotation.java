package events;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import utils.DataInputProvider;
public class TestAnnotation implements IAnnotationTransformer{

	public static int iDriverTestCaseRowCount;
	public static Properties properties = new Properties();	
	public static int iTestCaseRowNumDriver;
	public static String sExcelFilePath;
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) { 		
		 try {
			properties.load(new FileInputStream(new File("./src/test/resources/environment.properties")));	
			//read excel file
			String sExcelFilePath=System.getProperty("user.dir")+"\\data\\"+properties.getProperty("DataFile");
			DataInputProvider.setExcelFile(sExcelFilePath,properties.getProperty("DriverSheetName"));
			iDriverTestCaseRowCount= DataInputProvider.getRowCount(properties.getProperty("DriverSheetName"));
	        annotation.setInvocationCount(iDriverTestCaseRowCount);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}				
	}
}