package ui.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TopNavigationPanel {
    private final SelenideElement navBar = $(By.id("navbarExample"));

    public void clickOn(String itemName) {
        navBar.shouldBe(Condition.visible);
        navBar.find(byText(itemName)).shouldBe(Condition.visible).click();
    }
}
