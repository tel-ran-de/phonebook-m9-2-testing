package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class LoginPage extends PageObject {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"defaultRegisterFormEmail\"]")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-login/form/div[3]/input")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/app-root/app-login/form/button")
    private WebElement loginBtn;

    @FindBy(xpath = "/html/body/app-root/app-login/form/div[5]/a")
    private WebElement forgotPassword;

    // main page = user page (by documentation)
    public MainPage login(String user, String password) {
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new MainPage(driver);
    }

    public ForgotPasswordPage forgotPass(){
        forgotPassword.click();
        return new ForgotPasswordPage(driver);
    }

}
