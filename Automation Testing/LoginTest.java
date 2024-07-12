package learningSelenium;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginTest 
{

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() 
    {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testffc.nimapinfotech.com/");
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() 
    {
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @When("the user clicks the PunchIn button")
    public void the_user_clicks_the_punchin_button() 
    {
        WebElement punchInButton = driver.findElement(By.id("punchInButton"));
        punchInButton.click();
    }

    @Then("the toast message should display {string}")
    public void the_toast_message_should_display(String expectedMessage) 
    {
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));
        Assert.assertEquals(toastMessage.getText(), expectedMessage);
    }

    @Given("the user is on the dashboard")
    public void the_user_is_on_the_dashboard() {
        the_user_is_on_the_login_page();
        the_user_enters_username_and_password("validUser", "validPass");
        the_user_clicks_the_login_button();
        the_user_should_be_redirected_to_the_dashboard();
    }

    @When("the user navigates to add customer page")
    public void the_user_navigates_to_add_customer_page() {
        WebElement addCustomerLink = driver.findElement(By.id("addCustomerLink"));
        addCustomerLink.click();
    }

    @When("the user enters customer name {string} and details {string}")
    public void the_user_enters_customer_name_and_details(String customerName, String customerDetails) {
        WebElement customerNameField = driver.findElement(By.id("customerName"));
        WebElement customerDetailsField = driver.findElement(By.id("customerDetails"));
        customerNameField.sendKeys(customerName);
        customerDetailsField.sendKeys(customerDetails);
    }

    @When("the user clicks the add customer button")
    public void the_user_clicks_the_add_customer_button() {
        WebElement addCustomerButton = driver.findElement(By.id("addCustomerButton"));
        addCustomerButton.click();
    }

    @Then("the customer should be added successfully with message {string}")
    public void the_customer_should_be_added_successfully_with_message(String expectedMessage) {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-message")));
        Assert.assertEquals(successMessage.getText(), expectedMessage);
        driver.quit();
    }
}
