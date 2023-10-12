package ui.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactModal {
    private final SelenideElement title = $("#exampleModalLabel");
    private final SelenideElement recipientEmail = $("#recipient-email");
    private final SelenideElement recipientName = $("#recipient-name");
    private final SelenideElement messageText = $("#message-text");
    private final SelenideElement sendButton = $(By.xpath("//button[text()='Send message']"));

    private void fillInputField(SelenideElement fieldName, String text) {
        fieldName.shouldBe(Condition.editable).sendKeys(text);
    }

    private void enterName(String text) {
        fillInputField(recipientName, text);
    }
    private void enterEmail(String text) {
        fillInputField(recipientEmail, text);
    }
    private void enterMessage(String message) {
        fillInputField(messageText, message);
    }

    public void sendMessage(String recipientName, String recipientEmail, String message) {
        enterName(recipientName);
        enterEmail(recipientEmail);
        enterMessage(message);
        sendButton.click();
    }

    public void isDisplayed() {
        title.should(Condition.appear);
    }
    public void isClosed() {
        title.should(Condition.disappear);
    }
}
