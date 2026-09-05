package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Condition.value;


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
    @Step("Открываем страницу")
    public NewDemoqaFormPage openPage() {
        open("/automation-practice-form");
        logger.info("Открытие формы: https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Удаляем баннер")
    public NewDemoqaFormPage removeBanner() {
        executeJavaScript("document.querySelector('#fixedban')?.remove();");
        executeJavaScript("document.querySelector('footer')?.remove();");
        return this;
    }

    @Step("Заполняем имя")
    public NewDemoqaFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Заполняем фамилию")
    public NewDemoqaFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Заполняем Email")
    public NewDemoqaFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбираем пол")
    public NewDemoqaFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }
    @Step("Заполняем номер")
    public NewDemoqaFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Выбираем дату рождения")
    public NewDemoqaFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    @Step("Выбираем предмет")
    public NewDemoqaFormPage setSubjects(String value) {
        subjectsInput.setValue(value);
        $$(".subjects-auto-complete__menu-list div").findBy(text(value)).click();
        return this;
    }
    @Step("Выбираем хобби")
    public NewDemoqaFormPage setHobbiesCheckbox(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }
    @Step("Загружаем картинку")
    public NewDemoqaFormPage setUploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }
    @Step("Заполняем адрес")
    public NewDemoqaFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    @Step("Выбираем штат")
    public NewDemoqaFormPage setState(String value) {
        stateInput.click();
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }
    @Step("Выбираем город")
    public NewDemoqaFormPage setCity(String value) {
        cityInput.click();
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }
    @Step("Нажимает на кнопку \"Submit\"")
    public NewDemoqaFormPage clickSubmit() {
        buttonSubmit.click();
        return this;


    }
    @Step("Проверяем поле {key} с ведёнными данными {value}")
    public NewDemoqaFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверить, что в поле First Name отображается значение '{0}'")
    public NewDemoqaFormPage shouldHaveFirstName(String expectedValue) {

        if (expectedValue.isEmpty()) {
            firstNameInput.shouldBe(Condition.empty);
        } else {
            firstNameInput.shouldHave(Condition.value(expectedValue));
        }

        return this;
    }

    @Step("Проверить, что в поле Last Name отображается значение '{0}'")
    public NewDemoqaFormPage shouldHaveLastName(String expectedValue) {

        if (expectedValue.isEmpty()) {
            lastNameInput.shouldBe(Condition.empty);
        } else {
            lastNameInput.shouldHave(Condition.value(expectedValue));
        }
        return this;
    }

    @Step("Проверить, что в поле User Email отображается значение '{0}'")
    public NewDemoqaFormPage shouldHaveUserEmail(String expectedValue) {

        if (expectedValue.isEmpty()) {
            userEmailInput.shouldBe(Condition.empty);
        } else {
            userEmailInput.shouldHave(Condition.value(expectedValue));
        }
        return this;
    }

    @Step("Проверить, что в поле Gender отображается значение '{0}'")
    public NewDemoqaFormPage shouldHaveGender(String expectedValue) {
        genderRadioButton.$("input[name='gender'][value='" + expectedValue + "']")
                .shouldBe(Condition.selected);

        return this;
    }

    @Step("Проверить, что в поле Date of Birth отображается значение '{0}'")
    public NewDemoqaFormPage shouldHaveDateOfBirth(String expectedDate) {
        $("#dateOfBirthInput").shouldHave(Condition.value(expectedDate));
        return this;
    }
}
