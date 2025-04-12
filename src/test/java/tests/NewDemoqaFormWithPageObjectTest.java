package tests;

import org.junit.jupiter.api.Test;
import pages.NewDemoqaFormPage;
import pages.TestBase;

public class NewDemoqaFormWithPageObjectTest extends TestBase {

    NewDemoqaFormPage newDemoqaFormPage = new NewDemoqaFormPage();

    @Test
    void smokeFillFormTest() {
        newDemoqaFormPage.openPage()
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
                .setFirstName("A")
                .setLastName("A")
                .setUserEmail("a@m.r")
                .setGender("Male")
                .setUserNumber("8937342615")
                .setDateOfBirth("21", "April", "1996")
                .clickSubmit();

        newDemoqaFormPage.checkResult("Student Name", "A A")
                .checkResult("Student Email", "a@m.r")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8937342615")
                .checkResult("Date of Birth", "21 April,1996");


    }


}
