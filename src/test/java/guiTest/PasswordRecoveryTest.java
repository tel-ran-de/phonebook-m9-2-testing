package guiTest;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pages.PasswordRecovery;
import utils.FunctionalTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PasswordRecoveryTest extends FunctionalTest {

    PasswordRecovery passRecover = new PasswordRecovery(driver);
    private String passRecoverUrl = "http://localhost:4200/user/password-recovery/";

}
