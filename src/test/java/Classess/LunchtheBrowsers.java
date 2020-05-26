package Classess;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class LunchtheBrowsers {
	
	static WebDriver driver;
	
	public static void initApplication(String browser){
		
		
//		WebDriver driver = new ChromeDriver();
		
		if(browser.equals(System.getProperty("browser"))){
			
			System.setProperty("webdriver.chrome.driver", ".//exes//chromedriver.exe");
			
			driver=new ChromeDriver();
		}
		else{
			System.setProperty("webdriver.gecko.driver", ".//exes//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	@Test
	public void lunch()
	{
		initApplication("chrome");
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		//div/ul/li//div[starts-with(text(),'selenium')]	System.out.println(searchlist.size());
		for(int i = 0; i<searchlist.size();i++)
		{
			
			String searchlistvalue = searchlist.get(i).getText();
			System.out.println(searchlistvalue);
		}
		
		String xp = "//ul[@class='erkvQe']//li//span[starts-with(text(),'selenium')]";
		List<WebElement> searchlists = driver.findElements(By.xpath(xp));
		System.out.println(searchlists.size());
		for(int i = 0; i<searchlists.size();i++)
		{
			
			String searchlistvalue = searchlists.get(i).getText();
			System.out.println(searchlistvalue);
			if(searchlistvalue.contains("webdriver"))
			{
				searchlists.get(i).click();
				break;
			}
		}
		
		driver.navigate().to("https://www.selenium.dev/documentation/en/webdriver/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.quit();
		
	}
	
	@Test
	public void lunch11()
	{
		System.out.println("lunch1");
		
	}

	@Test
	public void lunch12()
	{
		System.out.println("lunch12");
		
	}
	
	@Test
	public void lunch13()
	{
		System.out.println("lunch13");
		
	}
	@Test
	public void lunch14()
	{
		System.out.println("lunch14");
		Assert.fail();
		
	}
}
