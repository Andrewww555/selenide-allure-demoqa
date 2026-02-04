import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeFormTests extends BaseTest {

    @Test
    public void StudentRegistrationPageTest() {
        new PracticeFormPage()
                .open()
                .fillName("Agent", "Smith")
                .fillEmail("smithagent@example.com")
                .selectGenderMale()
                .fillPhone("8800555555")
                .fillDateOfBirth(1, "January", 1993)
                .fillSubjects("Math", "Computer Science")
                .selectHobbySports()
                .uploadPicture("smith.jpeg")
                .fillAddress("Washington")
                .selectStateAndCity("NCR", "Delhi")
                .submit();

        var page = new PracticeFormPage();
        assertTrue(page.isModalDisplayed());
        assertTrue(page.getModalText().contains("Agent"));
        assertTrue(page.getModalText().contains("Smith"));
        assertTrue(page.getModalText().contains("NCR"));
        assertTrue(page.getModalText().contains("Delhi"));
    }
}
