package guiTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.Login;
import pages.UserPage;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UserPageTest extends FunctionalTest {

    UserPage userPage = new UserPage(driver);
    Login login = new Login(driver);

    @Before
    public void init() {
        driver.get(USER_URL);
    }

    @Test
    public void test01_logout_LoginPageIsDisabled() throws InterruptedException {
        login.enterData(USER, PASSWORD);
        login.clickLogin();
        Thread.sleep(3000);
        userPage.logout();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

}