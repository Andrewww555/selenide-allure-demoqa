package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeFormPage extends BasePage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderMaleRadio = $("label[for='gender-radio-1']");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesSportsCheckbox = $("label[for='hobbies-checkbox-1']");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateInput = $$("input[id*='react-select']").first();
    private final SelenideElement cityInput = $$("input[id*='react-select']").get(1);
    private final SelenideElement modalContent = $(".modal-content");

    public PracticeFormPage open() {
        return open("/automation-practice-form");
    }

    public PracticeFormPage fillName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage fillEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public PracticeFormPage selectGenderMale() {
        genderMaleRadio.click();
        return this;
    }

    public PracticeFormPage fillPhone(String phone) {
        userNumberInput.setValue(phone);
        return this;
    }

    public PracticeFormPage fillDateOfBirth(int day, String month, int year) {
        dateOfBirthInput.click();
        $(".react-datepicker__year-select").selectOption(String.valueOf(year));
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text(String.valueOf(day)))
                .click();
        return this;
    }

    public PracticeFormPage fillSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.sendKeys(subject);
            subjectsInput.pressEnter();
        }
        return this;
    }

    public PracticeFormPage selectHobbySports() {
        hobbiesSportsCheckbox.click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        try {
            uploadPicture.uploadFile(new File(getClass().getResource("/" + fileName).toURI()));
        } catch (Exception e) {
            throw new RuntimeException("Не удалось загрузить файл: " + fileName, e);
        }
        return this;
    }

    public PracticeFormPage fillAddress(String address) {
        currentAddress.scrollTo();
        currentAddress.setValue(address);
        return this;
    }

    public PracticeFormPage selectStateAndCity(String state, String city) {
        stateInput.sendKeys(state);
        stateInput.pressEnter();
        cityInput.sendKeys(city);
        cityInput.pressEnter();
        return this;
    }

    public PracticeFormPage submit() {
        $("#userForm").submit();
        return this;
    }

    public boolean isModalDisplayed() {
        return modalContent.isDisplayed();
    }

    public String getModalText() {
        return modalContent.getText();
    }
}
