package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModalComponent;

import static io.qameta.allure.Allure.step;


@DisplayName("Тесты на форму регистрации")
public class RegistrationFillInFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultModalComponent resultModalComponent = new ResultModalComponent();

    @Test
    @Tag("registration")
    @DisplayName("Заполнение формы полными данными")
    void fillTextFormTest() {
        step("Open form", () -> {
            registrationPage.openPage().removeBanners();
        });
        step("Fill in form", () -> {
            registrationPage.setFirstName("Margarita").setLastName("Zhuk").setEmail("zhukrita@gmail.com").setGender("Female").setPhone("9663453928").setDateOfBirth("1997", "March", "5").setSubjects("M").setHobbies("Sports").setPicture("image1.jpeg").setAddress("Address 1").setState("NCR").setCity("Delhi").submitForm();
        });
        step("Check results", () -> {
            resultModalComponent.checkModalIsOpen().checkResult("Student Name", "Margarita Zhuk").checkResult("Student Email", "zhukrita@gmail.com").checkResult("Gender", "Female").checkResult("Mobile", "9663453928").checkResult("Date of Birth", "05 March,1997").checkResult("Subjects", "Maths").checkResult("Hobbies", "Sports").checkResult("Picture", "image1.jpeg").checkResult("Address", "Address 1").checkResult("State and City", "NCR Delhi").closeModal();
        });
    }

    @Test
    @Tag("registration")
    @Disabled("Require some changes")
    @DisplayName("Заполнение формы минимальными данными")
    void fillMinimalFormTest() {
        step("Open form", () -> {
            registrationPage.openPage().removeBanners();
        });

        step("Fill in form", () -> {
            registrationPage.setFirstName("Margarita").setLastName("Zhuk").setGender("Female").setPhone("9663453928").setDateOfBirth("1997", "March", "5").submitForm();
        });

        step("Check results", () -> {
            resultModalComponent.checkModalIsOpen().checkResult("Student Name", "Margarita Zhuk").checkEmptyResult("Student Email").checkResult("Gender", "Female").checkResult("Mobile", "9663453928").checkResult("Date of Birth", "05 March,1997").checkEmptyResult("Subjects").checkEmptyResult("Hobbies").checkEmptyResult("Picture").checkEmptyResult("Address").checkEmptyResult("State and City").closeModal();
        });
    }

    @Test
    @Tag("registration")
    @DisplayName("Валидация обязательных полей")
    void validationTextFormTest() {
        step("Open form", () -> {
            registrationPage.openPage().removeBanners();
        });
        step("Submit form", () -> {
            registrationPage.submitForm();
        });
        step("Check results", () -> {
            registrationPage.checkOverallValidation().checkFirstNameValidation().checkLastNameValidation().checkGenderValidation().checkPhoneValidation();
            resultModalComponent.checkModalIsNotOpen();
        });
    }

    @Test
    @Tag("registration")
    @DisplayName("Валидация эл.почты - заведомо провальный")
    void emailValidationTest() {
        step("Open form", () -> {
            registrationPage.openPage().removeBanners();
        });

        step("Fill in form", () -> {
            registrationPage.setFirstName("Margarita").setLastName("Zhuk").setGender("Female").setPhone("9663453928").setEmail("aaa@gmail.com").submitForm();
        });
        step("Check results", () -> {
            registrationPage.checkEmailValidation();
            resultModalComponent.checkModalIsNotOpen();
        });
    }
}






