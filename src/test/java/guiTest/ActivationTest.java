package guiTest;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pages.Activation;
import utils.FunctionalTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ActivationTest extends FunctionalTest {

    Activation activation = new Activation(driver);
    private String activationUpUrl = "http://localhost:4200/user/activation";

}
