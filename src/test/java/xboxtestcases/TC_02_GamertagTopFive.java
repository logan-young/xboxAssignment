package xboxtestcases;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestCaseBase;
import util.TestData;
import xboxbasepages.XboxGamertagSearchPage;
import xboxbasepages.XboxSearchResultsPage;
public class TC_02_GamertagTopFive extends TestCaseBase{
	
	@Test(groups = { "firefox", "ChromeWin32", "IEWin32"})
	public void validateUserTopFiveGames() throws Exception {
		String searchGamertag = TestData.get("gamertag");
		
		XboxGamertagSearchPage xboxGamertagSearchPage = new XboxGamertagSearchPage();
		xboxGamertagSearchPage.open();
		xboxGamertagSearchPage.waitPageLoad();
		XboxSearchResultsPage xboxSearchResultsPage = xboxGamertagSearchPage.search(searchGamertag);
		
		
		//maps to compare
		HashMap<String, String> actual = xboxSearchResultsPage.getFirstFiveGames();
		HashMap<String, String> expected = new HashMap<>();
		for(int i = 1; i < 6; i++) {
			String gameKey = Integer.toString(i);
			String propName = TestData.get(gameKey);
			expected.put(gameKey, propName);
		}
		
		Assert.assertEquals(expected, actual);
		
	}
}
