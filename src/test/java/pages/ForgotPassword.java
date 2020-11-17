package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ForgotPassword extends PageObject {

    public ForgotPassword(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/div[3]/div")
    private WebElement wrongEmail;

    @FindBy(className = "alert")
    private WebElement userExistErrorMessage;

    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/button")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "/html/body/app-root/app-forgot-password/form/section")
    private WebElement confirmMessage;

    public void enterData(String user) {
        emailField.sendKeys(user);
        clickOnWebElement(resetPasswordButton);
    }

    public boolean isResetMyPasswordButtonEnabled() {
        return resetPasswordButton.isEnabled();
    }

    public String wrongEmail() {
        return wrongEmail.getText();
    }

    public String message() {
        return confirmMessage.getText();
    }

    public String userExistMessage() {
        return userExistErrorMessage.getText();
    }

}
