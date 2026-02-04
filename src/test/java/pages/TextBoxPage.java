package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage extends BasePage {
    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");

    private final SelenideElement outputName = $("#output #name");
    private final SelenideElement outputEmail = $("#output #email");
    private final SelenideElement outputCurrentAddress = $("#output #currentAddress");
    private final SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage open() {
        return open("/text-box");
    }

    public TextBoxPage fillFullName(String name) {
        fullNameInput.setValue(name);
        return this;
    }

    public TextBoxPage fillEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage fillPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage submit() {
        $("#submit").click();
        return this;
    }

    public String getOutputName() {
        return outputName.getText();
    }

    public String getOutputEmail() {
        return outputEmail.getText();
    }

    public String getOutputCurrentAddress() {
        return outputCurrentAddress.getText();
    }

    public String getOutputPermanentAddress() {
        return outputPermanentAddress.getText();
    }
}
