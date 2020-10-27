package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class UserPage extends PageObject {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"sidebar\"]/div/div/div/h6")
    private WebElement loggedUser;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/p")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/app-contacts/div[2]/button\n")
    private WebElement addNewContactButton;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul[1]/li[1]/a")
    private WebElement home;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul[1]/li[2]/a")
    private WebElement account;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul[1]/li[3]/a")
    private WebElement changePassword;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul[1]/li[4]/a")
    private WebElement logout;

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul[2]/li/a")
    private WebElement addNewContact;

    public void logout() {
        clickOnWebElement(logout);
    }

    public void clickChangePassword() {
        clickOnWebElement(changePassword);
    }

//    public String shortPassword() {
//        return minPassword.getText();
//    }
//
//    public String longPassword() {
//        return maxPassword.getText();
//    }


}
