package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ActivateEmailPage extends PageObject {

    public ActivateEmailPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "/html/body/app-root/app-activate-email/main/section/div/h4")
    private WebElement messageToCheckEmail;

    public ConfirmActivationPage activateAccount(){

        return new ConfirmActivationPage(driver);
    }
}
