package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.ActivateEmail;
import pages.Registration;
import utils.FunctionalTest;

import static org.junit.Assert.*;
import static utils.Constants.SIGN_UP_URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ActivateEmailTest extends FunctionalTest {

    Registration registration = new Registration(driver);
    ActivateEmail activationEmail = new ActivateEmail(driver);

    @Before
    public void init() {
        driver.get(SIGN_UP_URL);
    }

    @Test
    public void test01_activationEmailMessageIsDisplayed() throws InterruptedException {
        registration.enterData("exorf728@mail.com", "test12345", "test12345");
        registration.clickSignUp();
        assertTrue(activationEmail.isMessageDisplayed());
        assertEquals("Please, check your email and activate your account.", activationEmail.checkMessage());
    }

}
