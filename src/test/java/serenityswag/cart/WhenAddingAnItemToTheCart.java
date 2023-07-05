package serenityswag.cart;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import serenityswag.authentication.LoginActions;
import serenityswag.inventory.ProductList;


@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart{

@Managed(driver="firefox")
WebDriver driver;


@Steps
LoginActions login;

@Test
public void login()
{
	login.as(STANDARD_USER);
}

ShoppingCartIcon shoppingCartBadge;  // Static Locators

@Steps
CartActions cart;

@Test
public void theCorrectItemCountShouldBeShown()
{
	
	login.as(STANDARD_USER);
	
// Check that the Shopping cart badge is empty
	
	Serenity.reportThat("The shopping cart badge should be empty",() ->
	assertThat(shoppingCartBadge.badgeCount()).isEmpty());
	

// Add 1 item to the cart 
	cart.addItem("Sauce Labs Backpack");
	
//The Shopping cart badge should be "1"
	Serenity.reportThat("The shopping cart badge should now be '1'",() ->
	assertThat(shoppingCartBadge.badgeCount()).isEqualTo("1"));
	
	
	
	
}

ProductList productList;

@Test
public void allTheItemsShouldAppearInTheCart()
{
//Add several items to the cart
	
	List<String> selectedItems = firstThreeProductTitlesDisplayed();
	
	
// Open the cart page
	
	cart.addItems(selectedItems);
	
	String cartBadgeCount = Integer.toString(selectedItems.size());
	Serenity.reportThat("The shopping cart badge should now be " + selectedItems.size(),() ->
	assertThat(shoppingCartBadge.badgeCount()).isEqualTo(cartBadgeCount));

	cart.openCart();
	// should see all the items listed
	Serenity.reportThat("should see all the items listed ",() ->
	assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems));

}

private List<String> firstThreeProductTitlesDisplayed() {
	return productList.titles().subList(0, 2);
}


};