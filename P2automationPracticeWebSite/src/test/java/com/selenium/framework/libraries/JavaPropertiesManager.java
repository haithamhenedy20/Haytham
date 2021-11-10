package com.selenium.framework.libraries;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

////////PROPERTIES FILE :::: THIS IS NOT SELENIUM ITS JAVAAAAAA - TO BE TESTED WITH MAIN METHOD
///////before u go in hassle below , keep in mind that all this classs is about 3 major points:
//1- CREATE The properties file itself (in main method at the end of page).
//2-Create METHOD help to read from this file .
//3-Create METHOD help to write in this file.
//4-why prp file? to store parametes and data which will remain static during the project and pass it without change code
public class JavaPropertiesManager {
	
	
	final static Logger logger = Logger.getLogger(JavaPropertiesManager.class);
	//i think here he need to create properties file to give orders without play in the code
		private String propertiesFile; //attribute 4 u if u wanna read or write
		private Properties prop; //object to call whatever its a must -any object is null by default
		private FileInputStream input;//if we need 2 read
		private FileOutputStream output;//if we need 2 write

		//this constructor just 2 make condition that user passes correct file path with no mistakes
		//so if he pass null or 4get to pass with this if condition will stop test and if he pass right one then the constructor
		//will tell everybody in this class that this right input is equals to instance variable-->private String propertiesFile
		public JavaPropertiesManager(String propertiesFilePath) {
			try {
				if (propertiesFilePath.length() > 0) {
					propertiesFile = propertiesFilePath;
					prop = new Properties();
				}
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			}
		}
	////////READING METHOD ////////////////	
	//method 2 read the file u pass key - then method return u value
		public String readProperty(String key) {
			String value = null;
			try {
				//2 read u have 2 direct use/define ur temp input stream so creat object from it as shown here
				//& then pass file location 2 this input
				input = new FileInputStream(propertiesFile);
				//then after u define this input u have 2 load it by ur best friend the object of prop. so this step u pass the object which
				//have the the file path, so u loaded the whole file to comp memory
				prop.load(input);
				//once load done then only u can get value after u give the key
				value = prop.getProperty(key);
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			} finally {
				try {
					if (input != null) {//this finally just 2 clean ur objects u have 2 make sure that files on ur memory after read/write are closed to not give error when others use same files & inside finally put anuther try/catch so if close order not achieved test stop and through error
						input.close();
					}
				} catch (Exception e) {
					logger.error("Error: ", e);
					assertTrue(false);
				}
			}
			return value;
		}
		
		
	////////WRITTING METHOD ////////////////	
	//now in same class another method but to write and no return with write 4 sure & here i will pass the key and valkue 4 sure since iam the writer !
		public void setProperty(String key, String value) {
			try {
				output = new FileOutputStream(propertiesFile);
				prop.setProperty(key, value); //here setting property it will ask u whats ur key & ur value u wanna write ?!
				prop.store(output, null);//then will store it & will ask u 4 comment just pass null
				logger.info("Properties file created ---> " + propertiesFile);
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			} finally {
				try {
					if (output != null) {
						output.close();
					}
				} catch (Exception e) {
					logger.error("Error: ", e);
					assertTrue(false);
				}
			}

		}
		
	//now in same class another method but to write and no return with write 4 sure & here i will pass the key and value 4 sure PLUS COMMENT since iam the writer only difference here is this whole method just to add comments inside the LOG FILE TABLE !
		public void setProperty(String key, String value, String comments) {
			try {
				output = new FileOutputStream(propertiesFile);
				prop.setProperty(key, value);
				prop.store(output, comments);//Here is only difference i replaced NULL With ur needed comment
				logger.info("Properties file created ---> " + propertiesFile);
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			} finally {
				try {
					if (output != null) {
						output.close();
					}
				} catch (Exception e) {
					logger.error("Error: ", e);
					assertTrue(false);
				}
			}
		}
		
		//now since all this is java not selenium we did main method here to test all this code , here u created log file with this test and u can go there type in english browser =firefox and rerun ur test then ur test will run in firefox this time but i got lest between the enum and issues in base.
		//u just added in the page the the 'properties propreader object and passed the new log file u created then u called BROWSERTYPE which u already typed it by handin ur file then do ur search man its complicated!!
		public static void main(String[] args) {
			
			//good understanding :: using same object(myProperty)u will do 1 order to write (setProperty ) and another one to read(readProperty)
			JavaPropertiesManager myProperty = new JavaPropertiesManager("src/test/resources/config.properties");//this line to prepare creating new log file and u should pass the destination it will b created in src beside ur driver files go check there 
			myProperty.setProperty("browserType", "Chrome");
			//myProperty.setProperty("browserType", "FIREFOX");
			//myProperty.setProperty("demoMode", "Off", "Demo mode parameters: On, Off");
			
			String propValue = myProperty.readProperty("browserType");
			logger.info("value is: " + propValue);		
		}
		
	

}
