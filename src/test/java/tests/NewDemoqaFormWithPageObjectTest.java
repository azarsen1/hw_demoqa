package tests;

import org.junit.jupiter.api.Test;
import pages.NewDemoqaFormPage;

public class NewDemoqaFormWithPageObjectTest extends TestBase {

    NewDemoqaFormPage newDemoqaFormPage = new NewDemoqaFormPage();

    @Test
    void smokeFillFormTest() {
        newDemoqaFormPage.openPage()
                .removeBanner()
                .setFirstName("Arsen")
                .setLastName("Mukhametkulov")
                .setUserEmail("arsen@mail.ru")
                .setGender("Male")
                .setUserNumber("89373426157")
                .setDateOfBirth("21", "April", "1996")
                .setSubjects("Maths")
                .setHobbiesCheckbox("Sports")
                .setUploadPicture("AGE_TEST.jpg")
                .setCurrentAddress("Yangixayot 8")
                .setState("Uttar Pradesh")
                .setCity("Merrut")
                .clickSubmit();

        newDemoqaFormPage.checkResult("Student Name", "Arsen Mukhametkulov")
                .checkResult("Student Email", "arsen@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8937342615")
                .checkResult("Date of Birth", "21 April,1996")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "AGE_TEST.jpg")
                .checkResult("Address", "Yangixayot 8")
                .checkResult("State and City", "Uttar Pradesh Merrut");


    }

    @Test
    void minFillFormTestTest() {
        newDemoqaFormPage.openPage()
                .removeBanner()
                .setFirstName("A")
                .setLastName("A")
                .setUserEmail("a@m.ru")
                .setGender("Male")
                .setUserNumber("8937342615")
                .setDateOfBirth("21", "April", "1996")
                .clickSubmit();

        newDemoqaFormPage.checkResult("Student Name", "A A")
                .checkResult("Student Email", "a@m.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8937342615")
                .checkResult("Date of Birth", "21 April,1996");


    }

    @Test
    void negativeFillFormTestTest() {
        newDemoqaFormPage.openPage()
                .removeBanner()
                .setFirstName("")
                .setLastName("A")
                .setUserEmail("a@m.ru")
                .setGender("Male")
                .setUserNumber("8937342615")
                .setDateOfBirth("21", "April", "1996")
                .clickSubmit();

        newDemoqaFormPage.shouldHaveFirstName("")
                         .shouldHaveLastName("A")
                         .shouldHaveUserEmail("a@m.ru")
                         .shouldHaveGender("Male")
                         .shouldHaveDateOfBirth("21 Apr 1996")
        ;
    }

}
