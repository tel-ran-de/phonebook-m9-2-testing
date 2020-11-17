package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.Login;
import pages.UserPage;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UserPageTest extends FunctionalTest {

    UserPage userPage = new UserPage(driver);

    @Before
    public void init() {
        driver.get(LOGIN_URL);
        Login login = new Login(driver);
        login.enterData(ACTIVATED_USER, PASSWORD);
        login.clickLogin();
    }

    @Test
    public void test01_logout_LoginPageIsDisplayed() {
        userPage.logout();
        assertEquals(LOGIN_URL, currentUrl());
    }

    @Test
    public void test02_login_UsernameIsDisplayed() {
        userPage.isLoggedUserDisplayed();
        assertTrue(ACTIVATED_USER, userPage.isLoggedUserDisplayed());
    }

    @Test
    public void test03_clickHome_ContactsDisplayed() {
        userPage.clickHome();
        assertEquals(USER_URL, currentUrl());
    }

    @Test
    public void test04_clickAddNewContact_AddContactFormIsDisplayed() {
        userPage.clickAddNewContact();
        assertEquals(ADD_NEW_CONTACT_URL, currentUrl());
    }

    @Test
    public void test05_allLinksEnabled() {
        userPage.linksAreEnabled();
        assertEquals(true, userPage.linksAreEnabled());
    }

}
