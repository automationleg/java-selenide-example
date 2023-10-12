import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.CartPage;
import ui.pages.HomePage;
import ui.pages.ProductPage;

public class DemoBlazeStepDefinitions {
    private HomePage homePage;

    public DemoBlazeStepDefinitions() {
        homePage = Selenide.page(HomePage.class);
    }
    @Given("Browser open with page www.demoblaze.com")
    public void openUrl() {
        homePage.open();
    }
    @When("Select product {string} from product card")
    public void selectProduct(String product_name) {
        homePage.selectProduct(product_name);
    }

    @Then("Product Page is opened with displayed title {string}")
    public void productPageDisplayedWithTitle(String title) {
        new ProductPage().productTitleIsDisplayed(title);
    }
    @When("Add product to Cart")
    public void addToCart() {
        new ProductPage().addToCart();
    }

    @And("Click on {string} button from Navigation panel")
    public void clickOnNavButton(String buttonName) {
        homePage.topNavigationPanel.clickOn(buttonName);
    }

    @Then("Cart Page is opened with {int} product in shopping cart")
    public void validateNumberOfItemsInCart(int items_count) {
        new CartPage().validateNumberOfAddedItems(items_count);
    }

    @When("Select {string} from Categories")
    public void selectFromCategories(String category) {
        homePage.selectCategory(category);
    }
}