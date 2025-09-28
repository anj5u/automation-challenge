	    package pages;
	    import org.openqa.selenium.WebDriver;
	    import org.openqa.selenium.WebElement;
	    import org.openqa.selenium.support.FindBy;

	    /**
	     * Page Object for the Billing Setup Page (Step 2/2 of enrollment).
	     * This page is responsible for handling automatic invoicing configuration or skipping it.
	     */
	    public class BillingSetupPage extends BasePage {

	        // --- Locators for Automatic Invoicing Decision ---
	        // Assuming 'No' is the option to skip and leads to the final confirmation/student details page.
	        @FindBy(xpath = "//span[contains(text(), 'Setup later through Family Account')]/preceding-sibling::input[@type='radio']")
	        private WebElement setupLaterRadio;
	        
	        // Assuming the final action button is consistently labeled "Finish" or "Save" on this page.
	        @FindBy(xpath = "//button[contains(text(), 'Finish') or contains(text(), 'Save')]")
	        private WebElement finishBtn;
	        
	        // Placeholder for a key element to confirm we are on the page
	        @FindBy(xpath = "//h1[contains(text(), 'automatic invoicing')]")
	        private WebElement automaticInvoicingHeader;


	        /**
	         * Constructor initializes WebDriver and inherited BasePage properties.
	         * @param driver The WebDriver instance passed from the test layer.
	         */
	        public BillingSetupPage(WebDriver driver) {
	            super(driver);
	        }
	        
	        /**
	         * Verifies that the Billing Setup Page is displayed by checking a key element.
	         * @return true if the header is visible.
	         */
	        public boolean isBillingPageDisplayed() {
	            return automaticInvoicingHeader.isDisplayed();
	        }


	        /**
	         * Selects the 'Setup later' option and clicks the Finish button.
	         * @return StudentDetailsPage, which is the final destination after onboarding.
	         */
	        public  skipBillingSetup() {
	            // 1. Select 'No' / 'Setup later' radio button
	            click(setupLaterRadio);
	            
	            // 2. Click the Finish button
	            click(finishBtn);
	            
	            // The action leads to the final Student Details page
	            return new (driver);
	        }
	    }
