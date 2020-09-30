package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.Login;
import utils.FunctionalTest;

import static org.junit.Assert.*;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginTest extends FunctionalTest {

    Login login = new Login(driver);

    @Before
    public void init() {
        driver.get(LOGIN_URL);
    }

    @Test
    public void test01_noData_LoginButtonIsDisabled() {
        assertFalse(login.isLoginButtonEnabled());
    }

    @Test
    public void test02_validData_loginButtonEnabled() {
        login.enterData(USER, PASSWORD);
        assertTrue(login.isLoginButtonEnabled());
    }

    @Test
    public void test03_invalidData_LoginButtonIsEnabled() {
        login.enterData(INVALID_USER, PASSWORD);
        assertFalse(login.isLoginButtonEnabled());
    }

    @Test
    public void test04_noData_SignUpButtonIsEnabled() {
        assertTrue(login.isSignUpButtonEnabled());
    }

    @Test
    public void test05_signUp_RegistrationPageIsDisplayed() {
        login.clickSignUp();
        assertEquals(SIGN_UP_URL, driver.getCurrentUrl());
    }

    @Test
    public void test06_loginAuthorisedUser_UserPageIsDisplayed() throws InterruptedException {
        login.enterData(USER, PASSWORD);
        assertTrue(login.isLoginButtonEnabled());
        login.clickLogin();
        Thread.sleep(5000);
        assertEquals(USER_URL, driver.getCurrentUrl());
    }

    // TODO: "forgot pass" id needed. Ask Vadik
    @Test
    public void test07_forgotPasswordLinkIsEnabled() {
        assertTrue(login.isForgotPasswordLinkEnabled());
    }

    // TODO: "forgot pass" id needed
    @Test
    public void test08_forgotPasswordLink_ForgotPasswordPageIsDisplayed() throws InterruptedException {
        login.clickForgotPassword();
        Thread.sleep(5000);
        assertEquals(FORGOT_PASS_URL, driver.getCurrentUrl());
    }

    @Test
    public void test09_emailFieldIsEmpty_ErrorMessageIsDisplayed() {
        login.enterData(" ", PASSWORD);
        assertEquals("Email is required.", login.emptyEmail());
    }

    @Test
    public void test10_passwordFieldIsEmpty_ErrorMessageIsDisplayed() {
        login.enterData(USER, "");
        assertEquals("Password is required.", login.emptyPassword());
    }

    @Test
    public void test11_passwordFieldIsEmpty_LoginButtonIsDisabled() {
        login.enterData(USER, "");
        login.clickLogin();
        assertFalse(login.isLoginButtonEnabled());
    }

    @Test
    public void test12_invalidEmail_ErrorMessageIsDisplayed() {
        login.enterData(INVALID_USER, PASSWORD);
        assertEquals("Email must be a valid email address.", login.wrongEmail());
    }

    @Test
    public void test13_shortPass_ErrorMessageIsDisplayed() {
        login.enterData(USER, SHORT_PASSWORD);
        assertEquals("Password must be at least 8 characters.", login.shortPassword());
    }

    // TODO: no text. ask Vadik to fix
    @Test
    public void test14_longPass_ErrorMessageIsDisplayed() {
        login.enterData(USER, LONG_PASSWORD);
        assertEquals("Password must be no longer than 20 characters.", login.longPassword());
    }

    @Test
    public void test15_shortPass_loginButtonIsDisabled() {
        login.enterData(USER, SHORT_PASSWORD);
        assertFalse(login.isLoginButtonEnabled());
    }

}
