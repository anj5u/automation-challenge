package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StudentListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locator
    private By addStudentBtn = By.xpath("//button[contains(text(),'Add Student')]");

    // Constructor
    public StudentListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page validation (optional)
    public boolean isStudentListPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addStudentBtn)).isDisplayed();
    }

    // Action → navigate to AddStudentPage
    public AddStudentPage clickAddStudent() {
        wait.until(ExpectedConditions.elementToBeClickable(addStudentBtn)).click();
        return new AddStudentPage(driver);
    }
}



