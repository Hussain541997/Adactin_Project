package stepDefinition;

import Baseclass.BaseClass;
import PageObjectModel.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;

public class loginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private SelectPage selectPage;
    private BookAHotel bookAHotel;
    private BookingConfirmation bookingConfirmation;
    private Bookedtinerary bookedtinerary;

    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {
        // Launch browser and open URL
        driver = BaseClass.launchBrowser("chrome");
        BaseClass.openUrl("https://adactinhotelapp.com/HotelAppBuild2/");

        // Initialize Page Object
        loginPage = new LoginPage(driver);
    }

    @When("User enters the login username {string} and password {string}")
    public void user_enters_the_login_username_and_password(String username, String password) {
        loginPage.enterUserName("Hussain54");
        loginPage.enterPassword("Hussain@65");
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User Should be navigated to the Search Hotel page")
    public void user_should_be_navigated_to_the_search_hotel_page() {
        System.out.println("Page Title: " + driver.getTitle());
    }

    @Given("user navigate to search hotel page")
    public void user_navigate_to_search_hotel_page() {
        searchPage =new SearchPage(driver);
    }
    @Then("User select the Hotel")
    public void user_select_the_hotel() {
       searchPage.setHotelLocation("1");
    }
    @Then("User select the type of room and number of rooms")
    public void user_select_the_type_of_room_and_number_of_rooms() {
        searchPage.setNumberOfRooms("2");
        searchPage.setRoomType("2");
    }
    @Then("User choose the check in date and check out date")
    public void user_choose_the_check_in_date_and_check_out_date() {
        searchPage.setCheckInDate("23/07/2025");
        searchPage.setCheckOutDate("25/07/2025");
    }
    @Then("User select the number of adults per room and children per room")
    public void user_select_the_number_of_adults_per_room_and_children_per_room() {
        searchPage.setAdultsPerRoom("2");
        searchPage.setChildrenPerRoom("2");
    }
    @Then("User clicks the search button")
    public void user_clicks_the_search_button() {
       searchPage.setSearch_Button();
    }


    @Given("The user has successfully searched for hotels")
    public void the_user_has_successfully_searched_for_hotels() {
        selectPage =new SelectPage(driver);

    }
    @When("The user selects a hotel from the list")
    public void the_user_selects_a_hotel_from_the_list() {
        selectPage.setSelectHotel();
    }
    @Then("The user clicks on the Continue button")
    public void the_user_clicks_on_the_continue_button() {
        selectPage.setContinueButton();
    }
    @Given("User Navigated to Book A Hotel Website")
    public void user_navigated_to_book_a_hotel_website() {
        bookAHotel =new BookAHotel(driver);
    }

    @When("User enters First And Last Name")
    public void user_enters_first_and_last_name() {
        bookAHotel.setFirstName("Hussaini");
        bookAHotel.setLastName("Mubarak");

    }
    @When("User enters Billing Address")
    public void user_enters_billing_address() {
        bookAHotel.setBillingAddress("paramakudi");
    }
    @When("User enters Credit Card Number")
    public void user_enters_credit_card_number() {
        bookAHotel.setCreditCardNumber("1111111111111111");
    }
    @When("user selects Credit Card Type")
    public void user_selects_credit_card_type() {
       bookAHotel.setCreditCardType("2");
    }
    @When("User Selects Expiry Month and Year")
    public void user_selects_expiry_month_and_year() {
        bookAHotel.setExpiryMonth("1");
        bookAHotel.setExpiryYear("2026");
    }
    @When("User enters CVV Number")
    public void user_enters_cvv_number() {
        bookAHotel.setCvv("123");
    }
    @Then("User clicks BookNow Button")
    public void user_clicks_book_now_button() {
        bookAHotel.setBookNowButton();
    }
    @Given("user navigate to Confirmation Page")
    public void user_navigate_to_confirmation_page()  {
        bookingConfirmation =new BookingConfirmation(driver);
        System.out.println(bookingConfirmation.getText("//td[@class='login_title']"));

    }
    @When("user Clicks My Itinerary")
    public void user_clicks_my_itinerary() {
        bookingConfirmation.setMyItinerary();
    }
    @Then("user navigate to booked Itinerary page")
    public void user_navigate_to_booked_itinerary_page() {
        System.out.println(bookingConfirmation.getTitle());
    }
    @Given("User navigates to Booked Itinerary page")
    public void user_navigates_to_booked_itinerary_page() {
        bookedtinerary = new Bookedtinerary(driver);
        bookedtinerary.getTitle();
    }
    @When("User check the checkbox")
    public void user_check_the_checkbox() {
        bookedtinerary.setOrderId();
    }
    @When("User Cancels the BookedHotels")
    public void user_cancels_the_booked_hotels() {
        bookedtinerary.setCancelSelected();
        bookedtinerary.confirmAlert();
    }
    @Then("User logs out from the application")
    public void user_logs_out_from_the_application() {
        bookedtinerary.setLogoutButton();
    }





}



