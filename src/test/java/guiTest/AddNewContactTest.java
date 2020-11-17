package guiTest;

import org.junit.Before;
import org.junit.Test;
import pages.AddNewContact;
import pages.AddPhone;
import pages.Login;
import pages.UserPage;
import utils.FunctionalTest;

import static org.junit.Assert.*;
import static utils.Constants.*;
import static utils.Constants.PASSWORD;

public class AddNewContactTest extends FunctionalTest {

    UserPage userPage = new UserPage(driver);
    AddNewContact newContact = new AddNewContact(driver);
    AddPhone addPhone = new AddPhone(driver);

    @Before
    public void init() {
        driver.get(LOGIN_URL);
        Login login = new Login(driver);
        login.enterData(ACTIVATED_USER, PASSWORD);
        login.clickLogin();
        userPage.clickAddNewContact();
    }

    @Test
    public void test01_noData_AddContactButtonIsDisabled() {
        assertFalse(newContact.isAddButtonEnabled());
    }

    @Test
    public void test02_addContact_ContactCreated() {
        newContact.addContact("Anna", "Me", "");
        addPhone.addPhone("8976785765674");
        assertTrue(newContact.contactCard());
    }

    @Test
    public void test03_shortPhoneNumber_ErrorDisplayed() {
        newContact.addContact("Anna", "Yurchenko", "tel-ran");
        addPhone.addPhone("1234");
        assertEquals("PhoneNumber must be at least 10 characters long.", addPhone.errorMin());
    }

    @Test
    public void test04_longPhoneNumber_ErrorDisplayed() {
        newContact.addContact("Anna", "Yurchenko", "test");
        addPhone.addPhone("123487675654534534347");
        assertEquals("PhoneNumber must be no longer than 15 characters.", addPhone.errorMax());
    }

    @Test
    public void test05_wrongPhoneNumber_ErrorDisplayed() {
        newContact.addContact("Anna", "Yurchenko", "test");
        addPhone.addPhone("+1234876jkg");
        assertEquals("PhoneNumber must contain only Number.", addPhone.error());
    }

}
