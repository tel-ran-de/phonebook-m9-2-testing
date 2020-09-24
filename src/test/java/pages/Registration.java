package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class Registration extends PageObject {

    public Registration(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//*[@id=\"defaultRegisterFormEmail\"]")
//    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[2]/input")
//    @FindBy(id = "defaultRegisterFormPass")
    private WebElement passField;

    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[3]/input")
//    @FindBy(id = "defaultRegisterFormConfPass")
    private WebElement confPassField;

    @FindBy(xpath = "/html/body/app-root/app-registration/form/button")
//    @FindBy(id = "btnSignup")
    private WebElement signUpBtn;

    @FindBy(xpath = "/html/body/app-root/app-registration/form/a")
//    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    // TODO: find a path after fixing a bug (Vadik).user already exists
    @FindBy(xpath = "/html/body/app-root/app-registration/form/div[4]/div")
    private WebElement errorMessage;

    public void enterData(String email, String pass, String confirmPass) {
        this.emailField.sendKeys(email);
        this.passField.sendKeys(pass);
        this.confPassField.sendKeys(confirmPass);
    }

    public Registration register(String user, String password, String confPassword){
        emailField.sendKeys(user);
        passField.sendKeys(password);
        confPassField.sendKeys(confPassword);
        signUpBtn.click();
        return null;
    }

    public boolean isSignUpBtnEnabled() {
        return signUpBtn.isEnabled();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void clickSignUp() {
        signUpBtn.click();
    }

}
