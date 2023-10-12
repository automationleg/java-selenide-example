package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ui.pages.components.TopNavigationPanel;

import javax.lang.model.element.Element;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    public TopNavigationPanel topNavigationPanel;
    private final ElementsCollection itemCards = $$(By.className("card-title"));
    private final ElementsCollection categories = $$(By.className("list-group-item"));

    public HomePage() {
        this.topNavigationPanel = new TopNavigationPanel();
    }

    public HomePage open() {
        Selenide.open("https://www.demoblaze.com");
        return new HomePage();
    }

    public HomePage selectProduct(String name) {
        itemCards.findBy(Condition.text(name)).shouldBe(Condition.visible).click();
        return this;
    }

    public HomePage selectCategory(String category) {
        categories.findBy(Condition.text(category)).click();
        return this;
    }
}