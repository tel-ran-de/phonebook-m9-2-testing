package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class Login extends PageObject {

    public Login(WebDriver driver) { super(driver);
    }

    @FindBy(xpath = "//*[@id=\"defaultRegisterFormEmail\"]")
//    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-login/form/div[2]/input")
//    @FindBy(id = "defaultRegisterFormPass")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/app-root/app-login/form/button")
//    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/app-root/app-login/form/div[5]/a")
    private WebElement forgotPasswordLink;

    // main page = user page (by documentation)

    public void enterDataToLogin(String email, String pass) {
        this.emailField.sendKeys(email);
        this.passwordField.sendKeys(pass);
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public MainPage login(String user, String password) {
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }

    public ForgotPassword forgotPass(){
        forgotPasswordLink.click();
        return new ForgotPassword(driver);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isForgotPassLinkEnabled() {
        return forgotPasswordLink.isEnabled();
    }

}
