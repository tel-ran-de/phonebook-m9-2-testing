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

    @FindBy(id = "minimal-password")
    private WebElement minPassword;

    @FindBy(id = "maximal-password")
    private WebElement maxPassword;

    @FindBy(css = "button")
    private WebElement updateButton;

    @FindBy(xpath = "message")
    WebElement successMessage;

    public void changePassword(String password) {
        this.passwordField.sendKeys(password);
        this.updateButton.click();
    }

    public boolean isUpdateButtonEnabled() {
        return updateButton.isEnabled();
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

}
