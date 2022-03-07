package xboxbasepages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import AR_Impl.XboxHomePage;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

public class XboxGamertagSearchPage extends Page {
	
	@FindBy(className="form-inline my-2 my-lg-0")
	public WebElement pageLoad;
	
	@FindBy(name="s")
	public WebElement searchInput;
	
	
	
	//open this page
		public XboxGamertagSearchPage open() throws Exception {
			//read the url from property file
			Properties PROPERTIES_RESOURCES = SystemUtil
					.loadPropertiesResources("/testdata_xbox.properties");
			String URL = PROPERTIES_RESOURCES.getProperty("gamertaghome.url");
			TestCaseBase.threadDriver.get().navigate().to(URL);
			return this;
		}
	
		
		public XboxGamertagSearchPage waitPageLoad() throws InterruptedException {
			Waiting.implicitly(10);
			return this;
		}
		
		
		public XboxSearchResultsPage search(String searchTerm) throws Exception {
			searchInput.sendKeys(searchTerm);
			searchInput.submit();
			return new XboxSearchResultsPage();
		}

}



