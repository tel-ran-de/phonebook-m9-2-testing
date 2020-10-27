package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.ChangePassword;
import pages.Login;
import pages.UserPage;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UserPageTest extends FunctionalTest {

    UserPage userPage = new UserPage(driver);
    ChangePassword changePass = new ChangePassword(driver);

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

}
