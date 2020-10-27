package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.ForgotPassword;
import utils.FunctionalTest;

import static org.junit.Assert.*;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ForgotPasswordTest extends FunctionalTest {

    ForgotPassword forgotPass = new ForgotPassword(driver);

    @Before
    public void init() {
        driver.get(FORGOT_PASS_URL);
    }

    @Test
    public void test01_noEmail_ResetMyPasswordButtonIsDisabled() {
        assertFalse(forgotPass.isResetMyPasswordButtonEnabled());
    }

    @Test
    public void test02_validEmail_ResetMyPasswordButtonIsEnabled() {
        forgotPass.enterData(USER);
        assertTrue(forgotPass.isResetMyPasswordButtonEnabled());
    }

    @Test
    public void test03_invalidEmail_ErrorMessageIsDisplayed() {
        forgotPass.enterData(INVALID_USER);
        assertFalse(forgotPass.isResetMyPasswordButtonEnabled());
        assertEquals("Email must be a valid email address.", forgotPass.wrongEmail());
    }

    @Test
    public void test04_activatedEmail_ConfirmMessageToResetIsDisplayed() {
        forgotPass.enterData(ACTIVATED_USER);
        assertEquals("Please check your email and reset your password", forgotPass.message());
    }

    @Test
    public void test05_notRegisteredEmail_ErrorMessageIsDisplayed() {
        forgotPass.enterData("noname@me.com");
        assertEquals("Error! This user doesn't exist", forgotPass.userExistMessage());
    }

}
