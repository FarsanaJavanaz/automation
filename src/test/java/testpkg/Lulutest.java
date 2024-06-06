package testpkg;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import basepkg.Baseclass;
import pagepkg.Lulupage;
import utilities.Utility;

public class Lulutest extends Baseclass
{
	Lulupage ob;
	@Test(priority=1)
	public void loginwithvalidcredentials() throws IOException
	{
		ob=new Lulupage(driver);
		String xl="C:\\Users\\i\\Desktop\\lulu.xlsx";
		String sheet="Sheet1";
		int rowcount=Utility.getrowcount(xl,sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String number=Utility.getcellvalues(xl, sheet, i, 0);
			System.out.println("number "+number);
			String passwords=Utility.getcellvalues(xl, sheet, i, 1);
			System.out.println("password="+passwords);
			ob.login(number, passwords);
		}	
	}
	@Test(enabled=false)
	public void logo()
	{
		boolean logo=driver.findElement(By.xpath("//*[@id=\\\"loginForm\\\"]/div[8]/button")).isDisplayed();
		if(logo)
		{
			System.out.println("logo is present");
		}
		else
		{
			System.out.println("logo is not present");
		}
	}
	@Test(enabled=false)
	public void contentverification()
	{
		String src=driver.getPageSource();
		if(src.contains("luluhypermarket "))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	@Test(enabled=false)
	public void responsecode() throws IOException
	{
		URL ob1=new URL(baseurl);
		HttpURLConnection con=(HttpURLConnection)ob1.openConnection();
		int responsecode=con.getResponseCode();
		System.out.println(responsecode);
	}
	@Test(enabled=false)
	public void brokenlinks() throws IOException
	{
		List<WebElement>li=driver.findElements(By.tagName("a"));
		System.out.println("total number of links: "+li.size());
		for(WebElement ele:li)
		{
			String link=ele.getAttribute("href");
			verifylink();
		}
	}
	private void verifylink() throws IOException {
		URL ob1=new URL(baseurl);
		HttpURLConnection con=(HttpURLConnection)ob1.openConnection();
		int responsecode=con.getResponseCode();
		if(responsecode==200)
		{
			System.out.println("succesfull links : "+baseurl);
		}
		else if(responsecode==404)
		{
			System.out.println("broken links: "+baseurl);
		}
		
	}
	@Test(enabled=false)
	public void buttontextvalidation()
	{
		//ob.button();
		WebElement butt=driver.findElement(By.id("homeDeliveryButton"));
		if(butt.getAttribute("id").equals("homeDeliveryButton"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
			
	}
	@Test(enabled=false)
	public void screenshot() throws IOException
	{
		WebElement button=driver.findElement(By.id("homeDeliveryButton"));
		File buttonscreenshot=button.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(buttonscreenshot, new File("/lulu/screenshot.png"));
	}
	@Test(priority=2,enabled=false)
	public void multiplewindowhandling() throws InterruptedException
	{
		Thread.sleep(2000);
		ob=new Lulupage(driver);
		System.out.println("windowhandling");
		String parentwindow=driver.getWindowHandle();
		System.out.println("parent window title"+driver.getTitle());
		ob.mulwindow();
		Set<String>allWindowHandlesSet=driver.getWindowHandles();
		for(String handle:allWindowHandlesSet)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
			}
		}
		
	}
	@Test
	public void mousehover()
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement electronics=driver.findElement(By.xpath("/html/body/main/header/section[2]/nav/div/div[1]/div[2]/div/ul/li[4]/a"));
		WebElement sound=driver.findElement(By.xpath("/html/body/main/header/section[2]/nav/div/div[1]/div[2]/div/ul/li[4]/div/div/div/div/div/div[3]/div[2]/ul/li[1]/span/a"));
	    Actions act=new Actions(driver);
	    act.moveToElement(electronics).perform();
	    sound.click();
	    
	
	}

	

}
