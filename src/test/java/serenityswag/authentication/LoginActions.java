package serenityswag.authentication;

import org.openqa.selenium.By;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractionSteps {

	@Step("log in with {0} ")
	public void as(User user) {

		openUrl("https://www.saucedemo.com");

		$(LoginForm.USER_NAME).sendKeys(user.getUsername());
		$(LoginForm.PASSWORD).sendKeys(user.getPassword());
		$(LoginForm.LOGIN_BUTTON).click();

	}

}
