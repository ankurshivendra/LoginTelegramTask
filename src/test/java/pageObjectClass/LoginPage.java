package pageObjectClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTOLoginPage() {
		driver.get("https://dashboard.hubz.io/");
		String actualTitle = driver.getTitle();

		assertEquals("Hubz Onchain Chat Analytics", actualTitle);
	}

	public void ClickTelegramLoginBtn() throws InterruptedException {

		driver.switchTo().frame("telegram-login-hubz_dashboard_bot");
		Thread.sleep(1000);

		String currentID = driver.getWindowHandle();

		driver.findElement(By.xpath("//div[@id='widget_login']")).click();

		Set<String> windowID = driver.getWindowHandles();

		String[] w = windowID.toArray(new String[windowID.size()]);

		driver.switchTo().window(w[1]);

		driver.findElement(By.id("login-country-selected")).click();

		List<WebElement> name = driver.findElements(By.xpath("//div[@id='login-country-search-results'] // div"));
		for (WebElement element : name) {
			String Text = element.getText();
			if (Text.contains("Angola")) {
				element.click();
			}

		}

		driver.findElement(By.cssSelector("input#login-phone")).sendKeys("98989898");
		driver.findElement(By.xpath("//form[@id='send-form']/div[2]/button[1]/span[1]")).click();
		driver.switchTo().window(currentID);

	}

	public void dropdownselect() {

		List<WebElement> list = driver.findElements(By.xpath("(//div[@class='login_country_search_results'])/div"));

		for (WebElement ele : list) {
			String actualText = ele.getText();
			if (actualText.equals("Aruba")) {

				ele.click();
				break;
			}
		}
	}

	public void clickonnextbtn() {

		driver.findElement(By.xpath("(//button[@class='button-item ripple-handler']/span)[1]")).click();
	}

	public void LearnMoreAboutHubzText() {

		driver.findElement(By.xpath("//a[@class='ant-typography css-1vssx36']")).click();

	}

	public void tryhubznow() {
		Set<String> windowID = driver.getWindowHandles();

		String[] w = windowID.toArray(new String[windowID.size()]);

		driver.switchTo().window(w[1]);

		driver.findElement(By.xpath("(//a[@class='framer-Rjsyh framer-167jf0g framer-v-15saw9k framer-y74s5t'])[1]"))
				.click();
	}

}
