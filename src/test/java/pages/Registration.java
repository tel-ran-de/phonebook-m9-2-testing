package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class Registration extends PageObject {

    public Registration(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "empty-email")
    private WebElement emptyEmailField;

    @FindBy(id = "wrong-email")
    private WebElement wrongEmail;

    @FindBy(id = "password")
    private WebElement passField;

    @FindBy(id = "empty-password")
    private WebElement emptyPasswordField;

    @FindBy(id = "minimal-password")
    private WebElement minPassword;

    @FindBy(id = "maximal-password")
    private WebElement maxPassword;

    @FindBy(id = "not-match-password")
    private WebElement passwordsDontMatch;

    @FindBy(id = "confirm-password")
    private WebElement confPassField;

    @FindBy(id = "btn-signup")
    private WebElement signUpBtn;

    @FindBy(id = "btn-login")
    private WebElement loginBtn;

    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[4]")
    private WebElement userExist;

    public void enterData(String email, String pass, String confirmPass) {
        this.emailField.sendKeys(email);
        this.passField.sendKeys(pass);
        this.confPassField.sendKeys(confirmPass);
    }

    public void clickSignUp() {
        clickOnWebElement(signUpBtn);
    }

    public void clickLogin() {
        clickOnWebElement(loginBtn);
    }

    public boolean isLoginBtnEnabled() {
        return loginBtn.isEnabled();
    }

    public boolean isSignUpBtnEnabled() {
        return signUpBtn.isEnabled();
    }

    public String existedUser() {
        return userExist.getText();
    }

    public String passwordShort() {
        return minPassword.getText();
    }

    public String passwordLong() {
        return maxPassword.getText();
    }

    public String passwordsDontMatch() {
        return passwordsDontMatch.getText();
    }

    public String emailEmpty() {
        return emptyEmailField.getText();
    }

    public String passwordEmpty() {
        return emptyPasswordField.getText();
    }

    public String wrongEmail() {
        return wrongEmail.getText();
    }

}
