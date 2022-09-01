package Task;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TrelloTask {

	@Parameters({"Username","Password"})
	@Test
	public void ListAandB(String userid, String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Actions action= new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://trello.com/en");

	
		  
		    driver.findElement(By.xpath("//a[@class=\"Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr\"]")).click();
		    driver.findElement(By.id("user")).sendKeys(userid);


		    driver.findElement(By.id("login")).click();
		    driver.findElement(By.id("password")).sendKeys(password);
		    driver.findElement(By.id("login")).click();
		    driver.findElement(By.className("css-wxvfrp")).sendKeys(password);
		    driver.findElement(By.className("css-19r5em7")).click();



		    driver.findElement(By.xpath("//span[contains(text(),'Create new board')]")).click();
		    driver.findElement(By.cssSelector("input.Hj0IB7nx8rs7UO  ")).sendKeys("ListAandListB");
		    driver.findElement(By.xpath("//button[starts-with(text(),'Cre')]")).click();


		    driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("List A");
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
		    driver.findElement(By.cssSelector("span.js-add-a-card")).click();

		    WebElement cardA =driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"));
		    action.sendKeys("I am moving from A").sendKeys(Keys.ENTER).build().perform();


		    driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("List B");
		    driver.findElement(By.xpath("//input[@value='Add list']")).click();


		    WebElement From =driver.findElement(By.xpath("//span[contains(text(),'I am moving from A')]"));;
		    WebElement To =driver.findElement(By.xpath("//*[@id=\"board\"]/div[2]"));
		    action.pause(Duration.ofSeconds(5));
		    Thread.sleep(5000);
		    action.clickAndHold(From).pause(Duration.ofSeconds(5)).moveToElement(To).release(To).build().perform();


		    WebElement getXYofCard= driver.findElement(By.xpath("//span[contains(text(),'I am moving from A')]"));
		    Point xypoints=getXYofCard.getLocation();
		    int xValue = xypoints.getX();
		    int yValue= xypoints.getY();
		    System.out.println("The value of x is:"+xValue);
		    System.out.println("The value of y is:"+yValue);
		    driver.findElement(By.cssSelector("div.yRPuNUIoZpQWwj")).click();
		    driver.findElement(By.xpath("//button[@class='R2Zt2qKgQJtkYY'][@data-test-id='header-member-menu-logout']")).click();
		    driver.findElement(By.cssSelector("span.css-19r5em7")).click();

		
		    driver.quit();
	}
	
}




