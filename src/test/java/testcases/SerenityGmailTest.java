
package testcases;



import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class SerenityGmailTest extends PageObject{
	
	
	
	@Managed(driver = "chrome")
	WebDriver driver;
	
	
	
	@Title("Executing Login Test")
	@Test
	public void doLogin() {
		
		
		driver.get("http://www.gmail.com");
		
			}

}
