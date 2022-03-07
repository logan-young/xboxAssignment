package xboxbasepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import util.Page;
import util.Waiting;

public class XboxSearchResultsPage extends Page {

	@FindBy(xpath=".//*[@class='game-card-desc']//h3/a")
	List<WebElement> gamehistory;

	
	public HashMap<String, String> getFirstFiveGames(){
		HashMap<String, String> gameDesc= new HashMap<>();
		
		for(int i=0; i<5; i++) {
			String name = gamehistory.get(i).getText();
			System.out.println(name);
			String key = Integer.toString(i+1);
			gameDesc.put(key, name);
		}		
		
		return gameDesc;
	}
	
	
	public XboxSearchResultsPage waitPageLoad() throws Exception{
		Waiting.implicitly(10);
		return this;
	}
}
