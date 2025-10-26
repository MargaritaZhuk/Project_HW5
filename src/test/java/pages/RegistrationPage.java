package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement header = $("h1"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderSelector = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelector = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper #state input"),
            cityInput = $("#stateCity-wrapper #city input"),
            submitButton = $("#submit"),
            dateOfBirthInput = $("#dateOfBirthInput");

    CalendarComponent calendar = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        header.shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderSelector.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String year, String month, String day) {
        dateOfBirthInput.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesSelector.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }

    public RegistrationPage checkOverallValidation() {
        $(".was-validated").shouldBe(visible);
        return this;
    }

    public RegistrationPage checkFirstNameValidation() {
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationPage checkLastNameValidation() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationPage checkEmailValidation() {
        emailInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationPage checkPhoneValidation() {
        phoneInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationPage checkGenderValidation() {
        genderSelector.$$("[for^='gender-radio']")
                .forEach(label -> label.shouldHave(cssValue("color", "rgba(220, 53, 69, 1)")));
        return this;
    }
}