package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class AddNewContact extends PageObject {

    public AddNewContact(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(css = ".btn")
    private WebElement addContactButton;

    @FindBy(xpath = "/html/body/app-root/app-student-edit/div/div/div/div[1]/div")
    private WebElement contactCard;

    public void addContact(String firstName, String lastName, String description) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        descriptionField.sendKeys(description);
        addContactButton.isEnabled();
        addContactButton.click();
    }

    public boolean isAddButtonEnabled() {
        return addContactButton.isEnabled();
    }

    public boolean contactCard() {
        return contactCard.isDisplayed();
    }

}
