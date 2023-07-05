package serenityswag.inventory;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import serenityswag.authentication.LoginActions;

@RunWith(SerenityRunner.class)
public class WhenViewingHighligthedProducts {

	@Managed
	WebDriver driver;

	@Steps
	LoginActions login;

	@Steps
	viewProductDetailsActions viewProductDetails;
	
	ProductList productList;

	productDetailsPageObject productDetails;

	@Test
	public void shouldDisplayHighlightedProoductsOnWelcomePage() {
		login.as(STANDARD_USER);

		List<String> productsOnDisplay = productList.titles();

		System.out.println(productsOnDisplay.size());
		assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack");

	}

	@Test
	public void shouldDisplayCorrectProductsDisplayPage() {
		login.as(STANDARD_USER);
		
		String firstItemName = productList.titles().get(0);

		//productList.openProductDetailsFor(firstItemName);
		
		viewProductDetails.forProductWithName(firstItemName);
		
		
		
		Serenity.reportThat("The product name should be correctly Displayed", () ->
		assertThat(productDetails.productName()).isEqualTo(firstItemName));
		
		Serenity.reportThat("The Product Image should have the correct alt text", () ->
		productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible());

	}

	@Test
	public void highLightedProductsShouldDisplayCorrespondingImages() {
		login.as(STANDARD_USER);

		List<String> productsOnDisplay = productList.titles();

		SoftAssertions softly = new SoftAssertions();
		productsOnDisplay.forEach(
				productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName));

		softly.assertAll();

	}

}


