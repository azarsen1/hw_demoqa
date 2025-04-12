package pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class NewDemoqaFormPage {

    private static final Logger logger = LoggerFactory.getLogger(NewDemoqaFormPage.class);


    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement stateInput = $("#state");
    SelenideElement cityInput = $("#city");
    SelenideElement buttonSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public NewDemoqaFormPage openPage() {
        open("/automation-practice-form");
        logger.info("Открытие формы: https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#fixedban").shouldBe(visible);
        $("footer").shouldBe(visible);
        logger.info("Удаление баннеров со страницы");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public NewDemoqaFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public NewDemoqaFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public NewDemoqaFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public NewDemoqaFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public NewDemoqaFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public NewDemoqaFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public NewDemoqaFormPage setSubjects(String value) {
        subjectsInput.setValue(value);
        $$(".subjects-auto-complete__menu-list div").findBy(text(value)).click();
        return this;
    }

    public NewDemoqaFormPage setHobbiesCheckbox(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public NewDemoqaFormPage setUploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath("AGE_TEST.jpg");
        return this;
    }

    public NewDemoqaFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public NewDemoqaFormPage setState(String value) {
        stateInput.click();
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }

    public NewDemoqaFormPage setCity(String value) {
        cityInput.click();
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }

    public NewDemoqaFormPage clickSubmit() {
        buttonSubmit.click();
        return this;


    }

    public NewDemoqaFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }


}
