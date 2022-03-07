package AR_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;


public class XboxHomePage extends Page {
    	//some text which would be used as expected result
    	//this also could be move to a property file 
    	public static String TITLE="Xbox Leaderboards - Xbox Gamertag";
	    
	    	@FindAll({
	    		@FindBy(tagName="p")
	    	})
	    	
	    	public List<WebElement> GamerScores;
	    	public List<String> verifyGamerScores = new ArrayList<String>();
	    	
		//open this page
		public XboxHomePage open() throws Exception {
			//read the url from property file
			Properties PROPERTIES_RESOURCES = SystemUtil
					.loadPropertiesResources("/testdata_xbox.properties");
			String URL = PROPERTIES_RESOURCES.getProperty("xbox.url");
			TestCaseBase.threadDriver.get().navigate().to(URL);
			
			//return this means browser stays on XboxHomePage
			return this;
		}
		public XboxHomePage pagewaiting() throws InterruptedException {
			Waiting.implicitly(10);
			return this;
		}
		
		public boolean Top5GamerScore() {
			boolean result = true;
			Properties PROPERTIES_RESOURCES = SystemUtil
					.loadPropertiesResources("/testdata_xbox.properties");
			verifyGamerScores.add(PROPERTIES_RESOURCES.getProperty("xbox.top1"));
			verifyGamerScores.add(PROPERTIES_RESOURCES.getProperty("xbox.top2"));
			verifyGamerScores.add(PROPERTIES_RESOURCES.getProperty("xbox.top3"));
			verifyGamerScores.add(PROPERTIES_RESOURCES.getProperty("xbox.top4"));
			verifyGamerScores.add(PROPERTIES_RESOURCES.getProperty("xbox.top5"));
			System.out.println(verifyGamerScores);
			
			
			for(int i=0; i>5; i++) {
				WebElement x = GamerScores.get(i);
				String gamerscore = x.getText();
//				System.out.println(GamerScores + "this is webelement");
//				System.out.println(result);
				if(!gamerscore.equals(verifyGamerScores.get(i))) {
					result = false;
					break;
				}
				else if (gamerscore.equals(verifyGamerScores.get(i))) {
				result = true;
				break;
				}
				else {
					result = false;
					break;
					
				}
				
			}
			return result;
			
		}


}


