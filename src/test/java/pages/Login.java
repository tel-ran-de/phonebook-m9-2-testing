package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class Login extends PageObject {

    public Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "empty-email")
    private WebElement emptyEmailField;

    @FindBy(id = "wrong-email")
    private WebElement wrongEmail;

    @FindBy(id = "wrong-user")
    private WebElement wrongUser;

    @FindBy(id = "registration-password")
    private WebElement passwordField;

    @FindBy(id = "empty-password")
    private WebElement emptyPasswordField;

    @FindBy(id = "minimal-password")
    private WebElement minPassword;

    @FindBy(id = "maximal-password")
    private WebElement maxPassword;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    @FindBy(id = "btn-signup")
    private WebElement signUpButton;

    @FindBy(id = "forgot-password")
    private WebElement forgotPasswordLink;

    public void enterData(String email, String pass) {
        this.emailField.sendKeys(email);
        this.passwordField.sendKeys(pass);
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public boolean isSignUpButtonEnabled() {
        return signUpButton.isEnabled();
    }

    public void clickLogin() {
        clickOnWebElement(loginButton);
    }

    public void clickSignUp() {
        clickOnWebElement(signUpButton);
    }

    public void clickForgotPassword() {
        clickOnWebElement(forgotPasswordLink);
    }

    public String wrongUser() {
        return wrongUser.getText();
    }

    public String emptyEmail() {
        return emptyEmailField.getText();
    }

    public String wrongEmail() {
        return wrongEmail.getText();
    }

    public String emptyPassword() {
        return emptyPasswordField.getText();
    }

    public String shortPassword() {
        return minPassword.getText();
    }

    public String longPassword() {
        return maxPassword.getText();
    }

    public boolean isForgotPasswordLinkEnabled() {
        return forgotPasswordLink.isEnabled();
    }

}
