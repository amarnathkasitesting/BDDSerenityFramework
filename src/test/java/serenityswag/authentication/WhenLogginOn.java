package serenityswag.authentication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import serenityswag.inventory.InventoryPage;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenLogginOn {

	@Managed
	WebDriver driver;

	@Steps
	LoginActions login;

	InventoryPage inventoryPage;

	@Test
	public void usersCanLoginViaHomePage() {

		login.as(STANDARD_USER);

		Serenity.reportThat("The inventory page should be displayed with the correct title",
				() -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products"));

	}

}
