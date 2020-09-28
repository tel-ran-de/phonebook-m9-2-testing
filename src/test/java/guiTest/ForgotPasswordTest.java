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
        assertEquals("Email must be a valid email address.", forgotPass.wrongEmail());
    }

    @Test
    public void test04_enterRegisteredEmail_ConfirmMessageIsDisplayed() {
        forgotPass.enterData(USER);
        assertEquals("Please check your email and reset your password", forgotPass.message());
    }

    // TODO: fix a bug on frontend. No message "Error! This user doesn't exist"
    @Test
    public void test05_enterNotRegisteredEmail_ErrorMessageIsDisplayed() {
        forgotPass.enterData(INVALID_USER);
        assertEquals("Error! This user doesn't exist.", forgotPass.userExistMessage());
    }

}
