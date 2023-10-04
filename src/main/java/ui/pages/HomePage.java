package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ui.pages.components.TopNavigationPanel;

import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    public TopNavigationPanel topNavigationPanel;
    private final ElementsCollection itemCards = $$(By.className("card-title"));

    public HomePage() {
        this.topNavigationPanel = new TopNavigationPanel();
    }

    public void selectProduct(String name) {
        itemCards.findBy(Condition.text(name)).click();
    }

}