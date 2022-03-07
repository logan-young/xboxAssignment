package xboxbasepages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

public class XboxLeaderboardPage extends Page {
	
	
	//web elements
	@FindBy(xpath="(//div[@class=\"row\"]/*/*/div[@class=\"col-lg col-12\"]/a)[1]")
	public WebElement actualGamertag1;
	@FindBy(xpath="(//div[@class=\"row\"]/*/*/div[@class=\"col-lg col-12\"]/a)[2]")
	public WebElement actualGamertag2;
	@FindBy(xpath="(//div[@class=\"row\"]/*/*/div[@class=\"col-lg col-12\"]/a)[3]")
	public WebElement actualGamertag3;
	@FindBy(xpath="(//div[@class=\"row\"]/*/*/div[@class=\"col-lg col-12\"]/a)[4]")
	public WebElement actualGamertag4;
	@FindBy(xpath="(//div[@class=\"row\"]/*/*/div[@class=\"col-lg col-12\"]/a)[5]")
	public WebElement actualGamertag5;
	
	
	
	//open this page
	public XboxLeaderboardPage open() throws Exception {
		//read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_TC_01_LeaderboardTopFive.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("xbox.url.leaderboard");
		TestCaseBase.threadDriver.get().navigate().to(URL);
		return this;
	} public boolean getGamertags() {
		//System.out.println(gamertag1.getText());
		boolean result = true;
		
		//read the expected usernames from property file
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_TC_01_LeaderboardTopFive.properties");
		String user1 = PROPERTIES_RESOURCES.getProperty("gamer1");
		String user2 = PROPERTIES_RESOURCES.getProperty("gamer2");
		String user3 = PROPERTIES_RESOURCES.getProperty("gamer3");
		String user4 = PROPERTIES_RESOURCES.getProperty("gamer4");
		String user5 = PROPERTIES_RESOURCES.getProperty("gamer5"); 
		
		if (!user1.equals(actualGamertag1.getText())) {
			result = false;
			System.out.println("expected: " + user1 + " actual: " + actualGamertag1.getText() );
		}
		if (!user2.equals(actualGamertag2.getText())) {
			result = false;
			System.out.println("expected: " + user2 + " actual: " + actualGamertag2.getText() );
		}
		if (!user3.equals(actualGamertag3.getText())) {
			result = false;
			System.out.println("expected: " + user3 + " actual: " + actualGamertag3.getText() );
		}
		if (!user4.equals(actualGamertag4.getText())) {
			result = false;
			System.out.println("expected: " + user4 + " actual: " + actualGamertag4.getText() );
		}
		if (!user5.equals(actualGamertag5.getText())) {
			result = false;
			System.out.println("expected: " + user5 + " actual: " + actualGamertag5.getText() );
		} 
		System.out.println("expected: " + user1 + " actual: " + actualGamertag1.getText() );
		System.out.println("expected: " + user2 + " actual: " + actualGamertag2.getText() );
		System.out.println("expected: " + user3 + " actual: " + actualGamertag3.getText() );
		System.out.println("expected: " + user4 + " actual: " + actualGamertag4.getText() );
		System.out.println("expected: " + user5 + " actual: " + actualGamertag5.getText() );
		return result;
	} 
}

