package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class PassRecoveryPage extends PageObject {
    public PassRecoveryPage(WebDriver driver) { super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/div/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/div/div[4]/input")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/div/button")
    private WebElement submitBtn;

    private PassRecoveryActivationPage passActivation(String password, String confPassword) {
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confPassword);
        submitBtn.click();
        return new PassRecoveryActivationPage(driver);
    }

}
