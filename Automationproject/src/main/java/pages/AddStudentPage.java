package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddStudentPage extends BasePage {

    // --- Locators for Section 1: Student Details ---
    @FindBy(xpath = "//label[text()='First Name']/following-sibling::input")
    private WebElement firstNameField;

    @FindBy(xpath = "//label[text()='Last Name']/following-sibling::input")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[text()='Email address']/following-sibling::input")
    private WebElement emailField;

    @FindBy(xpath = "//label[text()='Phone Number']/following-sibling::input")
    private WebElement phoneField;

    @FindBy(xpath = "//span[contains(text(), 'SMS Capable')]/preceding-sibling::input[@type='checkbox']")
    private WebElement smsCapableCheckbox;

    // --- Student Type & Family ---
    @FindBy(xpath = "//span[contains(text(), 'Child')]/preceding-sibling::input[@type='radio']")
    private WebElement childTypeRadio;

    @FindBy(xpath = "//span[contains(text(), 'Adult')]/preceding-sibling::input[@type='radio']")
    private WebElement adultTypeRadio;

    @FindBy(xpath = "//span[contains(text(), 'New Family')]/preceding-sibling::input[@type='radio']")
    private WebElement newFamilyRadio;

    @FindBy(xpath = "//span[contains(text(), 'Existing Family')]/preceding-sibling::input[@type='radio']")
    private WebElement existingFamilyRadio;

    // --- Conditional Parent Fields ---
    @FindBy(xpath = "//label[text()='Parent First Name']/following-sibling::input")
    private WebElement parentFirstNameField;

    @FindBy(xpath = "//label[text()='Parent Last Name']/following-sibling::input")
    private WebElement parentLastNameField;

    @FindBy(xpath = "//label[text()='Email Address']/following-sibling::input")
    private WebElement parentEmailField;

    // --- Additional Details ---
    @FindBy(xpath = "//span[contains(text(), 'Show additional details')]/parent::a")
    private WebElement showAdditionalDetailsLink;

    @FindBy(id = "skillLevel")
    private WebElement skillLevelDropdown;

    @FindBy(id = "instrument")
    private WebElement instrumentDropdown;

    // --- Final Action Button ---
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    private WebElement saveButton;

    // --- Constructor ---
    public AddStudentPage(WebDriver driver) {
        super(driver);
    }

    // --- Private helper for dynamic status radio buttons ---
    private By getStatusRadioLocator(String status) {
        return By.xpath("//span[text()='" + status + "']/preceding-sibling::input[@type='radio']");
    }

    // --- Actions ---
    public void enterBasicInfo(String firstName, String lastName, String email, String phone) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        type(phoneField, phone);
    }

    public void toggleSmsCapable(boolean checked) {
        if (checked != smsCapableCheckbox.isSelected()) {
            click(smsCapableCheckbox);
        }
    }

    public void selectStatus(String status) {
        WebElement statusRadio = driver.findElement(getStatusRadioLocator(status));
        click(statusRadio);
    }

    public void chooseTypeChildWithNewFamily(String parentFirstName, String parentLastName, String parentEmail) {
        click(childTypeRadio);
        click(newFamilyRadio);
        type(parentFirstNameField, parentFirstName);
        type(parentLastNameField, parentLastName);
        type(parentEmailField, parentEmail);
    }

    public void expandAdditionalDetailsAndSelect(String skillLevel, String instrument) {
        click(showAdditionalDetailsLink);
        selectDropdownOption(skillLevelDropdown, skillLevel);
        selectDropdownOption(instrumentDropdown, instrument);
    }

    private void selectDropdownOption(WebElement dropdownElement, String optionText) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionText);
    }

    public BillingSetupPage clickSave() {
        click(saveButton);
        return new BillingSetupPage(driver);
    }

	public BillingSetupPage clickNext() {
		// TODO Auto-generated method stub
		return null;
	}
}
