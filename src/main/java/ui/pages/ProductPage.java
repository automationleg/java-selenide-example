package ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private final SelenideElement productContent = $(By.className("product-content"));
    private final SelenideElement productTitle = $(By.className("name"));
    private final SelenideElement addToCartButton = $(By.cssSelector("a.btn")).shouldHave(text("Add to cart"));


    public ProductPage isDisplayed() {
        productContent.shouldBe(visible);
        return this;
    }

    public ProductPage productTitleIsDisplayed(String title) {
        productTitle.shouldHave(text(title)).shouldBe(visible);
        return this;
    }
    public ProductPage addToCart() {
        addToCartButton.click();
        return this;
    }
}
