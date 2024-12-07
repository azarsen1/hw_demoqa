import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NewDemoqaForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 1000;
    }

    @Test
     void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("document.getElementById('fixedban').style.display = 'none';");
        executeJavaScript("$('footer').remove()");
        switchTo().frame("google_ads_iframe_/21849154601,22343295815/Ad.Plus-970x250-1_0");
        executeJavaScript("document.body.innerHTML = '';");
        switchTo().defaultContent();

        SelenideElement button = $("#submit");
        $("#submit").scrollTo().click();
        Configuration.pageLoadStrategy = "eager";
        $("#firstName").setValue("Arsen");
        $("#lastName").setValue("Mukhametkulov");
        $("#userEmail").setValue("Azarsen1@mail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("8937341615");
        $("#dateOfBirthInput").click();
        $("select.react-datepicker__year-select").selectOption("1996");
        $("select.react-datepicker__month-select").selectOption("April");
        $$(".react-datepicker__day").findBy(text("21")).click();
        $("#subjectsInput").setValue("Maths");
        $$(".subjects-auto-complete__menu-list div").findBy(text("Maths")).click();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFile(new File("/Users/arsenmukhametkulov/Desktop/AGE_TEST.jpg"));
        $("#currentAddress").setValue("Yangixayot 8");
        $("#state").click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Merrut").pressEnter();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Arsen Mukhametkulov"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("Azarsen1@mail.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("8937341615"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("21 April,1996"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("AGE_TEST.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("Yangixayot 8"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("Uttar Pradesh Merrut"));
    }
}









