package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.Registration;
import utils.FunctionalTest;

import static org.junit.Assert.*;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RegistrationTest extends FunctionalTest {

    Registration registration = new Registration(driver);

    @Before
    public void init() {
        driver.get(SIGN_UP_URL);
    }

    @Test
    public void test01_noData_SignUpButtonIsDisabled() {
        assertFalse(registration.isSignUpBtnEnabled());
    }

    @Test
    public void test02_loginButtonIsEnabled() {
        assertTrue(registration.isLoginBtnEnabled());
    }

    @Test
    public void test03_validData_SignUpButtonIsEnabled() {
        registration.enterData(USER, PASSWORD, CONF_PASSWORD);
        assertTrue(registration.isSignUpBtnEnabled());
    }

    @Test
    public void test04_invalidData_SignUpButtonIsDisabled() throws InterruptedException {
        registration.enterData(INVALID_USER, SHORT_PASSWORD, SHORT_PASSWORD);
        assertFalse(registration.isSignUpBtnEnabled());
    }

    @Test
    public void test05_clickLogin_LoginPage() throws InterruptedException {
        registration.clickLogin();
        assertEquals(USER_URL, driver.getCurrentUrl());
    }

    @Test
    public void test06_newUserValidData_ActivateEmailPageIsDisplayed() throws InterruptedException {
        registration.enterData("tran@test.de", PASSWORD, CONF_PASSWORD);
        registration.clickSignUp();
        Thread.sleep(5000);
        assertEquals(ACTIVATE_EMAIL_URL, driver.getCurrentUrl());
    }

    @Test
    public void test07_activatedUserData_UserExistErrorMessageIsDisplayed() {
        registration.enterData(USER, PASSWORD, CONF_PASSWORD);
        registration.clickSignUp();
        assertEquals("User already exists.", registration.existedUser());
    }

    @Test
    public void test08_passwordFieldIsEmpty_ErrorMessageIsDisplayed() {
        registration.enterData(INVALID_USER, "", "");
        assertEquals("Password is required.", registration.passwordEmpty());
    }

    @Test
    public void test09_shortPass_ErrorMessageIsDisplayed() {
        registration.enterData(USER, SHORT_PASSWORD, PASSWORD);
        assertEquals("Password must be at least 8 characters long.", registration.passwordShort());
    }

    @Test
    public void test10_longPass_ErrorMessageIsDisplayed() {
        registration.enterData(USER, LONG_PASSWORD, LONG_PASSWORD);
        assertEquals("Password must be no longer than 20 characters.", registration.passwordLong());
    }

    @Test
    public void test11_passwordsDontMatch_ErrorMessageIsDisplayed() {
        registration.enterData(USER, PASSWORD, LONG_PASSWORD);
        assertEquals("Passwords do not match.", registration.passwordsDontMatch());
    }

    @Test
    public void test12_emailFieldIsEmpty_ErrorMessageIsDisplayed() {
        registration.enterData(" ", PASSWORD, CONF_PASSWORD);
        assertEquals("Email is required.", registration.emailEmpty());
    }

    @Test
    public void test13_wrongEmail_ErrorMessageIsDisplayed() {
        registration.enterData(INVALID_USER, PASSWORD, PASSWORD);
        assertEquals("Email must be a valid email address.", registration.wrongEmail());
    }

    @Test
    public void test14_wrongEmail_SignUpButtonIsEnabled() {
        registration.enterData(INVALID_USER, PASSWORD, PASSWORD);
        assertFalse(registration.isSignUpBtnEnabled());
    }

}
