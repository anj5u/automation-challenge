package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object representing the Login Page.
 * Extends BasePage to reuse common methods like click() and type().
 */
public class LoginPage extends BasePage {

    // --- Locators using PageFactory ---
    @FindBy(id = "MainContent_contentBody_textboxEmail")
    private WebElement emailInput;

    @FindBy(id = "MainContent_contentBody_textboxPassword")
    private WebElement passwordInput;

    @FindBy(id = "MainContent_contentBody_buttonLogin")
    private WebElement loginBtn;

    // --- Constructor ---
    public LoginPage(WebDriver driver) {
        super(driver); // Calls BasePage constructor to initialize driver and wait
    }

    // --- Page Validation ---
    /**
     * Checks if the login page is displayed by waiting for the email input field.
     * @return true if email input is visible, false otherwise
     */
    public boolean isLoginPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailInput)).isDisplayed();
    }

    // --- Actions ---
    /**
     * Enters the email using BasePage type() method.
     * @param email User email
     */
    public void enterEmail(String email) {
        type(emailInput, email);
    }

    /**
     * Enters the password using BasePage type() method.
     * @param password User password
     */
    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    /**
     * Clicks the login button using BasePage click() method.
     */
    public void clickLogin() {
        click(loginBtn);
    }

    // --- Combined Login Method ---
    /**
     * Performs login action and returns DashboardPage.
     * @param email User email
     * @param password User password
     * @return DashboardPage object after successful login
     */
    public DashboardPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        // Optionally, you can add wait here for dashboard to load
        return new DashboardPage(driver);
    }
}
