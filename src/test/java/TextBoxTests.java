import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxTests extends BaseTest {

    @Test
    public void fillFormTest() {
        new TextBoxPage()
                .open()
                .fillFullName("Mr. Anderson")
                .fillEmail("mr.anderson@example.com")
                .fillCurrentAddress("Moscow")
                .fillPermanentAddress("Perm")
                .submit();

        var page = new TextBoxPage();
        assertEquals("Name:Mr. Anderson", page.getOutputName());
        assertEquals("Email:mr.anderson@example.com", page.getOutputEmail());
        assertEquals("Current Address :Moscow", page.getOutputCurrentAddress());
        assertEquals("Permananet Address :Perm", page.getOutputPermanentAddress());
    }
}
