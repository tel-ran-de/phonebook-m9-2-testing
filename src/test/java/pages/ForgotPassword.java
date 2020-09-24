package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ForgotPassword extends PageObject {
    public ForgotPassword(WebDriver driver) { super(driver);
    }

//    @FindBy(xpath = "//*[@id=\"defaultRegisterFormEmail\"]")
    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/button")
    private WebElement resetPasswordBtn;

    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/section/div/h4")
    private WebElement confirmMessage;

    public PasswordRecovery passRecover(String user) {
        emailField.sendKeys(user);
        resetPasswordBtn.click();
        return new PasswordRecovery(driver);
    }

}
