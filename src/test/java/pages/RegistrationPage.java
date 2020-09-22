package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class RegistrationPage extends PageObject {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // verified
    @FindBy(xpath = "//*[@id=\"defaultRegisterFormEmail\"]")
    private WebElement emailField;

    // verified
    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[2]/input")
    private WebElement passwordField;

    // verified
    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[3]/input")
    private WebElement confirmPasswordField;

    // verified
    @FindBy(xpath = "/html/body/app-root/app-registration/form/button")
    private WebElement signUpBtn;

    // verified
    @FindBy(xpath = "/html/body/app-root/app-registration/form/a")
    private WebElement loginBtn;

    public ActivateEmailPage register(String user, String password, String confPassword){
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confPassword);
        signUpBtn.click();
        loginBtn.click();
        return new ActivateEmailPage(driver);
    }

}
