package testCaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectClass.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	WebDriver driver;
	LoginPage LoginPage;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		LoginPage = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void any() {
		LoginPage.goTOLoginPage();
	}

	@Test(priority = 2)
	public void ClickTelegramLoginBtn() throws InterruptedException {
		LoginPage.ClickTelegramLoginBtn();
	}

	@Test(priority = 3, enabled = false)
	public void dropdownselect() {
		LoginPage.dropdownselect();

	}
		
	@Test (priority = 4)
		public void LearnMoreAboutHubzText(){
			LoginPage.LearnMoreAboutHubzText();
		}
	@Test(priority = 5)
	public void tryhubznow() {
		LoginPage.tryhubznow();
		
	}
}
      
