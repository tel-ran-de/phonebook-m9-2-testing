package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ForgotPasswordPage extends PageObject {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"defaultRegisterFormEmail\"]")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/button")
    private WebElement resetPasswordBtn;

    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/section/div/h4")
    private WebElement message;


    public PassRecoveryPage passRecover(String userEmail) {
        emailField.sendKeys(userEmail);
        resetPasswordBtn.click();
        return new PassRecoveryPage(driver);
    }

}
