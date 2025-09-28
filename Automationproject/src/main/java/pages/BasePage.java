package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * BasePage is the foundation for all Page Objects in the framework.
 * It initializes the WebDriver, WebDriverWait, and shared common methods
 * for interaction and validation.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final Duration TIMEOUT = Duration.ofSeconds(10);

    /**
     * Constructor initializes WebDriver, WebDriverWait, and PageFactory.
     * @param driver The WebDriver instance passed from the test layer.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        // Initialize WebElements defined in the subclass using @FindBy
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for an element to be clickable and clicks it.
     * Provides a safe way to interact with dynamic elements.
     * @param element The WebElement to click.
     */
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Waits for an element to be visible and clickable, clears its current content,
     * and sends the specified text.
     * @param element The WebElement to type into.
     * @param text The String text to send to the element.
     */
    protected void type(WebElement element, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.clear();
        el.sendKeys(text);
    }

    /**
     * Waits for a page title to match the expected title string.
     * @param expectedTitle The expected title of the page.
     * @return true if the title matches within the timeout, false otherwise.
     */
    public boolean verifyPageTitle(String expectedTitle) {
        return wait.until(ExpectedConditions.titleIs(expectedTitle));
    }
}
