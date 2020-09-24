package guiTest;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pages.ForgotPassword;
import utils.FunctionalTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ForgotPasswordTest extends FunctionalTest {

    ForgotPassword forgotPass = new ForgotPassword(driver);
    private String forgotPassUrl = "http://localhost:4200/user/forgot-password";

}
