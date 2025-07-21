package PageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingConfirmation extends BaseClass {
    private WebDriver driver;
    //constructor
    public BookingConfirmation(WebDriver driver){
        this.driver = driver;
    }

    //locator
    private final String myItinerary = "//input[@name='my_itinerary']";


    //getter
    public WebElement getMyItinerary(){
        return driver.findElement(By.xpath(myItinerary));
    }

    //setter
    public void setMyItinerary(){
        waitForVisibility(myItinerary,10);
        clickElement(myItinerary);
    }
}
