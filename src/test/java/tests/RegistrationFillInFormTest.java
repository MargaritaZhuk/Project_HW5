package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModalComponent;


public class RegistrationFillInFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultModalComponent resultModalComponent = new ResultModalComponent();

    @Test
    void fillTextFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Margarita")
                .setLastName("Zhuk")
                .setEmail("zhukrita@gmail.com")
                .setGender("Female")
                .setPhone("9663453928")
                .setDateOfBirth("1997", "March", "5")
                .setSubjects("M")
                .setHobbies("Sports")
                .setPicture("image1.jpeg")
                .setAddress("Address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        resultModalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Margarita Zhuk")
                .checkResult("Student Email", "zhukrita@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9663453928")
                .checkResult("Date of Birth", "05 March,1997")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "image1.jpeg")
                .checkResult("Address", "Address 1")
                .checkResult("State and City", "NCR Delhi")
                .closeModal();
    }

    @Test
    void fillMinimalFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Margarita")
                .setLastName("Zhuk")
                .setGender("Female")
                .setPhone("9663453928")
                .setDateOfBirth("1997", "March", "5")
                .submitForm();

        resultModalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Margarita Zhuk")
                .checkEmptyResult("Student Email")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9663453928")
                .checkResult("Date of Birth", "05 March,1997")
                .checkEmptyResult("Subjects")
                .checkEmptyResult("Hobbies")
                .checkEmptyResult("Picture")
                .checkEmptyResult("Address")
                .checkEmptyResult("State and City")
                .closeModal();

    }

    @Test
    void validationTextFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .submitForm()
                .checkOverallValidation()
                .checkFirstNameValidation()
                .checkLastNameValidation()
                .checkGenderValidation()
                .checkPhoneValidation();
        resultModalComponent.checkModalIsNotOpen();
    }

    @Test
    void emailValidationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Margarita")
                .setLastName("Zhuk")
                .setGender("Female")
                .setPhone("9663453928")
                .setEmail("aaa@aa")
                .submitForm()
                .checkEmailValidation();
        resultModalComponent.checkModalIsNotOpen();
    }
}






