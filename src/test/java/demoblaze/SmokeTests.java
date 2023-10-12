package demoblaze;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import ui.pages.CartPage;
import ui.pages.HomePage;
import ui.pages.ProductPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.pages.components.ContactModal;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class SmokeTests {

    @BeforeAll
    public static void setBrowser() {
        WebDriverManager.chromedriver().setup();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @BeforeEach
    void setUp() {
//        Configuration.baseUrl = "https://www.demoblaze.com/";
//        open(Configuration.baseUrl);

    }

    @AfterEach
    void tearDown() {
        closeWindow();
    }

    @Test
    void testBuyingPhone() {
        HomePage homePage = new HomePage();
        homePage.selectProduct("Sony xperia z5");
        new ProductPage().productTitleIsDisplayed("Sony xperia z5").addToCart();

        homePage.topNavigationPanel.clickOn("Cart");
        new CartPage().validateNumberOfAddedItems(1);

    }

    @Test
    void sendContactMessage() {
        new HomePage().topNavigationPanel.clickOn("Contact");

        ContactModal contactModal = new ContactModal();
        contactModal.sendMessage("Krzysztof", "krzysztof@test.pl", "Test message");
        contactModal.isClosed();
    }
}