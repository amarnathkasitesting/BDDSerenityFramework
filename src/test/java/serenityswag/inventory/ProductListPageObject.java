package serenityswag.inventory;

import java.util.List;
import java.util.function.IntPredicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class ProductListPageObject extends PageObject {


	public void openProductDetailsFor(String ItemName) {
		find(By.linkText(ItemName)).getText();
		
		

	}


}
