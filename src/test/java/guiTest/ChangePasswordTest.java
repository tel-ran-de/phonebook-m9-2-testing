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
        userPage.clickChangePassword();
    }

    @Test
    public void test01_noData_ChangePasswordButtonIsDisabled() {
        assertFalse(changePass.isChangePasswordButtonEnabled());
    }

    @Test
    public void test02_setNewPassword_UpdateButtonEnabled() {
        changePass.setPassword(NEW_PASSWORD, NEW_CONF_PASSWORD);
        assertTrue(changePass.isChangePasswordButtonEnabled());
    }

    @Test
    public void test03_changePassword_SuccessMessageIsDisplayed() throws InterruptedException {
        assertEquals(CHANGE_PASSWORD_URL, currentUrl());
        changePass.setPassword(NEW_PASSWORD, NEW_CONF_PASSWORD);
        changePass.clickChangePasswordBtn();
        Thread.sleep(3000);
        assertEquals("The password has been changed successfully", changePass.successMessage());
    }

    @Test
    public void test04_shortPass_ErrorMessageIsDisplayed() {
        changePass.setPassword(SHORT_PASSWORD, SHORT_PASSWORD);
        assertFalse(changePass.isChangePasswordButtonEnabled());
        assertEquals("Password must be at least 8 characters long.", changePass.shortPassword());
    }

    @Test
    public void test05_longPass_ErrorMessageIsDisplayed() {
        changePass.setPassword(LONG_PASSWORD, LONG_PASSWORD);
        assertFalse(changePass.isChangePasswordButtonEnabled());
        assertEquals("Password must be no longer than 20 characters.", changePass.longPassword());
    }

    @Test
    public void test06_passwordsDontMatch_ErrorMessageIsDisplayed() {
        changePass.setPassword(PASSWORD, SHORT_PASSWORD);
        assertFalse(changePass.isChangePasswordButtonEnabled());
        assertEquals("Passwords do not match.", changePass.passwordsDontMatch());
    }

}
