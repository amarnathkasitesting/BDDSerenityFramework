package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class viewProductDetailsActions extends UIInteractionSteps{

	
	//ProductListPageObject productList;

	
	@Step("View product details for product {0}")
	public void forProductWithName(String firstItemName) {
		
$(ProductList.productDeatilsLinkFor(firstItemName)).click();

	}

}
