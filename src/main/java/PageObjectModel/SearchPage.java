package PageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BaseClass {
    private WebDriver driver;

    //constructors

    public SearchPage(WebDriver driver){
        this.driver =driver;
    }

    //locators

    private final String hotelLocation ="//select[@id='location']";
    private final String hotelName = "//select[@id='hotels']";
    private final String roomType = "//select[@id='room_type']";
    private final String numberOfRooms = "//select[@id='room_nos']";
    private final String checkInDate = "//input[@id='datepick_in']";
    private final String checkOutDate = "//input[@id='datepick_out']";
    private final String adultsPerRoom = "//select[@id='adult_room']";
    private final String childrenPerRoom = "//select[@id='child_room']";
    private final String search_Button = "//input[@id='Submit']";

    //getters

    public WebElement getHotelLocation(){
        return driver.findElement(By.xpath(hotelLocation));
    }
    public WebElement getHotelName(){
        return driver.findElement(By.xpath(hotelName));
    }
    public WebElement getRoomType(){
        return driver.findElement(By.xpath(roomType));
    }
    public WebElement getNumberOfRooms(){
        return driver.findElement(By.xpath(numberOfRooms));
    }
    public WebElement getCheckInDate(){
        return driver.findElement(By.xpath(checkInDate));
    }
    public WebElement getCheckOutDate(){
        return driver.findElement(By.xpath(checkOutDate));
    }
    public WebElement getAdultsPerRoom(){
        return driver.findElement(By.xpath(adultsPerRoom));
    }
    public WebElement getChildrenPerRoom(){
        return  driver.findElement(By.xpath(childrenPerRoom));
    }
    public WebElement getSearch_Button(){
        return driver.findElement(By.xpath(search_Button));
    }

    //setters

    public void setHotelLocation(String Text){
        selectDropdown(hotelLocation,"index",Text);
    }
    public void setHotelName(String Text){
        selectDropdown(hotelName,"index",Text);
    }
    public void setRoomType(String Text){
        selectDropdown(roomType,"index",Text);
    }

    public void setNumberOfRooms(String Text){
        selectDropdown(numberOfRooms,"index",Text);
    }
    public void setCheckInDate(String Text){
        enterText(checkInDate,Text);
    }
    public void setCheckOutDate(String Text){
        enterText(checkOutDate,Text);
    }

    public void setAdultsPerRoom(String Text){
        selectDropdown(adultsPerRoom,"index",Text);
    }
    public void setChildrenPerRoom(String Text){
        selectDropdown(childrenPerRoom,"index",Text);
    }
    public void setSearch_Button(){
       clickElement(search_Button);
    }
}
