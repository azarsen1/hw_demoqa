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


    }


}
