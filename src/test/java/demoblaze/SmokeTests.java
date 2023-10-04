package demoblaze;

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
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private ContactModal contactModal;

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
        open("https://www.demoblaze.com/");
        homePage = new HomePage();
    }

    @AfterEach
    void tearDown() {
        closeWindow();
    }

    @Test
    void testBuyingPhone() {
        homePage.selectProduct("Sony xperia z5");

        productPage = new ProductPage();
        productPage.isDisplayed();
        productPage.productTitleIsDisplayed("Sony xperia z5").addToCart();

        homePage.topNavigationPanel.clickOn("Cart");

        cartPage = new CartPage();
        cartPage.validateNumberOfAddedItems(1);

    }

    @Test
    void sendContactMessage() {
        homePage.topNavigationPanel.clickOn("Contact");

        contactModal = new ContactModal();
        contactModal.sendMessage("Krzysztof", "kramuk@test.pl", "Test message");
        contactModal.isClosed();
    }
}