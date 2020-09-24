package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.Registration;
import utils.FunctionalTest;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RegistrationTest extends FunctionalTest {

    Registration registration = new Registration(driver);
    private String signUpUrl = "http://localhost:4200/user/registration";

    private String user = "anna.yurchenko@me.com";
    private String password = "yurchenko2009";
    private String confPassword = password;

    private String invalidUser = "anna.urchenko@com";
    private String shortPassword = "111111";
    private String longPassword = "1234567890123456789012";

    @Before
    public void init() { driver.get(signUpUrl); }

    @Test
    public void test01_enterValidData_SignUpBtnIsEnabled() {
        registration.enterData(user, password, confPassword);
        assertTrue(registration.isSignUpBtnEnabled());
    }

    @Test
    public void test02_noData_SignUpBtnIsDisabled() {
        assertFalse(registration.isSignUpBtnEnabled());
    }

    // -> change to "find by id"
    @Test
    public void test03_enterInvalidData_SignUpBtnIsDisabled() {
        registration.enterData("anna", "123", "123");
        assertFalse(registration.isSignUpBtnEnabled());
    }

    // !get right xpath ->pass
    @Test
    public void test04_userExists_ErrorMessageIsDisplayed() {
        registration.enterData("anna.yurchenko@me.com", "yurchenko2009", "yurchenko2009");
        registration.clickSignUp();
        assertTrue(registration.isErrorMessageDisplayed());
    }

    //!get right xpath ->pass
    @Test
    public void test05_shortPass_ErrorMessageIsDisplayed() {
        registration.enterData(user, shortPassword, shortPassword);
        assertTrue(registration.isErrorMessageDisplayed());
    }

//    @Test
//    public void test06_activateUser_UserLoggedIn() throws InterruptedException {
//        registration.enterData("anna.yurchenko@me.com", "yurchenko2009", "yurchenko2009");
//        registration.clickSignUp();
//        Thread.sleep(3000);
//        assertEquals(driver.getCurrentUrl(),activateEmailUrl);
//
//        assertEquals(driver.getCurrentUrl(),activationUrl);
//        activation.clickLoginButton();
//        assertEquals(driver.getCurrentUrl(),mainUrl);
//    }

}
