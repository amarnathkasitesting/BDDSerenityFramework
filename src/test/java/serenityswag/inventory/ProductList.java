package serenityswag.inventory;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.ResolvableElement;

public class ProductList extends PageObject{

	public static By productDeatilsLinkFor(String ItemName) {
		
		return By.linkText(ItemName);
		
	}

	public List<String> titles() {

		List<String> titleElements = findAll(By.className("inventory_item_name")).textContents();
		System.out.println(titleElements);
		return titleElements;

		// return findAll(".inventory_item_name").textContents();
	}

	public String imageTextForProduct(String productName) {
		
		return find(By.xpath(("//div[@class='inventory_item'][contains(.,'"+ productName + "')]//img"))).getAttribute("alt");
	}

	public static By addToCartButtonFor(String itemName) {
		
		return By.xpath("//div [@class='inventory_item'][contains(.,'"+ itemName +"')]//button");
	}



}
