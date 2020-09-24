package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class PasswordRecovery extends PageObject {
    public PasswordRecovery(WebDriver driver) { super(driver); }

//    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/div/div[2]/input")
    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement passwordField;

//    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/div/div[4]/input")
    @FindBy(id = "defaultRegisterFormConfPass")
    private WebElement confirmPasswordField;

//    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/div/button")
    @FindBy(id = "btnSubmit")
    private WebElement submitBtn;

    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/section/div/h4")
    private WebElement confirmNewPassMessage;

    //    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/section/div/a")
    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    public Login login(){
        loginBtn.click();
        return new Login(driver);
    }

    private PasswordRecovery passRecover(String password, String confPassword) {
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confPassword);
        submitBtn.click();
        return new PasswordRecovery(driver);
    }

}
