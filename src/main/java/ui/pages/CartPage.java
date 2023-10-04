package ui.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private final SelenideElement placeOrderButton = $(By.xpath("//button[text()='Place Order']"));
    private final ElementsCollection itemsInCart = $$("table tbody tr");


    public CartPage isDisplayed() {
        placeOrderButton.should(appear);
        return this;
    }

    public void validateNumberOfAddedItems(int itemsCount) {
        itemsInCart.shouldHave(CollectionCondition.size(itemsCount));

    }


}
