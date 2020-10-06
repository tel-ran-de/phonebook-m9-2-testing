package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.ActivateEmail;
import pages.Registration;
import utils.FunctionalTest;

import static org.junit.Assert.*;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RegistrationTest extends FunctionalTest {

    Registration registration = new Registration(driver);
    ActivateEmail activationEmail = new ActivateEmail(driver);

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
    public void test04_invalidData_SignUpButtonIsDisabled() {
        registration.enterData(INVALID_USER, SHORT_PASSWORD, SHORT_PASSWORD);
        assertFalse(registration.isSignUpBtnEnabled());
    }

    @Test
    public void test05_clickLogin_LoginPage() {
        registration.clickLogin();
        assertEquals(LOGIN_URL, currentUrl());
    }

    @Test
    public void test06_newUserValidData_ActivateEmailPageIsDisplayed() throws InterruptedException {
        registration.enterData("testing@dot.com", PASSWORD, CONF_PASSWORD);
        assertTrue(registration.isSignUpBtnEnabled());
        registration.clickSignUp();
        Thread.sleep(5000);
        assertEquals(ACTIVATE_EMAIL_URL, currentUrl());
        assertTrue(activationEmail.isMessageDisplayed());
        assertEquals("Please, check your email and activate your account.", activationEmail.checkMessage());
    }

    @Test
    public void test07_activatedUserData_UserExistErrorMessageIsDisplayed() {
        registration.enterData(ACTIVATED_USER, PASSWORD, CONF_PASSWORD);
        assertTrue(registration.isSignUpBtnEnabled());
        registration.clickSignUp();
        assertEquals("Error! User already exists", registration.existedUser());
    }

    @Test
    public void test08_passwordFieldIsEmpty_ErrorMessageIsDisplayed() {
        registration.enterData(INVALID_USER, "", "");
        assertEquals("Password is required.", registration.passwordEmpty());
    }

    @Test
    public void test09_shortPassword_ErrorMessageIsDisplayed() {
        registration.enterData(USER, SHORT_PASSWORD, PASSWORD);
        assertEquals("Password must be at least 8 characters long.", registration.passwordShort());
    }

    @Test
    public void test10_longPassword_ErrorMessageIsDisplayed() {
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

    @Test
    public void test15_existingUserData_SignUpButtonIsEnabled() {
        registration.enterData(ACTIVATED_USER, PASSWORD, CONF_PASSWORD);
        registration.clickSignUp();
        assertTrue(registration.isSignUpBtnEnabled());
    }

    @Test
    public void test16_upperCaseEmail_UserCreated() throws InterruptedException {
        registration.enterData("TERLRAN@MEX.COM", "12345678", "12345678");
        assertTrue(registration.isSignUpBtnEnabled());
        registration.clickSignUp();
        Thread.sleep(5000);
        assertEquals(ACTIVATE_EMAIL_URL, currentUrl());
        assertEquals("Please, check your email and activate your account.", activationEmail.checkMessage());
    }

    @Test
    public void test17_capitalisedLettersInEmail_UserCreated() throws InterruptedException {
        registration.enterData("New-Name@Org.de", PASSWORD, CONF_PASSWORD);
        assertTrue(registration.isSignUpBtnEnabled());
        registration.clickSignUp();
        Thread.sleep(5000);
        assertEquals(ACTIVATE_EMAIL_URL, currentUrl());
        assertEquals("Please, check your email and activate your account.", activationEmail.checkMessage());
    }

    @Test
    public void test18_numbersInEmail_UserCreated() throws InterruptedException {
        registration.enterData("123-456@dot.com", PASSWORD, CONF_PASSWORD);
        assertTrue(registration.isSignUpBtnEnabled());
        registration.clickSignUp();
        Thread.sleep(5000);
        assertEquals("Please, check your email and activate your account.", activationEmail.checkMessage());
    }

    // "а" from the russian keyboard
    @Test
    public void test19_cyrillicInEmail_ErrorMessageIsDisplayed() {
        registration.enterData("аdmin@gmail.com", PASSWORD, PASSWORD);
        assertEquals("Email must be a valid email address.", registration.wrongEmail());
    }

    @Test
    public void test20_symbolsInEmail_ErrorMessageIsDisplayed() {
        registration.enterData("$,*,-,+@dot.com", PASSWORD, CONF_PASSWORD);
        assertEquals("Email must be a valid email address.", registration.wrongEmail());
    }

    @Test
    public void test21_additionalAtSignSymbolInEmail_ErrorMessageIsDisplayed() {
        registration.enterData("mynew@user@gmail.com", PASSWORD, PASSWORD);
        assertEquals("Email must be a valid email address.", registration.wrongEmail());
    }

    @Test
    public void tes22_fullMatchData_UserCreated() throws InterruptedException {
        registration.enterData("1234@org.de", "1234@org.de", "1234@org.de");
        assertTrue(registration.isSignUpBtnEnabled());
        registration.clickSignUp();
        Thread.sleep(5000);
        assertEquals(ACTIVATE_EMAIL_URL, currentUrl());
        assertEquals("Please, check your email and activate your account.", activationEmail.checkMessage());
    }

    @Test
    public void tes23_spaceInEmail_RegistrationFailed() {
        registration.enterData("     @com.de", "test1234@com.de", "test1234@com.de");
        assertFalse(registration.isSignUpBtnEnabled());
        assertEquals("Email must be a valid email address.", registration.wrongEmail());
    }

}
