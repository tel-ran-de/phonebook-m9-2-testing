package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ChangePassword extends PageObject {

    public ChangePassword(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmation-password")
    private WebElement confirmPasswordField;

    @FindBy(id = "minimal-password")
    private WebElement minPassword;

    @FindBy(id = "maximal-password")
    private WebElement maxPassword;

    @FindBy(id = "not-match-password")
    private WebElement passwordsDontMatch;

    @FindBy(css = ".btn")
    private WebElement changePasswordButton;

    @FindBy(css = "h4")
    WebElement successMessage;

    public void setPassword(String password, String confirmPassword) {
        this.passwordField.sendKeys(password);
        this.confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickChangePasswordBtn() {
        clickOnWebElement(changePasswordButton);
    }

    public boolean isChangePasswordButtonEnabled() {
        return changePasswordButton.isEnabled();
    }

    public String successMessage() {
        return successMessage.getText();
    }

    public String shortPassword() {
        return minPassword.getText();
    }

    public String longPassword() {
        return maxPassword.getText();
    }

    public String passwordsDontMatch() {
        return passwordsDontMatch.getText();
    }

}
