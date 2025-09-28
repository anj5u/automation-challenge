package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

import static org.testng.Assert.assertTrue;

public class AddStudentBasicTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AddStudentPage addStudentPage;
    private BillingSetupPage billingSetupPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.mymusicstaff.com");
    }

    @Test
    public void testAddNewStudentAsChild() {
        // Login → returns DashboardPage
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login("anjuvasudev103@gmail.com", "12345abC@");
        assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not displayed!");

        // Dashboard → AddStudentPage
        addStudentPage = dashboardPage.clickAddStudent();

        // Fill student details
        addStudentPage.enterBasicInfo("Test", "Child", "child.test@example.com", "1234567890");
        addStudentPage.selectStatus("Active");
        addStudentPage.chooseTypeChildWithNewFamily("Parent", "Test", "parent.test@example.com");
        addStudentPage.expandAdditionalDetailsAndSelect("Beginner", "Piano");

        // Proceed to billing setup → returns BillingSetupPage
        billingSetupPage = addStudentPage.clickSave();

        // Skip billing setup
        billingSetupPage.skipBillingSetup();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
