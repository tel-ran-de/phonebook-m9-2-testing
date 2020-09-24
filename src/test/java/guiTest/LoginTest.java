package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.Login;
import utils.FunctionalTest;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginTest extends FunctionalTest {

    Login login = new Login(driver);
    private String loginUrl = "http://localhost:4200/user/login";
    private String mainUrl = "http://localhost:4200/";

    private String user = "anna.yurchenko@me.com";
    private String password = "yurchenko2009";

    private String invalidUser = "anna.urchenko@com";
    private String shortPassword = "111111";
    private String longPassword = "1234567890123456789012";

    @Before
    public void init() {driver.get(loginUrl);}

    @Test
    public void test01_loginExistingUser_loginButtonEnabled() {
        login.enterDataToLogin(user, password);
        assertTrue(login.isLoginButtonEnabled());
    }

    @Test
    public void test02_noLoginData_SignUpBtnIsDisabled() {
        assertFalse(login.isLoginButtonEnabled());
    }

    @Test
    public void test03_loginAuthorisedUser_MainPageIsDisplayed() throws InterruptedException {
        login.enterDataToLogin(user, password);
        login.clickLogin();
        Thread.sleep(3000);
        assertEquals(driver.getCurrentUrl(),mainUrl);
    }

    // ToDo: get id for FPlink
    @Test
    public void test04_forgotPasswordLinkIsEnabled() {
        assertTrue(login.isForgotPassLinkEnabled());
    }

}
