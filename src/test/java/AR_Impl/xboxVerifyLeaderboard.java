package AR_Impl;



import org.testng.Assert;
import org.testng.annotations.Test;

import util.TestCaseBase;

public class xboxVerifyLeaderboard extends TestCaseBase {

	@Test
	public void open() throws Exception {
		XboxHomePage leaderboard = new XboxHomePage();
		
		leaderboard.open();
		leaderboard.pagewaiting();
//		Assert.assertTrue(leaderboard.titleIs(XboxHomePage.TITLE));
		Assert.assertTrue(leaderboard.Top5GamerScore());
		System.out.println(leaderboard.Top5GamerScore());
	}
}
