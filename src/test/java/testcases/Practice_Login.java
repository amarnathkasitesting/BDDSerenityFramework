package testcases;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;


@RunWith(SerenityRunner.class)
public class Practice_Login {

	@Managed(driver ="chrome")
	WebDriver driver;
	
		@Test
		@Title("Gamil Testing only")
		public void doLogin() {
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			driver.findElement(By.name("q")).sendKeys("Hello serenity");
			driver.manage().window().minimize();
			driver.quit();
			
		}
	
	
	
	
	
}
