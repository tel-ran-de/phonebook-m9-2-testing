package guiTest;

import org.junit.Before;
import org.junit.Test;
import pages.ChangePassword;
import pages.Login;
import pages.UserPage;
import utils.FunctionalTest;

import static org.junit.Assert.*;
import static utils.Constants.*;

public class ChangePasswordTest extends FunctionalTest {

    ChangePassword changePass = new ChangePassword(driver);
    UserPage userPage = new UserPage(driver);

    @Before
    public void init() {
        driver.get(LOGIN_URL);
        Login login = new Login(driver);
        login.enterData(ACTIVATED_USER, PASSWORD);
        login.clickLogin();
    }

    @Test
    public void test01_noData_UpdateButtonIsDisabled() {
        assertFalse(changePass.isUpdateButtonEnabled());
    }

    @Test
    public void test02_setNewPassword_UpdateButtonEnabled() {
        userPage.clickChangePassword();
        changePass.changePassword(NEW_PASSWORD);
        assertTrue(changePass.isUpdateButtonEnabled());
    }

    @Test
    public void test03_changePassword_LoginPageIsDisplayed() throws InterruptedException {
        userPage.clickChangePassword();
        assertEquals(CHANGE_PASSWORD_URL, currentUrl());
        changePass.changePassword(NEW_PASSWORD);
        Thread.sleep(3000);
        assertEquals(LOGIN_URL, currentUrl());
    }

    @Test
    public void test04_changePassword_SuccessMessageIsDisplayed() throws InterruptedException {
        userPage.clickChangePassword();
        assertEquals(CHANGE_PASSWORD_URL, currentUrl());
        changePass.changePassword(NEW_PASSWORD);
        assertEquals("Password changed successfully!", changePass.successMessage());
    }

    @Test
    public void test05_shortPass_ErrorMessageIsDisplayed() {
        changePass.changePassword(SHORT_PASSWORD);
        assertEquals("Password must be at least 8 characters.", changePass.shortPassword());
    }

    @Test
    public void test06_longPass_ErrorMessageIsDisplayed() {
        changePass.changePassword(LONG_PASSWORD);
        assertEquals("Password must be no longer than 20 characters.", changePass.longPassword());
    }

}
