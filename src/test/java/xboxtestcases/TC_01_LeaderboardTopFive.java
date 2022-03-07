package xboxtestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestCaseBase;
import xboxbasepages.XboxLeaderboardPage;

public class TC_01_LeaderboardTopFive extends TestCaseBase {


		@Test(groups = { "firefox", "ChromeWin32", "IEWin32"})
		public void testGamertag() throws Exception {
		XboxLeaderboardPage XboxTopFive = new XboxLeaderboardPage();
		XboxTopFive.open();
		Assert.assertTrue(XboxTopFive.getGamertags());
		}
		
		
}
