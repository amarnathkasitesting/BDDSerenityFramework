package serenityswag.inventory;

import java.util.function.IntPredicate;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class productDetailsPageObject extends PageObject {



	public String productName() {
		return $(".inventory_item_name").getText();
	}

	public WebElementState productImageWithAltValueOf(String firstItemName) {
		
		return $(".inventory_details_container img[alt='"+ firstItemName + "']");
	}

}
