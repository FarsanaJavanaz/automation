package pagepkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lulupage {
	
    ChromeDriver driver;
	
	@FindBy(id="emailAddress")
	WebElement  emailid;
	
	@FindBy(id="j_password")
	WebElement  password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div[8]/button")
	WebElement login ;
	
	@FindBy(xpath="//*[@id=\"footer\"]/section[2]/div/div/div[1]/ul[2]/li[3]/a/svg")
	WebElement  instagram;
	
	/*@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;
	
	@FindBy(="")
	WebElement  ;*/
	
public Lulupage(ChromeDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void login(String number, String passwords)
{

emailid.sendKeys(number);
password.sendKeys(passwords);
login.click();
}
public void mulwindow()
{
	instagram.click();
}
}














