package serenityswag.inventory;

import java.util.function.IntPredicate;

import net.serenitybdd.core.pages.PageObject;

public class InventoryPage extends PageObject {

	public String getHeading() {

		String title = $(".title").getText();
		System.out.println(title);
		return title;
	}

}
