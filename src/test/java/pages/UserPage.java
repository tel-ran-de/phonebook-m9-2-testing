package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class UserPage extends PageObject {

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Account")
    private WebElement loggedUser;

    @FindBy(linkText = "Home")
    private WebElement home;

    @FindBy(linkText = "Account")
    private WebElement account;

    @FindBy(linkText = "Change password")
    private WebElement changePassword;

    @FindBy(linkText = "Logout")
    private WebElement logout;

    @FindBy(linkText = "Add new Contact")
    private WebElement addNewContactLink;

    @FindBy(css = ".btn")
    private WebElement addNewContactButton;

    public boolean isLoggedUserDisplayed() {
        return loggedUser.isDisplayed();
    }

    public boolean linksAreEnabled() {
        home.isEnabled();
        account.isEnabled();
        changePassword.isEnabled();
        logout.isEnabled();
        addNewContactLink.isEnabled();
        return true;
    }

    public UserPage clickHome() {
        clickOnWebElement(home);
        return new UserPage(driver);
    }

    public void clickChangePassword() {
        clickOnWebElement(changePassword);
    }

    public void logout() {
        clickOnWebElement(logout);
    }

    public void clickAddNewContact() {
        clickOnWebElement(addNewContactLink);
    }

}
