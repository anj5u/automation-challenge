    
package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By addStudentBtn = By.className("base-200.mb-3.ng-star-inserted"); // corrected className syntax
    private By welcomeMessage = By.xpath("//h3[@class='base-200 mb-3 ng-star-inserted']"); // for validation

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page validation
    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)).isDisplayed();
    }

    // Click Add Student → navigates to AddStudentPage
    public AddStudentPage clickAddStudent() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addStudentBtn));
        addBtn.click();
        return new AddStudentPage(driver);
    }
}
