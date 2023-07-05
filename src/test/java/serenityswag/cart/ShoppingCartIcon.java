package serenityswag.cart;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class ShoppingCartIcon extends PageObject{

	public String badgeCount() {
		
		return $(".shopping_cart_link").getText();
	}

	public By link()
	{
		return By.cssSelector(".shopping_cart_link");
	}
}
