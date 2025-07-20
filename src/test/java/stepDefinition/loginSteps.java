package stepDefinition;

import Baseclass.baseclass;
import PageObjectModel.login_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class loginSteps extends baseclass {
    private WebDriver driver;
    private login_page loginPage;


    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {

        // Use BaseClass's static driver getter
        this.driver =baseclass.getDriver();
        //initialize Page Object With driver
        loginPage =new login_page(driver);
        //launch browser
        driver = launchBrowser("edge");
        //url launch
        openUrl("https://adactin.com/HotelApp/index.php");
    }
    @When("User enters the login username {string} and password {string}")
    public void user_enters_the_login_username_and_password(String string, String string2) {
        //user id and password
        loginPage.enterUserName("Hussain54");
        loginPage.enterPassword("Hussain@65");
    }
    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("User Should be navigated to the Search Hotel page")
    public void user_should_be_navigated_to_the_search_hotel_page() {
        System.out.println(driver.getTitle());
    }
}
