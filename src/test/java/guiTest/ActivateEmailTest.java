package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.ActivateEmail;
import pages.Registration;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ActivateEmailTest extends FunctionalTest {

    Registration registration = new Registration(driver);
    ActivateEmail activationEmail = new ActivateEmail(driver);
    private String signUpUrl = "http://localhost:4200/user/registration";
    private String activateEmailUrl = "http://localhost:4200/user/activate-email";

    @Before
    public void init() { driver.get(signUpUrl); }

    @Test
    public void test01_activateEmailPageIsDisplayed() throws InterruptedException {
        registration.enterData("vemape8700@debsmail.com", "test12345", "test12345");
        registration.clickSignUp();
        Thread.sleep(3000);
        assertEquals(driver.getCurrentUrl(),activateEmailUrl);
    }

    @Test
    public void test02_activationEmailMessageIsDisplayed() throws InterruptedException {
        registration.enterData("xexof78559@debsmail.com", "test12345", "test12345");
        registration.clickSignUp();
        Thread.sleep(3000);
        assertTrue(activationEmail.isMessageDisplayed());
        assertEquals("Please, check your email and activate your account.", activationEmail.checkMessage());
    }

}
